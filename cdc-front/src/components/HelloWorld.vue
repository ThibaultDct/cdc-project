<template>
  <v-container>
    <v-row justify="center" align="center" style="margin-top: 5%;">
      <template v-if="!stepsCompleted">
        <Email :step="step" @clicked="onClickChoice"/>
      </template>
      <template v-else>
        <FinishedQuizz :score="score"/>
      </template>
    </v-row>
    <template>
      <v-row class="score">
        <v-card color="accent" dense width="50%">
          <v-card-title>
            Score : {{score}}
          </v-card-title>
        </v-card>
      </v-row>
    </template>
    <template>
      <v-row class="stepper" style="pointer-events: none">
        <v-stepper :steps="steps" v-model="step"></v-stepper>
      </v-row>
    </template>
  </v-container>
</template>

<script>
import { VStepper } from 'vue-stepper-component'
import Email from "./Email";
import FinishedQuizz from "./FinishedQuizz";

  export default {
    name: 'HelloWorld',
    
    components: {FinishedQuizz, Email, VStepper},

    data: () => ({
      steps: 10,
      step: undefined,
      stepsCompleted: false,
      score: 0,
      difficulty: 0,
    }),
    methods: {
      onClickChoice(isCorrect) {
        this.score = isCorrect ? this.score+1 : this.score;
        if (this.step < this.steps){
          this.step+=1;
        }else {
          this.stepsCompleted = true;
        }
      },
    }
  }
</script>

<style scoped>
  .mail-content {
    max-width: 50%;
  }

  .stepper {
    position: absolute;
    bottom: 10%;
    margin-left: 25%;
    margin-right: 25%;
    width: 50%;
  }
  .score {
    position: absolute;
    bottom: 10%;
    left: 5%;
    width: 40%;
  }
</style>
