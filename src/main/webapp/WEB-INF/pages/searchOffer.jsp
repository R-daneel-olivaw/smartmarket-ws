<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="../../assets/ico/favicon.ico">

<title>search offer</title>

<!-- Bootstrap core CSS -->

<%-- <c:url value="/resources/css/main.css" />" rel="stylesheet"> --%>

<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/narrowBootstrap.css"/>"
	rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy this line! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
      <![endif]-->
</head>

<body>

	<div class="container">
		<div class="header">
			<h3 class="text-muted">Search for offers</h3>
		</div>

		<div class="jumbotron">


			<p>Let's go fishing</p>
			<p>let us know where to look!</p>

			<form:form method="GET" commandName="command" class="form-horizontal"
				role="form" action="offerSearch/getOffersByCityMarket">

				<div class="form-group">
					<label for="text" class="col-sm-3 control-label">City*</label>
					<div class="col-sm-8">
						<form:input path="cityName" type="text" class="form-control"
							id="inputPassword3" placeholder="enter city name" />
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-3 control-label">Market*</label>
					<div class="col-sm-8">
						<form:input path="marketName" type="text" class="form-control"
							id="inputEmail3" placeholder="enter market name" />
					</div>
				</div>
				<!-- <div class="form-group">
					<a href="javascript:requestOffers()"><button type="button"
							class="btn btn-primary btn-lg active">start looking</button></a>
				</div> -->

				<div class="form-group">
					<input type="submit" value="Search" name="_step"
						class="btn btn-primary btn-lg active" />
				</div>
			</form:form>
		</div>

		<table>
			<c:forEach var="offer" items="${searchResults}"
				varStatus="varCounter">
				<tr>
					<td><c:out value="${offer.offer}" /></td>
					<td><c:out value="${offer.seller.sellerName}" /></td>
				</tr>
			</c:forEach>
		</table>

		<div class="row marketing">
			<div class="col-lg-6"></div>
		</div>

		<div class="footer">
			<p>&copy; Company 2014</p>
		</div>

	</div>
	<!-- /container -->


	<!-- Bootstrap core JavaScript
      ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

	<script type="application/javascript">
		
		
		
      function requestOffers()
      {
          
              $.ajax({
          type: "GET",
          url: "offerSearch/getOffersByCityMarket",
		  dataType: 'json',
          data: {
    				market:"sector-18",
				    city:"noida"
  				},
          success: function(data,response) {
              if(response == "success")
              {
                  //var offer = jQuery.parseJSON(respose);
				  alert( data[1].offer );
              }
          }
      });
          
//          var offer = jQuery.parseJSON( '[{"offer":"Buy 1 Get 1","offerType":"Free","seller":{"sellerName":"Anugrah","sellerCity":"noida","sellerMarket":"sector-18"}},{"offer":"50% OFF","offerType":"Discount","seller":{"sellerName":"Akshat","sellerCity":"noida","sellerMarket":"sector-18"}}]' );
//          alert( offer[1].offer );
      }
      
	
	
	
	
	
	
	
	
	
	</script>

</body>
</html>
