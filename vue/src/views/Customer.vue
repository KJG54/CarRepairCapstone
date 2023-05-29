<template>
  <div class="dashboard">
    <h1>Details</h1>
    <customer-links />
    <customer-details />
  </div>
</template>


<script>
import CustomerLinks from '../components/CustomerLinks.vue'
import CustomerDetails from '../components/CustomerDetails.vue'

export default {
  name: "user",
  components: {
    CustomerLinks,
    CustomerDetails
  }
};
</script>

<style>
</style>
























