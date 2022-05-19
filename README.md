# 3조 - 

## 1.설계
### a) DDD설계
![220505](https://user-images.githubusercontent.com/104835130/169385398-6408d56a-c335-4bcb-8f86-869924856d62.png)

|기능|메소드|도메인|API|
|------|----|---|--------------|
|회원가입|POST|USER|/user/join|
|로그인|POST|USER|/user/login|
|QnA게시판 조회|GET|BOARD|/boards/qna|
|자유게시판 조회|GET|BOARD|/boards/community|
