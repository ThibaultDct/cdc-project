<template>
    <v-container class="ml-5">
        <v-app-bar dense color="sidebar"><h2>Meilleurs scores</h2></v-app-bar>
        <!-- LOADING ANIMATION -->
        <div v-if="loading == true">
            <v-progress-circular indeterminate size="64" color="accent"></v-progress-circular>
        </div>
        <!-- ERROR MESSAGE -->
        <div v-if="loading == false && isError == true">
            <v-alert
                dense
                border="left"
                type="error"
            >
                Oops ! Une erreur est survenue lors du chargement des scores.
                <v-btn color="warning" class="d-flex justify-end" v-on:click="loadScoreList">Réessayer</v-btn>
            </v-alert>
        </div>
        <!-- USERS LIST -->
        <div v-if="loading == false && isError == false">
            <v-alert
                dense
                border="left"
                type="success"
                dismissible
            >
                {{getScoresListSize}} score(s) récupéré(s)
            </v-alert>
            <v-list elevation="1">
                <v-layout class="d-flex">
                    <v-btn class="ma-2" color="accent" v-on:click="loadScoreList"><v-icon>mdi-reload</v-icon></v-btn>
                    <v-spacer/><v-spacer/><v-spacer/><v-text-field class="ma-2 justify-end" rounded filled dense placeholder="Recherche" v-model="searchTerm"></v-text-field>
                </v-layout>
                <v-list-item-group>
                  <v-list-item>
                    <v-list-item-content>
                      <v-list-item-title> <strong> Pseudo </strong></v-list-item-title>
                    </v-list-item-content>
                    <v-list-item-content>
                      <v-list-item-title><strong> Score </strong></v-list-item-title>
                    </v-list-item-content>
                  </v-list-item>
                    <v-list-item
                        v-for="score in scores"
                        :key="score.pseudo"
                    >
                        <v-list-item-avatar>
                            <v-avatar>
                                <Avatar :username=score.pseudo></Avatar>
                            </v-avatar>
                        </v-list-item-avatar>

                        <v-list-item-content>
                          <v-list-item-title v-text="score.pseudo" :text-color='hover ? "primary" : "secondary"'></v-list-item-title>
                        </v-list-item-content>
                        <v-list-item-content>
                          <v-list-item-title v-text="score.score" :text-color='hover ? "primary" : "secondary"'></v-list-item-title>
                        </v-list-item-content>

                      <v-list-item-icon>
                        <v-icon>
                          mdi-trophy-outline
                        </v-icon>
                      </v-list-item-icon>
                    </v-list-item>
                </v-list-item-group>
                <v-subheader>
                    Total : {{getScoresListSize}}
                </v-subheader>
            </v-list>
        </div>
    </v-container>
</template>

<script>
import Avatar from "vue-avatar"

const apiUrl = "https://workshop.cloud.thibaultdct.fr"
const scoreEndpoint = "/scores"

export default {
    name: "ScoreList",
    components: {Avatar},

    data() {
        return {
            overlay: true,
            loading: true,
            isError: false,
            scores: null,
            searchTerm: "",
        }
    },

    methods: {
        loadScoreList: function () {
            this.scores = null
            this.loading = true
            this.isError = false
            this.searchTerm = ""
            this.axios
                .get(apiUrl + scoreEndpoint)
                .then(res => {
                    console.log(res)
                    this.scores = this.sortScores(res.data.scores)
                    this.loading = false
                })
                .catch(err => {
                    console.error(err); 
                    this.loading = false
                    this.isError = true
                })
        },
        sortScores: function (score) {
            return score.sort(function(a, b) {
                return a.score < b.score
            })
        },
    },
    
    mounted() {
        this.loadScoreList();
    },

    computed: {
        getScoresListSize () {
            return this.scores.length
        },
    },

}
</script>
<style>
</style>