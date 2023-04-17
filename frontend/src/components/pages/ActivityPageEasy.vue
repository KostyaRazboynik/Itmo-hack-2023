<template>
  <div class="activity-info">
    <div clas="name">
      This is {{ activity.name }}.
    </div>

    <div class="time">
      {{ activity.start }}
      {{ activity.end }}
    </div>

    <div class="memory-usage">
      {{ activity.memory }}
    </div>
  </div>
</template>

<script>
export default {
  name: "ActivityPage",
  props: ["activity"],
}
</script>

<style scoped>

</style>