<jsp:include flush="true" page="includes/include_header.jsp"></jsp:include>
<%@ page import="logophilia.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<style>

img.listhead{

   max-height:50px;



}

img.xlr{
   height:20px;

}




</style>

	<div class="row">
			<div class="col-md-3"> 
			</div>




			<div class="col-md-6"> 

<!-- <div class="container"> -->





<!-- </div> -->

<form action="CreateWordListServlet" method="post" enctype="multipart/form-data">



<h1 class="display-1" style="text-align: center;">New Word List <img class="listhead" src="img/menu2.png"></h1>
<br>




<div class="pull-right">

<div class="btn-group" role="group" aria-label="">
<!-- <div class=""> -->
  <button class="btn btn-default dropdown-toggle dropdown" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
   <img class="xlr" src="img/lists.png">  List Type
    <span class="caret"></span>
  </button>
  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
<!--     <li><a href="CreateNewWordList.jsp"><img class="lists" src="img/menu2.png"> Words</a></li> -->
    <li><a href="CreateNewQuoteList.jsp"><img class="lists" src="img/quotes2.png"> Quotes</a></li>
<!--     <li><a href="#">Something else here</a></li> -->
<!--     <li role="separator" class="divider"></li> -->
<!--     <li><a href="#">Separated link</a></li> -->
  </ul>
</div>

  <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-question-sign"></span> Help</button>
  <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-info-sign"></span> Info</button>
</div>




<!-- <!-- <div class="pull-right"> --> 
<!--   <button type="button" class="btn btn-secondary"><span class="glyphicon glyphicon-question-sign"></span> Help</button> -->

<!-- <div class="dropdown"> -->
<!--   <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"> -->
<!--     Change List Type -->
<!--     <span class="caret"></span> -->
<!--   </button> -->
<!--   <ul class="dropdown-menu" aria-labelledby="dropdownMenu1"> -->
<!-- <!--     <li><a href="CreateNewWordList.jsp">Words</a></li> --> 
<!--     <li><a href="CreateNewQuoteList.jsp">Quotes</a></li> -->
<!-- <!--     <li><a href="#">Something else here</a></li> --> 
<!-- <!--     <li role="separator" class="divider"></li> --> 
<!-- <!--     <li><a href="#">Separated link</a></li> --> 
<!--   </ul> -->
<!-- </div> -->
<!-- </div> -->
<br>
<hr/>













             




		           <strong> Name of word list:</strong> <textarea class="form-control" name="wordlistname" ROWS="1" id="comment" required="required"></textarea>
		                                 <c:if test="${!empty error}">
           
           <div class="alert alert-danger alert-dismissible" role="alert" style="padding-top: 5px;">
  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
 <h2><strong>${error}</strong></h2>
</div>

</c:if>


<%--        <c:if test="${!empty notenougheros}"> --%>
           
<!--            <div class="alert alert-danger alert-dismissible" role="alert" style="padding-top: 5px;"> -->
<!--   <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button> -->
<!--   <strong>Warning!</strong> Not Enough Eros! -->
<!-- </div> -->

<%-- </c:if> --%>




		                        <br>
		           
		           
		           
		           
		           

		           

		           
<!-- 	<strong> Thumbnail of list</strong> (optional):   <input style="padding-top: 5px;" type="file" name="thumbnail" accept="image/*"> -->

		                        <br>
		           
			
           <strong> Description of word list</strong> (optional): <textarea class="form-control" name="description" ROWS="2" id="comment"></textarea>
                        <br>
           
           
           
<!--            <div class="checkbox-inline pull-right" onclick="" data-toggle="collapse" data-target="#MyOwnDefinitions" > -->
<!--   <label style="margin-top:10px;"><input type="checkbox" name="mydefinitions" data-on="" data-off="My own definitions" data-toggle="toggle" value="" checked></label> -->
<!-- </div> -->

		
<!--  <div id="MyOwnDefinitions" class="collapse"> -->




<!--  </div> -->
		           
             <strong>Words:</strong> <textarea placeholder="Enter your words here, seperate each word with either a newline or space. No punctuation **should be able to enter anything....***" class="form-control" name="words" ROWS="10" required="required"></textarea>
             <br>
<!--              <div class="pull-right"> -->
<!--              							<button type="submit" class="btn btn-default"><i class="fa fa-share"></i> Preview</button> -->
             
             		           		           	<strong> Edit thumbnail of word list</strong> (optional):  
		           <textarea class="form-control" name="imageURL" ROWS="1" id="comment" placeholder="Example: http://img.wallpaperfolder.com/f/51A5E0CCF6A4/pictures-rare-animals-wide-really.jpg">${listimage}</textarea>
		           						<div class="checkbox-inline" onclick="" data-toggle="collapse" data-target="#MyOwnImage" >
  <label style="margin-top:10px;"><input type="checkbox"  data-on="" data-off="My own Image" data-toggle="toggle" value=""></label>
</div>

		
 <div id="MyOwnImage" class="collapse">



	
 <input style="padding-top: 5px;" type="file">
 </div>
             
             
		<c:if test="${currenteros >= 10 }">
             <input type="submit" class="btn btn-success">
             </c:if>
             	<c:if test="${currenteros < 10 }">
			<input type="submit" disabled title="Not enough Eros!" class="btn btn-danger" disabled="disabled">
             </c:if>
             
             
             
            </form> 
            
     
<!-- 							        	<form method="post" action="UserPostServlet" class="dropzone" id="my-awesome-dropzone" style="height: 10px;">            -->
							
						
	
<!--       							<div class="pull-left"> -->
      														        <p></p>
      							
<!-- 							<button type="submit" class="btn btn-success green"><i class="fa fa-share"></i> Share</button> -->
<!-- 							</div> -->

<!-- 							  </form> -->
             
             
							  
             
             
             </div>
             
             	<div class="col-md-3"> 
			</div>
			
			
			</div>
             
             
             
             
             <jsp:include flush="true" page="includes/include_footer.jsp"></jsp:include>