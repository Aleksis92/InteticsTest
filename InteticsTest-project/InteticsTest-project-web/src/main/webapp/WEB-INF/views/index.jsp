<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<!Doctype>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<title>Image Previewer</title>
		<c:url var="css_url" value="/webContent/CSS/style.css" />
		<c:url var="jquery_url" value="/webContent/JS/jquery-3.2.1.min.js" />
		<c:url var="custom_js_url" value="/webContent/JS/index.js" />
		<c:url var="add_img_url" value="/webContent/Images/add.png" />
		<c:url var="add_logo_url" value="/webContent/Images/logo.png" />
		<link href="${css_url}" rel="stylesheet" type="text/css"/>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous"/>
		<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
	</head>
	</head>
	<body>

	<!-- HTML-код модального окна -->
	<div id="new-image-modal" class="modal fade">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Add image</h4>
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>

				</div>

				<div class="modal-body">
					<div class="container-fluid no-padding-left-right">
						<spring:form id="images-form" class="box" method="post" action="/api/Images" enctype="multipart/form-data" modelAttribute="ImageFromJSP">
							<div class="row">
								<div class="col-7">
										<div class="box__input vertical-align-middle">
											<input class="box__file inputfile" type="file" name="image" id="file" data-multiple-caption="{count} files selected" multiple />
											<label id="box__label" for="file"><strong>Choose a file</strong><span class="box__dragndrop"> or drag it here</span>.</label>
										</div>
										<div class="box__uploading">Uploading&hellip;</div>
										<div class="box__success">Done!</div>
										<div class="box__error">Error! <span></span>.</div>
								</div>
								<div class="col-5">
									<h5 class="box-content">Name your media</h5>
									<spring:input path="name" type="text" name="image-name" class="box-content"/>
									<h5 class="box-content">Add tags</h5>
									<spring:textarea path="description" id="image-tags"  name="image-tags"></spring:textarea>
									<input class="box-content" type="text" id="image-tags-input" name="image-tags-input"/>
									<h5 class="box-content">Add description</h5>
									<spring:textarea path="tags" class="box-content"  name="image-description"></spring:textarea>
									<button class="box__button btn btn-primary" type="submit">Upload</button>
								</div>
							</div>
						</spring:form>
					</div>
				</div>
				<div class="modal-footer">
				</div>
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row">
			<!-- Header -->
			<div class="container container-background  no-padding-left-right" >
				<div id="header" class="row border-bottom no-gutters" >
					<div class="col-7 vertical-align-middle">
						<img class="header-content-margin" src="${add_logo_url}">
						<h5 class="header-content-margin text-grey"><strong>Welcome to Image Previewer!</strong></h5>
					</div>
					<div class="col-4 vertical-align-middle justify-content-end">
						<h5 class="header-content-margin text-grey"><strong>Hi, ${AllUserData.username}</strong></h5>
					</div>
					<div class="col-1 vertical-align-middle justify-content-end">
						<a class="header-content-margin" href="/logout.html"> <i class="fa fa-sign-out fa-2x" aria-hidden="true"></i> </a>
					</div>
				</div>
			</div>

		</div>
		<div class="row">
			<!-- Search -->
			<div class="container container-background  no-padding-left-right" >
				<div id="search" class="row" >
					<div class="col-12">
						<form id="search-form" class="form-group vertical-align-middle justify-content-between" action="/search">
							<input id="search-input" type="text" class="form-control search-size " placeholder="Write tags here">
							<button id="search-button" class="btn btn-info">Search</button>
						</form>
					</div>
				</div>
				<div id="tags" class="row" >
					<div class="col-12">
						<div class="btn-group btn-primary-outline">
							<button type="button" class="btn btn-primary tags-button-size">1</button>
							<button type="button" class="btn btn-primary tags-button-size">2</button>
							<button type="button" class="btn btn-primary tags-button-size">3</button>
							<button type="button" class="btn btn-primary tags-button-size">4</button>
							<button type="button" class="btn btn-primary tags-button-size">5</button>
							<button type="button" class="btn btn-primary tags-button-size">6</button>
						</div>
					</div>
				</div>

			</div>

		</div>

		<div class="row" >
		<!-- Images -->
			<div class="container container-background" >
				<div id="row" class="row">
					<div id="new-image" class="col-sm-6 col-md-4 col-lg-3 card div-images-size">

						<img src="${add_img_url}">
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--<div id="wrap"></div>
	<div id="window">
		<div class="container">
			<div class="col-8">
				<form method="POST" action="/uploadImage.html" enctype="multipart/form-data">
					<input type="file" name="file"/>
					<input type="submit" value="Upload">
				</form>
			</div>
			<div class="col-4">

			</div>
		</div>
	</div> -->






	<script src="${jquery_url}"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
			integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
			crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
			integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
			crossorigin="anonymous"></script>
	<script type="text/javascript" src="${custom_js_url}"></script>
	</body>
</html>


