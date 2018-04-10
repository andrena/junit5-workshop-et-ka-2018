package library.activies.reading;

import library.Book;

public class FunReading implements ReadingMethod {

	private Progression progression;
	private double knowlegeFactor = 0.1;

	public FunReading(Book book) {
		this.progression = new Progression();
	}

	@Override
	public void read() {
		knowlegeFactor = knowlegeFactor * 0.1;
		progression.addFun(1.0).addKnowledge(knowlegeFactor);
	}

	@Override
	public Progression getProgession() {
		return progression;
	}

}
