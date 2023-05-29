<template>
<div class="cars">
  <div
    class="car"
    v-for="car in cars"
    v-bind:key="car.carId"
  >
      <p
        class="car-accordion"
        :class="{ 'car-selected': carsClicked.includes(car.carId)}"
        v-on:click="onCarClick(car.carId)"
      >{{ getCarTitle(car) }}</p>
      <details-service
        class="slidePanel"
        v-bind:carId=car.carId
        v-show="carsClicked.includes(car.carId)"
      />
  </div>
</div>
</template>

<script>
import DetailsService from './DetailsService.vue';
import UserService from '@/services/UserService.js'

export default {
  components: { DetailsService },
    name: 'emp-details-car',
    props: ['user'],
    data(){
        return {
            carsClicked: [],
            cars: []
        }
    },
    methods: {
        onCarClick(carId){
            if(this.carsClicked.includes(carId)){
                this.carsClicked = this.carsClicked.filter( (eachCarId) => {
                    return eachCarId != carId;
                });
            } else {
                this.carsClicked.push(carId);
            }
        },
        getCarTitle(car){
            return `${car.year} ${car.color} ${car.make} ${car.model}`
        }
    },
    created(){
        UserService.getCarsByUser(this.user.id).then((response) => {
            this.cars = response.data;
        });
    }
}
</script>

<style>
.cars {
  border-top: 3px solid black;
}

.car {
  box-sizing: border-box;
  cursor: pointer;
  padding: 5px;
  width: 100%;
  border-bottom: 1px solid lightgray;
  outline: none;
  text-align: left;
  transition: 0.4s;
}

.car:last-child{
    border-bottom: none;
}

.car:hover {
  background-color: #ccc;
}

.user .car > p {
  margin: 5px;
}

.car-accordion:after {
  content: '\02795'; /* Unicode character for "plus" sign (+) */
  font-size: 13px;
  color: #777;
  float: right;
  margin-left: 5px;
}

.car-selected:after {
  content: "\2796"; /* Unicode character for "minus" sign (-) */
}

.slidePanel {
  padding: 0 18px;
  background-color: white;
  overflow: hidden; 
}

</style>