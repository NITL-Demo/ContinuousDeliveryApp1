$(document).ready(function() {
		      // alert("Hi..1");
			  
			  //Pizzas
            $('#pizza').click(function ()
            {
				$.ajax({
				  type: "GET",
				  url: "/devcapsule-spring-1.0/pizzas",
				  contentType: "application/json; charset=utf-8",
				  dataType: "json",
				  success: function(data) {
					// Do magic here
					var _len = data.length;
					var post, i , toppings ;
					
					var div = document.getElementById('container');
					div.innerHTML = ""; 
										
					 var table = document.createElement('table');
					 table.style.width = '60%';
                     table.setAttribute('border', '1');
					 
					 
					 var row = table.insertRow(0);
					 row.style.border = "1px solid #808080"
					 row.style.backgroundColor  = "#C0C0C0"
					 
					 var rowcol1 = row.insertCell(0);
					 rowcol1.innerHTML = "Pizza Name";
					 
					 var rowcol2 = row.insertCell(1);
					 rowcol2.innerHTML = "Base";
					 
					 var rowcol3 = row.insertCell(2);
					 rowcol3.innerHTML = "Toppings";
					 
					 
					 var rowcol4 = row.insertCell(3);
					 rowcol4.innerHTML = "Price";
					 
					
					  for (i = 0; i < _len; i++) {
						//debugger
						post = data[i];						
						//dataStr = dataStr + "<br>" + post.name   ;
						
						var row1 = table.insertRow(i+1);
						row1.style.border = "1px solid #000"
						// Insert New Column for Row1 at index '0'.
						var row1col1 = row1.insertCell(0);
						row1col1.innerHTML = post.name;
						
						// Insert New Column for Row1 at index '2'.
						var row1col3 = row1.insertCell(1);
						row1col3.innerHTML = post.base.name;
						
						var row1col3 = row1.insertCell(2);
						
						var _toppingsLen = post.toppings.length;
						var toppingsStr = "";
						for( j = 0 ; j < _toppingsLen ; j++) {
						   toppings = post.toppings[j] ;
                 		   toppingsStr = toppingsStr + "<br>" + toppings.name ;				   
						}
						row1col3.innerHTML = toppingsStr;
						
						// Insert New Column for Row1 at index '1'.
						var row1col2 = row1.insertCell(3);
						row1col2.innerHTML = post.price;
						
					  }
					 
                     div.appendChild(table);
					 //document.getElementById('pizzalist').innerHTML = dataStr;
					
					
				  }
				});
				
            });
              //Pizzas
			  
			  // Base 
			  $('#bases').click(function ()
             {
			     //alert("bases");
				 $.ajax({
				  type: "GET",
				  url: "/devcapsule-spring-1.0/bases",
				  contentType: "application/json; charset=utf-8",
				  dataType: "json",
				  success: function(data) {
				                  
								  var _len = data.length;
				                  var div = document.getElementById('container');
					              div.innerHTML = ""; 
								  
								  var table = document.createElement('table');
								  //table.style.width = '100%';
								  table.setAttribute('border', '1');
								  
								  
								  var row = table.insertRow(0);
								  row.style.border = "1px solid #808080"
					              row.style.backgroundColor  = "#C0C0C0"
								 
								  var rowcol1 = row.insertCell(0);
								  rowcol1.innerHTML = "Bases";
								  
								  
								  for (i = 0; i < _len; i++) {
									//debugger
									post = data[i];	
									var row1 = table.insertRow(i+1);
									row1.style.border = "1px solid #000"
									// Insert New Column for Row1 at index '0'.
									var row1col1 = row1.insertCell(0);
									row1col1.innerHTML = post.name;
									  
								  }
								  
								  div.appendChild(table);
								  
				          }
				  });
				 
				 
			  });
			  //Bases
			  
			  // Toppings
			  $('#toppings').click(function ()
              {
			      //alert("toppings");
				  $.ajax({
				  type: "GET",
				  url: "/devcapsule-spring-1.0/toppings",
				  contentType: "application/json; charset=utf-8",
				  dataType: "json",
				  success: function(data) {
				            
							      var _len = data.length;
				                  var div = document.getElementById('container');
					              div.innerHTML = ""; 
								  
								  var table = document.createElement('table');
								  //table.style.width = '100%';
								  table.setAttribute('border', '1');
								  
								  
								  var row = table.insertRow(0);
								  row.style.border = "1px solid #808080"
					              row.style.backgroundColor  = "#C0C0C0"
								 
								  var rowcol1 = row.insertCell(0);
								  rowcol1.innerHTML = "Toppings";
								  
								  
								  for (i = 0; i < _len; i++) {
									//debugger
									post = data[i];	
									var row1 = table.insertRow(i+1);
									row1.style.border = "1px solid #000"
									// Insert New Column for Row1 at index '0'.
									var row1col1 = row1.insertCell(0);
									row1col1.innerHTML = post.name;
											  
								  }
								  
								  div.appendChild(table);
				  
				     }
				  });
			  });
			  //Toppings
			  
			  // Orders
			  $('#orders').click(function ()
              {
			      //alert("toppings");
				  $.ajax({
				  type: "GET",
				  url: "/devcapsule-spring-1.0/orders",
				  contentType: "application/json; charset=utf-8",
				  dataType: "json",
				  success: function(data) {
				            
							      var _len = data.length;
								  var post;
				                  var div = document.getElementById('container');
					              div.innerHTML = ""; 
								  
								  var table = document.createElement('table');
								  table.style.width = '60%';
								  table.setAttribute('border', '1');
								  
								  
								  var row = table.insertRow(0);
								  row.style.border = "1px solid #808080"
					              row.style.backgroundColor  = "#C0C0C0"
								 
								  var rowcol1 = row.insertCell(0);
								  rowcol1.innerHTML = "Pizza Name";
								  
								  
								  var rowcol1 = row.insertCell(1);
								  rowcol1.innerHTML = "Base";
								  
								  var rowcol1 = row.insertCell(2);
								  rowcol1.innerHTML = "Toppings";
								  
								  var rowcol1 = row.insertCell(3);
								  rowcol1.innerHTML = "Total Price";
								  
								  
								  for (i = 0; i < _len; i++) {
										
										post = data[i];
									
									    var row1 = table.insertRow(i+1);
									    row1.style.border = "1px solid #000"
										
									    var _pizzasLen = post.pizzas.length;
										
										for( j = 0 ; j < _pizzasLen ; j++) {
										   var pizza = post.pizzas[j] ;
										   
                                           var row1col1 = row1.insertCell(0);
										   row1col1.innerHTML = pizza.name;	


                                           var row1col2 = row1.insertCell(1);
										   row1col2.innerHTML = pizza.base.name;		


                                           var _toppingsLen = pizza.toppings.length ;		
                                           for( k = 0 ; k < _toppingsLen ; k++) {
											   var topp = pizza.toppings[k];
											   var row1col3 = row1.insertCell(2);
										       row1col3.innerHTML = topp.name;	
										   }
                                               										   
										   
										}
										// Insert New Column for Row1 at index '0'.
										var row1col4 = row1.insertCell(3);
										row1col4.innerHTML = post.totalPrice;	
								  
								  }
								 								  
								  div.appendChild(table);
				  
				     }
				  });
			  });
			  //Orders
			  
			  
        });