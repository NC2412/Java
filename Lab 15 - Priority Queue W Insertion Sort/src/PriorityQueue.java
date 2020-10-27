import java.util.Arrays;

public class PriorityQueue {

    /* This class is finished for you.
     */
    private static class Customer implements Comparable<Customer> {
        private double donation;

        public Customer(double donation) {
            this.donation = donation;
        }

        public double getDonation() {
            return donation;
        }

        public void donate(double amount) {
            donation += amount;
        }

        public int compareTo(Customer other) {
            double diff = donation - other.donation;
            if (diff < 0) {
                return -1;
            } else if (diff > 0) {
                return 1;
            } else {
                return 0;
            }
        }

        public String toString() {
            return String.format("$%.2f", donation);
        }
    }

    private Customer[] data;
    private int size;

    public PriorityQueue(int capacity) {
        data = new Customer[capacity];
        size = 0;
    }
    
    public PriorityQueue() {
        this(10);
    }

    /* Add a customer to the queue.
     * Remember to do so in a way that keeps the queue in sorted order!
     */
    public void push(Customer customer) {
    	if (size == data.length)
    		return;
    	
    	int i;
    	
    	for (i = size; i > 0; i--) {
    		if (customer.compareTo(data[i - 1]) < 0) {
    			backShift(i, size);
    			data[i] = customer;
    			break;
    		}
    	}
        
        if (i == 0) {
        	backShift(i, size);
        	data[0] = customer;
        }
        
    	size++;
    }

    /* Remove and return the highest priority customer from the queue.
     */
    public Customer pop() {
        Customer retData = data[0];
        
        data[0] = null;
        frontShift();
        size--;
        
        return retData;
    }

    /* Return, but don't remove, the highest priority item from the queue.
     */
    public Customer peek() {
        return data[0];
    }

    /* Given the index of a customer, increase their donation amount, letting
     * them cut in line if necessary. 
     *
     * Refer to the Customer class to remind yourself the operations you can do
     * on a customer.
     */
    public void bump(int customerIndex, double amount) {
    	if (customerIndex >= size)
    		return;
    	
    	int i;
        data[customerIndex].donate(amount);
        Customer temp = data[customerIndex];
        
        for (i = 0; i < customerIndex; i++) {
        	if (temp.compareTo(data[i]) > 0) {
        		backShift(i, customerIndex);
        		data[i] = temp;
        		break;
        	}
        }
    }
    
    public void backShift(int start, int end) {
    	if (start >= size || end >= data.length)
    		return;
    	
    	for (int i = end; i > start; i--) {
    		data[i] = data[i - 1];
    	}
    }
    
    public void frontShift() {
    	for (int i = 0; i < size - 1; i++) {
    		Customer temp = data[i + 1];
    		data[i] = temp;
    	}
    }

    public String toString() {
        return Arrays.toString(data);
    }

    public static void main(String[] args) {
        PriorityQueue line = new PriorityQueue(6);
        
        line.push(new Customer(5.00));
        line.push(new Customer(10.00));
        line.push(new Customer(1.00));

        System.out.println(line.pop());
        System.out.println(line.pop());

        line.push(new Customer(20.00));
        line.push(new Customer(15.00));
        line.push(new Customer(2.00));

        line.bump(1, 30.00);
        line.bump(3, 60.00);
        System.out.println(line.pop());
        System.out.println(line.peek());
        System.out.println(line.pop());
        System.out.println(line.pop());
        System.out.println(line.pop());
    }
}