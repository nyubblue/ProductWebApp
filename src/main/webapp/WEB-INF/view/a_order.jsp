<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="webjars/bootstrap/3.4.1/css/bootstrap.min.css"/>" type="text/css" rel="stylesheet"/>
        <s:url var="url_css" value="/static/css/style.css"/>
        <link href="${url_css}" rel="stylesheet" type="text/css"/>
        <title>Homepage</title>
        <style>
            #header1{
                font-family: "Helvetica Neue",Helvetica,Arial,sans-serif;
                color: #2113aa;
            }
            #header2{
                font-family: "Helvetica Neue",Helvetica,Arial,sans-serif;
                font-size: 2.5rem;
            }
        </style>
        <s:url var="url_jqlib" value="/static/js/jquery-3.2.1.min.js" />
        <script src="${url_jqlib}"></script>
        <script>
//           function selectedDelete(id){
//               $.ajax({
//                   url: 'delete_dt';
//                   data: {pid: id},
//                   success: function (data){
//                       alert(data);
//                   }
//               });
//           }
        </script>
    </head>
    <s:url var="url_bg" value="/static/images/bg.jpg"/>
    <body >
        <div class="container">
            <div class="row">
                <div class="col-sm-12" style="text-align: center;">
                    <h1 id="header1">Orderdate <fmt:formatDate type="date" value="${order.orderDate}" pattern="dd/MM/yyyy" /></h1>
                </div>   
            </div>
            <div class="row">
                <form action="<s:url value="/update_order"/>">
                    <div class="col-sm-12">
                        <table width="100%" cellpadding="3"  class="table table-bordered" >
                            <thead>
                                <tr class="bg-info">
                                    <th >Index</th>
                                    <th>Name</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Status</th>
                                    <th>Select</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody id="header2">
                                <c:forEach var="o" items="${order.orderDetails}" varStatus ="st" >
                                    <tr>
                                        <td>${st.count}</td>
                                        <td>${o.name}</td>
                                        <td>${o.price}</td>
                                        <td>
                                            <input class="form-control mb-2" type="number" name="quantity" value="${o.quantity}" />
                                        </td>
                                        <td>${order.status}</td>
                                        <td align="center">${o.id}
                                            <!--<input type="checkbox" name ="oid" value="" />-->
                                        </td>
                                        <td>
                                            <button type="button" onclick='location.href="<c:url value="/delete_dt/${o.id}"/> "' >
                                                Delete
                                            </button>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                            <tfoot class="bg-primary">
                                <tr>
                                    <td colspan="1">Total Price </td>
                                    <td colspan="6" style="text-align: center;"><span style="font-size: 1.5em;">${order.totalPrice}<span></td>
                                                </tr>
                                                </tfoot>
                                                </table>
                                                </div>
                                                <div class="row">
                                                    <div class="col-sm-12">
                                                        <div class="col-sm-3">
                                                            <button class="btn btn-info btn-lg"  type="button" onclick='location.href = "<c:url value="/continue" />"'>Continue</button>
                                                        </div>
                                                        <div class="col-sm-6" align="center">
                                                            <div class="btn-group" role="group" aria-label="nhom_thao_tac" >
                                                                <button  class="btn btn-warning btn-lg">Delete Selected Product</button>
                                                                <button   class="btn btn-success btn-lg" >Update</button>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-3" align="right">
                                                            <button class="btn btn-info btn-lg"  type="button" onclick='location.href = "<c:url value="/submit_order" />"'>Order</button>
                                                        </div>
                                                    </div>   
                                                </div>
                                                </form>
                                                </div>

                                                <!--**-->
                                                </div>
                                                </body>
                                                </html>