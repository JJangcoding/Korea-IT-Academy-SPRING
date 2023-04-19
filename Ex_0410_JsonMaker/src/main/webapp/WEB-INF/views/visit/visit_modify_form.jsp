<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<!-- Ajax사용을 위해 참조할 js -->
		<script src="/visit/resources/js/httpRequest.js"></script>
		
		<script>
			function send( f ){
				let idx = f.idx.value;
				let name = f.name.value;
				let content = f.content.value;
				let pwd = f.pwd.value.trim();
				if( pwd == '' ){
					alert("비밀번호 필수");
					return;
				}
				
				var url = "modify.do";
				var param = "idx="+idx+"&name="+name+"&content="+encodeURIComponent(content)+"&pwd="+pwd;
				sendRequest(url, param, resultFn, "post");
				
			}
			
			function resultFn(){
				if( xhr.readyState == 4 && xhr.status == 200 ){
					
					var data = xhr.responseText;
					
					alert(data);
					
					location.href="list.do";
					
				}
			}
			
		</script>
		
	</head>
	
	<body>
		<form>
			<input type="hidden" name="idx" value="${vo.idx}">	
			
			<table border="1" align="center">
				<caption>게시글 수정하기</caption>
			
				<tr>
					<th>작성자</th>
					<td><input name="name" value="${ vo.name }"></td>
				</tr>
				
				<tr>
					<th>내용</th>
					<td><textarea rows="5" cols="50" name="content">${ vo.content }</textarea></td>
				</tr>
				
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pwd" value="${ vo.pwd }"></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<input type="button" value="수정하기" onclick="send(this.form);">
						<input type="button" value="목록으로" onclick="location.href='list.do'">					
					</td>
				</tr>
			</table>		
		</form>
	</body>
</html>

















