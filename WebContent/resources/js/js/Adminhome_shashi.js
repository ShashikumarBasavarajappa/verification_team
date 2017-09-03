$(document).ready(function(){
$("#archive_user").attr('disabled','disabled');
$("#newsletter").on('click',function(){

  //var shashi =  $('input[name=newsletter]:checked');
//var shashi =   $("#newsletter").is(":checked");
var shashi  =   $('#newsletter:checked').val();
  if(shashi){
     $("#archive_user").removeAttr('disabled');
      alert("---------------" + shashi);
      var data = 'user_id=' + shashi;
      var url = $("#profilepage").attr("action");

      alert("url" + url + "data " + data);

      $.ajax({
      url : url,
      data : data,
      type : "get",
      success : function(data) {
        alert( response );
      },
      error: function(){
           alert('Error while request..');
       }
    });

  }
 });
});
