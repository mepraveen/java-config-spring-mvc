<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<%@ include file="/WEB-INF/views/templates/header.jsp" %>
<body>
<div id="container">
  <header>
	<div class="width">
    		<h1><a href="/">sophi<span>ncell</span></a></h1>
       		 <h2>Here for nepal examples</h2>
	</div>
    </header>
    <nav>
	<div class="width">
  		
  		 <ul>
	<li class="start"><a href="index">Home</a></li>
	<li class="selected"><a href="examples">Examples</a></li>
	<li><a href="#">Products</a></li>
	<li><a href="#">Solutions</a></li>
	<li class=""><a href="login">log In</a></li>
	<li class="end"><a href="#">Contact</a></li>
</ul>
	</div>
    </nav>

    <div id="body" class="width">
		
        <section id="content">

	    <article>
	    <h2>Examples</h2>

            <h1>Heading H1</h1>
            <h2>Heading H2</h2>
            <h3>Heading H3</h3>
            <h4>Heading H4</h4>
            <h5>Heading H5</h5>
            
            
            <p>&nbsp;</p>

            
            <h3>Lists</h3>
            <ul>
                <li>List item</li>
                <li>List item</li>
                <li>List item</li>
            </ul>
                    
            <ol>
                <li>List item</li>
                <li>List item</li>
                <li>List item</li>
            </ol>

            <p>&nbsp;</p>

            
                
            <h3>Code and blockquote</h3>
            <code>&lt;? echo('Hello world'); ?&gt;</code>

            <blockquote><p>Mauris sit amet tortor in urna tincidunt aliquam. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas</p></blockquote>

            
            <p>&nbsp;</p>           
            
            <h3>Table</h3>

            <table cellspacing="0">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Age</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>John Smith</td>
                    <td>28</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>Fred James</td>
                    <td>49</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>Rachel Johnson</td>
                    <td>19</td>
                </tr>

            </table>

            <p>&nbsp;</p>

            
            <h3>Form</h3>

            <fieldset>
                <legend>Form legend</legend>
                <form action="#" method="get">
                    <p><label for="name">Name:</label>
                    <input name="name" id="name" value="" type="text" /></p>
                    <p><label for="email">Email:</label>
                    <input name="email" id="email" value="" type="text" /></p>

                    <p><label for="message">Message:</label>
                    <textarea cols="37" rows="11" name="message" id="message"></textarea></p>
                    <p><input name="send" style="margin-left: 150px;" class="formbutton" value="Send" type="submit" /></p>
                </form>
            </fieldset>
            
      		</article>
        </section>
        
        <aside class="sidebar">

           <ul>	
               <li>
                    <h4>Categories</h4>
                    <ul>
                        <li><a href="index.html">Home Page</a></li>
                        <li><a href="examples.html">Style Examples</a></li>
                        <li><a href="#">Commodo vestibulum sem mattis</a></li>
                        <li><a href="#">Sed aliquam libero ut velit bibendum</a></li>
                        <li><a href="#">Maecenas condimentum velit vitae</a></li>
                    </ul>
                </li>
                
                <li>
                    <h4>About us</h4>
                    <ul>
                        <li class="text">
                        	<p style="margin: 0;">Aenean nec massa a tortor auctor sodales sed a dolor. Duis vitae lorem sem. Proin at velit vel arcu pretium luctus. <a href="#" class="readmore">Read More &raquo;</a></p>
                        </li>
                    </ul>
                </li>
                
                <li>
                	<h4>Search site</h4>
                    <ul>
                    	<li class="text">
                            <form method="get" class="searchform" action="#" >
                                <p>
                                    <input type="text" size="32" value="" name="s" class="s" />
                                    
                                </p>
                            </form>	
						</li>
					</ul>
                </li>
                
                <li>
                    <h4>Helpful Links</h4>
                    <ul>
                        <li><a href="http://www.themeforest.net/?ref=spykawg" title="premium templates">Premium HTML web templates from $10</a></li>
                        <li><a href="http://www.dreamhost.com/r.cgi?259541" title="web hosting">Cheap web hosting from Dreamhost</a></li>
                        <li><a href="http://tuxthemes.com" title="Tux Themes">Premium WordPress themes</a></li>
                    </ul>
                </li>
                
            </ul>
		
        </aside>
    	<div class="clear"></div>
    </div>
    <%@ include file="/WEB-INF/views/templates/footer.jsp" %>
</div>
</body>
</html>
