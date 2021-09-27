package service;

import java.util.ArrayList;
import java.util.List;

import dao.ReservationDAO;
import util.ScanUtil;
import util.View;
import vo.OperationVO;
import vo.ReservationVO;

public class ReservationService {
	private static ReservationService instance = new ReservationService();
	public static ReservationService getInstance() {
		return instance;
	}
	private ReservationService() {}
	private ReservationDAO reservationDao = ReservationDAO.getInstance();
	public int resrv() throws Exception {
		ReservationVO vo = new ReservationVO();
		List<ReservationVO> result = reservationDao.getArrivalSpotList();
		System.out.println();
		System.out.println("<<<< 도착지 선택 >>>>");
		for (ReservationVO reservationVO : result) {
			System.out.println(reservationVO);
		}
		System.out.println();
		System.out.println("노선번호를 입력하세요.");
		System.out.print(">> ");
		String select = ScanUtil.nextLine();
		vo.setRouteNo(select);
		
		ReservationVO list = reservationDao.getTimeList(0);
		System.out.println("시간:" + list);
		
		return View.RESERVATION;
	}
}
