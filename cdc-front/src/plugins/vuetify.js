import Vue from 'vue';
import Vuetify from 'vuetify/lib/framework';

Vue.use(Vuetify);

const vuetify = new Vuetify({
    theme: {
        dark: false,
        themes: {
            light: {
                primary: '#e76f51',
                secondary: '#2a9d8f',
                accent: '#2a9d8f',
                success: '#00C853',
                warning: '#f4a261',
                error: '#e76f51',
                text: '#192230',
                sidebar: '#F5F3F4',
            },
            dark: {
                primary: '#f0efeb',
                secondary: '#264653',
                accent: '#e9c46a',
                success: '#00C853',
                warning: '#f4a261',
                error: '#e76f51',
                text: '#f0efeb',
                sidebar: '#1A1A1A',
            }
        }
    },
})

export default vuetify;
