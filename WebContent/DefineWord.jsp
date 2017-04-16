<jsp:include flush="true" page="includes/include_header.jsp"></jsp:include>
<%@ page import="logophilia.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<div class="container"  data-spy="scroll" data-target=".navbar" data-offset="50">

<div class="container-fluid">
<form id="searchForm" method="get" action="SearchServlet">
		<div class = "btn-toolbar" role = "toolbar">




						<div class="btn-group affix-top"  data-spy="affix" style="position: fixed; right; left:36%;  top:60px;" data-offset-top="10">
						 <div class="collapse navbar-collapse" id="myNavbar">
						        <ul class="nav navbar-nav">
						          <li ><a href="#section1">Etymology</a></li>
						          <li><a href="#section2">All words </a></li>
						          <li><a href="#section3">Sounds</a></li>
						          <li><a href="#section5">Example Sentences</a></li>
						          <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Images <span class="caret"></span></a>
						            <ul class="dropdown-menu">
						              <li><a href="#section41">Google</a></li>
						              <li><a href="#section42">Merriam</a></li>
						            </ul>
						          </li>
						        </ul>
						      </div>
						</div>



		</div>
</form>
</div>



	


<!-- 		 <a href="#" class="btn btn-default openall">open all</a> <a href="#" class="btn btn-default closeall">close all</a>    onclick=' <a href="#collapse5">' -->
		 
		  <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
		  
            <div class="pull-right">
            
            
            <form method="post" action="SaveWordServlet" style="padding-bottom: 3px;">
            <button class="btn btn-default" value="Save" name="word" type="submit">Save</button>
			</form>


  
             <button id="expandAll" class="btn btn-default" role="button">Open All</button>

                <a id="collapseAll" href="#" class="btn btn-default" role="button">Close All</a>
                
                

<div class="dropdown" style="padding-top: 3px;">

<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" disabled>Add to word list...
  <span class="caret"></span></button>
  <ul class="dropdown-menu">
  
  		<c:forEach items="${userlists}" var="list"> 
  
    <li><a href="#">${list}</a></li>
</c:forEach> 


  </ul>
</div>
            
            
            
          
                
                
            </div>
        </div>

	

<div class="panel-group">
			
			
			
			
			
								<c:out value="${iresults} results."></c:out>
			<hr />
	




<!-- 	******************************************************		ONE WORD AND DEFINITION      ****************************************************** -->
		
<!-- 		<i style="float: right;" class="material-icons" >thumb_up</i> -->
			<form class="panel panel-primary">
			
					<div class="panel-heading"> 
					<h4 class="panel-title" >
					<a data-toggle="collapse" href="#collapse1" >${oneword}</a> 
					</h4>
					</div>

					<div id="collapse1" class="panel-collapse in">
					<div class="panel-body">
					 
					 
					 
					  <ul class="nav nav-tabs">
					  <li class="active"><a data-toggle="tab" href="#menu1">${firstword1}</a></li>
					  
		<c:forEach items="${resultsw}" var="word" varStatus="theCount"> 
					  
    <li><a data-toggle="tab" href="#home${theCount.count}">${word}</a></li>

</c:forEach> 





					</ul>


					
					
					  <div class="tab-content">
    <div id="menu1" class="tab-pane fade in active">
<!--       <h3>HOME</h3> -->

		<ul class="list-group">
					
					<c:forEach items="${onedefinition}" var="definition"> 
							
		        <li class="list-group-item">${definition}</li>
		
		            </c:forEach>
		</ul>
		
		
		
		
		
<!-- 		 <div class="panel-group"> -->
<!--     <div class="panel panel-default"> -->
<!--       <div class="panel-heading"><a data-toggle="collapse" href="#collapse1" >What's up</a></div> -->
<!--       	<div id="collapse1" class="panel-collapse collapse"> -->
<!--       <div class="panel-body">Panel Content</div> -->
<!--       </div> -->
<!--     </div> -->

<!--     <div class="panel panel-primary" style="margin-top: 0;"> -->
    
<!--       <div class="panel-heading"><a data-toggle="collapse" href="#collapse2" >Etymology</a></div> -->
<!--             	<div id="collapse2" class="panel-collapse collapse"> -->
      
<!--       <div class="panel-body">Panel Content</div> -->
<!--       </div> -->
<!--     </div> -->
    
<!--         <div class="panel panel-success" style="margin-top: 0;"> -->
    
<!--       <div class="panel-heading"><a data-toggle="collapse" href="#collapse3" >Example Sentences</a></div> -->
<!--             	<div id="collapse3" class="panel-collapse collapse"> -->
      
<!--       <div class="panel-body">Panel Content</div> -->
<!--       </div> -->
<!--     </div> -->

<!--         <div class="panel panel-info" style="margin-top: 0;"> -->
    
<!--       <div class="panel-heading"><a data-toggle="collapse" href="#collapse4" >Synoynms and Antonym</a></div> -->
<!--             	<div id="collapse4" class="panel-collapse collapse"> -->
      
<!--       <div class="panel-body">Panel Content</div> -->
<!--       </div> -->
<!--     </div> -->

<!--        <div class="panel panel-warning" style="margin-top: 0;"> -->
    
<!--       <div class="panel-heading"><a data-toggle="collapse" href="#collapse5" >Images</a></div> -->
<!--             	<div id="collapse5" class="panel-collapse collapse"> -->
      
<!--       <div class="panel-body">Panel Content</div> -->
<!--       </div> -->
<!--     </div> -->
    
<!--            <div class="panel panel-danger" style="margin-top: 0;"> -->
    
<!--       <div class="panel-heading"><a data-toggle="collapse" href="#collapse6" >Sounds</a></div> -->
<!--             	<div id="collapse6" class="panel-collapse collapse"> -->
      
<!--       <div class="panel-body">Panel Content</div> -->
<!--       </div> -->
<!--     </div> -->


<!--   </div> -->
		
		
		
		
		
		
		
		
		

    </div>
    
    			<c:forEach items="${resultsd}" var="definition2" varStatus="theCount"> 
    
    <div id="home${theCount.count}" class="tab-pane fade">
      <h3>Menu ${theCount.count}</h3>
      <p>${definition2}</p>
    </div>
                </c:forEach>
    

  </div>
					
					
					
					
								
								
					</div>		
					</div>
			</form>
			<br />
			
			
<!-- 	******************************************************		ALL WORDS (MORE WORDS..)      ****************************************************** -->
<!-- 			<form id="section2" class="panel panel-info"> -->
			
<!-- 					<div class="panel-heading"> -->
<!-- 						<h4 class="panel-title"> -->
<!-- 					<a data-toggle="collapse" href="#collapse2" >All words definitions (More words)</a>  -->
<!-- 					</h4> -->
<!-- 					</div> -->
					
<!-- 						<div id="collapse2" class="panel-collapse collapse"> -->
<!-- 					<div class="panel-body"> -->
<%-- 								<c:out value="${shuffle}"></c:out> --%>
<!-- 					</div> -->
<!-- 					</div> -->
					
<!-- 			</form> -->
<!-- 			<br /> -->


<!-- 	******************************************************		WORDS      ****************************************************** -->
<!-- 			<form class="panel panel-info"> -->
			
<!-- 							<div class="panel-heading"> -->
<!-- 							<h4 class="panel-title"> -->
<!-- 					<a data-toggle="collapse" href="#collapse3" >Words</a>  -->
<!-- 					</h4> -->
<!-- 					</div> -->
							
<!-- 			<div id="collapse3" class="panel-collapse collapse">						 -->
<%-- 			<c:forEach items="${resultsw}" var="word"> --%>
		
<!-- 							<tr class="panel-body">	 -->
						
<%-- 									<td>${word}</td> --%>
<!-- 							</tr> -->
							
<%-- 			</c:forEach>			 --%>
<!-- 			</div> -->
<!-- 			</form> -->
<!-- 			<br /> -->


<!-- 	******************************************************		DEFINITIONS      ****************************************************** -->
<!-- 			<form class="panel panel-info"> -->
<!-- 							<div class="panel-heading"> -->
<!-- 							<h4 class="panel-title"> -->
<!-- 					<a data-toggle="collapse" href="#collapse4" >Definitions</a>  -->
<!-- 					</h4> -->
<!-- 					</div> -->
					
<!-- 			<div id="collapse4" class="panel-collapse collapse">					 -->
<%-- 			<c:forEach items="${resultsd2}" var="definition"> --%>
<!-- 							<tr class="panel-body"> -->
							
<%-- 									<td>${definition}</td> --%>
<!-- 							</tr> -->
<%-- 			</c:forEach> --%>
<!-- 			</div> -->
<!-- 			</form> -->
<!-- 			<br /> -->
			
			
<!-- 	******************************************************		Etymology      ****************************************************** -->
			<form id="section1" class="panel panel-success" >
							<div class="panel-heading">
							<h4 class="panel-title">
					<a data-toggle="collapse" href="#collapse5" >Etymology</a> 
					</h4>
					</div>
							
							
			<div id="collapse5" class="panel-collapse collapse">					
			<c:forEach items="${resultsety}" var="etymology">
							<tr class="panel-body">
							
									<td>${etymology}</td>
							</tr>
			</c:forEach>
			</div>
			
			</form>
			<br/>
			
			
<!-- 	******************************************************		SOUND      ****************************************************** -->
			<form id="section3" class="panel panel-warning">		
							<div class="panel-heading">
							<h4 class="panel-title">
					<a data-toggle="collapse" href="#collapse6" >Sound(s)<i class="material-icons" style="float: right;" >hearing</i></a> 
					</h4>
					</div>
							
			<div id="collapse6" class="panel-collapse collapse">					
			<c:forEach items="${resultsound}" var="sound">
							<tr class="panel-body">
									<td><embed src="${sound}"></embed></td>
							</tr>					
			</c:forEach>
			</div>


			</form>
			<br />
			
			
			
<!-- 	******************************************************		MERRIAM IMAGE      ****************************************************** -->
			<form id="section42" class="panel panel-default">
							<div class="panel-heading">
							<h4 class="panel-title">
					<a data-toggle="collapse" href="#collapse7" >Merriam Image <i class="material-icons" style="float: right;">image</i></a> 
					</h4>
					</div>
			
			<div id="collapse7" class="panel-collapse collapse">				
			<c:forEach items="${resultimgcH}" var="imgc">
							<tr class="panel-body">
									<td><img src="${imgc}" class="img-rounded" /></td>
							</tr>
			</c:forEach>
							<div class="panel-footer">					
			<c:forEach items="${resultimgcC}" var="imgcC">
								<tr align="right">
									<td>${imgcC}</td>
								</tr>
			</c:forEach>
							</div>
							
			</div>			
			</form>
			<br />
			
			
			
			
			
			
			
			
<!-- 	******************************************************		Wikipedia     ****************************************************** -->
						<form class="panel panel-info">
							<div class="panel-heading">
							<h4 class="panel-title">
					<a data-toggle="collapse" href="#collapse9" >Wikipedia</a> 
					</h4>
					</div>
					
			<div id="collapse9" class="panel-collapse collapse">					
			<c:forEach items="${wikibeg}" var="wikibeg">
							<tr class="panel-body">
							
									<td>${wikibeg}</td>
							</tr>
			</c:forEach>
			</div>
			</form>
			<br />
			
			
			<!-- 	******************************************************		Synonyms     ****************************************************** -->
						<form class="panel panel-info">
							<div class="panel-heading">
							<h4 class="panel-title">
					<a data-toggle="collapse" href="#collapse10" >Synonyms</a> 
					</h4>
					</div>
					
			<div id="collapse10" class="panel-collapse collapse">					
			<c:forEach items="${resultsd}" var="definition">
							<tr class="panel-body">
							
									<td>Wikipedia stuff</td>
							</tr>
			</c:forEach>
			</div>
			</form>
			<br />
			
			
			<!-- 	******************************************************		Antonyms     ****************************************************** -->
						<form class="panel panel-info">
							<div class="panel-heading">
							<h4 class="panel-title">
					<a data-toggle="collapse" href="#collapse11" >Antonyms</a> 
					</h4>
					</div>
					
			<div id="collapse11" class="panel-collapse collapse">					
			<c:forEach items="${resultsd}" var="definition">
							<tr class="panel-body">
							
									<td>Wikipedia stuff</td>
							</tr>
			</c:forEach>
			</div>
			</form>
			<br />
			
			
						<!-- 	******************************************************		Example Sentences     ****************************************************** -->
						<form class="panel panel-info">
							<div class="panel-heading">
							<h4 class="panel-title">
					<a data-toggle="collapse" href="#collapse12" >Example sentences</a> 
					</h4>
					</div>
					
			<div id="collapse12" class="panel-collapse collapse">					
			<c:forEach items="${resultsd}" var="definition">
							<tr class="panel-body">
							
									<td>Wikipedia stuff</td>
							</tr>
			</c:forEach>
			</div>
			</form>
			<br />
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	<!-- 	******************************************************		Google Images     ****************************************************** -->		
			<form id="section41" class="panel panel-danger">
							<div class="panel-heading"> 
							<h4 class="panel-title">
					<a data-toggle="collapse" href="#collapse8" >Google Images <i class="material-icons" style="float: right;">view_module</i> </a> 
					</h4>
					</div>
					
					 <div id="collapse8" class="panel-collapse collapse">
							<div  class="panel-body">
			<c:forEach items="${myList}" var="image" varStatus="TheModal">
			
							<tr>	
									<td><div class="col-lg-3 col-sm-4 col-xs-6"><a title="Image: ${image}" target="_blank"><img src="${image}" class="thumbnail img-responsive" id="${image}"/></a></div></td>	
							</tr>

									<!-- The Modal -->
			<div id="${TheModal}" class="modal">
			<span class="close">CLOSE</span>
			<img class="modal-content" id="imgModal">
							<div class="panel-footer"> Make a button so people can add a word to the image and save it <button>Make word</button></div>
			 <div id="caption"></div>
			</div>
			
			<script>
								// Get the modal
								var modal = document.getElementById('${TheModal}');	
								// Get the image and insert it inside the modal - use its "alt" text as a caption
								var img = document.getElementById('${image}');
								var modalImg = document.getElementById("imgModal");
								var captionText = document.getElementById("caption");
								img.onclick = function(){
								    modal.style.display = "block";
								    modalImg.src = this.src;
								    modalImg.alt = this.alt;
								    captionText.innerHTML = this.alt;}								
								// Get the <span> element that closes the modal
								var span = document.getElementsByClassName("close")[0];								
								// When the user clicks on <span> (x), close the modal
								span.onclick = function() { 
								    modal.style.display = "none";}
			</script>


			</c:forEach>
			</div>
			</div>
			
			</form>

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