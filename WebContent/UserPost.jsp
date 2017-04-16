<jsp:include flush="true" page="includes/include_header.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
 <link rel="stylesheet" href="//cdn.jsdelivr.net/bootstrap.tagsinput/0.4.2/bootstrap-tagsinput.css" />
<script src="//cdn.jsdelivr.net/bootstrap.tagsinput/0.4.2/bootstrap-tagsinput.min.js"></script>


<style>



img.resize{
   width:500px;
   display: block;
    margin-left: auto;
    margin-right: auto;
    margin-top: 20px;
   
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


</style>













<div class="row">

<div class="col-md-4">

</div>











								
								
								
								
								
<%-- 																											${UserWordPost[count.index]Word} --%>
																							















<div class="col-md-4">


<div class="row">


 <c:forEach items="${resultsPostsArray}" var="wordposts" varStatus="count">

<%-- <P>Results: ${wordposts}</P> --%>																					
			<div class="col-md-12">
				<div style="background:white; !important" class="jumbotron">
					<div class="container">
<!-- 					remove word posts its just for show -->
						<h3 class="caption">
							<span class="glyphicon glyphicon-user"></span> ${UserWordPostUser[count.index]}
						</h3>
						<h6 class="caption" style="padding-left: 40px;"><a href="">${UserWordPostTime[count.index]}</a></h6>

						<img class="resize"
							src="${UserWordPostImage[count.index]}">
						<div style="padding-top: 3px;">
							<input type="text" name="cities" class="form-control"
								value="Hanoi" data-role="tagsinput" />

						</div>
						<font size="40"><a>${UserWordPostWord[count.index]}</a></font>
						<p class="well">${UserWordPostDefinition[count.index]}</p>
						<hr />
					</div>


				<div class="container">
				
				<span class="glyphicon glyphicon-thumbs-up"></span><button type="button" class="btn btn-link">Like</button>
				<span class="glyphicon glyphicon-comment"></span><button type="button" class="btn btn-link">Comment</button>
				<span class="glyphicon glyphicon-share-alt"></span><button type="button" class="btn btn-link">Share</button>
				
				
			
				</div>
<div>
<div class="jumbotron"> Box showing show likes it</div>
</div>


<div class="container" style="padding-bottom: 10px;">

<div class="pull-left">
      
       <img class="resizeUser" src="img/0072.jpg">
      </div>
      
      <span><a>Fallais Alexandre</a> Totally agree mate! No boredom in kindness. Mainly cause what it produces in others makes you so much more alive. </span>
      <div style="padding-left: 45px;">
		<a>Like   </a> <a style="padding-left: 15px;">    Reply</a>
		</div>
</div>


<div class="container" style="padding-bottom: 10px;">

<div class="pull-left">
      
       <img class="resizeUser" src="img/g3.jpg">
      </div>
      
      <span><a>Stephen H Fisher</a> As an absurdist, I can't abide such treatment of dolphin loving wizards.

Send the poster a message asking them to edit a question or personal comment in it. </span>
      <div style="padding-left: 45px;">
		<a>Like   </a> <a style="padding-left: 15px;">    Reply</a>
		</div>
</div>


<div class="container" style="padding-bottom: 10px;">

<div class="pull-left">
      
       <img class="resizeUser" src="img/R.jpg">
      </div>
      
      <span><a>Corey Leighton</a> Everyone wins in this thread  </span>
      <div style="padding-left: 45px;">
		<a>Like   </a> <a style="padding-left: 15px;">    Reply</a>
		</div>
</div>


<div class="container">


<div class="input-group">

<div class="pull-right">
      <input style="width: 400px;padding-left: 5px;" type="text" class="form-control" placeholder="Leave a comment...">
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
			</c:forEach>
			


		</div>
		</div>
		
		
		<div class="col-md-4">

</div>
		
		
		
		</div>
<jsp:include flush="true" page="includes/include_footer.jsp"></jsp:include>