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

<h1 style="text-align: center;">Notifications</h1>
<br>

<div class="row">

     <div class="col-md-12" >
              <div class="pull-right">
               
               <form action="ClearAllNotifications" method="post">
               <button type="submit" class="btn btn-info">Clear Notifications</button>
               </form>
               
               
               
               </div>
               
                </div>
                </div>
                <br>
<div class="jumbotron">

<br>

<div class="row">

     <div class="col-md-1" >
           </div>
           
           
               <div class="col-md-10" >
 
               
               
               <ul class="list-group">
                                  <c:forEach items="${notifications}" var="notification">

  <li class="list-group-item"><p>${notification}</p></li>

</c:forEach>
</ul>
               
               
               
               
               
               
               
               
               
               
               
               
               
               
               
               
           </div>
           

                <div class="col-md-1" >
           </div>


</div>


</div>







</div>































<jsp:include flush="true" page="includes/include_footer.jsp"></jsp:include>