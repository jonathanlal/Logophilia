<jsp:include flush="true" page="includes/include_header.jsp"></jsp:include>
<%@ page import="logophilia.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<style>

.row{
/*     margin-top:40px; */
    padding: 0 10px;
}
.clickable{
    cursor: pointer;   
}

.panel-heading div {
	margin-top: -18px;
	font-size: 15px;
}
.panel-heading div span{
	margin-left:5px;
}
.panel-body{
	display: none;
}




</style>

<script>
(function(){
    'use strict';
	var $ = jQuery;
	$.fn.extend({
		filterTable: function(){
			return this.each(function(){
				$(this).on('keyup', function(e){
					$('.filterTable_no_results').remove();
					var $this = $(this), 
                        search = $this.val().toLowerCase(), 
                        target = $this.attr('data-filters'), 
                        $target = $(target), 
                        $rows = $target.find('tbody tr');
                        
					if(search == '') {
						$rows.show(); 
					} else {
						$rows.each(function(){
							var $this = $(this);
							$this.text().toLowerCase().indexOf(search) === -1 ? $this.hide() : $this.show();
						})
						if($target.find('tbody tr:visible').size() === 0) {
							var col_count = $target.find('tr').first().find('td').size();
							var no_results = $('<tr class="filterTable_no_results"><td colspan="'+col_count+'">No results found</td></tr>')
							$target.find('tbody').append(no_results);
						}
					}
				});
			});
		}
	});
	$('[data-action="filter"]').filterTable();
})(jQuery);

$(function(){
    // attach table filter plugin to inputs
	$('[data-action="filter"]').filterTable();
	
	$('.container').on('click', '.panel-heading span.filter', function(e){
		var $this = $(this), 
			$panel = $this.parents('.panel');
		
		$panel.find('.panel-body').slideToggle();
		if($this.css('display') != 'none') {
			$panel.find('.panel-body input').focus();
		}
	});
	$('[data-toggle="tooltip"]').tooltip();
})

</script>




<div class="container"  style="display: block;">



 <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
            <div class="pull-right">
                        <a  class="btn btn-default" role="button"> More Word Lists</a>
            
<!--             <a data-toggle="collapse" href="#collapse5" >Etymology</a>  -->
            <a id="addToWordList" data-toggle="collapse" href="#collapse5" class="btn btn-default" role="button"> Create Word List</a>
            </div>
<div class="pull-left">
                        		<form method="get" action="ChangeViewServletT">
             <button name="ViewL" type="submit" value="notnullmyfriend" class="btn btn-default" role="button"> View/layout <small><i class="glyphicon glyphicon-eye-open"></i></small></button>
            </form>
<!--             <form method="get" action="TestServlet"> -->
<!--   <button name="results" type="submit" value="list" class="btn btn-default" role="button"> Get results <small><i class="glyphicon glyphicon-eye-open"></i></small></button> -->
<!-- <br/> -->
<!-- </form>    -->
            </div>            
            
        </div>
         <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
            <div class="pull-right">
            
<!--             <a data-toggle="collapse" href="#collapse5" >Etymology</a>  -->
            <a> Total Words: 5212</a>
             
            </div>
        </div>


<div class="container" >
    <h1>Word Lists LIST<small><i class="glyphicon glyphicon-list"></i></small></h1>
 
    
    	<div class="row">




            <form method="get" action="WordListServlet">

<div class="list-group">
<c:forEach items="${Listresults}" var="list" varStatus="theCount">


  <a class="list-group-item">${list}	<span class="pull-right"><input type="submit" name="DeleteList${theCount.count}" value="Delete" class="btn btn-danger btn-xs"/><button name="OpenList" type="submit" value="${theCount.index}" class="btn btn-success btn-xs">Open</button></span></a>  





	</c:forEach>
</div>
</form>


			<hr/>

			</div>
			
			

			
		</div>
<!-- 	</div> -->










</div>






















<!-- <div class="panel panel-primary"> -->
<!-- 					<div class="panel-heading"> -->
<!-- 						<h3 class="panel-title">Your Lists</h3> -->
<!-- 						<div class="pull-right"> -->
<!-- 							<span class="clickable filter" data-toggle="tooltip" title="Toggle table filter" data-container="body"> -->
<!-- 								<i class="glyphicon glyphicon-filter"></i> -->
<!-- 							</span> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="panel-body"> -->
<!-- 						<input type="text" class="form-control" id="dev-table-filter" data-action="filter" data-filters="#dev-table" placeholder="Filter Lists" /> -->
<!-- 					</div> -->
<!-- 					<form method="get" action="WordListServlet"> -->
<!-- 					<table class="table table-hover" id="dev-table"> -->
<!-- 						<thead> -->
<!-- 							<tr> -->
<!-- 								<th>#</th> -->
<!-- 								<th>List Name</th> -->
<!-- 								<th>Description</th> -->
<!-- 								<th> </th> -->
						
<!-- 							</tr> -->
<!-- 						</thead> -->
					
<!-- 						<tbody> -->
						
			
			
			
<%-- 							<c:forEach items="${UserList}" var="list" varStatus="theCount"> --%>
							
<!-- 							<tr> -->
<%-- 								<td>${theCount.count}</td> --%>
<%-- 								<td>${list}</td> --%>
<!-- 								<td>Some description of file needs to go here</td> -->
<!-- 								<td> -->
								 
<!-- <!-- 								<input type="submit" name="OpenList" value="Open" class="btn btn-success btn-xs btn-block"/> Some text --> 
<%-- 								 <input type="submit" name="DeleteList${theCount.count}" value="Delete" class="btn btn-danger btn-xs btn-block"/> --%>
<!-- <!-- 								<div   class="btn btn-success btn-xs btn-block"> Delete </div> --> 
<%-- 								<button name="OpenList" type="submit" value="${theCount.index}" class="btn btn-success btn-xs btn-block">Open</button> --%>
<!-- 								</td> -->
						
<!-- 							</tr> -->
<%-- 									</c:forEach>	 --%>

<!-- 						</tbody> -->
<!-- 					</table> -->
<!-- 					</form> -->
<!-- 				</div> -->




<jsp:include flush="true" page="includes/include_footer.jsp"></jsp:include>