#!/bin/bash -x

#The specific localization
remoteRoot="/home/data/httpd/download.eclipse.org"
xwtRoot="xwt"


########### Parameters Initialization ###########
if [[ "$MILESTONE" == "-R" ]] ; then
  destination=$remoteRoot/$xwtRoot/release-$RELEASE_NUMBER
  destinationUpdateSite=$destination
else
  destination=$remoteRoot/$xwtRoot/milestones-$RELEASE_NUMBER
  destinationUpdateSite=$destination/$RELEASE_NUMBER$MILESTONE
fi
#echo $destinationUpdateSite

jobArtifacts=$HOME/.jenkins/jobs/$PROMOTED_JOB_NAME/builds/$PROMOTED_NUMBER/archive
#echo $jobArtifacts
#ls $jobArtifacts

if $SIGN ; then
  :
else
  echo "The sources may not have been signed. Please verify the build and artifacts parameters and try again."
  exit 1
fi

if [ -d $destination ] ; then
  if [ -d $destinationUpdateSite ] ; then
    if $OVERRIDE ; then
      echo "Removing previous artifacts"
      rm -rf $destinationUpdateSite
    else
      echo "The milestone already exists. You might want to change the suffix or delete the previous one."
      exit 1
    fi
  fi
fi


########### Publish Artifacts ###########
#Go to the artifact directory
cd $jobArtifacts
echo "Promoting the Job to $destinationUpdateSite"
#No error if exists, makes parent directories as needed
mkdir -p $destinationUpdateSite

#Copy the contents onto the server folder
cp -a *.zip $destinationUpdateSite
cp -a repository/* $destinationUpdateSite


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
' > $1/index.html
}
echo "Create index.html file for the new repository"
cerateIndexFile $destinationUpdateSite


########### Set Access Rights ###########
# This function sets the acess rights to allow all memebers of the group to edit the files
function setAccessRights() {
	chmod -R 775 "$1"
	chgrp -hR technology.xwt "$1"
}
echo "Set access right -R: $destinationUpdateSite"
setAccessRights $destinationUpdateSite


echo "publishing done."
