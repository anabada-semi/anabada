package anabada.semi.reply.model.vo;

public class Reply {
	
	private int replyNo;
	private String replyContent;
	private String replyDt;
	private int replySecret;
	private int memberNo;
	private int itemNo;
	private int replyStatusNo;
	
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
	public String getReplyDt() {
		return replyDt;
	}
	public void setReplyDt(String replyDt) {
		this.replyDt = replyDt;
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
	public int getReplyStatusNo() {
		return replyStatusNo;
	}
	public void setReplyStatusNo(int replyStatusNo) {
		this.replyStatusNo = replyStatusNo;
	}
	
	@Override
	public String toString() {
		return "Reply [replyNo=" + replyNo + ", replyContent=" + replyContent + ", replyDt=" + replyDt
				+ ", replySecret=" + replySecret + ", memberNo=" + memberNo + ", itemNo=" + itemNo + ", replyStatusNo="
				+ replyStatusNo + "]";
	}
	
	
	
}
