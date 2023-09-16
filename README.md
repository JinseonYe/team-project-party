# 내배캠 4기 스프링 A-2 < Let`s Party > 팀프로젝트

![image](https://github.com/JinseonYe/calculator_project/assets/117062933/74fc28e9-fd6a-4124-b147-11e9c0a0b2c3)

내일배움캠프 4기 스프링 A반 2조의 1회성 모임 매칭 서비스 < Let`s Party >입니다.  
게임 속 [ 인스턴트 파티 ] 처럼 빠르게 모임을 결성하고 목적을 이룬 후 부담 없이 헤어지는   
즉흥적인 소규모 모임을 구성하게 해주는 웹 서비스 입니다.



## 1. 사용기술

 <img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=SpringBoot&logoColor=white"> <img src="https://img.shields.io/badge/Spring Security-6DB33F?style=for-the-badge&logo=SpringSecurity&logoColor=white"> 
<img src="https://img.shields.io/badge/MYSQL-4479A1?style=for-the-badge&logo=MYSQL&logoColor=white"> <img src="https://img.shields.io/badge/Redis-DC382D?style=for-the-badge&logo=Redis&logoColor=white">  
  <img src="https://img.shields.io/badge/Thymeleaf-6DB33F?style=for-the-badge&logo=Thymeleaf&logoColor=white"> <img src="https://img.shields.io/badge/Html-E34F26?style=for-the-badge&logo=html5&logoColor=white"> <img src="https://img.shields.io/badge/css-E34F26?style=for-the-badge&logo=html5&logoColor=white"> <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=white"> <img src="https://img.shields.io/badge/KAKAO API-FFCD00?style=for-the-badge&logo=KAKAO&logoColor=white">     
<img src="https://img.shields.io/badge/amazon EC2-FF9900?style=for-the-badge&logo=amazon EC2&logoColor=white"> <img src="https://img.shields.io/badge/amazon RDS-527FFF?style=for-the-badge&logo=amazon RDS&logoColor=white"> <img src="https://img.shields.io/badge/amazon S3-569A31?style=for-the-badge&logo=amazon S3&logoColor=white"> <img src="https://img.shields.io/badge/Github actions-2088FF?style=for-the-badge&logo=githubActions&logoColor=white">   
<img src="https://img.shields.io/badge/Github-181717?style=for-the-badge&logo=github&logoColor=white"> <img src="https://img.shields.io/badge/intelli J-181717?style=for-the-badge&logo=intelliJIDEA&logoColor=white"> <img src="https://img.shields.io/badge/POSTMAN-FF6C37?style=for-the-badge&logo=POSTMAN&logoColor=white">

- JDK 11
- SpringBoot 2.7.8


##  2. 팀원
| 이름 | 깃허브 링크 | 
| --- | --- | 
| 조운 | [깃허브](https://github.com/jwoon1013)   | 
| 최찬호 | [깃허브](https://github.com/chanoChoi) | 
| 김민재| [깃허브](https://github.com/hobakk) | 
| 예진선| [깃허브](https://github.com/JinseonYe) | 
| 이상환| [깃허브](https://github.com/sang-hwann)  | 

## 3.  API 명세
https://www.notion.so/47a47b7b603c42f0b99f898e98fe49b3?v=0d0802a2acd34da68bbabbab16b43350

## 4. ERD 구조도
![image](https://github.com/JinseonYe/calculator_project/assets/117062933/ea6f60ab-0c2b-464a-ba7f-73c98c49990d)

## 5. 주요 기능
### 1. 회원가입 & 로그인
- Spring Security 를 통한 인증/인가 구현 
- JWT 사용(Access Token & RefreshToken 구현 
: RefreshToken은 Redis로 관리)
- 카카오 로그인 Oauth2
- 로그아웃 기능

### 2. 유저 관련
- 내 프로필 정보 조회 & 수정
- 다른 유저 프로필 정보 조회
- 회원 탈퇴
- 내가 작성한 or 신청한 모집글 조회 기능

### 3. 모집글 관련 기능
- 모집글 작성 & 수정 기능 (카카오 지도 api 사용)
- 작성시 입력한 [모임시간] 기준 [15분전]을 [모집마감시간]으로 설정
- 모집글 검색 기능 (주소 & 장소명 & 제목)
- 카테고리별 모집글 조회 기능
- 핫한 모집글 조회 기능 (모집글 조회수 반영)
- 마음에 드는 모집글에 좋아요&취소 기능 (스크랩)
- 내가 좋아요한 모집글 조회 기능


### 4. 모임참가 관련 기능
- 유저는 한번에 한 모집글에만 참석 가능
- 참가신청이 들어오면 파티장은 수락/거부 가능
- 참가인원이 꽉 찬경우 모집글이 [모집마감] 상태로 변경
- 참가인원이 차지 않은경우 모집글은 자동으로 [종료] 처리 됨

### 5. 노쇼 시스템 기능
- 참가자는 [노쇼투표시간] ("모임시간" 으로부터 1시간동안) 동안 다른유저 노쇼 투표가 가능
- 노쇼 투표 시간이 종료되면, 참가자의 과반수(반올림)에게 신고받은 유저는 노쇼포인트가 +1 됨

### 6. 유저 차단 기능
- 유저-유저 개인간의 차단 기능
- 나의 차단리스트 관리 기능
- 내가 차단한 유저가 검색에 걸리지 않는 필터링 기능

### 7. 신고 기능
- 문제 있는 모집글 신고 하는 기능
- 문제 있는 유저 신고 하는 기능
- 신고 10회 누적시 해당 모집글 & 유저 블라인드 처리 기능

### 8. 관리자 기능
- 전체 유저 조회 기능
- 전체 게시글 조회 기능
- 카테고리 생성 수정 삭제 기능
- 특정 유저 계정 정지 기능
- 특정 게시글 삭제 기능
- 모집글 신고 로그 조회 기능
- 특정유저 신고로그 조회 기능

※ 현재 관리자 기능의 경우 프론트 페이지가 구현되어있지 않습니다.
