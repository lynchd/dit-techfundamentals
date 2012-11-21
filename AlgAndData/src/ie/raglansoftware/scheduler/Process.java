package ie.raglansoftware.scheduler;

/**
 * @author David Lynch (C) 2011
 */
public class Process
	implements Comparable<Process>
{
	private PriorityClass priorityClass;
	private Long lastRan;
	
	public Process() {
		priorityClass = PriorityClass.NORMAL;
		lastRan = Long.MIN_VALUE;
	}
	
	public Process(PriorityClass pClass) {
		this();
		this.priorityClass=pClass;
	}
	
	public Process(PriorityClass pClass, Long lastRan) {
		this(pClass);
		this.lastRan=lastRan;
	}


	public PriorityClass getPriorityClass() {
		return priorityClass;
	}

	public Long getLastRan() {
		return lastRan;
	}

	@Override
	/**
	 * Where two processes Px and Py share a priority-class, they are distinguished by timestamps Tx and Ty such that 
	 * 	-	PTx > PTy when Tx < Ty 
	 * 	-   PTx < PTy when Tx > Ty
	 * 	-   Either Px or Py is chosen at random when Tx == Ty
	 *  -   MIN(T) is set to Long.MIN_VALUE and is the initial timestamp value of a process. 
	 */
	public int compareTo(Process other) {
		final int LOWER = -1;
		final int EQUAL = 0;
		final int HIGHER = 1;
		
		if (other==null) {
			return HIGHER;
		}
		
		if (priorityClassEqualTo(other)) {
			if (this.lastRan<other.lastRan) {
				return HIGHER;
			}
			else if (this.lastRan>other.lastRan) {
				return LOWER;
			}
			else {
				return EQUAL;
			}
		}
		else {
			return priorityClass.getPriorityValue().compareTo(other.getPriorityClass().getPriorityValue());
		}
	}
	
	public boolean priorityClassEqualTo(Process other) {
		return (this.priorityClass.getPriorityValue().equals(other.getPriorityClass().getPriorityValue()));
	}

	public boolean isGreaterThan(Process other) {
		if (this.compareTo(other)==1) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		String str = priorityClass.toString();
		str = (str + "(" + this.getLastRan() + ")");
		return str;
	}

	public void setLastRan(Long lastRan) {
		this.lastRan = lastRan;
	}
}
