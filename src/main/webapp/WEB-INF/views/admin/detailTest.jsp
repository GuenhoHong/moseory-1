<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<!-- jquery js -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<!-- bootstrap js -->
<script src="/js/bootstrap.js"></script>
</head>
<body>

<script>
	$(document).ready(function(){
		var html = "<div id='detailInfo'><select name = 'product_color'><option value = '화이트'>WHITE</option><option value = '블랙'>BALCK</option><option value = '레드'>RED</option><option value = '그레이'>GRAY</option></select></div>";
		var html2 = "<div class = 'addSize'><input type='checkbox' class ='size' value='xs'>XS<input type = 'text' class= 'product_stock'>개<br><input type='checkbox' class ='size' value='s'>S<input type = 'text' class= 'product_stock'>개<br><input type='checkbox' class ='size' value='m' id = 'sizeArea'>M<input type = 'text' class= 'product_stock'>개<br><input type='checkbox' class ='size' value='l'>L<input type = 'text' class= 'product_stock'>개<br><input type='checkbox' class ='size' value='xl'>XL<input type = 'text' class= 'product_stock'>개<br></div>"
		$('#addAreaBtn').click(function(e){
			$('.newArea').append(html+html2);
		});
		
		var size = $('input[name="product_size"]:checked');
		console.log("size = " + size);
/* 		$('input[name="product_size"]:checked').each(function(i){
			sizeArray.push($(this).val());
			$('input[name="product_stock"]').each(function(i) {
				if($(this).val() != ""){
					stockArray.push($(this).val());
				}
			});
 */			
	/* 	}); */
	})
function regist() {
	
	detailInfo();
	$("#registForm").submit();
	/* fileUpload(); */
}
	function detailInfo() {
		var productDetail = null;
		
		var colorArray = [];
		var sizeArray = [];
		var stockArray = [];
		var numberOfChecked = $('input[name="product_size"]:checked').length;
		
		for(var i = 0; i < numberOfChecked; i++) {
			$('select[name="product_color"]').each(function(i){
				colorArray.push($(this).val());
			});
		}
		
		$('input[name="product_size"]:checked').each(function(i){
			sizeArray.push($(this).val());
			$('input[name="product_stock"]').each(function(i) {
				if($(this).val() != ""){
					stockArray.push($(this).val());
				}
			});
		});
		
		var stockLength = stockArray.length;
		var sizeLength = sizeArray.length;
		
		if(stockLength != sizeLength){
			alert("사이즈와 수량을 확인해주세요");
		}
		console.log(colorArray);
		console.log(sizeArray);
		console.log(stockArray);
		
		for(var i = 0; i < numberOfChecked; i++) {
			productDetail = {
				product_color : colorArray[i],
				product_size : sizeArray[i],
				product_stock : stockArray[i]
			}
			sendDetail.sendPro(productDetail);
		}
	}
	
	var sendDetail = (function() {
		function sendPro(productDetail) {
			$.ajax({
				type : "post",
				url : "/admin/detailTest",
				data : JSON.stringify(productDetail),
				async : false,
				contentType : "application/json; charset=utf-8"
			});
		} // sendPro
		return {sendPro : sendPro};
	})();
</script>
	            <table class="table table-bordered">
	                <tr>
	                	<th>상품정보 <img src="/images/ico_required.gif"></th>
	                	<td>  
	                		<div class = "detailInfo">
		                		<div class = "addColor">
			                		<select name = "product_color">
	                					<option value = "화이트">WHITE</option>
	                					<option value = "블랙">BALCK</option>
	                					<option value = "레드">RED</option>
	                					<option value = "그레이">GRAY</option>
	                				</select>
		                		</div>
								<div class = "addSize">
					                <input type="checkbox" class ="size" value="xs">XS
    					            <input type = "text" class= "product_stock">개<br>
					                <input type="checkbox" class ="size" value="s">S
					                <input type = "text" class= "product_stock">개<br>
					                <input type="checkbox" class ="size" value="m" id = "sizeArea">M
					                <input type = "text" class= "product_stock">개<br>
					                <input type="checkbox" class ="size" value="l">L
					                <input type = "text" class= "product_stock">개<br>
					                <input type="checkbox" class ="size" value="xl">XL
					                <input type = "text" class= "product_stock">개<br>
					            </div>	       
							</div>      		
  	              			<div class = "newArea">
  	              			
  	              			</div>
  	              			<button type = "button" id = "addAreaBtn">추가</button>
	                	</td>
	                </tr>
	            </table>
	            <div class = "regist_btn_area text-center">
					<input type = "button" value = "등록" class = "btn btn-primary btn-md" onclick="regist()">
					<input type = "button"  value = "취소" class ="btn btn-default btn-md">
				</div>
				
</body>
</html>