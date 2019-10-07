$(document).ready(function() {

  // Check for click events on the navbar burger icon
  $(".navbar-burger").click(function() {

      // Toggle the "is-active" class on both the "navbar-burger" and the "navbar-menu"
      $(".navbar-burger").toggleClass("is-active");
      $(".navbar-menu").toggleClass("is-active");

  });
  /*$("#signup").hide();*/
});
$(function () {
    $("#asignup, .cancel1").click(function () {
$("#signup").toggle(1000);
    });
    $("#asignin, .cancel2").click(function () {
        $("#signin").toggle(1000);
    });
    $(".delete").click(function () {
        $("#delete1").remove();

    });
    $("#create, .cancel1").click(function () {
        $("#createf").toggle(1000);
        $(".table").toggle(500);
    });
    $("#update").click(function () {
       if ($("input:checked").length > 1 || $("input:checked").length < 1) {
           alert("Select only one field for updating");
       }
       else {
$(".taskUpdate").toggle(1000);
       }

    });
    $(".cancel3").click(function () {
        $(".taskUpdate").toggle(1000);
    });
    $("#delete").click(function () {
        if ($("input:checked").length = 0) {
            alert("Select at least one field");
        }


    });
});

/* document.addEventListener('DOMContentLoaded', () => {
 (document.querySelectorAll('.notification .delete') || []).forEach(($delete) => {
     $notification = $delete.parentNode;
 $delete.addEventListener('click', () => {
    $notification.parentNode.removeChild($notification);
 });
 });
 });*/
