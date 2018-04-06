package common;

import java.util.ArrayList;
import java.util.List;

import library.Page;

public class PageFactory {

	public static List<Page> createPages(int pageAmount) {
		List<Page> pages = new ArrayList<>();
		for (int i = 0; i < pageAmount; i++) {
			pages.add(new Page(i));
		}
		return pages;
	}

}
