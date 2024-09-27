# Ecommerce Prototype

[Spring Boot Samples](https://spring.io/projects/spring-boot#samples) <br>
[Spring Boot Initializr](https://start.spring.io/)

## Preparing project
* Java
* Maven
* JDK and Java 21
* Packaging War (for web)

## Dependency, Spring Boot: 3.3.3
- Developer Tools:
    * Spring Boot DevTools
    * Lombok
- Web:
    * Spring Web
    * Rest Repositories
    * Spring Web Services
- Security
    * Spring Security
- SQL:
    * Spring Data JPA
    * MySql Driver

## Folder
```
/
├── main/
│   ├── java/
│   │   └── packages/
│   │      ├── config/
│   │      ├── controllers/
│   │      ├── entities/
│   │      ├── repositories/
│   │      ├── services/
│   │      ├── util/
│   │      ├── App.java
│   │      └── ServletInitializer.java
│   └── resources/
│          ├── static/
│          └── templates/
└── test/
```

## Annotations
* Classes
    * @Service
    * @Repository
    * @RestController (RestAPI)
    * @RequestMapping
* Entities
    * @Entity
    * @Table
    * @Id
    * @GeneratedValue
    * @Column
    * @CreationTimestamp + @Column(updatable = false)
    * @UpdateTimestamp
    * @OneToOne(mappedBy = "atrib_t2", fetch = FetchType.LAZY/EAGER)
    * @OneToOne(fetch = FetchType.LAZY/EAGER)
        * @JoinColumn(name = "id_t1")
    * @OneToMany(mappedBy ="atrib_t2", fetch = FetchType.LAZY/EAGER)
    * @ManyToOne(fetch = FetchType.LAZY/EAGER)
        * @JoinColumn(name = "id_t1")
    * @ManyToMany(fetch = FetchType.LAZY/EAGER)
        * @JoinTable(
          name = "t1_t2",
          joinColumns = @JoinColumn(name = "id_t1"),
          inverseJoinColumns = @JoinColumn(name = "id_t2"))
    * @ManyToMany(mappedBy = "atrib_t2", fetch = FetchType.LAZY/EAGER)
* Metods
    * @Autowired
    * @GetMapping
    * @PostMapping
    * @PutMapping
    * @DeleteMapping
    * @RequestMapping

## Config DB
* Edit application.properties file
```
spring.mvc.view.prefix=/templates/

# MySQL Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/praxis?useSSL=false&serverTimezone=UTC
spring.datasource.username=praxis
spring.datasource.password=praxis
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect

# Hibernate Configuration
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.hibernate.ddl-auto=update
```

## Config MVC
* Edit application.properties file
```
# Enable PUT and DELETE in MVC
spring.mvc.hiddenmethod.filter.enabled=true
```

## Tests
```
// Mockito with JUnit 5.

@ExtendWith(MockitoExtension.class)

// Mock repository

@Mock
IRepository repository;

// Mocks service

@InjectMocks
Service service;

Some some = new Some(...)
when(repository.method()).thenReturn(some);

Some result = service.method();

assertThat(result).isEqualTo(some);

verify(repository, times(1)).method();
```
## TaskKill
```
cmd
netstat -ano
netstat -ano | findstr :8080
taskkill /f /pid <pid-number>
```

## Git
```
git checkout -b branchName                  
git switch main                             
git pull                                    
git branch                                  
git push --set-upstream origin "branchName" 
git commit -m "branchName"                  
git push                                    

git branch                  
git checkout -b develop     
git checkout branchName     
git pull origin develop     
git merge branchName        
git status                  
git push origin branchName  
git switch branchName       
git branch -d branchName    
```

## Seed
* Create data.sql in Resources folder
* Edit application.properties file
```
// replace this 
spring.jpa.hibernate.ddl-auto=update

// with this
# Seed
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.defer-datasource-initialization=true
spring.sql.init.mode=always
```
