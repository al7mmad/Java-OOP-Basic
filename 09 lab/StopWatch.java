package lab_ObjectAndClass_stopWatch;

public class StopWatch {

	// Variables
	private long startTime = System.currentTimeMillis();
	private long  endTime = startTime ; 
	
	
	//Methods 
	public long getStartTime() {
		return this.startTime;
	}
	
	public long getEndTime() {
		return this.endTime;
	}
	
	public void start() {
		this.startTime = System.currentTimeMillis();
	}
	
	public void stop() {
		this.endTime = System.currentTimeMillis();
	}
	
	public long getElapsedTime() {
		return this.endTime - this.startTime;
	}
	
	
}
