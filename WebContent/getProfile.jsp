<jsp:include flush="true" page="/includes/include_header.jsp"></jsp:include>
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









var likes=0, dislikes=0;

//Functions to increase likes and immediately calculate bar widths
function like(){
	likes++;
	calculateBar();
}
function dislike(){
	dislikes++;
	calculateBar();
}

//Calculates bar widths
function calculateBar(){
	var total= likes+dislikes;
  //Simple math to calculate percentages
	var percentageLikes=(likes/total)*100;
	var percentageDislikes=(dislikes/total)*100;

  //We need to apply the widths to our elements
	document.getElementById('likes').style.width=percentageLikes.toString()+"%";
	document.getElementById('dislikes').style.width=percentageDislikes.toString()+"%";
  
  //We add the numbers on the buttons, just to show how to
  document.getElementById('likeButton').value=" " + likes.toString();
  document.getElementById('dislikeButton').value=" " + dislikes.toString();

}

calculateBar();


</script>
<!--                         <style>$.fn.editable.defaults.mode = 'inline';</style> -->
		<style>
		
		
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





             <img align="left" class="fb-image-lg" src="${SelectedUsercoverImg}" >
           

         






   <img align="left" style="position: absolute;display: block;" class="fb-image-profile" src="${SelectedUserprofileImg}">




         
         
         
         

        
        
        
        
      
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

	  <h1>${SelectedUserloggedInUser}   </h1>
	     <h2><i class="fa fa-diamond" aria-hidden="true"></i> ${SelectedUsereros} Eros</h2>
  
    <h3><a href="#">RANK</a>: ${SelectedUserSelectedUserRank}</h3>
    <hr/>
            <h4> Joined:  ${creationTime}</h4>

	  
          


						</div>
						
						











                    
                        <div class="tab-pane fade in" id="tab2default">
                        
                        
					
									       
                      <h3><textarea style="overflow:hidden;height:100px;width:100%;border: 0px;background-color:white;" class="input xlarge" name="Ptitle" disabled>${SelectedUserusertitleresults}</textarea></h3>  
                  
<textarea id="textarea-container" style="resize:vertical;height:300px;width:100%;border: 0px;overflow:hidden;background-color:white;" class="input xlarge" name="Pbody" disabled>${SelectedUseruserbodyresults}</textarea>

   
   
   
	  
          


						</div>
						
						















					
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
                    
                    <c:forEach items="${SelectedUsersavedwords}" var="savedwordsvar">
             <li class="list-group-item">${SelectedUsersavedwordsvar}</li>
					</c:forEach>

                      </div>
                      
                        
                 
                 
                 
                 
                                       
                   
                </div>
                
                
                
                
                
            </div>
	  	     
	  	     
	  	     
	  	     </div>
	  
	  <div class="panel with-nav-tabs panel-default" style="width: 100 px;">
                <div class="panel-heading">
<!--                         <ul class="nav nav-tabs"> </li><li class="active">-->
                            <h4> Recent Search History</h4>
<!--                             <li><a href="#tab2default" data-toggle="tab">More info </a></li> -->

<!--                         </ul> -->
                </div>
	                  <div class="panel-body">
                    <div class="tab-content">
                    <div class="list-group">
                    
                                        <c:forEach items="${SelectedUsersearchhistory}" var="searchhistoryword">
                    
             <a class="list-group-item">${SelectedUsersearchhistoryword}</a>
             					</c:forEach>
             
                      </div>
                      
              
                </div>
                
                
                
                
                
            </div>
            </div>
	  
	  

	  
	  </div>
	  </div>
	  <div class="col-md-4">
	
	  
	  <div class="row">
	  			<div class="col-md-12">
	  			
	  			
	  
	  </div>
	  </div>
	  
	  
	  
	 <div class="row">





<c:forEach items="${SidFeedArray}" var="posts" varStatus="count">




		<c:set var="type" scope="session" value="${StypeFeedArray[count.index]}" />
<%-- 	<c:set var="wordtestarray" scope="session" value="${WordOrQuotePost[count.index]}" /> --%>

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
													<span class="glyphicon glyphicon-trash"></span> Delete <c:out value="${SidFeedArray[count.index]}"/>
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
											${SWordOrQuotePost[count.index]}?</h4>
									</div>
									<!--       <div class="modal-body"> -->
									<!--         <p>One fine body</p> -->
									<!--       </div> -->
									<div class="modal-footer">
										<form action="UserPostMenu" method="post">

											<button type="button" class="btn btn-default"
												data-dismiss="modal">No, changed my mind.</button>
											<!--         <button type="button" class="btn btn-danger" type="submit" >Yes, delete this list.</button> -->
											<input type="submit" name="action" value="Yes, delete this post." class="btn btn-danger">
												 <input hidden="true" name="deleteword" value="${SWordOrQuotePost[count.index]}">
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



							<span><img class="userposts" src="img/bird.jpg">
								${Suserpost[count.index]} </span>
						</h3>
						<small><a href="#" class="caption" style="padding-left: 50px; color: inherit; position: absolute; top: 60px;">${Stimepost[count.index]}</a></small>
						<br>
<p>test writing here </p>
<img class="resize" src="${Simagepost[count.index]}" style="max-width: 430px;"/> 

						<textarea contenteditable="true"
							style="overflow: hidden; height: 50px; width: 100%; border: 0px;margin-bottom: -10px;"
							class="input xlarge lead" name="usertext">${SDefinitionOrAuthorPost[count.index]}</textarea>

						<%-- 						<div class="lead" style="margin-bottom: 0px;">${UserWordPostUserText[count.index]}</div> --%>

						<font
							size="40"><a>${SWordOrQuotePost[count.index]}</a></font>
						<p class="well">${Susertextpost[count.index]}</p>
						<hr />
					</div>

					<div class="container">

						<span class="glyphicon glyphicon-thumbs-up"></span>
						<button type="button" class="btn btn-link">Like</button>
						<span class="glyphicon glyphicon-comment"></span>
						<button type="button" class="btn btn-link">Comment</button>
						<span class="glyphicon glyphicon-share-alt"></span>
						<button type="button" class="btn btn-link">SAVE</button>



					</div>
					<div>
<!-- 						<div class="jumbotron">Box showing show likes it</div> -->
						<ul class="list-group">

    <c:forEach items="${Sarrayception[count.index]}" var="comment" varStatus="count2">
     <li class="list-group-item">${Scomment}</li>
     	</c:forEach>

<%-- <li class="list-group-item"><p><img src="${profileImg}" class="resizeUserImgComment">${loggedInUser}: Cool lol test 1</p> --%>
<!-- </li> -->

      
</ul>




<%-- <c:forEach items="${userlists}" var="userlistsvar" varStatus="count"> --%>
							

<%-- 								<td>${userlistsvar}</td> --%>
								

<%-- 													</c:forEach> --%>











					</div>


					<!-- <div class="container" style="padding-bottom: 10px;"> -->

					<!-- <div class="pull-left"> -->

					<!--        <img class="resizeUser" src="img/0072.jpg"> -->
					<!--       </div> -->

					<!--       <span><a>Generic user</a> This is a random comment about something random so to fill up this space. </span> -->
					<!--       <div style="padding-left: 45px;"> -->
					<!-- 		<a>Like   </a> <a style="padding-left: 15px;">    Reply</a> -->
					<!-- 		</div> -->
					<!-- </div> -->


					<div class="container">


<form action="AddComment" method="post">
						<div class="input-group">

							<div class="pull-right">
							
							<input name="postID" value="${SwordorquotepostID[count.index]}" type="hidden">
								<input name="postUser" value="${Suserpost[count.index]}" type="hidden">
									<input name="type" value="${StypeFeedArray[count.index]}" type="hidden">
									
							
								<input name="comment" style="width: 100%; padding-left: 5px;" type="text"
									class="form-control" placeholder="Leave a comment...">
								<span class="input-group-btn">
									<button class="btn btn-secondary" type="submit">Enter</button>
								</span>
							</div>
							<div class="pull-left">

								<img class="resizeUser" src="img/bird.jpg">
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

							<form action="UserPostMenu" method="post">

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
							</form>
						</div>



						<div id="myModal" class="modal fade">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<!--         <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button> -->
										
										
										
										
										<h4 class="modal-title">Delete post
											${SWordOrQuotePost[count.index]}?</h4>
									</div>
									<!--       <div class="modal-body"> -->
									<!--         <p>One fine body</p> -->
									<!--       </div> -->
									<div class="modal-footer">
										<form action="UserPostMenu" method="post">

											<button type="button" class="btn btn-default"
												data-dismiss="modal">No, changed my mind.</button>
											<!--         <button type="button" class="btn btn-danger" type="submit" >Yes, delete this list.</button> -->
											<input type="submit" value="Yes, delete this post."
												id="files" name="file" class="btn btn-danger"> 
										
															 <input hidden="true" name="deleteword" value="${idFeedArray[count.index]}">
												 <input hidden="true" name="deletetype" value="q">
										</form>

									</div>
								</div>
								<!-- /.modal-content -->
							</div>
							<!-- /.modal-dialog -->
						</div>
						<!-- /.modal -->





						<h3 class="caption" style="margin-bottom: 0px; padding-bottom: 0px;">



							<span><img class="userposts" src="img/bird.jpg"/>
								${userpost[count.index]} </span>
						</h3>
						<small><a href="#" class="caption" style="padding-left: 50px; color: inherit; position: absolute; top: 60px;">${timepost[count.index]}</a></small>
						<br>
						<img class="resize" src="${imagepost[count.index]}" style="max-width: 430px;"/> 

<!-- <h3></h3> -->
<!-- <blockquote cite="#"> -->
<p>usertext: ${DefinitionOrAuthorPost[count.index]}</p>

<p>userpost: ${WordOrQuotePost[count.index]} - </p>





						<hr />
					</div>

					<div class="container">

						<span class="glyphicon glyphicon-thumbs-up"></span>
						<button type="button" class="btn btn-link">Like</button>
						<span class="glyphicon glyphicon-comment"></span>
						<button type="button" class="btn btn-link">Comment</button>
						<span class="glyphicon glyphicon-share-alt"></span>
						<button type="button" class="btn btn-link">SAVE</button>



					</div>
					<div>
						<div class="jumbotron">Box showing show likes it</div>
					</div>


					<!-- <div class="container" style="padding-bottom: 10px;"> -->

					<!-- <div class="pull-left"> -->

					<!--        <img class="resizeUser" src="img/0072.jpg"> -->
					<!--       </div> -->

					<!--       <span><a>Generic user</a> This is a random comment about something random so to fill up this space. </span> -->
					<!--       <div style="padding-left: 45px;"> -->
					<!-- 		<a>Like   </a> <a style="padding-left: 15px;">    Reply</a> -->
					<!-- 		</div> -->
					<!-- </div> -->


					<div class="container">



						<div class="input-group">

							<div class="pull-right">
									class="form-control" placeholder="Leave a comment...">
								<span class="input-group-btn">
									<button class="btn btn-secondary" type="button">Enter</button>
								</span>
							</div>
							<div class="pull-left">

								<img class="resizeUser" src="img/bird.jpg">
							</div>


						</div>


					</div>






				</div>
			</div>















































		</c:if>

























	</c:forEach>






		</div>



	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
<!-- 	  </div> -->
	  </div>
	  <div class="col-md-3" >
<!-- 	  	     <div class="jumbotron"> -->
	  	     
	  	     
	  	     
	  	     
	  	    
	  	     
<!-- 	  	     <div class="panel with-nav-tabs panel-default" style="width: 100 px;"> -->
<!--                 <div class="panel-heading"> -->
<!--                             <h4>Shards <img class="shard" src="img/crashshard2mult.png"> </h4> -->

<!--                 </div> -->
<!-- 	                  <div class="panel-body"> -->
<!--                     <div class="tab-content"> -->

                 
                 
                                       
                   
<!--                 </div> -->
	  	     
	  	     
	  	     
	  	     
	  	     
	  	     
	  	     
	  	     
<!--            </div> -->
	  
<!-- 	   <div class="col-md-1" > -->
<!--            </div> -->
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
<!-- 	 </div> -->
	  	     
	  	     
	  	     
	  	     														<form method="get" action="OpenListServlet">           
	  	     
	   			<div class="panel with-nav-tabs panel-default" style="width: 100 px;">
                <div class="panel-heading">
<!--                         <ul class="nav nav-tabs"> </li><li class="active">-->
                            <h3>Word Lists <img class="lists" src="img/lists.png"> </h3>
<!--                             <li><a href="#tab2default" data-toggle="tab">More info </a></li> -->

<!--                         </ul> -->
                </div>
	                  <div class="panel-body">
                    <div class="tab-content">
                 
                 
                 
                 
                 
                 
<%--                       <c:forEach items="${savedwords}" var="savedwordsvar"> --%>
<%--              <a class="list-group-item">${savedwordsvar}</a> --%>
<%-- 					</c:forEach> --%>
                 
                 
                 
                 
                 
                 
                 
                 				<table class="table table-hover" id="dev-table">
						<thead>
							<tr>
							
								<th>List Name</th>
								<th>List Size</th>
								
								<th>likes | dislikes</th>
								<th> </th>
						
							</tr>
						</thead>
						
					
						<tbody>
						

			
			
			
<%-- 							<c:forEach items="${Listresults}" var="list" varStatus="theCount"> --%>

							                      <c:forEach items="${SelectedUseruserlists}" var="userlistsvar" varStatus="count">
							
							<tr>
<%-- 								<td>${theCount.count}</td> --%>

								<td>${userlistsvar}</td>
								
								
								<td>														<c:out value="${SelectedUserlistsizes[count.index]}"></c:out>
								</td>
								
								<td>Likes and dislikes</td>
								<td>
								 
<!-- 								<input type="submit" name="OpenList" value="Open" class="btn btn-success btn-xs btn-block"/> Some text -->
<%-- 								 <input type="submit" name="DeleteList${theCount.count}" value="Delete" class="btn btn-danger btn-xs btn-block"/> --%>
<!-- 								<div   class="btn btn-success btn-xs btn-block"> Delete </div> -->
								<button name="OpenList" type="submit" value="${userlistsvar}" class="btn btn-success btn-xs btn-block">Open</button>
								</td>
															</tr>
								
													</c:forEach>
						
<%-- 									</c:forEach>	 --%>

						</tbody>
						
					</table>
					


					
					

                 
                 
                 
                 
                 
                                       
                   
                </div>
                
                
                
                
                
            </div>
	  	     
	  	     
	  	     
	  	     </div>
	  	     
	  	     								</form>
	  	     
	  	     
	  	     
	  	     
	  	      				     
	   

   
    	  
<!-- 	  <div class="row"> -->
<!-- 	  			<div class="col-md-12"> -->
	  			
	  				     
	   <div class="panel with-nav-tabs panel-default" style="width: 100 px;">
                <div class="panel-heading">
<!--                         <ul class="nav nav-tabs"> </li><li class="active">-->
                            <h3> Quote Lists <img class="lists" src="img/lists.png"></h3>
<!--                             <li><a href="#tab2default" data-toggle="tab">More info </a></li> -->

<!--                         </ul> -->
                </div>
	                  <div class="panel-body">
                    <div class="tab-content">
                 
                 		                 
                             				<table class="table table-hover" id="dev-table">
						<thead>
							<tr>
							
								<th>List Name</th>
								<th>List Size</th>
								
								<th>likes | dislikes</th>
								<th> </th>
						
							</tr>
						</thead>
						
					
						<tbody>
						


							                      <c:forEach items="${userquotelists}" var="userquotelistsvar" varStatus="count">
							
							<tr>

								<td>${userquotelistsvar}</td>
								
								
								<td>														<c:out value="${quotelistsizes[count.index]}"></c:out>
								</td>
								
								<td>Likes and dislikes</td>
								<td>

								<button name="OpenList" type="submit" value="${userquotelistsvar}" class="btn btn-success btn-xs btn-block">Open</button>
								</td>
															</tr>
								
													</c:forEach>
						

						</tbody>
						
					</table>
                 

                 
                 
                                       
                   
                </div>
                
                
                
                
                
            </div>
	  	     
	  	     
	  	     
	  	     </div>
	  
<!-- 	  </div> -->
<!-- 	  </div> -->
	  
    
    
    
      
            
            
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











<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>



	

<jsp:include flush="true" page="/includes/include_footer.jsp"></jsp:include>