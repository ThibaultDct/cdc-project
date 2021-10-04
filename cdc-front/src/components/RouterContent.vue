<template>
  <!------------ CONTENT ------------>
  <v-main>
    <v-container class='m-2 mt-0 pt-0'>
      <v-row class="fill-height">
        <v-col>
          <transition name="fade">
            <router-view></router-view>
          </transition>
        </v-col>
      </v-row>
    </v-container>
  </v-main>
  <!--------------------------------->
</template>

<script>
export default {
  name: "RouterContent"
}
</script>

<style scoped>

</style>