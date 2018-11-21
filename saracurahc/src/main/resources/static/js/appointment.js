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
        selectable:true,
        select: function(start, end)
        {
            $('#appointment-details').show();
            $('#modalProceedBtn').show();
            $('#modalConfirmBtn').hide();
            $('#appointment-payment').hide();
            $('#eventCreatorModal').modal('show');
        },
        height: 650,
        defaultView: 'agendaWeek',
        editable: true,
        eventLimit: true, // allow "more" link when too many events
    });

    //$('#appointment-schedule').addClass("disabled");

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
                //$('#appointment-schedule').removeClass("disabled");
            })
        },
        error: function (e) {
            $('#btnDropdownDoctors').prop("disabled", true);
        }
    });
}