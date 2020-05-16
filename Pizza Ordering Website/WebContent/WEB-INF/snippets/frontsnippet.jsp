 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
         <h1>Welcome to Online Pizza Ordering System</h1> 
         <h3>Developed and Managed by Daksh Patel</h3> 
         <hr> 
         <form method='Post' action='FrontDoor' > 
        <c:choose>
   <c:when test="${param.msg!=null}">
  <h3 style='color:red;'> ${param.msg }</h3> 
   </c:when>
</c:choose>
  <div class="flex-container">
       
       <div class="flex-box">
       <center>
         Name :<input type=text name=uname ><br><br> 
         Phone Number : <input  type=text name=phone><br><br> 
         Email : <input  type=text name=email ><br><br> 
         Address : <input type=text name=address ><br><br>  
         
         
         
          <input type='radio' name='ordertype' value='pickup'> 
         <label for='pickup'>Pickup</label> 
         
          <input type='radio' name='ordertype' value='delivery'> 
         <label for='delivery'>Delivery</label> <br>
         <br>
        
         <input type='submit' value='Submit' class="button"> 
           </center>
         
         
         </form>
        </div>
  
        <div class="flex-box">
      <img src="piz.jpg" class="imagebox">
        </div>
        
 </div>
       
