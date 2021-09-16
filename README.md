# 20210916_Initialize Project
- Gradle
- Java
- Dependencies
  - Spring Data JPA
  - Thymeleaf
  - Spring Web
  - Lombok
  - H2 Database // 개발 교육, 테스트 환경에서 편리함

### DevTools
+) implementation 'org.springframework.boot:spring-boot-devtools'   
개발시 유용한 기능들을 제공해줌.
1. template 갱신 후 Build - Recompile => 서버 재실행하지 않아도 화면 자동 갱신

### H2 설정
- JDBC URL: jdbc:h2:~/jpashop
- home에서 jpashop.mv.db 생성 확인후 disconnect
- 이후 JDBC URL: jdbc:h2:tcp://localhost/~/jpashop 으로 접근

### 
- resources/application.properties 삭제
- resources/application.yml 생성
- 차이?

### 빌드하고 실행하기
````
$ ./gradlew clean build
$ cd build/libs
$ ls
$ java -jar jpashop-0.0.1-SNAPSHOT.jar
^C
````

### 쿼리 파라미터 로그 남기기
- 실운용 시 성능 문제가 생길 수 있음.. 
implementation 'com.github.gavlyukovskiy:p6spy-spring-boot-starter:1.5.6'