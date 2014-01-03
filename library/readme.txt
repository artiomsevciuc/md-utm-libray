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

Apache ant config, for easier copy of the jsp,css,image folder without building entire project
1. Create an external file ant.properties in the same directory as the project
That is made for not to commit that file
2. Add tomcatPath property, should look like this:
tomcatPath=/home/userName/Java/apache-tomcat-7.0.47/webapps/library