package anabada.semi.shop.model.vo;

import java.sql.Timestamp;

// SELECT P.SHOP_NO PURCHASER, I.MEMBER_NO SELLER, P.ITEM_NO, P.ITEM_STATUS_CD, 
// I.ITEM_NM, I.ITEM_PRICE, I.ITEM_DATE, E.IMG_PATH, E.IMG_NM
public class Purchase {
	private int purchaser;
	private int seller;
	private int itemNo;
	private int itemStatusCode;
	private String itemName;
	private String itemPrice;
	private Timestamp itemDate;
	private String itemImgPath;
	private String itemImgName;
	private String uploadDate;
	
	public Purchase() {
		// TODO Auto-generated constructor stub
	}

	public int getPurchaser() {
		return purchaser;
	}

	public void setPurchaser(int purchaser) {
		this.purchaser = purchaser;
	}

	public int getSeller() {
		return seller;
	}

	public void setSeller(int seller) {
		this.seller = seller;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public int getItemStatusCode() {
		return itemStatusCode;
	}

	public void setItemStatusCode(int itemStatusCode) {
		this.itemStatusCode = itemStatusCode;
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

	public Timestamp getItemDate() {
		return itemDate;
	}

	public void setItemDate(Timestamp itemDate) {
		this.itemDate = itemDate;
	}

	public String getItemImgPath() {
		return itemImgPath;
	}

	public void setItemImgPath(String itemImgPath) {
		this.itemImgPath = itemImgPath;
	}

	public String getItemImgName() {
		return itemImgName;
	}

	public void setItemImgName(String itemImgName) {
		this.itemImgName = itemImgName;
	}

	public String getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
	
}
