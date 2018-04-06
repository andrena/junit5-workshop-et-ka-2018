package library.activies.reading;

public class Progression {

	private double knowledge = 0.0;
	private double fun = 0.0;

	public double getKnowledge() {
		return knowledge;
	}

	Progression addKnowledge(double knowledge) {
		this.knowledge += knowledge;
		return this;
	}

	Progression addFun(double fun) {
		this.fun += fun;
		return this;
	}

	public double getFun() {
		return fun;
	}

}
