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
    $('.pagination li a').on('click', function(){
        $('.pagination li a.is-current').removeClass('is-current');
        $(this).addClass('is-current');

    });
    $(".pagination-previous").click(function () {
        if($('.is-current').text() == 1) {
            window.location.href = "/pagination?page=3";
            $('.pagination-link:eq(2)').click();
        }
        else if ($('.is-current').text() ==2) {
            window.location.href = "/pagination?page=1";
            $('.pagination-link:eq(0)').click();
        }
        else 	{
            window.location.href = "/pagination?page=2";
            $('.pagination-link:eq(1)').click();
        }
    });
    $(".pagination-next").click(function () {
        if($('.is-current').text() == 1) {
            window.location.href = "/pagination?page=2";
            $('.pagination-link:eq(1)').click();
        }
        else if ($('.is-current').text() ==2) {
            window.location.href = "/pagination?page=3";
            $('.pagination-link:eq(2)').click();
        }
        else window.location.href = "/pagination?page=1";
            $('.pagination-link:eq(0)').click();
    });
});


