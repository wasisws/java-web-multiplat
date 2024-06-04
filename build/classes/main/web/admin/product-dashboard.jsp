<%-- Created on : Jul 11, 2023, 7:49:30 PM by DuyDuc94 --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import = "java.util.*" %>
<%@page import = "model.*" %>
<%@page import = "dal.*" %>

<!DOCTYPE html>

<html>
    <head>
        <!-- Required meta tags -->
        <title>Category Dashboard</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="admin/assets/vendor/bootstrap/css/bootstrap.min.css">
        <link href="admin/assets/vendor/fonts/circular-std/style.css" rel="stylesheet">
        <link rel="stylesheet" href="admin/assets/libs/css/style.css">
        <link rel="stylesheet" href="admin/assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
        <link rel="stylesheet" type="text/css" href="admin/assets/vendor/datatables/css/dataTables.bootstrap4.css">
        <link rel="stylesheet" type="text/css" href="admin/assets/vendor/datatables/css/buttons.bootstrap4.css">
        <link rel="stylesheet" type="text/css" href="admin/assets/vendor/datatables/css/select.bootstrap4.css">
        <link rel="stylesheet" type="text/css" href="admin/assets/vendor/datatables/css/fixedHeader.bootstrap4.css">
    </head>
    <body>

        <div class="dashboard-main-wrapper">
            <%@include file="templates/header.jsp" %>
            <%@include file="templates/left-sidebar.jsp" %>

            <c:set var="listProducts" value="${requestScope['listProducts']}" />

            <div class="dashboard-wrapper">
                <div class="container-fluid  dashboard-content">

                    <!--Page Header-->
                    <div class="row">
                        <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                            <div class="page-header">
                                <h3 class="mb-2">Product Dashboard</h3>
                                <div class="page-breadcrumb">
                                    <nav aria-label="breadcrumb">
                                        <ol class="breadcrumb">
                                            <li class="breadcrumb-item"><a href="dashboard" class="breadcrumb-link">Dashboard</a></li>
                                            <li class="breadcrumb-item active" aria-current="page">Category Dashboard</li>
                                        </ol>
                                    </nav>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--Page Header-->

                    <!-- content -->
                    <div class="row">
                        <!-- basic table  -->
                        <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                            <div class="card">
                                <h5 class="card-header">Product</h5>
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered first">
                                            <thead>
                                                <tr>
                                                    <th>Image</th>
                                                    <th>ID</th>
                                                    <th>Product Name</th>
                                                    <th>Description</th>
                                                    <th>Price</th>
                                                    <th>Sold</th>
                                                    <th>Edit</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="product" items="${listProducts}">
                                                    <tr>
                                                        <td>
                                                            <div class="m-r-10"><img src="templates/img${product.getImage()}" alt="user" class="rounded" width="45"></div>
                                                        </td>
                                                        <td>${product.getID()}</td>
                                                        <td>${product.getName()}</td>
                                                        <td>${product.getDescription()}</td>
                                                        <td>$${product.getPrice()}</td>
                                                        <td>${product.getSold()}</td>
                                                        <td>
                                                            <a href="#">
                                                                <i class="fas fa-edit fa-lg"></i>
                                                            </a>
                                                            <a href="#">
                                                                <i class="fas fa-window-close fa-lg"></i>
                                                            </a>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- end basic table  -->
                    </div>
                    <!-- end content -->
                </div>
            </div>
        </div>

        <!-- Optional JavaScript -->
        <script src="admin/assets/vendor/jquery/jquery-3.3.1.min.js"></script>
        <script src="admin/assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
        <script src="admin/assets/vendor/slimscroll/jquery.slimscroll.js"></script>
        <script src="admin/assets/vendor/multi-select/js/jquery.multi-select.js"></script>
        <script src="admin/assets/libs/js/main-js.js"></script>
        <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
        <script src="admin/assets/vendor/datatables/js/dataTables.bootstrap4.min.js"></script>
        <script src="https://cdn.datatables.net/buttons/1.5.2/js/dataTables.buttons.min.js"></script>
        <script src="admin/assets/vendor/datatables/js/buttons.bootstrap4.min.js"></script>
        <script src="admin/assets/vendor/datatables/js/data-table.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/pdfmake.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/vfs_fonts.js"></script>
        <script src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.html5.min.js"></script>
        <script src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.print.min.js"></script>
        <script src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.colVis.min.js"></script>
        <script src="https://cdn.datatables.net/rowgroup/1.0.4/js/dataTables.rowGroup.min.js"></script>
        <script src="https://cdn.datatables.net/select/1.2.7/js/dataTables.select.min.js"></script>
        <script src="https://cdn.datatables.net/fixedheader/3.1.5/js/dataTables.fixedHeader.min.js"></script>
    </body>
</html>
