
 function InvokeLocatopn(Obj){
	
		$.ajax({
			        type: 'GET',
			        url:  'http://localhost:9082/LocationController/GetLocationListData',     
			        dataType: 'json',
			        async: true,
			        success: function(result) {
				     // alert(result[0]);
			         // console.log(result[0]);
			         
			         // New record
    $('a.editor-create').on('click', function (e) {
        e.preventDefault();
 
        editor.create( {
            title: 'Create new record',
            buttons: 'Add'
        } );
    } );
 
    // Edit record
    $('#LocationGridData_dt').on('click', 'td.editor-edit', function (e) {
        e.preventDefault();
 
        editor.edit( $(this).closest('tr'), {
            title: 'Edit record',
            buttons: 'Update'
        } );
    } );
 
    // Delete a record
    $('#LocationGridData_dt').on('click', 'td.editor-delete', function (e) {
        e.preventDefault();
 
        editor.remove( $(this).closest('tr'), {
            title: 'Delete record',
            message: 'Are you sure you wish to remove this record?',
            buttons: 'Delete'
        } );
    } );
			        
			          $('#LocationGridData_dt').DataTable({
				        data: result,				        
				        columns: [		
						    { data: 'LocationId' },
				            { data: 'LocationName' },
				            { data: 'CreatedDate'},
				            { data: 'CreatedBy' },
				            { data: 'UpdatedDate' },
				            { data: 'UpdatedBy' },
				            { data: 'IsActive' },
				            {
                			data: null,
			                className: "dt-center editor-edit",
			                defaultContent: '<i class="fa fa-pencil"/>Edit',
			                orderable: false
            				},
				            {
				                data: null,
				                className: "dt-center editor-delete",
				                defaultContent: '<i class="fa fa-trash"/>Delete',
				                orderable: false
				            }
				            
				        ],
				    });
			        	
			        },
			        error: function(jqXHR, textStatus, errorThrown){
			        	alert(errorThrown);
			            alert(jqXHR.status + ' ' + jqXHR.responseText);
			        }
			   });
			   


}

