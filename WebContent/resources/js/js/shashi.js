/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function(){
    $('#sampleForm').submit(
		function(event) {
			var firstname = $('.firstname').val();
			
			var data = 'firstname='
					+ encodeURIComponent(firstname);
				
			$.ajax({
				url : $("#sampleForm").attr("action"),
				data : data,
				type : "GET",

				success : function(response) {
					alert( "shashi" );
				},
				error : function(xhr, status, error) {
					alert("fail");
				}
			});
			return false;
		});
});

