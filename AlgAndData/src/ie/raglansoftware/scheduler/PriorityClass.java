package ie.raglansoftware.scheduler;

/**
 * @author David Lynch (C) 2011
 */
public enum PriorityClass {
	BACKGROUND("Background",0),
	NORMAL("Normal",1),
	CRITICAL("Critcal",2);
	
	private String 	stringRepresentation;
	private Integer priority;
	
	private PriorityClass(String stringRepresentation, Integer priority) {
		this.stringRepresentation=stringRepresentation;
		this.priority=priority;
	}
	@Override
	public String toString() {
		return this.stringRepresentation;
	}
	public Integer getPriorityValue() {
		return priority;
	}
}
