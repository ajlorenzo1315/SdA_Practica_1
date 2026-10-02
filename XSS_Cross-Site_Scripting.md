Sí. Si al introducir:

```html
<script>alert("HACKED!")</script>
```

en el **nombre de usuario o comentario**, guardarlo y posteriormente visualizarlo aparece una ventana `HACKED!`, ya has demostrado que **JavaScript controlado por el usuario se está ejecutando**. Si además persiste al recargar o lo ve otra sesión, es evidencia de **Stored XSS**.

Ahora haría tres cosas.

1. **Documenta la prueba**: captura el campo con el payload, la ventana `HACKED!` y la página donde se ejecuta. Anota exactamente qué campo y página utilizaste.

2. **Localiza la causa en el código**:

```bash
grep -Rni "th:utext" src/main/resources/templates
```

y, para comentarios:

```bash
grep -Rni "comment" src/main/resources/templates
```

Para nombres:

```bash
grep -RniE "user\.name|user.*name" src/main/resources/templates
```

Si encuentras, por ejemplo:

```html
<span th:utext="${comment.text}"></span>
```

es un candidato directo. Compáralo con:

```html
<span th:text="${comment.text}"></span>
```

3. **Comprueba que es almacenado**: cierra sesión, vuelve a entrar —idealmente con otro usuario— y visita el producto/perfil donde quedó almacenado. Si vuelve a aparecer `HACKED!` sin volver a introducir el payload, tienes una demostración especialmente clara del flujo:

```text
Usuario A introduce JavaScript
        ↓
Amazoncillo lo almacena
        ↓
Usuario B visita la página
        ↓
El contenido llega al navegador sin escapar
        ↓
JavaScript ejecutado
```

Para el informe, puedes describirlo como **CWE-79: Improper Neutralization of Input During Web Page Generation (Cross-site Scripting)**. La práctica pide precisamente documentar vulnerabilidad/CWE, localización, daño concreto y solución. Primera Práctica

**No lo corrijas todavía.** Pásame ahora la salida de:

```bash
grep -Rni "th:utext" src/main/resources/templates
```

y te indico cuál de esas líneas está provocando el XSS, cómo demostrar el impacto para la práctica y después cómo corregir **todas** las ocurrencias.

```bash
grep -Rni "th:utext" src/main/resources/templates
src/main/resources/templates/Cart.html:37:               <h2 th:utext="#{shopping.cart.title}" ></h2>
src/main/resources/templates/Cart.html:46:                  <span th:utext="#{shopping.cart.empty}"></span>
src/main/resources/templates/Cart.html:56:                     <span th:utext="#{shopping.cart.buy}"></span>
src/main/resources/templates/Cart.html:68:                        <th data-priority="1" th:utext="#{product.name}"></th>
src/main/resources/templates/Cart.html:69:                        <th data-priority="5" th:utext="#{product.description}"></th>
src/main/resources/templates/Cart.html:70:                        <th data-priority="4" th:utext="#{product.category}"></th>
src/main/resources/templates/Cart.html:71:                        <th data-priority="3" th:utext="#{product.rating}"></th>
src/main/resources/templates/Cart.html:72:                        <th data-priority="2" th:utext="#{product.price}"></th>
src/main/resources/templates/Cart.html:81:                           <span th:utext="${product.name}" th:title="${product.description}"></span></td>
src/main/resources/templates/Cart.html:82:                        <td th:utext="${product.description}"></td>
src/main/resources/templates/Cart.html:83:                        <td class="align-middle" th:utext="${product.category.name}"></td>
src/main/resources/templates/Cart.html:87:                        <td class="align-middle"><span th:utext="${product.price}"></span><span>&euro;</span></td>
src/main/resources/templates/ChangePassword.html:23:                           <h2 th:utext="#{change.password.title}"></h2>
src/main/resources/templates/ChangePassword.html:33:                                  th:utext="#{change.password.old.password}"></label>
src/main/resources/templates/ChangePassword.html:54:                                  th:utext="#{change.password.new.password}"></label>
src/main/resources/templates/ChangePassword.html:74:                                  th:utext="#{profile.input.password.confirm}"></label>
src/main/resources/templates/ChangePassword.html:95:                              <button type="submit" class="btn btn-primary" th:utext="#{login.button}"></button>
src/main/resources/templates/Comment.html:23:                           <h2 th:utext="#{comment.title} + ': ' + ${product.name} + ' (' + ${product.category.name} + ')'"></h2>
src/main/resources/templates/Comment.html:33:                                  th:utext="#{comment.rate}"/>
src/main/resources/templates/Comment.html:39:                           <label for="address" class="col-3 text-right" th:utext="#{comment.text}"></label>
src/main/resources/templates/Comment.html:56:                              <button type="submit" class="btn btn-primary" th:utext="#{comment.button}"></button>
src/main/resources/templates/Error.html:11:               <h2 th:utext="#{error.title}"></h2>
src/main/resources/templates/Error.html:16:            <b th:utext="#{error.page}"></b> <span th:utext="${url}"></span>
src/main/resources/templates/Error.html:19:            <b th:utext="#{error.time}"></b> <span th:utext="${timestamp}"></span>
src/main/resources/templates/Error.html:22:            <b th:utext="#{error.status}"></b> <span th:utext="${status}"></span> <span
src/main/resources/templates/Error.html:23:                th:if="${error}" th:utext="'('+${error}+')'"></span>
src/main/resources/templates/Error.html:27:            <span th:if="${errorMessage} and ${errorMessage.length() != 0}" th:utext="${errorMessage}"></span>
src/main/resources/templates/Error.html:32:               <b th:utext="#{error.cause}"></b>
src/main/resources/templates/Error.html:33:               <span th:utext="${exception}"></span>
src/main/resources/templates/Error.html:36:                  <span th:utext="${ste}" th:remove="tag">${ste}</span>
src/main/resources/templates/Error.html:40:               <b th:utext="#{error.cause}"></b>
src/main/resources/templates/Error.html:41:               <span th:utext="${exception}"></span>
src/main/resources/templates/Error.html:47:            <span th:utext="${trace}"></span>
src/main/resources/templates/Index.html:20:                        <h5 class="card-title" th:utext="${category.name}"></h5>
src/main/resources/templates/Index.html:22:                            th:utext="${category.description}"></h6>
src/main/resources/templates/layout/Messages.html:9:                  <span th:utext="${errorMessage}"></span>
src/main/resources/templates/layout/Messages.html:17:                  <span th:utext="${successMessage}"></span>
src/main/resources/templates/layout/Messages.html:25:                  <span th:utext="${warningMessage}"></span>
src/main/resources/templates/layout/Modal.html:9:                     <h5 class="modal-title" th:utext="#{confirm.title}"></h5>
src/main/resources/templates/layout/Modal.html:18:                     <button type="button" class="btn btn-primary" th:utext="#{confirm.yes}"></button>
src/main/resources/templates/layout/Modal.html:20:                             th:utext="#{confirm.no}"></button>
src/main/resources/templates/layout/NavBar.html:26:                        <span th:utext="${session['user'].name}"></span>
src/main/resources/templates/layout/NavBar.html:27:                        (<span th:utext="${session['user'].email}"></span>)
src/main/resources/templates/layout/NavBar.html:34:                        <div th:utext="#{navbar.home}"></div>
src/main/resources/templates/layout/NavBar.html:40:                        <div th:utext="#{navbar.products}"></div>
src/main/resources/templates/layout/NavBar.html:49:                        <div><span th:utext="#{navbar.cart}"></span>
src/main/resources/templates/layout/NavBar.html:50:                           (<b th:utext="${session['shoppingCart'].products.size()}"></b>)</div>
src/main/resources/templates/layout/NavBar.html:59:                        <div th:utext="#{navbar.login}"></div>
src/main/resources/templates/layout/NavBar.html:66:                        <div th:utext="#{navbar.register}"></div>
src/main/resources/templates/layout/NavBar.html:74:                        <div th:utext="#{navbar.orders}"></div>
src/main/resources/templates/layout/NavBar.html:81:                        <br/><span th:utext="#{navbar.account}"></span>
src/main/resources/templates/layout/NavBar.html:86:                           <span th:utext="#{navbar.profile}"></span></a>
src/main/resources/templates/layout/NavBar.html:89:                           <span th:utext="#{navbar.password}"></span></a>
src/main/resources/templates/layout/NavBar.html:95:                        <div th:utext="#{navbar.logout}"></div>
src/main/resources/templates/Login.html:24:                           <h2 th:utext="#{login.title}"></h2>
src/main/resources/templates/Login.html:33:                                  th:utext="#{profile.input.email}"></label>
src/main/resources/templates/Login.html:52:                                  th:utext="#{profile.input.password}"></label>
src/main/resources/templates/Login.html:76:                                 <span th:utext="#{login.remember.me}"></span>
src/main/resources/templates/Login.html:86:                                    <span th:utext="#{login.forgot.password}"></span>   
src/main/resources/templates/Login.html:95:                              <button type="submit" class="btn btn-primary" th:utext="#{login.button}"></button>
src/main/resources/templates/Order.html:46:                           <h2 th:utext="#{order.title} + ' ' + ${order.name}" ></h2>
src/main/resources/templates/Order.html:54:                        <label class="col-6 text-right" th:utext="#{order.total.price}"></label>
src/main/resources/templates/Order.html:56:                           <span th:utext="${order.price}"></span>&euro;
src/main/resources/templates/Order.html:61:                        <label class="col-6 text-right" th:utext="#{order.date}"></label>
src/main/resources/templates/Order.html:63:                           <span th:utext="${#dates.format(order.timestamp, 'yyyy-MM-dd hh:mm')}">
src/main/resources/templates/Order.html:68:                        <label for="address" class="col-6 text-right" th:utext="#{order.address}"></label>
src/main/resources/templates/Order.html:70:                           <span th:utext="${order.address}"></span>
src/main/resources/templates/Order.html:75:                        <label class="col-6 text-right" th:utext="#{order.state}"></label>
src/main/resources/templates/Order.html:89:                                 <span th:utext="#{order.pay.now}"></span>
src/main/resources/templates/Order.html:96:                                 <span th:utext="#{order.cancel}"></span>
src/main/resources/templates/Order.html:112:                        <th data-priority="1" th:utext="#{product.name}"></th>
src/main/resources/templates/Order.html:113:                        <th data-priority="5" th:utext="#{product.description}"></th>
src/main/resources/templates/Order.html:114:                        <th data-priority="4" th:utext="#{product.category}"></th>
src/main/resources/templates/Order.html:115:                        <th data-priority="3" th:utext="#{product.rating}"></th>
src/main/resources/templates/Order.html:116:                        <th data-priority="2" th:utext="#{product.price}"></th>
src/main/resources/templates/Order.html:124:                           <span th:utext="${orderLine.product.name}" 
src/main/resources/templates/Order.html:127:                        <td th:utext="${orderLine.product.description}"></td>
src/main/resources/templates/Order.html:128:                        <td class="align-middle" th:utext="${orderLine.product.category.name}"></td>
src/main/resources/templates/Order.html:132:                        <td class="align-middle"><span th:utext="${orderLine.price}"></span><span>&euro;</span></td>
src/main/resources/templates/OrderConfirm.html:39:                           <h2 th:utext="#{new.order.title}" ></h2>
src/main/resources/templates/OrderConfirm.html:48:                              <span th:utext="#{shopping.cart.empty}"></span>
src/main/resources/templates/OrderConfirm.html:62:                           <label class="col-4 text-right" th:utext="#{order.total.price}"></label>
src/main/resources/templates/OrderConfirm.html:64:                              <span th:utext="${orderForm.price}"></span>&euro;
src/main/resources/templates/OrderConfirm.html:73:                                 <span th:utext="#{order.default.address}"></span>
src/main/resources/templates/OrderConfirm.html:83:                                 <span th:utext="#{order.different.address}"></span>
src/main/resources/templates/OrderConfirm.html:88:                           <label for="address" class="col-4 text-right" th:utext="#{order.address}"></label>
src/main/resources/templates/OrderConfirm.html:107:                                 <span th:utext="#{order.buy.and.pay}"></span>
src/main/resources/templates/OrderConfirm.html:112:                                 <span th:utext="#{order.buy.and.pay.later}"></span>
src/main/resources/templates/OrderConfirm.html:129:                        <th data-priority="1" th:utext="#{product.name}"></th>
src/main/resources/templates/OrderConfirm.html:130:                        <th data-priority="5" th:utext="#{product.description}"></th>
src/main/resources/templates/OrderConfirm.html:131:                        <th data-priority="4" th:utext="#{product.category}"></th>
src/main/resources/templates/OrderConfirm.html:132:                        <th data-priority="3" th:utext="#{product.rating}"></th>
src/main/resources/templates/OrderConfirm.html:133:                        <th data-priority="2" th:utext="#{product.price}"></th>
src/main/resources/templates/OrderConfirm.html:140:                           <span th:utext="${product.name}" th:title="${product.description}"></span></td>
src/main/resources/templates/OrderConfirm.html:141:                        <td th:utext="${product.description}"></td>
src/main/resources/templates/OrderConfirm.html:142:                        <td class="align-middle" th:utext="${product.category.name}"></td>
src/main/resources/templates/OrderConfirm.html:146:                        <td class="align-middle"><span th:utext="${product.price}"></span><span>&euro;</span></td>
src/main/resources/templates/Orders.html:25:               <h2 th:utext="#{orders.title}" ></h2>
src/main/resources/templates/Orders.html:34:                  <span th:utext="#{orders.empty.table}"></span>
src/main/resources/templates/Orders.html:44:                        <th data-priority="1" th:utext="#{order.name}"></th>
src/main/resources/templates/Orders.html:45:                        <th data-priority="3" th:utext="#{order.date}"></th>
src/main/resources/templates/Orders.html:46:                        <th data-priority="2" th:utext="#{order.price}"></th>
src/main/resources/templates/Orders.html:47:                        <th data-priority="4" th:utext="#{order.state}"></th>
src/main/resources/templates/Orders.html:54:                           <span th:utext="${order.name}" ></span>
src/main/resources/templates/Orders.html:57:                           <span th:utext="${#dates.format(order.timestamp, 'yyyy-MM-dd hh:mm')}" ></span>
src/main/resources/templates/Orders.html:60:                           <span th:utext="${order.price}"></span><span>&euro;</span>
src/main/resources/templates/Payment.html:33:                           <h2 th:utext="#{new.order.title}" ></h2>
src/main/resources/templates/Payment.html:47:                                 <span th:utext="#{payment.default.card} + ' #' + 
src/main/resources/templates/Payment.html:58:                                 <span th:utext="#{payment.different.card}"></span>
src/main/resources/templates/Payment.html:83:                           <label for="cvv" class="col-4 text-right input-label-middle" th:utext="#{payment.cvv}">
src/main/resources/templates/Payment.html:101:                                  th:utext="#{payment.expiration.month}"></label>
src/main/resources/templates/Payment.html:109:                                 <option value=''  th:utext="#{month.select}"></option>
src/main/resources/templates/Payment.html:110:                                 <option value='1' th:utext="#{month.1}">January</option>
src/main/resources/templates/Payment.html:111:                                 <option value='2' th:utext="#{month.2}">February</option>
src/main/resources/templates/Payment.html:112:                                 <option value='3' th:utext="#{month.3}">March</option>
src/main/resources/templates/Payment.html:113:                                 <option value='4' th:utext="#{month.4}">April</option>
src/main/resources/templates/Payment.html:114:                                 <option value='5' th:utext="#{month.5}">May</option>
src/main/resources/templates/Payment.html:115:                                 <option value='6' th:utext="#{month.6}">June</option>
src/main/resources/templates/Payment.html:116:                                 <option value='7' th:utext="#{month.7}">July</option>
src/main/resources/templates/Payment.html:117:                                 <option value='8' th:utext="#{month.8}">August</option>
src/main/resources/templates/Payment.html:118:                                 <option value='9' th:utext="#{month.9}">September</option>
src/main/resources/templates/Payment.html:119:                                 <option value='10' th:utext="#{month.10}">October</option>
src/main/resources/templates/Payment.html:120:                                 <option value='11' th:utext="#{month.11}">November</option>
src/main/resources/templates/Payment.html:121:                                 <option value='12' th:utext="#{month.12}">December</option>
src/main/resources/templates/Payment.html:131:                                  th:utext="#{payment.expiration.year}"></label>
src/main/resources/templates/Payment.html:138:                                 <option value='' th:utext="#{year.select}"></option>
src/main/resources/templates/Payment.html:156:                                 <span th:utext="#{payment.set.as.default.card}"></span>
src/main/resources/templates/Payment.html:164:                                 <span th:utext="#{payment.pay.button}"></span>
src/main/resources/templates/Product.html:25:                            <h5 class="card-title ui-helper-margin-top" th:utext="${product.name}"></h5>
src/main/resources/templates/Product.html:26:                            <h6 class="card-subtitle mb-2 text-muted truncate" th:utext="${product.description}"></h6>
src/main/resources/templates/Product.html:28:                                <span class="font-weight-bold" th:utext="#{product.price}"></span>
src/main/resources/templates/Product.html:29:                                <span th:utext="${product.price}"></span>
src/main/resources/templates/Product.html:33:                                <span class="font-weight-bold" th:utext="#{product.total.sales}"></span>
src/main/resources/templates/Product.html:34:                                <span th:utext="${product.sales}"></span>
src/main/resources/templates/Product.html:45:                                        <span th:utext="#{product.add.to.cart}"></span>
src/main/resources/templates/Product.html:53:                                        <span th:utext="#{add.or.edit.comment.button}"></span>
src/main/resources/templates/Product.html:68:                            <span class="font-weight-bold" th:utext="${comment.user.name}"></span>
src/main/resources/templates/Product.html:74:                            <span class="font-weight-bold" th:utext="#{comment.date}"></span>
src/main/resources/templates/Product.html:75:                            <span th:utext="${#dates.format(comment.timestamp, 'yyyy-MM-dd hh:mm')}">
src/main/resources/templates/Product.html:79:                            <span th:utext="${comment.text}">
src/main/resources/templates/Products.html:51:                                 <span th:utext="${category.name}"></span>
src/main/resources/templates/Products.html:66:                        <th data-priority="1" th:utext="#{product.name}"></th>
src/main/resources/templates/Products.html:67:                        <th data-priority="5" th:utext="#{product.description}"></th>
src/main/resources/templates/Products.html:68:                        <th data-priority="4" th:utext="#{product.category}"></th>
src/main/resources/templates/Products.html:69:                        <th data-priority="3" th:utext="#{product.rating}"></th>
src/main/resources/templates/Products.html:70:                        <th data-priority="3" th:utext="#{product.total.sales}"></th>
src/main/resources/templates/Products.html:71:                        <th data-priority="2" th:utext="#{product.price}"></th>
src/main/resources/templates/Products.html:79:                           <span th:utext="${product.name}" th:title="${product.description}"></span>
src/main/resources/templates/Products.html:81:                        <td th:utext="${product.description}"></td>
src/main/resources/templates/Products.html:82:                        <td class="align-middle" th:utext="${product.category.name}"></td>
src/main/resources/templates/Products.html:86:                        <td class="align-middle"><span th:utext="${product.sales}"></span></td>
src/main/resources/templates/Products.html:87:                        <td class="align-middle"><span th:utext="${product.price}"></span><span>&euro;</span></td>
src/main/resources/templates/Profile.html:32:                           <h2 th:utext="#{registration.title}" th:if="${session['user'] == null}"></h2>
src/main/resources/templates/Profile.html:33:                           <h2 th:utext="#{edit.profile.title}" th:unless="${session['user'] == null}"></h2>
src/main/resources/templates/Profile.html:43:                                  th:utext="#{profile.input.name}"></label>
src/main/resources/templates/Profile.html:63:                                  th:utext="#{profile.input.email}"></label>
src/main/resources/templates/Profile.html:78:                                  th:utext="#{profile.input.email.tip}"></small>
src/main/resources/templates/Profile.html:87:                                  th:utext="#{profile.input.password}"></label>
src/main/resources/templates/Profile.html:106:                                  th:utext="#{profile.input.password.confirm}"></label>
src/main/resources/templates/Profile.html:124:                           <label for="address" class="col-3 text-right" th:utext="#{profile.input.address}">
src/main/resources/templates/Profile.html:140:                           <label for="image" class="col-3 text-right" th:utext="#{profile.input.image}"></label>
src/main/resources/templates/Profile.html:151:                                     th:utext="#{profile.input.image.tip}"></small>
src/main/resources/templates/Profile.html:160:                                  th:utext="#{profile.input.current.image}"></label>
src/main/resources/templates/Profile.html:178:                                      th:utext="#{registration.button}"></button>
src/main/resources/templates/Profile.html:180:                                      th:utext="#{edit.profile.button}"></button>
src/main/resources/templates/ResetPassword.html:23:                           <h2 th:utext="#{reset.password.title}"></h2>
src/main/resources/templates/ResetPassword.html:38:                                  th:utext="#{reset.password.new.password}"></label>
src/main/resources/templates/ResetPassword.html:58:                                  th:utext="#{profile.input.password.confirm}"></label>
src/main/resources/templates/ResetPassword.html:79:                              <button type="submit" class="btn btn-primary" th:utext="#{reset.password.button}">
src/main/resources/templates/SendEmail.html:24:                           <h2 th:utext="#{send.email.title}"></h2>
src/main/resources/templates/SendEmail.html:33:                                  th:utext="#{profile.input.email}"></label>
src/main/resources/templates/SendEmail.html:55:                                 <span th:utext="#{send.email.button}"></span>

```


Ahí ya aparece la causa del XSS que acabas de demostrar. En `Product.html` tienes exactamente estas dos salidas controlables:

```html
Product.html:68
<span class="font-weight-bold" th:utext="${comment.user.name}"></span>

Product.html:79
<span th:utext="${comment.text}">
```

Como has comprobado que aparece `alert("HACKED!")`, ya no estamos ante un simple candidato: **esas rutas de salida permiten interpretar contenido almacenado como HTML/JavaScript**.

### Qué has encontrado

Tienes al menos dos vectores muy claros en la página del producto:

```text
Nombre del usuario
      ↓
comment.user.name
      ↓
th:utext
      ↓
JavaScript ejecutado
```

y:

```text
Texto del comentario
      ↓
comment.text
      ↓
th:utext
      ↓
JavaScript ejecutado
```

Esto es **Stored XSS / Persistent XSS (CWE-79)** si el payload queda almacenado y se ejecuta posteriormente cuando se visita el producto.

### Haz una prueba definitiva

Pon como **nombre de usuario**:

```html
<script>alert("XSS-NOMBRE")</script>
```

Y como **comentario**:

```html
<script>alert("XSS-COMENTARIO")</script>
```

Después visita el producto.

Así puedes identificar inmediatamente cuál de los dos puntos está ejecutándose.

Después **cierra sesión e inicia sesión con otro usuario** y visita ese mismo producto. Si aparece el `alert` sin introducir de nuevo el payload, tienes una demostración muy buena de Stored XSS.

### Pero no cambies todos los `th:utext` a ciegas

Esto es importante.

Tienes muchos:

```html
th:utext="#{product.name}"
th:utext="#{navbar.home}"
th:utext="#{login.button}"
```

Esos `#{...}` son mensajes internos/internacionalización y no equivalen automáticamente a una entrada controlada por un atacante.

Nos interesan especialmente expresiones `${...}` cuyo valor pueda proceder de usuarios o de datos modificables.

En tu salida hay varios candidatos importantes además de los comentarios:

```text
NavBar.html
${session['user'].name}
${session['user'].email}

Product.html
${comment.user.name}
${comment.text}

Order.html
${order.name}
${order.address}

Orders.html
${order.name}

Error.html
${url}
${errorMessage}
${exception}
${trace}

Cart/Products/Order...
${product.name}
${product.description}
${product.category.name}
```

No podemos afirmar todavía que todos sean explotables. Hay que determinar quién puede controlar cada valor.

### La corrección de los dos que ya has demostrado

Para datos que deben mostrarse como texto, cambia:

```html
<span th:utext="${comment.user.name}"></span>
```

por:

```html
<span th:text="${comment.user.name}"></span>
```

Y:

```html
<span th:utext="${comment.text}"></span>
```

por:

```html
<span th:text="${comment.text}"></span>
```

La diferencia conceptual es:

```text
th:utext
<script>alert("HACKED!")</script>
            ↓
       interpreta HTML
            ↓
        💥 JavaScript


th:text
<script>alert("HACKED!")</script>
            ↓
        escapa HTML
            ↓
<script>alert("HACKED!")</script>
     aparece como TEXTO
```

Después de corregirlo, **repite exactamente la misma prueba**. El resultado correcto será ver literalmente:

```text
<script>alert("HACKED!")</script>
```

y **no** debe aparecer ninguna ventana.

Pero antes de corregir quiero que encontremos **todas las salidas potencialmente controlables**, porque vuestra práctica exige corregir todas las ocurrencias de una vulnerabilidad para obtener la puntuación completa. Primera Práctica

Haz ahora este filtro, que nos quitará gran parte del ruido de `#{...}`:

```bash
grep -Rni 'th:utext="${' src/main/resources/templates
```

Pásame esa salida. La clasificamos una por una en **controlable / no controlable / necesita investigación**, y así sacamos la lista completa de XSS sin reportar falsos positivos.


La vulnerabilidad que acabas de comprobar es **XSS (Cross-Site Scripting)**, concretamente **Stored XSS (XSS almacenado/persistente)** si el nombre o comentario queda guardado y se ejecuta posteriormente.

### ¿En qué consiste?

La aplicación permite que un usuario introduzca contenido, por ejemplo:

```html
<script>alert("HACKED!")</script>
```

Ese contenido se almacena como nombre de usuario o comentario. El problema aparece después, cuando `Product.html` lo muestra usando:

```html
<span th:utext="${comment.user.name}"></span>
```

o:

```html
<span th:utext="${comment.text}"></span>
```

`th:utext` hace que el contenido se inserte como **HTML sin escapar**. Por tanto, el navegador no lo trata simplemente como texto: puede interpretarlo como HTML y ejecutar JavaScript.

El flujo es:

```text
Atacante
   │
   │ introduce código HTML/JavaScript
   ▼
<script>alert("HACKED!")</script>
   │
   ▼
Amazoncillo lo almacena
   │
   ▼
Otro usuario visita el producto
   │
   ▼
th:utext muestra el contenido sin escapar
   │
   ▼
El navegador interpreta <script>
   │
   ▼
JavaScript ejecutado en el navegador de la víctima
```

### ¿Por qué `alert("HACKED!")` es importante?

La ventana `HACKED!` **no es el daño real**. Solo es una prueba sencilla de que has conseguido ejecutar JavaScript.

Lo importante es que, si:

```javascript
alert("HACKED!")
```

se ejecuta, entonces el atacante ha conseguido que **su JavaScript se ejecute en el contexto de la aplicación web**.

Eso puede tener consecuencias mucho más serias: modificar el contenido de la página, realizar acciones usando la sesión de la víctima mediante peticiones desde la aplicación, mostrar formularios falsos, redirigir al usuario, leer información del DOM accesible al JavaScript o intentar acceder a credenciales/tokens que estén expuestos al código de la página. Las cookies marcadas `HttpOnly` no pueden ser leídas directamente mediante JavaScript, por lo que el impacto concreto depende también de cómo estén configuradas las cookies y la aplicación.

### ¿Por qué en vuestro caso es especialmente grave?

Porque parece ser **almacenado**.

Un XSS reflejado normalmente necesita que la víctima abra una petición preparada. En vuestro caso:

```text
Atacante publica comentario malicioso
             ↓
        BD Amazoncillo
             ↓
Usuario A visita producto → ejecución
Usuario B visita producto → ejecución
Usuario C visita producto → ejecución
```

El atacante no necesita volver a enviar el payload a cada víctima; permanece almacenado hasta que el contenido sea eliminado o modificado.

Por eso deberías hacer la prueba que comentábamos: guardar el comentario, cerrar sesión, entrar con otro usuario y visitar el producto. Si vuelve a aparecer `HACKED!`, tienes una demostración clara de persistencia.

### ¿Cuál es el error de programación?

No es simplemente «permitir `<script>` en un formulario». El problema fundamental está en **cómo se representa una entrada no confiable**.

Actualmente:

```html
<span th:utext="${comment.text}"></span>
```

Para un comentario:

```html
<script>alert("HACKED!")</script>
```

el resultado puede convertirse en HTML ejecutable.

Para contenido que debe ser texto, debería escaparse, por ejemplo con:

```html
<span th:text="${comment.text}"></span>
```

De esta manera, el navegador debería recibir una representación escapada equivalente a:

```html
&lt;script&gt;alert("HACKED!")&lt;/script&gt;
```

y mostrar:

```text
<script>alert("HACKED!")</script>
```

sin ejecutarlo.

### Para vuestro informe

Puedes describirla aproximadamente así:

> **Vulnerabilidad:** Stored Cross-Site Scripting (XSS)  
> **CWE:** CWE-79 – Improper Neutralization of Input During Web Page Generation.  
> **Descripción:** La aplicación permite almacenar datos controlados por el usuario, como el nombre y el contenido de los comentarios. Posteriormente estos valores se representan mediante `th:utext`, por lo que su contenido HTML no se escapa. Esto permite almacenar código HTML/JavaScript que será interpretado por el navegador cuando un usuario visite la página afectada.  
> **Prueba:** Se introduce `<script>alert("HACKED!")</script>` y, al visualizar posteriormente el contenido, el navegador ejecuta el código y muestra `HACKED!`. Si persiste tras recargar o en otra sesión, se confirma el carácter almacenado de la vulnerabilidad.  
> **Impacto:** Un atacante puede conseguir que JavaScript controlado por él se ejecute en el navegador de otros usuarios que visualicen el contenido afectado.  
> **Solución:** Aplicar codificación de salida adecuada al contexto; para estos valores textuales en Thymeleaf, sustituir el uso inseguro de `th:utext` por `th:text` y revisar todas las demás salidas de datos controlables.

Esto encaja con lo que exige vuestra práctica: indicar vulnerabilidad/CWE, localización, consecuencias y solución concreta. Primera Práctica

Y hay un detalle importante para la práctica: **el XSS puede ser una vulnerabilidad y, además, formar parte de uno de los tres exploits** si lo combinas con otra clase de vulnerabilidad para producir un daño concreto; el enunciado exige que cada exploit combine al menos dos tipos. Primera Práctica