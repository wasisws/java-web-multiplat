<%-- Created on : Jul 11, 2023, 7:49:30 PM by DuyDuc94 --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import = "java.util.*" %>
<%@page import = "model.*" %>
<%@page import = "dal.*" %>

<!DOCTYPE html>

<html>
    <head>
        <title>Sale Dashboard</title>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="admin/assets/vendor/bootstrap/css/bootstrap.min.css">
        <link href="admin/assets/vendor/fonts/circular-std/style.css" rel="stylesheet">
        <link rel="stylesheet" href="admin/assets/libs/css/style.css">
        <link rel="stylesheet" href="admin/assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
        <link rel="stylesheet" href="admin/assets/vendor/charts/chartist-bundle/chartist.css">
        <link rel="stylesheet" href="admin/assets/vendor/charts/morris-bundle/morris.css">
        <link rel="stylesheet" href="admin/assets/vendor/fonts/material-design-iconic-font/css/materialdesignicons.min.css">
        <link rel="stylesheet" href="admin/assets/vendor/charts/c3charts/c3.css">
        <link rel="stylesheet" href="admin/assets/vendor/fonts/flag-icon-css/flag-icon.min.css">
    </head>
    <body>

        <div class="dashboard-main-wrapper">
            <%@include file="templates/header.jsp" %>
            <%@include file="templates/left-sidebar.jsp" %>
            <div class="dashboard-wrapper">
                <div class="container-fluid  dashboard-content">

                    <!--Page Header-->
                    <div class="row">
                        <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                            <div class="page-header">
                                <h3 class="mb-2">Sale Dashboard</h3>
                                <div class="page-breadcrumb">
                                    <nav aria-label="breadcrumb">
                                        <ol class="breadcrumb">
                                            <li class="breadcrumb-item"><a href="dashboard" class="breadcrumb-link">Dashboard</a></li>
                                            <li class="breadcrumb-item active" aria-current="page">Sale Dashboard</li>
                                        </ol>
                                    </nav>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--Page Header-->

                    <!-- content -->
                    <div class="ecommerce-widget">
                        <div class="row">
                            <div class="col-xl-4 col-lg-6 col-md-6 col-sm-12 col-12">
                                <div class="card">
                                    <div class="card-body">
                                        <h5 class="text-muted">Total Earning</h5>
                                        <div class="metric-value d-inline-block">
                                            <h1 class="mb-1">$3400.43</h1>
                                        </div>
                                        <div class="metric-label d-inline-block float-right text-success font-weight-bold">
                                            <span><i class="fa fa-fw fa-arrow-up"></i></span><span>5.86%</span>
                                        </div>
                                    </div>
                                    <div id="sparkline-revenue"></div>
                                </div>
                            </div>

                            <div class="col-xl-4 col-lg-6 col-md-6 col-sm-12 col-12">
                                <div class="card">
                                    <div class="card-body">
                                        <h5 class="text-muted">Cancel Order</h5>
                                        <div class="metric-value d-inline-block">
                                            <h1 class="mb-1">3</h1>
                                        </div>
                                        <div class="metric-label d-inline-block float-right text-success font-weight-bold">
                                            <span><i class="fa fa-fw fa-arrow-up"></i></span><span>5.86%</span>
                                        </div>
                                    </div>
                                    <div id="sparkline-revenue2"></div>
                                </div>
                            </div>

                            <div class="col-xl-4 col-lg-6 col-md-6 col-sm-12 col-12">
                                <div class="card">
                                    <div class="card-body">
                                        <h5 class="text-muted">Visitors</h5>
                                        <div class="metric-value d-inline-block">
                                            <h1 class="mb-1">6</h1>
                                        </div>
                                        <div class="metric-label d-inline-block float-right text-success font-weight-bold">
                                            <span><i class="fa fa-fw fa-arrow-up"></i></span><span>8.00%</span>
                                        </div>
                                    </div>
                                    <div id="sparkline-revenue4"></div>
                                </div>
                            </div>
                        </div>

                        <div class="row">

                            <!-- recent orders  -->
                            <div class="col-xl-9 col-lg-12 col-md-6 col-sm-12 col-12">
                                <div class="card">
                                    <h5 class="card-header">Top Selling</h5>
                                    <div class="card-body p-0">
                                        <div class="table-responsive">
                                            <table class="table">
                                                <thead class="bg-light">
                                                    <tr class="border-0">
                                                        <th class="border-0">#</th>
                                                        <th class="border-0">Image</th>
                                                        <th class="border-0">Product Name</th>
                                                        <th class="border-0">Id</th>
                                                        <th class="border-0">Sold</th>
                                                        <th class="border-0">Price</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td>1</td>
                                                        <td>
                                                            <div class="m-r-10"><img src="templates/img/laptops/Acer-Aspire-7.png" alt="user" class="rounded" width="45"></div>
                                                        </td>
                                                        <td>Acer Aspire 7 </td>
                                                        <td>5 </td>
                                                        <td>16</td>
                                                        <td>$1380.00</td>
                                                    </tr>
                                                    <tr>
                                                        <td>2</td>
                                                        <td>
                                                            <div class="m-r-10"><img src="templates/img/laptops/Asus-TUF-Gaming-A15.png" alt="user" class="rounded" width="45"></div>
                                                        </td>
                                                        <td>Asus TUF Gaming A15 </td>
                                                        <td>13</td>
                                                        <td>15 </td>
                                                        <td>$1180.00</td>
                                                    </tr>
                                                    <tr>
                                                        <td>3</td>
                                                        <td>
                                                            <div class="m-r-10"><img src="templates/img/smartphones/Iphone-13-Pro.png" alt="user" class="rounded" width="45"></div>
                                                        </td>
                                                        <td>Iphone 13 Pro </td>
                                                        <td>21 </td>
                                                        <td>15</td>
                                                        <td>$820.00</td>
                                                    </tr>
                                                    <tr>
                                                        <td>4</td>
                                                        <td>
                                                            <div class="m-r-10"><img src="templates/img/laptops/Dell-Gaming-G15.png" alt="user" class="rounded" width="45"></div>
                                                        </td>
                                                        <td>Dell Gaming G15 </td>
                                                        <td>3 </td>
                                                        <td>14</td>
                                                        <td>$1340.00</td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="9"><a href="#" class="btn btn-outline-light float-right">View Details</a></td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- end recent orders  -->

                            <!-- customer acquistion  -->
                            <div class="col-xl-3 col-lg-6 col-md-6 col-sm-12 col-12">
                                <div class="card">
                                    <h5 class="card-header">Customer Acquisition</h5>
                                    <div class="card-body">
                                        <div class="ct-chart ct-golden-section" style="height: 354px;"></div>
                                        <div class="text-center">
                                            <span class="legend-item mr-2">
                                                <span class="fa-xs text-primary mr-1 legend-tile"><i class="fa fa-fw fa-square-full"></i></span>
                                                <span class="legend-text">Returning</span>
                                            </span>
                                            <span class="legend-item mr-2">

                                                <span class="fa-xs text-secondary mr-1 legend-tile"><i class="fa fa-fw fa-square-full"></i></span>
                                                <span class="legend-text">First Time</span>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- end customer acquistion  -->
                        </div>
                        
                    </div>
                    <!-- end content -->
                </div>
            </div>
        </div>

        <!-- Optional JavaScript -->
        <!-- jquery 3.3.1 -->
        <script src="admin/assets/vendor/jquery/jquery-3.3.1.min.js"></script>
        <!-- bootstap bundle js -->
        <script src="admin/assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
        <!-- slimscroll js -->
        <script src="admin/assets/vendor/slimscroll/jquery.slimscroll.js"></script>
        <!-- main js -->
        <script src="admin/assets/libs/js/main-js.js"></script>
        <!-- chart chartist js -->
        <script src="admin/assets/vendor/charts/chartist-bundle/chartist.min.js"></script>
        <!-- sparkline js -->
        <script src="admin/assets/vendor/charts/sparkline/jquery.sparkline.js"></script>
        <!-- morris js -->
        <script src="admin/assets/vendor/charts/morris-bundle/raphael.min.js"></script>
        <script src="admin/assets/vendor/charts/morris-bundle/morris.js"></script>
        <!-- chart c3 js -->
        <script src="admin/assets/vendor/charts/c3charts/c3.min.js"></script>
        <script src="admin/assets/vendor/charts/c3charts/d3-5.4.0.min.js"></script>
        <script src="admin/assets/vendor/charts/c3charts/C3chartjs.js"></script>
        <script src="admin/assets/libs/js/dashboard-ecommerce.js"></script>
    </body>
</html>
