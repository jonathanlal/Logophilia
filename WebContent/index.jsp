<jsp:include flush="true" page="includes/include_header.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



<style>

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

#pinBoot {
  position: relative;
  max-width: 100%;
  width: 100%;
}
img.word {
  width: 100%;
  max-width: 100%;
  height: auto;
}
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














<div class="container" style="margin-right:0; margin-left: 0;width: 99%">

<div class="row">

     <div class="col-md-3">
         
      <div class="jumbotron">
      <h2>${date}</h2>
      <h3 style="text-align: center;">Todays word:</h3>
<!--  <div class="container"> -->
     
 <br/>

     
<!--      <form class="btn-group btn-lg" method="get" action="UserControlServlet"> -->
     
     <h3><Strong>${dailyword}</Strong></h3>
     
     <h5>${dailyworddefinitions}</h5>
     
<!-- <a class="btn btn-default btn-block" href="DefineWord.jsp">Todays Word</a> -->


<!-- <!--  <input type="submit" name="button1" value="WordLists" class="btn btn-default btn-block"/> -->
<!-- <a class="btn btn-default btn-block" href="WordListIndex.jsp">Word Lists</a> -->



<!-- <button type="submit" class="btn btn-default btn-block ">Daily Word</button> -->
<!-- <a class="btn btn-default btn-block" href="GamesMenu.jsp">Games</a> -->

<!-- <button type="submit" class="btn btn-default btn-block">LeaderBoard?</button> -->
<!-- <button type="submit" class="btn btn-default btn-block">Saved Words</button> -->
<!-- <button type="submit" class="btn btn-default btn-block disabled">MAKE MONEY</button> -->
<!-- <button type="submit" class="btn btn-default btn-block disabled">SUBMIT ARTICLE</button> -->
<!-- </form> -->
     
     

     <br/>
     
     
<!--     </div> -->
</div>

      <div class="jumbotron">
     LISTS
     MOST LIKED?
     Most Liked Word Post From Yesterday?
     
     
      </div>
     
     
	</div>
	
	


   <div class="col-md-9">
   
<!--    <div class="pull-left" style="padding-left: 5px;padding-top: 5px;"> -->
<!--              <a id="addToWordList" data-toggle="collapse" href="UserProfile.jsp" class="btn btn-default" role="button"><small><i class="material-icons">add</i></small></a> -->
            
          
<!--             </div> -->
 <div class="jumbotron" style="margin:0;">
<!--  <div class="container"> -->
 <br>
<!--   <h3 style="text-align: center;">Word Posts</h3> -->

<!-- <div class="container"> -->
<!--   <div class="row"> -->

    <section id="pinBoot">

<%-- <div>${resultsArray}</div> --%>
						
<c:forEach items="${indexWordPostsArray}" var="wordposts" varStatus="count">

      <article class="white-panel"> <img class="word" src="${indexWordPostImageArray[count.index]}" alt="">
        <h3><a href="#" data-toggle="tooltip" data-placement="right" title="${indexWordPostTimeArray[count.index]}">${indexWordPostWordArray[count.index]}</a></h3>
        <h5>${indexWordPostUserTextArray[count.index]}</h5>
        <div>
        
        												<ul class="list-group">

    <c:forEach items="${indexWordPostDefinitionArray[count.index]}" var="def" varStatus="count2">
     <li class="list-group-item">${def}</li>
     	</c:forEach>

      
</ul>
        
        
<%--         Def: ${indexWordPostDefinitionArray[count.index]} --%>
        </div>
              <form action="AddLikeIndex" method="post">
        
<!--       <span class="pull-right"> -->
      

        
        <input name="postUser" value="${indexWordPostUserArray[count.index]}" type="hidden">
        
      <input name="id" value="${indexwordpostID[count.index]}" type="hidden">
      <input name="count" value="${indexwordpostlikesSize[count.index]}" type="hidden">
      
      <button style="padding-right: 0px;" type="submit" class="btn btn-link pull-right"><small><span class="glyphicon glyphicon-thumbs-up"></span> ${indexwordpostlikesSize[count.index]}</small></button>
      
         			</form>
      
      
      
<!--        <button style="padding-right: 0px;" type="button" class="btn btn-link"><small><span class="glyphicon glyphicon-thumbs-down"></span> 0</small></button> -->
        
        <button  data-toggle="modal" data-target="#myModal${count.index}" style="padding-right: 0px;" type="button" class="btn btn-link pull-right"><small><span class="glyphicon glyphicon-comment"></span> ${indexwordpostComments[count.index]}</small></button>
                
        
























		<!--  COMMENTS Modal -->
		<div id="myModal${count.index}" class="modal fade" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">${indexWordPostWordArray[count.index]}</h4>
					</div>
					<div class="modal-body">

<img class="word" src="${indexWordPostImageArray[count.index]}" alt="">
 <p>  <strong>${indexWordPostUserArray[count.index]}:</strong>  <span>${indexWordPostUserTextArray[count.index]}</span></p>

<div class="jumbotron">
        												<ul class="list-group">

    <c:forEach items="${indexWordPostDefinitionArray[count.index]}" var="def" varStatus="count2">
     <li class="list-group-item">${def}</li>
     	</c:forEach>

      
</ul>
</div>
          <form method="post" action="AddCommentIndex">

						<ul class="list-group">
						
						

    <c:forEach items="${arrayception[count.index]}" var="comment" varStatus="count2">
     <li class="list-group-item">${comment}</li>
     	</c:forEach>

<li class="list-group-item">

<!-- <form action="AddComment" method="post"> -->
						<div class="input-group">

							<div class="pull-right">
							
							<input name="postID" value="${indexwordpostID[count.index]}" type="hidden">
								<input name="postUser" value="${indexWordPostUserArray[count.index]}" type="hidden">
									<input name="type" value="w" type="hidden">
									
							
								<input name="comment" style="width: 80%; padding-left: 5px;" type="text"
									class="form-control" placeholder="Leave a comment...">
								<span class="input-group-btn pull-right">
									<button class="btn btn-secondary" type="submit">Enter</button>
								</span>
							</div>
							<div class="pull-left">

								<img class="resizeUser" src="${profileImg}">
							</div>


						</div>
<!-- </form> -->

</li>
      
</ul>
     	</form>

<!-- <hr> -->

      
      

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













<!--  LIKES Modal -->
		<div id="myLikesModal${count.index}" class="modal fade" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">${indexWordPostWordArray[count.index]}</h4>
					</div>
					<div class="modal-body">

<img class="word" src="${indexWordPostImageArray[count.index]}" alt="">
 <p>  <strong>${indexWordPostUserArray[count.index]}:</strong>  <span>${indexWordPostUserTextArray[count.index]}</span></p>


        												<ul class="list-group">

    <c:forEach items="${indexWordPostDefinitionArray[count.index]}" var="def" varStatus="count2">
     <li class="list-group-item">${def}</li>
     	</c:forEach>

      
</ul>

						<ul class="list-group">
						
						

    <c:forEach items="${arrayception[count.index]}" var="comment" varStatus="count2">
     <li class="list-group-item">${comment}</li>
     	</c:forEach>

      
</ul>
      
      

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





















             <span class="pull-left">  
        <button type="button" class="btn btn-link">${indexWordPostUserArray[count.index]} </button>
        </span>
      </article>


</c:forEach>



<!--       <article class="white-panel"><img class="word" src="http://i.imgur.com/sDLIAZD.png" alt=""> -->
<!--         <h4><a href="#">Title 1</a></h4> -->
<!--         <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute -->
<!--           irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p> -->
<!--       </article> -->


<!--       <article class="white-panel"> <img class="word" src="http://i.imgur.com/xOIMvAe.jpg" alt=""> -->
<!--         <h4><a href="#">Title 3</a></h4> -->
<!--         <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute -->
<!--           irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p> -->
<!--       </article> -->


<!--       <article class="white-panel"> <img class="word" src="http://i.imgur.com/3gXW3L3.jpg" alt=""> -->
<!--         <h4><a href="#">Title 4</a></h4> -->
<!--         <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute -->
<!--           irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p> -->
<!--       </article> -->

<!--       <article class="white-panel"> <img class="word" src="http://i.imgur.com/o2RVMqm.jpg" alt=""> -->
<!--         <h4><a href="#">Title 5</a></h4> -->
<!--         <p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p> -->
<!--       </article> -->

<!--       <article class="white-panel"> <img class="word" src="http://i.imgur.com/kFFpuKA.jpg" alt=""> -->
<!--         <h4><a href="#">Title 6</a></h4> -->
<!--         <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute -->
<!--           irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p> -->
<!--       </article> -->



<!--       <article class="white-panel"><img class="word" src="http://i.imgur.com/E9RmLPA.jpg" alt=""> -->
<!--         <h4><a href="#">Title 7</a></h4> -->
<!--         <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute -->
<!--           irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p> -->
<!--       </article> -->

<!--       <article class="white-panel"> <img class="word" src="http://i.imgur.com/8lhFhc1.gif" alt=""> -->
<!--         <h4><a href="#">Title 8</a></h4> -->
<!--         <p>Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p> -->
<!--       </article> -->

    </section>


    <hr>


<!--   </div> -->
  <p>
    <br>
    <br>

  </p>

<!-- </div> -->































<!-- </div> -->

</div>
</div>






<!--      <div class="col-md-1"> -->
<!--       <div class="jumbotron"> -->
<!--      </div> -->
<!--      </div> -->
<!--      		 <div class="pull-right" style="padding-right: 5px;padding-top: 5px;"> -->
            
            
<!-- 			 <a id="addToWordList" data-toggle="collapse" href="#collapse5" class="btn btn-default" role="button"><small><i class="material-icons">loop</i></small></a> -->
<!--             <a id="addToWordList" data-toggle="collapse" href="#collapse5" class="btn btn-default" role="button"><small><i class="material-icons">trending_up</i></small></a> -->
<!--             <a id="addToWordList" data-toggle="collapse" href="#collapse5" class="btn btn-default btn-xl" role="button"><small><i class="glyphicon glyphicon-fire"></i></small></a> -->
<!--             </div> -->
            
<!--             <div class="pull-left" style="padding-left: 5px;padding-top: 5px;"> -->
<!--              <a id="addToWordList" data-toggle="collapse" href="#collapse5" class="btn btn-default" role="button"><small><i class="material-icons">add</i></small></a> -->
            
          
<!--             </div> -->
     
     
<!--       <div class="jumbotron"> -->
<!--         <h3 style="text-align: center;">Shards</h3> -->
      
      
      
             
<!--              <br/> -->
             
             
             
             
<!--  <form class="container">	 -->
<!--      		<div class="media"> -->
<!--   <a class="media-left" href="#"> -->
<!--     <img class="media-object" data-src="..." alt="Generic placeholder image"> -->
<!--   </a> -->
<!--   <div class="media-body"> -->
<!--     <h4 class="media-heading">Media heading</h4> -->
<!--     Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus. -->
 
 
<!--    <br/> -->
 
 
 
<!--  <div class="pull-right" style="padding-right: 40px;"> -->
<!--  	 <a id="addToWordList" data-toggle="collapse" href="#collapse5" class="btn btn-default btn-sm" role="button">  -->
<!--  	 <small><i class="glyphicon glyphicon-heart"></i></small></a> -->
 	 
<!--  	 <a id="addToWordList" data-toggle="collapse" href="#collapse5" class="btn btn-default btn-sm" role="button">  -->
<!--  	 <small><i class="glyphicon glyphicon-thumbs-up"></i></small></a> -->
 	 
<!--  	 <a id="addToWordList" data-toggle="collapse" href="#collapse5" class="btn btn-default btn-sm" role="button">  -->
<!--  	 <small><i class="glyphicon glyphicon-thumbs-down"></i></small></a> -->
 	 
<!--  	  	 <a id="addToWordList" data-toggle="collapse" href="#collapse5" class="btn btn-default btn-sm" role="button">  -->
<!--  	 <small><i class="glyphicon glyphicon-comment"></i></small></a> -->
 	 
 	 
<!--  	 </div> -->
<!--  	   <br/> -->
<!--  	  <p class="by-author">By Jhon Doe </p>  -->
 	 
<!--  </div> -->
<!-- </div>  -->



<!-- <div class="row"> -->
<!--   <div class="span8"> -->
<!--     <div class="row"> -->
<!--       <div class="span8"> -->
<!--         <h4><strong><a href="#">Title of the post</a></strong></h4> -->
<!--       </div> -->
<!--     </div> -->
<!--     <div class="row"> -->
<!--       <div class="span2"> -->
<!--         <a href="#" class="thumbnail"> -->
<!--             <img src="http://placehold.it/260x180" alt=""> -->
<!--         </a> -->
<!--       </div> -->
<!--       <div class="span6">       -->
<!--         <p> -->
<!--           Lorem ipsum dolor sit amet, id nec conceptam conclusionemque. Et eam tation option. Utinam salutatus ex eum. Ne mea dicit tibique facilisi, ea mei omittam explicari conclusionemque, ad nobis propriae quaerendum sea. -->
<!--         </p> -->
<!--         <p><a class="btn" href="#">Read more</a></p> -->
<!--       </div> -->
<!--     </div> -->
<!--     <div class="row"> -->
<!--       <div class="span8"> -->
<!--         <p></p> -->
<!--         <p> -->
<!--           <i class="icon-user"></i> by <a href="#">John</a>  -->
<!--           | <i class="icon-calendar"></i> Sept 16th, 2012 -->
<!--           | <i class="icon-comment"></i> <a href="#">3 Comments</a> -->
<!--           | <i class="icon-share"></i> <a href="#">39 Shares</a> -->
<!--           | <i class="icon-tags"></i> Tags : <a href="#"><span class="label label-info">Snipp</span></a>  -->
<!--           <a href="#"><span class="label label-info">Bootstrap</span></a>  -->
<!--           <a href="#"><span class="label label-info">UI</span></a>  -->
<!--           <a href="#"><span class="label label-info">growth</span></a> -->
<!--         </p> -->
<!--       </div> -->
<!--     </div> -->
<!--   </div> -->
<!-- </div> -->
<!-- <hr> -->

<!-- <div class="row"> -->
<!--   <div class="span8"> -->
<!--     <div class="row"> -->
<!--       <div class="span8"> -->
<!--         <h4><strong><a href="#">Title of the post</a></strong></h4> -->
<!--       </div> -->
<!--     </div> -->
<!--     <div class="row"> -->
<!--       <div class="span2"> -->
<!--         <a href="#" class="thumbnail"> -->
<!--             <img src="http://placehold.it/260x180" alt=""> -->
<!--         </a> -->
<!--       </div> -->
<!--       <div class="span6">       -->
<!--         <p> -->
<!--           Lorem ipsum dolor sit amet, id nec conceptam conclusionemque. Et eam tation option. Utinam salutatus ex eum. Ne mea dicit tibique facilisi, ea mei omittam explicari conclusionemque, ad nobis propriae quaerendum sea. -->
<!--         </p> -->
<!--       </div> -->
<!--     </div> -->
<!--     <div class="row"> -->
<!--       <div class="span8"> -->
<!--         <p></p> -->
<!--         <p> -->
<!--           <i class="icon-user"></i> by <a href="#">Mark</a>  -->
<!--           | <i class="icon-calendar"></i> Sept 16th, 2012 -->
<!--           | <i class="icon-comment"></i> <a href="#">3 Comments</a> -->
<!--           | <i class="icon-share"></i> <a href="#">39 Shares</a> -->
<!--           | <i class="icon-tags"></i> Tags : <a href="#"><span class="label label-info">Snipp</span></a>  -->
<!--           <a href="#"><span class="label label-info">Bootstrap</span></a>  -->
<!--           <a href="#"><span class="label label-info">UI</span></a>  -->
<!--           <a href="#"><span class="label label-info">growth</span></a> -->
<!--         </p> -->
<!--       </div> -->
<!--     </div> -->
<!--   </div> -->
<!-- </div> -->
<!-- <hr> -->

<!-- <div class="row"> -->
<!--   <div class="span8"> -->
<!--     <div class="row"> -->
<!--       <div class="span8"> -->
<!--         <h4><strong><a href="#">Title of the post</a></strong></h4> -->
<!--       </div> -->
<!--     </div> -->
<!--     <div class="row"> -->
<!--       <div class="span2"> -->
<!--         <a href="#" class="thumbnail"> -->
<!--             <img src="http://placehold.it/260x180" alt=""> -->
<!--         </a> -->
<!--       </div> -->
<!--       <div class="span6">       -->
<!--         <p> -->
<!--           Lorem ipsum dolor sit amet, id nec conceptam conclusionemque. Et eam tation option. Utinam salutatus ex eum. Ne mea dicit tibique facilisi, ea mei omittam explicari conclusionemque, ad nobis propriae quaerendum sea. -->
<!--         </p> -->
<!--         <p><a href="#">Read more</a></p> -->
<!--       </div> -->
<!--     </div> -->
<!--     <div class="row"> -->
<!--       <div class="span8"> -->
<!--         <p></p> -->
<!--         <p> -->
<!--           <i class="icon-user"></i> by <a href="#">Mark</a>  -->
<!--           | <i class="icon-calendar"></i> Sept 16th, 2012 -->
<!--           | <i class="icon-comment"></i> <a href="#">3 Comments</a> -->
<!--           | <i class="icon-share"></i> <a href="#">39 Shares</a> -->
<!--           | <i class="icon-tags"></i> Tags : <a href="#"><span class="label label-info">Snipp</span></a>  -->
<!--           <a href="#"><span class="label label-info">Bootstrap</span></a>  -->
<!--           <a href="#"><span class="label label-info">UI</span></a>  -->
<!--           <a href="#"><span class="label label-info">growth</span></a> -->
<!--         </p> -->
<!--       </div> -->
<!--     </div> -->
<!--   </div> -->
<!-- </div> -->
<!-- <hr> -->







<!--     </form> -->
<!--     <hr/> -->
    
        
    
    
    
    
    
    
    
    
    
    
    
    
    
<!-- </div> -->
     
<!-- 	</div> -->













<!-- ROW DIV -->
</div>


</div>







<script>

$(document).ready(function() {
	$('#pinBoot').pinterest_grid({
	no_columns: 3,
	padding_x: 10,
	padding_y: 10,
	margin_bottom: 50,
	single_column_breakpoint: 700
	});
	});

	/*
	Ref:
	Thanks to:
	http://www.jqueryscript.net/layout/Simple-jQuery-Plugin-To-Create-Pinterest-Style-Grid-Layout-Pinterest-Grid.html
	*/


	/*
	    Pinterest Grid Plugin
	    Copyright 2014 Mediademons
	    @author smm 16/04/2014

	    usage:

	     $(document).ready(function() {

	        $('#blog-landing').pinterest_grid({
	            no_columns: 4
	        });

	    });


	*/
	;(function ($, window, document, undefined) {
	    var pluginName = 'pinterest_grid',
	        defaults = {
	            padding_x: 10,
	            padding_y: 10,
	            no_columns: 3,
	            margin_bottom: 50,
	            single_column_breakpoint: 700
	        },
	        columns,
	        $article,
	        article_width;

	    function Plugin(element, options) {
	        this.element = element;
	        this.options = $.extend({}, defaults, options) ;
	        this._defaults = defaults;
	        this._name = pluginName;
	        this.init();
	    }

	    Plugin.prototype.init = function () {
	        var self = this,
	            resize_finish;

	        $(window).resize(function() {
	            clearTimeout(resize_finish);
	            resize_finish = setTimeout( function () {
	                self.make_layout_change(self);
	            }, 11);
	        });

	        self.make_layout_change(self);

	        setTimeout(function() {
	            $(window).resize();
	        }, 500);
	    };

	    Plugin.prototype.calculate = function (single_column_mode) {
	        var self = this,
	            tallest = 0,
	            row = 0,
	            $container = $(this.element),
	            container_width = $container.width();
	            $article = $(this.element).children();

	        if(single_column_mode === true) {
	            article_width = $container.width() - self.options.padding_x;
	        } else {
	            article_width = ($container.width() - self.options.padding_x * self.options.no_columns) / self.options.no_columns;
	        }

	        $article.each(function() {
	            $(this).css('width', article_width);
	        });

	        columns = self.options.no_columns;

	        $article.each(function(index) {
	            var current_column,
	                left_out = 0,
	                top = 0,
	                $this = $(this),
	                prevAll = $this.prevAll(),
	                tallest = 0;

	            if(single_column_mode === false) {
	                current_column = (index % columns);
	            } else {
	                current_column = 0;
	            }

	            for(var t = 0; t < columns; t++) {
	                $this.removeClass('c'+t);
	            }

	            if(index % columns === 0) {
	                row++;
	            }

	            $this.addClass('c' + current_column);
	            $this.addClass('r' + row);

	            prevAll.each(function(index) {
	                if($(this).hasClass('c' + current_column)) {
	                    top += $(this).outerHeight() + self.options.padding_y;
	                }
	            });

	            if(single_column_mode === true) {
	                left_out = 0;
	            } else {
	                left_out = (index % columns) * (article_width + self.options.padding_x);
	            }

	            $this.css({
	                'left': left_out,
	                'top' : top
	            });
	        });

	        this.tallest($container);
	        $(window).resize();
	    };

	    Plugin.prototype.tallest = function (_container) {
	        var column_heights = [],
	            largest = 0;

	        for(var z = 0; z < columns; z++) {
	            var temp_height = 0;
	            _container.find('.c'+z).each(function() {
	                temp_height += $(this).outerHeight();
	            });
	            column_heights[z] = temp_height;
	        }

	        largest = Math.max.apply(Math, column_heights);
	        _container.css('height', largest + (this.options.padding_y + this.options.margin_bottom));
	    };

	    Plugin.prototype.make_layout_change = function (_self) {
	        if($(window).width() < _self.options.single_column_breakpoint) {
	            _self.calculate(true);
	        } else {
	            _self.calculate(false);
	        }
	    };

	    $.fn[pluginName] = function (options) {
	        return this.each(function () {
	            if (!$.data(this, 'plugin_' + pluginName)) {
	                $.data(this, 'plugin_' + pluginName,
	                new Plugin(this, options));
	            }
	        });
	    }

	})(jQuery, window, document);



</script>











<jsp:include flush="true" page="includes/include_footer.jsp"></jsp:include>