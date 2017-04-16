<jsp:include flush="true" page="includes/include_header.jsp"></jsp:include>
<%@ page import="logophilia.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
img.list{
/* position:absolute; */
/* margin-top:122px; */
/* right: 350px; */
/* margin-right: 50px; */
/*    height:34px; */
/*    height:50px; */
/*    width:50px; */
padding-top:20px;
/*    max-height:260px; */
  max-width: 230px;
/*    width:35px; */
/*    display: block; */
/*     margin-left: auto; */
/*     margin-right: auto; */
/*      margin-left: 10px; */
/*     margin-bottom: 3px; */
   top:100px;
   left:-250px;
   position: absolute;
/*    height:40px; */
}

body,
.modal-open .page-container,
.modal-open .page-container .navbar-fixed-top,
.modal-open .modal-container {
	overflow-y: scroll;
}

@media (max-width: 979px) {
	.modal-open .page-container .navbar-fixed-top{
		overflow-y: visible;
	}
}



</style>
<script>
$('.launchConfirm').on('click', function (e) {
    $('#confirm')
        .modal({ backdrop: 'static', keyboard: false })
        .one('click', '[data-value]', function (e) {
            if($(this).data('value')) {
                alert('confirmed');
            } else {
                alert('canceled');
            }
        });
});


</script>

	<div class="row">
			<div class="col-md-3"> 
			</div>




			<div class="col-md-6"> 

<!-- <div class="container"> -->





<!-- </div> -->

<form action="EditWordListServlet" enctype="multipart/form-data" method="get">


<!-- <input type="submit" class="btn btn-default"> -->
<div class="pull-right">
<button class="btn btn-default btn-sm" onclick="goBack()"><span class="glyphicon glyphicon-circle-arrow-left"></span> Go Back</button>

<script>
function goBack() {
    window.history.back();
}
</script>

</div>

<h1 style="text-align: center;">Edit ${clicked}</h1>
















<!-- <div class="pull-right"> -->
<!-- <div class="dropdown"> -->
<!--   <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"> -->
<!--     List Type -->
<!--     <span class="caret"></span> -->
<!--   </button> -->
<!--   <ul class="dropdown-menu" aria-labelledby="dropdownMenu1"> -->
<!--     <li><a href="#">Words</a></li> -->
<!--     <li><a href="#">Quotes</a></li> -->
<!--     <li><a href="#">Something else here</a></li> -->
<!--     <li role="separator" class="divider"></li> -->
<!--     <li><a href="#">Separated link</a></li> -->
<!--   </ul> -->
<!-- </div> -->
<!-- <!-- </div> --> 
<br>
<hr/>













             		            <div class="alert alert-danger alert-dismissible" role="alert" style="padding-top: 5px;">
  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  <p align="center">A little glitchy here... Please edit one at a time. This guarantees that the edit will be processed. </p>
</div>




		           <strong> Edit Name of list:</strong> <TEXTAREA class="form-control" NAME="name" ROWS="1" id="comment" disabled>${clicked}</TEXTAREA>
		           

		           
		           
		                      <c:if test="${!empty error}">
           
           <div class="alert alert-danger alert-dismissible" role="alert" style="padding-top: 5px;">
  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  <strong>Warning!</strong> Name of list already exists!
</div>

</c:if>
		                        <br>
		           
		           
		           	<strong> Edit Thumbnail of list</strong> (optional):  
<TEXTAREA class="form-control" NAME="imageURL" ROWS="1" id="comment" placeholder="Example: https://upload.wikimedia.org/wikipedia/commons/0/0c/Cow_female_black_white.jpg">${listimage}</TEXTAREA>
		           						<div class="checkbox-inline" onclick="" data-toggle="collapse" data-target="#MyOwnImage" >
  <label style="margin-top:10px;"><input type="checkbox"  data-on="" data-off="My own Image" data-toggle="toggle" value=""></label>
</div>

		
 <div id="MyOwnImage" class="collapse">



	
 <input style="padding-top: 5px;" type="file" name="thumbnail" accept="image/*">
 </div>



	                                 <img class="list" src="${listimage}">

		                        <br>
		           
			
           <strong> Edit Description of list:</strong> <TEXTAREA class="form-control" NAME="description" ROWS="2" id="comment">${description}</TEXTAREA>
           
           


                        <br>
           
             <strong>Edit Words in List:</strong> <TEXTAREA contenteditable="true" class="form-control" NAME="editwordsinlist" ROWS="10">${wordsfromDB}</TEXTAREA>
             
             <br>
<!--              <div class="pull-right"> -->
<!--              							<button type="submit" class="btn btn-default"><i class="fa fa-share"></i> Preview</button> -->
             
<!--              <input type="submit" type="file" id="files" name="file" class="btn btn-default"> -->
<!--              </div> -->
 <div class="pull-right">

             <button type="submit" class="btn btn-success btn-sm"> <span class="glyphicon glyphicon-floppy-disk"></span> Save</button>
            </div>
             
             
            </form> 
            
            
 <div class="pull-right" style="margin-top: 0px;padding-right: 5px;">
 <button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-trash"></span>  Delete</button>
 </div>
 
 
 
 
 <div id="myModal" class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
<!--         <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button> -->
        <h4 class="modal-title">Delete ${clicked}?</h4>
      </div>
<!--       <div class="modal-body"> -->
<!--         <p>One fine body</p> -->
<!--       </div> -->
      <div class="modal-footer">
                  <form action="DeleteListServlet" method="post">
      
        <button type="button" class="btn btn-default" data-dismiss="modal">No, changed my mind.</button>
<!--         <button type="button" class="btn btn-danger" type="submit" >Yes, delete this list.</button> -->
                     <input type="submit" value="Yes, delete this list." id="files" name="file" class="btn btn-danger">
        
        <input hidden="true" name="deletelist" value="${clicked}">
            </form>
        
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
 
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