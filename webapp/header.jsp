<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="content-type" content="text/html;charset=ISO-8859-1" />
<meta name="description" content="GUJ - O portal de desenvolvedores do Brasil">

<meta property="og:title" content="GUJ - O portal de desenvolvedores do Brasil">
<meta property="og:site_name" content="guj.com.br">
<meta property="og:url" content="http://www.guj.com.br">
<meta property="og:type" content="forum">
<meta property="og:image" content="<c:url value="/imgs/guj-logo.png"/>">

<c:if test="${empty rmSection}">
	<c:set var="rmSection" value="guj/internas"/>
</c:if>

<c:if test="${empty title}">
	<c:set var="title">O portal de desenvolvedores do Brasil</c:set>
</c:if>

<title>GUJ - ${title}</title>
<link href="<c:url value="/stylesheets/guj3.css?20130424"/>" media="screen" rel="stylesheet" type="text/css" />

<script type="text/javascript">var p="http",d="static";if(document.location.protocol=="https:"){p+="s";d="engine";}var z=document.createElement("script");z.type="text/javascript";z.async=true;z.src=p+"://"+d+".adzerk.net/ados.js";var s=document.getElementsByTagName("script")[0];s.parentNode.insertBefore(z,s);</script>
<script type="text/javascript">
	var ados = ados || {};
	ados.run = ados.run || [];
	ados.run.push(function() {
		/* load placement for account: caelum, site: guj, size: 728x90 - Leaderboard*/
		ados_add_placement(7120, 49043, "headerBanner", 4);
		/* load placement for account: caelum, site: guj, size: 728x90 - Leaderboard*/
		ados_add_placement(7120, 49043, "postBanner", 4);
		/* load placement for account: caelum, site: guj, size: 300x250 - Medium Rectangle*/
		ados_add_placement(7120, 49043, "medRectangleAd", 5);
		// para o futuro:
		//ados_setKeywords('java, hibernate, jsf'); 
		ados_load();
	});
</script>

<!--[if IE]>
<link href="<c:url value="/stylesheets/guj3-ie.css?20090222"/>" media="screen" rel="stylesheet" type="text/css" />
<![endif]-->
<script type="text/javascript" src="<c:url value="/javascripts/jquery-1.3.1.min.js?20090222"/>"></script>
<script type="text/javascript" src="<c:url value="/javascripts/jquery.dimensions.min.js?20090222"/>"></script>
<script type="text/javascript">
$().ready(function() {
	$("#returnPath").val(document.location);
});
</script>
</head>

<body>
  <div id="header">
    <div class="container1">
    	<div id="headerBanner"></div>
      <div class="container2">
        <a href="<c:url value="/"/>" id="logo" data-slogan="${title}">GUJ</a>
      </div>
    </div>
  </div>