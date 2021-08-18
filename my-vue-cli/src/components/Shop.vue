<template>
  <div id="quanju">
  <el-container>
    <el-header>
  <div id="wenzi9">
        <h3>
          <router-link to="/login">登录</router-link>
          <router-link to="/register">注册</router-link>
           <router-link to="/register">购物车</router-link>
        </h3>
      </div>
    </el-header>
  </el-container>

  <el-container>
    <el-aside width="200px">
      <h3>
        <router-link to="/login">水果蔬菜</router-link>
        </h3>
        <h3>
        <router-link to="/register">衣服</router-link>
        </h3>
        <h3>
         <router-link to="/register">鞋包</router-link>
       </h3>
    </el-aside>
    <el-main>
      <div class="block">
        <el-carousel height="450px">
          <el-carousel-item v-for="item in imagebox" :key="item.id">
           <img :src="item.idView" class="image">
          </el-carousel-item>
        </el-carousel>
      </div>
    </el-main>
  </el-container>

  <el-container>
    <el-header>Header</el-header>
    <el-main>Main</el-main>
    <el-footer>Footer</el-footer>
  </el-container>

  <el-container>
    <el-aside width="200px">Aside</el-aside>
    <el-main>Main</el-main>
  </el-container>

  <el-container>
    <el-header>Header</el-header>
    <el-container>
      <el-aside width="200px">Aside</el-aside>
      <el-main>Main</el-main>
    </el-container>
  </el-container>

  <el-container>
    <el-header>Header</el-header>
    <el-container>
      <el-aside width="200px">Aside</el-aside>
      <el-container>
        <el-main>Main</el-main>
        <el-footer>Footer</el-footer>
      </el-container>
    </el-container>
  </el-container>

  <el-container>
    <el-aside width="200px">Aside</el-aside>
    <el-container>
      <el-header>Header</el-header>
      <el-main>Main</el-main>
    </el-container>
  </el-container>

  <el-container>
    <el-aside width="200px">Aside</el-aside>
    <el-container>
      <el-header>Header</el-header>
      <el-main>Main</el-main>
      <el-footer>Footer</el-footer>
    </el-container>
  </el-container> 




  </div>
</template>

<script>
  export default{
    name:"Shop",
    data(){
      return{
        imagebox:[{id:0,idView:require('../assets/图片1.jpg')},
        {id:1,idView:require('../assets/图片2.jpg')},
        {id:2,idView:require('../assets/图片2.jpg')},
        {id:3,idView:require('../assets/图片4.jpg')},
        ]
      }
    }

  }

</script>

<style>
  .el-carousel__item h3 {
    color: #ffffff;
    font-size: 14px;
    opacity: 0.75;
    line-height: 150px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
     background-color: #ffffff;
  }

  .el-carousel__item:nth-child(2n+1) {
     background-color: #ffffff;
  }

    .el-header, .el-footer {
      background-color: #aaaa7f;
      color: #333;
      text-align: center;
      line-height: 60px;
    }

    .el-aside {
      background-color: #ffffff;
      color: #333;
      text-align: center;
      line-height: 150px;
    }

    .el-main {
      background-color: #ffffff;
      color: #333;
      text-align: center;
      line-height: 160px;
    }

    body > .el-container {
      margin-bottom: 40px;
    }

    .el-container:nth-child(5) .el-aside,
    .el-container:nth-child(6) .el-aside {
      line-height: 260px;
    }

    .el-container:nth-child(7) .el-aside {
      line-height: 320px;
    }
  #wenzi9{
    position: absolute;
    left: 10px;
    right: 60px;
    top: 30px;
  }

</style>
