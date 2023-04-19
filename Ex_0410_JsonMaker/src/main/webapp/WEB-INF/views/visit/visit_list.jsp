<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<style>
			img{ display:block;
				margin:0 auto; }
		</style>
		
		<link rel="stylesheet" href="/visit/resources/css/visit.css">
		
		<!-- Ajax사용을 위한 js파일 등록 -->
		<script src="/visit/resources/js/httpRequest.js"></script>
		
		<script>
			function del( f ){
				let pwd = f.pwd.value; //원본 비밀번호
				let c_pwd = f.c_pwd.value; //입력 비밀번호
				
				if( pwd != c_pwd ){
					alert("비밀번호 불일치");
					return;
				}
				
				//삭제확인
				if( !confirm("정말로 삭제 하시겠습니까?") ){
					return;
				}
				
				//삭제를 위한 url매핑 호출
				var url = "delete.do";
				var param = "idx=" + f.idx.value;
				sendRequest(url, param, resFn, "get");
			}
			
			//콜백 메서드
			function resFn(){
				if( xhr.readyState == 4 && xhr.status == 200 ){
					
					//data = "no" 또는 data = "yes"
					var data = xhr.responseText;
					
					if( data == 'no' ){
						alert("삭제실패");
					}else{
						alert("삭제성공");
					}
					
					location.href="list.do";//전체목록 갱신
					
				}
			}
			
			function modify(f){
				
				let pwd = f.pwd.value.trim();//원본 비밀번호
				let c_pwd = f.c_pwd.value.trim();//입력한 비밀번호
				
				if( pwd != c_pwd ){
					alert("비밀번호 불일치");
					return;
				}
				
				f.action = 'modify_form.do';
				f.method = "post";
				
				//modify_form.do?idx=10&pwd=1111&c_pwd=1111
				f.submit();
				
			}
			
		</script>
	</head>
	
	<body>
		<div id="main_box">
			<h1>방명록 리스트</h1>
			
			<div align="right">
				<input type="button" value="글쓰기" onclick="location.href='insert_form.do'">
			</div>
			
			<c:forEach var="vo" items="${ list }">
				<div class="visit_box">
					<div class="type_content"><pre>${ vo.content }</pre><br>
						
						<!-- 첨부된 파일이 있는 경우에만 img태그를 사용 -->
						<c:if test="${ vo.filename ne 'no_file' }">
							<img src="/visit/resources/upload/${ vo.filename }" width="200"/>
						</c:if>
					
					</div>
					
					
					
					<div class="type_name">${ vo.name }( ${ vo.ip } / ${ vo.pwd } )</div>
					<div class="type_regdate">작성일 : ${ vo.regdate }</div>
				
					<form>
						<input type="hidden" name="idx" value="${ vo.idx }">
						<input type="hidden" name="pwd" value="${ vo.pwd }">
						비밀번호 <input type="password" name="c_pwd">
						
						<input type="button" value="수정" onclick="modify(this.form)">
						<input type="button" value="삭제" onclick="del(this.form)">
					</form>
				</div>
				
			</c:forEach>
			
		</div>
	</body>
</html>












































