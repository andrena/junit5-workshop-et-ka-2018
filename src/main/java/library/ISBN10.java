package library;

import java.util.ArrayList;

public class ISBN10 implements ISBNType {

	private static final int checkDigitIndex = 3;
	private static final int titleNumberIndex = 2;
	private static final int publisherNumberIndex = 1;
	private static final int groupNumberIndex = 0;

	@Override
	public boolean isOfType(String ISBN) {
		String[] splittedISBN = ISBN.split("-");
		if (splittedISBN.length != 4) {
			return false;
		}
		ArrayList<Integer> numbers = getAsList(splittedISBN);
		return (calculateCheckDigit(numbers) == numbers.get(0));
	}

	private ArrayList<Integer> getAsList(String[] splittedISBN) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(Integer.parseInt(splittedISBN[groupNumberIndex]));
		numbers.addAll(getAsSingleNumbers(splittedISBN[publisherNumberIndex]));
		numbers.addAll(getAsSingleNumbers(splittedISBN[titleNumberIndex]));
		numbers.add(0, Integer.parseInt(splittedISBN[checkDigitIndex]));
		return numbers;
	}

	private int calculateCheckDigit(ArrayList<Integer> numbers) {
		int calculatedCheckDigit = 0;
		for (int i = 1; i <= 9; i++) {
			calculatedCheckDigit += numbers.get(i) * i;
		}
		return calculatedCheckDigit % 11;
	}

	private ArrayList<Integer> getAsSingleNumbers(String numberString) {
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		char[] numberArray = numberString.toCharArray();
		for (int i = 0; i < numberArray.length; i++) {
			numberList.add(Integer.parseInt(String.valueOf(numberArray[i])));
		}
		return numberList;
	}

}
