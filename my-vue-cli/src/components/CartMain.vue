<template>
  <div>
    <el-main>
      <div class="root">
        <div class="g-bd">
          <div class="m-bread">
            <div class="block">
              <el-breadcrumb separator="/" style="margin: -20px 0px 0px 0px;">
                <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
                <el-breadcrumb-item><a href="/">用户中心</a></el-breadcrumb-item>
                <el-breadcrumb-item>购物车</el-breadcrumb-item>
              </el-breadcrumb>
              <span style="margin-top: 20px;">购物车</span>
            </div>
          </div>
          <div class="cart-list">
            <table style="text-align:center; margin: 100px;">
              <thead>
                <tr class="chead">
                  <el-row>
                    <el-col :span="3">
                      <td><input id="allcheck" type="checkbox" @click="allcheck"
                          :checked="list.length===listIds.length && listIds.length"></td>
                    </el-col>
                    <el-col :span="6">
                      <td>商品名称</td>
                    </el-col>
                    <el-col :span="6">
                      <td>商品价格</td>
                    </el-col>
                    <el-col :span="6">
                      <td>购买数量</td>
                    </el-col>
                    <el-col :span="2">
                      <td>操作</td>
                    </el-col>
                  </el-row>
                </tr>
              </thead>
              <tbody>
                <tr class="cbody" v-for="(item,index) in list" :key="index">
                  <el-row>
                    <el-col :span="3">
                      <td><input type="checkbox" name="boxs" :value="index" @click="checkedOne(item.id)"
                          :checked="listIds.indexOf(item.id)>=0"></td>
                    </el-col>
                    <el-col :span="6">
                      <td>{{ item.product_name | handleText}}</td>
                    </el-col>
                    <el-col :span="6">
                      <td>{{ item.price }}</td>
                    </el-col>
                    <el-col :span="6">
                      <td><button type="button" @click="sub(index)" :disabled="item.num===1">-</button>
                        {{ item.num  }}
                        <button type="button" @click="add(index)">+</button>
                      </td>
                    </el-col>
                    <el-col :span="2">
                      <td><button type="button" @click="remove(index)">删除</button></td>
                    </el-col>
                  </el-row>
                </tr>
              </tbody>
            </table>

            <div class="cfoot" style="padding-left: 40px;">共{{ total }}元！
              <button type="button" :disabled="listIds.length==0" @click="deleteAll">批量删除</button>
              <el-button style="margin-right: 80px;margin-left: 50px;" type="text" @click="dialogVisible = true">结算
              </el-button>
              <el-dialog title="表单弹框" :visible.sync="dialogVisible" width="30%">
                <el-form ref="form" :model="form" label-width="80px">
                  <el-form-item label="姓名">
                    <el-input v-model="consignee"></el-input>
                  </el-form-item>
                  <el-form-item label="备注">
                    <el-input v-model="guest_book"></el-input>
                  </el-form-item>
                  <el-form-item label="快递方式">
                    <el-radio v-model="dirstribution" label="顺丰" style="margin-right: 50px;">顺丰</el-radio>
                    <el-radio v-model="dirstribution" label="圆通" style="margin-right: 50px;">圆通</el-radio>
                    <el-radio v-model="dirstribution" label="中通" style="margin-right: 50px;">中通</el-radio>
                    <el-radio v-model="dirstribution" label="申通" style="margin-right: 50px;">申通</el-radio>
                    <el-radio v-model="dirstribution" label="韵达" style="margin-right: 50px;">韵达</el-radio>
                  </el-form-item>
                  <el-form-item label="地址">
                    <el-input v-model="address_id"></el-input>
                  </el-form-item>
                </el-form>
                <span slot="footer" class="dialog-footer">
                  <el-button @click="dialogVisible = false">取 消</el-button>
                  <el-button type="primary" @click="buy(),dialogVisible = false">去支付</el-button>
                </span>
              </el-dialog>
            </div>
          </div>
        </div>
      </div>
    </el-main>
  </div>
</template>

<script>
  export default {
    name: "hw1",
    filters: {
          handleText(value) {
               if (!value) return ''
               if (value.length > 25) {
                 return value.slice(0, 25) + '...'
               }
               return value
             }
        },
    data() {
      return {
        consignee: "",
        guest_book: "",
        dirstribution: "",
        address_id: "",
        num: "",
        total1: "",
        dialogVisible: false,
        form: {
          name: '',
          number: '',
        },
        //是否全选
        isCheckedAll: false,
        //存储选中的id数组
        listIds: [],
        //存储数据
        list: [],
        nums: []
      }
    },
    computed: {
      total: function() {
        var total = 0;
        //遍历listIds（存储选中id数组），在list查找id与 listIds的id相等数据，进行总价计算
        for (var i = 0; i < this.listIds.length; i++) {
          var n = this.listIds[i];
          var item = this.list.find((element) => (element.id == n));
          total += item.num * item.price;
        }
        return total
      }
    },
    created() {
      this.getCart()
    },
    methods: {
      open() {
        this.$prompt('请输入', '提示', {
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
            message: '取消输入'
          });
        });
      },
      checkedOne(listId) {
        let idIndex = this.listIds.indexOf(listId);
        if (idIndex >= 0) { //如果listIds中已经包含就去除
          this.listIds.splice(idIndex, 1);
        } else { //如果listIds中没有包含就添加
          this.listIds.push(listId);
        }
      },
      sub: function(index) {
        if (this.list[index].num === 0) return;
        this.list[index].num--;
        var id1 = this.list[index].id;
        this.$axios.get("http://localhost:8080/my_shop_user/cart/delete", {
          params: {
            id: id1
          }, //请求参数 JSON对象
          responseType: "json", //服务端返回的数据类型
          responseEncoding: "UTF-8" //服务端响应的数据编码格式
        }).then().catch(e => {
          console.log(e);
          alert(e);
        });
      },
      add: function(index) {
        this.list[index].num++;
        var id1 = this.list[index].id;
        this.$axios.get("http://localhost:8080/my_shop_user/cart/add", {
          params: {
            id: id1
          }, //请求参数 JSON对象
          responseType: "json", //服务端返回的数据类型
          responseEncoding: "UTF-8" //服务端响应的数据编码格式
        }).then().catch(e => {
          console.log(e);
          alert(e);
        });
      },
      remove: function(index) {
        this.listIds = [];
        var id1 = this.list[index].id;
        this.list.splice(index, 1);
        this.$axios.get("http://localhost:8080/my_shop_user/cart/remove", {
          params: {
            id: id1
          }, //请求参数 JSON对象
          responseType: "json", //服务端返回的数据类型
          responseEncoding: "UTF-8" //服务端响应的数据编码格式
        }).then().catch(e => {
          console.log(e);
          alert(e);
        });
      },
      allcheck: function(e) {
        console.log(e);
        this.isCheckedAll = e.target.checked;
        if (this.isCheckedAll) { //全选时
          this.listIds = [];
          this.list.forEach(item => {
            this.listIds.push(item.id);
          })
        } else {
          this.listIds = [];
        }
      },
      deleteAll: function() {
        this.list = this.list.filter(item => this.listIds.indexOf(item.id) === -1);
        this.$axios.get("http://localhost:8080/my_shop_user/cart/removeall", {
          params: {
            listIds: this.listIds.toString()
          }, //请求参数 JSON对象
          responseType: "json", //服务端返回的数据类型
          responseEncoding: "UTF-8" //服务端响应的数据编码格式
        }).then().catch(e => {
          console.log(e);
          alert(e);
        });
        this.listIds = [];
      },
      buy: function() {
        this.list = this.list.filter(item => this.listIds.indexOf(item.id) === -1);
        let params = this.$qs.stringify({
          consignee: this.consignee,
          guest_book: this.guest_book,
          distribution: this.dirstribution,
          address_id: this.address_id,
          gid: this.listIds.toString(),
        });
        this.$axios.post("http://localhost:8080/my_shop_user/submitOrder", params, {
          headers: {
            "Content-Type": "application/x-www-form-urlencoded"
          },
          responseType: "json", //服务端返回的数据类型
          responseEncoding: "UTF-8" //服务端响应的数据编码格式
        }).then(({
          value
        }) => {
          this.$message({
            type: 'success',
          });
        }).catch(e => {
          console.log(e);
          alert(e);
        });
       this.$router.push('list');
      },
      getCart: function() {
        this.$axios.get("http://localhost:8080/my_shop_user/cart", {
          responseType: "json", //服务端返回的数据类型
          responseEncoding: "UTF-8" //服务端响应的数据编码格式
        }).then(response => {
          this.list = response.data.cartAndPros;
        }).catch(e => {
          console.log(e);
          alert(e);
        });
      }
    }
  }
</script>

<style>
  .cbody {
    float: left;
    margin-left: -100px;
    background-color: #E9EBFE;
    width: 1100px;
    height: 50px;
    line-height: 40px;
  }

  .cfoot button {
    margin-right: 20px;
    margin-left: 70px;
  }

  .cfoot {
    margin-top: -30px;
    height: 50px;
    line-height: 50px;
    background-color: #FAF9DE;
    float: right;
  }

  .el-col {
    border-radius: 4px;
  }

  .chead {
    float: left;
    margin-top: -70px;
    margin-left: -100px;
    background-color: #DCE2F1;
    width: 1100px;
    height: 50px;
    line-height: 40px;
  }

  .block span {
    float: left;
  }

  .m-bread .block {
    font-size: 18px;
    text-decoration: none;
    padding: 100px 0 70px 0;
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
