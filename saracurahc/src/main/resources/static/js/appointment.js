
//Run as soon as the page is loaded
$(document).ready(function () {

    var selectedSpeciality = $('.speciality-select');
    selectedSpeciality.click(function(e) {
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
        },
        error: function (e) {
            $('#btnDropdownDoctors').prop("disabled", true);
        }
    });
}



// function fire_ajax_submit() {
//
//     var search = {}
//     search["username"] = $("#username").val();
//
//     $("#btn-search").prop("disabled", true);
//
//     $.ajax({
//         type: "GET",
//         contentType: "application/json",
//         url: "/getDoctorsBySpeciality/" + id,
//         data: JSON.stringify(search),
//         dataType: 'json',
//         cache: false,
//         timeout: 600000,
//         success: function (data) {
//         },
//         error: function (e) {
//         }
//     });
//
// }