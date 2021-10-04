<template>
  <v-navigation-drawer
      v-model="drawer"
      :mini-variant="mini"
      :expand-on-hover="expandOnHover"
      permanent
      class="m-0 p-0"
      absolute
      floating
      color="sidebar"
  >
    <v-list dense>
      <v-list-item
          v-for="item in items"
          :key="item.title"
          link
          @click="$router.push({ path: item.route })"
      >
        <v-list-item-icon>
          <v-icon class="mr-1">{{ item.icon }}</v-icon>
        </v-list-item-icon>

        <v-list-item-content>
          <v-list-item-title>{{ item.title }}</v-list-item-title>
        </v-list-item-content>
      </v-list-item>
    </v-list>
  </v-navigation-drawer>
</template>

<script>
export default {

  name: "Sidebar",

  data: () => ({
    drawer: true,
    items: [
      { title: "Jeu", icon: "mdi-controller-classic-outline", route: "/dashboard" },
      { title: "Meilleurs scores", icon: "mdi-trophy-outline", route: "/users" },
    ],
    mini: true,
    expandOnHover: true,
  }),
  methods: {
    logout() {
      this.$session.destroy()
      this.$router.push("/")
      this.$router.go()
    }
  },
};
</script>

<style scoped>

</style>