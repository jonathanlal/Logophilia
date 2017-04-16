<jsp:include flush="true" page="includes/include_header.jsp"></jsp:include>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> --%>



<style>


#pinBoot {
  position: relative;
  max-width: 100%;
  width: 100%;
}
img.word {
  width: 100%;
  max-width: 100%;
  height: auto;
}
.white-panel {
  position: absolute;
/*   background: white; */
  box-shadow: 0px 1px 2px rgba(0, 0, 0, 0.3);
  padding: 10px;
}
/*
stylize any heading tags withing white-panel below
*/

.white-panel h1 {
  font-size: 1em;
}
.white-panel h1 a {
  color: #A92733;
}
.white-panel:hover {
  box-shadow: 1px 1px 10px rgba(0, 0, 0, 0.5);
  margin-top: -5px;
  -webkit-transition: all 0.3s ease-in-out;
  -moz-transition: all 0.3s ease-in-out;
  -o-transition: all 0.3s ease-in-out;
  transition: all 0.3s ease-in-out;
}

/* image thumbnail */
.thumb {
    display: block;
	width: 100%;
	margin: 0;
}

/* Style to article Author */
.by-author {
	font-style: italic;
	line-height: 1.3;
	color: #aab6aa;
}

/* Main Article [Module]
-------------------------------------
* Featured Article Thumbnail
* have a image and a text title.
*/
.featured-article {
	width: 482px;
	height: 350px;
	position: relative;
	margin-bottom: 1em;
}

.featured-article .block-title {
	/* Position & Box Model */
	position: absolute;
	bottom: 0;
	left: 0;
	z-index: 1;
	/* background */
	background: rgba(0,0,0,0.7);
	/* Width/Height */
	padding: .5em;
	width: 100%;
	/* Text color */
	color: #fff;
}

.featured-article .block-title h2 {
	margin: 0;
}

/* Featured Articles List [BS3]
--------------------------------------------
* show the last 3 articles post
*/

.main-list {
	padding-left: .5em;
}

.main-list .media {
	padding-bottom: 1.1em;
	border-bottom: 1px solid #e8e8e8;
}


</style>















<div class="row">

     <div class="col-md-2" style="padding-left: 40px;">
<!--          <form method="post" action="/CreateUserBucket" > -->
         
         
     <button class="btn btn-lg" type="submit">
     Create Bucket
     
     </button>
     
<!--      </form> -->
     
     
     
	</div>
	
	


   <div class="col-md-6">
   
   
   
   
   
    <h1>Hello Google Cloud Storage!</h1>

  <table>
    <tr>
      <td style="font-weight: bold;">Upload a file to Google Cloud Storage:</td>
    </tr>
    <tr>
<!--[START user_input]-->      
      <td>
<!--         <form action="/CreateUserBucket" enctype="text/plain" method="get" name="putFile" id="putFile"> -->
          <div>
            Bucket: <input type="text" name="bucket" />
            File Name: <input type="text" name="fileName" />
            <br /> File Contents: <br />
            <textarea name="content" id="content" rows="3" cols="60"></textarea>
            <br />
            <input type="submit" onclick='uploadFile(this)' value="Upload Content" />
          </div>
<!--         </form> -->
      </td>
    </tr>
    <tr>
      <td style="font-weight: bold;">Download a file from Google Cloud Storage:</td>
    </tr>
    <tr>
      <td>
        <form name="getFile">
          <div>
            Bucket: <input type="text" name="bucket" id="bucket" />
            File Name: <input type="text" name="fileName" id="fileName" />
          </div>
        </form>
        <form action="/index.html" method="get" name="submitGet">
          <div>
            <input type="submit" onclick='changeGetPath(this)' value="Download Content" />
          </div>
        </form>
      </td>
    </tr>
<!--[END user_input]-->    
  </table>
   
   
   
   
   
   
   
   
   

</div>






     <div class="col-md-4" style="padding-right: 40px;">
     

	</div>










 



<!-- ROW DIV -->
</div>




  <script>
      function setDownloadDefaults() {
        var url = location.search;
        var bucketArg = url.match(/bucket=[^&]*&/);
        if (bucketArg !== null) {
          document.getElementById("bucket").value = bucketArg.shift().slice(7, -1);
        }
        var fileArg = url.match(/fileName=[^&]*&/);
        if (fileArg !== null) {
          document.getElementById("fileName").value = fileArg.shift().slice(9, -1);
        }
      }
      function changeGetPath() {
        var bucket = document.forms["getFile"]["bucket"].value;
        var filename = document.forms["getFile"]["fileName"].value;
        if (bucket == null || bucket == "" || filename == null || filename == "") {
          alert("Both Bucket and FileName are required");
          return false;
        } else {
          document.submitGet.action = "/gcs/" + bucket + "/" + filename;
        }
      }
      function uploadFile() {
        var bucket = document.forms["putFile"]["bucket"].value;
        var filename = document.forms["putFile"]["fileName"].value;
        if (bucket == null || bucket == "" || filename == null || filename == "") {
          alert("Both Bucket and FileName are required");
          return false;
        } else {
          var postData = document.forms["putFile"]["content"].value;
          document.getElementById("content").value = null;
          var request = new XMLHttpRequest();
          request.open("POST", "/gcs/" + bucket + "/" + filename, false);
          request.setRequestHeader("Content-Type", "text/plain;charset=UTF-8");
          request.send(postData);
        }
      }
    </script>









<jsp:include flush="true" page="includes/include_footer.jsp"></jsp:include>