package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import oracle.jdbc.driver.OracleDriver;
import vo.MemberVO;

public class UserDAO {
	private String url = "jdbc:oracle:thin:@112.220.114.130";
	private String id = "team5_20210809s";
	private String pw = "java";
	
	private static UserDAO instance = new UserDAO();
	public static UserDAO getInstance() {
		return instance;
	}
	private UserDAO() {}
	
	public int insertMember(MemberVO vo) throws Exception {
		String sql = "INSERT INTO MEMBER (ID) VALUES (?)";
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection(url,id,pw);
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getMemId());
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		return executeUpdate;
	}
	
	public int updateMember(MemberVO vo) throws Exception {
		String sql = "UPDATE MEMBER SET NAME = ?, PW = ?, AGE = ?, ADDRESS = ?, MAIL = ?, PHONE = ?, BALANCE = ? WHERE ID = ?";
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection(url,id,pw);
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getMemName());
		statement.setString(2, vo.getMemPw());
		statement.setInt(3, vo.getMemAge());
		statement.setString(4, vo.getMemAddress());
		statement.setString(5, vo.getMemMail());
		statement.setString(6, vo.getMemPhone());
		statement.setInt(7, vo.getMemBalance());
		statement.setString(8, vo.getMemId());
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		return executeUpdate;
	}
	
	
}