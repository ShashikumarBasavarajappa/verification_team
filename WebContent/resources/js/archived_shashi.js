$(document).ready(function(){
$("#archive_user").attr('disabled','disabled');
$("#newsletter").on('click',function(){

  //var shashi =  $('input[name=newsletter]:checked');
//var shashi =   $("#newsletter").is(":checked");
var shashi  =   $('#newsletter:checked').val();
  if(shashi){
	  $('.loading').show(); 
     $("#archive_user").removeAttr('disabled');
      var data = 'user_id=' + shashi;
      var url = $("#profilepage").attr("action");
      $.ajax({
      url : url,
      data : data,
      type : "get",
      success : function(data) {
    	  $('.loading').hide();
        alert( response );
      },
      error: function(){
           alert('Error while request..');
       }
    });

  }
 });
});
