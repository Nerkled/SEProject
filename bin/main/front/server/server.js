const express = require('express');
const path = require('path');
const app = express();

app.use(express.static(path.join(__dirname, '../client'))); 

app.listen(3000, function () {
  console.log('Server is running on http://localhost:3000');
});