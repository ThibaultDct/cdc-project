import Vue from 'vue'
import App from './App.vue'
import Trend from 'vuetrend'
import vuetify from '@/plugins/vuetify'
import Vuex from 'vuex'
import VueSidebarMenu from 'vue-sidebar-menu'
import VueApexCharts from 'vue-apexcharts'
import VuePipeline from 'vue-pipeline'
import VueAvatar from 'vue-avatar'
import axios from 'axios'
import VueAxios from 'vue-axios'
import { BreedingRhombusSpinner, TrinityRingsSpinner } from 'epic-spinners';
import VueSession from 'vue-session'
import router from './router/index'
import 'vue-sidebar-menu/dist/vue-sidebar-menu.css'

Vue.config.productionTip = false
Vue.use(Trend)
Vue.use(VueSidebarMenu)
Vue.use(VueApexCharts)
Vue.use(VuePipeline)
Vue.use(VueAvatar)
Vue.use(VueSession)
Vue.use(Vuex)
Vue.use(VueAxios, axios)

Vue.component('apexchart', VueApexCharts)
Vue.component('breeding-rhombus-spinner', BreedingRhombusSpinner)
Vue.component('trinity-rings-spinner', TrinityRingsSpinner)

new Vue({
  vuetify,
  router,
  render: h => h(App),
}).$mount('#app')
