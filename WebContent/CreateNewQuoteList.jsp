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

<form action="CreateQuoteListServlet" method="post" enctype="multipart/form-data">


<!-- <input type="submit" class="btn btn-default"> -->

<h1 style="text-align: center;"></h1>







<h1 class="display-1" style="text-align: center;">New Quote List <img class="listhead" src="img/quotes2.png"></h1>
<br>




<div class="pull-right">

<div class="btn-group" role="group" aria-label="">
<!-- <div class=""> -->
  <button class="btn btn-default dropdown-toggle dropdown" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
   <img class="xlr" src="img/lists.png">  List Type
    <span class="caret"></span>
  </button>
  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
    <li><a href="CreateNewWordList.jsp"><img class="lists" src="img/menu2.png"> Words</a></li>
<!--     <li><a href="CreateNewQuoteList.jsp"><img class="lists" src="img/quotes2.png"> Quotes</a></li> -->
<!--     <li><a href="#">Something else here</a></li> -->
<!--     <li role="separator" class="divider"></li> -->
<!--     <li><a href="#">Separated link</a></li> -->
  </ul>
</div>
  
  
  
  
  
  
  
  
  <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-question-sign"></span> Help</button>
  <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-info-sign"></span> Info</button>
</div>
















<!-- <div class="pull-right"> -->
<!-- <button class="btn btn-default btn-sm" onclick="goBack()"><span class="glyphicon glyphicon-circle-arrow-left"></span> Go Back</button> -->

<!-- <script> -->

<!-- </script> -->

<!-- </div> -->










<!-- </div> -->
<br>
<hr/>

















		           <strong> Name of quote list:</strong> <TEXTAREA class="form-control" NAME="name" ROWS="1" id="comment"></TEXTAREA>
		                                 <c:if test="${!empty error}">
           
           <div class="alert alert-danger alert-dismissible" role="alert" style="padding-top: 5px;">
  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
 <h2><strong>Name Already Exists! Or, Not Enough Eros! </strong></h2>
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
		           
			
           <strong> Description of quote list:</strong> <TEXTAREA class="form-control" NAME="description" ROWS="2"></TEXTAREA>
                        <br>
           
           
           <c:forEach var="i" begin="0" end="${n}">
             
             <strong>Quote:</strong> <TEXTAREA placeholder="Quote" class="form-control" NAME="quote_${i}" id="txtDynamic_${i}" ROWS="10" ></TEXTAREA>
             <br>
			     <strong>Author:</strong> <TEXTAREA placeholder="Author" class="form-control" NAME="author_${i}" id="txtDynamic_${i}" ROWS="1"></TEXTAREA>		
              <br>
              </c:forEach>
              
    
<%--              <input type="hidden" name="size" value="${n}">" --%>
             
             		           		           	<strong> Edit Thumbnail of quote list</strong> (optional):  
		           <TEXTAREA class="form-control" NAME="imageURL" ROWS="1" placeholder="Example: https://upload.wikimedia.org/wikipedia/commons/0/0c/Cow_female_black_white.jpg"></TEXTAREA>
<!-- 		           						<div class="checkbox-inline" onclick="" data-toggle="collapse" data-target="#MyOwnImage" > -->
<!--   <label style="margin-top:10px;"><input type="checkbox"  data-on="" data-off="My own Image" data-toggle="toggle" value=""></label> -->
<!-- </div> -->

		
<!--  <div id="MyOwnImage" class="collapse"> -->



	
<!--  <input style="padding-top: 5px;" type="file"> -->
<!--  </div> -->
                      <input type="submit" class="btn btn-default">
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