<template>
  <div class="site-topbar">
    <div class="container">
      <div class="topbar-nav"><a rel="nofollow" href="#/home">Ape-Speed商城</a> <span class="sep">|</span>
      </div>
      <div id="J_miniCartTrigger" class="topbar-cart"><a data-spm="navigation.to_cart_navigation_bar.1" rel="nofollow"
          id="J_miniCartBtn" href="#/cart/list" class="cart-mini" data-params="&quot;&quot;"><em
            class="iconfont-cart"></em><em class="iconfont-cart-full hide"></em>购物车<span
            class="cart-mini-num J_cartNum">（0）</span></a>
        <div id="J_miniCartMenu" class="cart-menu " style="height: 0px;">
          <div class="menu-content">
            <div class="loading">
              <div class="loader"></div>
            </div>
            <ul id="J_miniCartList" class="cart-list hide"></ul>
            <div id="J_miniCartListTotal" class="cart-total clearfix hide"></div>
            <div class="msg msg-error hide"></div>
            <div class="msg msg-empty hide">购物车中还没有商品，赶紧选购吧！</div>
          </div>
        </div>
      </div>
      <div id="J_siteUserInfo" class="topbar-info"><a data-spm="navigation.logon_navigation_bar.1" rel="nofollow"
          href="#/login" data-agreement="true" data-login="true" class="link"
          data-href="#/login"
          data-params="&quot;&quot;">登录</a> <span class="sep">|</span> <a
          data-spm="navigation.register_navigation_bar.1" rel="nofollow" href="#/register"
          data-agreement="true" data-register="true" class="link"
          data-href="//account.xiaomi.com/pass/register?sid=mi_eshop" data-params="&quot;&quot;">注册</a><span
          class="sep">|</span><span class="message"><a data-spm="navigation.message_navigation_bar.1" rel="nofollow"
            href="javascript:void(0);" data-href="//www.mi.com/user/message" class="J_needAgreement" data-login="true"
            data-agreement="true">消息通知<i class="J_miMessageTotal"></i></a></span></div>
    </div>
  </div>
</template>

<script>
</script>

<style>
    .site-topbar {
      position: fixed;
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
  .container:after, .container:before {
      content: " ";
      display: table;
  }
  .site-topbar .topbar-nav {
      float: left;
      height: 40px;
      line-height: 40px;
  }
  .site-topbar a {
      color: #b0b0b0;
      line-height: 40px;
      display: inline-block;
  }
  a {
      background-color: rgba(0,0,0,0);
  }
  a:-webkit-any-link {
      cursor: pointer;
  }
  a, a:hover {
      text-decoration: none;
  }
  .site-topbar .sep {
      margin: 0 .3em;
      color: #424242;
  }
  .ndash, .sep {
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
      font-family: iconfont!important;
      font-style: normal;
      -webkit-font-smoothing: antialiased;
      -webkit-text-stroke-width: .2px;
      -moz-osx-font-smoothing: grayscale;
  }
  .hide {
      display: none!important;
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
  .site-topbar .topbar-info .link, .site-topbar .topbar-info .message, .site-topbar .topbar-info .sep, .site-topbar .topbar-info .user {
      float: left;
  }
  .site-topbar .message i {
      font-style: normal;
  }
  body {
      font: 14px/1.5 Helvetica Neue,Helvetica,Arial,Microsoft Yahei,Hiragino Sans GB,Heiti SC,WenQuanYi Micro Hei,sans-serif;
      background-color: #fff;
      min-width: 1226px;
  }
  html {
      -webkit-text-size-adjust: 100%;
  }
</style>
