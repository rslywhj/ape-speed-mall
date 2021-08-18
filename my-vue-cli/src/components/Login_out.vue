<template>
  <div>
  </div>
</template>

<script>
  export default {
    name: "Login_out",
    data() {},

    created() {
      this.login_out()
    },

    methods: {
      login_out() {
        //axios请求后台服务端
        this.$axios.post("http://localhost:8080/my_shop_user/login_out", {
          headers: {
            "Content-Type": "application/x-www-form-urlencoded"
          },
          responseType: "text",
          responseEncoding: "utf-8"
        }).then((response) => {
               window.sessionStorage.username = undefined
                localStorage.removeItem('user')
              this.$router.push({path:'/home'})
            }).catch((e) => {
              alert(e);
            });
        }
      }
    }
</script>

<style>
</style>
