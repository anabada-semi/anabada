package anabada.semi.item.model.vo;

import java.util.Date;

public class Reply {
	
	private int ReplyNo;
	private String ReplyContent;
	private Date ReplyDate;
	private int ReplySecret;
	private int MemberNo;
	private int ItemNo;
	private int ReplyStatusCode;
	
	public Reply() {
		// TODO Auto-generated constructor stub
	}
	
	public int getReplyNo() {
		return ReplyNo;
	}

	public void setReplyNo(int replyNo) {
		ReplyNo = replyNo;
	}

	public String getReplyContent() {
		return ReplyContent;
	}

	public void setReplyContent(String replyContent) {
		ReplyContent = replyContent;
	}

	public Date getReplyDate() {
		return ReplyDate;
	}

	public void setReplyDate(Date replyDate) {
		ReplyDate = replyDate;
	}

	public int getReplySecret() {
		return ReplySecret;
	}

	public void setReplySecret(int replySecret) {
		ReplySecret = replySecret;
	}

	public int getMemberNo() {
		return MemberNo;
	}

	public void setMemberNo(int memberNo) {
		MemberNo = memberNo;
	}

	public int getItemNo() {
		return ItemNo;
	}

	public void setItemNo(int itemNo) {
		ItemNo = itemNo;
	}

	public int getReplyStatusCode() {
		return ReplyStatusCode;
	}

	public void setReplyStatusCode(int replyStatusCode) {
		ReplyStatusCode = replyStatusCode;
	}


	@Override
	public String toString() {
		return "Reply [ReplyNo=" + ReplyNo + ", ReplyContent=" + ReplyContent + ", ReplyDate=" + ReplyDate
				+ ", ReplySecret=" + ReplySecret + ", MemberNo=" + MemberNo + ", ItemNo=" + ItemNo
				+ ", ReplyStatusCode=" + ReplyStatusCode + "]";
	}
	
	
}
