<template>
  <table class="w-4/5 divide-y divide-gray-200 mt-20">
            <thead class="bg-gray-50">
              <tr>
                <th
                  scope="col"
                  class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider"
                >
                  Name
                </th>
                <th
                  scope="col"
                  class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider"
                >
                  Fecha
                </th>
                <th
                  scope="col"
                  class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider"
                >
                  Horario
                </th>
              </tr>
            </thead>
            <tbody class="bg-white divide-y divide-gray-200">
              <tr v-for="reser in reserva" :key="reser.name">
                <td class="px-6 py-4 whitespace-nowrap">
                  <div class="flex items-center">
                    <div class="ml">
                      <div class="text-sm font-medium text-gray-900">
                        {{ reser.name }}
                      </div>
                    </div>
                  </div>
                </td>
                <td class="px-6 py-4 whitespace-nowrap">
                  <div class="text-sm text-gray-500">{{ reser.fecha }}</div>
                </td>
                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">
                  {{ reser.horario }}
                </td>
                <td
                  class="px-6 py-4 whitespace-nowrap text-right text-sm font-medium"
                >
                  <a href="#" class="text-red-500 hover:text-red-900"
                    >Eliminar</a
                  >
                </td>
              </tr>
            </tbody>
          </table>
</template>

<script>
const reserva = [
  {
    name: "Jane Cooper",
    fecha: "20/09/2021",
    horario: "12:00",
  }
];


export default {
  computed: {
      reserva() {
          return reserva
      }
  }
}
</script>
