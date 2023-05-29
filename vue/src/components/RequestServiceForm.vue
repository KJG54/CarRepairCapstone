<template>
  <div>
    <form class="request-service-form" v-on:submit.prevent="saveService">
      <!-- need a v-model in select that selects the right car -->
      <!-- <select >
        <option value="">--- Select your vehicle ---</option>
        <option value="???">Vehicle 1</option>
        
      </select> -->

      <!--<router-link v-bind:to="{name: 'addCar'}">Add New Car</router-link>-->
      <section id="car">
        <input
          class="make-input"
          type="text"
          placeholder="Make"
          v-model="serviceRequest.make"
        />
        <input
          class="model-input"
          type="text"
          placeholder="Model"
          v-model="serviceRequest.model"
        />
        <input
          class="year-input"
          type="text"
          placeholder="Year"
          v-model="serviceRequest.year"
        />
        <input
          class="color-input"
          type="text"
          placeholder="Color"
          v-model="serviceRequest.color"
        />
      </section>
      <section id="dropDownSection">
      <select id ="typeOfService" v-model="serviceRequest.oil">
        <option value="">--- Select Oil Type ---</option>
        <option value="Regular">Regular</option>
        <option value="Semi Synthetic">Semi Synthetic</option>
        <option value="Full Synthetic">Full Synthetic</option>
      </select>
      <select id="dropDownService" v-model="serviceRequest.frontBrakes">
        <option value="">--- Select Front Brakes ---</option>
        <option value="Good Year">Good Year</option>
        <option value="Power Stop">Power Stop</option>
        <option value="Firestone">Firestone</option>
      </select>

      <select id="backBrakesDrop" v-model="serviceRequest.backBrakes">
        <option value="">--- Select Back Brakes ---</option>
        <option value="Good Year">Good Year</option>
        <option value="Power Stop">Power Stop</option>
        <option value="Firestone">Firestone</option>
      </select>

      <select id="tiresDrop" v-model="serviceRequest.tires">
        <option value="">--- Select Tires ---</option>
        <option value="x1 Firestone">x1 Firestone</option>
        <option value="x2 Firestone">x2 Firestone</option>
        <option value="x3 Firestone">x3 Firestone</option>
        <option value="x4 Firestone">x4 Firestone</option>
        <option value="x1 Bridgestone">x1 Bridgestone</option>
        <option value="x2 Bridgestone">x2 Bridgestone</option>
        <option value="x3 Bridgestone">x3 Bridgestone</option>
        <option value="x4 Bridgestone">x4 Bridgestone</option>
        <option value="x1 WeatherGuard">x1 WeatherGuard</option>
        <option value="x2 WeatherGuard">x2 WeatherGuard</option>
        <option value="x3 WeatherGuard">x3 WeatherGuard</option>
        <option value="x4 WeatherGuard">x4 WeatherGuard</option>
      </select>
      </section>
      <label for="drop-off-date">Drop Off Date: </label>
      <input
        id="drop-off-date"
        name="drop-off-date"
        class="drop-off-date-input"
        type="date"
        v-model="serviceRequest.date"
      />

      <button id="submitRequestButton" type="submit">Submit Request</button>
    </form>
    <!-- <h2> {{this.$store.state.cars.make}} </h2> -->
  </div>
</template>

<script>
import repairsService from "../services/RepairsService";

export default {
  name: "repair-service-form",
  data() {
    return {
      serviceRequest: {
        make: "",
        model: "",
        year: "",
        color: "",
        oil: "",
        frontBrakes: "",
        backBrakes: "",
        tires: "",

        body: "",
      },
    };
  },
  methods: {
    saveService() {
      alert("button clicked");

      repairsService.create(this.serviceRequest).then((response) => {
        if (response.status === 200) {
          alert("success");

          console.log(this.$store.state.user.id);

          this.$router.push({ path: `/user/${this.$store.state.user.id}` }); // -> /user/1

          // this.$router.push({name: 'user', params: {id: this.$store.state.user.id}})
          // this.$router.push("/user/" + this.$store.state.user.id);
        } else {
          alert(response.status);
        }
      });
    },
  },
};
</script>

<style>

#car {
  display: flex;
  flex-direction: row;
  margin: auto;
}
.make-input {
  font-size: 25px;
  margin-right: 20px;
  padding: 15px;
}
.model-input {
  font-size: 25px;
  margin-right: 20px;
}
.year-input {
  font-size: 25px;
  margin-right: 20px;
}
.color-input {
  font-size: 25px;
  /* margin-right: 20px; */
}
#typeOfService {
  font-size: 25px;
  /* display: flex;
  justify-content: space-evenly; */
  /* padding: 2%; */
  margin-left: 10px;
  margin-right: 10px;
}
#dropDownService {
  font-size: 25px;
  /* padding: 2%; */
  margin-left: 10px;
  margin-right: 10px;
}
#backBrakesDrop {
  font-size: 25px;
  /* padding: 2%; */
  /* width: 50%; */
  margin-left: 10px;
  margin-right: 10px;
}
#tiresDrop{
  font-size: 25px;
  /* padding: 2%; */
  margin-left: 10px;
  margin-right: 10px;
}
#dropOffDate {
  margin-left: 10px;
  margin-right: 10px;
}
#submitRequestButton {
  font-size: 30px;
}
#dropDownSection{
  display: flex;
  margin: auto;
  justify-content: center;
  /* padding: 10px 10px; */
}
</style>