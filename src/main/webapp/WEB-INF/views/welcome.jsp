<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	    <link href="<c:url value='/resources/css/bootstrap.min.css' />"  rel="stylesheet">

</head>
<body>

	<div class="jumbotron">
		<h1 class="display-4">Hello, ${greeting}</h1>
		<p class="lead">This is a simple hero unit, a simple
			jumbotron-style component for calling extra attention to featured
			content or information.</p>
		<hr class="my-4">
		<p>It uses utility classes for typography and spacing to space
			content out within the larger container.</p>
		<a class="btn btn-primary btn-lg" href="#" role="button">Learn
			more</a>
	</div>
	<!-- Script javaScript -->
	<script src="<c:url value='/resources/js/jquery-3.4.1.min.js' />"></script>
	<script src="<c:url value='/resources/js/bootstrap.min.js' />"></script>
</body>
</html>