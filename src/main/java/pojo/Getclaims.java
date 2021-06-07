package pojo;

import java.util.List;

public class Getclaims {
	
	private int myQueue;
	private int myClaim;
	private int assigned;
	private int inProgress;
	private int delayed;
	private int reportSubmitted;
	private int needAttention;
	private int allClaim;
	private List<ClaimResponse> claimResponse;
	public int getMyQueue() {
		return myQueue;
	}
	public void setMyQueue(int myQueue) {
		this.myQueue = myQueue;
	}
	public int getMyClaim() {
		return myClaim;
	}
	public void setMyClaim(int myClaim) {
		this.myClaim = myClaim;
	}
	public int getAssigned() {
		return assigned;
	}
	public void setAssigned(int assigned) {
		this.assigned = assigned;
	}
	public int getInProgress() {
		return inProgress;
	}
	public void setInProgress(int inProgress) {
		this.inProgress = inProgress;
	}
	public int getDelayed() {
		return delayed;
	}
	public void setDelayed(int delayed) {
		this.delayed = delayed;
	}
	public int getReportSubmitted() {
		return reportSubmitted;
	}
	public void setReportSubmitted(int reportSubmitted) {
		this.reportSubmitted = reportSubmitted;
	}
	public int getNeedAttention() {
		return needAttention;
	}
	public void setNeedAttention(int needAttention) {
		this.needAttention = needAttention;
	}
	public int getAllClaim() {
		return allClaim;
	}
	public void setAllClaim(int allClaim) {
		this.allClaim = allClaim;
	}
	public List<ClaimResponse> getClaimResponse() {
		return claimResponse;
	}
	public void setClaimResponse(List<ClaimResponse> claimResponse) {
		this.claimResponse = claimResponse;
	}
	
	

}
