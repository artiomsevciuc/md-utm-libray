Add to the settings.xml
1. Between <profiles> tags add 
	<profile>
        <id>tomcatProfile</id>
		<properties>
			<tomcatPath>../apache-tomcat-7.0.47/webapps</tomcatPath><!-- Path to your apache tomcat application -->
		</properties>
	</profile>
2. Between <activeProfiles> tags add:
	<activeProfile>tomcatProfile</activeProfile>
3. Deploying application is made from console using following command:
	mvn exec:exec