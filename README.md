# Simple Calendar
### What is this application about?
***
<p align="left">This is a simple calendar where users can create, update and delete events added onto the calendar's individual day box.</p>

### How does it work?
***
<ul>
  <li><b>Create an event: </b> Long click on a day box to create an event </li>
  <li><b>View event on selected day:</b> Click on a day box to show all events on that day</li>
  <li><b>Update an event:</b> Click on a day box to show all events on that day and then click on the event you would like to update.</li>
  <li><b>Delete an event:</b> Same as update an event, just select 'Delete' instead. </li>
</ul>

### Client and Backend
***
<b>Client Side</b><br />
The client side of the application is built using Android Studio. The mobile application uses JSON to communicate with the API backend to get, post, update and delete events – to update the calendar visual UI on the client side. <br />

<b>Back End</b><br />
The backend of the calendar application is built with NodeJS, ExpressJS, SequelizeJS and PostgreSQL. The API backend is currently running on <a href="https://glacial-stream-73172.herokuapp.com/">https://glacial-stream-73172.herokuapp.com/</a>.

&nbsp; &nbsp; &nbsp; &nbsp; The API for the calendar:<br />
&nbsp; &nbsp; &nbsp; &nbsp; ●     POST /events<br />
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; ○     create an event

&nbsp; &nbsp; &nbsp; &nbsp; ●     GET /events<br />
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; ○    return all events

&nbsp; &nbsp; &nbsp; &nbsp; ●     DELETE /events/:id<br />
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; ○     delete an event
       
&nbsp; &nbsp; &nbsp; &nbsp; ●     PUT /events/:id<br />
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; ○     update an existing event

### Screenshots
***
<p align="center">
<img src="http://i65.tinypic.com/2vanvhz.png" alt="startup screenshot" width=30%; styles="display:'inline-block';"><img src="http://i64.tinypic.com/2v8l25x.png" alt="startup screenshot" width=30%; styles="display:'inline-block';"><img src="http://i68.tinypic.com/1qiaft.pngg" alt="startup screenshot" width=30%; styles="display:'inline-block';">
</p>

<br /><br />
