
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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





img.shard{
   height:23px;
/*       margin-bottom: 10px; */
   

}
img.eros{
   height:18px;

}


img.listsChart{
   height:40px;

}

img.lists{
   height:20px;

}
img.listsShuffle{
   max-height:30px;

}
img.listsLogout{
   max-height:35px;

}

img.resizeUserShard2{
/*    height:34px; */
/*    height:50px; */
/*    width:50px; */
   height:35px;
   width:35px;
/*    display: block; */
/*     margin-left: auto; */
    margin-right: auto;
     margin-left: 10px; */
/*     margin-bottom: 3px; */
   
   
/*    height:40px; */
}

.caret-up {
    width: 0; 
    height: 0; 
    border-left: 4px solid rgba(0, 0, 0, 0);
    border-right: 4px solid rgba(0, 0, 0, 0);
    border-bottom: 4px solid;
    
    display: inline-block;
    margin-left: 2px;
    vertical-align: middle;
}
</style>
 <link rel="icon" href="img/shards.ico"/>

<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
<nav class="navbar navbar-custom navbar-fixed-top" role="navigation"  style="height: 56px;">
<!-- <div class="container-fluid"> -->

<div class="row">

<!-- <div class="row" style="border-bottom: 2px solid white;"> -->

						
	    <div class="col-sm-12">
	  

				    				<a href="/" class="navbar-left" style="padding-left: 10px;padding-top: 10px;">    <img src="img/logov2.png" height="40px"></a>
				    
					    <div class="navbar-header">
					      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					        <span class="sr-only">Toggle navigation</span>
					        <span class="icon-bar"></span>
					        <span class="icon-bar"></span>
					        <span class="icon-bar"></span>
					      </button>
					     <a class="navbar-brand" href="/" style="margin-left: -10px;margin-top: 6px;">Logophilia</a>
					    </div>
					    
					    
					    
						
						   


	 <!-- Collect the nav links, forms, and other content for toggling -->
						    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="padding-left:30px;">
	
<!-- 						      <ul class="nav navbar-nav" > -->
						      

						        
<!-- 						        <li class="dropdown"> -->
						        

						        
						        
<!--  <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span style="padding-bottom: 10px;" class="glyphicon glyphicon-book" aria-hidden="true"> </span></a> -->
<!-- 						          <ul class="dropdown-menu" role="menu"> -->
<!-- 						            <li><a href="test.jsp">test.jsp</a></li> -->
<!-- 						            <li><a href="#">Explore users?</a></li> -->
<!-- 						            <li><a href="#">Random word</a></li> -->
<!-- 						            <li class="divider"></li> -->
<!-- 						            <li><a href="#">Buy credits</a></li> -->
<!-- 						            <li class="divider"></li> -->
<!-- 						            <li><a href="#">Generate definition of word on image of your choosing</a></li> -->
<!-- 						             <li class="divider"></li> -->
<!-- 						            <li><a href="#">+ Let user add their own links here (to a specific list, article etc)</a></li> -->
<!-- 						          </ul> -->
<!-- 						        </li> -->
<!-- 						      </ul> -->
						    
	
						      


	 
	 <ul class="nav navbar-nav">
	 <li>

							<form id="searchForm" method="get" action="GetWordInfo" class="navbar-form" role="search">  
							<div class="input-group">
    <input id="s" type="text" name="query" class="form-control" placeholder="Probe for..." data-toggle="tooltip" title="Remember to add tooltips on the page" style="width:100%;height:40px;" />
    <span class="input-group-addon">
        <i class="glyphicon glyphicon-search"></i>
    </span>
</div>
</form>
</li>
	</ul>
<!-- 	https://www.google.co.uk/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png -->
	
<!-- 	<i class="fa fa-diamond" aria-hidden="true"></i> -->

		                                	<form action="NavBarServLet" method="get">
		
			<ul class="nav navbar-nav navbar-right" style="display: inline;padding-right: 50px" id="menu">
			
			
						<li style="padding-top: 7px;" class="dropdown hidden-xs"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><img class="eros" src="img/eros2.png">
 <strong>${eros}</strong> Eros <span class="label label-info">${currenteros}</span>
                </a>
                
                     <ul class="dropdown-menu">
                     
                     
				<li><a href="/LeaderBoardServlet"><img class="listsChart" src="img/charts.gif"> Users</a></li>
                     
                        <li><a href="About.jsp"><span class="glyphicon glyphicon-play"></span> More info</a></li>
					 <li><a href="Eros.jsp"><span class="glyphicon glyphicon-play"></span> Eros Info</a></li>
                        

                    </ul>
                </li>
			
<!-- 			<li style="margin-top: 7px;" class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><img class="shard" src="img/crashshard2mult.png"> -->
<!-- 			 Shards  -->
<!--                 </a> -->
<!--                     <ul class="dropdown-menu"> -->
<!--                         <li><a href="#"><img class="lists" src="img/ShardMENU.gif">  Articles</a></li> -->
<!--                         <li><a href="Articles.jsp"><img class="lists" src="img/MyShards.gif">  My Shards</a></li> -->
<!--     <li> <hr style="margin-bottom: 5px;margin-top: 5px;"/> </li> -->
<!--                         <li><a href="CreateNewShard.jsp"  class="text-center"><img class="lists" src="img/createshared.gif"> Create New Shard</a></li> -->
<!--                     </ul> -->
<!--                 </li> -->
                
                <li style="padding-top: 7px;" class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><img class="lists" src="img/lists.png"> Lists 
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
                <li  class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">
                
                
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
			                    </form>





	</div>
		 
			 
	</div>										
					        
						  
						      
	</div>					      
						    

 </nav>  
 
 </div>
 
 <br/> <br/> <br/>							    
<a class="fb-like" data-share="true" data-show-faces="true" style="padding-left: 2px;"></a>	
<hr/>