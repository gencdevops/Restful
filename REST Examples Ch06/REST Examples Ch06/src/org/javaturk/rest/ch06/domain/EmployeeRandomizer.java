package org.javaturk.rest.ch06.domain;

import java.util.Random;

public class EmployeeRandomizer {

	private static long count;
	private static Random random = new Random();

	private static String[] firstNames = { "Ali", "Ayse", "Bahar", "Bekir", "Bulent", "Can", "Cem", "Demet", "Elif",
			"Eylem", "Faruk", "Fatma", "Ganime", "Gulsum", "Haydar", "Halil", "Ismail", "Jale", "Kemal", "Leman",
			"Mehmet", "Mihrimah", "Murat", "Mustafa", "Nedim", "Nilufer", "Selim", "Selman", "Sevda", "S¸leyman",
			"Tarik", "Teoman", "Turgut", "Yeliz", "Zuhal" };

	private static String[] departments = { "Production", "Sales", "Marketing", "Engineering" };

	public static long createId() {
		return ++count;
	}

	public static String createName() {
		int randomInt = random.nextInt(35);
		return firstNames[randomInt];
	}

	public static Department createDepartment() {
		int randomInt = random.nextInt(4);
		return new Department(randomInt, departments[randomInt]);
	}

	public static char createSex() {
		return 'u';
	}

	public static EmployeeRank createRank() {
		return EmployeeRank.FIRST;
	}
}
