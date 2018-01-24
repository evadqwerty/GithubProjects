var profileDataTable;

$(document).ready(function() {
	initProfileDataTable();
});

function initProfileDataTable() {
	profileDataTable = $('#profileDataTable').dataTable({
		"dom" : 'Hgtp',
		"sAjaxSource" : "/ApplicationsDeveloperAssesment/profile/all",
		"bPaginate" : true,
		"bScrollCollapse" : true,
		"iDisplayStart" : 0,
		"iDisplayLength" : 10,
		columns : [ {
			"mData" : "id",
			"visible" : false
		}, {
			"sTitle" : "Name",
			"mData" : "name",
			mRender : function(data, type, row) {
				return data.first + " " + data.middle + ". " + data.last;
			}
		}, {
			"sTitle" : "Age",
			"mData" : "age"
		}, {
			"mData" : "name.first",
			"visible" : false
		}, {
			"mData" : "name.middle",
			"visible" : false
		}, {
			"mData" : "name.last",
			"visible" : false
		}, {
			"mData" : "picture",
			"visible" : false
		}, {
			"mData" : "profile",
			"visible" : false
		}, {
			"mData" : "email",
			"visible" : false
		}, {
			"mData" : "phone",
			"visible" : false
		}, {
			"mData" : "address",
			"visible" : false
		}, {
			"mData" : "balance",
			"visible" : false
		} ],

		"language" : {
			"emptyTable" : "No Item Found",
			"zeroRecords" : "No Item Found"
		}

	});

	$('#profileDataTable tbody')
			.on(
					'click',
					'tr',
					function() {
						var id = profileDataTable.fnGetData(this, 0);
						var name = profileDataTable.fnGetData(this, 3) + " "
								+ profileDataTable.fnGetData(this, 4) + " "
								+ profileDataTable.fnGetData(this, 5);
						var age = profileDataTable.fnGetData(this, 2);
						var picture = profileDataTable.fnGetData(this, 6);
						var profile = profileDataTable.fnGetData(this, 7);
						var email = profileDataTable.fnGetData(this, 8);
						var phone = profileDataTable.fnGetData(this, 9);
						var address = profileDataTable.fnGetData(this, 10);
						var balance = profileDataTable.fnGetData(this, 11);

						window.location.href = "/ApplicationsDeveloperAssesment/profile/redirect?id="
								+ id
								+ "&name="
								+ name
								+ "&picture="
								+ picture
								+ "&profile="
								+ profile
								+ "&email="
								+ email
								+ "&phone="
								+ phone
								+ "&address="
								+ address
								+ "&age=" + age + "&balance=" + balance;
					});

}