<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="jumbotron">

		<div class="container">

			<form method="post" enctype="multipart/form-data" action="UploadFile">


				<input type="text" name="description" /> <input type="file"
					name="file" /> <input type="submit" />


			</form>


		</div>


	</div>
	<h1>"${directory}"</h1>
	<h1>"${message}"</h1>
	<h1>"${filepath}"</h1>
	<h1>"${filename}"</h1>
	<h1>"${filetype}"</h1>
	<h1>"${filesize}"</h1>

	<img src="${filepath}">


	<hr />
	<div class="jumbotron">

		<img alt="" src="UploadFileController2">

	</div>




</body>
</html>