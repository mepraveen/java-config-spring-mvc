$(document).ready(function(){  
              $(".username").change(function(){  
                  var username = $(this).val();  
                  if(username.length >= 6){  
                      $(".status").html("<img src='./resources/core/images/loading.gif'><font color=gray> Checking availability...</font>");  
                       $.ajax({  
                          type: "GET",  
                          url: "http://localhost:8080/java-config/check/"+username,  
                          data: "username="+ username,  
                          success: function(msg){  
  
                              $(".status").ajaxComplete(function(event, request, settings){  
                            	  
                            	  if(msg=="true"){
                            		  $(".status").html("<font color=green> Aviable </font>");  
                            	  }else{
                            		  
                            		  $(".status").html("<font color=red> Not Aviable </font>"); 
                            	  }
                              
  
                              });  
                          }  
                      });   
                  }  
                  else{  
                         
                      $(".status").html("<font color=red>Username should be <b>6</b> character long.</font>");  
                  }  
                    
              });  
          }); 