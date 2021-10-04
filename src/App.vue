<template>
  <v-app>
    <template v-if="sessionExists">
      <Sidebar/>
      <RouterContent/>
    </template>
    <template v-else>
      <Home/>
    </template>
    <Footer/>
  </v-app>
</template>

<script>
import Home from "@/views/Home";
import Sidebar from "@/components/Sidebar";
import RouterContent from "@/components/RouterContent";
import Footer from "@/components/Footer";

export default {
  name: "App",

  components: {Home, Footer, RouterContent, Sidebar},

  methods: {
    isOk: function () {
      return this.$session.exists();
    }
  },

  computed: {
    sessionExists() {
      console.log(this.$session.exists())
      return this.$session.exists();
    }
  },

};
</script>

<style>

.v-step > .label > .index {
  background-color: #2a9d8f !important;
}
.v-step.is-active > .label > .index {
  background-color: #00C853 !important;
}

.index {
  box-shadow: none !important;
  border: 1px solid black !important;
  color: unset !important;
}
</style>
