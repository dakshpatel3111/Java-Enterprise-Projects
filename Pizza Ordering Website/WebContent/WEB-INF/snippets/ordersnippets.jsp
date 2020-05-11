<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="true" %>
    
		 <h1>Welcome ${user.name} to Online Pizza  Ordering App </h1>
		 
         <hr> 
           <c:choose>
   <c:when test="${param.msg!=null}">
  <h3 style='color:red;'> ${param.msg }</h3> 
   </c:when>
</c:choose>
         
         
 <div class="flex-container">
        
      
         
 
         <hr> 
      <div class="flex-box"> 
         <form method='Post' action='OrderPage'> 
      
         <center><h2>Add a Pizza</h2></center> 
       <hr>
         <center><h2>Select Size</h2></center> 
         <div class=sizebox>
         <input type='radio' name='size' value='small'> 
         <label for='small'>Small</label> 
        
         <input type='radio' name='size' value='medium'> 
         <label for='medium'>Medium</label> 
        
         <input type='radio' name='size' value='large' checked> 
         <label for='large'>Large</label> 
        
         <input type='radio' name='size' value='extralarge'> 
         <label for='extralarge'>ExtraLarge</label><br> 
		</div>
      
         <br>
         <hr>
         <center>
         
         
     
         <h2>Add Topppings</h2>
         </center>
         
         <br> 
	    
        
          
         <input type='checkbox' name='toppings' value='Pepperoni' > 
         <label for='Pepperoni'>Pepperoni</label><br> 
		
        
         <input type='checkbox' name='toppings' value='Sausage'>
         <label for='Sausage'>Sausage</label><br> 
		
         <input type='checkbox' name='toppings' value='Mushrooms'>
         <label for='Mushrooms'>Mushrooms</label><br> 
        
         <input type='checkbox' name='toppings' value='Anchovies' checked>  
         <label for='Anchovies'>Anchovies</label><br> 
        
        
        
         <input type='checkbox' name='toppings' value='GreenOlives'>  
         <label for='GreenOlives'>GreenOlives</label><br> 
        
        
         <input type='checkbox' name='toppings' value='BlackOlives' > 
         <label for='BlackOlives'>BlackOlives</label><br> 
        
       
         <input type='checkbox' name='toppings' value='GreenPepper' checked > 
         <label for='GreenPepper'>GreenPepper</label><br> 
        
        
       
         <input type='checkbox' name='toppings' value='HotPepper' > 
         <label for='HotPepper'>HotPepper</label><br> 
        
        
         <input type='checkbox' name='toppings' value='ExtraCheese' > 
         <label for='ExtraCheese'>ExtraCheese</label><br> 
      
         <input type='checkbox' name='toppings' value='ExtraSause' checked> 
         <label for='ExtraSauce'>ExtraSauce</label><br> 
     </div>
     


<div class="flex-box">
<img src="piz.jpg" class="imagebox">

</div>
  
  </div>
         <hr>
         <input type='submit' value='Proceed to Checkout' class="button">
         
         
         
         
        
         </form> 
        