
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%-- <%@ page import="googleAPI.*"%> --%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width = device-width, initial-scale = 1">
<title>Logophilia</title>

<!-- IMAGE FIT STYLE CSS -->
<style>


  @import url("//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css");

/* html, body { */
/*     height: 100%; */
/* } */
/* body {     */
/*     padding-top: 75px; */
/* } */
body.navbar-more-show  {
	overflow: hidden;
}



.dropdown-backdrop {
    position: static;
    background-color: #FFFFFF;
}

.animate {
    -webkit-transition: all 0.3s ease-in-out;
	-moz-transition: all 0.3s ease-in-out;
	-o-transition: all 0.3s ease-in-out;
	-ms-transition: all 0.3s ease-in-out;
	transition: all 0.3s ease-in-out;
}
.navbar {

    height: calc(100%); 
 	max-height: 100px; 
	-webkit-transform: translate(0px, calc(-100% + 69px));
	transform: translate(0px, calc(-100% + 69px));
}
.navbar .container:not(.navbar-more) {
    padding: 0px;
}
.navbar-more-overlay {

	background-color: #FFFFFF;
	display: none;
/* 	height: 100%; */
	left: 0px;
	position: fixed;
	top: 0px;
/* 	width: 95%; */
	z-index: 1029;
}
.navbar-more-show > .navbar-more-overlay {
	display: block;
}
.navbar-more-show > .navbar {
	-webkit-transform: translate(0px, 0px);
	transform: translate(0px, 0px);
}
.navbar-nav.mobile-bar {
	list-style: none;
	-ms-box-orient: horizontal;
	display: -webkit-box;
	display: -moz-box;
	display: -ms-flexbox;
	display: -moz-flex;
	display: -webkit-flex;
	display: flex;
	-webkit-justify-content: space-around;
	justify-content: space-around;
	-webkit-flex-flow: row wrap;
	flex-flow: row wrap;
	-webkit-align-items: stretch;
	align-items: stretch;
	margin: 0px 0px;
}
.navbar-nav.mobile-bar > li {
	-webkit-flex-grow: 1;
	flex-grow: 1;
	text-align: center;
}
.navbar-nav.mobile-bar > li > a > span.menu-icon {
	display: block;
	font-size: 1.8em;
}
.navbar-more {
	background-color: rgb(255, 255, 255);
/* 	height: calc(100% - 69px); */
/* 	overflow: auto; */
	height: 51px;
		border-bottom: 0.05em solid #e3e0e0; 
/* 		border-bottom: 1px solid black; */
}
.navbar-more .navbar-form {
	border-width: 0px;
}
.navbar-more .navbar-nav > li > a {
    color: rgb(64, 64, 64);   
}
.navbar-more > .navbar-nav > li > a > span.menu-icon {
	margin-left: 10px;
	margin-right: 10px;
}

img.lists{
   height:20px;

}

.navbar-custom {
	
     background-color:#ffffff; 
      color:#ffffff;  
/*      background-color:blue;  */
/*     color:blue; */
    border-radius:0;
/* 	border-bottom: 0.05em solid #e3e0e0; */
		border-bottom: 1px solid black;
	
}
img.resizeUserShard2{
/*    height:34px; */
/*    height:50px; */
/*    width:50px; */
   height:35px;
   width:35px;
       margin-right: auto;
     margin-left: 10px; 
     margin-bottom: -10px; 
     margin-top: -10px;
/*    display: block; */
/*     margin-left: auto; */
/*     margin-right: auto; */
/*      margin-left: 10px;  */
/*      margin-bottom: -10px;  */
/*      margin-top: -10px; */
/* margin-bottom: -10px; */
/*     margin-bottom: 3px; */
   
   
/*    height:40px; */
}
img.resizeUserShard2mobile{

   height:35px;
/*    width:25px; */
       margin-right: auto;
     margin-left: 10px; 
/*      margin-bottom: -10px;  */
     margin-top: -10px;
     padding-top: 10px;

}


.fa{
color: black;
}

img.listsLogout{
   max-height:35px;

}


@media (min-width: 768px) {
/* div.navbar-more { */
/* display: none; */

/* margin-top: -20px; */
/* } */
/* div.navbar-more .navbar-form { */
/* display: none; */
/* margin-top: -20px;  */
/* } */
/* div.navbar-more .navbar-nav > li > a { */
/*    display: none; */
/* margin-top: -20px; */
/* } */
/* div.navbar-more > .navbar-nav > li > a > span.menu-icon { */
/* display: none; */
/* margin-top: -20px; */
/* } */

	.navbar {

/*  	top: -40px;  */
        height: 51px; 
		-webkit-transform: translate(0px, 0px);
		transform: translate(0px, 0px);
	}
	.navbar-nav.mobile-bar {
 	top: -20px; 
		display: block;
		max-height: 64px;
		margin: 0px -15px; 
	}
	.navbar-nav.mobile-bar > li > a > span.menu-icon {
		display: none;
	
	}

	
}
  
  
  @media (max-width: 767px) {
 div.navbar-more { 
 margin-top: -22px;

  }

ul.nav > li > a:hover {
/* genius lol */
margin-top: -2px;
margin-bottom: -2px;
border-top: 2px solid #F0F0F0;
border-bottom: 2px solid #F0F0F0;
}

  }
  

</style>

<!-- FACEBOOK SHIT -->
<script>
  // This is called with the results from from FB.getLoginStatus().
  function statusChangeCallback(response) {
    console.log('statusChangeCallback');
    console.log(response);
    // The response object is returned with a status field that lets the
    // app know the current login status of the person.
    // Full docs on the response object can be found in the documentation
    // for FB.getLoginStatus().
    if (response.status === 'connected') {
      // Logged into your app and Facebook.
      testAPI();
    } else if (response.status === 'not_authorized') {
      // The person is logged into Facebook, but not your app.
      document.getElementById('status').innerHTML = 'Please log ' +
        'into this app.';
    } else {
      // The person is not logged into Facebook, so we're not sure if
      // they are logged into this app or not.
      document.getElementById('status').innerHTML = 'Please log ' +
        'into Facebook.';
    }
  }

  // This function is called when someone finishes with the Login
  // Button.  See the onlogin handler attached to it in the sample
  // code below.
  function checkLoginState() {
    FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
    });
  }

  window.fbAsyncInit = function() {
  FB.init({
    appId      : '{1732972510267704}',
    cookie     : true,  // enable cookies to allow the server to access 
                        // the session
    xfbml      : true,  // parse social plugins on this page
    version    : 'v2.5' // use graph api version 2.5
  });

  // Now that we've initialized the JavaScript SDK, we call 
  // FB.getLoginStatus().  This function gets the state of the
  // person visiting this page and can return one of three states to
  // the callback you provide.  They can be:
  //
  // 1. Logged into your app ('connected')
  // 2. Logged into Facebook, but not your app ('not_authorized')
  // 3. Not logged into Facebook and can't tell if they are logged into
  //    your app or not.
  //
  // These three cases are handled in the callback function.

  FB.getLoginStatus(function(response) {
    statusChangeCallback(response);
  });

  };

  // Load the SDK asynchronously
  (function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));

  // Here we run a very simple test of the Graph API after login is
  // successful.  See statusChangeCallback() for when this call is made.
  function testAPI() {
    console.log('Welcome!  Fetching your information.... ');
    FB.api('/me', function(response) {
      console.log('Successful login for: ' + response.name);
      document.getElementById('status').innerHTML =
        'Thanks for logging in, ' + response.name + '!';
    });
  }
</script>

<script>
  window.fbAsyncInit = function() {
    FB.init({
      appId      : '1732972510267704',
      xfbml      : true,
      version    : 'v2.6'
    });
  };

  (function(d, s, id){
     var js, fjs = d.getElementsByTagName(s)[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement(s); js.id = id;
     js.src = "//connect.facebook.net/en_US/sdk.js";
     fjs.parentNode.insertBefore(js, fjs);
   }(document, 'script', 'facebook-jssdk'));
</script>

<!--   DROPDOWN SCRIPT  -->
<script type="text/javascript">
// 	$(function() {
// 		$(".dropdown").hover(function() {
// 			$('.dropdown-menu', this).stop(true, true).fadeIn("fast");
// 			$(this).toggleClass('open');
// 			$('b', this).toggleClass("caret caret-up");
// 		}, function() {
// 			$('.dropdown-menu', this).stop(true, true).fadeOut("fast");
// 			$(this).toggleClass('open');
// 			$('b', this).toggleClass("caret caret-up");
// 		});
// 	});
</script>


<script type="text/javascript">
// $(function () {

//     var active = true;

//     $('#collapse-init').click(function () {
//         if (active) {
//             active = false;
//             $('.panel-collapse').collapse('show');
//             $('.panel-title').attr('data-toggle', '');
//             $(this).text('Enable accordion behavior');
//         } else {
//             active = true;
//             $('.panel-collapse').collapse('hide');
//             $('.panel-title').attr('data-toggle', 'collapse');
//             $(this).text('Disable accordion behavior');
//         }
//     });
    
//     $('#accordion').on('show.bs.collapse', function () {
//         if (active) $('#accordion .in').collapse('hide');
//     });

// });
</script>




  





<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<!-- <script src="js/includeNAV.js"></script> -->
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<link href="/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="/js/bootstrap.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="http://fontawesome.io/assets/font-awesome/css/font-awesome.css">


<link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet">
<script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>

      <link rel="shortcut icon" type='image/x-icon' href="img/favicon.ico">


<script>


$(function(){
    $("#includedLoggedInNav").load("NavLoggedIn2.jsp"); 
  });

$(function(){
   $("#includedLoggedOutNav").load("NavLoggedOut2.jsp"); 
 });

$(document).ready(function() {
    $('a[href="#navbar-more-show"], .navbar-more-overlay').on('click', function(event) {
		event.preventDefault();
		$('body').toggleClass('navbar-more-show');
		if ($('body').hasClass('navbar-more-show'))	{
			$('a[href="#navbar-more-show"]').closest('li').addClass('active');
		}else{
			$('a[href="#navbar-more-show"]').closest('li').removeClass('active');
		}
		return false;
	});
});

</script>

</head>


<body>
<%-- <c:set var="username" scope="session" value="${username}"/> --%>
<%-- <c:when test="${username != null}"> --%>

<%-- </c:when> --%>
<%-- <c:otherwise> --%>
<%-- <c:if test="${5>3}"> --%>


<c:if test="${null != loggedInUser}">
<div id="includedLoggedInNav"></div>
</c:if>



<c:if test="${null == loggedInUser}">
<div id="includedLoggedOutNav"></div>
</c:if>


<!-- <div id="includedLoggedOutNav"></div> -->
