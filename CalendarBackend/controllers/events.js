const express = require('express');
const models = require('../models');

const EventController = {
  registerRouter() {
    const router = express.Router();
    router.get('/', this.index); //returns all events in the Events database
    router.post('/', this.create); //create a new event and insert into Events database
    router.put('/:id', this.update); //update existing event in Events database
    router.delete('/:id', this.delete); //delete existing event in Events database

    return router;
  },
  index(req, res){
    models.Events.findAll({
      order: [
            ['year', 'ASC'],
            ['month', 'ASC'],
            ['day', 'ASC'],
        ],
    })
    .then((allEvents) => {
      res.json({
        events: allEvents,
      })
    });
  },
  create(req, res){
    models.Events.create({
      day: req.body.day,
      month: req.body.month,
      year: req.body.year,
      description: req.body.description,
      startTime: req.body.startTime,
      endTime: req.body.endTime,
      title: req.body.title,
    })
    .then((newEvent) => {
      res.json(newEvent);
    })
    .catch(() => {
      res.sendStatus(400);
    })
  },
  update(req, res){
    models.Events.update({
      title: req.body.title,
      startTime: req.body.startTime,
      endTime: req.body.endTime,
      description: req.body.description,
    }, {
      where: {
        eventId: req.params.id,
      }
    })
    .then((id) => {
      models.Events.findById(req.params.id)
      .then((event) => {
        res.json(event);
      })
      .catch(() => {
        res.sendStatus(400);
      })
    })
  },
  delete(req, res){
    models.Events.destroy({
      where: {
        eventId: req.params.id,
      }
    })
    .then(() => {
      res.sendStatus(200);
    })
    .catch(() => {
      res.sendStatus(400);
    })
  },
}

module.exports = EventController.registerRouter();
