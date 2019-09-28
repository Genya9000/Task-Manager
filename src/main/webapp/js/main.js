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
    $("#asignin, .cancel").click(function () {
        $("#signin").toggle(1000);
    });
    $(".delete").click(function () {
        $("#delete1").remove();

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
