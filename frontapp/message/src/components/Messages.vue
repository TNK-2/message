<template>
  <div>
    <h1>{{ msg }}</h1>
    <p style="color:red;">{{errorMsg}}</p>
    <input type="text" v-model="newmessage"/>
    <button @click="postmessage">
      送信
    </button>
    <div v-for="message in messages">
      {{message.id}} {{message.message}}
    </div>
  </div>
</template>

<script>
export default {
  name: 'Messages',
  props: {
    msg: String
  },
  data () {
    return {
      errorMsg: '',
      newmessage: '',
      messages: []
    }
  },
  created () {
    fetch('http://localhost')
    .then(response => response.json())
    .then(json => {
      this.messages = json
    })
  },
  methods: {
    getmessage: function() {
      fetch('http://localhost')
      .then(response => response.json())
      .then(json => {
        this.messages = json;
      })
    },
    postmessage: function() {
      const newmessage = this.newmessage;
      fetch('http://localhost', {
        method: 'post',
        headers: new Headers({
          'Accept': 'application/json',
          'content-type': 'application/json',
          'charset': 'UTF-8'
        }),
        body: JSON.stringify({
          message: newmessage
        })
      })
      .then(response => response.json())
      .then(json => {
        if (json.error) {
          this.errorMsg = json.error
        } else {
          this.errorMsg = ''
          this.messages.push(json)
        }
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
