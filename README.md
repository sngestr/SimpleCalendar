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

### Specs
***
<b>Must Have Specs</b><br />
[<b>X</b>] The UI should have one month hard coded view (Pick any month)<br />
[<b>X</b>] Click on a day box, and be able to create a new event on that day which gets sent to the backend on clicking submit.<br />
&nbsp; &nbsp; &nbsp; &nbsp; ◦The form should have start time, end time, description and submit. <br />
&nbsp; &nbsp; &nbsp; &nbsp; ◦Once submit is clicked the form should disappear.<br />
&nbsp; &nbsp; &nbsp; &nbsp; ◦Event should now appear in that day’s box. <br />
&nbsp; &nbsp; &nbsp; &nbsp; ◦Events cannot span multiple days. Must start and end the same day.<br />
[<b>X</b>] Show all events the user has on their calendar.<br />
[<b>X</b>] The UI should have 4 rows of 7 boxes (simple case of a 28 day month).<br />

<b>Optional Specs (Not required; bonus points available for inclusion of one or more features)</b><br />
[] Switch between months<br />
[] Week or day view<br />
[] Handle events spanning multiple days<br />
[<b>X</b>] Handle too many events to fit in your box UI on a given day.<br />
[<b>X</b>]You should be able to update/delete events. How you implement this UX is up to you.<br />
[] The UI should have 5 rows of 7 boxes with the correct date on the correct days.<br />
### Screenshots
***
<p align="center">
<img src="http://i65.tinypic.com/2vanvhz.png" alt="startup screenshot" width=30%; styles="display:'inline-block';"><img src="http://i64.tinypic.com/2v8l25x.png" alt="startup screenshot" width=30%; styles="display:'inline-block';"><img src="http://i68.tinypic.com/1qiaft.pngg" alt="startup screenshot" width=30%; styles="display:'inline-block';">
</p>

### Comment
***
Currently, the application is detecting the current month and grabbing the amount of days in the current month to populate the view so it's not hard-coded to be a certain month and 28 days. Also, the events might take a while to load (sorry!). I will continue to work and improve on this application and include all specifications!

<br /><br />
<b>Thank you!!</b>
