
# SpringBoot Testing QPcademy (Coach : Harpal Singh)
### _Course Struture_
##### Warm Up Session+ Bonus
- How to wire springboot app within no time
- How to `spice up` your code using `Lombok`
- Remove boilerplate code using lombok
- Fetch Data from Database using SpringBoot
- How to use `springboot-jpa`
- Projection Queries etc
- How to use `JPABuddy`.
- How to read property files in spring
- How to organize and read property files using standard way 
- `@TestPropertySource`/ `@PropertySource` /`@Environment`
- Usage of `@ContextConfiguration` `@SpringExtention`
- Difference b/w `@Autowired and @Bean`
- `@RestController/@Controller/@Repository/@Service/@Configuration`

##### 1. Mocking Using Mockito
- Introduction to Mockito
- Creating Mocks with Mockito
- Stubbing Method calls of Mockito
- AAA-> `Arrange(when-then->return) /Act/ Assert`
- Usage of `@MockitoExtentions`/`@Mock`/`@InjectMocks`
- Verifying Interaction of a Mock using `Assertions`
- Real word usage of `Spy` and difference between `@Mock` and `@Spy`

##### 2. Introduction to Junit 5
- Assertions
- Naming Test
- Parameterized Test
- Junit 5 extentions
- unit 5  Extenstion
   * Test Life Cycle Callbacks
   * Test Instance Post Processing 
   * Conditional Test Execution 
   * Parameter Resolution 
   * Exception Handling
- Parallel Test
- Execution Condition
##### 3. Additional Test Libraries
- Hamercest
- AssertJ
- JSONAssert
- JSONPath

### 4. SpringBoot Test Slices
##### a) Database Layer
- Database Access Layer
- Usage of @DataJpaTest/@TestEntityManager/P6Spy/TransactionalSupport
##### b) WebLayer
- Testing WebLayer
- Usage of @WebMvcTest
##### c) Service Layer
- Testing Service Layer
##### d) Http Clients
- Testing Http Clients using @RestTemplate and @Webclient
### 5. Integration Test
- End to End Tests `@SpringBootTest`
- Writing test using `@TestContainer` 
- Test Repo layer using `H2 DB`
- Test Repo layer using `MysqlContainer`
-  

### Application Setup 

###### Download Rabbit MQ Image from DockerHub ########## 
- docker pull rabbitmq:3-management

###### Start RabbitMQ ######## 
- docker run --rm -it --hostname my-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management
