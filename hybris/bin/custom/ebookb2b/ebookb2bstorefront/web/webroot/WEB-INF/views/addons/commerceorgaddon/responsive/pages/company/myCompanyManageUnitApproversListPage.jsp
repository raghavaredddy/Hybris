<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="nav" tagdir="/WEB-INF/tags/responsive/nav" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="org-common" tagdir="/WEB-INF/tags/addons/commerceorgaddon/responsive/common" %>

<spring:htmlEscape defaultHtmlEscape="true" />

<spring:theme code="text.company.select.action.label" var="selectAction"/>
<spring:theme code="text.company.deselect.action.label" var="deselectAction"/>

<c:if test="${empty cancelUrl}">
	<spring:url value="/my-company/organization-management/manage-units/" var="cancelUrl" htmlEscape="false"/>
</c:if>

<c:set var="searchUrl" value="${baseUrl}/${action}?unit=${ycommerce:encodeUrl(param.unit)}&sort=${ycommerce:encodeUrl(searchPageData.pagination.sort)}"/>

<jsp:useBean id="additionalParams" class="java.util.HashMap"/>
<c:set target="${additionalParams}" property="unit" value="${param.unit}" />

<template:page pageTitle="${pageTitle}">
    <div class="account-section">
        <div class="row">
            <div class="col-xs-12 col-sm-6">
                <org-common:headline url="${cancelUrl}" labelKey="text.company.manage.units.${action}.mainTitle"/>
            </div>
            <div class="account-header-done-btn col-xs-12 col-sm-3 pull-right">
                <org-common:done url="${cancelUrl}" labelKey="text.company.done.button"/>
            </div>
        </div>

        <div class="account-section-content ${empty searchPageData.results ? 'content-empty' : ''}">
            <nav:pagination top="true" showTopTotals="false" supportShowPaged="${isShowPageAllowed}"
                            supportShowAll="${isShowAllAllowed}" searchPageData="${searchPageData}"
                            hideRefineButton="true" searchUrl="${searchUrl}" msgKey="text.company.${action}.page"
                            additionalParams="${additionalParams}" numberPagesShown="${numberPagesShown}"/>

            <div class="account-list">
                <c:choose>
                    <c:when test="${not empty searchPageData.results}">
                        <div class="account-cards card-select">
                            <c:forEach items="${searchPageData.results}" var="user">
                                <spring:url value="/my-company/organization-management/manage-users/details" var="viewUrl" htmlEscape="false">
                                    <spring:param name="user" value="${user.uid}"/>
                                </spring:url>
                                <spring:url value="${baseUrl}/approvers/select/" var="selectUrl" htmlEscape="false">
                                    <spring:param name="user" value="${user.uid}"/>
                                    <spring:param name="unit" value="${param.unit}"/>
                                </spring:url>
                                <spring:url value="${baseUrl}/approvers/deselect/" var="deselectUrl" htmlEscape="false">
                                    <spring:param name="user" value="${user.uid}"/>
                                    <spring:param name="unit" value="${param.unit}"/>
                                </spring:url>

                                <div class="card col-xs-12 col-sm-6 col-md-4 ${user.selected ? 'selected' : ''}" id="row-${user.normalizedUid}">
                                    <ul class="pull-left col-xs-10">
                                        <li>
                                            <ycommerce:testId code="name_${action}_link">
                                                <a href="${viewUrl}">${fn:escapeXml(user.name)}</a>
                                            </ycommerce:testId>
                                        </li>
                                        <li>
                                            <ycommerce:testId code="email_${action}_label">
                                                ${fn:escapeXml(user.uid)}
                                            </ycommerce:testId>
                                        </li>
                                        <li>
                                            <ycommerce:testId code="b2bunit_${action}_label">
                                                ${fn:escapeXml(user.unit.name)}
                                            </ycommerce:testId>
                                        </li>
                                        <li class="roles-wrapper clearfix">
                                            <b><spring:theme code="text.company.roles.all.label"/></b>
                                            <ycommerce:testId code="roles_${action}_label">
                                                <ul id="roles-${user.normalizedUid}">
                                                    <c:forEach items="${user.roles}" var="role">
                                                        <li>
                                                            <spring:theme code="b2busergroup.${role}.name"/>
                                                        </li>
                                                    </c:forEach>
                                                </ul>
                                            </ycommerce:testId>
                                        </li>
                                        <li>
                                            <ycommerce:testId code="status_${action}_label">
                                                <spring:theme code="text.company.status.active.${user.active}" />
                                            </ycommerce:testId>
                                        </li>
                                    </ul>
                                    <ycommerce:testId code="actions_${action}_label">
                                        <c:if test="${user.active}">
                                            <span id="selection-${user.normalizedUid}" class="account-cards-actions">
                                                <c:choose>
                                                    <c:when test="${user.selected}">
                                                        <a href="#" url="${deselectUrl}" class="action-links js-deselectUser">
                                                            <span class="glyphicon glyphicon-ok"></span>
                                                        </a>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <a href="#" url="${selectUrl}" class="action-links js-selectUser">
                                                            <span class="glyphicon glyphicon-ok"></span>
                                                        </a>
                                                    </c:otherwise>
                                                </c:choose>
                                            </span>
                                        </c:if>
                                    </ycommerce:testId>
                                </div>
                            </c:forEach>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <spring:theme code="text.company.noentries"/>
                    </c:otherwise>
                </c:choose>
            </div>

            <div class="clearfix">
                <div class="accountActions-bottom pull-right col-xs-12 hidden-sm hidden-md hidden-lg">
                    <org-common:done url="${cancelUrl}" labelKey="text.company.done.button"/>
                </div>
            </div>

		    <nav:pagination top="false" supportShowPaged="${isShowPageAllowed}" supportShowAll="${isShowAllAllowed}" searchPageData="${searchPageData}"
						hideRefineButton="true" searchUrl="${searchUrl}" msgKey="text.company.${action}.page"
						additionalParams="${additionalParams}" numberPagesShown="${numberPagesShown}"/>
        </div>

	</div>

	<c:url value="${baseUrl}/approvers" var="approversActionLink" />
    <script id="enableDisableLinksTemplate" type="text/x-jquery-tmpl">
        {{if selected}}
            <a href="#" url="${approversActionLink}/deselect/?user={{= id}}&unit=${ycommerce:encodeUrl(param.unit)}" class="action-links js-deselectUser"><span class="glyphicon glyphicon-ok"></span></a>
        {{else}}
            <a href="#" url="${approversActionLink}/select/?user={{= id}}&unit=${ycommerce:encodeUrl(param.unit)}" class="action-links js-selectUser"><span class="glyphicon glyphicon-ok"></span></a>
        {{/if}}
    </script>

    <script id="userRolesTemplate" type="text/x-jquery-tmpl">
        {{each displayRoles}}
            <li>{{= $value}}</li>
        {{/each}}
    </script>

</template:page>
