<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- 品牌 Logo -->
    <a  class="brand-link">
    <img src="static/img/logo1.png"
         alt="AdminLTE Logo"
         class="brand-image img-circle elevation-3"
         style="opacity: .8"><br/>
    <span class="brand-text font-weight-light" style="color: white"><h6>Ape-Speed 管理系统</h6></span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
        <!-- Sidebar user (optional) -->
        <div class="user-panel mt-3 pb-3 mb-3 d-flex">
            <div class="image">
                <img src="static/img/avatar04.png" class="img-circle elevation-2" alt="用户头像">
            </div>
            <div class="info">
                <a  class="d-block"><h3>admin</h3></a>
                <div class="navbar_right fa fa-power-off"> <a href="${pageContext.request.contextPath }/admin_out.jsp">退出系统</a>
            </div>
            </div>
        </div>

        <!-- 侧边栏菜单 -->
        <nav class="mt-2">
            <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu"
                data-accordion="false">
                <!-- 使用 .nav-icon 类添加图标，
                     或使用 font-awesome 或其他任何图标字体库 -->
                <li class="nav-item has-treeview menu-open">
                    <a href="./admin/light1.jsp" class="nav-link">
                        <i class="nav-icon fas fa-book"></i>
                        <p>
                            订单管理
                            <i class="fas fa-angle-left right"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                        <li class="nav-item">
                            <a href="./admin/pending_order.jsp" class="nav-link active">
                                <i class="far fa-circle nav-icon"></i>
                                <p>待发货订单</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="./admin/wait_paid_order.jsp" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>待付款订单</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="./admin/shipped_order.jsp" class="nav-link active">
                                <i class="far fa-circle nav-icon"></i>
                                <p>已发货订单</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="./admin/reject_order.jsp" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>取消/拒收订单</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="./admin/refund_order.jsp" class="nav-link active">
                                <i class="far fa-circle nav-icon"></i>
                                <p>退款订单</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="./admin/received_order.jsp" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>已收货订单</p>
                            </a>
                        </li>
                    </ul>
                </li>

                <li class="nav-item has-treeview menu-open">
                    <a href="./admin/light2.jsp" class="nav-link">
                        <i class="nav-icon fas fa-book"></i>
                        <p>
                            商品管理
                            <i class="fas fa-angle-left right"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                        <li class="nav-item">
                            <a href="./admin/listing.jsp" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>在售商品</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="./admin/listAll.jsp" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>商品仓库</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="./admin/listCategory.jsp" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>商品分类</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="./admin/addProduct.jsp" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>添加商品</p>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item has-treeview menu-open">
                    <a href="./admin/light3.jsp" class="nav-link">
                        <i class="nav-icon fas fa-book"></i>
                        <p>
                            会员管理
                            <i class="fas fa-angle-left right"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                        <li class="nav-item">
                            <a href="./admin/vip_list.jsp" class="nav-link">
                                <i class="far fa-circle nav-icon"></i>
                                <p>会员列表</p>
                            </a>
                        </li>
                    </ul>
                </li>


            </ul>
        </nav>
        <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
</aside>
