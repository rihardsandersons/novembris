package jtm.activity11;

import java.util.LinkedList;

/**
 * This is frontend class for array filler. It uses ArrayFiller to fill array of
 * integers using sequental or concurrent (parallel) approach
 */
public class ArrayFillerManager {
	static int[] array; // array to be filled
	static int latency; // emulated latency in ms
	static int minValue, maxValue; // min and max (including) of the
									// array cell
	private static LinkedList<Thread> threads; // list of threads when parallel
	// filling is used

	// HINT feel free to use main() method to call setUp(), fillStupidly() etc.
	// for debugging purposes if unit tests doesn't show enough information,
	// what exactly in implementation seems wrong.
	// Note that main() method will not be used in unit tests.

	public static int[] setUp(int arraySize, int latency, int minValue, int maxValue) {
		// save passed values in prepared structure
		// initialize array with passed size
		// initialize list of threads
		// return reference to the initialized array
		ArrayFillerManager.array = new int[arraySize];
		ArrayFillerManager.latency = latency;
		ArrayFillerManager.minValue = minValue;
		ArrayFillerManager.maxValue = maxValue;
		threads = new LinkedList<>();
		return array;
	}

	public static void fillStupidly() {

		for (int i = 0; i < array.length; i++) {
			ArrayFiller currentFiller = new ArrayFiller(latency, minValue, maxValue, i, i);
			currentFiller.run();
		}

	}

	// create cycle which creates new ArrayFiller objects
	// with filling range of only ONE cell at a time (i.e. range from..to is
	// 0..0, then 1..1, etc.) and invoke .run() method for these objects.
	// Note, that invocation of .run() method directly executes it in
	// current (main) thread.
	// Note that this method emulates, what would happen if you would send
	// just small portions of data through media with latency.

	public static void fillSequentially() {

		ArrayFiller currentFiller = new ArrayFiller(latency, minValue, maxValue, 0, array.length - 1);
		currentFiller.run();

		// create cycle which creates one ArrayFiller object
		// with filling range for ALL array but executed just in SINGLE thread
		// by invocation of .run() method directly.
		// Note that this method emulates, what would happen if you would do
		// proper "buffering" with large amount of data, but do execution just
		// in single thread.
	}

	public static void fillParalelly() {

		int threadsN = array.length ;
		for (int i = 0; i <= array.length; i += threadsN) {
			ArrayFiller aF = new ArrayFiller(latency, minValue, maxValue, i, i + threadsN);
			Thread thread = new Thread(aF);
			Thread thread2 = new Thread(aF);
			Thread thread3 = new Thread(aF);
			threads.add(thread);
			threads.add(thread2);
			threads.add(thread3);
			thread.start();
			thread2.start();
			thread3.start();

			try {
				thread.join(latency);

			} catch (Exception e) {

			}

		}

		// create cycle which creates new ArrayFiller objects
		// with any range and pass them as references to the Thread constructor.
		// Add newly created Thread objects into threads list and start them
		// threads using .start() method. Note that invocation of .start() for
		// thread object creates new concurrent thread in application
		// Note that, to pass tests, this implementation should run faster than
		// fillSequentally() method.
		//
		// HINT: Don't forget to check that separately started threads are
		// actually finished by calling .join() method for them.
		// Note that this method emulates, what would happen if you do proper
		// buffering and scaling of the execution.

	}

}
