
package ddit.or.kr.collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapTest03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, Phone> map = new HashMap<>();
		int count = 1;
		System.out.println("===============================");
		System.out.println("전화번호 관리 프로그램");
		System.out.println("===============================");
		System.out.println();
		
		while (true) {
			System.out.println("메뉴를 선택하세요");
			System.out.println("1. 전화번호 등록");
			System.out.println("2. 전화번호 수정");
			System.out.println("3. 전화번호 삭제");
			System.out.println("4. 전화번호 검색");
			System.out.println("5. 전화번호 전체 출력");
			System.out.println("0. 프로그램 종료");
			System.out.print("번호입력 >>");
			int select = Integer.parseInt(sc.nextLine());
			Phone phone = new Phone();
			if (select == 1) {
				System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
				System.out.print("이름 >> ");
				String name = sc.nextLine();
				System.out.print("전화번호 >> ");
				String phoneNum = sc.nextLine(); 
				System.out.print("주소 >> ");
				String address = sc.nextLine();
				phone.setName(name);
				phone.setPhoneNum(phoneNum);
				phone.setAddress(address);
				map.put(name, phone);
				System.out.println("등록이 완료되었습니다.");
				System.out.println();
			} else if (select == 2) {
				System.out.println("수정할 사용자의 이름을 입력하세요.");
				System.out.print("이름입력 >> ");
				String name = sc.nextLine();
				map.put(name, phone);
				System.out.print("수정할 번호입력 >> ");
				String modifyNum = sc.nextLine();
				System.out.print("수정할 주소입력 >> ");
				String modifyAddr = sc.nextLine();
				phone.setPhoneNum(modifyNum);
				phone.setAddress(modifyAddr);
				System.out.println("수정완료!!");
				System.out.println();
			} else if (select == 3) {
				System.out.println("삭제할 사용자의 이름을 입력하세요.");
				System.out.print("이름입력 >>");
				String name = sc.nextLine();
				map.remove(name);
				System.out.println("삭제가 완료되었습니다!");
				System.out.println();
			} else if (select == 4) {
				System.out.println("검색할 이름을 입력하세요.");
				System.out.print("이름입력 >>");
				String name = sc.nextLine();
				System.out.println("=============================================");
				System.out.println("이름      전화번호           주소");
				System.out.println("=============================================");
				System.out.println(name +"\t"+ map.get(name));
				System.out.println("=============================================");
				System.out.println();
			} else if (select == 5) {
				System.out.println("=============================================");
				System.out.println("번호      이름      전화번호           주소");
				System.out.println("=============================================");
				count = 1;
				for (String key : map.keySet()) {
					System.out.println(count+ "\t" + key +"\t"+ map.get(key));
					count++;
				}
				System.out.println("=============================================");
			} else if (select == 0) {
				System.out.println("프로그램을 종료합니다...");
				break;
			} else {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			} 
		}
		
	}
}
