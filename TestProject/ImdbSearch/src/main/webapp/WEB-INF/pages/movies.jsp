<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: btesila
  Date: 5/22/2014
  Time: 5:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"
           prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.endava.imdb.search.domain.jpa.TvSeriesEntity" %>

<jsp:include page="header.jsp"/>
<jsp:include page="searchForm.jsp"/>

<div style="padding-left:40px;">

    <div class="page-header">
        <h1>Search Results</h1>
    </div>

    <c:if test="${results != null}">
        <c:choose>
            <c:when test="${fn:length(results) > 0}">

                    <c:forEach var="result" items="${results}" varStatus="theCount">

                        <div class="panel-group" id="accordion">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a data-toggle="collapse" data-parent="#accordion" href="#collapse${theCount.index}">
                                            ${result.title}
                                        </a>
                                    </h4>
                                </div>
                                <div id="collapse${theCount.index}" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <div class="media">
                                            <a class="pull-left" href="${result.url}">
                                                <img class="media-object" src="${result.poster}" alt="No image available">
                                            </a>
                                            <div class="media-body">

                                                <c:if test="${result.year > 0}">
                                                    <h4 class="media-heading">Release year: ${result.year}</h4>
                                                </c:if>

                                                <c:if test="${result.country != null}">
                                                    <h5 class="media-heading">Country: ${result.country}</h5>
                                                </c:if>

                                                <c:if test="${result.status != null}">
                                                    <h5 class="media-heading">Status: ${result.status}</h5>
                                                </c:if>

                                                <h5 class="media-heading">
                                                    <c:forEach var="genre" items="${result.genres}">
                                                        ${genre.name}
                                                    </c:forEach>
                                                </h5>
                                                <p>
                                                    ${result.overview}
                                                </p>
                                                <c:if test="${fn:length(result.actors) > 0}">
                                                    <h5 class="media-heading">Cast</h5>
                                                    <ul>
                                                        <c:forEach var="actor" items="${result.actors}">
                                                           <li> ${actor.name} </li>
                                                        </c:forEach>
                                                    </ul>
                                                </c:if>
                                                <c:if test="${fn:length(result.episodes) > 0}">
                                                    <h5 class="media-heading">Episodes</h5>
                                                    <ul>
                                                        <c:forEach var="episode" items="${result.episodes}">
                                                            <li>${episode.title}</li>
                                                        </c:forEach>
                                                    </ul>
                                                </c:if>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>

                    </c:forEach>

            </c:when>
            <c:otherwise>
                <div class="alert alert-danger">
                    <strong>We didn't find any results for "${param.query}".</strong> Check the spelling, or try a different search.
                </div>
            </c:otherwise>
        </c:choose>
    </c:if>
</div>



<jsp:include page="footer.jsp"/>

