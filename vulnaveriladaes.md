```bash

root@alixia:~/git/Ciberseguridad_Munics/app/practica_1/store-app# grep -Rni "java.sql" src/main/java
root@alixia:~/git/Ciberseguridad_Munics/app/practica_1/store-app# grep -Rni "createQuery" src/main/java
src/main/java/es/storeapp/business/repositories/AbstractRepository.java:68:        Query query = entityManager.createQuery(MessageFormat.format(FIND_ALL_QUERY, 
src/main/java/es/storeapp/business/repositories/AbstractRepository.java:75:        Query query = entityManager.createQuery(MessageFormat.format(FIND_ALL_ORDERED_QUERY, 
src/main/java/es/storeapp/business/repositories/AbstractRepository.java:82:        Query query = entityManager.createQuery(MessageFormat.format(FIND_BY_TEXT_ATTRIBUTE_QUERY, 
src/main/java/es/storeapp/business/repositories/CategoryRepository.java:15:        Query query = entityManager.createQuery(FIND_HIGHLIGHTED_QUERY);
src/main/java/es/storeapp/business/repositories/CommentRepository.java:18:        Query query = entityManager.createQuery(MessageFormat
src/main/java/es/storeapp/business/repositories/CommentRepository.java:24:        Query query = entityManager.createQuery(MessageFormat
src/main/java/es/storeapp/business/repositories/OrderLineRepository.java:17:        Query query = entityManager.createQuery(MessageFormat.format(FIND_BY_USER_AND_PRODUCT_QUERY, userId, productId));
src/main/java/es/storeapp/business/repositories/OrderRepository.java:16:        Query query = entityManager.createQuery(MessageFormat.format(FIND_BY_USER_QUERY, userId));
src/main/java/es/storeapp/business/repositories/ProductRepository.java:17:        Query query = entityManager.createQuery(MessageFormat.format(FIND_BY_CATEGORY_QUERY, 
src/main/java/es/storeapp/business/repositories/UserRepository.java:18:            Query query = entityManager.createQuery(MessageFormat.format(FIND_USER_BY_EMAIL_QUERY, email));
src/main/java/es/storeapp/business/repositories/UserRepository.java:27:        Query query = entityManager.createQuery(MessageFormat.format(COUNT_USER_BY_EMAIL_QUERY, email));
src/main/java/es/storeapp/business/repositories/UserRepository.java:33:            Query query = entityManager.createQuery(MessageFormat.format(LOGIN_QUERY, email, password));
root@alixia:~/git/Ciberseguridad_Munics/app/practica_1/store-app# grep -RniE "createQuery|createNativeQuery|executeQuery|executeUpdate|prepareStatement|createStatement" src/main/java
src/main/java/es/storeapp/business/repositories/AbstractRepository.java:68:        Query query = entityManager.createQuery(MessageFormat.format(FIND_ALL_QUERY, 
src/main/java/es/storeapp/business/repositories/AbstractRepository.java:75:        Query query = entityManager.createQuery(MessageFormat.format(FIND_ALL_ORDERED_QUERY, 
src/main/java/es/storeapp/business/repositories/AbstractRepository.java:82:        Query query = entityManager.createQuery(MessageFormat.format(FIND_BY_TEXT_ATTRIBUTE_QUERY, 
src/main/java/es/storeapp/business/repositories/CategoryRepository.java:15:        Query query = entityManager.createQuery(FIND_HIGHLIGHTED_QUERY);
src/main/java/es/storeapp/business/repositories/CommentRepository.java:18:        Query query = entityManager.createQuery(MessageFormat
src/main/java/es/storeapp/business/repositories/CommentRepository.java:24:        Query query = entityManager.createQuery(MessageFormat
src/main/java/es/storeapp/business/repositories/OrderLineRepository.java:17:        Query query = entityManager.createQuery(MessageFormat.format(FIND_BY_USER_AND_PRODUCT_QUERY, userId, productId));
src/main/java/es/storeapp/business/repositories/OrderRepository.java:16:        Query query = entityManager.createQuery(MessageFormat.format(FIND_BY_USER_QUERY, userId));
src/main/java/es/storeapp/business/repositories/ProductRepository.java:17:        Query query = entityManager.createQuery(MessageFormat.format(FIND_BY_CATEGORY_QUERY, 
src/main/java/es/storeapp/business/repositories/UserRepository.java:18:            Query query = entityManager.createQuery(MessageFormat.format(FIND_USER_BY_EMAIL_QUERY, email));
src/main/java/es/storeapp/business/repositories/UserRepository.java:27:        Query query = entityManager.createQuery(MessageFormat.format(COUNT_USER_BY_EMAIL_QUERY, email));
src/main/java/es/storeapp/business/repositories/UserRepository.java:33:            Query query = entityManager.createQuery(MessageFormat.format(LOGIN_QUERY, email, password));
root@alixia:~/git/Ciberseguridad_Munics/app/practica_1/store-app# grep -RniE "createQuery|createNativeQuery|executeQuery|executeUpdate|prepareStatement|createStatement" src/main/java
src/main/java/es/storeapp/business/repositories/AbstractRepository.java:68:        Query query = entityManager.createQuery(MessageFormat.format(FIND_ALL_QUERY, 
src/main/java/es/storeapp/business/repositories/AbstractRepository.java:75:        Query query = entityManager.createQuery(MessageFormat.format(FIND_ALL_ORDERED_QUERY, 
src/main/java/es/storeapp/business/repositories/AbstractRepository.java:82:        Query query = entityManager.createQuery(MessageFormat.format(FIND_BY_TEXT_ATTRIBUTE_QUERY, 
src/main/java/es/storeapp/business/repositories/CategoryRepository.java:15:        Query query = entityManager.createQuery(FIND_HIGHLIGHTED_QUERY);
src/main/java/es/storeapp/business/repositories/CommentRepository.java:18:        Query query = entityManager.createQuery(MessageFormat
src/main/java/es/storeapp/business/repositories/CommentRepository.java:24:        Query query = entityManager.createQuery(MessageFormat
src/main/java/es/storeapp/business/repositories/OrderLineRepository.java:17:        Query query = entityManager.createQuery(MessageFormat.format(FIND_BY_USER_AND_PRODUCT_QUERY, userId, productId));
src/main/java/es/storeapp/business/repositories/OrderRepository.java:16:        Query query = entityManager.createQuery(MessageFormat.format(FIND_BY_USER_QUERY, userId));
src/main/java/es/storeapp/business/repositories/ProductRepository.java:17:        Query query = entityManager.createQuery(MessageFormat.format(FIND_BY_CATEGORY_QUERY, 
src/main/java/es/storeapp/business/repositories/UserRepository.java:18:            Query query = entityManager.createQuery(MessageFormat.format(FIND_USER_BY_EMAIL_QUERY, email));
src/main/java/es/storeapp/business/repositories/UserRepository.java:27:        Query query = entityManager.createQuery(MessageFormat.format(COUNT_USER_BY_EMAIL_QUERY, email));
src/main/java/es/storeapp/business/repositories/UserRepository.java:33:            Query query = entityManager.createQuery(MessageFormat.format(LOGIN_QUERY, email, password));
root@alixia:~/git/Ciberseguridad_Munics/app/practica_1/store-app# grep -RniE "MessageFormat|String\.format" src/main/java
src/main/java/es/storeapp/business/entities/Category.java:73:        return String.format("Category{categoryId=%s, name=%s, description=%s, icon=%s, highlighted=%s}", 
src/main/java/es/storeapp/business/entities/Comment.java:93:        return String.format("Comment{commentId=%s, text=%s, rating=%s, timestamp=%s, user=%s, product=%s}", 
src/main/java/es/storeapp/business/entities/CreditCard.java:4:import java.text.MessageFormat;
src/main/java/es/storeapp/business/entities/CreditCard.java:52:        return MessageFormat.format("CreditCard{card={0}, cvv={1}, expirationMonth={2}, expirationYear={3}}", 
src/main/java/es/storeapp/business/entities/Order.java:108:        return String.format("Order{orderId=%s, name=%s, timestamp=%s, price=%s, address=%s, state=%s, user=%s, orderLines=%s}", 
src/main/java/es/storeapp/business/entities/OrderLine.java:5:import java.text.MessageFormat;
src/main/java/es/storeapp/business/entities/OrderLine.java:71:        return MessageFormat.format("OrderLine{orderLineId={0}, price={1}, product={2}, order={3}}", 
src/main/java/es/storeapp/business/entities/Product.java:138:        return String.format("Product{productId=%s, category=%s, name=%s, description=%s, icon=%s, price=%s, totalScore=%s, totalComments=%s, sales=%s}", 
src/main/java/es/storeapp/business/entities/User.java:143:        return String.format("User{userId=%s, name=%s, email=%s, password=%s, address=%s, resetPasswordToken=%s, card=%s, image=%s}", 
src/main/java/es/storeapp/business/repositories/AbstractRepository.java:6:import java.text.MessageFormat;
src/main/java/es/storeapp/business/repositories/AbstractRepository.java:68:        Query query = entityManager.createQuery(MessageFormat.format(FIND_ALL_QUERY, 
src/main/java/es/storeapp/business/repositories/AbstractRepository.java:75:        Query query = entityManager.createQuery(MessageFormat.format(FIND_ALL_ORDERED_QUERY, 
src/main/java/es/storeapp/business/repositories/AbstractRepository.java:82:        Query query = entityManager.createQuery(MessageFormat.format(FIND_BY_TEXT_ATTRIBUTE_QUERY, 
src/main/java/es/storeapp/business/repositories/CommentRepository.java:4:import java.text.MessageFormat;
src/main/java/es/storeapp/business/repositories/CommentRepository.java:18:        Query query = entityManager.createQuery(MessageFormat
src/main/java/es/storeapp/business/repositories/CommentRepository.java:24:        Query query = entityManager.createQuery(MessageFormat
src/main/java/es/storeapp/business/repositories/OrderLineRepository.java:4:import java.text.MessageFormat;
src/main/java/es/storeapp/business/repositories/OrderLineRepository.java:17:        Query query = entityManager.createQuery(MessageFormat.format(FIND_BY_USER_AND_PRODUCT_QUERY, userId, productId));
src/main/java/es/storeapp/business/repositories/OrderRepository.java:4:import java.text.MessageFormat;
src/main/java/es/storeapp/business/repositories/OrderRepository.java:16:        Query query = entityManager.createQuery(MessageFormat.format(FIND_BY_USER_QUERY, userId));
src/main/java/es/storeapp/business/repositories/ProductRepository.java:4:import java.text.MessageFormat;
src/main/java/es/storeapp/business/repositories/ProductRepository.java:17:        Query query = entityManager.createQuery(MessageFormat.format(FIND_BY_CATEGORY_QUERY, 
src/main/java/es/storeapp/business/repositories/UserRepository.java:4:import java.text.MessageFormat;
src/main/java/es/storeapp/business/repositories/UserRepository.java:18:            Query query = entityManager.createQuery(MessageFormat.format(FIND_USER_BY_EMAIL_QUERY, email));
src/main/java/es/storeapp/business/repositories/UserRepository.java:27:        Query query = entityManager.createQuery(MessageFormat.format(COUNT_USER_BY_EMAIL_QUERY, email));
src/main/java/es/storeapp/business/repositories/UserRepository.java:33:            Query query = entityManager.createQuery(MessageFormat.format(LOGIN_QUERY, email, password));
src/main/java/es/storeapp/business/services/OrderService.java:17:import java.text.MessageFormat;
src/main/java/es/storeapp/business/services/OrderService.java:75:                logger.warn(MessageFormat.format("Trying to pay the order {0}", order));
src/main/java/es/storeapp/business/services/OrderService.java:107:            logger.debug(MessageFormat.format("Searching the orders of the user {0}", user.getEmail()));
src/main/java/es/storeapp/business/services/OrderService.java:121:            logger.debug(MessageFormat.format("Checking if user {0} buy the product {1}", 
src/main/java/es/storeapp/business/services/ProductService.java:14:import java.text.MessageFormat;
src/main/java/es/storeapp/business/services/ProductService.java:78:                logger.debug(MessageFormat.format("Searching if the user {0} has commented the product {1}", 
src/main/java/es/storeapp/business/services/ProductService.java:94:                logger.debug(MessageFormat.format("{0} has modified his comment of the product {1}", 
src/main/java/es/storeapp/business/services/ProductService.java:105:                logger.debug(MessageFormat.format("{0} created a comment of the product {1}", 
src/main/java/es/storeapp/web/controller/CommentController.java:10:import java.text.MessageFormat;
src/main/java/es/storeapp/web/controller/CommentController.java:56:                    logger.debug(MessageFormat.format("Loading previous comment {0}", commentForm));
src/main/java/es/storeapp/web/controller/CommentController.java:76:            return Constants.SEND_REDIRECT + MessageFormat.format(Constants.PRODUCT_TEMPLATE,
src/main/java/es/storeapp/web/controller/HomeController.java:6:import java.text.MessageFormat;
src/main/java/es/storeapp/web/controller/HomeController.java:29:            logger.debug(MessageFormat.format("Home categories: {0}", categories));
src/main/java/es/storeapp/web/controller/OrderController.java:15:import java.text.MessageFormat;
src/main/java/es/storeapp/web/controller/OrderController.java:109:            logger.debug(MessageFormat.format("Go to complete order page {0}", orderForm.getName()));
src/main/java/es/storeapp/web/controller/OrderController.java:140:            return Constants.SEND_REDIRECT + MessageFormat.format(Constants.ORDER_PAYMENT_ENDPOINT_TEMPLATE, 
src/main/java/es/storeapp/web/controller/OrderController.java:178:        return Constants.SEND_REDIRECT + MessageFormat.format(Constants.ORDER_ENDPOINT_TEMPLATE, order.getOrderId());
src/main/java/es/storeapp/web/controller/OrderController.java:196:        return Constants.SEND_REDIRECT + MessageFormat.format(Constants.ORDER_ENDPOINT_TEMPLATE, order.getOrderId());
src/main/java/es/storeapp/web/controller/ShoppingCartController.java:9:import java.text.MessageFormat;
src/main/java/es/storeapp/web/controller/ShoppingCartController.java:56:                logger.debug(MessageFormat.format("Adding product {0} to shopping cart", id));
src/main/java/es/storeapp/web/controller/UserController.java:19:import java.text.MessageFormat;
src/main/java/es/storeapp/web/controller/UserController.java:137:                logger.debug(MessageFormat.format("User {0} logged in", user.getEmail()));
src/main/java/es/storeapp/web/controller/UserController.java:152:                logger.debug(MessageFormat.format("User {0} not logged in ", loginForm.getEmail()));
src/main/java/es/storeapp/web/controller/UserController.java:182:                logger.debug(MessageFormat.format("User {0} with name {1} registered", user.getEmail(), user.getName()));
src/main/java/es/storeapp/web/controller/UserController.java:216:                logger.debug(MessageFormat.format("User {0} with name {1} updated", 
src/main/java/es/storeapp/web/controller/UserController.java:270:                    MessageFormat.format(Constants.CONTENT_DISPOSITION_HEADER_VALUE, user.getEmail(), user.getImage()));
src/main/java/es/storeapp/web/controller/UserController.java:330:            userService.sendResetPasswordEmail(email, MessageFormat.format(Constants.URL_FORMAT, scheme, 
src/main/java/es/storeapp/web/interceptors/LoggerInterceptor.java:3:import java.text.MessageFormat;
src/main/java/es/storeapp/web/interceptors/LoggerInterceptor.java:21:            logger.debug(MessageFormat.format("Request URL: {0} started at {1}", 
src/main/java/es/storeapp/web/interceptors/LoggerInterceptor.java:33:            logger.debug(MessageFormat.format("Request URL: {0} finished at {1}", 
src/main/java/es/storeapp/web/interceptors/LoggerInterceptor.java:42:            logger.debug(MessageFormat.format("After completion URL: {0} finished at {1}", 
root@alixia:~/git/Ciberseguridad_Munics/app/practica_1/store-app# 

```
Perfecto. Ese resultado ya nos reduce muchísimo el trabajo. No significa que las 12 llamadas sean vulnerables: ahora tenemos que distinguir qué valores son controlables por el usuario y cuáles simplemente insertan nombres internos o IDs.
La propia práctica usa JPA/JPQL en los repositorios, así que estamos mirando exactamente en la capa adecuada.

```bash


grep -RniE "createQuery|createNativeQuery|executeQuery|executeUpdate|prepareStatement|createStatement" src/main/java
src/main/java/es/storeapp/business/repositories/AbstractRepository.java:68:        Query query = entityManager.createQuery(MessageFormat.format(FIND_ALL_QUERY, 
src/main/java/es/storeapp/business/repositories/AbstractRepository.java:75:        Query query = entityManager.createQuery(MessageFormat.format(FIND_ALL_ORDERED_QUERY, 
src/main/java/es/storeapp/business/repositories/AbstractRepository.java:82:        Query query = entityManager.createQuery(MessageFormat.format(FIND_BY_TEXT_ATTRIBUTE_QUERY, 
src/main/java/es/storeapp/business/repositories/CategoryRepository.java:15:        Query query = entityManager.createQuery(FIND_HIGHLIGHTED_QUERY);
src/main/java/es/storeapp/business/repositories/CommentRepository.java:18:        Query query = entityManager.createQuery(MessageFormat
src/main/java/es/storeapp/business/repositories/CommentRepository.java:24:        Query query = entityManager.createQuery(MessageFormat
src/main/java/es/storeapp/business/repositories/OrderLineRepository.java:17:        Query query = entityManager.createQuery(MessageFormat.format(FIND_BY_USER_AND_PRODUCT_QUERY, userId, productId));
src/main/java/es/storeapp/business/repositories/OrderRepository.java:16:        Query query = entityManager.createQuery(MessageFormat.format(FIND_BY_USER_QUERY, userId));
src/main/java/es/storeapp/business/repositories/ProductRepository.java:17:        Query query = entityManager.createQuery(MessageFormat.format(FIND_BY_CATEGORY_QUERY, 
src/main/java/es/storeapp/business/repositories/UserRepository.java:18:            Query query = entityManager.createQuery(MessageFormat.format(FIND_USER_BY_EMAIL_QUERY, email));
src/main/java/es/storeapp/business/repositories/UserRepository.java:27:        Query query = entityManager.createQuery(MessageFormat.format(COUNT_USER_BY_EMAIL_QUERY, email));
src/main/java/es/storeapp/business/repositories/UserRepository.java:33:            Query query = entityManager.createQuery(MessageFormat.format(LOGIN_QUERY, email, password));
root@alixia:~/git/Ciberseguridad_Munics/app/practica_1/store-app# grep -RniE "createQuery|createNativeQuery|executeQuery|executeUpdate|prepareStatement|createStatement" src/main/java
src/main/java/es/storeapp/business/repositories/AbstractRepository.java:68:        Query query = entityManager.createQuery(MessageFormat.format(FIND_ALL_QUERY, 
src/main/java/es/storeapp/business/repositories/AbstractRepository.java:75:        Query query = entityManager.createQuery(MessageFormat.format(FIND_ALL_ORDERED_QUERY, 
src/main/java/es/storeapp/business/repositories/AbstractRepository.java:82:        Query query = entityManager.createQuery(MessageFormat.format(FIND_BY_TEXT_ATTRIBUTE_QUERY, 
src/main/java/es/storeapp/business/repositories/CategoryRepository.java:15:        Query query = entityManager.createQuery(FIND_HIGHLIGHTED_QUERY);
src/main/java/es/storeapp/business/repositories/CommentRepository.java:18:        Query query = entityManager.createQuery(MessageFormat
src/main/java/es/storeapp/business/repositories/CommentRepository.java:24:        Query query = entityManager.createQuery(MessageFormat
src/main/java/es/storeapp/business/repositories/OrderLineRepository.java:17:        Query query = entityManager.createQuery(MessageFormat.format(FIND_BY_USER_AND_PRODUCT_QUERY, userId, productId));
src/main/java/es/storeapp/business/repositories/OrderRepository.java:16:        Query query = entityManager.createQuery(MessageFormat.format(FIND_BY_USER_QUERY, userId));
src/main/java/es/storeapp/business/repositories/ProductRepository.java:17:        Query query = entityManager.createQuery(MessageFormat.format(FIND_BY_CATEGORY_QUERY, 
src/main/java/es/storeapp/business/repositories/UserRepository.java:18:            Query query = entityManager.createQuery(MessageFormat.format(FIND_USER_BY_EMAIL_QUERY, email));
src/main/java/es/storeapp/business/repositories/UserRepository.java:27:        Query query = entityManager.createQuery(MessageFormat.format(COUNT_USER_BY_EMAIL_QUERY, email));
src/main/java/es/storeapp/business/repositories/UserRepository.java:33:            Query query = entityManager.createQuery(MessageFormat.format(LOGIN_QUERY, email, password));
root@alixia:~/git/Ciberseguridad_Munics/app/practica_1/store-app# grep -RniE "MessageFormat|String\.format" src/main/java
src/main/java/es/storeapp/business/entities/Category.java:73:        return String.format("Category{categoryId=%s, name=%s, description=%s, icon=%s, highlighted=%s}", 
src/main/java/es/storeapp/business/entities/Comment.java:93:        return String.format("Comment{commentId=%s, text=%s, rating=%s, timestamp=%s, user=%s, product=%s}", 
src/main/java/es/storeapp/business/entities/CreditCard.java:4:import java.text.MessageFormat;
src/main/java/es/storeapp/business/entities/CreditCard.java:52:        return MessageFormat.format("CreditCard{card={0}, cvv={1}, expirationMonth={2}, expirationYear={3}}", 
src/main/java/es/storeapp/business/entities/Order.java:108:        return String.format("Order{orderId=%s, name=%s, timestamp=%s, price=%s, address=%s, state=%s, user=%s, orderLines=%s}", 
src/main/java/es/storeapp/business/entities/OrderLine.java:5:import java.text.MessageFormat;
src/main/java/es/storeapp/business/entities/OrderLine.java:71:        return MessageFormat.format("OrderLine{orderLineId={0}, price={1}, product={2}, order={3}}", 
src/main/java/es/storeapp/business/entities/Product.java:138:        return String.format("Product{productId=%s, category=%s, name=%s, description=%s, icon=%s, price=%s, totalScore=%s, totalComments=%s, sales=%s}", 
src/main/java/es/storeapp/business/entities/User.java:143:        return String.format("User{userId=%s, name=%s, email=%s, password=%s, address=%s, resetPasswordToken=%s, card=%s, image=%s}", 
src/main/java/es/storeapp/business/repositories/AbstractRepository.java:6:import java.text.MessageFormat;
src/main/java/es/storeapp/business/repositories/AbstractRepository.java:68:        Query query = entityManager.createQuery(MessageFormat.format(FIND_ALL_QUERY, 
src/main/java/es/storeapp/business/repositories/AbstractRepository.java:75:        Query query = entityManager.createQuery(MessageFormat.format(FIND_ALL_ORDERED_QUERY, 
src/main/java/es/storeapp/business/repositories/AbstractRepository.java:82:        Query query = entityManager.createQuery(MessageFormat.format(FIND_BY_TEXT_ATTRIBUTE_QUERY, 
src/main/java/es/storeapp/business/repositories/CommentRepository.java:4:import java.text.MessageFormat;
src/main/java/es/storeapp/business/repositories/CommentRepository.java:18:        Query query = entityManager.createQuery(MessageFormat
src/main/java/es/storeapp/business/repositories/CommentRepository.java:24:        Query query = entityManager.createQuery(MessageFormat
src/main/java/es/storeapp/business/repositories/OrderLineRepository.java:4:import java.text.MessageFormat;
src/main/java/es/storeapp/business/repositories/OrderLineRepository.java:17:        Query query = entityManager.createQuery(MessageFormat.format(FIND_BY_USER_AND_PRODUCT_QUERY, userId, productId));
src/main/java/es/storeapp/business/repositories/OrderRepository.java:4:import java.text.MessageFormat;
src/main/java/es/storeapp/business/repositories/OrderRepository.java:16:        Query query = entityManager.createQuery(MessageFormat.format(FIND_BY_USER_QUERY, userId));
src/main/java/es/storeapp/business/repositories/ProductRepository.java:4:import java.text.MessageFormat;
src/main/java/es/storeapp/business/repositories/ProductRepository.java:17:        Query query = entityManager.createQuery(MessageFormat.format(FIND_BY_CATEGORY_QUERY, 
src/main/java/es/storeapp/business/repositories/UserRepository.java:4:import java.text.MessageFormat;
src/main/java/es/storeapp/business/repositories/UserRepository.java:18:            Query query = entityManager.createQuery(MessageFormat.format(FIND_USER_BY_EMAIL_QUERY, email));
src/main/java/es/storeapp/business/repositories/UserRepository.java:27:        Query query = entityManager.createQuery(MessageFormat.format(COUNT_USER_BY_EMAIL_QUERY, email));
src/main/java/es/storeapp/business/repositories/UserRepository.java:33:            Query query = entityManager.createQuery(MessageFormat.format(LOGIN_QUERY, email, password));
src/main/java/es/storeapp/business/services/OrderService.java:17:import java.text.MessageFormat;
src/main/java/es/storeapp/business/services/OrderService.java:75:                logger.warn(MessageFormat.format("Trying to pay the order {0}", order));
src/main/java/es/storeapp/business/services/OrderService.java:107:            logger.debug(MessageFormat.format("Searching the orders of the user {0}", user.getEmail()));
src/main/java/es/storeapp/business/services/OrderService.java:121:            logger.debug(MessageFormat.format("Checking if user {0} buy the product {1}", 
src/main/java/es/storeapp/business/services/ProductService.java:14:import java.text.MessageFormat;
src/main/java/es/storeapp/business/services/ProductService.java:78:                logger.debug(MessageFormat.format("Searching if the user {0} has commented the product {1}", 
src/main/java/es/storeapp/business/services/ProductService.java:94:                logger.debug(MessageFormat.format("{0} has modified his comment of the product {1}", 
src/main/java/es/storeapp/business/services/ProductService.java:105:                logger.debug(MessageFormat.format("{0} created a comment of the product {1}", 
src/main/java/es/storeapp/web/controller/CommentController.java:10:import java.text.MessageFormat;
src/main/java/es/storeapp/web/controller/CommentController.java:56:                    logger.debug(MessageFormat.format("Loading previous comment {0}", commentForm));
src/main/java/es/storeapp/web/controller/CommentController.java:76:            return Constants.SEND_REDIRECT + MessageFormat.format(Constants.PRODUCT_TEMPLATE,
src/main/java/es/storeapp/web/controller/HomeController.java:6:import java.text.MessageFormat;
src/main/java/es/storeapp/web/controller/HomeController.java:29:            logger.debug(MessageFormat.format("Home categories: {0}", categories));
src/main/java/es/storeapp/web/controller/OrderController.java:15:import java.text.MessageFormat;
src/main/java/es/storeapp/web/controller/OrderController.java:109:            logger.debug(MessageFormat.format("Go to complete order page {0}", orderForm.getName()));
src/main/java/es/storeapp/web/controller/OrderController.java:140:            return Constants.SEND_REDIRECT + MessageFormat.format(Constants.ORDER_PAYMENT_ENDPOINT_TEMPLATE, 
src/main/java/es/storeapp/web/controller/OrderController.java:178:        return Constants.SEND_REDIRECT + MessageFormat.format(Constants.ORDER_ENDPOINT_TEMPLATE, order.getOrderId());
src/main/java/es/storeapp/web/controller/OrderController.java:196:        return Constants.SEND_REDIRECT + MessageFormat.format(Constants.ORDER_ENDPOINT_TEMPLATE, order.getOrderId());
src/main/java/es/storeapp/web/controller/ShoppingCartController.java:9:import java.text.MessageFormat;
src/main/java/es/storeapp/web/controller/ShoppingCartController.java:56:                logger.debug(MessageFormat.format("Adding product {0} to shopping cart", id));
src/main/java/es/storeapp/web/controller/UserController.java:19:import java.text.MessageFormat;
src/main/java/es/storeapp/web/controller/UserController.java:137:                logger.debug(MessageFormat.format("User {0} logged in", user.getEmail()));
src/main/java/es/storeapp/web/controller/UserController.java:152:                logger.debug(MessageFormat.format("User {0} not logged in ", loginForm.getEmail()));
src/main/java/es/storeapp/web/controller/UserController.java:182:                logger.debug(MessageFormat.format("User {0} with name {1} registered", user.getEmail(), user.getName()));
src/main/java/es/storeapp/web/controller/UserController.java:216:                logger.debug(MessageFormat.format("User {0} with name {1} updated", 
src/main/java/es/storeapp/web/controller/UserController.java:270:                    MessageFormat.format(Constants.CONTENT_DISPOSITION_HEADER_VALUE, user.getEmail(), user.getImage()));
src/main/java/es/storeapp/web/controller/UserController.java:330:            userService.sendResetPasswordEmail(email, MessageFormat.format(Constants.URL_FORMAT, scheme, 
src/main/java/es/storeapp/web/interceptors/LoggerInterceptor.java:3:import java.text.MessageFormat;
src/main/java/es/storeapp/web/interceptors/LoggerInterceptor.java:21:            logger.debug(MessageFormat.format("Request URL: {0} started at {1}", 
src/main/java/es/storeapp/web/interceptors/LoggerInterceptor.java:33:            logger.debug(MessageFormat.format("Request URL: {0} finished at {1}", 
src/main/java/es/storeapp/web/interceptors/LoggerInterceptor.java:42:            logger.debug(MessageFormat.format("After completion URL: {0} finished at {1}", 
root@alixia:~/git/Ciberseguridad_Munics/app/practica_1/store-app# 
root@alixia:~/git/Ciberseguridad_Munics/app/practica_1/store-app# grep -RniE "FIND_ALL_QUERY|FIND_ALL_ORDERED_QUERY|FIND_BY_TEXT_ATTRIBUTE_QUERY|FIND_HIGHLIGHTED_QUERY|FIND_BY_USER_AND_PRODUCT_QUERY|FIND_BY_USER_QUERY|FIND_BY_CATEGORY_QUERY|FIND_USER_BY_EMAIL_QUERY|COUNT_USER_BY_EMAIL_QUERY|LOGIN_QUERY" src/main/java
src/main/java/es/storeapp/business/repositories/AbstractRepository.java:21:    private static final String FIND_ALL_QUERY = "SELECT t FROM {0} t";
src/main/java/es/storeapp/business/repositories/AbstractRepository.java:22:    private static final String FIND_ALL_ORDERED_QUERY = "SELECT t FROM {0} t ORDER BY t.{1}";
src/main/java/es/storeapp/business/repositories/AbstractRepository.java:23:    private static final String FIND_BY_TEXT_ATTRIBUTE_QUERY = "SELECT t FROM {0} t WHERE t.{1} = ''{2}'' ORDER BY t.{3}";
src/main/java/es/storeapp/business/repositories/AbstractRepository.java:68:        Query query = entityManager.createQuery(MessageFormat.format(FIND_ALL_QUERY, 
src/main/java/es/storeapp/business/repositories/AbstractRepository.java:75:        Query query = entityManager.createQuery(MessageFormat.format(FIND_ALL_ORDERED_QUERY, 
src/main/java/es/storeapp/business/repositories/AbstractRepository.java:82:        Query query = entityManager.createQuery(MessageFormat.format(FIND_BY_TEXT_ATTRIBUTE_QUERY, 
src/main/java/es/storeapp/business/repositories/CategoryRepository.java:11:    private static final String FIND_HIGHLIGHTED_QUERY = "SELECT c FROM Category c WHERE c.highlighted = true";
src/main/java/es/storeapp/business/repositories/CategoryRepository.java:15:        Query query = entityManager.createQuery(FIND_HIGHLIGHTED_QUERY);
src/main/java/es/storeapp/business/repositories/CommentRepository.java:14:    private static final String FIND_BY_USER_AND_PRODUCT_QUERY = 
src/main/java/es/storeapp/business/repositories/CommentRepository.java:25:            .format(FIND_BY_USER_AND_PRODUCT_QUERY, userId, productId));
src/main/java/es/storeapp/business/repositories/OrderLineRepository.java:11:    private static final String FIND_BY_USER_AND_PRODUCT_QUERY = 
src/main/java/es/storeapp/business/repositories/OrderLineRepository.java:17:        Query query = entityManager.createQuery(MessageFormat.format(FIND_BY_USER_AND_PRODUCT_QUERY, userId, productId));
src/main/java/es/storeapp/business/repositories/OrderRepository.java:11:    private static final String FIND_BY_USER_QUERY = 
src/main/java/es/storeapp/business/repositories/OrderRepository.java:16:        Query query = entityManager.createQuery(MessageFormat.format(FIND_BY_USER_QUERY, userId));
src/main/java/es/storeapp/business/repositories/ProductRepository.java:12:    private static final String FIND_BY_CATEGORY_QUERY = 
src/main/java/es/storeapp/business/repositories/ProductRepository.java:17:        Query query = entityManager.createQuery(MessageFormat.format(FIND_BY_CATEGORY_QUERY, 
src/main/java/es/storeapp/business/repositories/UserRepository.java:12:    private static final String FIND_USER_BY_EMAIL_QUERY = "SELECT u FROM User u WHERE u.email = ''{0}''";
src/main/java/es/storeapp/business/repositories/UserRepository.java:13:    private static final String COUNT_USER_BY_EMAIL_QUERY = "SELECT COUNT(*) FROM User u WHERE u.email = ''{0}''";
src/main/java/es/storeapp/business/repositories/UserRepository.java:14:    private static final String LOGIN_QUERY = "SELECT u FROM User u WHERE u.email = ''{0}'' AND u.password = ''{1}''";
src/main/java/es/storeapp/business/repositories/UserRepository.java:18:            Query query = entityManager.createQuery(MessageFormat.format(FIND_USER_BY_EMAIL_QUERY, email));
src/main/java/es/storeapp/business/repositories/UserRepository.java:27:        Query query = entityManager.createQuery(MessageFormat.format(COUNT_USER_BY_EMAIL_QUERY, email));
src/main/java/es/storeapp/business/repositories/UserRepository.java:33:            Query query = entityManager.createQuery(MessageFormat.format(LOGIN_QUERY, email, password));

```


Perfecto. Con esta salida ya tenemos un **candidato muy fuerte a JPQL/SQL Injection**.

Lo importante está en `UserRepository.java`. Las consultas introducen directamente `email` y `password` dentro del texto JPQL mediante `MessageFormat.format()`: Texto pegado

```java
"SELECT u FROM User u WHERE u.email = ''{0}''"

"SELECT COUNT(*) FROM User u WHERE u.email = ''{0}''"

"SELECT u FROM User u WHERE u.email = ''{0}'' AND u.password = ''{1}''"
```

`MessageFormat` aquí **no es una consulta parametrizada**. Vamos a investigarlo antes de modificar nada.

### Paso 1 — Ver el `UserRepository` completo

Ejecuta:

```bash
cat src/main/java/es/storeapp/business/repositories/UserRepository.java
```

Pásame la salida.

Mientras tanto podemos seguir la llamada de `LOGIN_QUERY`, que es la más interesante.

### Paso 2 — Averiguar quién llama al método de login

Primero necesitamos ver el nombre exacto del método que contiene la línea 33. Puedes obtenerlo también con:

```bash
nl -ba src/main/java/es/storeapp/business/repositories/UserRepository.java
```

Después buscaremos quién lo llama.

Probablemente tendremos algo parecido a:

```text
UserController
      ↓
UserService
      ↓
UserRepository
      ↓
LOGIN_QUERY
```

No quiero asumir el nombre del método; lo sacamos del código.

### Paso 3 — Ver el formulario de login

Ejecuta:

```bash
cat src/main/java/es/storeapp/web/forms/LoginForm.java
```

Queremos comprobar si existen:

```java
private String email;
private String password;
```

y qué validaciones tienen.

### Paso 4 — Localizar el controlador del login

Tu búsqueda ya muestra actividad relacionada con login en `UserController.java`, concretamente alrededor de las líneas 137 y 152. Texto pegado

Saca esa zona:

```bash
nl -ba src/main/java/es/storeapp/web/controller/UserController.java | sed -n '110,165p'
```

Aquí queremos localizar algo parecido a:

```java
loginForm.getEmail()
loginForm.getPassword()
```

y ver a qué método de `userService` se pasan.

### Paso 5 — Seguirlo hasta `UserService`

Haz:

```bash
grep -nE "login|authenticate|password|email" \
src/main/java/es/storeapp/business/services/UserService.java
```

Después veremos el método completo correspondiente.

Nuestro objetivo es demostrar una ruta como:

```text
POST /login

email=entrada usuario
password=entrada usuario
        ↓
LoginForm
        ↓
UserController
        ↓
UserService
        ↓
UserRepository
        ↓
MessageFormat.format(LOGIN_QUERY,email,password)
        ↓
entityManager.createQuery(...)
```

Cuando tengamos esa cadena confirmada, tendremos evidencia estática mucho más sólida.

### Paso 6 — Después hacemos la prueba dinámica

Primero iniciaremos sesión normalmente con F12 → **Network** abierto.

Buscaremos la petición del login y veremos exactamente:

```text
Request URL
Request Method
Content-Type
Form Data
```

La guía recomienda precisamente usar las herramientas del navegador para inspeccionar las peticiones HTTP. Guía Primera Práctica

Después reproduciremos **esa petición concreta** en tu instancia local y variaremos la entrada para determinar si realmente altera la consulta. Así evitamos reportar un falso positivo.

### Además: ya tenemos otro candidato

También has encontrado:

```java
FIND_BY_TEXT_ATTRIBUTE_QUERY =
 "SELECT t FROM {0} t WHERE t.{1} = ''{2}'' ORDER BY t.{3}";
```

Texto pegado

Ese `{2}` merece revisión porque parece representar **el valor buscado**. `{0}`, `{1}` y `{3}` podrían ser nombres internos de entidad/atributo, mientras que `{2}` podría llegar desde el usuario.

Pero **primero terminemos `UserRepository`**.

Pásame estas tres salidas:

```bash
cat src/main/java/es/storeapp/business/repositories/UserRepository.java
```

```bash
cat src/main/java/es/storeapp/web/forms/LoginForm.java
```

```bash
nl -ba src/main/java/es/storeapp/web/controller/UserController.java | sed -n '110,165p'
```

Con ellas seguimos la entrada desde el formulario hasta `createQuery()` y después hacemos la prueba en `localhost`.