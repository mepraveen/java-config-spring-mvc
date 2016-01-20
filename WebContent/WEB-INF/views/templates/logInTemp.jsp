<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

            
            <fieldset>
                <legend>Detail </legend>
                <form name="f2" id ="login" action="/java-config/login" method="post" >
                   
                    <p><label for="usernameOrEmail">Email:</label>
                    <input name="usernameOrEmail" id="email" value="" type="text" />
                    <span id="usernameOrEmailloc"></span></p>
                    
                                      
                     <p><label for="password">Password:</label>
                    <input name="password" id="password" value="" type="password" />
                    <span id="passwordloc"></span></p>       
                
                                      
                     <p><input name="send" style="margin-left: 150px;" class="formbutton" value="submit" type="submit" /></p>
               <p><a href="#" style="margin-left: 0px;"> Forgot Password</a>
               
               <p><a href="/java-config/signup" style="margin-left: 0px;"> Create a new Account</a></p>
                    
                                          
                     

                     
                </form>
            </fieldset>
            
            
            
