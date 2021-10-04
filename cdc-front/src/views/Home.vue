<template>
    <v-layout justify-center :class="$vuetify.theme.dark == true ? 'backgroundDark' : 'backgroundLight'">
        <div id="global">
            <!-- Topbar -->
            <div id="topBar">
                <div id="titleBar">
                    <img class="logo" src="@/assets/logo_small_icon_only_inverted.png" />
                </div>
                <div id="navigation">
                    <v-layout align-center>
                        <div v-for="item in menu" :key="item.title">
                            <div class="navButton" :style="cssProps">
                                {{ item.title }}
                            </div>
                        </div>
                    </v-layout>
                </div>
            </div>
            <!-- Content -->
            <v-layout class="content" justify-center align-center>
                <div class="slogan">
                    <h1>Portalz</h1>
                    <h3>L'outil pour vous démarquer parmis les développeurs</h3>
                </div>
            </v-layout>
        </div>
    </v-layout>
</template>

<script>
export default {
    name: 'Home',
    data () {
        return {
            menu: [
                {title: "Connexion", route: ""},
                {title: "Inscription", route: ""},
                {title: "Contact", route: ""}
            ]
        }
    },
    computed: {
        cssProps () {
            return {
                '--primary-color': this.$vuetify.theme.currentTheme.primary,
                '--accent-color': this.$vuetify.theme.currentTheme.accent,
                '--sidebar-color': this.$vuetify.theme.currentTheme.sidebar,
            }
        },
    },
}
</script>

<style scoped>
#global {
    width: 1240px;
    height: 100%;
}
#topBar {
    display: inline-flex;
    max-height: 64px;
    margin: 1em 2em 1em 2em;
    width: 100%;
    border-width: 2px;
}
#titleBar {
    display: flex;
    flex-direction: row;
}
#navigation {
    display: flex;
    flex-direction: row-reverse;
    margin-left: auto;
    margin-right: 2em;
}
.backgroundLight {
    background-image: -webkit-radial-gradient(1px 100%, circle, #2a9d8f 0%, white 100%);
}
.backgroundDark {
    background-image: -webkit-radial-gradient(1px 100%, circle, orange 0%, black 100%);
}
.logo {
    object-fit: contain;
}
.navButton {
    padding: 16px;
    font-size: 1.2em;
    color: var(--accent-color);
    background-color: var(--sidebar-color);
}
.navButton:hover {
    cursor: pointer;
    color: var(--primary-color);
}
.content {
    height: 512px;
    font-size: 2em;
}
.slogan {
    display: flex;
    flex-direction: column;
    justify-content: center;
}
</style>