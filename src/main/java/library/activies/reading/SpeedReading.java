package library.activies.reading;

import library.Book;

public class SpeedReading implements ReadingMethod {

	private static final double KNOWLEDGE = 1.62;
	private static final double FUN = 0.1;

	private Progression progression;

	public SpeedReading(Book book) {
		progression = new Progression();
	}

	@Override
	public void read() {
		progression.addKnowledge(KNOWLEDGE).addFun(FUN);
	}

	@Override
	public Progression getProgession() {
		return progression;
	}

}
