function sleep(ms){
      return new Promise(resolve => setTimeout(resolve, ms));
   }
function InvokeMethod(Obj)
{
	$.ajax({
	        type: 'GET',
	        url:  'http://localhost:9082/GetLocation',     
	        dataType: 'json',
	        async: true,
	        success: function(result) {
	        	//alert(result.length);
	        	for (var i = 0; i < result.length; i++){
		
	        		//alert(result[i].LocationId);
	        		//alert(result[i].LocationName);
	                $('#idLocation').append('<option value="' + result[i].LocationId + '">' + result[i].LocationName + '</option>');
	        	}
	        	
	        },
	        error: function(jqXHR, textStatus, errorThrown){
	        	alert(errorThrown);
	            alert(jqXHR.status + ' ' + jqXHR.responseText);
	        }
	   });
	   
	   //Deaprtment
	   alert("I m IN Department");
	 
	   //sleep(8000);
	  $.ajax({
	        type: 'GET',
	        url:  'http://localhost:9082/GetDepartment',     
	        dataType: 'json',
	        async: true,
	        success: function(resultR) {
	        	//alert(result.length);
	        	for (var i = 0; i < resultR.length; i++){		
	                $('#idDepartmant').append('<option value="' + resultR[i].DepartmentId + '">' + resultR[i].DepartmentName + '</option>');
	                
	        	}
	        	
	        },
	        error: function(jqXHR, textStatus, errorThrown){
	        	alert(errorThrown);
	            alert(jqXHR.status + ' ' + jqXHR.responseText);
	        }
	   });
	   
	   //Deaprtment
	   alert("I m IN BotName");
	   
	   $.ajax({
	        type: 'GET',
	        url:  'http://localhost:9082/GetBotName',     
	        dataType: 'json',
	        async: true,
	        success: function(resultB) {
	        	//alert(result.length);
	        	for (var i = 0; i < resultB.length; i++){		
	                $('#idBotName').append('<option value="' + resultB[i].BotId + '">' + resultB[i].BotName + '</option>');
	                
	        	}
	        },
	        error: function(jqXHR, textStatus, errorThrown){
	        	alert(errorThrown);
	            alert(jqXHR.status + ' ' + jqXHR.responseText);
	        }
	   });
	   
	   alert("Hello Piechart");
	   DashboardCreation("1");
}
	function DashboardCreation(obj)
 	{  
		

		var _varlocationid = document.getElementById("idLocation").value;
		//alert("Location :-" + _varlocationid);
		var _vardepartmentId = document.getElementById("idDepartmant").value;
		//alert("Department" +_vardepartmentId);
		var _varBotId = document.getElementById("idBotName").value;
		//alert("Bot" + _varBotId);
		
		var postData = _varlocationid + ',' + _vardepartmentId + ',' + _varBotId;
		//alert(postData);
		var postData= {
			    "LocationId" : _varlocationid,
      			"DepartmentId" :_vardepartmentId,
      			"BotId" : _varBotId
   			}
		// ajax post
		 $.ajax({
			url: "http://localhost:9082/PostGetDashboard",
    		type: "POST",
    		contentType : 'application/json; charset=utf-8',
       		dataType : 'json',
    		data: JSON.stringify(postData),
    		success: function(data, textStatus, jqXHR) {
        		//alert('Success!');
        		//alert(data[0].Alive);ProcesedCount,UnProcessedCount
        		//Code for Chart Start
        		//alert(data[0].ProcesedCount);
        		//alert(data[0].UnProcessedCount);
        		var _processed = data[0].ProcesedCount;
        		var _Unprocessed = data[0].UnProcessedCount;
        		document.getElementById("pieChart11").innerHTML="";
        		document.getElementById("pieChart1").innerHTML="";
        		//Firat Div Chart Start
        		var pie11 = new d3pie("pieChart11", {	
			    "header": {
			        "title": {
			            "fontSize": 34,
			            "font": "courier"
			        },
			        "subtitle": {
			            "color": "#8A084B",
			            "fontSize": 10,
			            "font": "courier"
			        },
			        "location": "top-left",
			        "titleSubtitlePadding": 10
			    },
			    "footer": {
			        "text": "",
			        "color": "#8A084B",
			        "fontSize": 10,
			        "font": "open sans",
			        "location": "bottom-left"
			    },
			    "size": {
			        "canvasHeight": 350,
			        "canvasWidth": 350,
			        "pieInnerRadius": "68%",
			        "pieOuterRadius": "54%"
			    },   "data": {
			        "sortOrder": "label-desc",
			        "content": [
			              {
			                  "label": "Processed",			                 
			                  "value": _processed,
			                  "color": "#FE2E9A"
			              }
			            ,
			  
			            {
			                "label": "Un-Processed",			              
			                "value": _Unprocessed,
			                "color": "#FAAC58"
			            }
			            
			        ]
			    },
			    "labels": {
			        "outer": {
			            "format": "label-percentage1",
			            "pieDistance": 20
			        },
			        "inner": {
			            "format": "none"
			        },
			        "mainLabel": {
			            "fontSize": 11
			        },
			        "percentage": {
			            "color": "#8A084B",
			            "fontSize": 11,
			            "decimalPlaces": 0
			        },
			        "value": {
			            "color": "#08088A",
			            "fontSize": 11
			        },
			        "lines": {
			            "enabled": true,
			            "color": "#0B615E"
			        },
			        "truncation": {
			            "enabled": true
			        }
			    },
			    "effects": {
			        "pullOutSegmentOnClick": {
			            "effect": "linear",
			            "speed": 400,
			            "size": 8,
			        }
			    }
			});
							//First Div chart end
							
			//Second Div Chart Start
        		var pie12 = new d3pie("pieChart1", {	
			    "header": {
			        "title": {
			            "fontSize": 34,
			            "font": "courier"
			        },
			        "subtitle": {
			            "color": "#999999",
			            "fontSize": 10,
			            "font": "courier"
			        },
			        "location": "top-left",
			        "titleSubtitlePadding": 10
			    },
			    "footer": {
			        "text": "",
			        "color": "#999999",
			        "fontSize": 10,
			        "font": "open sans",
			        "location": "bottom-left"
			    },
			    "size": {
			        "canvasHeight": 350,
			        "canvasWidth": 350,
			        "pieInnerRadius": "68%",
			        "pieOuterRadius": "54%"
			    },   "data": {
			        "sortOrder": "label-desc",
			        "content": [
			              {
			                  "label": "Processed",			                 
			                  "value": _processed,
			                  "color": "#3CB371"
			              }
			            ,
			  
			            {
			                "label": "Un-Processed",			              
			                "value": _Unprocessed,
			                "color": "#FF8C00"
			            }
			            
			        ]
			    },
			    "labels": {
			        "outer": {
			            "format": "label-percentage1",
			            "pieDistance": 20
			        },
			        "inner": {
			            "format": "none"
			        },
			        "mainLabel": {
			            "fontSize": 11
			        },
			        "percentage": {
			            "color": "#999999",
			            "fontSize": 11,
			            "decimalPlaces": 0
			        },
			        "value": {
			            "color": "#CD5C5C",
			            "fontSize": 11
			        },
			        "lines": {
			            "enabled": true,
			            "color": "#777777"
			        },
			        "truncation": {
			            "enabled": true
			        }
			    },
			    "effects": {
			        "pullOutSegmentOnClick": {
			            "effect": "linear",
			            "speed": 400,
			            "size": 8,
			        }
			    }
			});
									//Code for Chart End
									
					//Third Div Chart Start
			    		},
			    		error: function(jqXHR, textStatus, errorThrown) {
			        		alert('Error occurred!');
			    		}
						
					});
			
 	}
 	function DashboardGridCreation(Obj)
 	{
	    //alert("Bind Grid");
	    
	    //GridData_dt.attribute("display"," ");
		var _varlocationid = document.getElementById("idLocation").value;
		//alert("Location :-" + _varlocationid);
		var _vardepartmentId = document.getElementById("idDepartmant").value;
		//alert("Department" +_vardepartmentId);
		var _varBotId = document.getElementById("idBotName").value;
		//alert("Bot" + _varBotId);
		var postData = _varlocationid + ',' + _vardepartmentId + ',' + _varBotId;
		
		var postData= {
			    "LocationId" : _varlocationid,
      			"DepartmentId" :_vardepartmentId,
      			"BotId" : _varBotId
   			}
   			//alert(postData);
   			
   			$.ajax({
	        url: "http://localhost:9082/RealTimeDataValues/PostGetDashboardGrid",
    		type: "POST",
    		contentType : 'application/json; charset=utf-8',
       		dataType : 'json',
    		data: JSON.stringify(postData),
	        success: function(resultB) {
				//alert("I am in Success");
	        	//alert(resultB[0].ProcessId);
	            //alert(resultB[0].BotName);
	            //document.getElementById("GridData_dt").style.display="block";
	            for (var i = 0; i < resultB.length; i++){	
	            let noteRow = '<tr>' +
	      	  						'<td>' + resultB[i].ProcessId + '</td>' +
			                		'<td>' + resultB[i].BotName + '</td>' +
			                		'<td>' + resultB[i].LocationName + '</td>' +
			                		'<td>' + resultB[i].DepartmentName + '</td>' +
			                		'<td>' + resultB[i].Process_Name + '</td>' +
			                		'<td>' + resultB[i].Status + '</td>' +
			                		'<td>' + resultB[i].Remarks + '</td>' +
			                		'<td>' + resultB[i].CreatedBy + '</td>' +
			                		'</tr>';
			                		
	            $('#GridData_dt tbody').append(noteRow);
	          }
	        },
	        error: function(jqXHR, textStatus, errorThrown){
	        	alert(errorThrown);
	            alert(jqXHR.status + ' ' + jqXHR.responseText);
	        }
	   });
		
	    
	    
		}
		
		
 function funcSearch(Obj)
 {
	//
	//alert("Bind Grid");
	    
	    //GridData_dt.attribute("display"," ");
		var _varlocationid = document.getElementById("idLocation").value;
		//alert("Location :-" + _varlocationid);
		var _vardepartmentId = document.getElementById("idDepartmant").value;
		//alert("Department" +_vardepartmentId);
		var _varBotId = document.getElementById("idBotName").value;
		//alert("Bot" + _varBotId);
		var postData = _varlocationid + ',' + _vardepartmentId + ',' + _varBotId;
		
		var postData= {
			    "LocationId" : _varlocationid,
      			"DepartmentId" :_vardepartmentId,
      			"BotId" : _varBotId
   			}
   			//alert(postData);
   			
   			
   			
   			
   			$.ajax({
	        url: "http://localhost:9082/RealTimeDataValues/PostGetDashboardGridSearch",
    		type: "POST",
    		contentType : 'application/json; charset=utf-8',
       		dataType : 'json',
    		data: JSON.stringify(postData),
	        success: function(resultB) {
				//alert("I am in Success");
	        	//alert(resultB[0].ProcessId);
	            //alert(resultB[0].BotName);
	            //document.getElementById("GridData_dt").style.display="block";
	            
	            //Loop to remove table row start
	            var tableHeaderRowCount = 1;
						var table = document.getElementById('GridData_dt');
						var rowCount = table.rows.length;
						for (var i = tableHeaderRowCount; i < rowCount; i++) {
						    table.deleteRow(tableHeaderRowCount);
						}
	            //loop end
	            
	            for (var i = 0; i < resultB.length; i++){	
	            let noteRow = '<tr>' +
	      	  						'<td>' + resultB[i].ProcessId + '</td>' +
			                		'<td>' + resultB[i].BotName + '</td>' +
			                		'<td>' + resultB[i].LocationName + '</td>' +
			                		'<td>' + resultB[i].DepartmentName + '</td>' +
			                		'<td>' + resultB[i].Process_Name + '</td>' +
			                		'<td>' + resultB[i].Status + '</td>' +
			                		'<td>' + resultB[i].Remarks + '</td>' +
			                		'<td>' + resultB[i].CreatedBy + '</td>' +
			                		'</tr>';
			                		
	            $('#GridData_dt tbody').append(noteRow);
	          }
	        },
	        error: function(jqXHR, textStatus, errorThrown){
	        	alert(errorThrown);
	            alert(jqXHR.status + ' ' + jqXHR.responseText);
	        }
	   });
}
 	
 	