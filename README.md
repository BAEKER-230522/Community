<div align="center"><h1>
    🤚🏻BAEKER 의 Community Server 입니다.
</h1></div>

<div align="center"><h3>
    게시판의 게시물, 알고리즘 코드, 댓글을 관리합니다.
</h3></div>

<div align="center"><a href="https://github.com/BAEKER-230522"><b>
    🔗 Organization page
</b></a></div>
<div align="center"><a href="https://github.com/BAEKER-230522/Gateway"><b>
    🔗 Gateway Server
</b></a></div>

<br>

## ERD

- 게시글 Post 를 상속해 카테고리를 나눴습니다.
  - Code Review : 스터디 미션 해결 후 해결 코드 게시물 
  - Solution : 특정 알고리즘 문제의 해결 코드 게시물
  - Study Post : 스터디 전용 게시판
  - Free Post : 자유 게시판

<img width="596" alt="erd" src="https://github.com/choideakook/Project_Inhub/assets/115536240/e22eef86-affd-4e4a-9fe4-08bf121b40e0">
<br>

## 핵심 요구사항

### 개요

- 게시판은 4개의 카테고리로 구성되었습니다.
- 게시물은 조회 수와 추천 기능이 있고 댓글과 대댓글 기능이 있습니다.
    1. 스터디 미션 해결 게시판
        - 미션 중인 스터디 회원끼리만 조회가 가능한 게시물
        - 미션을 해결한 뒤 코드를 업로드하는 게시판
        - 알고리즘 코드의 라인별 댓글, 대댓글 기능
        - 게시물 추천 기능
    2. 백준 문제 해결 게시판
        - 백준 문제를 해결 코드가 게시되는 게시판
        - 스터디 미션을 통해 가장 많은 추천을 받은 코드가 게시
    3. 스터디 전용 게시판
        - 스터디원들만 사용 가능한 게시판
    4. 자유 게시판
        - BAEKER 를 이용하는 모든 클라이언트에게 공개된 게시판
        - 게시물 작성은 회원만 가능

<br>

### 01 생성

- 회원의 활동 내역 문서 생성 (서버 간 통신)
- 카테고리별 게시물 생성
- 게시물 추천
- 게시물 댓글 작성
- 코드 라인별 댓글 작성
- 대댓글 작성

<br>

### 02 조회

- 회원의 커뮤니티 활동 내역 조회
- 카테고리별 게시물 목록 조회
- 게시물 조회
- 게시물을 추천한 회원 목록 조회
- 게시물 댓글 조회
- 코드 라인별 댓글 조회
- 대댓글 조회

<br>

### 03 수정

- 게시물 수정
- 댓글 수정
- 대댓글 수정

<br>

### 04 삭제

- 게시물 삭제
- 게시물 추천 취소
- 게시물 댓글 삭제
- 코드 라인별 댓글 삭제
- 대댓글 삭제

<br>
