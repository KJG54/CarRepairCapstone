<template>
  <div>
    <h1>hello world</h1>
    <thead>
      <tr>
        <th>Oil</th>
        <th>Front Brakes</th>
        <th>Back Brakes</th>
        <th>Tires</th>
      </tr>
    </thead>
    <tbody>
      <!-- v-for="service in this.$store.state.services" v-bind="" -->
      <tr>
        <td>{{ this.$store.state.services.service.oil }}</td>
        <td>{{ this.$store.state.services.service.frontBrakes }}</td>
        <td>{{ this.$store.state.services.service.backBrakes }}</td>
        <td>{{ this.$store.state.services.service.tires }}</td>
      </tr>
    </tbody>
  </div>
</template>

<script>
import repairsService from "../services/RepairsService";

export default {
  name: "carServices",
  computed:{
      getService() {
          return {
              oil: this.$store.state.services.service.oil,
              frontBrakes: this.$store.state.services.service.frontBrakes,
              backBrakes: this.$store.state.services.service.backBrakes,
              tires: this.$store.state.services.service.tires

          }
      }
  },
  created() {
    repairsService.getServices(this.$route.params.id).then((response) => {
      console.log(response);
      this.$store.commit("SET_SERVICES", response.data);
    });
  },
};
</script>

<style>
</style>