// Get the modal
var modal = document.getElementById("myModal");
var statmodal = document.getElementById("statModal");
// Get the button that opens the modal
/*var btn = document.getElementById("sidebar").querySelectorAll("#spans");*/ 
var btn = document.getElementsByTagName("span");
// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];
var closebtn = document.getElementsByClassName("closeButton")[0];

var activity;
// When the user clicks the button, open the modal 
for (var i = 0; i < btn.length; i++) {
    btn[i].onclick = function() {
      modal.style.display = "block";
      //console.log("From js onclick: " + this.id);
      activity = this.id;
      console.log("checking activity: " + activity);
      //setting GIF for each activity
      if(activity === 'Jogging'){
          $("#activityGif").attr('src',"images/joggingGIF.gif");   
        }
      if(activity === 'Squats'){
          $("#activityGif").attr('src',"images/squatsGIF.gif");   
        }
      if(activity === 'Plank'){
          $("#activityGif").attr('src',"images/plankGIF.gif");   
        }
      if(activity === 'Crunches'){
          $("#activityGif").attr('src',"images/crunchesGIF.gif");   
        }
      if(activity === 'Pilates'){
          $("#activityGif").attr('src',"images/pilatesGIF.gif");   
        }
      if(activity === 'Cycling'){
          $("#activityGif").attr('src',"images/cyclingGIF.gif");   
        }
      if(activity === 'Swimming'){
          $("#activityGif").attr('src',"images/swimmingGIF.gif");   
        }
      if(activity === 'Aerobics'){
          $("#activityGif").attr('src',"images/aerobicsGIF.gif");   
        }
      if(activity === 'Free Hand Exercises'){
          $("#activityGif").attr('src',"images/freehandGIF.gif");   
        }
    }

}


// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}

//script for timer on click
var h1 = document.getElementsByTagName('h1')[0],
    start = $('#start-button'),
    stop = $('#stop-button'),
    seconds = 0, tempSeconds = 0, minutes = 0, hours = 0;
    //t;

//replace timer button

$(document).ready(function(){
  $("#start-button").click(function(){
    $("#start-button").hide();
    $("#stop-button").show();
    
    myTimer = setInterval(myClock, 1000);

    function myClock() {
       seconds++;
       if (seconds >= 60) {
        seconds = 0;
        minutes++;
        if (minutes >= 60) {
            minutes = 0;
            hours++;
        }
       }
   
    
    h1.textContent = (hours ? (hours > 9 ? hours : "0" + hours) : "00") + ":" + (minutes ? (minutes > 9 ? minutes : "0" + minutes) : "00") + ":" + (seconds > 9 ? seconds : "0" + seconds);
        
    } 

  });
  
  $("#stop-button").click(function(){
    $("#stop-button").hide();
    $("#start-button").show();
    clearInterval(myTimer);
    h1.textContent = "00:00:00";
    timeValue = minutes + " minutes " + seconds + " seconds";
    //calorieBurnt = ((seconds/60) / 55);
    statmodal.style.display = "block";
    $("#timespan").html(timeValue);
    $("#activityName").html(activity);
    
    tempSeconds = seconds;
    seconds = 0; minutes = 0; hours = 0;
    $('#calorie').load("workout?activityName="+activity+"&timeTaken="+tempSeconds,function(responseValue, statusValue, xhr){});
  });
});

//When the user clicks on <span>, close the modal
span.onclick = function() {
  modal.style.display = "none";
  //$('#calorie').load("workout?activityName="+activity+"&timeTaken="+tempSeconds,function(responseValue, statusValue, xhr){});
}


closebtn.onclick = function() {
	statmodal.style.display = "none";
	console.log("from closebutton: " + activity);

	$("#graph").html("Generate Progress Graph");
    $("#report").html("Generate Progress Report");
}

