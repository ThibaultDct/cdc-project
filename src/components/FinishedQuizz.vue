<template>
  <v-card
    elevation = "1"
    dense
    class="mail-content"
>
  <v-card-title> Veuillez entrer votre pseudo pour enregistrer votre score  </v-card-title>
  <v-card-text>
    <v-form
        ref="form"
        lazy-validation
    >
      <v-text-field
          v-model="pseudo"
          :counter="15"
          :rules="nameRules"
          label="Votre pseudo"
          required
      />

      <v-btn
          class="mr-4"
          @click="validate"
      >
        Valider et accéder au tableau des scores
      </v-btn>
    </v-form>

  </v-card-text>
</v-card>

</template>

<script>
import router from "../router";

export default {
  name: "Email",
  props: ['score'],

  data: () => ({
    pseudo: "",
    nameRules: [
      v => !!v || 'Un pseudo est requis',
      v => (v && v.length <= 15) || 'Votre pseudo doit faire moins de 15 caractères',
    ],

  }),
  methods: {
    postScore: function () {
      let userScore = {pseudo: this.pseudo, score: this.score};
      const apiUrl = "https://workshop.cloud.thibaultdct.fr";
      const scoreEndpoint = "/scores"

      this.axios
          .post(apiUrl + scoreEndpoint, userScore)
          .then(this.redirectToHighscores())
          .catch(err => {
            console.error(err);
            this.loading = false
            this.isError = true
          })

    },
    redirectToHighscores() {
      setTimeout(() => {router.push("/users");}, 100);
    },
    validate () {
      if (this.$refs.form.validate()){
        this.postScore();
      }
    },
  }
}
</script>

<style scoped>

</style>