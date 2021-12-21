package anabada.semi.shop.model.vo;

public class PostScript {
	private int postScriptNo;
	private String postScriptCheck;
	private int postScriptStatusCode;
	private int shopNo;
	private int memberNo;
	private String shopName;
	
	


	public PostScript() {}
	
	
	public int getShopNo() {
		return shopNo;
	}


	public void setShopNo(int shopNo) {
		this.shopNo = shopNo;
	}


	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	
	public int getPostScriptNo() {
		return postScriptNo;
	}
	public void setPostScriptNo(int postScriptNo) {
		this.postScriptNo = postScriptNo;
	}
	public String getPostScriptCheck() {
		return postScriptCheck;
	}
	public void setPostScriptCheck(String postScriptCheck) {
		this.postScriptCheck = postScriptCheck;
	}
	public int getPostScriptStatusCode() {
		return postScriptStatusCode;
	}
	public void setPostScriptStatusCode(int postScriptStatusCode) {
		this.postScriptStatusCode = postScriptStatusCode;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	
	
}
