<template>
  <div class="Test">
    <van-search v-model="pid" placeholder="请输入搜索关键词" @keydown.enter="GetLike"/>
  </div>
</template>
<script>
import axios from "axios";

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: 'test',
  data() {
    return {
      like: [],
      pid: "",
    };
  },
  methods:{
    GetLike() {
      axios.get("/api/selectAll")
          .then((res) => {
            console.log(res);
            this.like = res.data;
            console.log();

          });
      return this.like;
    },
  },
  created() {
    this.GetLike();
  }
}
</script>

<style scoped>

</style>