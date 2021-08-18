<template>

  <router-link :to="{name: 'Good', params: { gid: 10036 }}">前往Detail页面</router-link>

</template>

<script>
  export default {
    name: "test",
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
      this.getTest()
    },
    methods: {
      getTest: function() {
        let params ={

        }
        this.$axios.get("http://localhost:8080/my_shop_admin/productServlet", {
          headers: {
            "Content-Type": "application/x-www-form-urlencoded"
          },
          params: {
            draw: 1,
            start: 0,
            length: 10,
            pstatus: 1
          },
          responseType: "json", //服务端返回的数据类型
          responseEncoding: "UTF-8" //服务端响应的数据编码格式
        }).then(response => {
          this.list = response.data.cartAndPros;
          console.log(this.list)
        }).catch(e => {
          console.log(e);
          alert(e);
        });
      },
    }
  }
</script>

<style>
</style>
