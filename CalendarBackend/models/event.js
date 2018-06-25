module.exports = (sequelize, DataTypes) => {
  const Events = sequelize.define('Events', {
    eventId: {
      autoIncrement: true,
      primaryKey: true,
      type: DataTypes.INTEGER
    },
    day: {
      type: DataTypes.INTEGER
    },
    month: {
      type: DataTypes.INTEGER
    },
    year: {
      type: DataTypes.INTEGER
    },
    description: {
      type: DataTypes.STRING
    },
    startTime: {
      type: DataTypes.STRING
    },
    endTime: {
      type: DataTypes.STRING
    },
    title: {
      type: DataTypes.STRING
    }
  });

  return Events;
}
