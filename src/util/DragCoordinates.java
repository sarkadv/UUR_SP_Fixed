package util;

public class DragCoordinates {
	
	private double startX;
	private double startY;
	private double endX;
	private double endY;
	
	public DragCoordinates(double startX, double startY, double endX, double endY) {
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
	}

	public double getStartX() {
		return startX;
	}

	public double getStartY() {
		return startY;
	}

	public double getEndX() {
		return endX;
	}

	public double getEndY() {
		return endY;
	}

	public void setEndX(double endX) {
		this.endX = endX;
	}

	public void setEndY(double endY) {
		this.endY = endY;
	}

}
