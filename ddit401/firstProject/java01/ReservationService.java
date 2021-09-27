package service;

import java.util.List;

import dao.ReservationDAO;
import util.ScanUtil;
import util.View;
import vo.ReservationVO;
import vo.RouteVO;
import vo.TimeVO;

public class ReservationService {
	private static ReservationService instance = new ReservationService();
	public static ReservationService getInstance() {
		return instance;
	}
	private ReservationService() {}
	
	private ReservationDAO reservationDao = ReservationDAO.getInstance();
	
	public int resrv() throws Exception {
		ReservationVO rsvVo = new ReservationVO();
		RouteVO vo = new RouteVO();
		List<RouteVO> arrivalList = reservationDao.getArrivalSpotList();
		System.out.println();
		System.out.println("<<<< 도착지 선택 >>>>");
		for (RouteVO routeVO : arrivalList) {
			System.out.println(routeVO);
		}
		System.out.println();
		System.out.println("노선번호를 입력하세요.");
		System.out.print(">> ");
		String routeNo = ScanUtil.nextLine();
		rsvVo.setRouteNo(routeNo);
		
		List<TimeVO> timeList = reservationDao.getTimeList(rsvVo.getRouteNo());
		for (TimeVO timeVO : timeList) {
			System.out.println("\t"+timeVO);
		}
		System.out.println("희망 시간을 선택하세요(':' 포함하여 입력)");
		System.out.print(">> ");
		String routeTime = ScanUtil.nextLine();
		rsvVo.setStartTime(routeTime);
		System.out.println("1.성인 / 2.아동");
		int ac = ScanUtil.nextInt();
		if (ac == 1) {
			reservationDao.getTicket(rsvVo.getRouteNo());
			System.out.println(vo.getNormalFee());
			System.out.println("성인요금을 선택하셨습니다.");
		
		} else if(ac == 2) {
			System.out.println("아동요금");
		}
		
		
		
		
		
		
		
		
		
		return View.RESERVATION;
	}
}