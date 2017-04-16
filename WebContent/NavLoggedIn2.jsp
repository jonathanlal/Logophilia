
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



<style>


.dropdown-submenu {
    position: relative;
}

.dropdown-submenu>.dropdown-menu {
    top: 0;
    left: 100%;
    margin-top: -6px;
    margin-left: -1px;
    -webkit-border-radius: 0 6px 6px 6px;
    -moz-border-radius: 0 6px 6px;
    border-radius: 0 6px 6px 6px;
}

.dropdown-submenu:hover>.dropdown-menu {
    display: block;
}

.dropdown-submenu>a:after {
    display: block;
    content: " ";
    float: right;
    width: 0;
    height: 0;
    border-color: transparent;
    border-style: solid;
    border-width: 5px 0 5px 5px;
    border-left-color: #ccc;
    margin-top: 5px;
    margin-right: -10px;
}

.dropdown-submenu:hover>a:after {
    border-left-color: #fff;
}

.dropdown-submenu.pull-left {
    float: none;
}

.dropdown-submenu.pull-left>.dropdown-menu {
    left: -100%;
    margin-left: 10px;
    -webkit-border-radius: 6px 0 6px 6px;
    -moz-border-radius: 6px 0 6px 6px;
    border-radius: 6px 0 6px 6px;
}


img.listsChart{
   height:40px;

}

img.eros{
   height:18px;

}

img.lists{
   height:20px;

}
</style>




<div class="navbar-more-overlay"></div>

	<nav class="navbar navbar-custom navbar-fixed-top animate" >
		<div class="navbar-more">
		
					<div class="navbar-header hidden-xs">
									    				<a href="/" class="navbar-left" style="padding-left: 10px;padding-top: 1px;">    <img src="img/logov2.png" height="40px"></a>
					
				<a class="navbar-brand" href="/" style="text-decoration: none;">Logophilia</a>
			</div>
		
					<ul class="nav navbar-nav navbar-right" style="display: inline;padding-right: 10px;" id="menu">
					
					
					
		 <c:if test="${fn:contains(AccountType, 'admin')}">
		
						<li class="hidden-xs">
					<a href="/Admin.jsp">
											<span class="hidden-xs">Admin</span>
					
				</a>
				</li>
		        </c:if>    				
		


			<li class="hidden-xs">
				
<!-- 									<a href="/search/">			<span class="hidden-xs">Search Here</span> </a> -->
				
				        <form action="GetWordInfo" class="navbar-form" role="search">
        <div class="input-group">
            <input type="text" class="form-control" placeholder="Search" name="query">
            <div class="input-group-btn">
                <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
            </div>
        </div>
        </form>
				
				</li>
				
				
				
						<li class="dropdown hidden-xs"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><img class="eros" src="img/eros2.png">
 <strong>${eros}</strong> Eros <span class="label label-info">${currenteros}</span>
                </a>
                
                     <ul class="dropdown-menu">
                     
                     
				<li><a href="/LeaderBoardServlet"><img class="listsChart" src="img/charts.gif"> Users</a></li>
                     
                        <li><a href="About.jsp"><span class="glyphicon glyphicon-play"></span> More info</a></li>
					 <li><a href="Eros.jsp"><span class="glyphicon glyphicon-play"></span> Eros Info</a></li>
                        

                    </ul>
                </li>
				
				
              <li class="dropdown hidden-xs"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><img class="lists" src="img/lists.png"> Lists 
                </a>
                    <ul class="dropdown-menu">
                                            <li><a href="WordListIndex.jsp"><img class="lists" src="img/menu2.png"> Words </a></li>
                                              <li><a href="QuoteListIndex.jsp"><img class="lists" src="img/quotes2.png"> Quotes </a></li>
<!-- 						 <li><a style="text-align: left;" href="ShuffleWords.jsp"><img class="listsShuffle" src="img/shuffle2.gif"> Shuffle</a></li> -->
                       
<!--                         <li><a href="#"><span class="label label-warning">5:00 AM</span> "user" following your "list"</a></li> -->
    <li> <hr style="margin-bottom: 5px;margin-top: 5px;"/> </li>
    
    				
    
    
<!--     			 <li class="divider"></li> -->
              <li class="dropdown-submenu">
                <a tabindex="-1" href="#"><span class="glyphicon glyphicon-plus"></span> Create...</a>
           
                <ul class="dropdown-menu">
<!--                   <li><a tabindex="-1" href="#">Second level</a></li> -->

                  <li><a href="CreateNewWordList.jsp">Word List</a></li>
                  <li><a href="CreateNewQuoteList.jsp">Quote List</a></li>
                </ul>
              </li>
    
    
    
    
    <!--                   <li class="dropdown-submenu"> -->
<!--                     <a href="#">Even More..</a> -->
<!--                     <ul class="dropdown-menu"> -->
<!--                         <li><a href="#">3rd level</a></li> -->
<!--                     	<li><a href="#">3rd level</a></li> -->
<!--                     </ul> -->
<!--                   </li> -->
    
    
    
    
<!--                         <li><a href="CreateNewWordList.jsp" class="text-center"><span class="glyphicon glyphicon-plus"></span> New Word List</a></li> -->
<!--                          <li><a href="CreateNewQuoteList.jsp" class="text-center"><span class="glyphicon glyphicon-plus"></span> New Quote List</a></li> -->
                    </ul>
                </li>
				
		                <li  class="dropdown hiddex-xs"><a href="#" class="dropdown-toggle hidden-xs" data-toggle="dropdown">
                
                
<!--                    <img align="left" class="fb-image-profile thumbnail" src=""> -->
                
                						<c:if test="${not fn:containsIgnoreCase(notificationsSize, '0')}">
						<span class="label label-danger">
						${notificationsSize}
						</span>
						</c:if><strong style="padding-left: 5px;"> ${loggedInUser}</strong>  <b class="caret"></b><img src="${profileImg}" class="resizeUserShard2">
                </a>
<!--                 			<form action="LogOutServlet" method="get"> -->
                
                    <ul class="dropdown-menu">
                        <li><a href="UserProfile.jsp"><span class="glyphicon glyphicon-user"></span> Profile</a></li>
                        
<!--                    <i class="fa fa-flag" aria-hidden="true"> </i>-->
						<li><a href="Notifications.jsp"><img class="lists" src="img/flag.gif"> Notifications 
						
						<c:if test="${not fn:containsIgnoreCase(notificationsSize, '0')}">
						<span class="label label-danger">
						${notificationsSize}
						</span>
						</c:if>
						
						</a></li>
                                                <li><a href="Settings.jsp"><img class="lists" src="img/settings.gif">  Settings</a></li>
    <li> <hr style="margin-bottom: 5px;margin-top: 5px;"/> </li>
    
    
    				<li><a href="/logout"><img class="listsLogout" src="img/logout.gif"> Logout</a></li>
    
<!--                         <li> <input type="submit" name="action" value="Logout" class="btn btn-default btn-block"/></li> -->
                        
                    </ul>
<!--                     </form> -->
                </li>
				
				
</ul>
				    
	
			 
	</div>										
					        
						  

		
		
		
		
		
		
		
		
		
		
		


			<ul class="nav navbar-nav navbar-right mobile-bar" style="margin-top: 8px;">
			
							<li class="visible-xs" style="margin-top: -4px;">
					<a href="/search/">
						<span class="menu-icon fa fa-search"></span>
			
						<span class="visible-xs">Search</span>	
					</a>
				</li>
			

				

				<li class="visible-xs" style="margin-top: -4px;">
					<a href="/talks" style="margin-left: 3px;">
						<span class="menu-icon fa fa-info"></span>
			
						<span class="visible-xs">Eros</span>
					</a>
				</li>





				<li class="visible-xs" style="margin-top: -4px;">
					<a href="/tracking" style="margin-right: -5px;">

<span class="menu-icon"><img src="/img/Track.png" style="width: 25px;"><br></span>
						<span class="visible-xs">Lists</span>
					</a>
				</li>




<!-- 				<li class="visible-xs" style="margin-top: -4px;"> -->
<!-- 					<a href="/quotes" style="margin-left: 10px;"> -->
<!-- 										<span class="menu-icon fa fa-quote-right"></span>						 -->

			
<!-- 								<span class="visible-xs">Quotes</span> -->
<!-- 					</a> -->
<!-- 				</li> -->




<!-- 		add this to css dropdown		dropdown-backdrop -->





<!-- <li class="hidden-xs dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"> -->
                
                
                
<%--                <strong> ${username}</strong>  <b class="caret"></b> --%>
<%--                <img src="${imgProfile}" class="resizeUserShard2"> --%>
<!--                 </a> -->

<!--   <ul class="dropdown-menu"> -->

                        

<!-- 	 <li><a href="/tracking"><img class="lists" src="/img/Track.png" style="padding-right: 7px;"> Talk Tracker</a></li> -->
<!-- 					 <li><a href="/profile"><img class="lists" src="/img/profile.png" style="padding-right: 7px;">  Profile</a></li> -->
<!--                                                 <li><a href="../Settings.jsp"><img class="lists" src="/img/settings.gif">  Settings</a></li> -->
                                                 
<!--     <li> <hr style="margin-bottom: 5px;margin-top: 5px;"/> </li> -->
    
    
<!--     				<li><a href="/logout"><img class="listsLogout" src="/img/logout.gif"> Logout</a></li> -->
    
                        
<!--                     </ul> -->

<!-- 				</li> -->







				<li class="visible-xs dropdown" style="margin-top: -4px;" >
				
<a href="#" class="dropdown-toggle" data-toggle="dropdown">
					
 <b class="caret" style="padding-right: 0;"></b>
				<img src="${profileImg}" class="resizeUserShard2mobile" style="margin-left: 0;"><br>
						          <span style="padding-left: 10px;padding-top: 10px;">${loggedInUser}</span>       
					</a>
					
					
					
					
					 <ul class="dropdown-menu" style="background-color: white;">

                        
	 <li><a href="/quotes"><span class="menu-icon fa fa-quote-left"></span> Notifications</a></li>

					 <li><a href="/user/${loggedInUser}"><img class="lists" src="/img/profile.png" style="padding-right: 7px;">  Profile</a></li>
                                                <li><a href="/settings/"><img class="lists" src="/img/settings.gif">  Settings</a></li>
                                                 
    <li> <hr style="margin-bottom: 5px;margin-top: 5px;"/> </li>
    
    
    				<li><a href="/logout"><img class="listsLogout" src="/img/logout.gif"> Logout</a></li>
    
                        
                    </ul>
					
					
					
					
					
					
					
				</li>
				
				
				
				
				
				
			</ul>

	</nav>
	
	
	 <br/> <br/> <br/>	<br>
	
	
	
	
	
