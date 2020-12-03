package model.dao.login;

import java.util.ArrayList;
import java.util.List;

import model.dao.Dao;
import model.service.login.Login;

public class LoginDaoImpl extends Dao implements LoginDao{
	public LoginDaoImpl() {super();}
	
	/*  super클래스(Dao클래스)에서 선언한 session(인스턴스변수)의 
	 *  함수 selectList()를 사용 -> 테이블에 있는 모든 값을 list에 담음
	 *  selectList()에 있는 파라미터는 mapper.xml파일에서 
	 *  미리 정해둔 Select태그를 이용 -> mapper이름+사용할 태그이름
	 */
	public ArrayList<Login> select() {
		List<Login> list = session.selectList("Login.Select");
		return (ArrayList<Login>)list;
	}
}
