import Vue from 'vue';
import Dashboard from "@/views/Dashboard";
import Settings from "@/views/Settings";
import VueRouter from "vue-router";
import UsersList from "@/views/UsersList";

Vue.use(VueRouter)

const router = new VueRouter({
    routes: [{
            path: '/dashboard',
            name: 'dashboard',
            component: Dashboard
        },
        {
            path: '/settings',
            name: 'settings',
            component: Settings
        },
        {
            path: '/users',
            name: 'users',
            component: UsersList
        },
    ]
})

const DEFAULT_TITLE = 'Portalz';
router.afterEach((to) => {
    Vue.nextTick(() => {
        document.title = to.meta.title || DEFAULT_TITLE;
    });
});

export default router;