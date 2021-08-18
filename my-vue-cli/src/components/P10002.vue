<template>
  <div id="quanju">

    <v-header></v-header>

    <el-main>
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item><a href="/">活动管理</a></el-breadcrumb-item>
        <el-breadcrumb-item>活动列表</el-breadcrumb-item>
        <el-breadcrumb-item>活动详情</el-breadcrumb-item>
      </el-breadcrumb>
      <div class="one">
        <div class="left">
          <div class="block">
            <el-carousel height="500px" style="margin-top: 40px;">
              <el-carousel-item v-for="item in img1" :key="item.id">
                <span>
                  <img :src="item.idView" class="image">
                </span>

              </el-carousel-item>
            </el-carousel>
          </div>

        </div>

        <div class="right" v-for="item in list">
          <div class="h3">
            <h3>{{item.product_name}}</h3>
          </div>
          <div class="mt10">
            <p>{{item.des}}</p>

          </div>
          <div class="price">{{item.price}}&nbsp;&nbsp;&nbsp;元</div>

          <div class="buy">
            <div class="item">
              <div class="dt">
                数量

              </div>
              <div class="dd">
                <el-input-number style="float: left;" v-model="num" @change="handleChange" :min="1" :max="10" label="描述文字"></el-input-number>
              </div>
            </div>
          </div>

          <div class="order">
            <input class="buyBtn" type="button" value="立即选购" @click="toCart()">
            <button class="addBtn" @click="addCart()"><i class="el-icon-shopping-cart-full"></i>加入购物车</button>
            <div class="num">（库存&nbsp;<span id="goods-stock">{{item.stock}}</span>&nbsp;件）</div>
          </div>
          <div class="tb-extra ml20" id="J_tbExtra">
            <dl>
              <dt>承诺</dt>
              <dd><a class="J_Cont" title="满足7天无理由退换货申请的前提下，包邮商品需要买家承担退货邮费，非包邮商品需要买家承担发货和退货邮费。" href="#"
                  target="_blank"><img src="../assets/7d.jpg">7天无理由</a></dd>
            </dl>
            <dl>
              <dt>支付</dt>
              <dd><a href="##" target="_blank"><img src="../assets/mayi.png">蚂蚁花呗</a><a href="##" target="_blank"><img
                    src="../assets/card.png">信用卡支付</a><a href="##" target="_blank"><img src="../assets/ji.png">集分宝</a>
              </dd>
            </dl>
          </div>
        </div>
      </div>

      <div id="kindPicture-10086696572276">
        <p><img alt="mate40pro-PC版通用-六大理由.jpg" src="../../static/img/0.jpg">
        </p>
        <p><img style="" src="../../static/img/1.jpg">
        </p>
        <p><img style="" src="../../static/img/2.jpg">
        </p>
        <p><img style="" src="../../static/img/3.jpg">
        </p>
        <p><img alt="mzsm1920.jpg" title="" src="../../static/img/4.jpg">
        </p>
      </div>


    </el-main>

    <v-footer></v-footer>
  </div>
</template>

<script>
  import header from "./TestHeader"
  import footer from "./Footer"
  export default {
    components: {
      "v-header": header,
      "v-footer": footer
    },
    data() {
      return {
        num: 1,
        list: [],
        img1: [{
            id: 0,
            idView: require('../../static/img/z.png')
          },
          {
            id: 1,
            idView: require('../../static/img/f.png')
          },
        ]
      }
    },

    created() {
      this.getCart();
    },
    methods: {
      handleChange(value) {
        console.log(value);
      },
      getCart: function() {
        this.$axios.get("http://localhost:8080/my_shop_user/goods", {
          headers: {
            "Content-Type": "application/x-www-form-urlencoded"
          },
          params: {
            "gid": 10002,
            "num":this.num,
          }, //请求参数 JSON对象
          responseType: "json", //服务端返回的数据类型
          responseEncoding: "UTF-8" //服务端响应的数据编码格式
        }).then(response => {
          this.list.push(response.data) //数值赋值给data对象的students属性
        }).catch(e => {
          console.log(e);
          alert(e);
        });
      },
      addCart: function() {
        this.$axios.get("http://localhost:8080/my_shop_user/cart/a", {
          headers: {
            "Content-Type": "application/x-www-form-urlencoded"
          },
          params: {
            "id": 10002,
            "num":this.num,
          }, //请求参数 JSON对象
          responseType: "json", //服务端返回的数据类型
          responseEncoding: "UTF-8" //服务端响应的数据编码格式
        }).then(response => {
          this.list.push(response.data)
          alert("添加购物车成功")
        }).catch(e => {
          console.log(e);
          alert(e);
        });
      },
      toCart: function() {
        this.$axios.get("http://localhost:8080/my_shop_user/cart/a", {
          headers: {
            "Content-Type": "application/x-www-form-urlencoded"
          },
          params: {
            "id": 10002,
            "num":this.num,
          }, //请求参数 JSON对象
          responseType: "json", //服务端返回的数据类型
          responseEncoding: "UTF-8" //服务端响应的数据编码格式
        }).then(response => {
          this.list.push(response.data)
          this.$router.push("/cart")
        }).catch(e => {
          console.log(e);
          alert(e);
        });
      },
    },
  }
</script>

<style>
  .buy {
    margin-left: 10px;
    margin-top: 100px;
  }

  .order {
    margin-top: 20px;
  }

  .item {
    width: 590px;
    clear: both;
  }

  .buy .dt {
    line-height: 35px;
    height: 30px;
    display: inline;
    float: left;
    font-family: simsun;
    width: 75px;
  }

  .buy .dd {
    width: 525px;
    line-height: 35px;
    height: 30px;
    padding-bottom: 20px;
  }

  .buy-btn {
    color: #666;
    background: #f2f2f2;
    cursor: pointer;
    float: left;
    display: block;
    height: 27px;
    line-height: 26px;
    padding: 0px 10px;
    border: 1px solid #ddd;
  }

  input[type="text"].buy-num {
    text-align: center;
    width: 50px;
    height: 25px;
    float: left;
    border-left: 0px;
    border-right: 0px;
    border-top: 1px solid #ddd;
    border-bottom: 1px solid #ddd;
  }

  .buy-btn {
    color: #666;
    background: #f2f2f2;
    cursor: pointer;
    float: left;
    display: block;
    height: 27px;
    line-height: 26px;
    padding: 0px 10px;
    border: 1px solid #ddd;
  }

  .buyBtn {
    width: 160px;
    height: 40px;
    line-height: 40px;
    font-size: 16px;
    display: block;
    float: left;
    margin-right: 10px;
    text-align: center;
    background: #fbf0e8;
    border: 1px solid #ff6700;
    color: #ff6700;
    -webkit-transition: all .4s;
    transition: all .4s;
  }

  .addBtn {
    width: 160px;
    height: 40px;
    line-height: 40px;
    font-size: 16px;
    display: block;
    float: left;
    text-align: center;
    background: #ff6700;
    border: 1px solid #ff6700;
    color: #fff;
    -webkit-transition: all .4s;
    transition: all .4s;
  }

  .favorite {
    float: left;
    position: relative;
    border: 1px solid #ededed;
    margin-left: 10px;
    width: 90px;
    height: 40px;
    line-height: 40px;
    font-size: 16px;
    text-align: center;
    -webkit-transition: all .4s;
    transition: all .4s;
  }

  .order {
    margin-left: 150px;
  }

  span>img {
    cursor: pointer;
    transition: all 0.6s;
  }

  span>img:hover {
    transform: scale(1.4);
  }

  .one {
    margin-top: 100px;
    position: relative;

  }

  .left {
    width: 400px;
    margin-left: 150px;
    position: absolute;
    line-height: 20px;
  }

  .right {
    position: relative;
    left: 600px;
    width: 620px;
    background: #f8f8f8;
    padding-bottom: 10px;
  }

  .h3 {
    padding: 10px;
    height: 60px;
    border-bottom: 3px solid #E9EBFE;
  }

  .el-main {
    background-color: #ffffff;
    color: #333;
    line-height: 40px;
  }

  .price {
    color: #ff6700;
    display: inline-block;
    margin-top: 40px;
    font-size: 40px;
    vertical-align: middle;
  }

  dl {
    overflow: hidden;
  }

  dd {
    display: block;
    margin-inline-start: 40px;
  }

  dl dd a {
    float: left;
    margin-bottom: 15px;
    margin-right: 15px;
    height: 22px;
    line-height: 22px;
    color: #6C6C6C;
  }

  dl dt {
    float: left;
    width: 60px;
    height: 22px;
    line-height: 22px;
    margin-bottom: 4px;
    color: #6C6C6C;
  }

  dd>img {
    border: none;
    max-width: 100%;
    max-height: 100%;
  }

  .ml20 {
    margin-top: 40px;
    margin-left: 20px;
  }

  p {
    display: block;
    margin-block-start: 1em;
    margin-block-end: 1em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
  }

  p>img {
    width: 100%;
  }
</style>
