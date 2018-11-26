//Run as soon as the page is loaded
$(document).ready(function () {

    var speciality;
    var doctor;

    $('.speciality-select').click(function(e) {
        speciality = $(e.target).text();
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

            // FILL MODAL WITH APPOINTMENT DETAILS

            $('#someSwitchOptionSuccess').prop(':checked', false);

            $('#ensurance-name-text').val('');
            $('#patient-registration-number').val('');
            $('#pacient-phone-input').val('');
            $('#pacient-name-input').val('');

            $('#appointment-details #modal-detail-speciality').html('');
            $('#appointment-details #modal-detail-speciality').append(speciality);

            $('#appointment-details #modal-detail-start').html('');
            $('#appointment-details #modal-detail-start').append(moment(event.start).format('h:mm:ss a'));

            $('#appointment-details #modal-detail-duration').html('');
            $('#appointment-details #modal-detail-duration').append(moment(event.end).format('h:mm:ss a'));

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

        if($('#pacient-phone-input').val() != '' && $('#pacient-name-input').val() != ''){
            $('#appointment-details').hide();
            $('#modalProceedBtn').hide();
            $('#modalConfirmBtn').fadeIn("slow");
            $('#appointment-payment').fadeIn("slow");
        }
    });

    $('#particular-payment').hide();

    $('#someSwitchOptionSuccess').click(function (e) {
        if($('#someSwitchOptionSuccess').is(':checked')){
            $('#ensurance-payment').hide();
            $('#particular-payment').fadeIn("slow");
        } else {
            $('#ensurance-payment').fadeIn("slow");
            $('#particular-payment').hide();
        }
    });

    $('#modalConfirmBtn').click(function (e) {

        //Verify if the payment type is particular
        if($('#someSwitchOptionSuccess').is(':checked')){
            if($('#payment-type-dropdown').val() != 0) {
                confirmAppontmentParticular($('#payment-type-dropdown').val(), $('#pacient-name-input').val(), $('#pacient-phone-input').val());
            }
        } else {
            if($('#ensurance-name-text').val() != '' && $('#patient-registration-number').val() != ''){
                // confirmAppointmentEsnurance($('#ensurance-name-text').val(), $('#patient-registration-number').val());
            }
        }
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
                doctor = $(e.target).text();
                $('#btnDropdownDoctors').html('');
                $('#btnDropdownDoctors').append(doctor);
                $('#appointment-schedule').removeClass("disabled");

                $('#appointment-details #modal-detail-doctor').html('');
                $('#appointment-details #modal-detail-doctor').append(doctor);

                // Fill schedule with events
                getEvents(doctor);

            })
        },
        error: function (e) {
            $('#btnDropdownDoctors').prop("disabled", true);
        }
    });
}

function getEvents(doctor) {

    events = [];

    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/getEventsByDoctorName/" + doctor,
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

function confirmAppontmentParticular(paymentForm, patientName, patientPhone) {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/confirmAppontmentParticular/" + paymentForm + "/" + patientName + "/"+ patientPhone,
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            alert(data);
        },
        error: function (e) {
            alert("Error on confirm appointment");
        }
    });
}