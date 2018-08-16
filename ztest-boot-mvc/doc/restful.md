# 1. RESTful in Java
## 1.1 JAX-RS
Java关于restful的规约[wiki](https://en.wikipedia.org/wiki/Java_API_for_RESTful_Web_Services)

JAX-RS provides some annotations to aid in mapping a resource class (a POJO) as a web resource.   
The annotations use the Java package javax.ws.rs. They include:
1. @Path specifies the relative path for a resource class or method.
2. @GET, @PUT, @POST, @DELETE and @HEAD specify the HTTP request type of a resource.
3. @Produces specifies the response Internet media types (used for content negotiation).
4. @Consumes specifies the accepted request Internet media types.

In addition, it provides further annotations to method parameters to pull information out of the request.   
All the @*Param annotations take a key of some form which is used to look up the value required.
1. @PathParam binds the method parameter to a path segment.
2. @QueryParam binds the method parameter to the value of an HTTP query parameter.
3. @MatrixParam binds the method parameter to the value of an HTTP matrix parameter.
4. @HeaderParam binds the method parameter to an HTTP header value.
5. @CookieParam binds the method parameter to a cookie value.
6. @FormParam binds the method parameter to a form value.
7. @DefaultValue specifies a default value for the above bindings when the key is not found.
8. @Context returns the entire context of the object (for example @Context HttpServletRequest request).

## 1.2 Implementations
常见的实现jax-rs规范的rest框架
- Apache CXF
- Jersey
- RESTeasy
- Restlet
- ..

# 2. Spring MVC
Spring未遵从jax-rs规范
## 2.1 spring-context
spring-context定义了多种类型的Component,其中包含了接口类型的controller：
1. @Controller  
2. @Service  
3. @Component
4. @Repository
5. @Indexed

## 2.2 spring-web
spring未遵循jax-rs规范，在spring-web中自定义了一套类似规范注解：
1. @RestController
2. @Requestmapping
3. @ResponseBody
4. @RequestMapping, @GetMapping, @PostMapping, @PutMapping, @DeleteMapping
5. @RequestParam, @RequestBody, @PathVariable...

## 2.3 spring-webmvc
https://docs.spring.io/spring-boot/docs/2.0.3.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications

### Interception(拦截器)
1. 自定义类继承HandlerInterceptorAdapter
2. 继承WebMvcConfigurer，讲自定义拦截器添加到WebMvc

### Exception Handler(统一异常)
使用springMVC可以方便的对异常进行统一处理，3种方法：
1. 使用@Exceptionhandler注解，对当前Controller有效
2. 使用@ControllerAdvice增强，配合@ExceptionHandler、@InitBinder、@ModelAttribute等对所有@RequestMapping有效
3. 使用@Component注解HandlerExceptionResolver接口的实现类，实现全局异常控制

### 小技巧
1. 获取springmvc下的所有requestMapping的Url，直接使用@Autowired注入RequestMappingHandlerMapping

# 3 Http
## 3.1 Http Method Summary
Http Method中数据绑定概要[wiki](https://en.wikipedia.org/wiki/Hypertext_Transfer_Protocol)  

## 3.2 Message format
The client and server communicate by sending plain-text (ASCII) messages. The client sends requests to the server and the server sends responses.

### request message
The request message consists of the following:
- A request line(e.g., GET /images/logo.png HTTP/1.1)
- Request header fields
- An empty line
- An optional message body
The request line and other header fields must each end with <CR><LF> (that is, a carriage return character followed by a line feed character).  
The empty line must consist of only <CR><LF> and no other whitespace. In the HTTP/1.1 protocol, all header fields except Host are optional.  

### response message
The response message consists of the following:
- A status line which includes the status code and reason message (e.g., HTTP/1.1 200 OK, which indicates that the client's request succeeded).
- Response header fields (e.g., Content-Type: text/html).
- An empty line.
- An optional message body.
The status line and other header fields must all end with <CR><LF>. The empty line must consist of only <CR><LF> and no other whitespace.  
This strict requirement for <CR><LF> is relaxed somewhat within message bodies for consistent use of other system linebreaks such as <CR> or <LF> alone.