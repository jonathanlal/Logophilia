<jsp:include flush="true" page="includes/include_header.jsp"></jsp:include>
<%@ page import="userBeans.LoginDao"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>





<script>
$(function() {

    $('#login-form-link').click(function(e) {
		$("#login-form").delay(100).fadeIn(100);
 		$("#register-form").fadeOut(100);
 		$("#register-well").fadeOut(100);
		$('#register-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	$('#register-form-link').click(function(e) {
		$("#register-well").delay(100).fadeIn(100);
		$("#register-form").delay(100).fadeIn(100);
 		$("#login-form").fadeOut(100);
		$('#login-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});

});

$(function () {
	  var all_classes = "";
	  var timer = undefined;
	  $.each($('li', '.social-class'), function (index, element) {
	    all_classes += " btn-" + $(element).data("code");
	  });
	  $('li', '.social-class').mouseenter(function () {
	    var icon_name = $(this).data("code");
	    if ($(this).data("icon")) {
	      icon_name = $(this).data("icon");
	    }
	    var icon = "<i class='fa fa-" + icon_name + "'></i>";
	    $('.btn-social', '.social-sizes').html(icon + "Sign in with " + $(this).data("name"));
	    $('.btn-social-icon', '.social-sizes').html(icon);
	    $('.btn', '.social-sizes').removeClass(all_classes);
	    $('.btn', '.social-sizes').addClass("btn-" + $(this).data('code'));
	  });
	  $($('li', '.social-class')[Math.floor($('li', '.social-class').length * Math.random())]).mouseenter();
	});





</script>










<style>

/* body { */
/*     padding-top: 90px; */
/* } */
.panel-login {
	border-color: #ccc;
	-webkit-box-shadow: 0px 2px 3px 0px rgba(0,0,0,0.2);
	-moz-box-shadow: 0px 2px 3px 0px rgba(0,0,0,0.2);
	box-shadow: 0px 2px 3px 0px rgba(0,0,0,0.2);
}
.panel-login>.panel-heading {
	color: #00415d;
	background-color: #fff;
	border-color: #fff;
	text-align:center;
}
.panel-login>.panel-heading a{
	text-decoration: none;
	color: #666;
	font-weight: bold;
	font-size: 15px;
	-webkit-transition: all 0.1s linear;
	-moz-transition: all 0.1s linear;
	transition: all 0.1s linear;
}
.panel-login>.panel-heading a.active{
	color: #029f5b;
	font-size: 18px;
}
.panel-login>.panel-heading hr{
	margin-top: 10px;
	margin-bottom: 0px;
	clear: both;
	border: 0;
	height: 1px;
	background-image: -webkit-linear-gradient(left,rgba(0, 0, 0, 0),rgba(0, 0, 0, 0.15),rgba(0, 0, 0, 0));
	background-image: -moz-linear-gradient(left,rgba(0,0,0,0),rgba(0,0,0,0.15),rgba(0,0,0,0));
	background-image: -ms-linear-gradient(left,rgba(0,0,0,0),rgba(0,0,0,0.15),rgba(0,0,0,0));
	background-image: -o-linear-gradient(left,rgba(0,0,0,0),rgba(0,0,0,0.15),rgba(0,0,0,0));
}
.panel-login input[type="text"],.panel-login input[type="email"],.panel-login input[type="password"] {
	height: 45px;
	border: 1px solid #ddd;
	font-size: 16px;
	-webkit-transition: all 0.1s linear;
	-moz-transition: all 0.1s linear;
	transition: all 0.1s linear;
}
.panel-login input:hover,
.panel-login input:focus {
	outline:none;
	-webkit-box-shadow: none;
	-moz-box-shadow: none;
	box-shadow: none;
	border-color: #ccc;
}
.btn-login {
	background-color: #59B2E0;
	outline: none;
	color: #fff;
	font-size: 14px;
	height: auto;
	font-weight: normal;
	padding: 14px 0;
	text-transform: uppercase;
	border-color: #59B2E6;
}
.btn-login:hover,
.btn-login:focus {
	color: #fff;
	background-color: #53A3CD;
	border-color: #53A3CD;
}
.forgot-password {
	text-decoration: underline;
	color: #888;
}
.forgot-password:hover,
.forgot-password:focus {
	text-decoration: underline;
	color: #666;
}

.btn-register {
	background-color: #1CB94E;
	outline: none;
	color: #fff;
	font-size: 14px;
	height: auto;
	font-weight: normal;
	padding: 14px 0;
	text-transform: uppercase;
	border-color: #1CB94A;
}
.btn-register:hover,
.btn-register:focus {
	color: #fff;
	background-color: #1CA347;
	border-color: #1CA347;
}



@import url(//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css);
/*
 * Social Buttons for Bootstrap
 *
 * Copyright 2013 Panayiotis Lipiridis
 * Licensed under the MIT License
 *
 * https://github.com/lipis/bootstrap-social
 */

.btn-social{position:relative;padding-left:44px;text-align:left;white-space:nowrap;overflow:hidden;text-overflow:ellipsis}.btn-social :first-child{position:absolute;left:0;top:0;bottom:0;width:32px;line-height:34px;font-size:1.6em;text-align:center;border-right:1px solid rgba(0,0,0,0.2)}
.btn-social.btn-lg{padding-left:61px}.btn-social.btn-lg :first-child{line-height:45px;width:45px;font-size:1.8em}
.btn-social.btn-sm{padding-left:38px}.btn-social.btn-sm :first-child{line-height:28px;width:28px;font-size:1.4em}
.btn-social.btn-xs{padding-left:30px}.btn-social.btn-xs :first-child{line-height:20px;width:20px;font-size:1.2em}
.btn-social-icon{position:relative;padding-left:44px;text-align:left;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;height:34px;width:34px;padding-left:0;padding-right:0}.btn-social-icon :first-child{position:absolute;left:0;top:0;bottom:0;width:32px;line-height:34px;font-size:1.6em;text-align:center;border-right:1px solid rgba(0,0,0,0.2)}
.btn-social-icon.btn-lg{padding-left:61px}.btn-social-icon.btn-lg :first-child{line-height:45px;width:45px;font-size:1.8em}
.btn-social-icon.btn-sm{padding-left:38px}.btn-social-icon.btn-sm :first-child{line-height:28px;width:28px;font-size:1.4em}
.btn-social-icon.btn-xs{padding-left:30px}.btn-social-icon.btn-xs :first-child{line-height:20px;width:20px;font-size:1.2em}
.btn-social-icon :first-child{border:none;text-align:center;width:100% !important}
.btn-social-icon.btn-lg{height:45px;width:45px;padding-left:0;padding-right:0}
.btn-social-icon.btn-sm{height:30px;width:30px;padding-left:0;padding-right:0}
.btn-social-icon.btn-xs{height:22px;width:22px;padding-left:0;padding-right:0}
.btn-bitbucket{color:#fff;background-color:#205081;border-color:rgba(0,0,0,0.2)}.btn-bitbucket:hover,.btn-bitbucket:focus,.btn-bitbucket:active,.btn-bitbucket.active,.open .dropdown-toggle.btn-bitbucket{color:#fff;background-color:#183c60;border-color:rgba(0,0,0,0.2)}
.btn-bitbucket:active,.btn-bitbucket.active,.open .dropdown-toggle.btn-bitbucket{background-image:none}
.btn-bitbucket.disabled,.btn-bitbucket[disabled],fieldset[disabled] .btn-bitbucket,.btn-bitbucket.disabled:hover,.btn-bitbucket[disabled]:hover,fieldset[disabled] .btn-bitbucket:hover,.btn-bitbucket.disabled:focus,.btn-bitbucket[disabled]:focus,fieldset[disabled] .btn-bitbucket:focus,.btn-bitbucket.disabled:active,.btn-bitbucket[disabled]:active,fieldset[disabled] .btn-bitbucket:active,.btn-bitbucket.disabled.active,.btn-bitbucket[disabled].active,fieldset[disabled] .btn-bitbucket.active{background-color:#205081;border-color:rgba(0,0,0,0.2)}
.btn-dropbox{color:#fff;background-color:#1087dd;border-color:rgba(0,0,0,0.2)}.btn-dropbox:hover,.btn-dropbox:focus,.btn-dropbox:active,.btn-dropbox.active,.open .dropdown-toggle.btn-dropbox{color:#fff;background-color:#0d70b7;border-color:rgba(0,0,0,0.2)}
.btn-dropbox:active,.btn-dropbox.active,.open .dropdown-toggle.btn-dropbox{background-image:none}
.btn-dropbox.disabled,.btn-dropbox[disabled],fieldset[disabled] .btn-dropbox,.btn-dropbox.disabled:hover,.btn-dropbox[disabled]:hover,fieldset[disabled] .btn-dropbox:hover,.btn-dropbox.disabled:focus,.btn-dropbox[disabled]:focus,fieldset[disabled] .btn-dropbox:focus,.btn-dropbox.disabled:active,.btn-dropbox[disabled]:active,fieldset[disabled] .btn-dropbox:active,.btn-dropbox.disabled.active,.btn-dropbox[disabled].active,fieldset[disabled] .btn-dropbox.active{background-color:#1087dd;border-color:rgba(0,0,0,0.2)}
.btn-facebook{color:#fff;background-color:#3b5998;border-color:rgba(0,0,0,0.2)}.btn-facebook:hover,.btn-facebook:focus,.btn-facebook:active,.btn-facebook.active,.open .dropdown-toggle.btn-facebook{color:#fff;background-color:#30487b;border-color:rgba(0,0,0,0.2)}
.btn-facebook:active,.btn-facebook.active,.open .dropdown-toggle.btn-facebook{background-image:none}
.btn-facebook.disabled,.btn-facebook[disabled],fieldset[disabled] .btn-facebook,.btn-facebook.disabled:hover,.btn-facebook[disabled]:hover,fieldset[disabled] .btn-facebook:hover,.btn-facebook.disabled:focus,.btn-facebook[disabled]:focus,fieldset[disabled] .btn-facebook:focus,.btn-facebook.disabled:active,.btn-facebook[disabled]:active,fieldset[disabled] .btn-facebook:active,.btn-facebook.disabled.active,.btn-facebook[disabled].active,fieldset[disabled] .btn-facebook.active{background-color:#3b5998;border-color:rgba(0,0,0,0.2)}
.btn-flickr{color:#fff;background-color:#ff0084;border-color:rgba(0,0,0,0.2)}.btn-flickr:hover,.btn-flickr:focus,.btn-flickr:active,.btn-flickr.active,.open .dropdown-toggle.btn-flickr{color:#fff;background-color:#d6006f;border-color:rgba(0,0,0,0.2)}
.btn-flickr:active,.btn-flickr.active,.open .dropdown-toggle.btn-flickr{background-image:none}
.btn-flickr.disabled,.btn-flickr[disabled],fieldset[disabled] .btn-flickr,.btn-flickr.disabled:hover,.btn-flickr[disabled]:hover,fieldset[disabled] .btn-flickr:hover,.btn-flickr.disabled:focus,.btn-flickr[disabled]:focus,fieldset[disabled] .btn-flickr:focus,.btn-flickr.disabled:active,.btn-flickr[disabled]:active,fieldset[disabled] .btn-flickr:active,.btn-flickr.disabled.active,.btn-flickr[disabled].active,fieldset[disabled] .btn-flickr.active{background-color:#ff0084;border-color:rgba(0,0,0,0.2)}
.btn-github{color:#fff;background-color:#444;border-color:rgba(0,0,0,0.2)}.btn-github:hover,.btn-github:focus,.btn-github:active,.btn-github.active,.open .dropdown-toggle.btn-github{color:#fff;background-color:#303030;border-color:rgba(0,0,0,0.2)}
.btn-github:active,.btn-github.active,.open .dropdown-toggle.btn-github{background-image:none}
.btn-github.disabled,.btn-github[disabled],fieldset[disabled] .btn-github,.btn-github.disabled:hover,.btn-github[disabled]:hover,fieldset[disabled] .btn-github:hover,.btn-github.disabled:focus,.btn-github[disabled]:focus,fieldset[disabled] .btn-github:focus,.btn-github.disabled:active,.btn-github[disabled]:active,fieldset[disabled] .btn-github:active,.btn-github.disabled.active,.btn-github[disabled].active,fieldset[disabled] .btn-github.active{background-color:#444;border-color:rgba(0,0,0,0.2)}
.btn-google-plus{color:#fff;background-color:#dd4b39;border-color:rgba(0,0,0,0.2)}.btn-google-plus:hover,.btn-google-plus:focus,.btn-google-plus:active,.btn-google-plus.active,.open .dropdown-toggle.btn-google-plus{color:#fff;background-color:#ca3523;border-color:rgba(0,0,0,0.2)}
.btn-google-plus:active,.btn-google-plus.active,.open .dropdown-toggle.btn-google-plus{background-image:none}
.btn-google-plus.disabled,.btn-google-plus[disabled],fieldset[disabled] .btn-google-plus,.btn-google-plus.disabled:hover,.btn-google-plus[disabled]:hover,fieldset[disabled] .btn-google-plus:hover,.btn-google-plus.disabled:focus,.btn-google-plus[disabled]:focus,fieldset[disabled] .btn-google-plus:focus,.btn-google-plus.disabled:active,.btn-google-plus[disabled]:active,fieldset[disabled] .btn-google-plus:active,.btn-google-plus.disabled.active,.btn-google-plus[disabled].active,fieldset[disabled] .btn-google-plus.active{background-color:#dd4b39;border-color:rgba(0,0,0,0.2)}
.btn-instagram{color:#fff;background-color:#517fa4;border-color:rgba(0,0,0,0.2)}.btn-instagram:hover,.btn-instagram:focus,.btn-instagram:active,.btn-instagram.active,.open .dropdown-toggle.btn-instagram{color:#fff;background-color:#446a89;border-color:rgba(0,0,0,0.2)}
.btn-instagram:active,.btn-instagram.active,.open .dropdown-toggle.btn-instagram{background-image:none}
.btn-instagram.disabled,.btn-instagram[disabled],fieldset[disabled] .btn-instagram,.btn-instagram.disabled:hover,.btn-instagram[disabled]:hover,fieldset[disabled] .btn-instagram:hover,.btn-instagram.disabled:focus,.btn-instagram[disabled]:focus,fieldset[disabled] .btn-instagram:focus,.btn-instagram.disabled:active,.btn-instagram[disabled]:active,fieldset[disabled] .btn-instagram:active,.btn-instagram.disabled.active,.btn-instagram[disabled].active,fieldset[disabled] .btn-instagram.active{background-color:#517fa4;border-color:rgba(0,0,0,0.2)}
.btn-linkedin{color:#fff;background-color:#007bb6;border-color:rgba(0,0,0,0.2)}.btn-linkedin:hover,.btn-linkedin:focus,.btn-linkedin:active,.btn-linkedin.active,.open .dropdown-toggle.btn-linkedin{color:#fff;background-color:#005f8d;border-color:rgba(0,0,0,0.2)}
.btn-linkedin:active,.btn-linkedin.active,.open .dropdown-toggle.btn-linkedin{background-image:none}
.btn-linkedin.disabled,.btn-linkedin[disabled],fieldset[disabled] .btn-linkedin,.btn-linkedin.disabled:hover,.btn-linkedin[disabled]:hover,fieldset[disabled] .btn-linkedin:hover,.btn-linkedin.disabled:focus,.btn-linkedin[disabled]:focus,fieldset[disabled] .btn-linkedin:focus,.btn-linkedin.disabled:active,.btn-linkedin[disabled]:active,fieldset[disabled] .btn-linkedin:active,.btn-linkedin.disabled.active,.btn-linkedin[disabled].active,fieldset[disabled] .btn-linkedin.active{background-color:#007bb6;border-color:rgba(0,0,0,0.2)}
.btn-pinterest{color:#fff;background-color:#cb2027;border-color:rgba(0,0,0,0.2)}.btn-pinterest:hover,.btn-pinterest:focus,.btn-pinterest:active,.btn-pinterest.active,.open .dropdown-toggle.btn-pinterest{color:#fff;background-color:#a81a20;border-color:rgba(0,0,0,0.2)}
.btn-pinterest:active,.btn-pinterest.active,.open .dropdown-toggle.btn-pinterest{background-image:none}
.btn-pinterest.disabled,.btn-pinterest[disabled],fieldset[disabled] .btn-pinterest,.btn-pinterest.disabled:hover,.btn-pinterest[disabled]:hover,fieldset[disabled] .btn-pinterest:hover,.btn-pinterest.disabled:focus,.btn-pinterest[disabled]:focus,fieldset[disabled] .btn-pinterest:focus,.btn-pinterest.disabled:active,.btn-pinterest[disabled]:active,fieldset[disabled] .btn-pinterest:active,.btn-pinterest.disabled.active,.btn-pinterest[disabled].active,fieldset[disabled] .btn-pinterest.active{background-color:#cb2027;border-color:rgba(0,0,0,0.2)}
.btn-tumblr{color:#fff;background-color:#2c4762;border-color:rgba(0,0,0,0.2)}.btn-tumblr:hover,.btn-tumblr:focus,.btn-tumblr:active,.btn-tumblr.active,.open .dropdown-toggle.btn-tumblr{color:#fff;background-color:#1f3346;border-color:rgba(0,0,0,0.2)}
.btn-tumblr:active,.btn-tumblr.active,.open .dropdown-toggle.btn-tumblr{background-image:none}
.btn-tumblr.disabled,.btn-tumblr[disabled],fieldset[disabled] .btn-tumblr,.btn-tumblr.disabled:hover,.btn-tumblr[disabled]:hover,fieldset[disabled] .btn-tumblr:hover,.btn-tumblr.disabled:focus,.btn-tumblr[disabled]:focus,fieldset[disabled] .btn-tumblr:focus,.btn-tumblr.disabled:active,.btn-tumblr[disabled]:active,fieldset[disabled] .btn-tumblr:active,.btn-tumblr.disabled.active,.btn-tumblr[disabled].active,fieldset[disabled] .btn-tumblr.active{background-color:#2c4762;border-color:rgba(0,0,0,0.2)}
.btn-twitter{color:#fff;background-color:#2ba9e1;border-color:rgba(0,0,0,0.2)}.btn-twitter:hover,.btn-twitter:focus,.btn-twitter:active,.btn-twitter.active,.open .dropdown-toggle.btn-twitter{color:#fff;background-color:#1c92c7;border-color:rgba(0,0,0,0.2)}
.btn-twitter:active,.btn-twitter.active,.open .dropdown-toggle.btn-twitter{background-image:none}
.btn-twitter.disabled,.btn-twitter[disabled],fieldset[disabled] .btn-twitter,.btn-twitter.disabled:hover,.btn-twitter[disabled]:hover,fieldset[disabled] .btn-twitter:hover,.btn-twitter.disabled:focus,.btn-twitter[disabled]:focus,fieldset[disabled] .btn-twitter:focus,.btn-twitter.disabled:active,.btn-twitter[disabled]:active,fieldset[disabled] .btn-twitter:active,.btn-twitter.disabled.active,.btn-twitter[disabled].active,fieldset[disabled] .btn-twitter.active{background-color:#2ba9e1;border-color:rgba(0,0,0,0.2)}
.btn-vk{color:#fff;background-color:#587ea3;border-color:rgba(0,0,0,0.2)}.btn-vk:hover,.btn-vk:focus,.btn-vk:active,.btn-vk.active,.open .dropdown-toggle.btn-vk{color:#fff;background-color:#4a6a89;border-color:rgba(0,0,0,0.2)}
.btn-vk:active,.btn-vk.active,.open .dropdown-toggle.btn-vk{background-image:none}
.btn-vk.disabled,.btn-vk[disabled],fieldset[disabled] .btn-vk,.btn-vk.disabled:hover,.btn-vk[disabled]:hover,fieldset[disabled] .btn-vk:hover,.btn-vk.disabled:focus,.btn-vk[disabled]:focus,fieldset[disabled] .btn-vk:focus,.btn-vk.disabled:active,.btn-vk[disabled]:active,fieldset[disabled] .btn-vk:active,.btn-vk.disabled.active,.btn-vk[disabled].active,fieldset[disabled] .btn-vk.active{background-color:#587ea3;border-color:rgba(0,0,0,0.2)}


/* 
 * Only for this example - not needed for the buttons
 * ----------------------------------------------------- */
.btn-social-icon {margin-bottom: 4px;}
.social-class .social-hex{font-family:Monaco,Menlo,Consolas,"Courier New",monospace;font-size:10px;opacity:.3;float:right}
.social-class li{margin-bottom:4px}.social-class li:hover .social-hex{opacity:1}
.social-class li:hover code{background-color:#e8e8ee}
.social-class code{cursor:default}



</style>







<!-- <div class="container" style="padding-top: 80px;"> -->
    	<div class="row" style="padding-top: 80px;">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="#" class="active" id="login-form-link">Login</a>
							</div>
							<div class="col-xs-6">
								<a href="#" id="register-form-link">Register</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
						
								<form id="login-form" method="post" action="LoginServlet" role="form" style="display: block;">
									<div class="form-group">
										<input type="text" name="username"  id="username" tabindex="1" class="form-control" value="" placeholder="Username">
									</div>
									<div class="form-group">
										<input type="password" name="userpass" id="password" tabindex="2" class="form-control" value="" placeholder="Password">
									</div>
									<div class="form-group text-center">
										<input type="checkbox" tabindex="3" class="" name="remember" id="remember">
										<label for="remember"> Remember Me</label>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="commit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Login">
												
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-lg-12">
												<div class="text-center">
													<a href="RecoverPassword.jsp" tabindex="5" class="forgot-password">Forgot Password?</a>
												</div>
											</div>
										</div>
									</div>
								</form>
								
								
								
				
								
								
								<form id="register-form" action="RegisterServletDB" method="post" role="form" style="display: none;">
								
								
  <div class="row">
    <div class="col-sm-5"  style="padding-left: 40px;">
								
								
								
								
								
								
								
																	<br><br>
								
									<div class="form-group">
										<input type="text" name="username" id="username" tabindex="1" class="form-control" placeholder="Username" value="">
									</div>
									<div class="form-group">
										<input type="email" name="email" id="email" tabindex="1" class="form-control" placeholder="Email Address (optional)" value="">
									</div>
									<div class="form-group">
										<input type="password" name="userpass" id="password" tabindex="2" class="form-control" placeholder="Password">
									</div>
									<div class="form-group">
										<input type="password" name="confirmPassword" id="confirm-password" tabindex="2" class="form-control" placeholder="Confirm Password">
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-register" value="Register Now">
											</div>
										</div>
									</div>
								
								
								
								
								
								
        </div>
    <div class="col-sm-2">
     <h3 style="text-align: center;">OR</h3>
    </div>
    
    
    <div class="col-sm-5 social-buttons" style="padding-right: 40px;">
    
    									<br><br>
    
       <a class="btn btn-block btn-social btn-facebook">
        <i class="fa fa-facebook"></i> Register with Facebook
      </a>
   
     
      <a class="btn btn-block btn-social btn-google-plus">
        <i class="fa fa-google-plus"></i> Register with Google
      </a>
      <a class="btn btn-block btn-social btn-instagram">
        <i class="fa fa-instagram"></i> Register with Instagram
      </a>
      <a class="btn btn-block btn-social btn-linkedin">
        <i class="fa fa-linkedin"></i> Register with LinkedIn
      </a>
      <a class="btn btn-block btn-social btn-pinterest">
        <i class="fa fa-pinterest"></i> Register with Pinterest
      </a>
      <a class="btn btn-block btn-social btn-tumblr">
        <i class="fa fa-tumblr"></i> Register with Tumblr
      </a>
      <a class="btn btn-block btn-social btn-twitter">
        <i class="fa fa-twitter"></i> Register with Twitter
      </a>
    
    
    
    
     
    </div>    
  </div>        

								
								
								
								
								
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
<!-- 	</div> -->


<form class="container" id="register-well" style="display: none;">

<div class="well" style="text-align: center;">

<h5>The email is needed for password reset. No emails will be sent to you. </h5>
<h6><b>Without email, your account with all your information will be lost if you lose your password.</b></h6>
</div>






</form>










<jsp:include flush="true" page="includes/include_footer.jsp"></jsp:include>