package com.pratik.teenpatti;

import java.util.Scanner;

public class Utility {

	static Scanner scanner = new Scanner(System.in);

	static void print(String s) {
		System.out.print(s);
	}

	static void printLine(String s) {
		System.out.println(s);
	}

	static int randomNumber(int num) {
		return (int) (Math.random() * num);
	}

	static int getInt(String s) {
		System.out.println(s);
		return scanner.nextInt();

	}

	public static String getString(String string) {
		System.out.println(string);
		return scanner.next();

	}

	public static char getChar(String string) {
		System.out.println(string);
		return scanner.next().charAt(0);

	}
}
