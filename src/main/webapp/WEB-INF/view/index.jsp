<%-- 
    Document   : index
    Created on : Jun 24, 2019, 2:53:57 PM
    Author     : buynl
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="webjars/bootstrap/3.4.1/css/bootstrap.min.css"/>" type="text/css" rel="stylesheet"/>
        <title>Homepage</title>
    </head>
    <s:url var="url_bg" value="/static/images/bg.jpg"/>
    <body background="${url_bg}">
        <div class="container">
            <div class="row">
                <div class="col-sm-12" style="text-align: center;">
                    <h1>Products List</h1>
                </div>   
            </div>

            <div class="row">
                <div class="col-sm-12">
                    <table width="100%"  class="table table-bordered" >
                        <tr>
                            <th>Name</th>
                            <th>Category</th>
                            <th>Price</th>
                            <th>Description</th>
                            <th>Action</th>
                        </tr>
                        <c:forEach var="p" items="${products}">
                            <tr>
                                <td>${p.name}</td>
                                <td>${p.category_entity.name}</td>
                                <td>${p.price}</td>
                                <td>${p.description}</td>
                                <s:url var="url_order" value="/order_product" >
                                    <s:param name="productId" value="${p.id}" />
                                </s:url>
                                <td>
                                    <button class="btn btn-info" type="button" onclick='location.href="${url_order}"' >order Product</button>
                                </td>
                            </tr>
                        </c:forEach>
                            </table>
                </div>   
            </div>

        </div>
    </body>
</html>
