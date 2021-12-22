package anabada.semi.shop.model.vo;

import java.sql.Timestamp;

//W.ITEM_NO, I.ITEM_NM, I.ITEM_PRICE, I.ITEM_DATE, E.IMG_PATH, IMG_NM
public class Wish {
	private int memberNo;
	private int itemNo;
	private String itemName;
	private String itemPrice;
	private Timestamp itemDate;
	private String imgPath;
	private String imgName;
	
	private String uploadDate;
	
	public Wish() {
		// TODO Auto-generated constructor stub
	}

	
	
	public String getUploadDate() {
		return uploadDate;
	}



	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}



	public int getItemNo() {
		return itemNo;
	}


	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}


	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
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

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	
}
