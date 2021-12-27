package anabada.semi.notice.model.vo;

public class Notice {
	
	private int noticeNo;
	private int noticeContent;
	private int itemNo;
	private String itemName;
	private int shopNo;	// 판매자
	private int memberNo;	// 댓글 단 사람(로그인 한 사람)
	private int status;
	private int ReplyMemberNo;	// 대댓글 단 사람 번호
	private int PostSCriptNo;	// 댓글 번호
	
	public Notice() {
		// TODO Auto-generated constructor stub
	}
	
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public int getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(int noticeContent) {
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
	
	
	public int getReplyMemberNo() {
		return ReplyMemberNo;
	}

	public void setReplyMemberNo(int replyMemberNo) {
		ReplyMemberNo = replyMemberNo;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getPostSCriptNo() {
		return PostSCriptNo;
	}

	public void setPostSCriptNo(int postSCriptNo) {
		PostSCriptNo = postSCriptNo;
	}

	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", noticeContent=" + noticeContent + ", itemNo=" + itemNo
				+ ", itemName=" + itemName + ", shopNo=" + shopNo + ", memberNo=" + memberNo + ", status=" + status
				+ ", ReplyMemberNo=" + ReplyMemberNo + ", PostSCriptNo=" + PostSCriptNo + "]";
	}

	
	
}
