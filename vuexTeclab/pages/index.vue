<template>
  <div class="masterContainer">
    <!-- <Tutorial /> -->
    <Reserva />
    <Tables />
  </div>
</template>

<style>
.masterContainer{
  width: 100%;
  height: auto;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  }
</style>

<script>
import Reserva from "../components/reserva.vue";
import Tables from '../components/tables.vue';
export default {
  components: {
    Reserva,
    Tables,
  }
};
</script>
