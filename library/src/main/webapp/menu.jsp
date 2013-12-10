<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>
  <head>
    <sj:head jqueryui="true"/>
  </head>
  <body>
    <sj:menu id="menuWithItems" cssStyle="width:50%" >
        <sj:menuItem title="Struts2" href="http://struts.apache.org/2.x/index.html"/>
        <sj:menuItem title="Struts2 jQuery News" menuIcon="ui-icon-extlink" href="http://www.jgeppert.com/category/java/struts2-jquery/"/>
        <sj:menuItem title="Struts2 Plugins">
            <sj:menu id="subMenuPlugins" cssStyle="width:50%">
                <sj:menuItem title="Struts2 Plugins" href="https://cwiki.apache.org/S2PLUGINS/home.html"/>
                <sj:menuItem title="Struts2 jQuery Plugin" href="http://code.google.com/p/struts2-jquery/"/>
                <sj:menuItem title="Struts2 Bootstrap Plugin" href="http://code.google.com/p/struts2-jquery/"/>
            </sj:menu>
        </sj:menuItem>

        <sj:menuItem title="Struts2 @ Social Media">
            <sj:menu id="subMenuSocialMedia" cssStyle="width:50%">
                <sj:menuItem title="Struts2 @ Twitter" href="https://twitter.com/TheApacheStruts"/>
                <sj:menuItem title="Struts2 @ Google+" href="https://www.google.com/+ApacheStruts"/>
                <sj:menuItem title="Struts2 @ Facebook" href="http://www.facebook.com/struts2"/>
            </sj:menu>
        </sj:menuItem>

        <sj:menuItem title="AJAX">
            <sj:menu id="subMenuAjax" cssStyle="width:50%">
                <s:url var="ajax1" value="/ajax1.action"/>
                <sj:menuItem title="Ajax 1" href="%{ajax1}" targets="result"/>
                <s:url var="ajax2" value="/ajax2.action"/>
                <sj:menuItem title="Ajax 2" href="%{ajax2}" targets="result" effect="highlight" effectDuration="2500"/>
                <s:url var="ajax3" value="/ajax3.action"/>
                <sj:menuItem title="Ajax 3" href="%{ajax3}" targets="result" onBeforeTopics="beforeLink"
                             onCompleteTopics="completeLink"/>
                <s:url var="ajax4" value="/ajax4.action"/>
                <sj:menuItem title="Ajax 4" href="%{ajax4}" menuIcon="ui-icon-gear" targets="result" effect="bounce" effectDuration="1000"/>
            </sj:menu>
        </sj:menuItem>
    </sj:menu>
  </body>
</html>