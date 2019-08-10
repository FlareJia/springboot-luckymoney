#spring boot-luckymoney

注意事项：

1.配置文件application.yml类似树形文件，用格式将地址分开，在其中写配置时，记得空一格。

2.yml配置
  2.1 单个配置用@Value
  2.2 添加@ConfigurationProperties(prefix = "limit")注解时，需要在pom.xml文件添加如下依赖：
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
            <optional>true</optional>
        </dependency>
      并在@ConfigurationProperties(prefix = "limit")上一行用上@Component来注入

3.使用对象配置：在yml配置文件中配置，并新建一个类来获取对象

4.区分测试环境和生产环境，三份配置文件

5.在服务器打包运行的时候使用命令：java -jar -Dspring.profiles.active=prod target/luckymoney-0.0.1-SNAPSHOT.jar 来指明参数使用生产环境。

6.项目启动
  6.1 可在项目根目录处用命令: mvn spring-boot:run启动项目
  6.2 若是在服务器上，需要打包之后再运行，使用命令: mvn clean package进行打包
    再用java -jar [项目.jar] 启动
    
7.Controller的使用
  7.1 @Controller 处理http请求
  7.2 @RestController 这是spring4之后的新注解，原来的版本返回json需要用@ResponseBody配合@Controller来使用
  7.3 @RequestMapping 配置url映射，有些情况下还是需要用到它
  7.4 @PathVariable 获取url中的数据
  7.5 @RequestParam 获取请求参数的值
  
8.地址映射
  8.1 使用get:@GetMapping("/say")
  8.2 使用post:@PostMapping("/say")
  8.3 同时使用post和get:@RequestMapping("/say") 此种方式尽量不用

9.数据库
  9.1 mysql
  9.2 Spring-Data-Jpa 只需要extends JpaRepository
  9.3 三个数据库操作方法 save() findById() findAll()
  
10.四个接口 GET POST PUT

11.事务
  11.1 事务操作一般都放到service中
  11.2 InnoDB支持事务操作，Myisam不支持事务操作
  

WEB进阶：

1.使用@Valid表单验证
  1.1 使用@Valid和@Min限制发红包钱数大于等于10
  1.2 使用BindingResult来返回验证结果
  
2.使用AOP处理请求
  2.1 AOP是一种编程范式，与语言无关，是一种程序设计思想 
    面向切面AOP：Aspect Oriented Programming 
    面向对象OOP：Object Oriented Programming
    面向过程POP：Prodcure Oriented Programming
    
    收到HttpRequest请求->记录请求   ->处理网络请求->生成HttpResponse    ->记录回复
    收到数据库操作请求->记录请求      ->增删改查->生成处理结果            ->记录回复
    
    可以将上述的操作切成三部分
  2.2 第一步添加依赖spring-boot-starter-aop
      第二步添加aspect类，添加@Aspect和@Compenent注解，利用@Pointcut、@Before或@After之类
      第三步添加logger来打印日志
  
3.统一异常处理
4.单元测试