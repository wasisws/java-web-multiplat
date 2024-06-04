<%-- Created on : Jul 11, 2023, 7:51:54 PM by DuyDuc94 --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="nav-left-sidebar sidebar-dark">
    <div class="menu-list">
        <nav class="navbar navbar-expand-lg navbar-light">

            <!--Responsive-->
            <a class="d-xl-none d-lg-none" href="#">Dashboard</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <!--Responsive-->

            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav flex-column">

                    <li class="nav-divider">Menu</li>

                    <!--nav item-->
                    <li class="nav-item">
                        <a class="nav-link active" href="#" data-toggle="collapse" aria-expanded="false" data-target="#submenu-1" aria-controls="submenu-1"><i class="fas fa-warehouse"></i>Dashboard<span class="badge badge-success">6</span></a>

                        <!--nav dropdown-->
                        <div id="submenu-1" class="collapse submenu" style="">
                            <ul class="nav flex-column">
                                <li class="nav-item">
                                    <a class="nav-link" href="sale-dashboard" >Sale Dashboard</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="category-dashboard" >Category</a>
                                </li>

                                <li class="nav-item">
                                    <a class="nav-link" href="brand-dashboard">Brand</a>
                                </li>

                                <li class="nav-item">
                                    <a class="nav-link" href="product-dashboard">Product</a>
                                </li>

                                <li class="nav-item">
                                    <a class="nav-link" href="product-detail-dashboard" >Product Detail</a>
                                </li>
                            </ul>
                        </div>
                        <!--nav dropdown-->
                    </li>

                    <!--nav item-->
                    <li class="nav-item">
                        <a class="nav-link" href="#" data-toggle="collapse" aria-expanded="false" data-target="#submenu-3" aria-controls="submenu-3"><i class="fas fa-shopping-cart"></i>Order</a>
                        <div id="submenu-3" class="collapse submenu" style="">
                            <ul class="nav flex-column">
                                <li class="nav-item">
                                    <a class="nav-link" href="order-dashboard">All Order</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="admin/pages/chart-c3.html">Recent Order</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="admin/pages/chart-chartist.html">Preparing Order</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="admin/pages/chart-charts.html">Delivering Order</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="admin/pages/chart-morris.html">Delivered Order</a>
                                </li>
                            </ul>
                        </div>
                    </li>

                    <!--nav item-->
                    <li class="nav-item">
                        <a class="nav-link" href="#" data-toggle="collapse" aria-expanded="false" data-target="#submenu-2" aria-controls="submenu-2"><i class="fas fa-user"></i>User Management</a>
                        <div id="submenu-2" class="collapse submenu" style="">
                            <ul class="nav flex-column">
                                <li class="nav-item">
                                    <a class="nav-link" href="#">General</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">List Admin Account</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">Actived User</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">Disabled User</a>
                                </li>
                            </ul>
                        </div>
                    </li>

                    <li class="nav-divider">
                        Settings
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="#" data-toggle="collapse" aria-expanded="false" data-target="#submenu-6" aria-controls="submenu-6"><i class="fas fa-fw fa-file"></i> Website Pages</a>
                        <div id="submenu-6" class="collapse submenu" style="">
                            <ul class="nav flex-column">
                                <li class="nav-item">
                                    <a class="nav-link" href="admin/pages/blank-page.html">Blank Page</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="admin/pages/blank-page-header.html">Blank Page Header</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="admin/pages/login.html">Login</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="admin/pages/404-page.html">404 page</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="admin/pages/sign-up.html">Sign up Page</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="admin/pages/forgot-password.html">Forgot Password</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="admin/pages/pricing.html">Pricing Tables</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="admin/pages/timeline.html">Timeline</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="admin/pages/calendar.html">Calendar</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="admin/pages/sortable-nestable-lists.html">Sortable/Nestable List</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="admin/pages/widgets.html">Widgets</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="admin/pages/media-object.html">Media Objects</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="admin/pages/cropper-image.html">Cropper</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="admin/pages/color-picker.html">Color Picker</a>
                                </li>
                            </ul>
                        </div>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="#" data-toggle="collapse" aria-expanded="false" data-target="#submenu-7" aria-controls="submenu-7"><i class="fas fa-fw fa-inbox"></i>Apps <span class="badge badge-secondary">New</span></a>
                        <div id="submenu-7" class="collapse submenu" style="">
                            <ul class="nav flex-column">
                                <li class="nav-item">
                                    <a class="nav-link" href="admin/pages/inbox.html">Inbox</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="admin/pages/email-details.html">Email Detail</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="admin/pages/email-compose.html">Email Compose</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="admin/pages/message-chat.html">Message Chat</a>
                                </li>
                            </ul>
                        </div>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="#" data-toggle="collapse" aria-expanded="false" data-target="#submenu-8" aria-controls="submenu-8"><i class="fas fa-fw fa-columns"></i>Store</a>
                        <div id="submenu-8" class="collapse submenu" style="">
                            <ul class="nav flex-column">
                                <li class="nav-item">
                                    <a class="nav-link" href="admin/pages/icon-fontawesome.html">FontAwesome Icons</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="admin/pages/icon-material.html">Material Icons</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="admin/pages/icon-simple-lineicon.html">Simpleline Icon</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="admin/pages/icon-themify.html">Themify Icon</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="admin/pages/icon-flag.html">Flag Icons</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="admin/pages/icon-weather.html">Weather Icon</a>
                                </li>
                            </ul>
                        </div>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="#" data-toggle="collapse" aria-expanded="false" data-target="#submenu-9" aria-controls="submenu-9"><i class="fas fa-fw fa-map-marker-alt"></i>Maps</a>
                        <div id="submenu-9" class="collapse submenu" style="">
                            <ul class="nav flex-column">
                                <li class="nav-item">
                                    <a class="nav-link" href="admin/pages/map-google.html">Google Maps</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="admin/pages/map-vector.html">Vector Maps</a>
                                </li>
                            </ul>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
</div>
