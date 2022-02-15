package Corporation;

public class Status {
	private boolean	manager = false;
	private int		year = 0;
	
	public Status() {
		
	}
	
	public Status(int year) {
		this.setYear(year);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Status [manager=");
		builder.append(manager);
		builder.append(", year=");
		builder.append(year);
		builder.append("]");
		return builder.toString();
	}

	public Status(boolean manager) {
		this.setManager(manager);
	}
	
	public Status(int year, boolean manager) {
		this.setManager(manager);
		this.setYear(year);
	}

	public boolean isManager() {
		return manager;
	}

	public int getYear() {
		return year;
	}

	public void setManager(boolean manager) {
		this.manager = manager;
	}

	public void setYear(int year) {
		this.year = year;
	}
}