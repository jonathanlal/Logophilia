<jsp:include flush="true" page="includes/include_header.jsp"></jsp:include>
<%@ page import="logophilia.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<style>
img.imgsettings{
/*    height:34px; */
/*    height:50px; */
/*    width:50px; */
   width:50%;
/*    width:35px; */
/*    display: block; */
/*     margin-left: auto; */
    margin-right: auto;
     margin-left: 10px; */
/*     margin-bottom: 3px; */
   
   
/*    height:40px; */
}


</style>

<div class="container">

<h1 style="text-align: center;">${scores} Users</h1>
<br>
<div class="jumbotron">
<br>

<div class="row">
  
<!--                 <div class="col-md-1" > -->
      
               
<!--            </div> -->
 
      <div class="col-md-10" >
      
      	<form action="GetProfileServlet" method="get">
      
              				<table class="table table-hover" id="dev-table">
						<thead>
							<tr>
							
								<th>Username</th>
								<th>Joined</th>
								
								<th>Eros</th>
								<th>Word Posts</th>
								<th>Lists</th>
								<th>Shards </th>
						<th> </th>
							</tr>
						</thead>
						
					
						<tbody>
						

							                      <c:forEach items="${usernameLeaderBoard}" var="userlb" varStatus="count">
							
							<tr>

								<td>${userlb}</td>
								<td></td>
								<td></td>
								<td></td>
								<td>31 april 2016</td>
								
								<td>${ErosLeaderBoard[count.index]}</td>
								<td>

								<button name="Selectedusername" type="submit" value="${userlb}" class="btn btn-link btn-xs btn-block">Open profile</button>
								</td>
															</tr>
								
													</c:forEach>
						

						</tbody>
						
					</table>
</form>

           </div>          
           
<!--                 <div class="col-md-1" > -->
<!--            </div> -->

</div>
</div>





</div>




<jsp:include flush="true" page="includes/include_footer.jsp"></jsp:include>