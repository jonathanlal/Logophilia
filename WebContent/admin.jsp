<jsp:include flush="true" page="includes/include_header.jsp"></jsp:include>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>





<c:if test="${'jona' == loggedInUser}">
<div class="container">
<p class="lead"> Admin options:</p>
<ol>

<li><a>- Give or take any user's Eros, give all users eros(christmas or something)</a> <br> </li>
<li><a>- Kick user and ban?</a><br> </li>
<li><a>- Send message ?</a> <br></li>
<li><a>- A searchable table of users with editable values</a><br> </li>
<li><a>- Currently logged in users</a><br> </li>


 </ol>
</div>

</c:if>












<jsp:include flush="true" page="includes/include_footer.jsp"></jsp:include>