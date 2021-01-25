# learnSpringData

### Steps:

- Adding dependency from Spring context maven
- Adding config Spring context into Resources project
- Edit that config file by adding a component scan package

**In this project, I used JDBC, Hibernate and JPA Spring**.


* Trong Spring sử dụng Data sources và JDBC Template để hạn chế hard code và gọi lại nhiều lần connection.


###JDBC:

- Để sử dụng **Datasource**, thêm dependency spring-jdbc.
- Khai báo dataSource trong context fjle:

```java
    <bean name="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="url" value="jdbc:mysql://localhost:3306/learn_hibernate"/>
        <property name="username" value="root"/>
        <property name="password" value="012346"/>
    </bean>
```
- Sau đó ta sử dụng ``@Autowire`` cho biến dataSource trong class cần dùng.

- Trong Spring ta có thể sử dụng **JDBC Template** để không phải hard code lại ResultSet, Statement...
- Ta khai báo thêm biến ``JdbcTemplate``.
- JdbcTemplate cần truyền vào một dataSource.
- Ta hoàn toàn có thể tạo một bean của JdbcTemplate và sau sử dụng ``@Autowire`` như dataSource.

- **RowMapper**:
    - Khi ta dùng jdbcTemplate, nếu trong câu query ta select * thì ta không thể map với một kiểu mặt định trong jdbcTemplate được.
    Khi đó ta phải sử dụng RowMapper. 

- **JdbcDaoSupport**: trong jdbcDaoSupport đã có một jdbcTemplate, ta chỉ cần extend JdbcDaoSupport và sử dụng.

***Khi sử dụng Spring ta có 3 cách để tương tác với db:*** ``Jdbc đơn thuần``, ``JdbcTemplate``, ``JdbcDaoSupport``.


##Kết hợp Hibernate với Spring:

- Ta cần thêm dependencies cần thiết như: spring-orm, và hibernate-core. Tham khảo thêm cách sử dụng hibernate [Tại đây]()

- **Spring Data JPA**: đảm nhận những vấn đề vầ JPA trong Spring. Trong nội dung bài học này ta tìm hiểu một Data Access Layer provider là Hibernate.
    - Repository Interfaces: Chúng ta không cẩn sử dụng ``@Repository`` để qui định một class là repository. Chúng ta sẽ sử dụng ``Query DSL`` hoặc
     ``Query method``.
    - Để làm việc với Spring JPA ta cần bổ sung các dependencies như: hibernate-entitymanager,spring-data-jpa.
    - Sau khi cấu hình JPA trong context.xml, xong chúng ta chỉ sử dụng crud vào db mà không cần quan tâm đến JDBC hoặc hibernate query vào db nh
    ư thế nào. Chúng ta chỉ sử dụng các method của interface đã build sẵn.
    - **Query Method**: trong jpa chúng ta có thể tự viết thêm methods để thuận tiện trong từng project.
    - **@Query**: khi method của ta dài hoặc là query method của JPA không hỗ trợ thì ta tự định nghĩa method bằng cách dùng annotation ``@Query("c
âu query cụ thể")
    `` bên trên method trong repository cụ thể.