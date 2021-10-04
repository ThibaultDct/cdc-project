<template>
  <v-card
      elevation = "1"
      dense
      class="mail-content"
  >
    <v-card-title v-if="emailTitle"> {{ emailTitle }}</v-card-title>
    <v-card-title v-else> Email n°{{step}} </v-card-title>
    <v-card-subtitle>{{ emailDescription }}</v-card-subtitle>
    <v-card-subtitle style="margin-top: -2%"> <strong> From : </strong> {{from}} </v-card-subtitle>
    <v-card-subtitle style="margin-top: -2%"> <strong> To : </strong> {{to}} </v-card-subtitle>
    <v-card-subtitle style="margin-top: -2%"> <strong> Objet : </strong> {{objet}} </v-card-subtitle>
    <v-card-text>
      <v-card>
        <v-card-text>
          {{ mainBodyText }}
        </v-card-text>
      </v-card>
    </v-card-text>
    <v-card-actions>
      <v-row justify="center">
        <v-btn
            class="ma-2"
            large
            color="success"
            @click="legitClick"
        >
          <v-icon dark>
            mdi-check-circle-outline
          </v-icon>
          Mail légitime
        </v-btn>
        <v-btn
            class="ma-2"
            large
            color="error"
            @click="suspectClick"
        >
          <v-icon dark>
            mdi-close-circle-outline
          </v-icon>
          Mail suspect
        </v-btn>
      </v-row>
    </v-card-actions>
  </v-card>
</template>

<script>

const apiUrl = "https://workshop.cloud.thibaultdct.fr"
const scoreEndpoint = "/emails"

export default {
  name: "Email",
  props: ['step'],

  data: () => ({
    from: "no-reply@lild.com",
    to: "you@mail.com",
    objet: "Fèlicitation",
    mainBodyText: "Bravo !!! Vous êtes l'heureux gagnant de notre jeu suprise ! Dépêchez vous de vous rendre sur ce *lien* pour réclamer votre prix avant qu'il ne disparaisse !!",
    emailDescription: "",
    emailTitle: "Grand gagnant d'un coucours de Lidl ?",
    isLegit: false,
    emails: null,

  }),
  methods: {
    loadMailsList: function () {
      this.emails = null
      this.loading = true
      this.isError = false
      this.searchTerm = ""
      this.axios
          .get(apiUrl + scoreEndpoint)
          .then(res => {
            console.log(res)
            this.loading = false
          })
          .catch(err => {
            console.error(err);
            this.loading = false
            this.isError = true
          })
    },
    legitClick() {
      this.$emit('clicked', this.isLegit === true)
    },
    suspectClick() {
      this.$emit('clicked', this.isLegit === false)
    },
  },
  mounted() {
    //this.loadMailsList();
  },
}
</script>

<style scoped>

</style>