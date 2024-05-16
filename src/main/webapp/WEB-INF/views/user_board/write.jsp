<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
<link rel="icon" type="image/png" href="/img/logo02.png" />
<link rel="stylesheet"  href="/css/test.css" />
<link rel="stylesheet" href="/css/common.css" />
<link rel="stylesheet" href="/css/start.css" />
<script src="https://cdn.jsdelivr.net/npm/browser-scss@1.0.3/dist/browser-scss.min.js"></script>
<style>
.img-container{
   height: 350px; 
   background-image: url('/img/intro.jpg');
   background-size: cover; 
   background-position: center; 
   display: flex;
   justify-content: center; 
   align-items: center; /
}

  
table {
      border-collapse: separate; /* 바깥 테두리를 제거하기 위해 separate로 변경 */
    border-spacing: 0; /* 셀 사이의 간격을 없애기 위해 0으로 설정 */
    width: 70%;
    color: #333;
    font-family: Arial, sans-serif;
    font-size: 14px;
    text-align: left;
    border-radius: 10px;
    overflow: hidden;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
    margin: auto;
    margin-top: 50px;
    margin-bottom: 50px;
    
}

table td {
    text-align: center;
    padding: 10px;
    border: 1px solid white; /* 안쪽 테두리를 흰색으로 설정 */
}

table td:nth-of-type(1) {
    width: 200px;
    background: #3f98f7;
    color: white;
    font-weight: bold;
}

table input[type="text"],
table textarea {
    width: calc(100% - 20px);
    padding: 10px;
    box-sizing: border-box;
}

table input[type="submit"],
table input[type="button"] {
    width: 100px;
    margin-top: 10px;
}

table tr:last-child td {
    background-color: transparent;
    color: black;
}

table tr:nth-of-type(3) td:nth-of-type(2) {
    width: 800px;
}

table tr:nth-of-type(3) td:nth-of-type(2) textarea {
    height: 300px;
}

footer {
    text-align: center;
    margin-top: 400px;
    padding: 10px;
    background-color: #f2f2f2;
    border-top: 1px solid #ddd;
}

h2 {
    text-align: center;
    margin-top: 50px;
    margin-bottom: 30px;
}
</style>


</head>
<body>
<main>
    
<%@include file="/WEB-INF/include/Header.jsp" %>
<section class="img-container"></section>
		<div class = "main-wrap inner"></div>

<h2>게시글 등록</h2>
<form action="/User_board/Write" method="POST">
    <input type="hidden" name="user_id" value="${ user_id }" />
    <table>
        <tr>
            <td>제목</td>
            <td><input type="text" name="title" /></td>
        </tr>
        <tr>
            <td>작성자</td>
             <td>${ user_id }</td>
        </tr>
        <tr>
            <td>내용</td>
            <td><textarea name="content" rows="10"></textarea></td> <!-- 내용 부분 행 수 조정 -->
        </tr>   
        <tr>
            <td colspan="2">
                <input type="submit" value="글 쓰기" />
                <input type="button" value="목록" id="goList" />
            </td>
        </tr>
    </table>
</form>   
  
<script>
    const  goListEl  = document.getElementById('goList');
    goListEl.addEventListener('click', function(e) {
        location.href = '/User_board/List?user_id=1&nowpage=${nowpage}';
    })
</script>
<%@include file="/WEB-INF/include/Footer.jsp" %>
</main>
</body>
</html>
