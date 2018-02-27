# thymeleaf_test
  spring-boot+thymeleaf测试demo
  
## 所用到的技术
* spring boot
* thymeleaf
* mybatis
* mysql
* druid
* jquery+datables后台分页
* spring boot 热部署


## spring boot 热部署配置
    pom
```java
   <!-- 热部署模块 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <optional>true</optional> <!-- 这个需要为 true 热部署才有效 -->
            <scope>true</scope>
        </dependency>
```

```java
        <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <fork>true</fork> <!-- 如果没有该配置，devtools不会生效 -->
                </configuration>
            </plugin>
```


## jquery+datables后台分页效果展示
![image](https://github.com/lcyanxi/thymeleaf_test/raw/master/img/data1.png)
![image](https://github.com/lcyanxi/thymeleaf_test/raw/master/img/data2.png)

## 使用阿里的druid效果展示
![image](https://github.com/lcyanxi/thymeleaf_test/raw/master/img/druid.png)

