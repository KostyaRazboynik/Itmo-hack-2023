<template>
  <div class="graph-statistics">
    {{ chartData }}
    <Bar
        id="my-chart-id"
        :options="chartOptions"
        :data="chartData"
    />
  </div>
</template>

<script>
import { Bar } from 'vue-chartjs'
import { Chart as ChartJS, Title, Tooltip, Legend, BarElement, CategoryScale, LinearScale } from 'chart.js'

ChartJS.register(Title, Tooltip, Legend, BarElement, CategoryScale, LinearScale)

export default {
  name: 'BarChart',
  components: { Bar },
  props: ["names", "values"],

  computed: {
    chartData() {
      let colors = [];

      for (var i = 1; i <= this.names.length; i++) {
        colors.push('rgba(77, 166, 255, 0.5)');
      }

      return {
        // [ 'January', 'February', 'March' ]
        labels: this.names,
            // characteristics [40, 20, 12]
            datasets: [ { data: this.values, backgroundColor: colors}]
    }},
    chartOptions() { return {
      responsive: true,
      color: ["green"],}
  }
  },
}
</script>
