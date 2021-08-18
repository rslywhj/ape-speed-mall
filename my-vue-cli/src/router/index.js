import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Demo from "@/components/Demo"
import Login from "@/components/Login"
import Register from "@/components/register"
import Header from "@/components/Header"
import Footer from "@/components/Footer"
import Main from "@/components/Main"
import TestHeader from "@/components/TestHeader"
import Home from "@/components/Home"
import P10001 from "@/components/P10001"
import P10002 from "@/components/P10002"
import Shop from "@/components/Shop"
import UserCenterMain from "@/components/UserCenterMain"
import UserCenter from "@/components/UserCenter"
import CartMain from "@/components/CartMain"
import Cart from "@/components/Cart"
import ErMain from "@/components/ErMain"
import Er from "@/components/Er"
import ListMain from "@/components/ListMain"
import List from "@/components/List"
import LoginOut from "@/components/login_out"
import Test from "@/components/test"
import Good from "@/components/Good"



Vue.use(Router)

export default new Router({
  routes: [{
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/demo',
      name: "Demo",
      component: Demo
    },
    {
      path: '/login',
      name: "Login",
      component: Login
    },
    {
      path: '/register',
      name: "Register",
      component: Register
    },
    {
      path: '/header',
      name: "Header",
      component: Header
    },
    {
      path: '/footer',
      name: "Footer",
      component: Footer
    },
    {
      path: '/main',
      name: "Main",
      component: Main
    },
    {
      path: '/home',
      name: "Home",
      component: Home
    },
    {
      path: '/testHeader',
      name: "TestHeader",
      component: TestHeader
    },
    {
      path: '/p10001',
      name: 'P10001',
      component: P10001,
      meta: {
        needLogin: true
      }
    },
    {
      path: '/p10002',
      name: 'P10002',
      component: P10002,
      meta: {
        needLogin: true
      }
    },
    {
      path: '/shop',
      name: 'Shop',
      component: Shop
    },
    {
      path: '/usercentermain',
      name: 'UserCenterMain',
      component: UserCenterMain
    },
    {
      path: '/usercenter',
      name: 'UserCenter',
      component: UserCenter
    },
    {
      path: '/cartMain',
      name: 'CartMain',
      component: CartMain
    },
    {
      path: '/erMain',
      name: 'ErMain',
      component: ErMain
    },
    {
      path: '/er',
      name: 'Er',
      component: Er
    },
    {
      path: '/cart',
      name: 'Cart',
      component: Cart,
      meta: {
        needLogin: true
      }
    },
    {
      path: '/listMain',
      name: 'ListMain',
      component: ListMain
    },
    {
      path: '/list',
      name: 'List',
      component: List
    },
    {
      path: '/login_out',
      name: "Login_out",
      component: LoginOut
    },
    {
      path: '/p:gid',
      name: 'Good',
      component: Good,
      meta: {
        needLogin: true
      }
    },
    {
      path: '/test',
      name: 'Test',
      component: Test
    },
  ]
})
