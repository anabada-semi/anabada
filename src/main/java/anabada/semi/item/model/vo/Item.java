package anabada.semi.item.model.vo;

public class Item {

	private int itemNo;
	private String itemName;
	private int itemPrice;
	private String itemImg;
	private String itemInfo;
	private String itemDate;
	private int categoryCode;
	private int itemStatusCode;
	private int memberNo;
	
//	CATEGORY 테이블의 CATEGORY_NM 추가
	private String categoryName;
	
//	기본 생성자
	public Item() {	}
	
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemImg() {
		return itemImg;
	}
	public void setItemImg(String itemImg) {
		this.itemImg = itemImg;
	}
	public String getItemInfo() {
		return itemInfo;
	}
	public void setItemInfo(String itemInfo) {
		this.itemInfo = itemInfo;
	}
	public String getItemDate() {
		return itemDate;
	}
	public void setItemDate(String itemDate) {
		this.itemDate = itemDate;
	}
	public int getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}
	public int getItemStatusCode() {
		return itemStatusCode;
	}
	public void setItemStatusCode(int itemStatusCode) {
		this.itemStatusCode = itemStatusCode;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	
	// CATEGORY_NM 추가
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Item [itemNo=" + itemNo + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", itemImg=" + itemImg
				+ ", itemInfo=" + itemInfo + ", itemDate=" + itemDate + ", categoryCode=" + categoryCode
				+ ", itemStatusCode=" + itemStatusCode + ", memberNo=" + memberNo + ", categoryName=" + categoryName
				+ "]";
	}

	
}
