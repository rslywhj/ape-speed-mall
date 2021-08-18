<template>
  <div id="bg">
    <!-- <div id="juzhong"> -->
    <div id="wenzi">
      <h1>欢迎使用</h1>
    </div>

    <div id="border">
      <div id="neirong">

        <h2>Ape-Speed</h2>
        <h3>没有账号？请<router-link to="/register">注册</router-link>
        </h3>

        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
          <el-form-item label="用户名:" prop="username">
            <el-input placeholder="请输入用户名" v-model="ruleForm.username" size="small"></el-input>
          </el-form-item><br />
          <el-form-item label="密码:" prop="password">
            <el-input placeholder="请输入密码" v-model="ruleForm.password" show-password size="small">
            </el-input>
          </el-form-item><br />
          <el-form-item label="记住密码" prop="remember">
            <el-switch v-model="ruleForm.remember" size="small"></el-switch>
          </el-form-item><br />
          <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')" size="small">登录</el-button>
            <el-button @click="resetForm('ruleForm')" size="small">取消</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>

    <!-- </div> -->
  </div>
</template>

<script>
  export default {
    name: "Login",
    data() {
      return {

        ruleForm: {
          username: "",
          password: "",
          remember: false
        },
        rules: {
          username: [{
              required: true,
              message: "请填写用户名",
              trigger: "blur"
            },
            {
              min: 2,
              max: 10,
              message: "长度2到10个字符",
              trigger: "blur"
            }
          ],
          password: [{
              required: true,
              message: "请填写密码",
              trigger: "blur"
            },
            {
              min: 5,
              max: 16,
              message: "长度5到16个字符",
              trigger: "blur"
            }
          ]
        }
      }
    },

    created() {
      this.getCookie()
    },

    methods: {
      // 设置cookie
      setCookie(name, pwd, exdays) {
        var exdate = new Date() // 获取时间
        exdate.setTime(exdate.getTime() + 24 * 60 * 60 * 1000 * exdays) // 保存的天数
        // 字符串拼接cookie
        window.document.cookie = 'userName' + '=' + name + ';path=/;expires=' + exdate.toGMTString()
        window.document.cookie = 'userPwd' + '=' + pwd + ';path=/;expires=' + exdate.toGMTString()
      },
      // 读取cookie 将用户名和密码回显到input框中
      getCookie() {
        if (document.cookie.length > 0) {
          var arr = document.cookie.split('; ') // 这里显示的格式需要切割一下自己可输出看下
          for (var i = 0; i < arr.length; i++) {
            var arr2 = arr[i].split('=') // 再次切割
            // 判断查找相对应的值
            if (arr2[0] == 'userName') {
              this.ruleForm.username = arr2[1]; //保存到保存数据的地方
            } else if (arr2[0] == 'userPwd') {
              this.ruleForm.password = arr2[1];
            }
          }
        }
        this.ruleForm.remember = true;
      },
      // 点击登录按钮的时候，判断是否勾选了自动登录（记住密码），对cookie做相应操作
      submitForm(formName) {

        //1、获取formName对应的Dom对象
        this.$refs[formName].validate((vaild) => {
          //valid表示验证是否通过 true表示通过
          if (vaild) {
            //组装数据参数
            const paramData = this.$qs.stringify({
              username: this.ruleForm.username,
              password: this.ruleForm.password,
              remember: this.ruleForm.remember,
            });

            //axios请求后台服务端登陆验证
            this.$axios.post("http://localhost:8080/my_shop_user/login", paramData, {
              headers: {
                "Content-Type": "application/x-www-form-urlencoded"
              },
              responseType: "json",
              responseEncoding: "utf-8"
            }).then((response) => {
              //根据服务端返回的数据判断登陆是否成功
              /* console.log(this.ruleForm.remember) */
              if (response.data) {
                if (this.ruleForm.remember) {
                  //记住密码
                  // 传入账号名，密码，和保存天数
                  this.setCookie(this.ruleForm.username, this.ruleForm.password, 7)
                } else {
                  // 如果没有选中自动登录，那就清除cookie
                  this.setCookie('', '', -1) // 修改2值都为空，天数为负1天就好了
                }
                alert("登陆成功")
                window.sessionStorage.username = this.ruleForm.username
                localStorage.setItem("user","ere");
                window.location.href = "/#/home"
              } else {
                alert("登陆失败，用户名或密码有误，请重新登录");
                window.location.href = "/#/login"
              }
            }).catch((e) => {
              alert(e);
            });


          } else {
            return false;
          }
        })
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }

    }
  }
</script>

<style>
  #border {
    float: right;
    position: relative;
    top: 15%;
    right: 5%;
    border: 3px seashell solid;
    border-radius: 10px;
    width: 400px;
    height: 400px;
    background-color: #F9FAFC;
    margin: auto;
  }

  #neirong {
    position: absolute;
    right: 50px;
    top: 30px;
  }

  #bg {
    position: absolute;
    top: 10%;
    bottom: 10%;
    background-color: deepskyblue;
    width: 100%;
  }

  #wenzi {
    float: left;
    position: absolute;
    top: 25%;
    left: 20%;
    text-align: center;
    width: 400px;
    height: 400px;
    font-size: 45px;
    color: white;
  }

  .el-form-item {
    width: 300px;
    float: right;
  }
</style>
