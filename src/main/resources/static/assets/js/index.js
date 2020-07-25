$(function(){
    $(".menuh").hide();
    $(".headmenu").click(function(){
        $(".menuh").toggle();
    });
    $(".ico").mouseover(function(){
        $(this).css("background-color", "rgb(11, 151, 245)");
        $(this).find('.fa').css("color","rgb(255,255,255");
    });
    $(".ico").mouseout(function () { 
        $(this).css("background-color", "rgb(241, 243, 245)");
        $(this).find('.fa').css("color", "rgb(11, 151, 245)");
    });
})

            