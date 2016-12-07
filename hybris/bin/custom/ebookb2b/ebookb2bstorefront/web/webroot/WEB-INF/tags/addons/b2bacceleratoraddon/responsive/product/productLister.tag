<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="pageData" required="true"
              type="de.hybris.platform.commerceservices.search.facetdata.ProductSearchPageData" %>
<%@ attribute name="path" required="true" type="java.lang.String" %>
<%@ attribute name="itemType" required="false" type="java.lang.String" %>
<%-- Possible values ORDERFORM, FILTER --%>
<%-- Order form related parameters  --%>
<%@ attribute name="isOnlyProductIds" required="false" type="java.lang.Boolean" %>
<%@ attribute name="filterSkus" required="false" type="java.util.List" %>
<%@ taglib prefix="product" tagdir="/WEB-INF/tags/addons/b2bacceleratoraddon/responsive/product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="theme" tagdir="/WEB-INF/tags/shared/theme" %>

<spring:htmlEscape defaultHtmlEscape="true" />
<c:set value="${not empty isOnlyProductIds && isOnlyProductIds}" var="isOnlyProductIds"/>
<c:if test="${empty itemType}">
    <c:set value="ORDERFORM" var="itemType"/>
</c:if>
<c:set value="${itemType eq 'ORDERFORM'}" var="isOrderForm"/>
<c:url value="${path}" var="currentURL"/>

<%--  the id=resultsList is used in the script to get all the scrolling data  --%>
<ul id="resultsList" class="product-list"
     data-isOrderForm="${isOrderForm}"
     data-current-path="${currentURL}"
     data-current-query="${pageData.currentQuery.query.value}"
     data-isOnlyProductIds="${isOnlyProductIds}">
    <c:forEach items="${pageData.results}" var="product">
        <c:choose>
            <c:when test="${itemType eq 'ORDERFORM' && not empty product.variantMatrix}">
                <product:productListerOrderForm product="${product}" filterSkus="${filterSkus}"/>
            </c:when>
            <c:when test="${itemType eq 'FILTER'}">
                <product:productFilterOrderForm product="${product}"/>
            </c:when>
            <c:otherwise>
                <product:productListerItem product="${product}" isOrderForm="${isOrderForm}"/>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</ul>
