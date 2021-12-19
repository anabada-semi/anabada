package anabada.semi.item.model.vo;

public class Item {

	private int itemNo;
	private String itemName;
	private String itemPrice;
	private String itemImg;
	private String itemInfo;
	private String itemDate;
	private int categoryCode;
	private int itemStatusCode;
	private int memberNo;
	private int readCount;
	
//	CATEGORY 테이블의 CATEGORY_NM 추가
	private String categoryName;
	
//	WISH 테이블의 WISH 추가
	private int wish;
	
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
	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
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
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	// CATEGORY_NM 추가
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	// wish 추가
	public int getWish() {
		return wish;
	}
	
	public void setWish(int wish) {
		this.wish = wish;
	}

	@Override
	public String toString() {
		return "Item [itemNo=" + itemNo + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", itemImg=" + itemImg
				+ ", itemInfo=" + itemInfo + ", itemDate=" + itemDate + ", categoryCode=" + categoryCode
				+ ", itemStatusCode=" + itemStatusCode + ", memberNo=" + memberNo + ", readCount=" + readCount
				+ ", categoryName=" + categoryName + ", wish=" + wish + "]";
	}

	
}
