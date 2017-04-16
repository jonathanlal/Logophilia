
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>








<div class="navbar-more-overlay"></div>

	<nav class="navbar navbar-custom navbar-fixed-top animate" >
		<div class="navbar-more">
		
					<div class="navbar-header hidden-xs">
														    				<a href="/" class="navbar-left" style="padding-left: 10px;padding-top: 1px;">    <img src="img/logov2.png" height="40px"></a>
					
				<a class="navbar-brand" href="/" style="text-decoration: none;">Logophilia</a>
			</div>
		
					<ul class="nav navbar-nav navbar-right" style="display: inline;padding-right: 10px;" id="menu">
					
					
					
<%-- 		 <c:if test="${fn:contains(AccountType, 'admin')}"> --%>
		
<!-- 						<li class="hidden-xs"> -->
<!-- 					<a href="/Admin.jsp"> -->
<!-- 											<span class="hidden-xs">Admin</span> -->
					
<!-- 				</a> -->
<!-- 				</li> -->
<%-- 		        </c:if>    				 --%>
		
<!-- 			<li class="hidden-xs"> -->
				
<!-- 									<a href="/talks/">			<span class="hidden-xs">Posts</span> </a> -->
				
<!-- 				</li> -->


			<li class="hidden-xs">
				
<!-- 									<a href="/search/">			<span class="hidden-xs">Search</span> </a> -->
				
<!-- 				    <div class="col-sm-3 col-md-3"> -->
        <form action="GetWordInfo" class="navbar-form" role="search">
        <div class="input-group">
            <input type="text" class="form-control" placeholder="Search" name="query">
            <div class="input-group-btn">
                <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
            </div>
        </div>
        </form>
<!--     </div> -->
				
				</li>
				
				
				

				
				
				
		                <li class="dropdown" class="hidden-xs">
           
                <a href="/login.jsp" class="hidden-xs">
                <span class="glyphicon glyphicon-user">
                </span> Login 
           
                </a>

                </li>
				
				
</ul>
				    
	
			 
	</div>										
					        
						  

		
		
		
		
		
		
		
		
		
		
		


			<ul class="nav navbar-nav navbar-right mobile-bar" style="margin-top: 8px;">
			
							<li class="visible-xs" style="margin-top: -4px;">
<!-- 					<a href="/search/"> -->
<!-- 						<span class="menu-icon fa fa-search"></span> -->
			
<!-- 						<span class="visible-xs">Search</span>	 -->
<!-- 					</a> -->
<form action="GetWordInfo" class="navbar-form" role="search">
        <div class="input-group">
            <input type="text" class="form-control" placeholder="Search" name="query">
            <div class="input-group-btn">
                <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
            </div>
        </div>
        </form>



				</li>
			

				

<!-- 				<li class="visible-xs" style="margin-top: -4px;"> -->
<!-- 					<a href="/talks/"> -->
<!-- 						<span class="menu-icon fa fa-info"></span> -->
			
<!-- 						<span class="visible-xs">Talks</span> -->
<!-- 					</a> -->
<!-- 				</li> -->


				<li class="visible-xs" style="margin-top: -4px;">
					<a href="/login.jsp">
						<span class="menu-icon fa fa-sign-in"></span>
			
						<span class="visible-xs">Login</span>
					</a>
				</li>



<!-- 				<li class="visible-xs" style="margin-top: -4px;"> -->
<!-- 					<a href="/TalkTracking"> -->

<!-- <span class="menu-icon"><img src="/img/Track.png" style="width: 25px;"><br></span> -->
<!-- 						<span class="visible-xs">Talk Tracker</span> -->
<!-- 					</a> -->
<!-- 				</li> -->




<!-- 				<li class="visible-xs" style="margin-top: -4px;"> -->
<!-- 					<a href="/quotes"> -->
<!-- 										<span class="menu-icon fa fa-quote-right"></span>						 -->

			
<!-- 								<span class="visible-xs">Quotes</span> -->
<!-- 					</a> -->
<!-- 				</li> -->




				
<!-- 				<li class="visible-xs" style="margin-top: -4px;"> -->
				
<!-- <a href="/Profile"> -->
					

<%-- 				<img src="${imgProfile}" class="resizeUserShard2mobile"><br> --%>
<!-- 						          <span style="padding-left: 10px;padding-top: 10px;">Profile</span>        -->
<!-- 					</a> -->
<!-- 				</li> -->
			</ul>

	</nav>
	
	
	
	
	
	
	
 <br/> <br/> <br/>							    
<br>
	
