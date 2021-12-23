package anabada.semi.notice.model.vo;

public class Notice {
	
	private int noticeNo;
	private String noticeContent;
	private int itemNo;
	private int shopNo;
	private int memberNo;
	private int status;
	
	public Notice() {
		// TODO Auto-generated constructor stub
	}
	
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public int getShopNo() {
		return shopNo;
	}
	public void setShopNo(int shopNo) {
		this.shopNo = shopNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", noticeContent=" + noticeContent + ", itemNo=" + itemNo + ", shopNo="
				+ shopNo + ", memberNo=" + memberNo + ", status=" + status + "]";
	}
	
	
}
