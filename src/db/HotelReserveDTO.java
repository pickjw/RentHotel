package db;

import java.sql.Date;

public class HotelReserveDTO {
	
	private int reserveno;
	private int no;
	private String id;
	private String roomlevel;
	private int dday;// 기간
	private String rday;//날짜
	private int usebackfast;
	
	
	public int getReserveno() {
		return reserveno;
	}
	public void setReserveno(int reserveno) {
		this.reserveno = reserveno;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoomlevel() {
		return roomlevel;
	}
	public void setRoomlevel(String roomlevel) {
		this.roomlevel = roomlevel;
	}
	public int getDday() {
		return dday;
	}
	public void setDday(int dday) {
		this.dday = dday;
	}
	public String getRday() {
		return rday;
	}
	public void setRday(String rday) {
		this.rday = rday;
	}
	public int getUsebackfast() {
		return usebackfast;
	}
	public void setUsebackfast(int usebackfast) {
		this.usebackfast = usebackfast;
	}
	
	
	
}
