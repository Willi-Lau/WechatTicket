import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Enter from '../views/Enter.vue'
import Award from '../views/Award.vue'
import Ranke from '../views/Ranke.vue'
import Gift from '../views/Gift.vue'
import Ticket from '../views/Ticket.vue'


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/award',
    name: 'Award',
    component: Award
  },
  {
    path: '/enter',
    name: 'Enter',
    component: Enter
  },
  {
    path: '/ranke',
    name: 'Ranke',
    component: Ranke
  },
  {
    path: '/gift',
    name: 'Gift',
    component: Gift
  },
  {
    path: '/ticket',
    name: 'Ticket',
    component: Ticket
  }
]

const router = new VueRouter({
  routes
})

export default router
