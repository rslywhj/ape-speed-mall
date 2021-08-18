// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
//导入qs的js库
import qs from 'qs'
//导入axios的js库
import axios from 'axios'
import ElementUI from 'element-ui'
//导入ui组件的css文件
import 'element-ui/lib/theme-chalk/index.css'
import store from './store/store'



Vue.config.productionTip = false
//带上cookie
axios.defaults.withCredentials=true;

//声明插件安装
Vue.use(ElementUI)
//给Vue构造函数原型链上设置$qs,$axios对应的axios和qs对象

Vue.prototype.$qs=qs;
Vue.prototype.$axios=axios;

/* Vue.use(axios)
Vue.use(qs) */

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,    //store对象传入到vue实例中，这样vue实例中的所有组件都可以访问store存储的数据
  components: { App,qs,axios},     //局部组件中加入qs和axios
  template: '<App/>'
})
router.beforeEach((to, from, next) => {

  if (to.meta.needLogin) { // 判断该路由是否需要登录权限
    if(localStorage.getItem('user')){ //判断本地是否存在access_token
      next();
    }else {
     if(to.path === '#/login'){
        next();
      }else {
        next({
          path:'/login'
        })
      }
    }
  }
  else {
    next();
  }
  /*如果本地 存在 token 则 不允许直接跳转到 登录页面*/
  if(to.fullPath == "/login"){
    if(localStorage.getItem('user')){
      next({
        path:from.fullPath
      });
    }else {
      next();
    }
  }
});
