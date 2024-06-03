### Spring boot
-@SpringBootApplication
-@ComponentScan
-@Comppnent, @Controller(Interface), @Service(Interface), @Configuration
-@Bean
-@AutoWire
-@GetMapping, @PostMapiing
-@RequestParam, @PathVariable
-@JsonProperty
-@PostConstruct(right after bean creation, before the server start completed)
-@RestControllerAdvice(@Controller + @ResponseBody)
-@ExceptionHandler
-@Value
-@SpringBootTest, @WebMvcTest, @MockBean, @SpyBean
-mockMvc.perform(), andExpect()

### Lombok (Maven Projct Java/Springboot)
@Data(@ToString, @RequiredArgsConstructor, @Getter, @Setter)**
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgConstructor
@EqualAndHashCode

### Others
- Custom Library (infra folder)
 -ApiResp.class
 -UrlBuilder.class
 -BusincessRunTimeException.class, SysCode.class
- Mockito, Junit5, Hamcrest
-@Mock, @Spy, @InjectMock, @BefreAll, @BeforeEach, @AfterAll, @AfterEach
-Mockito.when().thenResult(), verify(), assertThat, etc.

### Spring boot(Spring) vs Java
-Spring Context & Bean, DI & IOC (Dependency Injection & Inversion of Control)
-Global Exception Handling (Parent Concept - Exception.class, RuntimeException.class)
-Auto Deserialization (JSON to Java Object) & Serialization (Java Object to JSON)
-application.yml
-Data Transfer Object(DTO)
