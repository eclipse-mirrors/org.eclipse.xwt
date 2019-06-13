#!/bin/bash
########### Requirements ###########
#You will need to have the 'ssh agent' plugin installed on your instance and configure the credentials for ssh access
#You can find the needed informations here: https://wiki.eclipse.org/Jenkins#How_do_I_deploy_artifacts_to_download.eclipse.org.3F
####################################
sshGenie="genie.xwt"
sshRemote="projects-storage.eclipse.org"
alias ll="ls -la"


########### Parameters Initialization ###########
if ! $PUBLISH ; then
  exit 0 # nothing to do here
fi 

if ! $SIGN ; then
  echo "The sources may not have been signed. Please verify the build and artifacts parameters and try again."
  exit 1
fi

#The specific localization
remoteRoot="/home/data/httpd/download.eclipse.org"
xwtRoot="xwt"

if [[ "$MILESTONE" == "-R" ]] ; then
  destination=$remoteRoot/$xwtRoot/release-$RELEASE_NUMBER
  destinationUpdateSite=$destination
else
  destination=$remoteRoot/$xwtRoot/milestones-$RELEASE_NUMBER
  destinationUpdateSite=$destination/$RELEASE_NUMBER$MILESTONE
fi
echo $destinationUpdateSite

#jobArtifacts=$HOME/.jenkins/jobs/$PROMOTED_JOB_NAME/builds/$PROMOTED_NUMBER/archive
jobArtifacts=$HOME/workspace/$JOB_NAME/
if [ ! -d $jobArtifacts ] ; then
  echo "No artifact folder was found under the specified $jobArtifacts path"
  exit 1
fi

echo "$jobArtifacts contains the following :"
ls $jobArtifacts

if ssh $sshGenie@$sshRemote [ -d $destination ] ; then
  if ssh $sshGenie@$sshRemote [ -d $destinationUpdateSite ] ; then
    if $OVERRIDE ; then
      echo "Removing previous artifacts"
      ssh $sshGenie@$sshRemote rm -rf $destinationUpdateSite
    else
      echo "The milestone already exists. You might want to change the suffix or delete the previous one."
      exit 1
    fi
  fi
fi


########### Publish Artifacts ###########
#Go to the artifact directory
cd $jobArtifacts

# Check the availability of the artifacts to promote before creating anything
if [ ! -f xwt-archived-p2-site.zip ] ; then
  echo "There is no xwt-archived-p2-site.zip here."
  pwd
  ls
  exit 1
fi
if [ ! -d repository ] ; then
  echo "There is no repository directory here."
  pwd
  ls
  exit 1
fi

echo "Promoting the Job to $destinationUpdateSite"

#No error if exists, makes parent directories as needed
echo "creating $destinationUpdateSite"
ssh $sshGenie@$sshRemote mkdir -p $destinationUpdateSite

if ssh $sshGenie@$sshRemote [ ! -d $destinationUpdateSite ] ; then
  echo "The destination folder could not be created. Please look why in the logs."
  exit 1
fi

#Copy the contents onto the server folder
echo "copying the zip into $destinationUpdateSite"
scp xwt-archived-p2-site.zip $sshGenie@$sshRemote:$destinationUpdateSite

echo "copying the p2 repository folder into $destinationUpdateSite"
scp -r repository/* $sshGenie@$sshRemote:$destinationUpdateSite


########### Create Index File ###########
function createIndexFile() {
echo '
<!DOCTYPE html>
<html>
<head>
  <title>XWT Update Site (Incubation)</title>
</head>

<body style="font-family:Arial; font-size:small;">
<h1>XWT Update Site (Incubation)</h1>
<p>
<em>For information about XWT, visit its <a href="http://www.eclipse.org/xwt">homepage</a> or <a
href="http://wiki.eclipse.org/XWT">wiki</a>.
         <br> For information about installing or updating Eclipse software, see the
         <a href="http://help.eclipse.org/helios/index.jsp?topic=/org.eclipse.platform.doc.user/tasks/tasks-124.htm">
           Eclipse Platform Help</a>.
</p>
<h3>Contents</h3>
<ul>
<li><a href="#">...</a></li>
</ul>
<p>
<a href="xwt-archived-p2-site.zip">Download the zipped XWT p2 site</a>
</p>
</body>
</html>
' | ssh $sshGenie@$sshRemote -T "cat > $1/index.html"
}
echo "Create index.html file for the new repository"
createIndexFile $destinationUpdateSite


########### Set Access Rights ###########
# This function sets the acess rights to allow all memebers of the group to edit the files
function setAccessRights() {
	ssh $sshGenie@$sshRemote chmod -R 775 "$1"
	ssh $sshGenie@$sshRemote chgrp -hR technology.xwt "$1"
}
echo "Set access right -R: $destinationUpdateSite"
setAccessRights $destinationUpdateSite


echo "publishing done."

