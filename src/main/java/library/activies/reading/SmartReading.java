package library.activies.reading;

import library.Book;

public class SmartReading implements ReadingMethod {

	private Progression progression;
	private double knowlegeFactor = 0.1;

	public SmartReading(Book book) {
		this.progression = new Progression();
	}

	@Override
	public void read() {
		knowlegeFactor = knowlegeFactor * 0.4;
		progression.addFun(0.7).addKnowledge(knowlegeFactor);
	}

	@Override
	public Progression getProgession() {
		return progression;
	}

}
