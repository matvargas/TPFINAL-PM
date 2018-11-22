//Run as soon as the page is loaded
$(document).ready(function () {

    $('.speciality-select').click(function(e) {
        var speciality = $(e.target).text();
        getDoctorsBySpeciality(speciality);
        $('#btnDropdownSpecialities').html('');
        $('#btnDropdownSpecialities').append(speciality);
    });

    $('#appointment-schedule').fullCalendar({
        header:{
            left:'prev,next today',
            center:'title',
            right:'month,agendaWeek,agendaDay'
        },
        theme: 'bootstrap3',
        eventClick: function(event, jsEvent, view){
            $('#appointment-details').show();
            $('#modalProceedBtn').show();
            $('#modalConfirmBtn').hide();
            $('#appointment-payment').hide();
            $('#eventCreatorModal').modal('show');
        },
        height: 650,
        defaultView: 'month',
        editable: true,
        eventLimit: true, // allow "more" link when too many events
    });

    $('#appointment-schedule').addClass("disabled");

    $('#modalProceedBtn').click(function (e) {
        $('#appointment-details').hide();
        $('#modalProceedBtn').hide();
        $('#modalConfirmBtn').fadeIn("slow");
        $('#appointment-payment').fadeIn("slow");
    });

});

function getDoctorsBySpeciality(speciality) {

    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/getDoctorsBySpeciality/" + speciality,
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            $('#btnDropdownDoctors').prop("disabled", false);
            $('#dropdownDoctors').html('');
            for(i = 0; i < data.length; i++) {
                $('#dropdownDoctors').append("<a class=\"dropdown-item selected-doctor\">" + data[i].NAME + "</a>");
            }

            $('.selected-doctor').click(function (e) {
                var doctor = $(e.target).text();
                $('#btnDropdownDoctors').html('');
                $('#btnDropdownDoctors').append(doctor);
                $('#appointment-schedule').removeClass("disabled");

                // Fill schedule with events
                getEvents();

            })
        },
        error: function (e) {
            $('#btnDropdownDoctors').prop("disabled", true);
        }
    });
}

function getEvents() {

    events = [];

    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/getAllEvents",
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            for (i = 0; i < data.length ;i++){

                var color = "#2d5880";

                if(data[i]["PATIENT_ASSOCIATED"] == null) {
                   color = "#0df11f";
                }

                events.push({
                    title: data[i]["TITLE"],
                    start: data[i]["BEGINDATE"],
                    end: data[i]["ENDDATE"],
                    color: color,
                });
            }
            $('#appointment-schedule').fullCalendar('removeEventSources');
            $('#appointment-schedule').fullCalendar('addEventSource',  events);
        },
        error: function (e) {
            alert("Error fetching events");
        }
    });
}