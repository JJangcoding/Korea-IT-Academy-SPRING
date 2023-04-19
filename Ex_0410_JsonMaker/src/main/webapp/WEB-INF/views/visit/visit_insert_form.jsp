<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<script>
			function send(f){
				
				let name = f.name.value.trim();
				let content = f.content.value.trim();
				let pwd = f.pwd.value.trim();
				
				//유효성 체크
				if( name == '' ){
					alert("이름을 입력하세요");
					return;
				}
				
				f.action="insert.do";
				f.method = "post";
				f.submit();
				
			}
		</script>
		
	</head>
	
	<body>


		<!-- 파일 전송시 form태그가 반드시 가져야 할 두가지의 속성
		     method="post" enctype="multipart/form-data" -->
		<form method="post" enctype="multipart/form-data">
			<table border="1" align="center">
				<caption>새 글 쓰기</caption>
				
				<tr>
					<th>작성자</th>
					<td><input name="name"></td>
				</tr>
				
				<tr>
					<th>내용</th>
					<td>
						<textarea rows="5" cols="50" name="content" style="resize:none;" wrap="on" ></textarea>
					</td>
				</tr>
				
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pwd"></td>
				</tr>
				
				<tr>
					<th>첨부파일</th>
					<td><input type="file" name="photo"></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<input type="button" value="글쓰기" onclick="send(this.form);">
						<input type="button" value="목록으로" onclick="location.href='list.do'">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>













