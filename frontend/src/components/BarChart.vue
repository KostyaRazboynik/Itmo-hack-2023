<script>
  import { Bar } from 'vue-chartjs'
  export default {
    name: 'BarChart',
    extends: Bar,
    props: ["chartData", "options"],

    mounted () {
      this.renderChart(this.chartData, this.options)
    }
  }
</script>
