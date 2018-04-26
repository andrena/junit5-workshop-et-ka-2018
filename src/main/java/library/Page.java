package library;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Page {

	@Id
	@GeneratedValue
	private int id;

	public Page() {
	}

	public Page(int pageNumber) {
	}

}
