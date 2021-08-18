<template>
  <div>
    <el-main>
      <div>
        <div class="g-bd" style="margin-top: 100px;border:3px #E9EBFE solid">
          <div class="g-sd">
            <h2 class="msg">我的订单</h2>
            <ul id="tab-box" class="n-msgtab f-cb">
              <button class="btn_anniu" @click="change(0);waitPaid()" :class="{ newStyle:0===number}">待支付</button>
              <button class="btn_anniu" @click="change(1);waitDeliver()" :class="{ newStyle:1===number}">待发货</button>
              <button class="btn_anniu" @click="change(2);deliver()" :class="{ newStyle:2===number}">待收货</button>
              <button class="btn_anniu" @click="change(3);takeDelivery()" :class="{ newStyle:3===number}">已收货</button>
              <button class="btn_anniu" @click="change(4);remove()" :class="{ newStyle:4===number}">取消/拒收</button>
              <button class="btn_anniu" @click="change(5);refund()" :class="{ newStyle:5===number}">退款</button>
            </ul>
            <el-button round style="margin-top: 20px;">一键已读</el-button>
          </div>
          <div class="g-mn">
            <div class="g-mnc">
              <div class="g-wrap">
                <h3 class="v-hd"><span class=" tit">猿速商城</span></h3>
                <div class="list">
                  <div class="zyj" v-show="0===number">
                    <table style="text-align: center;">
                      <thead class="lhead">
                        <tr class="lhead">
                          <el-row>
                            <el-col :span="2" class="lh">
                              <td>订单编号</td>
                            </el-col>
                            <el-col :span="2" class="lh">
                              <td>收货人</td>
                            </el-col>
                            <el-col :span="5" class="lh">
                              <td>用户留言</td>
                            </el-col>
                            <el-col :span="2" class="lh">
                              <td>订单总金额</td>
                            </el-col>
                            <el-col :span="2" class="lh">
                              <td>配送方式</td>
                            </el-col>
                            <el-col :span="4" class="lh" style="width: 130px;">
                              <td>下单时间</td>
                            </el-col>
                            <el-col :span="3" class="lh">
                              <td>订单状态</td>
                            </el-col>
                            <el-col :span="2" class="lh" style="margin-left: 10px;">
                              <td>操作</td>
                            </el-col>
                          </el-row>
                        </tr>
                      </thead>
                      <tbody>
                        <tr class="lbody" v-for="(item,index) in waitPaid1" :key="index">
                          <el-col :span="2" class="lb">
                            <td>
                              <p>{{ item.oid  }}</p>
                            </td>
                          </el-col>
                          <el-col :span="2" class="lb">
                            <td>
                              <p>{{ item.consignee  }}</p>
                            </td>
                          </el-col>
                          <el-col :span="5" class="lb">
                            <td>
                              <p>{{ item.guest_book  }}</p>
                            </td>
                          </el-col>
                          <el-col :span="2" class="lb">
                            <td>
                              <p>{{ item.total_amount  }}</p>
                            </td>
                          </el-col>
                          <el-col :span="2" class="lb">
                            <td>
                              <p>{{ item.distribution  }}</p>
                            </td>
                          </el-col>
                          <el-col :span="5" class="lb" style="width: 130px;">
                            <td>
                              <p>{{ item.order_data  }}</p>
                            </td>
                          </el-col>
                          <el-col :span="3" class="lb">
                            <td>
                              <p>待支付</p>
                            </td>
                          </el-col>
                          <el-col :span="2" class="lb" style="margin-left: 10px;">
                            <td>
                              <el-button type="primary" round="" class="bt" @click="buy(item.oid)">支付</el-button>
                            </td>
                          </el-col>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                  <div class="zyj" v-show="1===number">
                    <table style="text-align: center;">
                      <thead class="lhead">
                        <tr class="lhead">
                          <el-row>
                            <el-col :span="2" class="lh">
                              <td>订单编号</td>
                            </el-col>
                            <el-col :span="2" class="lh">
                              <td>收货人</td>
                            </el-col>
                            <el-col :span="5" class="lh">
                              <td>用户留言</td>
                            </el-col>
                            <el-col :span="2" class="lh">
                              <td>订单总金额</td>
                            </el-col>
                            <el-col :span="2" class="lh">
                              <td>配送方式</td>
                            </el-col>
                            <el-col :span="4" class="lh" style="width: 130px;">
                              <td>下单时间</td>
                            </el-col>
                            <el-col :span="3" class="lh">
                              <td>订单状态</td>
                            </el-col>
                            <el-col :span="2" class="lh" style="margin-left: 10px;">
                              <td>操作</td>
                            </el-col>
                          </el-row>
                        </tr>
                      </thead>
                      <tbody>
                        <tr class="lbody" v-for="(item,index) in waitDeliver1" :key="index">
                          <el-col :span="2" class="lb">
                            <td>
                              <p>{{ item.oid  }}</p>
                            </td>
                          </el-col>
                          <el-col :span="2" class="lb">
                            <td>
                              <p>{{ item.consignee  }}</p>
                            </td>
                          </el-col>
                          <el-col :span="5" class="lb">
                            <td>
                              <p>{{ item.guest_book  }}</p>
                            </td>
                          </el-col>
                          <el-col :span="2" class="lb">
                            <td>
                              <p>{{ item.total_amount  }}</p>
                            </td>
                          </el-col>
                          <el-col :span="2" class="lb">
                            <td>
                              <p>{{ item.distribution  }}</p>
                            </td>
                          </el-col>
                          <el-col :span="5" class="lb" style="width: 130px;">
                            <td>
                              <p>{{ item.order_data  }}</p>
                            </td>
                          </el-col>
                          <el-col :span="3" class="lb">
                            <td>
                              <p>待发货</p>
                            </td>
                          </el-col>
                          <el-col :span="2" class="lb" style="margin-left: 10px;">
                            <td>
                              <el-button type="danger" round class="bt" @click="cancel(item.oid)">取消/拒收</el-button>
                            </td>
                          </el-col>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                  <div class="zyj" v-show="2===number">
                    <table style="text-align: center;">
                      <thead class="lhead">
                        <tr class="lhead">
                          <el-row>
                            <el-col :span="2" class="lh">
                              <td>订单编号</td>
                            </el-col>
                            <el-col :span="2" class="lh">
                              <td>收货人</td>
                            </el-col>
                            <el-col :span="5" class="lh">
                              <td>用户留言</td>
                            </el-col>
                            <el-col :span="2" class="lh">
                              <td>订单总金额</td>
                            </el-col>
                            <el-col :span="2" class="lh">
                              <td>配送方式</td>
                            </el-col>
                            <el-col :span="4" class="lh" style="width: 120px;">
                              <td>下单时间</td>
                            </el-col>
                            <el-col :span="3" class="lh">
                              <td>订单状态</td>
                            </el-col>
                            <el-col :span="2" class="lh">
                              <td>&nbsp;拒收&nbsp;/&nbsp;收货</td>
                            </el-col>
                          </el-row>
                        </tr>
                      </thead>
                      <tbody>
                        <tr class="lbody" v-for="(item,index) in deliver1" :key="index">
                          <el-col :span="2" class="lb">
                            <td>
                              <p>{{ item.oid  }}</p>
                            </td>
                          </el-col>
                          <el-col :span="2" class="lb">
                            <td>
                              <p>{{ item.consignee  }}</p>
                            </td>
                          </el-col>
                          <el-col :span="5" class="lb">
                            <td>
                              <p>{{ item.guest_book  }}</p>
                            </td>
                          </el-col>
                          <el-col :span="2" class="lb">
                            <td>
                              <p>{{ item.total_amount  }}</p>
                            </td>
                          </el-col>
                          <el-col :span="2" class="lb">
                            <td>
                              <p>{{ item.distribution  }}</p>
                            </td>
                          </el-col>
                          <el-col :span="5" class="lb" style="width: 130px;">
                            <td>
                              <p>{{ item.order_data  }}</p>
                            </td>
                          </el-col>
                          <el-col :span="3" class="lb">
                            <td>
                              <p>待收货</p>
                            </td>
                          </el-col>
                          <el-col :span="2" class="lb">
                            <td>
                              <el-button type="danger" icon="el-icon-close" circle style="margin-left: -10px;"
                                @click="cancel(item.oid)"></el-button>
                              <el-button type="info" icon="el-icon-box" circle style="margin-left: 0px;"
                                @click="accept(item.oid)"></el-button>
                            </td>
                          </el-col>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                  <div class="zyj" v-show="3===number">
                    <table style="text-align: center;">
                      <thead class="lhead">
                        <tr class="lhead">
                          <el-row>
                            <el-col :span="2" class="lh">
                              <td>订单编号</td>
                            </el-col>
                            <el-col :span="2" class="lh">
                              <td>收货人</td>
                            </el-col>
                            <el-col :span="5" class="lh">
                              <td>用户留言</td>
                            </el-col>
                            <el-col :span="2" class="lh">
                              <td>订单总金额</td>
                            </el-col>
                            <el-col :span="2" class="lh">
                              <td>配送方式</td>
                            </el-col>
                            <el-col :span="4" class="lh" style="width: 130px;">
                              <td>下单时间</td>
                            </el-col>
                            <el-col :span="3" class="lh">
                              <td>订单状态</td>
                            </el-col>
                            <el-col :span="2" class="lh" style="margin-left: 10px;">
                              <td>操作</td>
                            </el-col>
                          </el-row>
                        </tr>
                      </thead>
                      <tbody>
                        <tr class="lbody" v-for="(item,index) in takeDelivery1" :key="index">
                          <el-col :span="2" class="lb">
                            <td>
                              <p>{{ item.oid  }}</p>
                            </td>
                          </el-col>
                          <el-col :span="2" class="lb">
                            <td>
                              <p>{{ item.consignee  }}</p>
                            </td>
                          </el-col>
                          <el-col :span="5" class="lb">
                            <td>
                              <p>{{ item.guest_book  }}</p>
                            </td>
                          </el-col>
                          <el-col :span="2" class="lb">
                            <td>
                              <p>{{ item.total_amount  }}</p>
                            </td>
                          </el-col>
                          <el-col :span="2" class="lb">
                            <td>
                              <p>{{ item.distribution  }}</p>
                            </td>
                          </el-col>
                          <el-col :span="5" class="lb" style="width: 130px;">
                            <td>
                              <p>{{ item.order_data  }}</p>
                            </td>
                          </el-col>
                          <el-col :span="3" class="lb">
                            <td>
                              <p>已收货</p>
                            </td>
                          </el-col>
                          <el-col :span="2" class="lb" style="margin-left: 10px;">
                            <td>
                              <el-button disabled class="bt">已收货</el-button>
                            </td>
                          </el-col>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                  <div class="zyj" v-show="4===number">
                    <table style="text-align: center;">
                      <thead class="lhead">
                        <tr class="lhead">
                          <el-row>
                            <el-col :span="2" class="lh">
                              <td>订单编号</td>
                            </el-col>
                            <el-col :span="2" class="lh">
                              <td>收货人</td>
                            </el-col>
                            <el-col :span="5" class="lh">
                              <td>用户留言</td>
                            </el-col>
                            <el-col :span="2" class="lh">
                              <td>订单总金额</td>
                            </el-col>
                            <el-col :span="2" class="lh">
                              <td>配送方式</td>
                            </el-col>
                            <el-col :span="4" class="lh" style="width: 130px;">
                              <td>下单时间</td>
                            </el-col>
                            <el-col :span="3" class="lh">
                              <td>订单状态</td>
                            </el-col>
                            <el-col :span="2" class="lh" style="margin-left: 10px;">
                              <td>操作</td>
                            </el-col>
                          </el-row>
                        </tr>
                      </thead>
                      <tbody>
                        <tr class="lbody" v-for="(item,index) in remove1" :key="index">
                          <el-col :span="2" class="lb">
                            <td>
                              <p>{{ item.oid  }}</p>
                            </td>
                          </el-col>
                          <el-col :span="2" class="lb">
                            <td>
                              <p>{{ item.consignee  }}</p>
                            </td>
                          </el-col>
                          <el-col :span="5" class="lb">
                            <td>
                              <p>{{ item.guest_book  }}</p>
                            </td>
                          </el-col>
                          <el-col :span="2" class="lb">
                            <td>
                              <p>{{ item.total_amount  }}</p>
                            </td>
                          </el-col>
                          <el-col :span="2" class="lb">
                            <td>
                              <p>{{ item.distribution  }}</p>
                            </td>
                          </el-col>
                          <el-col :span="5" class="lb" style="width: 130px;">
                            <td>
                              <p>{{ item.order_data  }}</p>
                            </td>
                          </el-col>
                          <el-col :span="3" class="lb">
                            <td>
                              <p>取消/拒收</p>
                            </td>
                          </el-col>
                          <el-col :span="2" class="lb" style="margin-left: 10px;">
                            <td>
                              <el-button type="warning" round class="bt" @click="re(item.oid)">申请退款</el-button>
                            </td>
                          </el-col>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                  <div class="zyj" v-show="5===number">
                    <table style="text-align: center;">
                      <thead class="lhead">
                        <tr class="lhead">
                          <el-row>
                            <el-col :span="2" class="lh">
                              <td>订单编号</td>
                            </el-col>
                            <el-col :span="2" class="lh">
                              <td>申请人</td>
                            </el-col>
                            <el-col :span="5" class="lh">
                              <td>配送方式</td>
                            </el-col>
                            <el-col :span="2" class="lh">
                              <td>申请退款金额</td>
                            </el-col>
                            <el-col :span="2" class="lh">
                              <td>申请时间</td>
                            </el-col>
                            <el-col :span="4" class="lh" style="width: 130px;">
                              <td>退款状态</td>
                            </el-col>
                            <el-col :span="3" class="lh">
                              <td>退款备注</td>
                            </el-col>
                            <el-col :span="2" class="lh" style="margin-left: 10px;">
                              <td>操作</td>
                            </el-col>
                          </el-row>
                        </tr>
                      </thead>
                      <tbody>
                        <tr class="lbody" v-for="(item,index) in refund1" :key="index">
                          <el-col :span="2" class="lb">
                            <td>
                              <p>{{ item.oid  }}</p>
                            </td>
                          </el-col>
                          <el-col :span="2" class="lb">
                            <td>
                              <p>{{ item.consignee  }}</p>
                            </td>
                          </el-col>
                          <el-col :span="5" class="lb">
                            <td>
                              <p>{{ item.distribution  }}</p>
                            </td>
                          </el-col>
                          <el-col :span="2" class="lb">
                            <td>
                              <p>{{ item.total_amount  }}</p>
                            </td>
                          </el-col>
                          <el-col :span="2" class="lb">
                            <td>
                              <p>{{ item.apply_data  }}</p>
                            </td>
                          </el-col>
                          <el-col :span="5" class="lb" style="width: 130px;">
                            <td>
                              <p>{{ item.refund_status  }}</p>
                            </td>
                          </el-col>
                          <el-col :span="3" class="lb">
                            <td>
                              <p>{{ item.refund_notes  }}</p>
                            </td>
                          </el-col>
                          <el-col :span="2" class="lb" style="margin-left: 10px;">
                            <td>
                              <el-button disabled class="bt">退款中</el-button>
                            </td>
                          </el-col>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </el-main>
  </div>
</template>

<script>
  export default {
    name: "listmain",
    data() {
      return {
        oid:[],
        number: 0,
        refund_notes:"",
        waitPaid1: [],
        waitDeliver1: [],
        deliver1: [],
        takeDelivery1: [],
        remove1: [],
        refund1: [],
      }
    },
    methods: {
      open() {
        this.$prompt('请输入退款理由', '亲~真的要退款吗', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
        }).then(({
          value
        }) => {
          this.$message({
            type: 'success',
          });
        }).catch(() => {
          this.$message({
            type: 'info',
          });
        });
      },
      re: function(oid) {
        let params = this.$qs.stringify({
          oid: oid
        });
        this.$axios.post("http://localhost:8080/my_shop_user/toApplyRefund", params, {
          headers: {
            "Content-Type": "application/x-www-form-urlencoded"
          },
          responseType: "json", //服务端返回的数据类型
          responseEncoding: "UTF-8" //服务端响应的数据编码格式
        }).then().catch(e => {
          console.log(e);
          alert(e);
        });
        alert("成功");
      },
      accept: function(oid) {
        let params = this.$qs.stringify({
          oid: oid
        });
        this.$axios.post("http://localhost:8080/my_shop_user/toTakeDelivery", params, {
          headers: {
            "Content-Type": "application/x-www-form-urlencoded"
          },
          responseType: "json", //服务端返回的数据类型
          responseEncoding: "UTF-8" //服务端响应的数据编码格式
        }).then().catch(e => {
          console.log(e);
          alert(e);
        });
        alert("收货成功");
      },
      cancel: function(oid) {
        let params = this.$qs.stringify({
          oid: oid
        });
        this.$axios.post("http://localhost:8080/my_shop_user/toRemove", params, {
          headers: {
            "Content-Type": "application/x-www-form-urlencoded"
          },
          responseType: "json", //服务端返回的数据类型
          responseEncoding: "UTF-8" //服务端响应的数据编码格式
        }).then().catch(e => {
          console.log(e);
          alert(e);
        });
        alert("取消/拒收 成功");
      },
      buy: function(oid) {
        let params = this.$qs.stringify({
          oid: oid
        });
        this.$axios.post("http://localhost:8080/my_shop_user/toPay", params, {
          headers: {
            "Content-Type": "application/x-www-form-urlencoded"
          },
          responseType: "json", //服务端返回的数据类型
          responseEncoding: "UTF-8" //服务端响应的数据编码格式
        }).then().catch(e => {
          console.log(e);
          alert(e);
        });
        alert("支付成功");
      },
      change: function(index) {
        this.number = index; //重要处
      },
      waitPaid: function() {
        this.$axios.post("http://localhost:8080/my_shop_user/waitPaid", {
          responseType: "json", //服务端返回的数据类型
          responseEncoding: "UTF-8" //服务端响应的数据编码格式
        }).then(response => {
          this.waitPaid1 = response.data;
          console.log(response.data)
        }).catch(e => {
          console.log(e);
          alert(e);
        });
      },
      waitDeliver: function() {
        this.$axios.post("http://localhost:8080/my_shop_user/waitdeliver", {
          responseType: "json", //服务端返回的数据类型
          responseEncoding: "UTF-8" //服务端响应的数据编码格式
        }).then(response => {
          this.waitDeliver1 = response.data;
          console.log(response.data)
        }).catch(e => {
          console.log(e);
          alert(e);
        });
      },
      deliver: function() {
        this.$axios.post("http://localhost:8080/my_shop_user/deliver", {
          responseType: "json", //服务端返回的数据类型
          responseEncoding: "UTF-8" //服务端响应的数据编码格式
        }).then(response => {
          this.deliver1 = response.data;
          console.log(response.data)
        }).catch(e => {
          console.log(e);
          alert(e);
        });
      },
      takeDelivery: function() {
        this.$axios.post("http://localhost:8080/my_shop_user/takeDelivery", {
          responseType: "json", //服务端返回的数据类型
          responseEncoding: "UTF-8" //服务端响应的数据编码格式
        }).then(response => {
          this.takeDelivery1 = response.data;
          console.log(response.data)
        }).catch(e => {
          console.log(e);
          alert(e);
        });
      },
      remove: function() {
        this.$axios.post("http://localhost:8080/my_shop_user/remove", {
          responseType: "json", //服务端返回的数据类型
          responseEncoding: "UTF-8" //服务端响应的数据编码格式
        }).then(response => {
          this.remove1 = response.data;
          console.log(response.data)
        }).catch(e => {
          console.log(e);
          alert(e);
        });
      },
      refund: function() {
        this.$axios.post("http://localhost:8080/my_shop_user/refund", {
          responseType: "json", //服务端返回的数据类型
          responseEncoding: "UTF-8" //服务端响应的数据编码格式
        }).then(response => {
          this.refund1 = response.data;
          console.log(response.data)
        }).catch(e => {
          console.log(e);
          alert(e);
        });
      },
    },
  }
</script>

<style>
  .wz {
    font-size: 1px;
  }

  .bt {
    width: 100px;
    height: 35px;
    margin-left: -20px;
  }

  .list {
    font-size: 10px;
  }

  .lb {
    width: 80px;
    padding-top: 10px;
  }

  .lh {
    width: 80px;
    margin-bottom: 10px;
  }

  .zyj td {
    margin: 2px 2px 2px 10px;
  }

  .v-hd .tit {
    font-size: 20px;
    font-weight: bold;
    line-height: 35px;
  }

  .v-hd {
    height: 35px;
    border-bottom: 5px solid #FFF2E2;
  }

  .g-wrap {
    padding: 40px;
    height: 620px;
    border-left: 2px #CCE8CF solid;
  }

  .g-mnc {
    margin-left: 185px;
  }

  .g-bd {
    border-top: 5px #00BFFF solid;
    width: 980px;
    min-height: 700px;
    _height: 700px;
    margin: 0 auto;
    background-color: #fff;
    border: 1px solid #d3d3d3;
    border-width: 0 1px;
  }

  .g-sd {
    position: relative;
    float: left;
    width: 184px;
  }

  .g-mn {
    float: right;
    width: 100%;
    margin-left: -185px;
  }

  .msg {
    height: 30px;
    padding: 32px 0 14px 0px;
    font-size: 20px;
    font-weight: normal;
    line-height: 30px;
  }

  .n-msgtab {
    border-top: 1px solid #ddd;
  }

  .n-msgtab .btn_anniu {
    float: right;
    width: 14px;
    border-bottom: 1px solid #ddd;
    list-style: none;
  }

  .n-msgtab .btn_anniu {
    display: block;
    width: 185px;
    height: 53px;
    padding-left: 0px;
    background: #f7f7f7;
    border: 1px solid #fff;
    line-height: 53px;
  }

  .j-iflag span {
    margin-left: -40px;
  }
</style>
