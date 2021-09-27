package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;
import vo.OperationVO;
import vo.ReservationVO;

public class ReservationDAO {
	private String url = "jdbc:oracle:thin:@112.220.114.130";
	private String id = "team5_20210809s";
	private String pw = "java";
	
	private static ReservationDAO instance = new ReservationDAO();
	public static ReservationDAO getInstance() {
		return instance;
	}
	private ReservationDAO() {}
	
	public List<ReservationVO> getArrivalSpotList() throws Exception {
		String sql = "SELECT DISTINCT B.ROUTE_NO, B.ARRIVAL_SPOT FROM OPERATION A, ROUTE B WHERE A.ROUTE_NO = B.ROUTE_NO ORDER BY 1";
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection(url,id,pw);
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		ArrayList<ReservationVO> list = new ArrayList<>();
		while(resultSet.next()) {
			String routeNo = resultSet.getString("route_no");
			String arrivalSpot = resultSet.getString("arrival_spot");
			list.add(new ReservationVO(routeNo,arrivalSpot));
		}
		resultSet.close();
		statement.close();
		connection.close();
		return list;
	}
	
	public ReservationVO getTimeList(int routeNo) throws Exception {
		String sql = "SELECT A.TIME FROM OPERATION A, ROUTE B WHERE A.ROUTE_NO = B.ROUTE_NO AND B.ROUTE_NO = '"+routeNo+"' ORDER BY 1 ";
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection(url,id,pw);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		ReservationVO vo = null;
		if (resultSet.next()) {
			String time = resultSet.getString("time");
			vo = new ReservationVO(time);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return vo;
	}
	
}
