const express = require('express');
const router = express.Router();

router.use('/events', require('./events'));

module.exports = router;
