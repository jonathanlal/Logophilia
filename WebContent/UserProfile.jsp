<jsp:include flush="true" page="includes/include_header.jsp"></jsp:include>
<%@ page import="logophilia.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
 <link rel="stylesheet" href="http://fontawesome.io/assets/font-awesome/css/font-awesome.css">
 <link rel="stylesheet" href="//cdn.jsdelivr.net/bootstrap.tagsinput/0.4.2/bootstrap-tagsinput.css" />
<!-- <link href="//cdnjs.cloudflare.com/ajax/libs/x-editable/1.5.0/bootstrap3-editable/css/bootstrap-editable.css" rel="stylesheet"/> -->
<!-- <script src="//cdnjs.cloudflare.com/ajax/libs/x-editable/1.5.0/bootstrap3-editable/js/bootstrap-editable.min.js"></script> -->
 
 
<script>


// $('.dropdown.keep-open').on({
//     "shown.bs.dropdown": function() { this.closable = false; },
//     "click":             function() { this.closable = true; },
//     "hide.bs.dropdown":  function() { return this.closable; }
// });


$(function() {

    $('#login-form-link').click(function(e) {
		$("#login-form").delay(100).fadeIn(100);
 		$("#register-form").fadeOut(100);
 		$("#register-well").fadeOut(100);
		$('#register-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	$('#register-form-link').click(function(e) {
		$("#register-well").delay(100).fadeIn(100);
		$("#register-form").delay(100).fadeIn(100);
 		$("#login-form").fadeOut(100);
		$('#login-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});

});

$(function () {
	  var all_classes = "";
	  var timer = undefined;
	  $.each($('li', '.social-class'), function (index, element) {
	    all_classes += " btn-" + $(element).data("code");
	  });
	  $('li', '.social-class').mouseenter(function () {
	    var icon_name = $(this).data("code");
	    if ($(this).data("icon")) {
	      icon_name = $(this).data("icon");
	    }
	    var icon = "<i class='fa fa-" + icon_name + "'></i>";
	    $('.btn-social', '.social-sizes').html(icon + "Sign in with " + $(this).data("name"));
	    $('.btn-social-icon', '.social-sizes').html(icon);
	    $('.btn', '.social-sizes').removeClass(all_classes);
	    $('.btn', '.social-sizes').addClass("btn-" + $(this).data('code'));
	  });
	  $($('li', '.social-class')[Math.floor($('li', '.social-class').length * Math.random())]).mouseenter();
	});















</script>
<!--                         <style>$.fn.editable.defaults.mode = 'inline';</style> -->
		<style>
		
		
		
		
		.panel-login {
	border-color: #ccc;
	-webkit-box-shadow: 0px 2px 3px 0px rgba(0,0,0,0.2);
	-moz-box-shadow: 0px 2px 3px 0px rgba(0,0,0,0.2);
	box-shadow: 0px 2px 3px 0px rgba(0,0,0,0.2);
}
.panel-login>.panel-heading {
	color: #00415d;
	background-color: #fff;
	border-color: #fff;
	text-align:center;
}
.panel-login>.panel-heading a{
	text-decoration: none;
	color: #666;
	font-weight: bold;
	font-size: 15px;
	-webkit-transition: all 0.1s linear;
	-moz-transition: all 0.1s linear;
	transition: all 0.1s linear;
}
.panel-login>.panel-heading a.active{
	color: #029f5b;
	font-size: 18px;
}
.panel-login>.panel-heading hr{
	margin-top: 10px;
	margin-bottom: 0px;
	clear: both;
	border: 0;
	height: 1px;
	background-image: -webkit-linear-gradient(left,rgba(0, 0, 0, 0),rgba(0, 0, 0, 0.15),rgba(0, 0, 0, 0));
	background-image: -moz-linear-gradient(left,rgba(0,0,0,0),rgba(0,0,0,0.15),rgba(0,0,0,0));
	background-image: -ms-linear-gradient(left,rgba(0,0,0,0),rgba(0,0,0,0.15),rgba(0,0,0,0));
	background-image: -o-linear-gradient(left,rgba(0,0,0,0),rgba(0,0,0,0.15),rgba(0,0,0,0));
}
.panel-login input[type="text"],.panel-login input[type="email"],.panel-login input[type="password"] {
	height: 45px;
	border: 1px solid #ddd;
	font-size: 16px;
	-webkit-transition: all 0.1s linear;
	-moz-transition: all 0.1s linear;
	transition: all 0.1s linear;
}
.panel-login input:hover,
.panel-login input:focus {
	outline:none;
	-webkit-box-shadow: none;
	-moz-box-shadow: none;
	box-shadow: none;
	border-color: #ccc;
}
.btn-login {
	background-color: #59B2E0;
	outline: none;
	color: #fff;
	font-size: 14px;
	height: auto;
	font-weight: normal;
	padding: 14px 0;
	text-transform: uppercase;
	border-color: #59B2E6;
}
.btn-login:hover,
.btn-login:focus {
	color: #fff;
	background-color: #53A3CD;
	border-color: #53A3CD;
}
.forgot-password {
	text-decoration: underline;
	color: #888;
}
.forgot-password:hover,
.forgot-password:focus {
	text-decoration: underline;
	color: #666;
}

.btn-register {
	background-color: #1CB94E;
	outline: none;
	color: #fff;
	font-size: 14px;
	height: auto;
	font-weight: normal;
	padding: 14px 0;
	text-transform: uppercase;
	border-color: #1CB94A;
}
.btn-register:hover,
.btn-register:focus {
	color: #fff;
	background-color: #1CA347;
	border-color: #1CA347;
}
		
		
		
		#fileupload-example-4 {
  height: 0;
  width: 0;
}

#fileupload-example-4-label {
    border: 1px solid #cccccc;
    padding: 5px;
}
		
		img.shard{
   height:23px;
/*       margin-bottom: 10px; */
   

}
img.lists{
   height:20px;

}
			textarea {
/* 				padding: 10px; */
				vertical-align: top;
/* 				width: 200px; */
			}
			textarea:focus {
				outline-style: solid;
				outline-width: 2px;
			}


/* img.resize{ */
/*    max-width:50%; */
/*    max-height:50%; */
/* } */


 bodylikes{
 	min-width: 100%;
 	text-align: center; 
 	}
#all{
	width:100%;
	margin: 0 auto; /*centers the website*/
}

#likes{
	height:5px;
	width:50%;
	background:#0000ee;
	float:left;
}
#dislikes{
	height:5px;
	width:50%;
	background:#ccc;
	float:right;
}

#bar{
	margin:0 auto;
	width:100%;
}


img.resize{
   max-width:480px;
   display: block;
    margin-left: auto;
    margin-right: auto;
    margin-top: 5px;
   
/*    height:40px; */
}

img.userposts{
   max-height: 40px;
   max-width: 40px;
   
/*    height:40px; */
}


img.resizeUser{
   height:34px;
   width:34px;
   display: block;
/*     margin-left: auto; */
    margin-right: auto;
/*     padding-right: 5px; */
/*     margin-bottom: 3px; */
   
   
/*    height:40px; */
}


img.resizeUserShard{
/*    height:34px; */
   width:80px;
   display: block;
/*     margin-left: auto; */
    margin-right: auto;
/*     padding-right: 5px; */
/*     margin-bottom: 3px; */
   
   
/*    height:40px; */
}


img.resizeUserImgComment{
/*    height:34px; */
/*    height:50px; */
/*    width:50px; */
   height:30px;
   width:30px;
/*    display: block; */
/*     margin-left: auto; */
    margin-right: 5px;
     margin-left: 2px; */
/*     margin-bottom: 3px; */
   
   
/*    height:40px; */
}

/* ==========================================================================
   Author's custom styles
   ========================================================================== */

body
{
    font-family: 'Open Sans', sans-serif;
}

.fb-profile img.fb-image-lg{
    z-index: 0;
    width: 100%;  
    margin-bottom: 10px;
/*       bottom: 0px; */
}

.fb-image-profile
{
/*     margin: -270px 10px 0px 10px; */
    z-index: 1;
    max-width: 260px; 
     max-height: 260px; 
     margin-left:10px;
     bottom: 19px;
}




@media (max-width:768px)
{
    
.fb-profile-text>h1{
    font-weight: 700;
    font-size:16px;
}

.fb-image-profile
{
    margin: -45px 10px 0px 25px;
    z-index: 9;
    width: 20%; 
      bottom: 0px;
}
}


body{ background: #fafafa;}
.widget-area.blank {
background: none repeat scroll 0 0 rgba(0, 0, 0, 0);
-webkit-box-shadow: none;
-moz-box-shadow: none;
-ms-box-shadow: none;
-o-box-shadow: none;
box-shadow: none;
}
body .no-padding {
padding: 0;
}
.widget-area {
background-color: #fff;
-webkit-border-radius: 4px;
-moz-border-radius: 4px;
-ms-border-radius: 4px;
-o-border-radius: 4px;
border-radius: 4px;
-webkit-box-shadow: 0 0 16px rgba(0, 0, 0, 0.05);
-moz-box-shadow: 0 0 16px rgba(0, 0, 0, 0.05);
-ms-box-shadow: 0 0 16px rgba(0, 0, 0, 0.05);
-o-box-shadow: 0 0 16px rgba(0, 0, 0, 0.05);
box-shadow: 0 0 16px rgba(0, 0, 0, 0.05);
float: left;
margin-top: 0px;
/* padding: 25px 30px; */
position: relative;
width: 100%;
}
.status-upload {
background: none repeat scroll 0 0 #f5f5f5;
-webkit-border-radius: 4px;
-moz-border-radius: 4px;
-ms-border-radius: 4px;
-o-border-radius: 4px;
border-radius: 4px;
float: left;
width: 100%;
}
.status-upload form {
float: left;
width: 100%;
}
.status-upload form textarea {
background: none repeat scroll 0 0 #fff;
border: medium none;
-webkit-border-radius: 4px 4px 0 0;
-moz-border-radius: 4px 4px 0 0;
-ms-border-radius: 4px 4px 0 0;
-o-border-radius: 4px 4px 0 0;
border-radius: 4px 4px 0 0;
color: #777777;
float: left;
font-family: Lato;
font-size: 14px;
height: 40px;
letter-spacing: 0.3px;
padding: 20px;
width: 100%;
resize:vertical;
outline:none;
border: 1px solid #F2F2F2;
}

.status-upload ul {
float: left;
list-style: none outside none;
margin: 0;
padding: 0 0 0 15px;
width: auto;
}
.status-upload ul > li {
float: left;
}
.status-upload ul > li > a {
-webkit-border-radius: 4px;
-moz-border-radius: 4px;
-ms-border-radius: 4px;
-o-border-radius: 4px;
border-radius: 4px;
color: #777777;
float: left;
font-size: 14px;
height: 30px;
line-height: 30px;
margin: 10px 0 10px 10px;
text-align: center;
-webkit-transition: all 0.4s ease 0s;
-moz-transition: all 0.4s ease 0s;
-ms-transition: all 0.4s ease 0s;
-o-transition: all 0.4s ease 0s;
transition: all 0.4s ease 0s;
width: 30px;
cursor: pointer;
}
.status-upload ul > li > a:hover {
background: none repeat scroll 0 0 #606060;
color: #fff;
}
.status-upload form button {
border: medium none;
-webkit-border-radius: 4px;
-moz-border-radius: 4px;
-ms-border-radius: 4px;
-o-border-radius: 4px;
border-radius: 4px;
color: #fff;
float: right;
font-family: Lato;
font-size: 14px;
letter-spacing: 0.3px;
margin-right: 9px;
margin-top: 9px;
padding: 6px 15px;
}
.dropdown > a > span.green:before {
border-left-color: #2dcb73;
}
.status-upload form button > i {
margin-right: 7px;
}








#pinBoot {
  position: relative;
  max-width: 100%;
  width: 100%;
}
/* img { */
/*   width: 100%; */
/*   max-width: 100%; */
/*   height: auto; */
/* } */
.white-panel {
  position: absolute;
/*   background: white; */
  box-shadow: 0px 1px 2px rgba(0, 0, 0, 0.3);
  padding: 10px;
}
/*
stylize any heading tags withing white-panel below
*/

.white-panel h1 {
  font-size: 1em;
}
.white-panel h1 a {
  color: #A92733;
}
.white-panel:hover {
  box-shadow: 1px 1px 10px rgba(0, 0, 0, 0.5);
  margin-top: -5px;
  -webkit-transition: all 0.3s ease-in-out;
  -moz-transition: all 0.3s ease-in-out;
  -o-transition: all 0.3s ease-in-out;
  transition: all 0.3s ease-in-out;
}

/* image thumbnail */
.thumb {
    display: block;
	width: 100%;
	margin: 0;
}

/* Style to article Author */
.by-author {
	font-style: italic;
	line-height: 1.3;
	color: #aab6aa;
/* 	margin-right: 40px; */
/* 	margin-bottom: 50px; */
}

/* Main Article [Module]
-------------------------------------
* Featured Article Thumbnail
* have a image and a text title.
*/
.featured-article {
	width: 482px;
	height: 350px;
	position: relative;
	margin-bottom: 1em;
}

.featured-article .block-title {
	/* Position & Box Model */
	position: absolute;
	bottom: 0;
	left: 0;
	z-index: 1;
	/* background */
	background: rgba(0,0,0,0.7);
	/* Width/Height */
	padding: .5em;
	width: 100%;
	/* Text color */
	color: #fff;
}

.featured-article .block-title h2 {
	margin: 0;
}

/* Featured Articles List [BS3]
--------------------------------------------
* show the last 3 articles post
*/

.main-list {
	padding-left: .5em;
}

.main-list .media {
	padding-bottom: 1.1em;
	border-bottom: 1px solid #e8e8e8;
}








</style>



<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>

    <div class="fb-profile">
<div class="row">
           <div class="col-md-1" >
           </div>
     
     
      		<div class="col-md-10" >





<!--           <form method="post" enctype="multipart/form-data" action="UploadFileCover"> -->
 <div class="dropdown keep-open">
 


 <a data-toggle="modal" data-target="#myModal2">
 <img style="position: relative;" class="fb-image-lg" src="${coverImg}" >
 </a>
 
 

 <ul class="dropdown-menu" aria-labelledby="dropdownMenu1" style="padding: 10px;">

    <li>
    <div class="container">

  <label style="text-decoration: underline;">Upload New Cover Image</label>
      <input type="file" name="file"/>
      <br>
   Or url link,
      <input style="width: 100%;" name="imgURL" placeholder="image url: //www.images.com/image.jpg">
      

  <h6>Remember to click <b>"Save"</b> below once you save your image!</h6>
      </div>
    </li>

    <li role="separator" class="divider"></li>
     <li style="margin-right: 5px;"><span class="pull-right"><input type="submit" value="Save" class="btn btn-success btn-success" style="text-shadow: orange;" /></span></li>
    
    
  </ul>
 </div>
<!--  </form> -->
           
           

           
           
         
<div style="${hideProfileImgSetting}">
           
<!--                    <form method="post" enctype="multipart/form-data" action="UploadFileProfile"> -->
 <div class="dropdown" style="position: relative;bottom: -10px;;z-index: 6;">
  <a data-toggle="modal" data-target="#myModal1">
    <img align="left" style="position:absolute;z-index: 4;padding-bottom: 10px;" class="fb-image-profile" src="${profileImg}">
 </a>
 <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">

 
    <li><input type="file" id="files" class="hidden"/>
         <div class="container">
 <label style="text-decoration: underline;">Upload New Profile Image</label>
      <input type="file" name="file"/>


   Or url link,
      <input style="width: 100%;padding: 5px;" name="imgURL" placeholder="image url: //www.images.com/image.jpg">
      
  <h6>Remember to click <b>"Save"</b> below once you choose your image!</h6>
  </div>
    </li>
    
    <li role="separator" class="divider"></li>
    <li style="margin-right: 5px;"><span class="pull-right" style="margin-right:5px;"><input type="submit" value="Save" class="btn btn-success btn-success" style="text-shadow: orange;" /></span></li>
  </ul>
 </div>

<!--  </form> -->


</div>

         
         
         
         
         

        
        






  		  </div>
    
           <div class="col-md-1" >
           </div>

 </div>
 </div>
 
<div class="row">
	  <div class="col-md-1" >
       </div>
       
	  <div class="col-md-3" >
	  <div class="jummbotron">
	  
	  
	  
	  <div class="panel with-nav-tabs panel-default" style="width: 100 px;">
                <div class="panel-heading">
                        <ul class="nav nav-tabs">
							<li ><a href="#tab2default" data-toggle="tab">Intro</a></li>
                        
                           <li class="active"><a href="#tab1default" data-toggle="tab">General</a></li>

                        </ul>
                </div>
	                  <div class="panel-body">
                    <div class="tab-content">
                        <div class="tab-pane fade in active" id="tab1default">

<!-- <span class="fb-follow"><button class="btn btn-default btn-xs">Follow</button> </span> -->
	  <h1>${loggedInUser}   </h1>
	     <h2><i class="fa fa-diamond" aria-hidden="true"></i> ${eros} Eros</h2>
  
    <h3><a href="#toRankDesc">${Rank}</a></h3>
    <hr/>
<!--    <h4>Join Date: 10/08/16 </h4> -->
            <h4> Joined:  ${creationTime}</h4>
<%--                         <h4> Date:  ${date}</h4> --%>
            
<%--                         <h4> Last Accessed:  ${lastAccessed}</h4> --%>
            
            
      
      
   
	  
          


						</div>
						
						














<!--                         <div class="tab-pane fade" id="tab2default">Default 2</div> -->
<!-- 					<h4>Angular-xeditable Textarea (Bootstrap 3)</h4> -->
<!-- <div ng-app="app" ng-controller="Ctrl"> -->
<!--   <a href="#" editable-textarea="user.desc" e-rows="7" e-cols="40"> -->
<!--     <pre>{{ user.desc || 'no description' }}</pre> -->
<!--   </a> -->
<!-- </div> -->
					
<!--                     </div> -->
                    
<!--                                     <div class="tab-content"> -->
                        <div class="tab-pane fade in" id="tab2default">
                        
                        
<!--                         <div class="status-upload">  !!!!!!!!!!!!!!!!!!!!!!!!!! enctype="multipart/form-data"!!!!!put that in form!!!!!!!!!!!!!!--> 
									<form method="post" action="UserSaveProfileDescription">           
					
									       
<!--                         <h2 contenteditable="true"><input style="display: none;" name="profileintrotitle" type="text" placeholder=""></h2> -->
                      <h3><textarea contenteditable="true" style="overflow:hidden;height:100px;width:100%;border: 0px;" class="input xlarge" name="Ptitle">${usertitleresults}</textarea></h3>  
                  
<!-- <input style="border: 0px;height: 50px;" name="profileintro" type="text" placeholder=""> -->
<textarea id="textarea-container" contenteditable="true" style="resize:vertical;height:300px;width:100%;border: 0px;overflow:hidden" class="input xlarge" name="Pbody">${userbodyresults}</textarea>

  <input type="submit" value="save" class="btn btn-default btn-xs"> 
   </form>
   
   
   
	  
          


						</div>
						
						














<!--                         <div class="tab-pane fade" id="tab2default">Default 2</div> -->
<!-- 					<h4>Angular-xeditable Textarea (Bootstrap 3)</h4> -->
<!-- <div ng-app="app" ng-controller="Ctrl"> -->
<!--   <a href="#" editable-textarea="user.desc" e-rows="7" e-cols="40"> -->
<!--     <pre>{{ user.desc || 'no description' }}</pre> -->
<!--   </a> -->
<!-- </div> -->
					
                    </div>
                    
                    
                </div>
                
                
                
                
                
            </div>
        
	  <br/>
	   
	  
	  	   <div class="panel with-nav-tabs panel-default" style="width: 100 px;">
                <div class="panel-heading">
<!--                         <ul class="nav nav-tabs"> </li><li class="active">-->
                            <h4>Saved words</h4>
<!--                             <li><a href="#tab2default" data-toggle="tab">More info </a></li> -->

<!--                         </ul> -->
                </div>
	                  <div class="panel-body">
                    <div class="tab-content">
                 
                 		                                     <div class="list-group">
                    
                    <c:forEach items="${savedwords}" var="savedwordsvar">
             <li class="list-group-item">${savedwordsvar}</li>
<!--              <span class="pull-right"><button class="btn btn-link" style="text-decoration:none;margin: 0px;position: absolute;">X</button></span> -->
					</c:forEach>

                      </div>
                      
                        
                 
                 
                 
                 
                                       
                   
                </div>
                
                
                
                
                
            </div>
	  	     
	  	     
	  	     
	  	     </div>
	  
	  <div class="panel with-nav-tabs panel-default" style="width: 100 px;">
                <div class="panel-heading">
                            <h4>Searched Word History</h4>

                </div>
	                  <div class="panel-body">
                    <div class="tab-content">
                    <div class="list-group">
                    
                                        <c:forEach items="${searchhistory}" var="searchhistoryword">
                    
             <a class="list-group-item">${searchhistoryword}</a>
             					</c:forEach>
             
                      </div>
                      
              
                </div>
                
                
                
                
                
            </div>
            </div>
	  
	  

	  
	  </div>
	  </div>
	  <div class="col-md-4">
	  <div class="jumbotron" style="min-height: 215px;">
	
<!-- 								<div class="status-upload">  !!!!!!!!!!!!!!!!!!!!!!!!!! enctype="multipart/form-data"!!!!!put that in form!!!!!!!!!!!!!!--> 
<!-- 									<form method="post" action="UserPostServlet">  -->
									
									
<!-- 													<div class="panel panel-login"> -->
					<div class="panel-heading" style="margin-bottom: 0px;padding-bottom: 0px;text-align: center;">
						<div class="row">
							<div class="col-xs-6">
								<a href="#" class="active" id="login-form-link">Word</a>
							</div>
							<div class="col-xs-6">
								<a href="#" id="register-form-link" >Quote</a>
							</div>
						</div>
						<hr style="margin-bottom: 5px;padding-bottom: 5px;">
					</div>
									
								<div class="panel-body" style="margin-top: 0px;padding-top: 0px;">
								
								
								
								<form method="post" action="UserWordPostServlet" enctype="multipart/form-data"> 	
								
								
								<div id="login-form" role="form" style="display: block;margin-top: 0px;">
				
										
										
										
										
													
									
						<textarea style="resize:none;height: 35px;width: 200px;" NAME="wordpostword" rows="1" class="form-control" placeholder="What is the word?"></textarea>
									
								<br>	
									        
									
		<textarea style="padding-top: 10px;background-color: white;" name="usertxt" class="form-control" placeholder="Your comments about this (optional)"></textarea>

<br>	
<textarea style="resize:none;width:100%;" rows="1" class="form-control" name="imageURL" placeholder="Link/URL here"></textarea>
<br>
      <input type="file" name="file"/>

 <div id="MyOwnDefinition" class="collapse">
<br>
	
<textarea style="resize:none;width:100%;" class="form-control" rows="4" id="comment-box" name="definition" placeholder="If you want your own definition, type it here..."></textarea>
 </div>

										
<!-- 							        <p></p> -->
							
						<br>
	
      							<div class="pull-right" style="padding-top: 10px;">
<!--       														        <p></p> -->
      							
							<button type="submit" class="btn btn-primary btn-sm"><i class="fa fa-share"></i> Post Word</button>
							</div>
<!-- 							      							<div class="pull-left"> -->
							
<!-- 							<div class="checkbox-inline" onclick="" data-toggle="collapse" data-target="#MyOwnDefinition" > -->
<!-- 				<input type="checkbox" name="definitionCheck" data-on="" data-off="My Definition" data-toggle="toggle" value="definitionON"> -->
 
<!-- </div> -->


		
<!-- 		</div>	 -->
	

<!--  <div id="MyOwnDefinition" class="collapse" style="margin-top:55px;"> -->

	
<!-- <textarea style="resize:none;width:100%;" class="form-control" rows="4" id="comment-box" name="definition" placeholder="If you want your own definition, type here..."></textarea> -->
<!--  </div> -->
		
				<br>
										
										
										
										
										
										
										
										
										
										
									</div>	
																  </form>
									
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										
					<form method="post" action="UserQuotePostServlet" enctype="multipart/form-data"> 	
										
										<div id="register-form" role="form" style="display: none;">
								
								
 
								<textarea  name="quote" rows="6" class="form-control" placeholder="Quote here"></textarea>
									
								<br>	
								<div class="pull-right">	        
						<textarea style="width: 300px;overflow:hidden;" name="author" rows="1" class="form-control" placeholder="Who said it?"></textarea>
						<br>
									</div>
					<br>
									
									
		<textarea style="padding-top: 10px;background-color: white;" name="usertxt" class="form-control" placeholder="Your comments about this (optional)"></textarea>

<br>	
<textarea style="resize:none;width:100%;" rows="1" class="form-control" name="imageURL" placeholder="Link/URL here"></textarea>
		
<br>
      <input type="file" name="file"/>

					
						<div class="pull-right" style="padding-top: 10px;">
<!--       														        <p></p> -->
      							
      							
							<button type="submit" class="btn btn-primary btn-sm"><i class="fa fa-share"></i> Post Quote</button>
							</div>
					
					
								
								
								
								
								
								</div>
										</form>
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										
										</div>
										
										
				
			

</div>
	  
	  
	  <div class="row">
	  			<div class="col-md-12">
	  			
	  			
	  
	  </div>
	  </div>
	  
	  
	  
<c:forEach items="${idFeedArray}" var="posts" varStatus="count">




		<c:set var="type" scope="session" value="${typeFeedArray[count.index]}" />

		<c:if test="${fn:contains(type, 'w')}">



			<div class="col-md-12">
				<div style="background: white; !important" class="jumbotron">


					<div class="container">
						<div class="pull-right" style="margin-top: 10px;">

							<form action="UserPostMenu" method="post">

								<ul>
									<li class="dropdown"><a href="#" class="dropdown-toggle"
										data-toggle="dropdown"
										style="padding-right: 10px; color: inherit;"><span
											class="glyphicon glyphicon-menu-down"></span></a>
										<ul class="dropdown-menu dropdown-menu-right list-group"
											style="margin-right: 10px;">



											<li><button class="list-group-item" value="${posts}"
													name="action" type="submit">
													<span class="glyphicon glyphicon-pencil"></span> Save Edit
												</button></li>

											<li><button class="list-group-item" value="${posts}"
													name="action" type="submit">
													<span class="glyphicon glyphicon-plus"></span> Add to
													List...
												</button></li>



											<!--                <li><a href="#"><span class="glyphicon glyphicon-plus"></span> Add to List...</a></li> -->
				<li><button class="list-group-item" data-toggle="modal" data-target="#myModal" type="button" style="padding-left: 20px; color: inherit;">
													<span class="glyphicon glyphicon-trash"></span> Delete <c:out value="${idFeedArray[count.index]}"/>
							</button></li>
											<!--          <input class="form-control" name="word" type="text" placeholder="what is the word?" -->
										</ul></li>
								</ul>
							</form>
						</div>



						<div id="myModal" class="modal fade">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<!--         <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button> -->
										<h4 class="modal-title">Delete post
											${WordOrQuotePost[count.index]}?</h4>
									</div>
									<!--       <div class="modal-body"> -->
									<!--         <p>One fine body</p> -->
									<!--       </div> -->
									<div class="modal-footer">
										<form action="DeleteWordPostServlet" method="post">

											<button type="button" class="btn btn-default"
												data-dismiss="modal">No, changed my mind.</button>
											<!--         <button type="button" class="btn btn-danger" type="submit" >Yes, delete this list.</button> -->
											<input type="submit" name="action" value="Yes, delete this post." class="btn btn-danger">
												 <input hidden="true" name="deleteID" value="${idFeedArray[count.index]}">
												 <input hidden="true" name="deletetype" value="w">
<%-- 												 												 <input hidden="true" name="delete" value="${WordOrQuotePost[count.index]}"> --%>
												 
										</form>

									</div>
								</div>
								<!-- /.modal-content -->
							</div>
							<!-- /.modal-dialog -->
						</div>
						<!-- /.modal -->





						<h3 class="caption" style="margin-bottom: 0px; padding-bottom: 0px;">



							<span><img class="userposts" src="${profileImg}">
								${userpost[count.index]} </span>
						</h3>
						<small><a href="#" class="caption" style="padding-left: 50px; color: inherit; position: absolute; top: 60px;">${timepost[count.index]}</a></small>
						<br>
<textarea contenteditable="true"
							style="overflow: hidden; height: 50px; width: 100%; border: 0px;margin-bottom: -10px;"
							class="input xlarge lead" name="usertext">${DefinitionOrAuthorPost[count.index]}</textarea>
<img class="resize" src="${imagepost[count.index]}" style="max-width: 430px;"/> 

						


						<font
							size="40"><a>${WordOrQuotePost[count.index]}</a></font>
						<div class="well">
						
						
						
												<ul class="list-group">

    <c:forEach items="${usertextpost[count.index]}" var="def" varStatus="count2">
     <li class="list-group-item">${def}</li>
     	</c:forEach>

      
</ul>
						
						</div>
						
						
						
						
						<hr />
					</div>

					<div class="container" style="white-space:nowrap">
					
					

			<form action="AddLike" method="post" style="display:inline;">
			
		<input name="postUser" value="${userpost[count.index]}" type="hidden">
			
			 <input name="id" value="${wordorquotepostID[count.index]}" type="hidden">
			 
			 			 <input name="type" value="w" type="hidden">
			 
						
						<button style="padding-right: 0;"  type="submit" class="btn btn-link"><span class="glyphicon glyphicon-thumbs-up"></span></button>
			</form>
									<button style="padding-left: 0;" class="btn btn-link">${likesArraySize[count.index]}</button>
			
						
						


<c:if test="${not empty savedwordsArrayCheck}">

						<c:if test="${fn:contains(savedwordsArrayCheck[count.index], 'yes')}">
												<form action="RemoveSaved" method="post">
												<input type="hidden" name="word" value="${WordOrQuotePost[count.index]}">
						
  							<button type="submit" class="btn btn-link"><span style="color: red;" class="glyphicon glyphicon-heart"></span> Saved!</button>
</form>
</c:if>


						<c:if test="${fn:contains(savedwordsArrayCheck[count.index], 'no')}">

				<form action="SaveWord" method="post">
												<input type="hidden" name="word" value="${WordOrQuotePost[count.index]}">
						<button type="submit" class="btn btn-link"><span class="glyphicon glyphicon-heart"></span> Save?</button>
						</form>
						
</c:if>

</c:if>


<c:if test="${empty savedwordsArrayCheck}">

			<form action="SaveWord" method="post">
												<input type="hidden" name="word" value="${WordOrQuotePost[count.index]}">
						<button type="submit" class="btn btn-link"><span class="glyphicon glyphicon-heart"></span> Save?</button>
						</form>

</c:if>






					</div>
					<div>
						<ul class="list-group">

    <c:forEach items="${arrayception[count.index]}" var="comment" varStatus="count2">
     <li class="list-group-item">${comment}</li>
     	</c:forEach>

      
</ul>




					</div>


		


					<div class="container">


<form action="AddComment" method="post">
						<div class="input-group">

							<div class="pull-right">
							
							<input name="postID" value="${wordorquotepostID[count.index]}" type="hidden">
								<input name="postUser" value="${userpost[count.index]}" type="hidden">
									<input name="type" value="${typeFeedArray[count.index]}" type="hidden">
									
							
								<input name="comment" style="width: 100%; padding-left: 5px;" type="text"
									class="form-control" placeholder="Leave a comment...">
								<span class="input-group-btn">
									<button class="btn btn-secondary" type="submit">Enter</button>
								</span>
							</div>
							<div class="pull-left">

								<img class="resizeUser" src="${profileImg}">
							</div>


						</div>
</form>

					</div>






				</div>
			</div>

		</c:if>


		<c:if test="${fn:contains(type, 'q')}">



	<div class="col-md-12">
				<div style="background: white; !important" class="jumbotron">


					<div class="container">
						<div class="pull-right" style="margin-top: 10px;">

<!-- 							<form action="UserPostMenu" method="post"> -->

								<ul>
									<li class="dropdown"><a href="#" class="dropdown-toggle"
										data-toggle="dropdown"
										style="padding-right: 10px; color: inherit;"><span
											class="glyphicon glyphicon-menu-down"></span></a>
										<ul class="dropdown-menu dropdown-menu-right list-group"
											style="margin-right: 10px;">



											<li><button class="list-group-item" value="${posts}"
													name="save" type="submit">
													<span class="glyphicon glyphicon-pencil"></span> Save Edit
												</button></li>

											<li><button class="list-group-item" value="${posts}"
													name="addToList" type="submit">
													<span class="glyphicon glyphicon-plus"></span> Add to
													List...
												</button></li>



											<!--                <li><a href="#"><span class="glyphicon glyphicon-plus"></span> Add to List...</a></li> -->
											<li><button class="list-group-item" data-toggle="modal"
													data-target="#myModal" type="button"
													style="padding-left: 20px; color: inherit;">
													<span class="glyphicon glyphicon-trash"></span> Delete
												</button></li>
											<!--          <input class="form-control" name="word" type="text" placeholder="what is the word?" -->
										</ul></li>
								</ul>
<!-- 							</form> -->
						</div>



						<div id="myModal" class="modal fade">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<!--         <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button> -->
										
										
										
										
										<h4 class="modal-title">Delete post
											${WordOrQuotePost[count.index]}?</h4>
									</div>
									<!--       <div class="modal-body"> -->
									<!--         <p>One fine body</p> -->
									<!--       </div> -->
									<div class="modal-footer">
										<form action="DeleteWordPost" method="post">

											<button type="button" class="btn btn-default"
												data-dismiss="modal">No, changed my mind.</button>
											<!--         <button type="button" class="btn btn-danger" type="submit" >Yes, delete this list.</button> -->
											<input type="submit" value="Yes, delete this post."
												id="files" name="file" class="btn btn-danger"> 
										
															 <input hidden="true" name="deleteword" value="${idFeedArray[count.index]}">
<!-- 												 <input hidden="true" name="deletetype" value="q"> -->
										</form>

									</div>
								</div>
								<!-- /.modal-content -->
							</div>
							<!-- /.modal-dialog -->
						</div>
						<!-- /.modal -->





						<h3 class="caption" style="margin-bottom: 0px; padding-bottom: 0px;">



							<span><img class="userposts" src="${profileImg}"/>
								${userpost[count.index]} </span>
						</h3>
						<small><a href="#" class="caption" style="padding-left: 50px; color: inherit; position: absolute; top: 60px;">${timepost[count.index]}</a></small>
						<br>
						<p>${usertextpost[count.index]}</p>
						
						<img class="resize" src="${imagepost[count.index]}" style="max-width: 430px;"/> 

<blockquote>
  <p>${WordOrQuotePost[count.index]}</p>
  <footer>${DefinitionOrAuthorPost[count.index]}</footer>
</blockquote>



						<hr />
					</div>

				<div class="container" style="white-space:nowrap">
					
					

			<form action="AddLike" method="post" style="display:inline;">
			
		<input name="postUser" value="${userpost[count.index]}" type="hidden">
			
			 <input name="id" value="${wordorquotepostID[count.index]}" type="hidden">
			 
			 <input name="type" value="q" type="hidden">
						
						<button style="padding-right: 0;"  type="submit" class="btn btn-link"><span class="glyphicon glyphicon-thumbs-up"></span></button>
			</form>
									<button style="padding-left: 0;" class="btn btn-link">${likesArraySize[count.index]}</button>
			
						
						









					</div>
					<div>
						<ul class="list-group">

    <c:forEach items="${arrayception[count.index]}" var="comment" varStatus="count2">
     <li class="list-group-item">${comment}</li>
     	</c:forEach>

      
</ul>




					</div>


		


					<div class="container">


<form action="AddComment" method="post">
						<div class="input-group">

							<div class="pull-right">
							
							<input name="postID" value="${wordorquotepostID[count.index]}" type="hidden">
								<input name="postUser" value="${userpost[count.index]}" type="hidden">
									<input name="type" value="${typeFeedArray[count.index]}" type="hidden">
									
							
								<input name="comment" style="width: 100%; padding-left: 5px;" type="text"
									class="form-control" placeholder="Leave a comment...">
								<span class="input-group-btn">
									<button class="btn btn-secondary" type="submit">Enter</button>
								</span>
							</div>
							<div class="pull-left">

								<img class="resizeUser" src="${profileImg}">
							</div>


						</div>
</form>

					</div>






				</div>
			</div>















































		</c:if>

























	</c:forEach>


	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  </div>
	  <div class="col-md-3" >
	  	     
	  	     
	  	     
	  	     
	  	    
	  	     
<!-- 	  	     <div class="panel with-nav-tabs panel-default" style="width: 100 px;"> -->
<!--                 <div class="panel-heading"> -->
<!--                             <h4>Shards <img class="shard" src="img/crashshard2mult.png"> </h4> -->
<!--                 </div> -->
<!-- 	                  <div class="panel-body"> -->
<!--                     <div class="tab-content"> -->
<%--                 				<c:if test="${usershards == null}"> --%>
<!-- 					<div class="alert alert-info" role="alert">   -->
<!--     <a class="alert-link" style="text-align: right;text-decoration: none;">You have no shards.</a> <a  href="CreateNewShard.jsp" >(click to create one)</a>   -->
<!-- </div> -->




                              
<!--      		<div class="media"> -->
     		
     		
<!--   <a class="media-left" href="#"> -->
<!--     <img class="resizeUserShard" src="img/rainbow.png"> -->
<!--   </a> -->
  
  
<!--   <div class="media-body"> -->
<!--     <h4 class="media-heading"><a>Example Shard</a></h4> -->
<!--     <p>A shard about shards, what you can do with it, how to create one, so on...</p> -->
 
<!--   </div>   -->
<!--     <div id="all"> -->
<!-- 	<div id="bar"> -->
<!-- 		<div id="likes"></div> -->
<!-- 		<div id="dislikes"></div> -->
<!-- 	</div> -->
<!-- 	<br> -->

<!-- </div> -->
<!--                 <div class="pull-left"> -->
 
<!--   	  <p class="by-author">By <a href="#" style="text-decoration: none;">Logophilia</a></p>  -->
<!--  </div> -->
   
<!--       		               <div class="pull-right"> -->
 
 
 
<!--  <div class="pull-right">	  -->
<!--  	 <a id="like" onclick="like();" role="button">  	  -->
<!--  	 <small><i class="glyphicon glyphicon-thumbs-up"></i></small><input value="" id="likeButton" style="width: 20px;border: 0;"></a> -->
 	 
<!--  	 <a id="dislike" onclick="dislike();"  role="button">  -->
<!--  	 <small><i class="glyphicon glyphicon-thumbs-down"></i></small><input value="" id="dislikeButton" style="width: 20px;border:0;"></a> -->
 	 
<!--  	  	 <a id="addToWordList" data-toggle="collapse" href="#collapse5" role="button">  -->
<!--  	 <small><i class="glyphicon glyphicon-comment"></i> 24</small></a> -->
 	
 	 
<!--  	 </div> -->
 	   
<!--  	 <br> -->
<!--  </div> -->
<!-- <br> -->
<!--  <hr/> -->
<!--  </div>  -->
<%--       </c:if>   --%>
   
<!--                 </div> -->

<!--            </div> -->
	  
<!-- 	   <div class="col-md-1" > -->
<!--            </div> -->
  
<!-- 	 </div> -->
	  	     
	  	     
	  	     
	  	     
	   			<div class="panel with-nav-tabs panel-default" style="width: 100 px;">
                <div class="panel-heading">
<!--                         <ul class="nav nav-tabs"> </li><li class="active">-->
                            <h3>Word Lists <img class="lists" src="img/menu2.png">  </h3>
<!--                             <li><a href="#tab2default" data-toggle="tab">More info </a></li> -->

<!--                         </ul> -->
                </div>
	                  <div class="panel-body">
                    <div class="tab-content">
                 
                 
                 
                 
                 
                 
<%--                       <c:forEach items="${savedwords}" var="savedwordsvar"> --%>
<%--              <a class="list-group-item">${savedwordsvar}</a> --%>
<%-- 					</c:forEach> --%>
                 
                 
                 
                 
                 
                 
  	<form method="get" action="OpenWordListServlet">           
                 
                 				<table class="table table-hover" id="dev-table">
						<thead>
							<tr>
							
								<th>List Name</th>
								<th>List Size</th>
								
								<th>Likes</th>
								<th> </th>
						
							</tr>
						</thead>
						
					
						<tbody>
						

			
			
			
<%-- 							<c:forEach items="${Listresults}" var="list" varStatus="theCount"> --%>

		<c:forEach items="${userlistnames}" var="name" varStatus="count">
							
							
							
							<tr>
<%-- 								<td>${theCount.count}</td> --%>

								<td>${name}</td>
								
								
								<td><c:out value="${userlistsizes[count.index]}"></c:out>
								</td>
								
								<td>${userlistlikes}</td>
								<td>
								 
<!-- 								<input type="submit" name="OpenList" value="Open" class="btn btn-success btn-xs btn-block"/> Some text -->
<%-- 								 <input type="submit" name="DeleteList${theCount.count}" value="Delete" class="btn btn-danger btn-xs btn-block"/> --%>
<!-- 								<div   class="btn btn-success btn-xs btn-block"> Delete </div> -->
								<button name="id" type="submit" value="${userlistids[count.index]}" class="btn btn-success btn-xs btn-block">Open</button>
								</td>
															</tr>
								
													</c:forEach>
						
<%-- 									</c:forEach>	 --%>

						</tbody>
						
					</table>
						  	     								</form>
					
					
					<c:if test="${empty userlists}">
					<div class="alert alert-info" role="alert">
  <a class="alert-link" style="text-align: right;text-decoration: none;">You have no word lists.</a> <a  href="CreateNewWordList.jsp" >(click to create one)</a>
</div>

</c:if>

					
					

                 
                 
                 
                 
                 
                                       
                   
                </div>
                
                
                
                
                
            </div>
	  	     
	  	     
	  	     
	  	     </div>
	  	     
	  	     
	  	     
	  	     
	  	     
<%-- 		   											<c:if test="${null != quotelists}"> --%>
		     
	   <div class="panel with-nav-tabs panel-default" style="width: 100 px;">
                <div class="panel-heading">
                            <h3> Quote Lists <img class="lists" src="img/quotes2.png"></h3>

                </div>
	                  <div class="panel-body">
                    <div class="tab-content">
                   	<form method="get" action="OpenQuoteListServlet">           
                 
                 		                 
                             				<table class="table table-hover" id="dev-table">
						<thead>
							<tr>
							
								<th>List Name</th>
								<th>List Size</th>
								
								<th>likes</th>
								<th> </th>
						
							</tr>
						</thead>
						
					
						<tbody>
						



	  <c:forEach items="${userquotelistnames}" var="name" varStatus="count2">
							
							<tr>

								<td>${name}</td>
			
								
								<td>	<c:out value="${userquotelistsizes[count.index]}"></c:out>
								</td>
								
								<td>${userquotelistlikes[count.index]}</td>
								<td>

	<button name="id" type="submit" value="${userquotelistids[count.index]}" class="btn btn-success btn-xs btn-block">Open</button>
								</td>
															</tr>
								
													</c:forEach>
						

						</tbody>
						
					</table>
					</form>
                 
                 					<c:if test="${empty quotelists}">
					<div class="alert alert-info" role="alert">
<!--   <a href="CreateNewList.jsp" class="alert-link" style="text-align: right;">You have no quote lists.</a> <small>(click to create one)</small> -->
    <a class="alert-link" style="text-align: right;text-decoration: none;">You have no quote lists.</a> <a  data-toggle="modal" data-target="#CreateQuoteList" >(click to create one)</a>
  
</div>

</c:if>
                 
                 
                                       
                   
                </div>
                
                
                
                
                
            </div>
	  	     
	  	     
	  	     
	  	     </div>
<%-- 	  	     													</c:if> --%>
	  	     
	  <form action="CreateQuoteList" method="get">
<!-- Modal -->
<div id="CreateQuoteList" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">How many quotes? </h4>
      </div>
      
      <div class="modal-body">
 	<textarea rows="5" cols="5" style="width: 100%;" name="size" contenteditable="true" placeholder="say size"></textarea>
      </div>
      <div class="modal-footer">
        <input type="submit" value="Save">
      </div>
    </div>
  </div>
</div> 
</form> 
	  
    
    
    
      
            
            
<hr/>










<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>

            
            
            
            
        </div>
  

 




</div>





	<!--  COVER -->
          <form method="post" enctype="multipart/form-data" action="../UploadFileCover">

		<!--  COVER Modal -->
		<div id="myModal2" class="modal fade" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Change cover photo?</h4>
					</div>
					<div class="modal-body">


		<div style="width: 100%;">	
		<a target='_blank' href="${imgCover}">Link to image</a>			
 <img style="margin: 0 auto;" class="img-responsive" src="${coverImg}" >

<br>



    <div class="container">

	<strong>From local device</strong>
      <input type="file" name="file"/>
      <br>
  <strong>Or URL link</strong><small> (.gif format accepted too!)</small> 
   <br>
      <input style="width: 35%" name="imgURL" placeholder="image url: //www.images.com/image.jpg">
      

      </div>
      </div>
      
      

					</div>
					<div class="modal-footer">
						<!--       	<button ><i class="fa fa-clipboard" aria-hidden="true"></i></button> -->
						<button type="button"
							class="btn btn-danger glyphicon glyphicon-remove"
							data-dismiss="modal"></button>
						<button type="submit"
							class="btn btn-success glyphicon glyphicon-floppy-disk"></button>
					</div>
				</div>

			</div>
		</div>

	</form>


	<!--  PROFILE MODEL -->
                   <form method="post" enctype="multipart/form-data" action="../UploadFileProfile">

		<!-- PROFILE -->
		<div id="myModal1" class="modal fade" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Change profile photo?</h4>
					</div>
					<div class="modal-body">
					
		<div style="width: 100%;">	
		<a target='_blank' href="${imgProfile}">Link to image</a>		
 <img style="margin: 0 auto;" class="img-responsive" src="${profileImg}" >


<br>

    <div class="container">

	<strong>From local device</strong>
      <input type="file" name="file"/>
      <br>
  <strong>Or URL link</strong><small> (.gif format accepted too!)</small> 
   <br>
      <input style="width: 35%" name="imgURL" placeholder="image url: //www.images.com/image.jpg">
      

      </div>
				</div>	
					</div>
					<div class="modal-footer">
						<!--       	<button ><i class="fa fa-clipboard" aria-hidden="true"></i></button> -->
						<button type="button"
							class="btn btn-danger glyphicon glyphicon-remove"
							data-dismiss="modal"></button>
						<button type="submit"
							class="btn btn-success glyphicon glyphicon-floppy-disk"></button>
					</div>
				</div>

			</div>
		</div>


	</form>







<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>



	

<jsp:include flush="true" page="includes/include_footer.jsp"></jsp:include>