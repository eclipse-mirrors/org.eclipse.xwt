echo zipping generated p2 site
mv -f buckminster.output/org.eclipse.xwt.releng_1.0.0-eclipse.feature/site.p2 .
zip -r site.p2.zip site.p2
