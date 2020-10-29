import java.util.Arrays;

interface PriorityQueue<T extends Comparable<T>> {
    public void push(T item);
    public T pop();
    public T peek();
}

public class Heap<T extends Comparable<T>> implements PriorityQueue<T> {

    private T[] heap;
    private int size;

    public Heap(int capacity) {
        heap = (T[]) new Comparable[capacity];
    }

    /* Given an index in the heap array, calculate what the parent node's
     * index is.
     */
    private int parent(int index) {
        return (index - 1) / 2;
    }

    /* Given an index in the heap array, calculate what the right child's
     * index is.
     */
    private int rchild(int index) {
        return 2 * (index + 1);
    }

    /* Given an index in the heap array, calculate what the left child's
     * index is.
     */
    private int lchild(int index) {
        return 2 * index + 1;
    }

    private boolean hasLeftChild(int index) {
        if (lchild(index) < size)
        	return true;
        else
        	return false;
    }

    private boolean hasRightChild(int index) {
        if (rchild(index) < size)
        	return true;
        else 
        	return false;
    }

    /* Swap the items in the array at index1 and index2.
     */
    private void swap(int index1, int index2) {
    	T temp = heap[index2];
    	
    	heap[index2] = heap[index1];
    	heap[index1] = temp;
    }

    /* Perform a heapify starting at the given index.
     * Check the index's two children to see if you should swap the node
     * with either of these children. If you should, do the swap, and call
     * another bubbleDown on the index you swapped to.
     */
    private void bubbleDown(int index) {
    	T leftVal = null;
    	T rightVal = null;
    	boolean hasLeft = hasLeftChild(index);
    	boolean hasRight = hasRightChild(index);
    	
    	if (hasLeft == true)
    		leftVal = heap[lchild(index)];
    	if (hasRight == true)
    		rightVal = heap[rchild(index)];
    	
    	if (!hasLeft && !hasRight)
    		return;
    	else if (hasLeft && !hasRight) {
    		if (leftVal.compareTo(heap[index]) > 0) {
    			swap(index, lchild(index));
    			bubbleDown(lchild(index));
    		}
    	}
    	else if (!hasLeft && hasRight) {
			swap(index, rchild(index));
			bubbleDown(rchild(index));
    	}
    	else
    		if (leftVal.compareTo(heap[index]) > 0 || rightVal.compareTo(heap[index]) > 0) {
	    		if (leftVal.compareTo(rightVal) > 0) {
	    			swap(index, lchild(index));
	    			bubbleDown(lchild(index));
	    		}
	    		else {
	    			swap(index, rchild(index));
	    			bubbleDown(rchild(index));
	    		}
    	}
    }

    /* Perform a "reverse-heapify" starting at the current index.
     * Check the index's parent to see if you should swap the two; If you
     * should, do a swap and call another bubbleUp on the index you swapped to.
     *
     * This should be a significantly simpler method than bubbleDown.
     */
    private void bubbleUp(int index) {
    	T parentVal = null;
    	
    	if (index > 0 && index < size)
    		parentVal = heap[parent(index)];
    	else
    		return;
    	
    	if (heap[index].compareTo(parentVal) > 0) {
    		swap(index, parent(index));
    		bubbleUp(parent(index));
    	}
    }

    /* Add an item to the queue.
     * Add the item at the end of the array, then bubble it up.
     * Assume that the heap will have space.
     */
    public void push(T item) {
    	if (size >= heap.length)
    		return;
    	
    	heap[size] = item;
    	size++;
    	
    	if (size > 1)
    		bubbleUp(size - 1);   	
    }

    /* Remove the highest priority item from the queue.
     * Replace the item at the root (index 0) with the last item
     * in the array, then bubble it down.
     * Assume that the heap won't be empty.
     */
    public T pop() {
    	
        T popVal = heap[0];
        
        heap[0] = heap[size - 1];
        heap[size - 1] = popVal;
        size--;
        
        if (size > 0)
        	bubbleDown(0);
        
        return popVal;
    }

    /* Return the highest priority item from the queue. 
     */
    public T peek() {
        return heap[0];
    }

    public String toString() {
        return Arrays.toString(heap);
    }

    public static void main(String[] args) {
        Heap<Integer> numbers = new Heap<Integer>(10);

        numbers.push(2270);
        numbers.push(19720);
        numbers.push(3430);
        numbers.push(2001);
        numbers.push(1998);
        numbers.push(7);

        System.out.println(numbers);

        System.out.printf("%-15s", numbers.pop());
        System.out.println(numbers);
        System.out.printf("%-15s", numbers.pop());
        System.out.println(numbers);
        numbers.peek();
        System.out.printf("%-15s", numbers.pop());
        System.out.println(numbers);
        System.out.printf("%-15s", numbers.pop());
        System.out.println(numbers);

        numbers.push(404);
        numbers.push(7778);
        numbers.push(27015);
        System.out.println("               (Three new numbers pushed)");
        System.out.println("               " + numbers);

        System.out.printf("%-15s", numbers.pop());
        System.out.println(numbers);
        System.out.printf("%-15s", numbers.pop());
        System.out.println(numbers);
        System.out.printf("%-15s", numbers.pop());
        System.out.println(numbers);
        numbers.peek(); // make sure peek doesn't change anything!
        System.out.printf("%-15s", numbers.pop());
        System.out.println(numbers);
        System.out.printf("%-15s", numbers.pop());
        System.out.println(numbers);
    }

}