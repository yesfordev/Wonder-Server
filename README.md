# bring

![image](https://user-images.githubusercontent.com/31542907/114298472-9571ef80-9af1-11eb-86b8-e9399a074dba.png)

### ☎️Take-Out 원격 주문 서비스 'Bring'

- 배달 주문 어플리케이션은 많으나, 테이크 아웃 서비스가 많이 부족하던 때

    → 제휴를 통해 원격 주문을 할 수 있도록 도와주는 어플리케이션

    → 점주 / 사용자 버전 2개로 나누어져 있음

- 개발 기간 - 2018년 12월 23일 ~ 2019년 1월 12일

### 프로젝트 진행 인원

- iOS 2명 - 기획 3명 - 디자인 2명 - 서버 4명 - 안드로이드 4명
- 🍞 담당 파트 : 서버

### Server

- Rest API

### 개발 환경 및 사용 기술

- Spring Boot
- MyBatis
- FCM
- AWS EC2, RDS, S3
- Postman
- IntelliJ
- Java 8
- Windows 10

### ER Diagram

![image](https://user-images.githubusercontent.com/31542907/114298517-c05c4380-9af1-11eb-9f71-2a2b80b08e73.png)

### ✨프로젝트 담당 역할

- 백 엔드 서버 개발
- DB 모델링
- API 문서 작성

### API 명세서
- [API](https://github.com/Bring-SOPT/Wonder-Server/wiki)

### 프로젝트 의존성

```
<dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>1.3.2</version>
        </dependency>

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>

        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <!-- AWS -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-aws</artifactId>
            <version>2.0.1.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-aws-context</artifactId>
            <version>1.2.1.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-aws-autoconfigure</artifactId>
            <version>1.2.1.RELEASE</version>
        </dependency>

        <!-- AOP -->
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.8.11</version>
        </dependency>

        <!-- JWT -->
        <dependency>
            <groupId>com.auth0</groupId>
            <artifactId>java-jwt</artifactId>
            <version>3.4.0</version>
        </dependency>
        <dependency>
            <groupId>commons-io</groupId>
            <artifactId>commons-io</artifactId>
            <version>2.4</version>
        </dependency>
        <dependency>
            <groupId>commons-io</groupId>
            <artifactId>commons-io</artifactId>
            <version>2.5</version>
        </dependency>

        <!--json-->
        <dependency>
            <groupId>org.json</groupId>
            <artifactId>json</artifactId>
            <version>20180813</version>
        </dependency>
</dependecies>

```

### 배포

- AWS EC2 - 애플리케이션 서버
- AWS RDS - DB 서버
- AWS S3 - 저장소 서버

### 개발자

- **서영은** - [yesfordev](https://github.com/yesfordev)
- **김보미** - [BBBOMi](https://github.com/BBBOMi)
- **박다예** - [parkdaye](https://github.com/parkdaye)
- **신지우** - [jiwoooooo](https://github.com/jiwoooooo)

### bring 프로젝트

- [ANDROID](https://github.com/Bring-SOPT/Wonder-Android)
- [IOS](https://github.com/Bring-SOPT/Wonder-iOS)
- [SERVER-OWNER](https://github.com/BBBOMi/Wonder-Server-Owner)
- [ANDROID-OWNER](https://github.com/Bring-SOPT/Wonder-Android-Owner)

### 🏆수상

- 제 22기 SOPT APPJAM 장려상 수상 (2019.01.26)
