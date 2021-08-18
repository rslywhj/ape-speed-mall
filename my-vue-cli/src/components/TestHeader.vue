<template>

  <div class="site-topbar">
    <el-header>
      <div class="container">
        <div class="topbar-nav"><a rel="nofollow" href="/#/home">Ape-Speed商城</a> <span class="sep">|</span>
        </div>
        <div id="J_miniCartTrigger" class="topbar-cart"><a data-spm="navigation.to_cart_navigation_bar.1" rel="nofollow"
            id="J_miniCartBtn" href="#/cart" class="cart-mini" data-params="&quot;&quot;"><em
              class="iconfont-cart"></em><em class="iconfont-cart-full hide"></em>购物车<span
              class="cart-mini-num J_cartNum">  <!-- （0） --></span></a>
         <!-- <div id="J_miniCartMenu" class="cart-menu " style="height: 0px;">
            <div class="menu-content">
              <div class="loading">
                <div class="loader"></div>
              </div>
              <ul id="J_miniCartList" class="cart-list hide"></ul>
              <div id="J_miniCartListTotal" class="cart-total clearfix hide"></div>
              <div class="msg msg-error hide"></div>
              <div class="msg msg-empty hide">购物车中还没有商品，赶紧选购吧！</div>
            </div>
          </div> -->
        </div>

        <div id="J_siteUserInfo" class="topbar-info" v-if="username !== 'undefined'">
          <a data-spm="navigation.logon_navigation_bar.1" rel="nofollow" href="#/list" data-agreement="true"
            data-login="true" class="link" data-href="#/list" data-params="&quot;&quot;">{{username}}</a>
          <span class="sep">|</span>
          <span class="message">
            <a data-spm="navigation.message_navigation_bar.1" rel="nofollow" href="#/login_out"
              data-href="//www.mi.com/user/message" class="J_needAgreement" data-login="true"
              data-agreement="true">退出登录<i class="J_miMessageTotal"></i></a></span>
        </div>
        <div id="J_siteUserInfo" class="topbar-info" v-else>
          <a data-spm="navigation.logon_navigation_bar.1" rel="nofollow" href="#/login" data-agreement="true"
            data-login="true" class="link" data-href="#/login" data-params="&quot;&quot;">登录</a>
          <span class="sep">|</span>
          <a data-spm="navigation.register_navigation_bar.1" rel="nofollow" href="#/register" data-agreement="true"
            data-register="true" class="link" data-href="//account.xiaomi.com/pass/register?sid=mi_eshop"
            data-params="&quot;&quot;">注册</a>
          <span class="sep">|</span>
          <span class="message">
            <a data-spm="navigation.message_navigation_bar.1" rel="nofollow" href="#/login_out"
              data-href="//www.mi.com/user/message" class="J_needAgreement" data-login="true"
              data-agreement="true">消息通知<i class="J_miMessageTotal"></i></a></span>
        </div>


      </div>

      <div class="top_headers" style="top: 40px;">
        <div class="header_container">
          <div class="logo">
            <a href="/#/home">
              <img src="../../static/img/logo.png" />

            </a>
          </div>
          <div class="top_header_container">
            <!-- <div class="top_item"><a href="http://localhost:8081/#/home">商城首页</a></div>
						<div class="top_item">网红推荐</div>
						<div class="top_item">我的购物车</div>
						<div class="top_item active"> 热榜社区 </div> -->
          </div>
          <div class="search_container">
            <div class="search_box">
              <i class="el-icon-search"></i>
              <input placeholder="请输入搜索内容" type="text" value="">
            </div>
          </div>
        </div>
      </div>
    </el-header>
  </div>

</template>

<script>
  export default {
    name: "TestHome",
    data() {
      return {
         username: window.sessionStorage.username
      }
    },
    methods: {
    }
  }
</script>

<style>
  .top_headers {
    height: 70px;
    width: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    box-shadow: 0 -2px 10px 5px hsl(0deg 0% 39% / 30%);
    position: absolute;
    top: 0;
    left: 0;
    z-index: 100;
    background-color: #F9FAFC;
  }

  .header_container {
    width: 1200px;
    display: flex;
    align-items: center;
  }

  .top_header_container {
    display: flex;
    justify-content: center;
    align-items: center;
  }

  .search_container {
    text-align: left;
    width: 280px;
    height: 40px;
    border: 1px solid #ebedf2;
    line-height: 38px;
    border-radius: 20px;
    margin-left: 100px;
    position: relative;
  }

  .search_box {
    padding-left: 20px;
    position: relative;
    display: flex;
    align-items: center;

  }

  .top_item {
    line-height: 70px;
    padding: 0 20px;
    cursor: pointer;
  }

  .logo {
    margin-right: 200px;
    margin-left: 80px;
  }

  .search_box input {
    line-height: 38px;
    text-align: left;
    border: none;
    background-color: #F9FAFC;
  }

  .site-topbar {
    position: relative;
    z-index: 30;
    height: 40px;
    font-size: 12px;
    color: #b0b0b0;
    background: #333;
  }

  .container {
    width: 1226px;
    margin-right: auto;
    margin-left: auto;
  }

  .container:after,
  .container:before {
    content: " ";
    display: table;
  }

  .topbar-nav {
    float: left;
    height: 40px;
    line-height: 40px;
    margin-left: 100px;
  }

  .site-topbar a {
    color: #b0b0b0;
    display: inline-block;

  }

  a,
  a:hover {
    text-decoration: none;
  }

  .site-topbar .sep {
    margin: 0 .3em;
    color: #424242;
  }

  .ndash,
  .sep {
    font-family: sans-serif;
  }

  .site-topbar .topbar-cart {
    position: relative;
    float: right;
    width: 120px;
    height: 40px;
    margin-left: 15px;
    -webkit-transition: all .2s;
    transition: all .2s;
    font-size: 12px;
  }

  .site-topbar .cart-mini {
    position: relative;
    z-index: 32;
    display: block;
    height: 40px;
    line-height: 40px;
    text-align: center;
    color: #b0b0b0;
    background: #424242;
  }

  .site-topbar .cart-mini em {
    margin-right: 4px;
    font-size: 20px;
    line-height: 20px;
    vertical-align: -4px;
  }

  [class*=iconfont] {
    font-family: iconfont !important;
    font-style: normal;
    -webkit-font-smoothing: antialiased;
    -webkit-text-stroke-width: .2px;
    -moz-osx-font-smoothing: grayscale;
  }

  .hide {
    display: none !important;
  }

  .site-topbar .cart-menu {
    position: absolute;
    right: 0;
    top: 40px;
    z-index: 31;
    width: 316px;
    height: 0;
    color: #424242;
    background: #fff;
    -webkit-box-shadow: 0 2px 10px rgb(0 0 0 / 15%);
    box-shadow: 0 2px 10px rgb(0 0 0 / 15%);
    overflow: hidden;
    -webkit-transition: height .3s;
    transition: height .3s;
  }

  .site-topbar .topbar-cart {
    position: relative;
    float: right;
    width: 120px;
    height: 40px;
    margin-left: 15px;
    -webkit-transition: all .2s;
    transition: all .2s;
    font-size: 12px;
  }

  .site-topbar {
    position: relative;
    z-index: 30;
    height: 40px;
    font-size: 12px;
    color: #b0b0b0;
    background: #333;
  }

  .site-topbar .topbar-info {
    position: relative;
    float: right;
    height: 40px;
    line-height: 40px;
  }

  .site-topbar .topbar-info .link {
    padding: 0 5px;
    text-align: center;
  }

  .site-topbar .message i {
    font-style: normal;
  }
</style>
