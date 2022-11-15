<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="join.jsp" method="post">
		email:<input type="text" name="email" /> <br /> 이름:<input type="text"
			name="name" /> <br /> 비밀번호:<input type="password" name="password"
			value="" /> <br /> 생년: <select name="birthYear">
			<option value="1996">1996</option>
			<option value="1997">1997</option>
			<option value="1998">1998</option>
		</select> <br /> 성별: 여자<input type="radio" name="gender" value="female"
			checked="checked" /> 남자<input type="radio" name="gender" value="male" />
		<br /> 자기소개: <br />
		<br />
		<textarea name="profile"></textarea>
		<br /> 취미: 코딩<input type="checkbox" name="habby" value="coding" /> 음주<input
			type="checkbox" name="habby" value="drinking" /> 요리<input
			type="checkbox" name="habby" value="cooking" /> 운동<input
			type="checkbox" name="habby" value="exercise" /> <br /> <br /> <input
			type="submit" value="회원가입" />

	</form>
</body>
</html>