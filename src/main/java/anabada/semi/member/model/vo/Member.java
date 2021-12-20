package anabada.semi.member.model.vo;

public class Member {
	private int memberNo;
	private String memberId;
	private String memberPw;
	private String memberNm;
	private String memberEmail;
	private String memberPhone;
	private String memberAddress;
	private String enrollDate;
	
	
	public Member() {}


	
	
	public Member(String memberId, String memberPw, String memberNm, String memberEmail, String memberPhone,
			String memberAddress) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberNm = memberNm;
		this.memberEmail = memberEmail;
		this.memberPhone = memberPhone;
		this.memberAddress = memberAddress;
	}


	

	public Member(int memberNo, String memberPw, String memberNm, String memberEmail, String memberPhone,
			String memberAddress) {
		super();
		this.memberNo = memberNo;
		this.memberPw = memberPw;
		this.memberNm = memberNm;
		this.memberEmail = memberEmail;
		this.memberPhone = memberPhone;
		this.memberAddress = memberAddress;
	}




	public int getMemberNo() {
		return memberNo;
	}


	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public String getMemberPw() {
		return memberPw;
	}


	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}


	public String getMemberNm() {
		return memberNm;
	}


	public void setMemberNm(String memberNm) {
		this.memberNm = memberNm;
	}


	public String getMemberEmail() {
		return memberEmail;
	}


	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}


	public String getMemberPhone() {
		return memberPhone;
	}


	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}


	public String getMemberAddress() {
		return memberAddress;
	}


	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}


	public String getEnrollDate() {
		return enrollDate;
	}


	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}


	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPw=" + memberPw + ", memberNm="
				+ memberNm + ", memberEmail=" + memberEmail + ", memberPhone=" + memberPhone + ", memberAddress="
				+ memberAddress + ", enrollDate=" + enrollDate + "]";
	}


	
	
}
