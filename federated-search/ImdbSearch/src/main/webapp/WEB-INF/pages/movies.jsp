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
<%@page import="com.endava.imdb.search.domain.jpa.TvSeriesEntity"%>
<html>

<jsp:include page="head.jsp"/>


<body role="document">
<div class="masthead-wrapper">

<jsp:include page="navbar.jsp"/>
    <div class="container-fluid">

        <div class="row" >
            <div class="col-md-10">

                <div class="jumbotron">

                    <div style="margin-left:20%; width:60%;">
                        <form action="movies" method="get"  role="form">
                            <div class="form-group">
                                <label for="query">Search for:</label>
                                <input id = "query" name = "query"  class="form-control" placeholder="search keywords"/>
                            </div>
                            <button type="submit" class="btn btn-pull-right btn-default ">Search</button>
                            <span class="glyphicon glyphicon-search"></span>
                        </form>
                    </div>

                </div>

                <div style="padding-left:40px;">

                   <c:if test="${results != null}">
                       <c:if test="${fn:length(results) > 0}">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th>Search results</th>
                                </tr>
                                </thead>
                                <tbody>

                               <c:forEach var="result" items="${results}">
                                   <tr >
                                       <td><img style="padding-right: 10px; width: 150px; height: 0px" src="${result.poster}" />${result.title}</td>
                                       <td>${result.year}</td>
                                   </tr>

                               </c:forEach>
                                </tbody>
                            </table>
                           </ul>

                           </c:if>
                   </c:if>
                 </div>
            </div>
        </div>
    </div>


</body>
</html>
