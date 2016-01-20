<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   
   

       <fieldset>
                <legend>Detail </legend>
                <form name="f1" id="signup" action="/java-config/submit" method="post" onsubmit="return validate()">
                   
                    <p><label for="email">Email or Username:</label>
                    <input name="email" id="email" value="" type="text" />
                    <span id="emailloc"></span></p>
                    
                                      
                   <p> <label for ="username">Username :</label>
                     <input name="username" id ="username" class="username" value="" type="text"> 
                     <span  id="usernameloc" class="status"></span> </p>
                                                              
                    
                     <p><label for="password">Password:</label>
                    <input name="password" id="password" value="" type="password" />
                    <span id="passwordloc"></span></p>       
                
                    <p><label for="repassword">Confrom Password:</label>
                    <input name="repassword" id="repassword" value="" type="password" />
                    <span id="repasswordloc"></span></p>    
                    
                     <p><input name="send" style="margin-left: 150px;" class="formbutton" value="create account" type="submit" /></p>
                     
                  
                     
                </form>
            </fieldset>
            
             