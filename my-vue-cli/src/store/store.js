import Vue from 'vue'
import Vuex from 'vuex'
import createPersistedState from 'vuex-persistedstate'


Vue.use(Vuex)

export default new Vuex.Store({
  //用来存储数据对象
  state: {
    //定义一个count属性
    count: 2,
  },
  plugins: [
    //持久化state
    createPersistedState({
      //指定存储位置（默认位置是localstorage）
      //sessionStorage 表示会话存储 当浏览器关闭后存储就消失了
      //localStorage 表示本地存储 当浏览器关闭后存储不消失，再次打开网站数据会恢复
      storage:window.sessionStorage,
      //指定需要缓存的状态属性
      reducer(val) {
        return {
          count: val.count
        }
      }
    })
  ],
  //简单理解是store的计算属性
  getters: {
    //state表示存储的数据对象，getters代表其他定义的getters
    getCount(state, getters) {
      //通过复杂计算
      return state.count;
    },
  },
  //定义事件类型（实际上是函数）
  mutations: {
    //定义addCount的事件类型
    addCount(state, num) {
      //state存储数据的对象
      state.count = state.count + num;
    },
    //定义subCount的事件类型
    subCount(state, num) {
      if (state.count > 0) {
        state.count = state.count - num;
      } else {
        state.count = 0;
      }
    }
  },
  actions: {
    myAddCount(context, num) {
      //context是vue的实例对象 可以使用context.commit("addCount",num)提交触发mutations定义事件类型（函数）
      setTimeout(() => {
        context.commit("addCount", num);
      }, 2000)
    },
    mySubCount(context, num) {
      setTimeout(() => {
        context.commit("subCount", num);
      }, 2000)
    }
  }
})
