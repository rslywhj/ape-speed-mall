<!-- <template>
  <div>
    <el-main>
      <div>
        <div class="g-bd" style="margin-top: 100px;border:3px #E9EBFE solid">
          <el-breadcrumb separator="/" style="margin: -20px 0px 10px 0px;">
            <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>用户中心</el-breadcrumb-item>
          </el-breadcrumb>
          <div class="g-sd">
            <h2 class="msg">用户中心</h2>
            <ul id="tab-box" class="n-msgtab f-cb">
              <li class="j-iflag">
                <el-card shadow="always" style="background-color: #FFF2E2;">我的</el-card>
              </li>
              <li class="j-iflag">
                <a href="http://localhost:8081/#/cart"><span>我的购物车</span></a>
              </li>
              <li class="j-iflag">
                <a href="#"><span>退出登录</span></a>
              </li>
            </ul>
            <el-button round style="margin-top: 20px;">一键已读</el-button>
          </div>
          <div class="g-mn">
            <div class="g-mnc">
              <div class="g-wrap">
                <h3 class="v-hd"><span class=" tit">猿速商城</span></h3>
                <div class="fm">
                  <form>
                    <el-upload
                      action="https://jsonplaceholder.typicode.com/posts/"
                      list-type="picture-card"
                      :on-preview="handlePictureCardPreview"
                      :on-remove="handleRemove">
                      <i class="el-icon-plus"></i>
                    </el-upload>
                    <el-dialog :visible.sync="dialogVisible">
                      <img width="100%" :src="dialogImageUrl" alt="">
                    </el-dialog>
                    请输入真实姓名：<input type="text" name="username" /><br />
                    请输入电话号码：<input type="text" name="tel"/><br />
                    请输入真是邮箱：<input type="text" name="e_mail"/><br />
                    是否修改密码：<input type="radio" value="是">是</input><input type="radio" value="否" />否</input<br />
                  </form>
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
    name: 'usercentermain',
     data() {
          return {
            dialogImageUrl: '',
            dialogVisible: false,
            username:"",
            tel:"",
            e_mail:""
          }
        },
        methods:
          submitForm(formName) {
          	//1.获取forName对应的Dom对象
          	this.$refs[formName].validate((vaild) => {
          		//
          		if (vaild) {
          			//
          			const paramData = this.$qs.stringify({
          				username: this.username,
          				password: this.

          			});
          			//
          			this.$axios.post("http://localhost:8080/my_shop_user/register", paramData, {
          				headers: {
          					"Content-type": "application/x-www-form-urlencoded"
          				},
          				responseType: "json",
          				responseEncoding: "utf-8"
          			}).then((response) => {
          				console.log(response.data)
          			if (response.data) {
          				alert("注册成功")
          				window.location.href = "/#/login"
          			} else {
          				alert("已有账户，请登录");
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

          handleRemove(file, fileList) {
            console.log(file, fileList);
          },
          handlePictureCardPreview(file) {
            this.dialogImageUrl = file.url;
            this.dialogVisible = true;
          }
        }
  }
  data() {
  	var validatePass2 = (rule, password1, callback) => {
  		if (password1 === '') {
  			callback(new Error('请再次输入密码'));
  		} else if (password1 !== this.ruleForm.password) {
  			callback(new Error('两次输入密码不一致!'));
  		} else {
  			callback();
  		}
  	};
  	}
</script>

<style>
  .btn_anniu {
    color: rgb(51, 122, 183);
    float: right;
    width: 14px;
    border-bottom: 1px solid #ddd;
    list-style: none;
    display: block;
    width: 185px;
    height: 53px;
    padding-left: 0px;
    background: #f7f7f7;
    border: 1px solid #fff;
    line-height: 53px;
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

  .n-msgtab li {
    float: right;
    width: 184px;
    border-bottom: 1px solid #ddd;
    list-style: none;
  }

  .n-msgtab li a {
    display: block;
    width: 144px;
    height: 53px;
    padding-left: 40px;
    background: #f7f7f7;
    border-top: 1px solid #fff;
    line-height: 53px;
  }

  .j-iflag span {
    margin-left: -40px;
  }
</style>
 -->
