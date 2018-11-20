//Run as soon as the page is loaded
$(document).ready(function () {

    $('.speciality-select').click(function(e) {
        var speciality = $(e.target).text();
        getDoctorsBySpeciality(speciality);
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
                $('#scheduleOF').html('');
                $('#scheduleOF').append("Agenda de " + doctor + ", especialidade médica: " + speciality);
            })
        },
        error: function (e) {
            $('#btnDropdownDoctors').prop("disabled", true);
        }
    });
}