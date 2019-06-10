package DTO;

import lms.domain.EvaluationType;

public class EvaluationPointsDTO {
	
	private EvaluationType evaluationType;
	private int maxPoints;
	private int pointsAchieved;
	
	public EvaluationPointsDTO() {
	}
	
	public EvaluationPointsDTO(EvaluationType evaluationType, int maxPoints, int pointsAchieved) {
		this.evaluationType = evaluationType;
		this.maxPoints = maxPoints;
		this.pointsAchieved = pointsAchieved;
	}
	
	public EvaluationType getEvaluationType() {
		return evaluationType;
	}
	public void setEvaluationType(EvaluationType evaluationType) {
		this.evaluationType = evaluationType;
	}
	public int getMaxPoints() {
		return maxPoints;
	}
	public void setMaxPoints(int maxPoints) {
		this.maxPoints = maxPoints;
	}
	public int getPointsAchieved() {
		return pointsAchieved;
	}
	public void setPointsAchieved(int pointsAchieved) {
		this.pointsAchieved = pointsAchieved;
	}
	
	

}
