<jsp:include flush="true" page="includes/include_header.jsp"></jsp:include>
<%@ page import="logophilia.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>

<!-- <script src="/ckeditor/ckeditor.js"></script> -->

<link href="alloy-editor/assets/alloy-editor-ocean-min.css" rel="stylesheet">
<script src="alloy-editor/alloy-editor-all-min.js"></script>


<style>
img.userposts{
   max-height: 50px;
   max-width: 50px;
   
/*    height:40px; */
}
/* carousel */
.media-carousel 
{
  margin-bottom: 0;
  padding: 0;
  margin-top: 30px;
}
/* Previous button  */
.media-carousel .carousel-control.left 
{
  left: -12px;
  background-image: none;
  background: none repeat scroll 0 0 #222222;
  border: 4px solid #FFFFFF;
  border-radius: 23px 23px 23px 23px;
  height: 40px;
  width : 40px;
  margin-top: 17%;
}
/* Next button  */
.media-carousel .carousel-control.right 
{
  right: -12px !important;
  background-image: none;
  background: none repeat scroll 0 0 #222222;
  border: 4px solid #FFFFFF;
  border-radius: 23px 23px 23px 23px;
  height: 40px;
  width : 40px;
  margin-top: 17%;
}
/* Changes the position of the indicators */
.media-carousel .carousel-indicators 
{
  right: 50%;
  top: auto;
  bottom: 0px;
  margin-right: -19px;
}
/* Changes the colour of the indicators */
.media-carousel .carousel-indicators li 
{
  background: #c0c0c0;
}
.media-carousel .carousel-indicators .active 
{
  background: #333333;
}

.media-carousel img
{
  width: 20%;
  float:left;
  padding:3px;
}

/* End carousel */









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

<div style="background: white; !important" class="jumbotron">

  <button id="somebutton">press here</button>
        <div id="somediv"></div>
		  <form action="CreateShardServlet" method="post" onsubmit="this.content.value=document.getElementById('myContentEditable').innerHTML;">

	<span style="padding-left: 3px;"><img class="userposts" src="img/bird.jpg" style="margin-right: 5px;margin-left: 10px;margin-top: -45px;">
								<textarea id="title" name="title" contenteditable="true" placeholder="Title" rows="1" style="resize:vertical;width: 90%;height: 50px;  font-size: 40px;margin-top: 5px;"></textarea></span>
<!-- 	 method="POST" action="CreateShard"		<h3 class="caption" style="margin-bottom: 0px; padding-bottom: 0px;" contenteditable="true"> -->



<!-- 							<span><img class="userposts" src="img/bird.jpg" style="margin-right: 5px;"> -->
<!-- 								test </span> -->
<!--  border-color: black;border-style: solid;border-width: 1px; -->
<!-- 						</h3> -->

		<div style="padding: 13px;overflow: hidden;"><textarea id="myContentEditable" name="content" contenteditable="true" style="padding-left: 20px;overflow: hidden;"></textarea>    
		
		
		
		<p>tags</p>
		  <div class="btn-toolbar pull-right" style="padding-right: 10px;">
                    <button type="submit" id="btnSubmit" class="btn btn-primary btn-md">Post</button>
                    <button type="button" id="btnCancel" class="btn btn-primary btn-md"><i class="glyphicon glyphicon-chevron-down"></i></button>
                </div>
		  </div>
		  </form>
		  </div>
		  
		  
		  
		  <hr/>
		  <p id="displayName">			</p>
		  
		  
		  <p id="demo"></p>
		  
		  
    
    
<!--     <textarea name="content" style="display:none;" ></textarea> -->


		  <div>${content}</div>
		  
<!-- 		  <script type="text/javascript"> -->
<!-- // 		   $(document).on("submit", "#submitshard", function() {  -->
		  
		  
<!-- // 		  var alloyEditor = AlloyEditor.editable('myContentEditable'); -->
<!-- // 		  var content = alloyEditor.get('nativeEditor').getData(); -->
		  		  

<!-- // 		  $.ajax({ -->
<!-- // 		      url: '/CreateShard', -->
<!-- // 		      data: { -->
<!-- // 		          postVariableName: content -->
<!-- // 		      }, -->
<!-- // 		      type: 'POST' -->
<!-- // 		  });  -->
		  
		  
<!-- // 		   }); -->
		  
		  
<!-- 		  </script> -->

		  
		       <script>
            $(document).on("click", "#somebutton", function() { // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
                
            	
            	var data = {
            		    foo: "fooValue",
            		    bar: "barValue",
            		    baz: "bazValue"
            		};

            		$.ajax({
            		    type: "POST",
            		    url: "TestServlet",
            		    contentType: "application/json", // NOT dataType!
            		    data: JSON.stringify(data),
            		    success: function(response) {
            		        // ...
            		    }
            		});
            	
            	
            	
            	
//             	$.get("TestServlet", function(responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
//                     $("#somediv").text(responseText);           // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
//                 });
            });
        </script>
		  
		  
		  
		  
		  <script type="text/javascript">
		  
		  $("#submitshard").submit(function( event ) {

			    // Stop form from submitting normally
			    event.preventDefault();

			    // Get some values from elements on the page:
			    var $form = $( this );

			    // We want to customize what we post, therefore we format our data
			    		  var alloyEditor = AlloyEditor.editable('myContentEditable');
	  var data = alloyEditor.get('nativeEditor').getData();
			    
			    
			   // var data = "login="+ $('#login').val() +"&passwordHash=" + CryptoJS.MD5($('#password').val());

			    // For debugging purposes... see your console:
			    // Prints out for example: login=myLoginName&passwordHash=a011a78a0c8d9e4f0038a5032d7668ab
			    console.log(data);

			    // The actual from POST method
			    $.ajax({
			        type: $form.attr('method'),
			        url:  $form.attr('action'),
			        data: data,
			        success: function (data) {
			            console.log("Hey, we got reply form java side, with following data: ");
			            console.log(data);

			            // redirecting example..
			            if(data === "SUCCESS") {

			               window.location.replace("http://stackoverflow.com");

			            }

			        }
			    });

			});    
		  
		  </script>
		  
		  
		  
		  
		  
		  <script>
// function myFunction() {
    //document.getElementById("demo").innerHTML = "Hello World";
    //        var content = alloyEditor.get('nativeEditor').getData();
// $(document).ready(function(){
// 	$('#btnSubmit').click(function(){
// 	    	 var alloyEditor = AlloyEditor.editable('myContentEditable');
//     	 var content = alloyEditor.get('nativeEditor').getData();
//     	$.ajax({
//     		url: 'CreateShard',
//     		type: 'POST',
//     		dataType: 'html',
//     		data: "content=" + content,
//     		success: function(data){
//     			if(!data.isValid){
//     				alert('not valid dude!');
    				
//     			}
//     		}
    	
//     			});
	
//     $('#btnSubmit').click(function(){

//     	return false;
//     	});
    
// });

</script>
		  
		    
<%-- 		  		<c:set var="alloyEditor" scope="session" value="${alloyEditor}" /> --%>
<%-- 		  <c:set var="content" scope="session" value="${content}" /> --%>
		  
<%-- 		  <c:out value="$(content)"></c:out> --%>
<%-- 		  <c:out value="$(alloyEditor)"></c:out> --%>
		  
<!--         <script> -->
<!-- //             CKEDITOR.replace( 'editor1' ); -->
<!-- //             skin: 'icy_orange,/ckeditor/skins/icy_orange/';  -->
                  
<!--         </script> -->


</div>
</div>






             <script>
          
             
             $(document).ready(function() {
            	 AlloyEditor.editable('myContentEditable');
             });
             
    
             
             </script>
             
             <jsp:include flush="true" page="includes/include_footer.jsp"></jsp:include>