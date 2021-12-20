package anabada.semi.item.model.vo;

import java.sql.Timestamp;
import java.util.Date;

public class Reply {
	
	private int replyNo;
	private String replyContent;
	private Timestamp replyDate;
	private int replySecret;
	private int memberNo;
	private int itemNo;
	private int replyStatusCode;
	
	private String memberName;
	
	public Reply() {
		// TODO Auto-generated constructor stub
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Timestamp getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(Timestamp replyDate) {
		this.replyDate = replyDate;
	}

	public int getReplySecret() {
		return replySecret;
	}

	public void setReplySecret(int replySecret) {
		this.replySecret = replySecret;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public int getReplyStatusCode() {
		return replyStatusCode;
	}

	public void setReplyStatusCode(int replyStatusCode) {
		this.replyStatusCode = replyStatusCode;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Override
	public String toString() {
		return "Reply [replyNo=" + replyNo + ", replyContent=" + replyContent + ", replyDate=" + replyDate
				+ ", replySecret=" + replySecret + ", memberNo=" + memberNo + ", itemNo=" + itemNo
				+ ", replyStatusCode=" + replyStatusCode + ", memberName=" + memberName + "]";
	}
	
	
	
}
