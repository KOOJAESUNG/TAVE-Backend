# :computer: TAVE App-Backend :computer:  

![image](https://github.com/Team-Crackdown/TAVE-Backend/assets/109260733/92b03e74-29a3-4f5c-be8d-a18ae2815113)



## :hammer: 프로젝트 사용기술
 - Spring Boot
 - Java 11
 - MySQL
 - Gradle
 - AWS S3, RDS, EC2, S3 Bucket
 - Swagger
 - Docker
 - Spring Security
 - Intellij IDEA

## :wrench: 작성한 API
- S3
- SSE
- Cool SMS
- Google OTP
 
## :triangular_flag_on_post: Monolithic Architecure
```
저희 팀은 소프트웨어 아키텍처로 서비스 사용자 추이를 고려하여 모놀리식 아키텍처를 이용하였습니다.
```
![image](https://github.com/Team-Crackdown/TAVE-Backend/assets/109260733/cfe1487a-9aae-468b-9799-64742931abdb)

### :question: 모놀리식 아키텍처 사용 이유?
```
모놀리식 아키텍처는 마이크로서비스 아키텍처와 비교했을 때 구현 시간이 짧으며, 주어진 시간 안에 빠르게 개발할 수 있는 장점이 있습니다.
또한, 현재 서비스의 사용자 수가 많지 않다는 점을 고려하여 마이크로서비스 아키텍처를 도입하지 않고 모놀리식 아키텍처를 선택하게 되었습니다.
```

## :pushpin: DB ERD 구조

![image](https://github.com/Team-Crackdown/TAVE-Backend/assets/109260733/7e34d5e3-efc7-46e3-972f-ce44cb8057f5)



##  :raised_hand: CI/CD 구조
```
빌드와 배포 작업의 수동 조작 대신 개발 단계를 자동화하여 짧은 주기로 제공할 수 있도록 하였습니다.
```

![image](https://github.com/Team-Crackdown/TAVE-Backend/assets/109260733/1324fb53-e2ca-4346-9af0-2d7616be089f)

## :question::exclamation: 주요 Issues :question::exclamation:
:heavy_check_mark: [ec2 릴리즈시 CD과정을 거치지 않을경우의 문제](https://github.com/Team-Crackdown/TAVE-Backend/issues/3)
</br>:heavy_check_mark: [SSE 연결 시 Timeout Exception 발생](https://github.com/Team-Crackdown/TAVE-Backend/issues/7)
</br>:heavy_check_mark: [Exception 예외 상황 발생시 요청사항](https://github.com/Team-Crackdown/TAVE-Backend/issues/9)

## :fire: 프로젝트 주요 관심사
:heavy_check_mark: 지속적인 유지 보수를 진행 중입니다.
</br>:heavy_check_mark: 서버 성능을 개선하기 위해 노력하고 있습니다.
</br>:heavy_check_mark: 사용자들로부터의 피드백을 수집하고 분석하여 개선점을 도출할 작업을 계획하고 있습니다.
</br>:heavy_check_mark: 꾸준한 코드 리팩토링을 진행중입니다.
</br>:heavy_check_mark: 프로젝트가 오래 지속될 수 있도록 기술적 지속성을 고려하고 있습니다.

## :sparkles: 의존성
- Springframework
- Google OTP
- Cool SMS
- AWS S3
- My SQL
- Swagger
- Mapstruct, Lombok
- H2 Database
- Spring Security
- JUnit4


## :fire: Swagger 문서
- localhost:8081/docs

## :pushpin: 실행시 유의사랑
- application.yml이 올라와있지 않아 실행이 되지 않습니다!! 실행을 원하시면 별도로 요청주시기 바랍니다!!



## :relaxed: 참고 문서
:white_check_mark: [AWS EC2](https://aws.amazon.com/ko/ec2/?nc2=h_ql_prod_fs_ec2)
</br>:white_check_mark: [CI/CD](https://velog.io/@jmjmjmz732002?tag=CICD)
</br>:white_check_mark: [Spring Security](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8-%EC%8B%9C%ED%81%90%EB%A6%AC%ED%8B%B0/dashboard)
</br>:white_check_mark: [Mapper](https://blog.naver.com/n_cloudplatform/222957490406)

