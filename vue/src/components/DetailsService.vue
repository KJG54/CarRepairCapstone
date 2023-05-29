<template>
  <div>
    <table class="service-table">
        <thead>
            <th>Item</th>
            <th>Value</th>
        </thead>
        <tr
          class="service-row"
          v-for="(value, key) in services.service"
          v-bind:key=key
        >
          <td class="service-key">{{ key }}</td>
          <td class="service-value">
            <input class="service-input" type="text" v-bind:placeholder="value">
          </td>
        </tr>
    </table>

    <div class="buttons">
      <button>Save</button>
      <button>Cancel</button>
    </div>
  </div>
</template>

<script>
import RepairsService from "@/services/RepairsService.js";

export default {
    name: 'details-service',
    props: ['carId'],
    data(){
        return {
            services: []
        }
    },
    created(){
        RepairsService.getServices(this.carId).then((response) => {
            this.services = response.data;
        });
    }
}
</script>

<style>
.service-row {
  border: none;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

.service-value, .service-input {
    width: 100%;
}

.service-value:hover {
    background-color: lightgray;
}

.service-key, .service-value {
  padding: 0;
}

.buttons button {
    margin: 5px;
}

</style>