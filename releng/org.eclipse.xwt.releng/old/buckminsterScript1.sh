echo "<?xml version='1.0' encoding='UTF-8'?>
<rm:rmap xmlns:bc='http://www.eclipse.org/buckminster/Common-1.0'
	xmlns:rm='http://www.eclipse.org/buckminster/RMap-1.0'>

        <rm:locator pattern='^org\.eclipse\.license.*' searchPathRef='license-source-code'/>
	<rm:locator pattern='^org\.eclipse\.xwt.*$' searchPathRef='xwt-workspace' />
	<rm:locator pattern='^org\.pushingpixels\.trident$' searchPathRef='orbit-2016-05-20' />
	<rm:locator pattern='.*' searchPathRef='kepler-release' />
	
	<rm:searchPath name='xwt-git'>
		<rm:provider componentTypes='eclipse.feature,osgi.bundle,buckminster'
			readerType='git' mutable='true' source='true'>
			<rm:property key='git.remote.uri'
				value='git://git.eclipse.org/gitroot/xwt/org.eclipse.xwt.git' />
			<rm:property key='git.remote.name' value='master' />
			<rm:uri format='{0}/org.eclipse.xwt.git,{1}'>
				<bc:propertyRef key='workspace.root' />
				<bc:propertyRef key='buckminster.component' />
			</rm:uri>
		</rm:provider>
	</rm:searchPath>

	<rm:searchPath name='orbit-2016-05-20'>
		<rm:provider componentTypes='eclipse.feature,osgi.bundle,buckminster'
			readerType='p2' mutable='false' source='false'>
			<rm:uri format='http://download.eclipse.org/tools/orbit/downloads/drops/R20160520211859/repository/'>
			</rm:uri>
		</rm:provider>
	</rm:searchPath>
	
	<rm:searchPath name='xwt-workspace'>
		<rm:provider componentTypes='eclipse.feature,osgi.bundle,buckminster'
			readerType='local'>
			<rm:uri format='{0}/{1}'>
				<bc:propertyRef key='workspace.root' />
				<bc:propertyRef key='buckminster.component' />
			</rm:uri>
		</rm:provider>
	</rm:searchPath>
	<rm:searchPath name='cbi-workspace'>
		<rm:provider componentTypes='eclipse.feature,osgi.bundle,buckminster'
			readerType='local'>
			<rm:uri format='{0}/cbi/{1}'>
				<bc:propertyRef key='workspace.root' />
				<bc:propertyRef key='buckminster.component' />
			</rm:uri>
		</rm:provider>
	</rm:searchPath>
	
	<rm:searchPath name='kepler-release'>
		<rm:provider componentTypes='eclipse.feature,osgi.bundle,buckminster'
			readerType='p2' mutable='false' source='false'>
			<rm:uri format='http://download.eclipse.org/releases/kepler'>
			</rm:uri>
		</rm:provider>
	</rm:searchPath>

	<rm:searchPath name='mars-release'>
		<rm:provider componentTypes='eclipse.feature,osgi.bundle,buckminster'
			readerType='p2' mutable='false' source='false'>
			<rm:uri format='http://download.eclipse.org/releases/mars'>
			</rm:uri>
		</rm:provider>
	</rm:searchPath>

<rm:searchPath name='license-source-code'>
<rm:provider componentTypes='eclipse.feature' readerType='git'>
<rm:property key='git.remote.uri' value='/gitroot/cbi/org.eclipse.license.git'/>
<rm:property key='git.auto.fetch' value='true'/>
<rm:property key='git.license.local.repository.location' value='${WORKSPACE}/org.eclipse.license'/>
<rm:uri format='{0},{1}'>
<bc:propertyRef key='git.license.local.repository.location'/>
<bc:propertyRef key='buckminster.component'/>
</rm:uri>
</rm:provider>
</rm:searchPath>

</rm:rmap>" > org.eclipse.xwt.releng/build.rmap

echo "<?xml version='1.0' encoding='UTF-8'?><cq:componentQuery xmlns:cq='http://www.eclipse.org/buckminster/CQuery-1.0' resourceMap='build.rmap'>
    <cq:rootRequest name='org.eclipse.xwt.releng' componentType='eclipse.feature'/>
</cq:componentQuery>" > org.eclipse.xwt.releng/build.cquery


echo "<?xml version='1.0' encoding='UTF-8'?>
<mspec:mspec xmlns:mspec='http://www.eclipse.org/buckminster/MetaData-1.0' installLocation='' materializer='p2' name='build.mspec' url='build.cquery'>
  <mspec:mspecNode materializer='workspace' filter='(buckminster.source=true)'/>
</mspec:mspec>" > org.eclipse.xwt.releng/build.mspec

echo "<?xml version='1.0' encoding='UTF-8'?>
<cs:cspecExtension xmlns:cs='http://www.eclipse.org/buckminster/CSpec-1.0'>
	<cs:dependencies>
		<cs:dependency name='org.eclipse.rcp' componentType='eclipse.feature'/>
                <cs:dependency name='org.eclipse.xwt.feature' componentType='eclipse.feature'/>
	</cs:dependencies>
</cs:cspecExtension>" > org.eclipse.xwt.releng/buckminster.cspex

