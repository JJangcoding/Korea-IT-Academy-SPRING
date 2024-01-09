# 코리아 IT 아카데미 - SPRING

## 2023년 3월 31일

이 코드는 Spring Framework를 사용한 간단한 웹 어플리케이션의 일부입니다.

**home.jsp:**
- JSP(JavaServer Pages) 파일로, 웹 페이지를 동적으로 생성하는 데 사용됩니다.
- `<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>`는 JSTL(JavaServer Pages Standard Tag Library)의 Core 라이브러리를 사용하기 위한 선언입니다.
- `${serverTime}`는 서버 시간을 표시하는데 사용되는 JSTL 표현식입니다.

**HomeController 클래스:**
- `@Controller` 어노테이션은 이 클래스가 컨트롤러임을 나타냅니다.
- `@RequestMapping("/")`은 "/" 경로로 들어오는 요청에 대해 `home` 메서드가 처리한다는 것을 나타냅니다.
- `home` 메서드는 현재 서버의 시간을 가져와 모델에 추가하고, "home"을 반환하여 home.jsp와 매핑됩니다.
- `logger`는 SLF4J(Logger Facade for Java)를 사용하여 로깅을 지원합니다. 이를 통해 로그 메시지를 생성할 수 있습니다.

**전반적인 흐름:**
1. 사용자가 웹 브라우저에서 어플리케이션의 루트 경로("/")로 요청을 보냅니다.
2. `HomeController` 클래스의 `home` 메서드가 이 요청을 처리하고, 현재 시간을 모델에 추가합니다.
3. 이 모델은 `home.jsp`에 전달되어 동적으로 웹 페이지를 생성합니다.
4. 최종적으로 생성된 페이지에는 "Hello world!"와 서버의 현재 시간이 포함되어 표시됩니다.

이 어플리케이션은 Spring Framework를 사용하여 모델-뷰-컨트롤러(MVC) 아키텍처를 구현하고 있으며, JSP를 활용하여 동적인 웹 페이지를 생성하고 있습니다.

## 2023년 4월 3일

**HomeController 클래스:**
- `HomeController` 클래스는 Spring의 `@Controller` 어노테이션을 통해 컨트롤러 역할을 하는 클래스입니다.
- `@RequestMapping(value = "/", method = RequestMethod.GET)`은 루트 경로("/")로 GET 요청이 오면 `home` 메서드가 처리한다는 것을 지정합니다.
- `home` 메서드는 현재의 로케일 정보(`Locale locale`)와 모델(`Model model`)을 파라미터로 받습니다.
- `logger`를 통해 클라이언트 로케일 정보를 로깅합니다.
- 현재 날짜와 시간을 생성하고, 이를 포맷팅하여 `formattedDate`에 저장합니다.
- 모델에 "serverTime"이라는 이름으로 `formattedDate` 값을 추가합니다.
- 최종적으로 "home" 문자열을 반환하여 `home.jsp`로 이동합니다.

**BoardController 클래스:**
- `BoardController` 클래스는 Spring의 `@Controller` 어노테이션을 통해 컨트롤러 역할을 하는 클래스입니다.
- 생성자와 setter를 통한 의존성 주입을 사용하여 `BoardServiceImp` 객체를 주입받습니다.
- `@RequestMapping(value = {"/","/list.do"})`은 "/" 또는 "/list.do"로의 요청에 대해 `list` 메서드가 처리한다는 것을 나타냅니다.
- `list` 메서드는 `BoardServiceImp`를 통해 데이터를 조회하고, 조회 결과를 모델에 추가하여 "board_list" 뷰로 포워딩합니다.

**BoardDAO 인터페이스와 BoardDAOImp 클래스:**
- `BoardDAO` 인터페이스는 데이터베이스 조작 메서드들을 선언한 인터페이스입니다.
- `BoardDAOImp` 클래스는 `BoardDAO`를 구현한 클래스로, 현재는 더미 데이터를 반환하도록 구현되어 있습니다.

**BoardService 인터페이스와 BoardServiceImp 클래스:**
- `BoardService` 인터페이스는 비즈니스 로직 메서드들을 선언한 인터페이스입니다.
- `BoardServiceImp` 클래스는 `BoardService`를 구현한 클래스로, 생성자를 통해 `BoardDAOImp`를 주입받아 데이터 조회 기능을 구현합니다.

**board_list.jsp:**
- JSP 파일로, 간단한 HTML과 JSTL을 사용하여 데이터를 출력합니다.
- `<c:forEach>`를 사용하여 리스트의 각 항목을 출력합니다.

**home.jsp:**
- JSP 파일로, 간단한 HTML과 JSTL을 사용하여 서버 시간을 출력합니다.
- `${serverTime}`을 사용하여 서버 시간을 출력합니다.

이 코드는 Spring Framework를 사용하여 간단한 MVC 웹 어플리케이션을 구현한 것으로 보입니다. Controller에서는 서비스를 통해 데이터를 받아와서 JSP로 전달하고, JSP에서는 받아온 데이터를 화면에 출력하는 형태입니다.

## 2023년 4월 3일 -2

**PersonController 클래스:**
- `PersonController` 클래스는 Spring의 `@Controller` 어노테이션을 통해 컨트롤러 역할을 하는 클래스입니다.
- `PersonDAO` 객체를 생성자를 통해 주입받아 사용합니다.
- `@RequestMapping(value = {"/", "/list.do"})`은 "/" 또는 "/list.do"로의 요청에 대해 `select` 메서드가 처리한다는 것을 나타냅니다.
- `select` 메서드는 `PersonDAO`를 통해 데이터를 조회하고, 조회 결과와 클라이언트의 IP 주소를 모델에 추가하여 "person.jsp" 뷰로 포워딩합니다.

**PersonDAO 클래스:**
- `PersonDAO` 클래스는 더미 데이터를 활용하여 간단한 회원 목록 조회 기능을 제공하는 DAO 클래스입니다.
- 생성자에서 "PersonDAO()의 생성자"를 출력합니다.
- `selectList` 메서드는 더미 데이터를 생성하고 리스트에 담아 반환합니다.

**PersonVO 클래스:**
- `PersonVO` 클래스는 회원 정보를 담는 VO(Value Object) 클래스입니다.
- 이름(`name`), 전화번호(`tel`), 나이(`age`)에 대한 필드와 이를 다루기 위한 Getter와 Setter 메서드가 있습니다.
- 생성자를 통해 객체를 초기화할 수 있도록 구성되어 있습니다.

이 코드는 Spring MVC 패턴을 기반으로 한 웹 어플리케이션에서 컨트롤러(`PersonController`), 데이터 접근 객체(`PersonDAO`), 그리고 데이터를 담는 객체(`PersonVO`)를 포함한 간단한 예제입니다. 컨트롤러에서는 DAO를 통해 데이터를 가져와 모델에 담고, JSP 파일로 결과를 전달하여 웹 페이지를 구성하는 방식으로 동작합니다.

## 2023년 4월 4일

**DeptController 클래스:**
- `DeptController` 클래스는 Spring의 `@Controller` 어노테이션을 통해 컨트롤러 역할을 하는 클래스입니다.
- `DeptDAO` 객체를 생성자를 통해 주입받아 사용합니다.
- `@RequestMapping(value = {"/", "/list.do"})`은 "/" 또는 "/list.do"로의 요청에 대해 `list` 메서드가 처리한다는 것을 나타냅니다.
- `list` 메서드는 `DeptDAO`를 통해 데이터를 조회하고, 조회 결과를 모델에 추가하여 "dept_list.jsp" 뷰로 포워딩합니다.

**DeptDAO 클래스:**
- `DeptDAO` 클래스는 MyBatis를 사용하여 데이터베이스와 상호 작용하는 DAO 클래스입니다.
- `setSqlSession` 메서드를 통해 `SqlSession` 객체를 주입받습니다.
- `selectList` 메서드는 MyBatis의 매퍼를 통해 "d.dept_list" 쿼리를 실행하여 전체 부서 목록을 가져옵니다.

**DeptVO 클래스:**
- `DeptVO` 클래스는 부서 정보를 담는 VO(Value Object) 클래스입니다.
- 부서 번호(`deptno`), 부서명(`dname`), 지역(`loc`)에 대한 필드와 이를 다루기 위한 Getter와 Setter 메서드가 있습니다.

이 코드는 Spring MVC 패턴을 기반으로 한 웹 어플리케이션에서 컨트롤러(`DeptController`), 데이터 접근 객체(`DeptDAO`), 그리고 데이터를 담는 객체(`DeptVO`)를 포함한 부서 정보 조회 예제입니다. 컨트롤러에서는 DAO를 통해 데이터를 가져와 모델에 담고, JSP 파일로 결과를 전달하여 웹 페이지를 구성하는 방식으로 동작합니다.

## 2023년 4월 4일 -2 

**ParamController 클래스:**
- `ParamController` 클래스는 Spring의 `@Controller` 어노테이션을 통해 컨트롤러 역할을 하는 클래스입니다.
- `VIEW_PATH` 상수는 JSP 파일의 경로를 나타냅니다.
- `insert_form()` 메서드는 "/insert_form.do" 요청에 대한 처리를 담당하며, "insert_form.jsp"로 이동합니다.
- `insert1()` 메서드는 "/insert1.do" 요청에 대한 처리를 담당하며, 파라미터로부터 받은 값을 `PersonVO` 객체에 수동으로 설정하고, 모델에 바인딩한 후 "insert_result.jsp"로 이동합니다.
- `insert2()` 메서드는 "/insert2.do" 요청에 대한 처리를 담당하며, `PersonVO` 객체를 메서드의 파라미터로 직접 받아 모델에 바인딩한 후 "insert_result.jsp"로 이동합니다.

**PersonVO 클래스:**
- `PersonVO` 클래스는 사용자 정보를 담는 VO(Value Object) 클래스입니다.
- `name`, `tel`, `age`에 대한 필드와 이를 다루기 위한 Getter와 Setter 메서드가 있습니다.

이 코드는 Spring MVC에서 파라미터 전달과 관련된 예제입니다. `ParamController` 클래스에서는 두 가지 방식으로 파라미터를 전달받는 방법을 보여줍니다. `insert1()` 메서드에서는 메서드의 파라미터로 직접 받아 `PersonVO` 객체를 생성하고, `insert2()` 메서드에서는 `PersonVO` 객체를 메서드의 파라미터로 직접 받아 처리하는 방법을 사용합니다.

## 2023년 4월 5일

**VisitController 클래스:**
- `VisitController` 클래스는 Spring의 `@Controller` 어노테이션을 사용하여 컨트롤러 역할을 하는 클래스입니다.
- `HttpServletRequest`와 `ServletContext`를 `@Autowired` 어노테이션으로 주입받습니다.
- `VisitDAO` 객체도 `@Autowired` 어노테이션으로 주입받습니다.
- `list()`: "/list.do"로 요청이 오면 방명록 전체 정보를 조회하고 해당 정보를 모델에 바인딩하여 "visit_list.jsp"로 포워딩합니다.
- `insert_form()`: "/insert_form.do"로 요청이 오면 새글 추가 폼으로 화면을 전환합니다.
- `insert()`: "/insert.do"로 요청이 오면 파라미터로 받은 정보를 이용하여 새로운 글을 추가하고, 파일이 업로드되었다면 서버에 파일을 저장합니다. 그리고 목록을 다시 조회하는 "redirect:list.do"로 리다이렉트합니다.
- `delete()`: "/delete.do"로 요청이 오면 해당 인덱스의 글을 삭제하고 성공 여부를 "yes" 또는 "no"로 반환합니다.
- `modify_form()`: "/modify_form.do"로 요청이 오면 해당 인덱스의 글을 수정하는 폼으로 화면을 전환합니다.
- `modify()`: "/modify.do"로 요청이 오면 해당 인덱스의 글을 수정하고, 성공 여부를 문자열로 반환합니다.

**VisitDAO 클래스:**
- `VisitDAO` 클래스는 방명록과 관련된 데이터베이스 액션을 수행하는 DAO(Data Access Object) 클래스입니다.
- `selectList()`: 방명록 전체 목록을 조회합니다.
- `insert()`: 새로운 글을 추가합니다.
- `delete()`: 지정된 인덱스의 글을 삭제합니다.
- `selectOne()`: 지정된 인덱스에 해당하는 글을 조회합니다.
- `update()`: 글을 수정합니다.

**MyCommon 클래스:**
- `MyCommon` 클래스는 상수 값을 정의한 유틸리티 클래스입니다.
- `Visit` 클래스 내에는 방명록과 관련된 뷰 경로가 정의되어 있습니다.

**VisitVO 클래스:**
- `VisitVO` 클래스는 방명록 글에 대한 정보를 담는 VO(Value Object) 클래스입니다.
- `idx`, `name`, `content`, `pwd`, `ip`, `regdate`, `filename`은 각각 글의 인덱스, 작성자 이름, 내용, 비밀번호, 아이피, 작성일시, 파일 이름을 나타냅니다.
- `MultipartFile photo`는 파일 업로드를 처리하기 위한 객체입니다.

이 코드는 Spring MVC에서 방명록을 관리하는 컨트롤러 및 DAO 예제입니다. 방명록 글의 추가, 삭제, 수정 등의 기능이 구현되어 있습니다. 또한 파일 업로드 기능도 포함되어 있습니다.


## 2023년 4월 7일

**HomeController 클래스:**
- `HomeController` 클래스는 Spring의 `@Controller` 어노테이션을 사용하여 컨트롤러 역할을 하는 클래스입니다.
- "/" 경로로 GET 요청이 오면 현재 시간을 가져와서 "home" 뷰에 시간 정보를 전달하여 포워딩합니다.

**TestController 클래스:**
- `TestController` 클래스는 Spring의 `@Controller` 어노테이션을 사용하여 컨트롤러 역할을 하는 클래스입니다.
- `TotalService` 객체를 생성자를 통해 주입받습니다.
- "/" 또는 "/list.do"로 요청이 오면 `TotalService`의 `selectList` 메서드를 호출하여 부서 목록을 가져와 "dept_list.jsp" 뷰에 부서 목록을 전달하여 포워딩합니다.

**DeptDAO 클래스:**
- `DeptDAO` 클래스는 데이터베이스에서 부서 정보를 관리하는 DAO(Data Access Object) 클래스입니다.
- `SqlSession` 객체를 생성자를 통해 주입받습니다.
- `selectList()`: 부서 목록을 조회합니다.

**TotalService 클래스:**
- `TotalService` 클래스는 비즈니스 로직을 처리하는 서비스(Service) 클래스입니다.
- `DeptDAO` 객체를 생성자를 통해 주입받습니다.
- `selectList()`: 부서 목록을 조회하는 메서드입니다.

**DeptVO 클래스:**
- `DeptVO` 클래스는 부서 정보를 담는 VO(Value Object) 클래스입니다.
- `deptno`, `dname`, `loc`는 각각 부서 번호, 부서 이름, 부서 위치를 나타냅니다.

**요약:**
- 코드는 Spring 프레임워크를 사용하여 구현되어 있습니다.
- `HomeController`는 간단한 홈페이지의 시간 정보를 제공합니다.
- `TestController`는 부서 정보를 제공하는 기능을 수행하며, 해당 기능은 `TotalService`와 `DeptDAO`를 활용합니다.
- 의존성 주입(Dependency Injection)을 통해 서비스 클래스와 DAO 클래스 간의 결합도를 낮추고 유연성을 높이는 형태로 설계되어 있습니다.

## 2023년 4월 10일

**JsonMakerController 클래스:**
- `JsonMakerController` 클래스는 Spring의 `@Controller` 어노테이션을 사용하여 컨트롤러 역할을 하는 클래스입니다.
- "/vo_to_json.do"로 요청이 오면 `PersonVO` 객체를 생성하고 이를 JSON 형태로 변환하여 반환합니다.

**JsonVisitController 클래스:**
- `JsonVisitController` 클래스는 Spring의 `@Controller` 어노테이션을 사용하여 컨트롤러 역할을 하는 클래스입니다.
- "/list.do", "/insert_form.do", "/insert.do", "/delete.do", "/modify_form.do", "/modify.do"와 같은 다양한 경로에 대한 요청을 처리합니다.
- 방명록 정보를 조회하거나 추가, 삭제, 수정하는 기능을 구현하고 있습니다.
- 업로드된 이미지는 `/resources/upload/` 폴더에 저장되며, 파일 이름은 현재 시간을 포함하여 중복을 방지합니다.
- AJAX 요청에 대한 응답은 `@ResponseBody` 어노테이션을 사용하여 JSON 형태로 반환합니다.

**VisitController 클래스:**
- `VisitController` 클래스는 `JsonVisitController`와 기능적으로 유사하나, 뷰 페이지로의 포워딩이 있는 메서드들이 추가로 구현되어 있습니다.
- "/list2.do", "/insert_form2.do", "/insert2.do", "/delete2.do", "/modify_form2.do", "/modify2.do"와 같은 다양한 경로에 대한 요청을 처리합니다.
- 뷰 페이지로의 포워딩이 있는 메서드들은 주로 화면 전환을 담당합니다.

**VisitDAO 클래스:**
- `VisitDAO` 클래스는 방명록 정보를 데이터베이스에서 처리하는 DAO 클래스입니다.
- SQL문은 MyBatis를 통해 실행됩니다.
- `selectList()`: 방명록 전체 목록 조회
- `insert()`: 방명록 추가
- `delete()`: 방명록 삭제
- `selectOne()`: 특정 인덱스의 방명록 조회
- `update()`: 방명록 수정

**MyCommon 클래스:**
- `MyCommon` 클래스는 뷰 페이지의 경로를 상수로 정의한 클래스입니다.
- `Visit`와 `Board` 내부 클래스로, 방명록과 게시판에 대한 뷰 페이지 경로를 정의하고 있습니다.

**PersonVO 클래스:**
- `PersonVO` 클래스는 이름(name), 나이(age), 주소(addr) 정보를 가지고 있는 VO 클래스입니다.

**VisitVO 클래스:**
- `VisitVO` 클래스는 방명록 정보를 담는 VO 클래스입니다.
- `idx`: 인덱스, `name`: 작성자 이름, `content`: 내용, `pwd`: 비밀번호, `ip`: 작성자 IP, `regdate`: 등록일, `filename`: 업로드된 파일 이름을 저장합니다.
- `photo`: 업로드된 이미지를 받기 위한 `MultipartFile` 타입의 필드가 있습니다.

**httpRequest.js 파일:**
- `httpRequest.js` 파일은 AJAX 요청을 수행하는 자바스크립트 코드를 포함하고 있습니다.
- `createRequest()`: HTTP request 객체 생성
- `sendRequest(url, param, callBack, method)`: AJAX 요청을 보내는 함수

**index.jsp 파일:**
- AJAX를 이용하여 서버에서 JSON 형태의 데이터를 받아와서 특정 필드를 출력하는 예제입니다.
- 페이지가 로드되면 `onload` 이벤트 핸들러가 실행되어 서버로 AJAX 요청을 보내고, 응답을 처리하는 `resultFn` 함수가 호출됩니다.
- 받아온 JSON 데이터를 가공하여 결과를 HTML에 출력합니다.

