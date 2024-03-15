import axios from "axios";
function AccessGet(url) {
  let data = {};
  axios
    .get(url)
    .then((res) => {
      console.log(res.data);
      data = res.data;
      return res.data[0];
    })
    .catch((err) => {
      console.log(err);
    });
  return data;
}
function AccessPost(url, data) {
  let datas = {};
  axios
    .post(url, data)
    .then((res) => {
      console.log(res);
      datas = res.data;
    })
    .catch((err) => {
      console.log(err);
    });
  return datas;
}

function Delete(url) {
  axios
    .delete(url)
    .then((res) => {
      console.log(res);
    })
    .catch((err) => {
      console.log(err);
    });
}
function Put(url, data) {
  axios
    .put(url, data)
    .then((res) => {
      console.log(res);
    })
    .catch((err) => {
      console.log(err);
    });
}
function Patch(url, data) {
  axios
    .patch(url, data)
    .then((res) => {
      console.log(res);
    })
    .catch((err) => {
      console.log(err);
    });
}

export { AccessGet, AccessPost, Delete, Put, Patch };
