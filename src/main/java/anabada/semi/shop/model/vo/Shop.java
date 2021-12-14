package anabada.semi.shop.model.vo;

public class Shop {
	private int memberNo;
	private String shopIntroduce;
	private String shopNo;
	
	public Shop() {}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getShopIntroduce() {
		return shopIntroduce;
	}

	public void setShopIntroduce(String shopIntroduce) {
		this.shopIntroduce = shopIntroduce;
	}

	public String getShopNo() {
		return shopNo;
	}

	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}

	@Override
	public String toString() {
		return "Shop [memberNo=" + memberNo + ", shopIntroduce=" + shopIntroduce + ", shopNo=" + shopNo + "]";
	}
	
}
