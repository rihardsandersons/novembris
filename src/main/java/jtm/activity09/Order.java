package jtm.activity09;

/*- #1
 * Implement Comparable interface with Order class
 * Hint! Use generic type of comparable items in form: Comparable<Order>
 * 
 * #2 Override/implement necessary methods for Order class:
 * - public Order(String orderer, String itemName, Integer count) — constructor of the Order
 * - public int compareTo(Order order) — comparison implementation according to logic described below
 * - public boolean equals(Object object) — check equality of orders
 * - public int hashCode() — tC string in following form: "ItemName: OrdererName: Count"
 * 
 * Hints:
 * 1. When comparing orders, compare their values in following order:
 *    - Item name
 *    - Customer name
 *    - Count of items
 * If item or customer is closer to start of alphabet, it is considered "smaller"
 * 
 * 2. When implementing .equals() method, rely on compareTo() method, as for sane design
 * .equals() == true, if compareTo() == 0 (and vice versa).
 * 
 * 3. Also Ensure that .hashCode() is the same, if .equals() == true for two orders.
 * 
 */

public class Order implements Comparable<Order> {
	String customer; // Name of the customer
	String name; // Name of the requested item
	int count; // Count of the requested items

	public Order(String orderer, String itemName, Integer count) {
		this.customer = orderer;
		this.name = itemName;
		this.count = count;
	}

	@Override
	public int compareTo(Order o) {
		int status;
		status = this.name.compareTo(o.name);
		if (status == 0) {
			status = this.customer.compareTo(o.customer);
			if (status == 0) {
				status = this.count - o.count;
				return status;
			}
		}
		if (status >= 1) {
			status = 1;
		}
		if (status <= -1) {
			status = -1;
		}

		return status;
	}

	public boolean equals(Object object) {
		return (object instanceof Order && compareTo((Order) object) == 0);
	}

	public int hashCode() {
		return toString().hashCode();
	}

	@Override
	public String toString() {
		return name + ": " + customer + ": " + count;
	}
}
