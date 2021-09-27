package service;

import java.sql.SQLIntegrityConstraintViolationException;

import dao.UserDAO;
import util.ScanUtil;
import util.View;
import vo.MemberVO;

public class JoinService {
	private UserDAO userDao = UserDAO.getInstance();
	private static JoinService instance = new JoinService();
	public static JoinService getInstance() {
		return instance;
	}
	private JoinService() {}
	
	public int join() throws Exception {
		MemberVO vo = new MemberVO();
		System.out.println(">>>>>회원가입<<<<<");
		while(true) {
			try {
				System.out.print("아이디 : ");
				String memId = ScanUtil.nextLine();
				vo.setMemId(memId);
				userDao.insertMember(vo);
				break;
			} catch (SQLIntegrityConstraintViolationException e) {
				System.out.println("아이디가 존재합니다.");
			}
		}
		System.out.print("이름 : ");
		String memNm = ScanUtil.nextLine();
		System.out.print("패스워드 : ");
		String memPw = ScanUtil.nextLine();
		System.out.print("나이(숫자만 입력) : ");
		int memAge = ScanUtil.nextInt();
		System.out.print("주소 : ");
		String memAddress = ScanUtil.nextLine();
		System.out.print("메일 : ");
		String memMail = ScanUtil.nextLine();
		System.out.print("전화번호 : ");
		String memPhone = ScanUtil.nextLine();
		System.out.print("충전할 금액 : ");
		int memBalance = ScanUtil.nextInt();
		vo.setMemName(memNm);
		vo.setMemPw(memPw);
		vo.setMemAge(memAge);
		vo.setMemAddress(memAddress);
		vo.setMemMail(memMail);
		vo.setMemPhone(memPhone);
		vo.setMemBalance(memBalance);
		int result = userDao.updateMember(vo);
		if (result > 0) {
			System.out.println("회원가입을 축하드립니다~!");
		}
		else {
			System.out.println("회원가입 실패하였습니다.");
		}
	return View.HOME;
	}
}