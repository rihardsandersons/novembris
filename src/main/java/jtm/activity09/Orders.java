package jtm.activity09;

import java.util.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.TreeSet;

import java.util.Iterator;

/*- #2
 * Implement Iterator interface with Orders class
 * Hint! Use generic type argument of iterateable items in form: Iterator<Order>
 * 
 *  #3 Override/implement public methods for Orders class:
 * - Orders()                — create new empty Orders
 * - add(Order item)            — add passed order to the Orders
 * - List<Order> getItemsList() — List of all customer orders
 * - Set<Order> getItemsSet()   — calculated Set of Orders from list (look at description below)
 * - sort()                     — sort list of orders according to the sorting rules
 * - boolean hasNext()          — check is there next Order in Orders
 * - Order next()               — get next Order from Orders, throw NoSuchElementException if can't
 * - remove()                   — remove current Order (order got by previous next()) from list, throw IllegalStateException if can't
 * - String toString()          — show list of Orders as a String
 * 
 * Hints:
 * 1. To convert Orders to String, reuse .toString() method of List.toString()
 * 2. Use built in List.sort() method to sort list of orders
 * 
 * #4
 * When implementing getItemsSet() method, join all requests for the same item from different customers
 * in following way: if there are two requests:
 *  - ItemN: Customer1: 3
 *  - ItemN: Customer2: 1
 *  Set of orders should be:
 *  - ItemN: Customer1,Customer2: 4
 */

public class Orders implements Iterable<Orders> {

	private List<Order> orders;
	private int iterator = -1;

	public Orders() {
		orders = new LinkedList<>();
	}

	public void add(Order item) {
		orders.add(item);
	}

	public List<Order> getItemsList() {
		return orders;
	}

	public Set<Order> getItemsSet() {
		Set<Order> orderSet = new TreeSet<Order>();
		Set<String> stringSet = new HashSet<String>();
		for (Order order : orders) {
			stringSet.add(order.name);
		}
		for (String ord : stringSet) {
			String tempName = "";
			int tempCount = 0;
			for (Order secondOrder : orders) {
				if (ord.equals(secondOrder.name)) {
					tempCount += secondOrder.count;
					tempName = String.join(",", secondOrder.customer, tempName);
				}
			}
			tempName = tempName.replaceAll("(,)*$", "");
			Order newOrder = new Order(tempName, ord, tempCount);

			orderSet.add(newOrder);
		}
		return orderSet;

	}

	public void sort() {
		Collections.sort(orders);
	}

	public boolean hasNext() {
		if (orders.isEmpty()) {
			return false;
		} else {
			if (iterator < (orders.size() - 1)) {
				return true;
			} else {
				return false;
			}
		}
	}

	public Order next() {
		if (orders.isEmpty()) {
			throw new NoSuchElementException();
		} else {
			iterator++;
			return orders.get(iterator);
		}
	}

	public void remove() throws IllegalStateException {
		if (orders.isEmpty()) {
			throw new IllegalStateException();
		} else {
			orders.remove(iterator);
			iterator--;
		}

	}

	public String toString() {
		return orders.toString();
	}

	@Override
	public void forEach(Consumer<? super Orders> arg0) {
		// Auto-generated method stub

	}

	@Override
	public Iterator<Orders> iterator() {
		// Auto-generated method stub
		return null;
	}

	@Override
	public Spliterator<Orders> spliterator() {
		// Auto-generated method stub
		return null;
	}

	// throw IllegalStateException if can't
	// String toString() — show list of Orders as a String
	/*-
	 * TODO #1
	 * Create data structure to hold:
	 *   1. some kind of collection of Orders (e.g. some List)
	 *   2. index to the current order for iterations through the Orders in Orders
	 *   Hints:
	 *   1. you can use your own implementation or rely on .iterator() of the List
	 *   2. when constructing list of orders, set number of current order to -1
	 *      (which is usual approach when working with iterateable collections).
	 */

}
