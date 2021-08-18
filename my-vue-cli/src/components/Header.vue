<template>
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
</template>


<script>
	export default {
		name:'Header',
		data () {
		  return {
		    msg: 'Welcome to Your Vue.js App'
		  }
		},

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
