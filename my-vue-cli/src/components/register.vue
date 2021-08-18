<template>
	<div id="bg">
		<div id="wenzi">
			<h1>欢迎注册</h1>
		</div>

		<div id="border">
			<div id="neirong">
				<div id="wenzi2">
					<h2>Ape-Speed 猿速商城</h2>
					<h3>已有账号？请<router-link to="/login">登录</router-link>
					</h3>
					<router-view></router-view>
				</div>

				<el-form :model="ruleForm" :rules="rules" ref="ruleForm1" label-width="100px" class="demo-ruleForm">
					<el-form-item label="用户名" prop="username">
						<el-input placehoder="请输入用户名:" v-model="ruleForm.username" size="small"></el-input>
					</el-form-item>
					<el-form-item label="密码" prop="password">
						<el-input placehoder="请输入密码" v-model="ruleForm.password" show-password size="small"></el-input>
					</el-form-item>
					<el-form-item label="确认密码" prop="password1">
						<el-input placehoder="请与第一次输入的密码一致" v-model="ruleForm.password1" show-password size="small">
						</el-input>
					</el-form-item>
					<el-form-item>
						<el-button type="primary" @click="submitForm('ruleForm1')" size="small">注册</el-button>
						<el-button @click="resetForm('ruleForm1')" size="small">重置</el-button>
					</el-form-item>
				</el-form>

			</div>
		</div>
	</div>
</template>

<script>
	export default {
		name: "register",
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
			return {
				ruleForm: {
					username: "",
					password: "",
					password1: ""
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
					],
					password1: [{
							validator: validatePass2,

							trigger: "blur"
						},
						{
							min: 5,
							max: 10,
							message: "请与第一次密码一致",
							trigger: "blur",

						}
					]
				}
			}
		},

		methods: {
			submitForm(formName) {
				//1.获取forName对应的Dom对象
				this.$refs[formName].validate((vaild) => {
					//
					if (vaild) {
						//
						const paramData = this.$qs.stringify({
							username: this.ruleForm.username,
							password: this.ruleForm.password,

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
			resetForm(formName) {
				this.$refs[formName].resetFields();
			}
		}
	}
</script>

<style>
	#border {
		float: right;
		position: absolute;
		top: 15%;
		right: 150px;
		border: 5px seashell solid;
		border-radius: 10px;
		width: 400px;
		height: 400px;
		background-color: #F9FAFC;
		margin: auto;
	}

	#neirong {
		position: absolute;
		left: 10px;
		right: 60px;
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

	#wenzi2 {
		weight: 300px;
		left: 50px;
	}

	.el-form-item {
		width: 300px;
		float: right;
	}
</style>
