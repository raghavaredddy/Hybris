<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/responsive/product" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/responsive/common" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/responsive/formElement" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

  <%-- <c:url value="/coming-soon/products" var ="productpage"/>
<c:url value="/coming-soon/products/Save" var="saveCustomerData"/> 
 --%> 
<template:page pageTitle="${pageTitle}">
	<div id="globalMessages">
		<common:globalMessages/>
	</div>

	<div id="productNotifyDiv">
		<ol class="products-list" data-isOrderForm="false">
		
			<c:forEach items="${produtList}" var="product">
				
				<div class="head">${product.name}
				<img src="${product.thumbnail.url}">
				</div>
			<%--	<input type="submit" id="notifyMe_${product.code}" value="NotifyMe" onclick="openForm('${product.code}')" /> --%>
				
				<%-- <div id="messageId" style="display: none">
				
				Data saved successfully
				
				</div> 	 --%>			
				<div id="notifyId_${product.code}" style="display: none">
				
					<form id="NotifyRegisterForm_${product.code}">
						<p>Please provide the details...</p>
						<table>
							<tr>
								<td>First Name</td>
								<td><input type="text" class="text" name="firstName" /></td>
							</tr>
							<tr>
								<td>Last Name</td>
								<td><input type="text" class="text" name="lastName" /></td>
							</tr>
							<tr>
								<td>Email Id</td>
								<td><input type="text" class="text" name="emailId" /></td>
							</tr>
							
							<%-- <c:forEach items="${productList}" var="product"> --%>

							<tr>
								<td>Product Code</td>
								<td><input type="text" class="text" name="productCode"
									value="${product.code}" /></td>
							</tr>

							<tr>
								<td>Product Name</td>
								<td><input type="text" class="text" name="productName"
									value="${product.name}" /></td>
							</tr>
							
							<tr>
								<td><input type="button" value="Save"
									onclick="formsubmit('${product.code}')" /></td>
								<td><input type="reset" value="Cancel"
									onclick="cancelform('${product.code}')" /></td>
							</tr>
						</table>
					</form>
				</div>
			</c:forEach>
		</ol>
		<div>
		<input type="text" id="resultTextID" style="display: none; border: none ; color: red;font-size: 20px;" readonly="readonly"/>
		</div>
	</div>
	
	<script type="text/javascript" src="${commonResourcePath}/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript">
			function formsubmit(code) 
				{  

					 try{
						 alert(code);
						 	var str = $("#NotifyRegisterForm_"+code).serialize();
						 	$.ajax({  
							     type 	 : "POST",  
							     data	 : str,
							     url 	 : "<c:url value='/coming-soon/products/Save'/>", 
							     success : function(result) 
							     { 
							    	 alert(code);
							    	 $("#resultTextID").val(result);
										$("#resultTextID").css({
										'display' : "block" 
										});
										
							     },
							    error : function()
							    {
							     	alert("Error");
							    }
						   });  
					 }
					 catch(e)
					 {
						 alert("Error>>"+e);
					 }
					 
			}
	</script>
		
		<script type="text/javascript">
		function openForm(code) {
			$("#notifyId_"+code).css({
				'display' : "block"
			});
			$("#notifyMe_"+code).css({
				'display' : "none"
			});
		}
		
		function cancelform(code) {
			$("#notifyId_"+code).css({
				'display' : "none"
			});
			$("#notifyMe_"+code).css({
				'display' : "block"
			});
			document.getElementById("resultTextID").value = "";
			$("#resultTextID").css({
				'display' : "none"
			}); 
			
		}
	</script> 
	
</template:page>