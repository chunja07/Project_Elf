<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
<title>연습 하는 부분들</title>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=lz0e8vpjrz5ApswJPUqL&submodules=geocoder"></script>
<script
  src="https://code.jquery.com/jquery-3.3.1.js"
  integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
  crossorigin="anonymous"></script>
</head>
<body>
 	<div id="map" style="width:400px;height:400px;"></div>
	
    <script type="text/javascript">
   
	
    var mapOptions = {
    		 	scaleControl: true,
    	        logoControl: true,
    	        mapDataControl: true,
    	        mapTypeControl: true,
    	        zoomControl: true   
     };
    
    
    var map = new naver.maps.Map(document.getElementById('map'), mapOptions);
    
     var infowindow = new naver.maps.InfoWindow();
    
    function onSuccessGeolocation(position){
    	var location = new naver.maps.LatLng(position.coords.latitude,
    										 position.coords.longitude);
    	map.setCenter(location);
    	map.setZoom(10);
    	
    	infowindow.setContent('<div style = "padding:10px;">' + '현재 위치' + '</div>');
    	
    	infowindow.open(map, location);
    	console.log('Coordinates: ' + location.toString());
    }
    
    function onErrorGeolocation(){
    	var center = map.getCenter();
    	
    	infowindow.setContent('<div style = "padding:10px;">' + 'Failed' + '</div>');
    	
    	infowindow.open(map,center);
    }
    
    $(window).on('load', function(){
    	if (navigator.geolocation){
    		navigator.geolocation.getCurrentPosition(onSuccessGeolocation, onErrorGeolocation);
    	} else {
    		var center = map.getCenter();
    		infowindow.setContent('<div style="padding:20px;"><h5 style="margin-bottom:5px;color:#f00;">Geolocation not supported</h5></div>');
    		 infowindow.open(map, center);
    	}
    });
    
    
    naver.maps.Event.addListener(map, 'click', function(e) {
    	marker.setPosition(e.latlng);
    });
    
    
    </script>	
	
	
	<table>
		<tr>
			<th>시</th>
			<th>군</th>
		</tr>
		<c:forEach items="${lol}" var = "i">
			<tr>
				<th>${i.province}</th>
				<th>${i.district}</th>
			</tr>		
		</c:forEach>
	
	
	</table>




	<form action="${pageContext.request.contextPath}/location" method = "post">
	<input type = "text">
	<input type = "submit" name = "button">
	</form>
</body>
</html>