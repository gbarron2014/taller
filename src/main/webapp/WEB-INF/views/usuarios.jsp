<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="products">
     <c:forEach items="${usuarios}" var="usuario">
         <div class="col-md-4" style="text-align:center">
             <p>${usuario.correo}</p>
             <img src="..." alt="..." class="img-thumbnail">
             <p>${usuario.password}</p>
         </div>
     </c:forEach>
</div>