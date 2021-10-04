<template>
  <v-container class="ml-5">
    <!-- Stack the columns on mobile by making one full-width and the other half-width -->
    <v-app-bar dense color="sidebar"><h2>Paramètres</h2></v-app-bar>
    <v-card
      elevation = "1"
      dense
    >
      <v-card-title>Apparence</v-card-title>
      <v-card-subtitle>Personnaliser l'apparence de votre interface</v-card-subtitle>
      <v-card-text>
        <v-switch
          v-model="$vuetify.theme.dark"
          label = "Mode sombre"
          color = "accent"
          class="ma-0"
        ></v-switch>
        <v-switch
          label = "Afficher les titres de page"
          color = "accent"
          class="ma-0"
        ></v-switch>
        <v-switch
          label = "Afficher les alertes de succès"
          color = "accent"
          class="ma-0"
        ></v-switch>
      </v-card-text>
    </v-card>
  </v-container>
</template>

<script>
  export default {
    name: 'Settings',

    data: () => ({
      width: 2,
      radius: 10,
      padding: 8,
      lineCap: 'round',
      gradient: [this.$vuetify.theme.currentTheme.accent],
      value: [0, 2, 5, 9, 5, 10, 3, 5, 0, 0, 1, 8, 2, 9, 0],
      gradientDirection: 'top',
      fill: false,
      type: 'trend',
      autoLineWidth: false,
    }),

    computed: {
      loadingColor() {
        return this.$vuetify.theme.currentTheme.accent
      }
    },
  }
</script>
