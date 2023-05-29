
<template>
  <div id="page">
    <section id="app">
      <article id="logo">
        <img
          id="image"
          src="./assets/logo.jpg"
          alt="Logo"
          style="width: 175px; height: 160px"
        />
      </article>
      <article id="company">
        <h1 id="companyName">AUTOCAR SERVICE & REPAIR</h1>
      </article>
      <article id="hyperlinks">
        <section id="nav">
          <article id="logoutArt">
            <router-link
              id="logout"
              v-bind:to="{ name: 'logout' }"
              v-if="$store.state.token != ''"
              >Logout</router-link
            >
          </article>
          <article id="registerArt">
            <router-link v-bind:to="{ name: 'requestService' }"
              >Service</router-link
            >
          </article>

          <article id="homeArt">
            <router-link id="aboutUs" v-bind:to="{ name: 'home' }"
              >Home</router-link
            >
          </article>
          <article id="profArt">
            <img
              id="profile"
              src="./assets/profileLogo.jpg"
              style="width 45px; height: 45px;"
            />
          </article>
          <article id="loginArt">
            <router-link
              v-bind:to="{ name: 'login' }"
              v-if="$store.state.token == ''"
              >Login</router-link
            >
          </article>
          <a href='' id="dashboardArt" v-on:click="onDashboardClick">
            Dashboard
          </a>
        </section>
      </article>
    </section>
    <router-view />
  </div>
</template>

<script>
export default {
  methods: {
    onDashboardClick() {
      if (this.isUser()) {
        this.$router.push({
          name: "user",
          params: { id: this.$store.state.user.id },
        });
      } else if (this.isEmployee()) {
        this.$router.push({
          name: "employee",
          params: { id: this.$store.state.user.id },
        });
      } else if (this.isAdmin()) {
        this.$router.push({
          name: "admin",
          params: { id: this.$store.state.user.id },
        });
      }
    },
    isUser() {
      const hasUser =
        this.$store.state.user.authorities.filter((auth) => {
          return auth.name === "ROLE_USER";
        }).length > 0;
      return hasUser && this.$store.state.user.authorities.length == 1;
    },
    isEmployee() {
      const hasEmployee =
        this.$store.state.user.authorities.filter((auth) => {
          return auth.name === "ROLE_EMPLOYEE";
        }).length > 0;
      return hasEmployee && this.$store.state.user.authorities.length == 1;
    },
    isAdmin() {
      const hasAdmin =
        this.$store.state.user.authorities.filter((auth) => {
          return auth.name === "ROLE_ADMIN";
        }).length > 0;
      return hasAdmin;
    },
  },
};
</script>script>
<style>
#page {
  padding: 50px;
}
#app {
  display: flex;
  border-radius: 5px;
  border: 3px solid #636363;
}

#nav {
  display: flex;
  /* grid-template-columns: 20% 20% 20% 40%; */
  justify-content: center;
  padding-top: 65px;
  font-size: 30px;
  padding: 60px 60px;
}

#logo {
  flex-basis: 10%;
  border: 3px solid #636363;
  justify-content: center;
  align-items: center;
}
#image {
  padding-top: 25%;
  position: relative;

  margin: auto;
}

#company {
  flex-basis: 50%;
  border: 3px solid #636363;
  /* padding-top: 10px; */
}
#hyperlinks {
  flex-basis: 45%;
  text-align: center;
  border: 3px solid #636363;
}
#companyName {
  font-size: 50px;
  text-align: center;
  padding-top: 30px;
}

.hyperArt {
  flex-basis: 25%;
  align-items: center;
}
#login {
  flex-basis: 25%;
}
#profile {
  flex-basis: auto;
  position: relative;
}
#logoutArt {
  padding: 25px 25px;
}
#registerArt {
  padding: 25px 25px;
}
#dashboardArt {
  padding: 25px 25px;
}
#homeArt {
  padding: 25px 25px;
}
#profArt {
  padding: 20px 15px;
}
#loginArt {
  padding-top: 25px;
}
</style>