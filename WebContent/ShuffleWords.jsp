

<jsp:include flush="true" page="includes/include_header.jsp"></jsp:include>

<style>


.btn-outlined {
    border-radius: 0;
    -webkit-transition: all 0.3s;
       -moz-transition: all 0.3s;
            transition: all 0.3s;
}

.btn-outlined.btn-theme {

    background: none;
    color: #6f5499;
	border-color: #6f5499;
}

.btn-outlined.btn-theme:hover,
.btn-outlined.btn-theme:active {
    color: #FFF;
    background: #6f5499;
    border-color: #6f5499;
}

.btn-outlined.btn-black {
    background: none;
    color: #000000;
	border-color: #000000;
}

.btn-outlined.btn-black:hover,
.btn-outlined.btn-black:active {
    color: #FFF;
    background: #000000;
    border-color: #000000;
}

.btn-outlined.btn-white {
    background: none;
    color: #FFFFFF;
	border-color: #FFFFFF;
}

.btn-outlined.btn-white:hover,
.btn-outlined.btn-white:active {
    color: #6f5499;
    background: #FFFFFF;
    border-color: #FFFFFF;
}


</style>


	




<div class="container">

 <div class="row">
 
	  <div class="col-md-1" >
	  
      </div>
      
	  <div class="col-md-10" >


    <form method="get" action="UpdateErosServlet">
  <button name="results" value="add" type="submit" class="btn btn-default" role="button"><i class="glyphicon glyphicon-plus"></i></button>
  <button name="results" value="subtract" type="submit" class="btn btn-default" role="button"><i class="glyphicon glyphicon-minus"></i></button>

</form> 





	</div>

 
	  <div class="col-md-1" >
	    <button name="results" value="add" type="submit" class="btn btn-default" role="button"><i class="glyphicon glyphicon-plus"></i></button>
	  
       </div>
       
       
</div>
           
</div>
<div class="container">
<div class="well" style="height: 280px;text-align: center;">

<br>
<br>
<br>
<br>

<h1>Definitions</h1>

</div>





<a style="height: 90px;" class="btn btn-outlined btn-block btn-theme btn-lg" data-wow-delay="0.7s"><br>Dummy word 1</a>
<a style="height: 90px;" class="btn btn-outlined btn-block btn-theme btn-lg" data-wow-delay="0.7s"><br>Dummy word 2</a>
<a style="height: 90px;" class="btn btn-outlined btn-block btn-theme btn-lg" data-wow-delay="0.7s"><br>Dummy word 3</a>

<div class="pull-right">
<button class="btn-xs"></button>
<button>Skip -2 Eros</button>

</div>

<div class="progress">
  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40"
  aria-valuemin="0" aria-valuemax="100" style="width:40%">
    40% Complete (success)
  </div>
</div>


</div>





























<jsp:include flush="true" page="includes/include_footer.jsp"></jsp:include>