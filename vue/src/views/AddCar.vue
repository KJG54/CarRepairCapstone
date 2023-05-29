<template>
  <div>
    <form class="add-car" v-on:submit.prevent="saveCar">
        <input class="make-input" type="text" placeholder="Make" v-model="car.make" />
        <input class="model-input" type="text" placeholder="Model" v-model="car.model" />
        <input class="year-input" type="text" placeholder="Year" v-model="car.year" />
        <input class="color-input" type="text" placeholder="Color" v-model="car.color" />
        <button type="submit">Add Car</button>
    </form>

  </div>
</template>

<script>
export default {
     name: "add-car",
    data() {
        return {
            car: {
                make: '',
                model: '',
                year: '',
                color: '',
                type: ''
            }
        }
    },
    methods: {
        saveCar() {
         this.$store.commit('SAVE_CAR', this.car);
            this.car = {
                make: '',
                model: '',
                year: '',
                color: '',
                type: ''
            };
            this.$router.push("/user/:id/requestService");
        }
    }

}
</script>

<style>

</style>