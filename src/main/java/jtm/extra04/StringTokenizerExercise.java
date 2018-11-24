package jtm.extra04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Scanner;
/*-
 * 
 * This class represents string tokenizer exercise.
 */

public class StringTokenizerExercise {

	public String[] splitString(String text, String delimiter) {
		String[] list = text.split(delimiter);
		// # 1 Split passed text by given delimiter and return array with
		// split strings.
		// HINT: Use System.out.println to better understand split method's
		// functionality.
		return list;

	}

	// public static void main(String[] args) {
	// String text = "Rihards tests";
	// String delimiter = "R";
	// String[] list2 = null;
	// list2 = text.split(delimiter);
	// for (int i = 0; i < list2.length; i++)
	// System.out.println(list2[i]);
	// }

	public List<String> tokenizeString(String text, String delimiter) {
		// # 2 Tokenize passed text by given delimiter and return list with
		// tokenized strings.
		StringTokenizer tokenizeS = new StringTokenizer(text, delimiter);

		List<String> list = new ArrayList<>();
		for (int i = 1; tokenizeS.hasMoreTokens(); i++) {
			list.add(tokenizeS.nextToken());
		}

		return list;
	}

	public List<Student> createFromFile(String filepath, String delimiter) {
		File students = new File(filepath);
		List<Student> list = new ArrayList<Student>();
		BufferedReader in = null;
		// TODO # 3 Implement method which reads data from file and creates
		// Student objects with that data. Each line from file contains data for
		// 1 Student object.
		// Add students to list and return the list. Assume that all passed data
		// and
		// files are correct and in proper form.
		// Advice: Explore StringTokenizer or String split options.
		return list;
	}

}
