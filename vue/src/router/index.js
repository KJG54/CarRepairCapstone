                            import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import Customer from '../views/Customer.vue'
import Employee from '../views/Employee.vue'
import Admin from '../views/Admin.vue'
import RequestService from '../views/RequestService.vue'

import AddCar from '../views/AddCar.vue'
import CompletedOrders from '../views/CompletedOrders.vue'

import RequestService2 from '../views/RequestService2.vue'
import CarServices from '../views/CarServices.vue'


Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/user/:id",
      name: "user",
      component: Customer,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/employee/:id",
      name: "employee",
      component: Employee,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/admin/:id",
      name: "admin",
      component: Admin,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/requestService',
      name: 'requestService',
      component: RequestService,
      meta: {
        requiresAuth: true
      }
    },
    {

      path: '/user/:id/addCar',
      name: 'addCar',
      component: AddCar,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/completedorders",
      name: "completedOrders",
      component: CompletedOrders,
      meta: {
        requiresAuth: true
      }
    },
    {

      path: '/requestService2',
      name: 'requestService2',
      component: RequestService2,
      meta: {
        requiresAuth: true
     }
    },
    {

      path: '/carServices/:id',
      name: 'carServices',
      component: CarServices,
      meta: {
        requiresAuth: true
      }
    }
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
