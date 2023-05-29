<template>
  <div>
    <div class="user" v-for="user in getUsers" v-bind:key="user.id">
      <div class="user-title">
        <p>
          Customer: <span>{{ user.firstName }} {{ user.lastName }}</span>
        </p>
        <p>
          Phone Number: <span>{{ user.phoneNumber }}</span>
        </p>
      </div>

      <details-car v-bind:user="user" />
    </div>
  </div>
</template>

<script>
import userService from "../services/UserService";
import DetailsCar from "@/components/DetailsCar";

export default {
  name: "details-user",
  components: {
    DetailsCar
  },
  data() {
    return {
      users: [],
    };
  },
  computed: {
    getUsers() {
      return this.users;
    },
  },
  created() {
    userService.getUsers().then((response) => {
      this.users = response.data;
    });
  },
};
</script>

<style>

.user {
  border: 1px solid black;
  margin: 10px;
}

.user p {
  font-family: Arial, Helvetica, sans-serif;
  margin: 5px 20px 20px 5px;
  padding: 0;
}

.user span {
  font-weight: bold;
}

.user-title {
  display: flex;
  justify-content: space-between;
  background: lightskyblue;
}
</style>