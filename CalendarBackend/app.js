const express = require('express');
const expressSession = require('express-session');
const PORT = process.env.PORT || 8080;

const app = express();

// Access Body Data
const bodyParser = require('body-parser');
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

// Load Controller
const controllers = require('./controllers');
app.use(controllers);

// Load Models
const models = require('./models');
models.sequelize.sync({force: false})
  .then(() => {
    app.listen(PORT);
  });
