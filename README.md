# 3조 - 

## 1. 팀원 및 개요
#### a)프론트엔드 : 
김덕기 / 백엔드 : 윤해서(유저, 커뮤니티, 게이트웨이/ DB AWS세팅 등) , 장준환(코인, 채팅방)

#### b)기능 : 
코인 실시간 조회 및 커뮤니티(네이버 주식 참고), 각 코인 당 채팅방 기능 구현


## 2.설계
### a) DDD설계
![220505](https://user-images.githubusercontent.com/104835130/169385398-6408d56a-c335-4bcb-8f86-869924856d62.png)

### b) MSA설계
![이미지](https://user-images.githubusercontent.com/104835130/169385576-e256a830-bd72-4518-80a1-495ba482c58c.png)


## 3. 기능

## 4.API정의
|기능|메소드|도메인|API|
|------|----|---|--------------|
|회원가입|POST|USER|/user/join|
|로그인|POST|USER|/user/login|
|QnA게시판 조회|GET|BOARD|/boards/qna|
|자유게시판 조회|GET|BOARD|/boards/community|
|게시글 조회|GET|BOARD|/board/id/{boardID}|
|댓글 조회|GET|BOARD|/reply/id/{id}|
