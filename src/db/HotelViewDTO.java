package db;

public class HotelViewDTO {
	
	private String name;
	private int price;
	private String img;
	private String roomlevel;
	private int dday;
	private String rday;
	private int usebackfast;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
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
