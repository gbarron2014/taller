<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="products">
     <c:forEach items="${productos}" var="producto">
         <div class="col-md-4" style="text-align:center">
             <p>${producto.name}</p>
             <img src="..." alt="..." class="img-thumbnail">
             <p>${producto.type}</p>
             <p>$ ${producto.price}</p>
         </div>
     </c:forEach>
</div>