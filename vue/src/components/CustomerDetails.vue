<template>
  <div class="details">
    <h1>Actual Customer Details</h1>
    <details-car v-bind:user="user" />
  </div>
</template>

<script>
// import UserService from "../services/UserService";
import DetailsCar from "@/components/DetailsCar";

export default {
  name: "customer-details",
  components: {
    DetailsCar,
  },
  data() {
    return {
      user: {},
    };
  },
  created() {
    this.user.id = this.$route.params.id;

    // UserService.getCarsByUser(this.$route.params.id).then((response) => {
    //   console.log(response);
    //   this.$store.commit("SET_CARS", response.data);
    // });
  },
};
</script>

<style>
</style>