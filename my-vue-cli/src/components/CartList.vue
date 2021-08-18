<template>
  <div>
    <div class="top_headers" data-v-c67265cc="">
      <div class="header_container" data-v-c67265cc="">
        <div class="logo" data-v-c67265cc="">
          <a href="#/home">
            <img data-v-c67265cc="" src="../../static/img/logo.png" />
          </a>
        </div>
        <div class="top_header_container" data-v-c67265cc="">
          <div class="top_item" data-v-c67265cc="">英雄数据</div>
          <div class="top_item" data-v-c67265cc="">排行榜</div>
          <div class="top_item" data-v-c67265cc="">职业选手</div>
          <div class="top_item active" data-v-c67265cc=""> 职业选手视角观战</div>
        </div>
        <div class="search_container" data-v-c67265cc="">
          <div class="search_box" data-v-c67265cc="">
            <i class="el-icon-search"></i>
            <input placeholder="请输入搜索内容" type="text" value="" data-v-c67265cc=""></div>
          <!---->
        </div>
      </div>

    </div>

    <!-- <input type="button" value="获取购物车" @click="getCart" /> -->
    <table style="text-align:center; margin: 100px;" >
      <thead style="background-color: #7A8B8B">
      <tr>
        <td><input id="allcheck" type="checkbox" @click="allcheck"
                   :checked="list.length===listIds.length && listIds.length"></td>
        <td>商品名称</td>
        <td>商品价格</td>
        <td>购买数量</td>
        <td>操作</td>
      </tr>
      </thead>
      <tbody>
      <tr v-for="(item,index) in list" :key="index">
        <td><input type="checkbox" name="boxs" :value="index" @click="checkedOne(item.id)"
                   :checked="listIds.indexOf(item.id)>=0"></td>
        <td>{{ item.name }}</td>
        <td>{{ item.price }}</td>
        <td><button type="button" @click="sub(index)" :disabled="item.num===1">-</button>
          {{ item.num }}
          <button type="button" @click="add(index)">+</button>
        </td>
        <td><button type="button" @click="remove(index)">删除</button></td>
      </tr>
      </tbody>
    </table>

    <div>共{{ total }}元！
      <button type="button" :disabled="listIds.length==0" @click="deleteAll">批量删除</button>
    </div>
  </div>
</template>

<script>

  export default {
    name: "hw1",
    data() {
      return{
        //是否全选
        isCheckedAll: false,
        //存储选中的id数组
        listIds:[],
        //存储数据
        list:[]
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
      getCart: function() {
        this.$axios.get("http://localhost:8080/my_shop_user/cart/list", {
          params: {}, //请求参数 JSON对象
          responseType: "json", //服务端返回的数据类型
          responseEncoding: "UTF-8" //服务端响应的数据编码格式
        }).then(response => {
          this.list = response.data.cartAndPros; //数值赋值给data对象的students属性
        }).catch(e => {
          console.log(e);
          alert(e);
        });
      }
    }
  }
</script>

<style>
  .top_headers[data-v-c67265cc] {
    width: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    box-shadow: 0 -2px 10px 5px hsl(0deg 0% 39% / 30%);
    position: fixed;
    top: 0;
    left: 0;
    z-index: 100;
    background-color:#F9FAFC;
  }
  .top_headers .header_container[data-v-c67265cc] {
    width: 1200px;
    display: flex;
    align-items: center;
  }
  .top_headers .top_header_container[data-v-c67265cc] {
    display: flex;
    justify-content: center;
    align-items: center;
  }
  .top_headers .search_container[data-v-c67265cc] {
    text-align: left;
    width: 280px;
    height: 40px;
    border: 1px solid #ebedf2;
    line-height: 38px;
    border-radius: 20px;
    margin-left: 100px;
    position: relative;
  }
  .top_headers .search_container .search_box[data-v-c67265cc] {
    padding-left: 20px;
    position: relative;
    display: flex;
    align-items: center;

  }
  .top_headers .top_header_container .top_item[data-v-c67265cc] {
    line-height: 70px;
    padding: 0 20px;
    cursor: pointer;
  }
  .top_headers .logo[data-v-c67265cc] {
    margin-right: 200px;
  }
  .top_headers .search_container .search_box input[data-v-c67265cc] {
    line-height: 38px;
    text-align: left;
    border:none;
    background-color:#F9FAFC;
  }

  i {
    width: 20px;
    height: 20px;
    margin-right: 10px;
    margin-top: 5px;
  }
</style>

