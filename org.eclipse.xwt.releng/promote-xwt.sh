directory="`date +%d-%m-%y-%H-%M`"
mv /home/data/httpd/download.eclipse.org/xwt/updates /home/data/httpd/archive.eclipse.org/xwt/updates/$directory

rm /home/data/users/ekaraca/promote/temp/site.p2.zip
rm -rf /home/data/users/ekaraca/promote/temp/site.p2

cd /home/data/users/ekaraca/promote/temp
wget --no-check-certificate "https://hudson.eclipse.org/hudson/job/xwt-1.0-kepler/lastSuccessfulBuild/artifact/site.p2.zip"

#...
# sign our zip
#...

unzip site.p2.zip
rm -rf /home/data/httpd/download.eclipse.org/xwt/updates/
mkdir /home/data/httpd/download.eclipse.org/xwt/updates/
cp -r /home/data/users/ekaraca/promote/temp/site.p2/* /home/data/httpd/download.eclipse.org/xwt/updates/
