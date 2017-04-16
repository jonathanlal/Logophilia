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

<h1 style="text-align: center;">Account Settings</h1>
<br>
<div class="jumbotron">
<br>

<div class="row">
<!--      <div class="col-md-1" > -->
<!--            </div> -->
           
           
                <div class="col-md-4" >
                <img src="${profileImg}" class="imgsettings">
                <br/>
                <div class="pull-left">
                                <br/>
                
                      <h3> Account name: <a class="bg-info" href="About.jsp">${loggedInUser}</a> </h3>
                
                      <h4> Account Type: <a class="bg-info" href="About.jsp"> Free user</a> <a href="UpgradeAccount.jsp"> <small>( upgrade? )</small> </a></h4>
                
                <hr/>
                      <h3> Lists: <a class="bg-info" href="#">${AmountOfUserLists}</a> </h3>
					 <h6> Shards: <a class="bg-info" href="About.jsp">???????</a> </h6>
					<h6> Word Posts: <a class="bg-info" href="About.jsp">${AmountOfUserWordPosts}</a> </h6>
                      
                </div>
                
           </div>
 
 
      <div class="col-md-7" >
      
      
     
      
      <h3>General settings: </h3>
      <br>


    							  <form action="SettingsNewTabOnSearch" method="get" id="newtab">
      <div class="checkbox">
  <label>
    <input name="newtab" type="checkbox" data-toggle="toggle" ${newTab} onchange="document.getElementById('newtab').submit();">   
    <strong>New tab link click</strong>
  </label>
</div>
										</form>





    							  <form action="SettingsHideSearchHistory" method="get" id="hidesearch">

      <div class="checkbox">
  <label>
    <input name="tabsearch" type="checkbox" data-toggle="toggle" ${hideSearch} onchange="document.getElementById('hidesearch').submit();">
    <strong>Hide search history</strong>
  </label>
</div>
										</form>



    	  <form action="SettingsHideProfileImg" method="get" id="hideprofileimg">

<div class="checkbox">
  <label>
    <input name="profileImgHide" type="checkbox" data-toggle="toggle" ${hideProfileImg} onchange="document.getElementById('hideprofileimg').submit();">
  <strong>Hide profile image</strong>  
  </label>
</div>


</form>




	<div class="checkbox-inline" onclick="" data-toggle="collapse" data-target="#ChangePassword" >
  <label style="margin-top:10px;"><input type="checkbox"  data-on="" data-off="New Password" data-toggle="toggle" value=""> <strong>Change your password</strong></label>
</div>


 <div id="ChangePassword" class="collapse" style="margin-top:10px;">
 
<form action="ChangePassword" method="post">
<div class="well">Password will update once you click on the confirmation link sent to your email.</div>
  <fieldset class="form-group">
    <label for="formGroupExampleInput">Current password: </label>
    <input name="cpass" type="text" class="form-control" id="formGroupExampleInput" placeholder="Current password">
  </fieldset>
  <fieldset class="form-group">
    <label for="formGroupExampleInput2">New password: </label>
    <input name="npass" type="text" class="form-control" id="formGroupExampleInput2" placeholder="New password">
  </fieldset>
    <fieldset class="form-group">
    <label for="formGroupExampleInput2">Confirm new password: </label>
    <input name="cnpass" type="text" class="form-control" id="formGroupExampleInput2" placeholder="Confirm new password">
  </fieldset>
  
  	<input class="pull-right btn btn-default" type="submit" value="submit">
</form>

 <br/>
	</div>
<!-- <strong> Definition:</strong> <textarea style="resize:none;width:100%;" class="input xlarge" rows="4" id="comment-box" name="comment-box" placeholder="If you want your own definition, type here..."></textarea> -->
 
<hr/>
<h3>Email settings: </h3>




	<div class="checkbox-inline" onclick="" data-toggle="collapse" data-target="#changeemail" >
  <label style="margin-top:10px;"><input type="checkbox"  data-on="" data-off="New Email" data-toggle="toggle" value=""> <strong>Change your email</strong></label>
</div>


 <div id="changeemail" class="collapse" style="margin-top:10px;">
<form action="ChangeEmail" method="post">
<div class="well">Email will update once you confirm the email that was sent to your new address.</div>

  <fieldset class="form-group">
    <label for="formGroupExampleInput">Confirm current email: </label>
    <input name="cemail" type="text" class="form-control" id="formGroupExampleInput" placeholder="Confirm current email">
  </fieldset>
  <fieldset class="form-group">
    <label for="formGroupExampleInput2">New email: </label>
    <input name="nemail" type="text" class="form-control" id="formGroupExampleInput2" placeholder="New email">
  </fieldset>
    <fieldset class="form-group">
    <label for="formGroupExampleInput2">Confirm new email: </label>
    <input name="cnemail" type="text" class="form-control" id="formGroupExampleInput2" placeholder="Confirm new email">
  </fieldset>
  
  	<input class="pull-right btn btn-default" type="submit" value="submit">
</form>

 <br/>
	</div>





<!-- <hr/> -->

<!-- <h3>Notification settings: </h3> -->

<!--    <div class="checkbox-inline disabled" onclick="" data-toggle="collapse" data-target="#notifications" disabled > -->
<!--   <label style="margin-top:10px;"><input type="checkbox" data-toggle="toggle" value=""> <strong>Send me emails</strong></label> -->
<!-- </div> -->

<!--  <div id="notifications" class="collapse" style="margin-top:10px;"> -->
<!-- <form> -->

<!--   <fieldset class="form-group"> -->
<!--     <label for="formGroupExampleInput">Shards: </label><br><br> -->
<!--   <label><input type="radio" name="optradio"> Notify when someone likes my shard</label><br> -->
<!--     <label><input type="radio" name="optradio">Notify when someone shares my shard</label><br> -->
  
<!--     <label><input type="radio" name="optradio">Notify when .....</label> -->
  
<!--   </fieldset> -->
<!--   <fieldset class="form-group"> -->
<!--     <label for="formGroupExampleInput2">Lists: </label><br><br> -->
<!--   <label><input type="radio" name="optradio">Option 1</label><br> -->
<!--   <label><input type="radio" name="optradio">Option 1</label> -->

<!--   </fieldset> -->
<!--     <fieldset class="form-group"> -->
<!--     <label for="formGroupExampleInput2">Posts: </label><br><br> -->
<!--   <label><input type="radio" name="optradio">Option 1</label><br> -->
<!--     <label><input type="radio" name="optradio">Option 1</label><br> -->
<!--     <label><input type="radio" name="optradio">Option 1</label> -->
  
<!--   </fieldset> -->
  
<!--   	<input class="pull-right" type="button" value="submit"> -->
<!-- </form> -->

<!--  <br/> -->
<!-- 	</div> -->






           </div>          
           
                <div class="col-md-1" >
           </div>

</div>
</div>










</div>































<jsp:include flush="true" page="includes/include_footer.jsp"></jsp:include>