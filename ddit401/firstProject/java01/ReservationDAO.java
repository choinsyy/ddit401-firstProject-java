package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;
import vo.RouteVO;
import vo.TimeVO;

public class ReservationDAO {
	private String url = "jdbc:oracle:thin:@112.220.114.130";
	private String id = "team5_20210809s";
	private String pw = "java";
	
	private static ReservationDAO instance = new ReservationDAO();
	public static ReservationDAO getInstance() {
		return instance;
	}
	private ReservationDAO() {}
	
	public List<RouteVO> getArrivalSpotList() throws Exception {
		String sql = "SELECT ROUTE_NO, ARRIVAL_SPOT FROM ROUTE";
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection(url,id,pw);
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		ArrayList<RouteVO> list = new ArrayList<>();
		while(resultSet.next()) {
			String routeNo = resultSet.getString("route_no");
			String arrivalSpot = resultSet.getString("arrival_spot");
			list.add(new RouteVO(routeNo,arrivalSpot));
		}
		resultSet.close();
		statement.close();
		connection.close();
		return list;
	}
	public List<TimeVO> getTimeList(String routeNo) throws Exception {
		String sql = "SELECT B.TIME FROM ROUTE A, OPERATION B WHERE A.ROUTE_NO = B.ROUTE_NO AND A.ROUTE_NO = '"+routeNo+"'";
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection(url,id,pw);
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		ArrayList<TimeVO> list = new ArrayList<>();
		while(resultSet.next()) {
			String time = resultSet.getString("time");
			list.add(new TimeVO(time));
		}
		resultSet.close();
		statement.close();
		connection.close();
		return list;
	}
	
	public RouteVO getTicket(String routeNo) throws Exception {
		String sql = "SELECT NORMAL_FEE FROM ROUTE WHERE ROUTE_NO = '"+routeNo+"'";
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection(url,id,pw);
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		RouteVO vo = null;
		if (resultSet.next()) {
			int normalFee = resultSet.getInt("normal_fee");
			vo = new RouteVO(normalFee);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return vo;
	}
	
	
	
	
	
}