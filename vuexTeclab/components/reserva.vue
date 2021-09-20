<template>
  <section class="container shadow-md">
    <article class="containerTitle"><h1>RESERVAR</h1></article>
    <article class="containerForm">
      <form @submit="NuevaReserva" method="post">
        <div class="input">
          <label>Nombre</label>
          <input type="text" placeholder="Nombre"  v-model="name" />
        </div>
        <div class="input">
          <label>Fecha</label>
          <input type="date" id="datepicker"  v-model="fecha" />
        </div>
        <div class="input">
          <label>Desde</label>
          <input type="time" name="eta"  v-model="desde" />
        </div>
        <div class="input">
          <label>Hasta</label>
          <input type="time" name="eta"  v-model="hasta" />
        </div>
        <div>

        <input  class="submit" type="submit" value="Enviar datos" />
        </div>
      </form>
    </article>
  </section>
</template>

<style>
.container {
  width: 80%;
  height: auto;
  display: flex;
  padding: 1rem 0 2rem 0;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin-top: 2rem;
  border-radius: 5px;
}
.containerTitle {
  width: 90%;
  color: #045c44;
  font-size: 2rem;
}
.containerForm form {
  width: 90%;
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.containerForm {
  width: 90%;
  margin: 1rem 0 1rem 0;
}
.input {
  display: flex;
  flex-direction: column;
}

.input input {
  border: 1px solid rgb(126, 126, 126);
  border-radius: 5px;
  padding: 0.5rem;
  outline: none;
  color: rgb(126, 126, 126);
}

.input label{
    color: rgb(105, 105, 105);
    }
.submit {
  background: #04E474;
  border-radius: 5px;
  padding: .5rem 1rem .5rem 1rem;
  color: white;
  cursor: pointer;
  margin-top: 1rem;
}
</style>

<script>
export default {
}
</script>

