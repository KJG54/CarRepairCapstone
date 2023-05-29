

<template>
  <div id="home">
    <section id="sloganBox">
      <article>
        <div id="slogan">
          <h1 style="font-size: 55px">Where your car goes to take a brake</h1>
        </div>
      </article>
      <article>
        <body>
          <p>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
            eiusmod tempor incididunt ut labore et dolore magna aliqua. Lorem
            ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod
            tempor incididunt ut labore et dolore magna aliqua. Lorem ipsum
            dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor
            incididunt ut labore et dolore magna aliqua. Lorem ipsum dolor sit
            amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt
            ut labore et dolore magna aliqua.
          </p>
        </body>
        <button id="learnMore">Learn More</button>
      </article>
    </section>
    <section>
      <article id="needHelp">
        <h1>Need Help?</h1>
        <body>
          <button id="serviceButton">Request Service</button>
        </body>
        <h1>About Us</h1>
        <body>
          <p>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
            eiusmod tempor incididunt ut labore et dolore magna aliqua. Lorem
            ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod
            tempor incididunt ut labore et dolore magna aliqua. Lorem ipsum
            dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor
            incididunt ut labore et dolore magna aliqua. Lorem ipsum dolor sit
            amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt
            ut labore et dolore magna aliqua.
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
            eiusmod tempor incididunt ut labore et dolore magna aliqua. Lorem
            ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod
            tempor incididunt ut labore et dolore magna aliqua. Lorem ipsum
            dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor
            incididunt ut labore et dolore magna aliqua. Lorem ipsum dolor sit
            amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt
            ut labore et dolore magna aliqua.
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
            eiusmod tempor incididunt ut labore et dolore magna aliqua. Lorem
            ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod
            tempor incididunt ut labore et dolore magna aliqua. Lorem ipsum
            dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor
            incididunt ut labore et dolore magna aliqua. Lorem ipsum dolor sit
            amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt
            ut labore et dolore magna aliqua.
          </p>
        </body>
      </article>
    </section>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
#home {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  border: 5px solid gray;
}
#sloganBox {
  flex-basis: 500px;
  text-align: center;
  padding-top: 60px;
  align-items: center;
  justify-content: center;
  background-color: rgb(218, 216, 216);
}
#slogan {
  padding-top: 30px;
  width: 1000px;
  height: 200px;
  background-color: rgb(172, 172, 172);
  align-items: center;
  justify-content: center;
  margin: auto;
}
p {
  padding-left: 100px;
  padding-right: 100px;
  font-size: 20px;
  padding-bottom: 20px;
}
#slogan h1 {
  font-weight: lighter;
}
#learnMore {
  font-size: xx-large;
  padding: 20px 40px;
  border-radius: 60px;
  border: 4px solid rgb(37, 37, 37);
  background-color: rgb(218, 216, 216);
  text-decoration: underline;
}
#needHelp {
  align-items: center;
  justify-content: center;
  margin: auto;
  text-align: center;
}
#needHelp h1 {
  font-size: 70px;
}
#needHelp button{
  font-size: xx-large;
  padding: 50px 70px;
  border: 6px solid rgb(61, 61, 61);
  background-color: rgb(165, 165, 165);
  border-radius: 10px;
}
</style>