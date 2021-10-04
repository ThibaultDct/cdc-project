<template>
  <v-container>
        <HelloWorld/>
  </v-container>
</template>

<script>
import HelloWorld from "@/components/HelloWorld";

  export default {
    name: 'Dashboard',
    components: {
      HelloWorld
    },

    data: () => ({
      
    }),

  }
</script>
