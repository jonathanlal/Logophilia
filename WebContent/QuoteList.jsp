<jsp:include flush="true" page="includes/include_header.jsp"></jsp:include>
<%@ page import="logophilia.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>





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


img.listslist{
   height:25px;
  

}
img.imgsettings{
position:absolute;
margin-top:122px;
right: 350px;

   height:200px;

}
img.list{

   max-height:260px;
   padding-top:69px;
   max-width: 185px;

   
   margin-left:0;

}




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

</style>



<div class="container"  style="display: block;">





 <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
            <div class="pull-right" style="padding-top: 15px;">
                    

            </div>

 </div>
 
  <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="padding-top: 4px;">
            <div class="pull-right">
                  <input name="edit" type="button" class="btn btn-default" value="Description" role="button" data-toggle="modal" data-target="#EditDescList">
   <input name="edit" type="button" class="btn btn-default" value="Add Quote" role="button" data-toggle="modal" data-target="#Addwordslist">
			             <a id="expandAll" href="#" class="btn btn-default" role="button">Open All</a>

                <a id="collapseAll" href="#" class="btn btn-default" role="button">Close All</a>
                
            </div>
 </div>
 
 
 
 <form action="EditDescription" method="post">
 		<input name="id" value="${idlist}" type="hidden">
				<input name="type" value="${typelist}" type="hidden">
<!-- Modal -->
<div id="EditDescList" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Edit Description for list: <br><a style="color: red;">${listname}</a> </h4>
      </div>
      
      <div class="modal-body">
 	<textarea rows="5" cols="5" style="width: 100%;" name="description" contenteditable="true">${description}</textarea>
      </div>
      <div class="modal-footer">
        <input type="submit" value="Save">
      </div>
    </div>
  </div>
</div> 
</form> 



 <form action="AddWordsList" method="post">
 		<input name="id" value="${idlist}" type="hidden">
				<input name="type" value="${typelist}" type="hidden">
<!-- Modal -->
<div id="Addwordslist" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Add words for list: <br><a style="color: red;">${listname}</a> </h4>
      </div>
      
      <div class="modal-body">
 	<textarea rows="5" cols="5" style="width: 100%;" name="words" contenteditable="true" placeholder="Add words here, seperated by a comma."></textarea>
      </div>
      <div class="modal-footer">
        <input type="submit" value="Save">
      </div>
    </div>
  </div>
</div> 
</form> 
 
 

	 <div class="jumbotron" style="width: auto;" >
	 
	 
								 	<div class="row">
								 	
								 	
								 	 <div class="col-lg-3" style="width: 190px;">
	 
	 
	                                 <img class="list" src="${listimage}">
	                    
	                   					 </div>
	                   					 
	 									 <div class="col-lg-4">
	 
	                    <h2 class="text-center"> ${listname}  <img class="listslist" src="img/quotelists.png"> </h2>	
	                    <ul class="list-group">
	                    
  <li class="list-group-item" style="height: 50px;width: 345px;"> <p>Quotes:<span class="text-success"> ${listsize}</span></p>									</li>
  <li class="list-group-item" style="height: 50px;width: 345px;"> <p>Date:<span class="text-info"> ${listdate} -<small> [${listtime}]</small></span></p>					</li>
  <li class="list-group-item" style="height: 50px;width: 345px;"><p> Author:<span class="text-info"> ${listcreator}</span></p>							</li>
</ul>
	                    
	                    
	                    
	        
    
    
   
    
  
	                                 
	 
													 </div>  
													 	 									 <div class="col-lg-5" >
<h3>Desciption:</h3>
 <div class="well" style="height: 198px;width: 480px;margin-top: 17px;">
<p class="font-italic">${description}</p>
   </div>
												 
													 
													 </div>
							
	 </div>


    <br/>


<c:forEach items="${wordsfromDB}" var="wordvary" varStatus="count">
			<div id="section${count.index}" class="panel panel-info" style="margin-bottom: 0px;">
			
					<div class="panel-heading">
						<h4 class="panel-title">
	<a data-toggle="collapse" href="#collapse${count.index}" ></a><a><span class="pull-right"><c:out value="${count.count}"></c:out>
					</span></a> 
					</h4>
					</div>
					
						<div id="collapse${count.index}" class="panel-collapse in">
					<div class="panel-body">
					
						<c:forEach items="${wordimagesArray[count.index]}" var="image" varStatus="count4">
					   <img class="list" src="${image}" align="left">
					   	</c:forEach>					   
					   
					<div class="container" style="padding-left: 200px;padding-top: 20px;">
					
					<blockquote>
  <p>${quotesfromDB[count.index]}</p>
  <footer><cite title="Source Title">- ${authorsfromDB[count.index]}</cite></footer>
</blockquote>
					
					
						</div>



								</div>
								</div>
								
								

          
            					
<div class="panel-footer">


<div class="btn-group">


					
			
			
			
<%-- <c:if test="${fn:contains(SavedWordsListCheck[count.index], 'yes')}"> --%>
<!-- 				<form action="RemoveSavedFromList" method="post" style="display: inline;"> -->
<%-- 							<input type="hidden" name="id" value="${idlist}"> --%>
<%-- 							<input type="hidden" name="word" value="${wordvary}"> --%>
<!--   							<button type="submit" class="btn btn-default btn-sm"><span style="color: red;" class="glyphicon glyphicon-heart"></span></button> -->
<!-- 				</form> -->
<%-- </c:if> --%>


<%-- <c:if test="${fn:contains(SavedWordsListCheck[count.index], 'no')}"> --%>
<!-- 				<form action="SaveWordFromList" method="post" style="display: inline;"> -->
<%-- 				<input type="hidden" name="id" value="${idlist}"> --%>
<%-- 				<input type="hidden" name="word" value="${wordvary}"> --%>
<!-- 						<button type="submit" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-heart"></span></button> -->
<!-- 				</form> -->
<%-- </c:if> --%>


			
			
		
				 <button class="btn btn-default btn-sm pull-right" value="" name="" data-toggle="modal" data-target="#addImage${count.index}">Add Image</button>
				 
				 <button class="btn btn-default btn-sm pull-right" value="" name="" data-toggle="modal" data-target="#removeWord${count.index}">Remove Quote</button>
				 
<form action="AddToList" method="post" style="display: inline;">
			<div class="dropdown pull-right">
   <button  class="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown" type="button">Add to list
  <span class="caret"></span></button>
  <ul class="dropdown-menu list-group">
  							                      <c:forEach items="${addtolistNames}" var="name" varStatus="count2">
    <li><button class="list-group-item" value="${addtolistIds[count2.index]}" name="id" type="submit">${name}</button></li>
    													</c:forEach>
  </ul>
			</div>
<input type="hidden" value="${typelist}" name="type">
<input type="hidden" name="word" value="${wordvary}">
 </form>

</div>

</div>

            </div>
            			          
            
            
         		<form action="AddImageList" enctype="multipart/form-data" method="post"  style="display: inline;">
				<input name="id" value="${idlist}" type="hidden">
				<input name="type" value="${typelist}" type="hidden">
				<input name="word" value="${wordvary}" type="hidden"> 
<!-- Modal -->
<div id="addImage${count.index}" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Add image to word: <a style="color: red;">${wordvary}</a> </h4>
      </div>
      
      <div class="modal-body">
     External Link: <textarea style="width: 100%" name="imageURL"></textarea>
      My own image:
        <input type="file">
      </div>
      <div class="modal-footer">
        <input type="submit">
      </div>
    </div>
  </div>
</div>            

            
                  </form>
            
            
            
         		<form action="RemoveWordFromList" method="post">
				<input name="id" value="${idlist}" type="hidden">
				<input name="type" value="${typelist}" type="hidden">
				<input name="word" value="${wordvary}" type="hidden"> 
<!-- Modal -->
<div id="removeWord${count.index}" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Remove word: <a style="color: red;">${wordvary}</a> from list?</h4>
      </div>
      

      <div class="modal-footer">
        <input type="submit">
      </div>
    </div>
  </div>
</div>            
            
                  </form>            
            

		</c:forEach>	
            

</div>

<form action="AddLikeList" method="post">

<input type="hidden" name="type" value="${typelist}">

<input type="hidden" name="id" value="${idlist}">

<input type="hidden" name="listcreator" value="${listcreator}">

<button style="padding-right: 0;"  type="submit" class="btn btn-link"><span class="glyphicon glyphicon-thumbs-up"></span></button>
<button style="padding-left: 0;" class="btn btn-link">${listlikesSize}</button>

<%-- <a  role="button"><small><i class="glyphicon glyphicon-thumbs-up"></i></small><input value="${listlikesSize}" id="likeButton" style="width: 20px;border: 0;"></a> --%>
 	 
 	 
 	  	 <a id="addToWordList" data-toggle="collapse" href="#collapse5" role="button"> 
 	 <small><i class="glyphicon glyphicon-comment"></i> ${commentsArraySize}</small></a>

</form>


</div>
  
	 <div class="row">

			<div class="col-md-12">
				<div style="background:white; !important" class="jumbotron">
				
				
				 <div class="row" style="width: 99.9%;margin-left: 40px;padding-right: 80px;height: 25px;">
				 <div class="col-md-2">
				 </div>
				  <div class="col-md-8">
							<div class="jumbotron" style="padding: 0px;text-align: left;"> 
							
							
							
							
							<a id="like" onclick="like();" role="button">  	 
 	 <small><i class="glyphicon glyphicon-thumbs-up"></i></small><input value=" ${listlikesSize}" id="likeButton" style="width: 20px;border: 0;"> ${listlikes}</a></div>
							</div>
							
							 <div class="col-md-2">
				 </div>
			</div>



						<ul class="list-group">

    <c:forEach items="${commentsArray}" var="comment" varStatus="count2">
     <li class="list-group-item">${comment}</li>
     	</c:forEach>

      
</ul>






<div class="container">




					<div class="container">

<form action="AddCommentLists" method="post">
						<div class="input-group">

							<div class="pull-right">

							<input name="postID" value="${idlist}" type="hidden">
								<input name="postUser" value="${listcreator}" type="hidden">
									<input name="type" value="${typelist}" type="hidden">
									
							
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
			</div>


		</div>




<div class="container">
<div class="panel-group">




</div>
</div>




<script type="text/javascript">
$(function () {			
    $('a[data-toggle="collapse"]').on('click',function(){

var objectID=$(this).attr('href');

if($(objectID).hasClass('in'))
{
                    $(objectID).collapse('hide');
}

else{
                    $(objectID).collapse('show');
}
    });
    
    
    $('#expandAll').on('click',function(){
        
        $('a[data-toggle="collapse"]').each(function(){
            var objectID=$(this).attr('href');
            if($(objectID).hasClass('in')===false)
            {
                 $(objectID).collapse('show');
            }
        });
    });
    
    $('#collapseAll').on('click',function(){
        
        $('a[data-toggle="collapse"]').each(function(){
            var objectID=$(this).attr('href');
            $(objectID).collapse('hide');
        });
    });
    
});
</script>


<jsp:include flush="true" page="includes/include_footer.jsp"></jsp:include>