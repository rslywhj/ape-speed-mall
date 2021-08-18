<template>
  <div>
    <el-main>
      <div class="root">
        <div class="g-bd">
          <div class="m-bread">
            <div class="block">
              <span>
                <el-breadcrumb separator="/">
                  <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
                  <el-breadcrumb-item><a href="/">手机</a></el-breadcrumb-item>
                </el-breadcrumb>
              </span>
            </div>
          </div>
          <div class="f-cb">
            <span class="title">品牌:</span>
            <ul class="brand">
              <li><a class="tag">荣耀手机</a></li>
              <li><a class="tag">华为手机</a></li>
              <li><a class="tag">苹果iphone</a></li>
              <li><a class="tag">小米手机</a></li>
              <li><a class="tag">OPPO</a></li>
              <li><a class="tag">一加</a></li>
              <li><a class="tag">VIVO</a></li>
            </ul>
          </div>
        </div>
      </div>
      <div class="product">
        <div class="h1">
          <h1>为你推荐</h1>
        </div>
        <div class="row1">
          <ul>
            <li class="g" style="margin-left: 100px;">
              <a href="#/p10001">
                <img src="../../static/img/z.png" alt="华为 HUAWEI Mate 40 Pro 全网通">
                <p class="name">华为 HUAWEI Mate 40 Pro 全网通</p>
                <p class="item_price">7899.00</p>
                <p class="counter">猜你喜欢</p>
                <div class="comment">
                  <p>猿速精选</p>
                  <p>佳哥出品必是精品</p>
                </div>
              </a>
            </li>
            <li class="g">
              <a href="#/p10002">
                <img src="../../static/img/z.png" alt="MAC 雾面丝绒哑光子弹头口红">
                <p class="name">MAC 雾面丝绒哑光子弹头口红</p>
                <p class="item_price">165.00</p>
                <p class="counter">猜你喜欢</p>
                <div class="comment">
                  <p>猿速精选</p>
                  <p>佳哥出品必是精品</p>
                </div>
              </a>
            </li>
            <li class="g">
              <a href="#/p10036">
                <img src="../../static/img/a.jpg" alt="纪梵希高定香榭天鹅绒唇膏306#">
                <p class="name">纪梵希高定香榭天鹅绒唇膏306#</p>
                <p class="item_price">355</p>
                <p class="counter">猜你喜欢</p>
                <div class="comment">
                  <p>猿速精选</p>
                  <p>佳哥出品必是精品</p>
                </div>
              </a>
            </li>
            <li class="g" style="margin-right: 60px;">
              <a href="#/p10037">
                <img src="../../static/img/b.jpg" alt="索尼 WH-1000XM3 头戴式耳机">
                <p class="name">索尼 WH-1000XM3 头戴式耳机</p>
                <p class="item_price">2599.00 </p>
                <p class="counter">猜你喜欢</p>
                <div class="comment">
                  <p>猿速精选</p>
                  <p>佳哥出品必是精品</p>
                </div>
              </a>
            </li>
          </ul>
        </div>
        <div class="row1">
          <ul>
            <li class="g" style="margin-left: 100px;">
              <a href="#/p10038">
                <img src="../../static/img/c.jpg" alt="Apple AirPods 配充电盒">
                <p class="name">Apple AirPods 配充电盒</p>
                <p class="item_price">1246.00</p>
                <p class="counter">猜你喜欢</p>
                <div class="comment">
                  <p>猿速精选</p>
                  <p>佳哥出品必是精品</p>
                </div>
              </a>
            </li>
            <li class="g">
              <a href="#/p10039">
                <img src="../../static/img/d.jpg" alt="MAC 雾面丝绒哑光子弹头口红">
                <p class="name">MAC 雾面丝绒哑光子弹头口红</p>
                <p class="item_price">165.00</p>
                <p class="counter">猜你喜欢</p>
                <div class="comment">
                  <p>猿速精选</p>
                  <p>佳哥出品必是精品</p>
                </div>
              </a>
            </li>
            <li class="g">
              <a href="#/p10040">
                <img src="../../static/img/e.jpg" alt="Apple 2019款 MacBook Air 13.3">
                <p class="name">Apple 2019款 MacBook Air 13.3</p>
                <p class="item_price">8499.00</p>
                <p class="counter">猜你喜欢</p>
                <div class="comment">
                  <p>猿速精选</p>
                  <p>佳哥出品必是精品</p>
                </div>
              </a>
            </li>
            <li class="g" style="margin-right: 60px;">
              <a href="#/p10041">
                <img src="../../static/img/f.jpg" alt="无印良品 MUJI 塑料浴室座椅">
                <p class="name">无印良品 MUJI 塑料浴室座椅</p>
                <p class="item_price">85.00</p>
                <p class="counter">猜你喜欢</p>
                <div class="comment">
                  <p>猿速精选</p>
                  <p>佳哥出品必是精品</p>
                </div>
              </a>
            </li>
          </ul>
        </div>
      </div>

    </el-main>
  </div>
</template>

<script>
  export default {
    name: "ermain",
    data() {
      return {
		  list: [],
      }
    },
    created() {
      this.getCart()
    },
    methods: {
      getCart: function() {
        let params = this.$qs.stringify({
          first_name:"手机"
        });
        this.$axios.get("http://localhost:8080/my_shop_user/selectSecond",params, {
          responseType: "json", //服务端返回的数据类型
          responseEncoding: "UTF-8" //服务端响应的数据编码格式
        }).then(response => {
          this.list = response.data;
          console.log(this.list)
        }).catch(e => {
          console.log(e);
          alert(e);
        });
      }
    }

  }
</script>

<style>
  a {
    color: 8CC7B5;
    text-decoration: none;
    font-style: inherit;
  }

  .product img {
    float: left;
    width: 200px;
    height: 200px;
    margin-top: 20px;
    -webkit-transition: -webkit-box-shadow .2s linear;
    transition: box-shadow .2s linear;
  }

  .h1 {
    height: 70px;
    border-bottom: 2px #E3EDCD solid;

  }

  .h1>h1 {
    float: left;
    margin-left: 20px;
  }

  .product {
    float: left;
    margin-left: 140px;
    margin-top: -100px;
    width: 1240px;
    height: 900px;
    font-size: 12px;
    background-color: #FAF9DE;
  }

  .row1 a {
    display: flex;
    flex-direction: column;
    align-items: center;
    font-size: 14px;
    text-align: center;
    width: 100%;
    height: 100%;
    position: relative;
    overflow: hidden;
  }

  .row1 a .discount {
    background-color: #f00;
  }

  .row1 a>p {
    height: 25px;
    line-height: 25px;
    font-size: 14px;
  }

  .row1 a .item_price {
    color: #1baeae;
  }

  .row1 a .counter {
    height: 15px;
    line-height: 15px;
    color: #aaa;
    font-size: 12px;
  }

  .comment {
    position: absolute;
    bottom: 0;
    left: 0;
    right: 0;
    transform: translateY(101%);
    transition: transform 0.4s;
    box-sizing: border-box;
    height: 70px;
    padding: 10px 0 0 30px;
    background-color: #1baeae;
    color: #fff;
    text-align: left;
  }

  .comment p {
    font-size: 12px;
    margin-top: 5px;
  }

  .g {
    list-style: none;
    width: 240px;
    height: 320px;
    background-color: #fff;
    margin-bottom: 20px;
    margin-left: 10px;
    margin-right: 6px;
  }

  .row1>ul {
    display: flex;
    height: 614px;
    justify-content: space-between;
    align-content: space-between;
    flex-wrap: wrap;
    float: right;
    margin-top: 50px;
    width: 1300px;
    height: 300px;
    font-size: 12px;
  }

  .row1>ul li:hover .comment {
    transform: translateY(0);
  }

  .f-cb {
    margin-top: 10px;
    border: 2px #FDE6E0 solid;
    min-height: 100px;
  }

  .tag {
    height: 24px;
    padding: 3px 15px;
    cursor: pointer;
  }

  li {
    list-style: none;
    margin-top: 15px;
    float: left;
    line-height: 44px;
    padding: 0 4px;
    color: #333;
  }

  ul {
    float: left;
    width: 1018px;
  }

  .brand {
    width: 938px;
  }

  .title {
    margin-top: 30px;
    float: left;
    width: 80px;
    line-height: 44px;
    color: #999;
    font-weight: 600;
  }

  .block span {
    float: left;
  }

  .m-bread .block {
    font-size: 18px;
    text-decoration: none;
    padding: 100px 0 40px 0;
    font-size: 18px;
    font-weight: 600;
  }

  .m-bread {
    margin-bottom: 0;
    border-bottom: 1px solid #333;
    min-height: 30px;
  }

  .g-bd {
    width: 1100px;
    min-height: 300px;
    margin: 0 auto;
    background: #fff;
  }

  .root {
    min-height: 400px;
  }
</style>
