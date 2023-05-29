
<template>
  <div id="login" class="text-center">
    <section id="entirePage">
      <section id="leftSide">
        <article id="topLeft">
          <p>MEMBER LOGIN</p>
        </article>
        <article id="bottomLeft">
          <h1 class="h3 mb-3 font-weight-normal">Welcome Back</h1>
          <h3>Sign in to save your car and your cash</h3>
          <form class="form-signin" @submit.prevent="login">
            <div
              class="alert alert-danger"
              role="alert"
              v-if="invalidCredentials"
            >
              Invalid username and password!
            </div>
            <div
              class="alert alert-success"
              role="alert"
              v-if="this.$route.query.registration"
            >
              Thank you for registering, please sign in.
            </div>
            <label for="username" class="sr-only"></label>
            <input
              type="text"
              id="username"
              class="form-control"
              placeholder="Username"
              v-model="user.username"
              required
              autofocus
            />
            <br />
            <br />
            <br />
            <label for="password" class="sr-only"></label>
            <input
              type="password"
              id="password"
              class="form-control"
              placeholder="Password"
              v-model="user.password"
              required
            />
            <br />
            <br />
            <br />
            <button type="submit">Sign in</button>
            <div id="needAccount">
              <router-link :to="{ name: 'register' }"
                >Need an account?</router-link
              >
            </div>
          </form>
        </article>
      </section>
      <section id="rightSide">
        <h1>Member Benefits:</h1>

        <h3>
          <!-- <div id="dollarSign"> -->
          <img
            id="dollarSign"
            src="https://thumbs.dreamstime.com/b/outline-coins-icon-isolated-grey-background-line-money-symbol-web-site-design-logo-app-editable-stroke-vector-illustra-95398130.jpg"
            style="width 70px; height: 90px; background-color:grey;"
          />
          <!-- </div> -->
          Full tires and Brakes - SAVE 2.5%
        </h3>
        <p>
          Buy 4 WeatherGuard tires, front and rear firestone brakes and save 10%
          off your entire order!
        </p>
        <h3>
          <img
            id="dollarSign"
            src="https://thumbs.dreamstime.com/b/outline-coins-icon-isolated-grey-background-line-money-symbol-web-site-design-logo-app-editable-stroke-vector-illustra-95398130.jpg"
            style="width 70px; height: 90px; background-color:grey;"
          />The Works - SAVE 5%
        </h3>
        <p>
          Buy 4 WeatherGuard tires, front and rear firestone brakes, and oil
          change (any type), air filter (any type), wheel alignment, inspection,
          and Emmisions stickes and save 5% off your entire order!
        </p>
        <div>
          <p>Share with your friends:</p>
        </div>
        <button>Send Link</button>
      </section>
    </section>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        id: "",
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);

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
          }
        })
        .catch((error) => {
          const response = error.response;
          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
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
</script>
<style>
#login {
  border: 6px solid gray;
}
#entirePage {
  display: flex;
  flex-direction: row;
}
#leftSide {
  flex-basis: 50%;
}
#topLeft {
}
#bottomLeft {
  padding-left: 20px;
  padding-right: 60px;
}
#topLeft p {
  margin: auto;
  font-size: 60px;
  background-color: rgb(117, 117, 117);
  padding: 70px 50px;
  text-align: center;
}
#rightSide {
  display: flex;
  flex-basis: 50%;
  background-color: rgb(213, 213, 213);
  flex-direction: column;
  padding-bottom: 40px;
}
#rightSide h1 {
  padding-left: 12%;
  font-size: 60px;
  margin-bottom: 0px;
}
#rightSide h3 {
  text-align: right;
  padding-right: 14%;
  font-size: 27px;
}
#rightSide p {
  font-size: 22px;
  text-align: left;
  margin-bottom: 0px;
}
#rightSide div p {
  text-align: center;
  font-weight: bold;
  font-size: x-large;
  margin-bottom: 0px;
}
#rightSide button {
  margin: auto;
  padding: 4% 12%;
  background-color: rgb(128, 128, 128);
  border: 5px solid rgb(83, 83, 83);
  font-size: 40px;
}
.form-signin {
  display: flex;
  flex-direction: column;
}
.form-signin button {
  font-size: xx-large;
  padding: 30px 30px;
  width: 60%;
  margin: auto;
  border: 6px solid rgb(102, 102, 102);
}
#bottomLeft h1 {
  text-align: left;
  padding: 20px 20px;
  margin: auto;
  font-size: 50px;
}
#bottomLeft h3 {
  margin: auto;
  text-align: left;
  font-weight: lighter;
  font-size: 30px;
  padding-left: 20px;
  padding-bottom: 40px;
}
#username {
  text-align: left;
  font-size: xx-large;
  border: 5px solid grey;
  padding: 10px 20px;
  border-radius: 5px;
}
#password {
  text-align: left;
  font-size: xx-large;
  border: 5px solid grey;
  padding: 10px 20px;
  border-radius: 5px;
}
#needAccount {
  text-align: center;
  font-size: large;
  margin: auto;
  padding: 20px 20px;
}
#dollarSign {
  position: relative;
  right: 70px;
  top: 35px;
  flex-basis: auto;
}
</style>