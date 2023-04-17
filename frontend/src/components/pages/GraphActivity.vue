<template>
  <div class="graph-activity">
    <BarChart :names="names" :values="values"/>
  </div>
</template>

<script>
import BarChart from "@/BarChart.vue";

export default {
  name: "GraphActivity",
  components: {
    BarChart,
  },
  props: ["names", "values"],
}
</script>