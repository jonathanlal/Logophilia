
<jsp:include flush="true" page="includes/include_header.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

  <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    


<div class="container">
<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
		  
            <div class="pull-right">
            
            
            <form method="post" action="SaveWordSearch" style="padding-bottom: 3px;">
            <input type="hidden" name="word" value="${oneword}">
            <button class="btn btn-default" value="Save" name="word" type="submit">Save</button>
			</form>


  
<!--              <button id="expandAll" class="btn btn-default" role="button">Open All</button> -->

<!--                 <a id="collapseAll" href="#" class="btn btn-default" role="button">Close All</a> -->
                
                

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

</div>

 

<div class="container">




 


<!-- <div class="jumbotron"> -->







            <div class="panel with-nav-tabs panel-default">
                <div class="panel-heading">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#tab1default" data-toggle="tab">General</a></li>
                            <li><a href="#tab2default" data-toggle="tab">Images</a></li>
                            <li><a href="#tab3default" data-toggle="tab">Sound</a></li>
<!--                             <li class="dropdown"> -->
<!--                                 <a href="#" data-toggle="dropdown">Dropdown <span class="caret"></span></a> -->
<!--                                 <ul class="dropdown-menu" role="menu"> -->
<!--                                     <li><a href="#tab4default" data-toggle="tab">Default 4</a></li> -->
<!--                                     <li><a href="#tab5default" data-toggle="tab">Default 5</a></li> -->
<!--                                 </ul> -->
<!--                             </li> -->
                        </ul>
                </div>


 <div class="panel-body">
                    <div class="tab-content">
                        <div class="tab-pane fade in active" id="tab1default">
                        
                        

           
           
                        
                        
                        
                        <div class="row">
 <div class="col-sm-12">
 
			<form class="panel panel-primary">
			
					<div class="panel-heading"> 
					<h4 class="panel-title" >
					<a data-toggle="collapse" href="#collapse1" >${oneword}</a> 
					</h4>
					</div>

					<div id="collapse1" class="panel-collapse in">
					<div class="panel-body">
					 

                      
                      
<!--                       					 		                 		                                     <div class="list-group"> -->
                    
<%--                     <c:forEach items="${examples}" var="ex" varStatus="count"> --%>
<%--              <li class="list-group-item">${ex} --%>
<!--              <br>              -->
<!--              </li> -->
<%-- 					</c:forEach> --%>

<!--                       </div> -->





<ul class="nav nav-tabs">
  <li class="active"><a data-toggle="tab" href="#home9">WordNet</a></li>
  <li><a data-toggle="tab" href="#menu19">Merriam</a></li>
  <li><a data-toggle="tab" href="#menu29">Other dictionary</a></li>
</ul>

<div class="tab-content">
  <div id="home9" class="tab-pane fade in active">

    
    
    
    					 		                 		                                     <div class="list-group">
                    
                    <c:forEach items="${definitions}" var="def" varStatus="count">
             <li class="list-group-item">${def}
             <br>             
             </li>
					</c:forEach>

                      </div>
    
    
    
    
    
    
  </div>
  <div id="menu19" class="tab-pane fade">



<br>




			<div class="tabbable-panel">
				<div class="tabbable-line">
					<ul class="nav nav-tabs ">
						<li class="active">
							<a href="#tab_default_19" data-toggle="tab">
							${firstword1}</a>
						</li>
						
						
								<c:forEach items="${resultsw}" var="word" varStatus="theCount"> 
					  
    <li><a href="#tab_default_${theCount.count}" data-toggle="tab">${word}</a></li>

</c:forEach> 
						
						

					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="tab_default_19">

		<ul class="list-group">
					
					<c:forEach items="${onedefinition}" var="definition"> 
							
		        <li class="list-group-item">${definition}</li>
		
		            </c:forEach>
		</ul>



						</div>
						
						
						
						
						<c:forEach items="${resultsd}" var="definition2" varStatus="theCount"> 
    
    <div id="tab_default_${theCount.count}" class="tab-pane">
<%--       <h3>Menu ${theCount.count}</h3> --%>
	<ul class="list-group">
     <li class="list-group-item">${definition2}</li>
     	</ul>	
    </div>
                </c:forEach>
						
					
						
						
						
						
						

					</div>
				</div>
			</div>








































  </div>
  <div id="menu29" class="tab-pane fade">
    <h3>Menu 2</h3>
    <p>Some content in menu 2.</p>
  </div>
</div>




					 
					 
					 
  
  
  
  
  
				
				
				
				
				
				
				
				
				
				
				
				
					
					
					
					
								
								
					</div>		
					</div>
			</form>
 
 </div>
</div>

<c:if test="${not empty examples}">

                        
                                   <div class="row">
 <div class="col-sm-12">
 
 
			<form id="section8" class="panel panel-info" >
							<div class="panel-heading">
							<h4 class="panel-title">
					<a data-toggle="collapse" href="#collapse8" >Example Sentences</a> 
					</h4>
					</div>
							
							
			<div id="collapse8" class="panel-collapse collapse">					
							<div class="panel-body">
						      
                          <c:forEach items="${examples}" var="ex" varStatus="count">
             <li class="list-group-item">${ex}
             <br>             
             </li>
					</c:forEach>
							</div>
			</div>
			
			</form>
 
 
 
 </div>
 
 </div>
 
 </c:if>
 
 



<div class="row">
 <div class="col-sm-4">
 
 
	<form id="section3" class="panel panel-warning">		
							<div class="panel-heading">
							<h4 class="panel-title">
					<a data-toggle="collapse" href="#collapse6" >Synoynms</a> 
					</h4>
					</div>
							
			<div id="collapse6" class="panel-collapse collapse">	
			<div class="panel-body">
		                 		                                     <div class="list-group">
                    
                    <c:forEach items="${synonyms}" var="syn" varStatus="count">
             <li class="list-group-item">${syn}
             <br>             
             </li>
					</c:forEach>

                      </div>
			
			</div>
							
<%-- 			<c:forEach items="${resultsound}" var="sound"> --%>
<!-- 							<tr > -->
<%-- 									<td>S<embed src="${sound}"></embed></td> --%>
<!-- 							</tr>					 -->
<%-- 			</c:forEach> --%>
			</div>


			</form>
</div>


 <div class="col-sm-8">




			<form id="section1" class="panel panel-success" >
							<div class="panel-heading">
							<h4 class="panel-title">
					<a data-toggle="collapse" href="#collapse5" >Etymology</a> 
					</h4>
					</div>
							
							
			<div id="collapse5" class="panel-collapse collapse">					

							<div class="panel-body">
	<c:forEach items="${resultsety}" var="etymology">
							<tr class="panel-body">
							
									<td>${etymology}</td>
							</tr>
			</c:forEach>
							</div>

			</div>
			
			</form>







 
</div>

<!--  <div class="col-sm-4"> -->
<!--  something else here -->
 
<!-- </div> -->

</div>
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        </div>
                        <div class="tab-pane fade" id="tab2default">





     <div class="panel with-nav-tabs panel-default">
                <div class="panel-heading">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#tab1defaultImg" data-toggle="tab">Merriam</a></li>
                            <li><a href="#tab2defaultImg" data-toggle="tab">Google</a></li>
<!--                             <li><a href="#tab3default" data-toggle="tab">Default 3</a></li> -->
<!--                             <li class="dropdown"> -->
<!--                                 <a href="#" data-toggle="dropdown">Dropdown <span class="caret"></span></a> -->
<!--                                 <ul class="dropdown-menu" role="menu"> -->
<!--                                     <li><a href="#tab4default" data-toggle="tab">Default 4</a></li> -->
<!--                                     <li><a href="#tab5default" data-toggle="tab">Default 5</a></li> -->
<!--                                 </ul> -->
<!--                             </li> -->
                        </ul>
                </div>
                <div class="panel-body">
                    <div class="tab-content">
                        <div class="tab-pane fade in active" id="tab1defaultImg">






<form id="section42" class="panel panel-default">
							<div class="panel-heading">
							<h4 class="panel-title">
					<a data-toggle="collapse" href="#collapse7img" >Merriam Image <i class="material-icons" style="float: right;">image</i></a> 
					</h4>
					</div>
			
			<div id="collapse7img" class="panel-collapse collapse">				
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










</div>
                        <div class="tab-pane fade" id="tab2defaultImg">



		<form id="section41" class="panel panel-danger">
							<div class="panel-heading"> 
							<h4 class="panel-title">
					<a data-toggle="collapse" href="#collapse8img" >Google Images <i class="material-icons" style="float: right;">view_module</i> </a> 
					</h4>
					</div>
					
					 <div id="collapse8img" class="panel-collapse collapse">
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
<!--                         <div class="tab-pane fade" id="tab3default">Default 3</div> -->
<!--                         <div class="tab-pane fade" id="tab4default">Default 4</div> -->
<!--                         <div class="tab-pane fade" id="tab5default">Default 5</div> -->
                    </div>
                </div>
            </div>





























</div>
                        <div class="tab-pane fade" id="tab3default">





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




</div>
<!--                         <div class="tab-pane fade" id="tab4default">Default 4</div> -->
<!--                         <div class="tab-pane fade" id="tab5default">Default 5</div> -->
                    </div>
                </div>











</div>




<!-- </div> -->


























</div>









<!-- <form action="GetWordInfo" method="post"> -->


<!-- <input type="text" name="query"> -->

<!-- <button type="submit">Go</button> -->
<!-- </form> -->


<!-- <div class="panel with-nav-tabs panel-default" style="width: 100 px;">  -->
<!--                 <div class="panel-heading"> -->
<!--                             <h4>synoynms</h4> -->

<!--                 </div> -->
<!-- 	                  <div class="panel-body"> -->
<!--                     <div class="tab-content"> -->
                 
<!--                  		                                     <div class="list-group"> -->
                    
<%--                     <c:forEach items="${definitions}" var="word" varStatus="count"> --%>
<%--              <li class="list-group-item">${word} --%>
<!--              <br>              -->
<!--              </li> -->
<%-- 					</c:forEach> --%>

<!--                       </div> -->

<!--                 </div> -->

<!--             </div> -->

<!-- 	  	     </div> -->






<div>${myList}</div>




















<jsp:include flush="true" page="includes/include_footer.jsp"></jsp:include>