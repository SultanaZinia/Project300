<<<<<<< HEAD
var courseURL = "course";
$(document).ready(function() {
    //var taskTable;
    //$('[data-toggle="tooltip"]').tooltip();
    
//    $('#courseTable tbody').on('click', 'tr', function() {
//        id = projectTable.cell(this, 0).data();
//        
//        $('#view_id').html(id);
//        $('#view_title').html(projectTable.cell(this, 1).data());
//        $('#view_submission_date').html(projectTable.cell(this, 2).data());
//        $('#view_members').html(projectTable.cell(this, 3).data());
//        $('#modalInfo').modal('show');
//    	alert('captured the click event');
//    	window.location.replace("tasks");
//        });
	alert('click!');
	$('#course_table').on('click', 'th', function(event) {
		alert('click click!');
    });
	
    	
});
=======
var courseURL = 'ajaxcourse';
var courseTable;



$(document).ready(
		function() {
			//alert('user here is: '+ $('#hidden_username').val());
			$('[data-toggle="tooltip"]').tooltip();
			courseTable = $('#courseTable').DataTable({
				"dom" : 'lrtip',
				"processing" : true,
				// "serverSide": true,
				"lengthChange" : true,
				"autoWidth" : false,
				"aoColumns" : [ {
					"mData" : 0,

				}, {
					"sWidth" : "20%",
					"mData" : 1
				}, {
					// "sWidth": "20%",
					"mData" : 2
				}, {
					"mData" : 3

				}

				],
				ajax : {
					url : courseURL + "?username=" + $('#hidden_username').val(),
					//url: courseURL,
					type : 'get',
					dataType : 'json'
				}

			});
			

			$('#courseTable tbody').on(
					'click',
					'tr',
					function(e) {
						var rowIndex = courseTable.row(this).index();
						var redirectWithParam = "gototasks?course_id="
								+ courseTable.cell(rowIndex, 0).data();
						window.location.href = redirectWithParam;
						//window.location.redirect(redirectWithParam) ;
					});

		});

function getUrlVars() {

	var vars = [], hash;
	var hashes = window.location.href.slice(
			window.location.href.indexOf('?') + 1).split('&');
	for ( var i = 0; i < hashes.length; i++) {
		hash = hashes[i].split('=');
		vars.push(hash[0]);
		vars[hash[0]] = hash[1];
	}
	return vars;
}
>>>>>>> fbcb89ffc8092d9ea7194463b4bb938039645baf
