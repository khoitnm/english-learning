<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Map</title>

    <!-- Bootstrap -->
    <link href="../libs/bootstrap-gentellena/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../libs/bootstrap-gentellena/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../libs/bootstrap-gentellena/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="../libs/bootstrap-gentellena/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- bootstrap-progressbar -->
    <link href="../libs/bootstrap-gentellena/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- JQVMap -->
    <link href="../libs/bootstrap-gentellena/vendors/jqvmap/dist/jqvmap.min.css" rel="stylesheet"/>

    <!-- Custom Theme Style -->
    <link href="../libs/bootstrap-gentellena/build/css/custom.min.css" rel="stylesheet">
</head>

<body class="nav-sm" ng-app="angularApp" onload="appService.pageSetup('${contextPath}');" ng-controller="pageController">

<div class="container body">
    <div class="main_container">
        <div class="col-md-3 left_col" ng-include="'../parts/sidebar.html'"></div>
        <div class="top_nav" ng-include="'../parts/top-nav.html'"></div>

        <!-- page content -->
        <div class="right_col" role="main">
            <!-- top tiles -->
            <div class="row tile_count">
                <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
                    <span class="count_top"><i class="fa fa-user"></i> Total Users</span>

                    <div class="count">2500</div>
                    <span class="count_bottom"><i class="green">4% </i> From last Week</span>
                </div>
                <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
                    <span class="count_top"><i class="fa fa-clock-o"></i> Average Time</span>

                    <div class="count">123.50</div>
                    <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>3% </i> From last Week</span>
                </div>
                <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
                    <span class="count_top"><i class="fa fa-user"></i> Total Males</span>

                    <div class="count green">2,500</div>
                    <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>34% </i> From last Week</span>
                </div>
                <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
                    <span class="count_top"><i class="fa fa-user"></i> Total Females</span>

                    <div class="count">4,567</div>
                    <span class="count_bottom"><i class="red"><i class="fa fa-sort-desc"></i>12% </i> From last Week</span>
                </div>
                <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
                    <span class="count_top"><i class="fa fa-user"></i> Total Collections</span>

                    <div class="count">2,315</div>
                    <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>34% </i> From last Week</span>
                </div>
                <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
                    <span class="count_top"><i class="fa fa-user"></i> Total Connections</span>

                    <div class="count">7,325</div>
                    <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>34% </i> From last Week</span>
                </div>
            </div>
            <!-- /top tiles -->

            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>Map
                                <small>Atlas history</small>
                            </h2>
                            <ul class="nav navbar-right panel_toolbox">
                                <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                </li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="#">Settings 1</a>
                                        </li>
                                        <li><a href="#">Settings 2</a>
                                        </li>
                                    </ul>
                                </li>
                                <li><a class="close-link"><i class="fa fa-close"></i></a>
                                </li>
                            </ul>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">
                            <div class="dashboard-widget-content">
                                <div id="world-map-gdp" class="col-md-12 col-sm-12 col-xs-12" style="height:800px; width: 100%"></div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
            <!--Map in panel row-->

            <div class="row">
                <!--<div id="world-map-gdp" class="col-md-12 col-sm-12 col-xs-12" style="height:600px;"></div>-->
            </div>
        </div>
        <!-- /page content -->

        <footer ng-include="'../parts/footer.html'"></footer>
    </div>
</div>

<!-- jQuery -->
<!--<script src="../libs/jquery-jvectormap/jquery-3.1.0.min.js"></script>-->
<script src="../libs/bootstrap-gentellena/vendors/jquery/dist/jquery.min.js"></script>

<!-- 01.* BOOTSTRAP -->
<!-- Bootstrap -->
<script src="../libs/bootstrap-gentellena/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="../libs/bootstrap-gentellena/vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="../libs/bootstrap-gentellena/vendors/nprogress/nprogress.js"></script>
<!-- bootstrap-progressbar -->
<script src="../libs/bootstrap-gentellena/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
<!-- iCheck -->
<script src="../libs/bootstrap-gentellena/vendors/iCheck/icheck.min.js"></script>

<!-- Flot -->
<script src="../libs/bootstrap-gentellena/vendors/Flot/jquery.flot.js"></script>
<script src="../libs/bootstrap-gentellena/vendors/Flot/jquery.flot.pie.js"></script>
<script src="../libs/bootstrap-gentellena/vendors/Flot/jquery.flot.time.js"></script>
<script src="../libs/bootstrap-gentellena/vendors/Flot/jquery.flot.stack.js"></script>
<script src="../libs/bootstrap-gentellena/vendors/Flot/jquery.flot.resize.js"></script>
<!-- Flot plugins -->
<script src="../libs/bootstrap-gentellena/vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
<script src="../libs/bootstrap-gentellena/vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
<script src="../libs/bootstrap-gentellena/vendors/flot.curvedlines/curvedLines.js"></script>
<!-- DateJS -->
<script src="../libs/bootstrap-gentellena/vendors/DateJS/build/date.js"></script>
<!-- JQVMap --><!-- We can use jVectorMap instead of JQVMap -->
<script src="../libs/bootstrap-gentellena/vendors/jqvmap/dist/jquery.vmap.js"></script>
<script src="../libs/bootstrap-gentellena/vendors/jqvmap/dist/maps/jquery.vmap.world.js"></script>
<script src="../libs/bootstrap-gentellena/vendors/jqvmap/examples/js/jquery.vmap.sampledata.js"></script>
<!-- bootstrap-daterangepicker -->
<script src="../libs/bootstrap-gentellena/production/js/moment/moment.min.js"></script>
<script src="../libs/bootstrap-gentellena/production/js/datepicker/daterangepicker.js"></script>

<!-- Custom Theme Scripts -->
<script src="../libs/bootstrap-gentellena/build/js/custom.angular.js"></script>

<!-- 01.* JVector -->
<!---->
<!--<script src="../libs/jquery-jvectormap/jquery-jvectormap-2.0.3.min.js"></script>-->
<!--<script src="../libs/jquery-jvectormap/jquery-jvectormap-world-mill.js"></script>-->

<!-- 01.* AngularJS -->
<script src="../libs/angular/angular.1.5.x.min.js"></script>
<script src="../libs/angular/angular-resource.min.js"></script>

<!-- 02. APPLICATION -->
<script src="../scripts/common/common.js"></script>
<script src="../scripts/angularjs/app-common-module.js"></script>
<script src="../scripts/angularjs/app.js"></script>
<script src="../scripts/angularjs/app-service.js"></script>
<script src="../scripts/services/map.js"></script>


<!-- JQVMap -->
<!--<script>-->
<!--$(document).ready(function () {-->
<!--$('#world-map-gdp').vectorMap({-->
<!--map: 'world_en',-->
<!--backgroundColor: null,-->
<!--color: '#ffffff',-->
<!--hoverOpacity: 0.7,-->
<!--selectedColor: '#666666',-->
<!--enableZoom: true,-->
<!--showTooltip: true,-->
<!--values: sample_data,-->
<!--scaleColors: ['#E6F2F0', '#149B7E'],-->
<!--normalizeFunction: 'polynomial'-->
<!--});-->
<!--});-->
<!--</script>-->
<!-- /JQVMap -->

</body>
</html>
