package interfaces;

import Locations.Node;

public interface Visitable {
	void setOpeningHour(String openingHour);
	void setClosingHour(String closingHour);
	String getOpeningHour();
	String getClosingHour();

	default void defaultScheduel(){
		setOpeningHour("09:30");
		setClosingHour("20:00");
	}

	static Duration getVisitingDuration(Visitable node){
		Duration location = new Duration();

		location.setOpeningHour(node.getOpeningHour());
		location.setClosingHour(node.getClosingHour());

		return location;
	}

	class Duration {
		String openingHour = new String();
		String closingHour = new String();

		public void setClosingHour(String closingHour) {
			this.closingHour = closingHour;
		}

		public void setOpeningHour(String openingHour) {
			this.openingHour = openingHour;
		}

		public String getClosingHour() {
			return closingHour;
		}

		public String getOpeningHour() {
			return openingHour;
		}

		@Override
		public String toString() {
			return openingHour + "-" + closingHour;
		}
	}
}
