package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class HotelDAO {

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	// 커넥션 풀을 이용한 데이터 베이스 연결
	public void getCon() {

		Boolean connect = false;

		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/jwdb");

			con = ds.getConnection();//
			connect = true;

		} catch (Exception e) {
			connect = false;
			e.printStackTrace();
		}

		if (connect) {
			System.out.println("연결o");
		} else {
			System.out.println("연결x");
		}
	}

	// 최신순 3개의 호텔방을 리턴하는 메소드
	public ArrayList<HotelRoomListDTO> getSelectHotel() {

		// 리턴타입을 설정
		ArrayList<HotelRoomListDTO> arrayList = new ArrayList();
		getCon();

		try {
			String sql = "SELECT * FROM hotel ORDER BY no DESC";
			pstmt = con.prepareStatement(sql);
			// 쿼리 실행후 결과를 ResultSet타입으로 리턴
			rs = pstmt.executeQuery();

			// 반복문을 돌면서 데이터를 저장
			int count = 0;
			while (rs.next()) {
				HotelRoomListDTO dto = new HotelRoomListDTO();
				dto.setNo(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setCategory(rs.getInt(3));
				dto.setPrice(rs.getInt(4));
				dto.setUsepeople(rs.getInt(5));
				dto.setRoomlevel(rs.getString(6));
				dto.setImg(rs.getString(7));
				dto.setInfo(rs.getString(8));
				// arrayList에 DTO클래스를 저장
				arrayList.add(dto);
				count++;
				if (count > 2)// 4개만 나오게 하기
					break;// 반복문 빠져 나가기
				// 3개만 arrayList 저장

			}
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return arrayList;
	}

	// 카테고리별 호텔룸을 리스트를 저장하는 메소드
	public ArrayList<HotelRoomListDTO> getCategoryHotel(int cate) {

		// 리턴타입을 설정
		ArrayList<HotelRoomListDTO> arrayList = new ArrayList();
		// 데이터를 저장할 DTO클래스 선언
		HotelRoomListDTO dto = null;
		// 객체 연결
		getCon();

		try {
			// 쿼리준비
			String sql = "SELECT * FROM hotel WHERE category=?";
			pstmt = con.prepareStatement(sql);
			// ?
			pstmt.setInt(1, cate);
			// 결과를 리턴
			rs = pstmt.executeQuery();
			// 반복문을 돌면서 데이터를 저장
			while (rs.next()) {
				// 데이터를 저장할 DTO클래스 생성
				dto = new HotelRoomListDTO();
				dto.setNo(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setCategory(rs.getInt(3));
				dto.setPrice(rs.getInt(4));
				dto.setUsepeople(rs.getInt(5));
				dto.setRoomlevel(rs.getString(6));
				dto.setImg(rs.getString(7));
				dto.setInfo(rs.getString(8));
				// arrayList에 DTO클래스를 저장
				arrayList.add(dto);

			}
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return arrayList;

	}

	// 모든 호텔방을 검색하는 메소드
	public ArrayList<HotelRoomListDTO> getAllHotel() {

		// 리턴타입을 설정
		ArrayList<HotelRoomListDTO> arrayList = new ArrayList();
		// 데이터를 저장할 DTO클래스 선언
		HotelRoomListDTO dto = null;
		// 객체 연결
		getCon();

		try {
			// 쿼리준비
			String sql = "SELECT * FROM hotel";
			pstmt = con.prepareStatement(sql);
			// ?
			// pstmt.setInt(1, cate);
			// 결과를 리턴
			rs = pstmt.executeQuery();
			// 반복문을 돌면서 데이터를 저장
			while (rs.next()) {
				// 데이터를 저장할 dto클래스 생성
				dto = new HotelRoomListDTO();
				dto.setNo(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setCategory(rs.getInt(3));
				dto.setPrice(rs.getInt(4));
				dto.setUsepeople(rs.getInt(5));
				dto.setRoomlevel(rs.getString(6));
				dto.setImg(rs.getString(7));
				dto.setInfo(rs.getString(8));
				// arrayList에 dto클래스를 저장
				arrayList.add(dto);

			}
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return arrayList;
	}

	// 하나의 호텔룸에 대한 정보를 리턴하는 메소드
	public HotelRoomListDTO getOneHotel(int no) {

		// 리턴타입 선언
		HotelRoomListDTO dto = new HotelRoomListDTO();
		getCon();

		try {

			// 쿼리 준비
			String sql = "SELECT * FROM hotel WHERE no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			// 결과를 리턴
			rs = pstmt.executeQuery();
			// 반복문을 돌면서 데이터를 저장
			if (rs.next()) {
				// 데이터를 저장할 dto클래스 생성
				// dto = new HotelRoomListDTO(); //위에서 생성 선언
				dto.setNo(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setCategory(rs.getInt(3));
				dto.setPrice(rs.getInt(4));
				dto.setUsepeople(rs.getInt(5));
				dto.setRoomlevel(rs.getString(6));
				dto.setImg(rs.getString(7));
				dto.setInfo(rs.getString(8));
				// arrayList에 dto클래스를 저장
				// arrayList.add(bean);

			}
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dto;

	}

	// 회원정보가 있는지를 비교
	public int getMember(String id, String pass) {

		int result = 0;
		getCon();

		try {

			String sql = "SELECT COUNT(*) FROM member WHERE id=? AND pass1=?;";
			pstmt = con.prepareStatement(sql);
			// ?
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			// 결과리턴
			rs = pstmt.executeQuery();
			// 데이터가 있다면
			if (rs.next()) {
				result = rs.getInt(1);// 0또는 1값이 저장됨
			}
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;

	}

	// 하나의 예약 정보를 저장하는 메소드
	public void setReserveHotel(HotelReserveDTO dto) {

		getCon();

		try {
			String sql = "INSERT INTO hotelreserve VALUES(?,?,?,?,?,?,?) ";
			pstmt = con.prepareStatement(sql);
			// ??값을대입reserveno
			pstmt.setInt(1, dto.getReserveno());
			pstmt.setInt(2, dto.getNo());
			pstmt.setString(3, dto.getId());
			pstmt.setString(4, dto.getRoomlevel());
			pstmt.setInt(5, dto.getDday());
			pstmt.setString(6, dto.getRday());
			pstmt.setInt(7, dto.getUsebackfast());
			// 쿼리실행
			pstmt.executeUpdate();
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	//회원의 예약 정보를 리턴하는 메소드  
	//SELECT * FROM rentcar NATURAL JOIN carreserve WHERE NOW() < rday AND id='test11';
	public ArrayList<HotelViewDTO> getAllReserve(String id) {

		ArrayList<HotelViewDTO> arrayList = new ArrayList<>();
		HotelViewDTO dto = null;
		
		getCon();
		
		try {
			String sql="SELECT * FROM hotel NATURAL JOIN hotelreserve WHERE NOW() < rday AND id=?";
			pstmt = con.prepareStatement(sql);
			//??
			pstmt.setString(1, id);
			//결과 리턴
			rs = pstmt.executeQuery();
			//한사람이 여러 id를 사용할수 있기에
			while(rs.next()) {//데이터가 하나라도 있다면
				dto = new HotelViewDTO();
				dto.setName(rs.getString(3));
				dto.setPrice(rs.getInt(5));
				dto.setImg(rs.getString(7));
				dto.setRoomlevel(rs.getString(2));
				dto.setDday(rs.getInt(11));
				dto.setRday(rs.getString(12));
				dto.setUsebackfast(rs.getInt(13));
				//ArrayList 에 저장
				arrayList.add(dto);
			}
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return arrayList;
		
	}
	//하나의 예약 삭제
	public void hotelRemoveReserve(String id, String rday) {
		
		getCon();
		
		try {
			String sql="DELETE FROM  hotelreserve WHERE id=? AND rday=?";
			pstmt = con.prepareStatement(sql);
			//?
			pstmt.setString(1, id);
			pstmt.setString(2, rday);
			//쿼리실행
			pstmt.executeUpdate();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	

}
