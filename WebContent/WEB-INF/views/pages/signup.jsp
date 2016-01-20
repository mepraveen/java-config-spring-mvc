<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<%@ include file="/WEB-INF/views/templates/header.jsp" %>
<script src="<c:url value="/resources/core/js/jquery-1.2.6.min.js"/>"></script>
<script src="<c:url value="/resources/core/js/validate.js" />"></script>
<script src="<c:url value="/resources/core/js/usernameaviablity.js" />"></script>


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
	<li class=""><a href="examples">Examples</a></li>
	<li><a href="#">Products</a></li>
	<li><a href="#">Solutions</a></li>
	<li class="selected"><a href="login">log In</a></li>
	<li class="end"><a href="#">Contact</a></li>
</ul>
	</div>
    </nav>

    <div id="body" class="width">
		
        <section id="content">

	    <article>
	   
        
            
            <h3>New Account</h3>
            
            <%-- <h1><spring:message code="label.details"/></h1> --%>
          	<form:errors path="signup1.*"/>

           <%@ include file="/WEB-INF/views/templates/signUpTemp.jsp" %>
           
            
      		</article>
        </section>
        
       
    	<div class="clear"></div>
    </div>
    <%@ include file="/WEB-INF/views/templates/footer.jsp" %>
</div>



</body>
</html>
