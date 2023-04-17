<template>
  <div class="activity datatable">
    {{ name }}
    <table>
      <thead>
      <tr>
        <th>Start time</th>
        <th>Duration</th>
        <th>URL</th>
        <th>Data Size</th>

      </tr>
      </thead>
      <tbody>

      <template v-for="record in activityRecords">
        <tr :key="record.id">
          <td>{{ name }}</td>
          <td>{{ record.duration }}</td>
          <td>{{ record.url }}</td>
          <td>{{ record.data_size }}</td>
        </tr>
      </template>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  name: "TableActivity",
  props: ["activityRecords", "name"],
}
</script>
