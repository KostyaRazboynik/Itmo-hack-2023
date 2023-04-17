<template>
  <div class="root">
    <GraphActivity :names="names" :values="values"/>

    <div class="body">
      <form @submit.prevent="changeSelection">
        <div class="selector">
          <label for="pet-select">Choose a option:</label>
          <select name="data" id="data-select" v-model="valuesType">
            <option value="duration">Duration</option>
            <option value="start_time">Start time</option>
            <option value="data_size">Data Size</option>
            <option value="data_per_time">Try put</option>
          </select>
        </div>
        <div class="button-field">
          <input type="submit" value="Put!">
        </div>
      </form>
    </div>
  </div>

  
</template>

<script>

import GraphActivity from "@/components/pages/GraphActivity.vue";
import axios from "axios"


export default {
  name: 'App',
  components: {
    GraphActivity,
  },

  data: function () {
    return {
      names: [],
      values: [],
      valuesType: "",
    }
  },

  methods: {
    changeSelection: function () {
      this.$root.$emit("changeSelection", this.valuesType);
    },
  },

  beforeMount() {
    this.$root.$on("changeSelection",() => {
      axios.get("http://164.92.210.100:5000/data_size").then(response => {
        const parsed = response.data
        var all_func = {}
            parsed.map((x) => {
              if (!(x["name"] in all_func)) {
                all_func[x["name"]] = x
                return
              }

              let old = all_func[x["name"]]
              if (x["start_time"] + x["duration"] > old["start_time"] + old["duration"]) {
                all_func[x["name"]] = x
              }
            })

        this.names = []
        this.values = []

        console.log(this.names)
        console.log(this.values)

        for (var key in all_func) {
          this.names.push(key)
          this.values.push(Number(all_func[key][this.valuesType]))
        }
      })
    })
  },
}
</script>
