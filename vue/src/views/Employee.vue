<template>
  <div class="dashboard">
    <h1>Repair List</h1>
    <employee-links />
    <employee-details />
    </div>

</template>

<script>
import EmployeeLinks from '../components/EmployeeLinks.vue'
import EmployeeDetails from '../components/EmployeeDetails.vue'

export default {
  name: "employee",
  components: { 
      EmployeeLinks,
      EmployeeDetails 
      }


}
</script>

<style>

</style>