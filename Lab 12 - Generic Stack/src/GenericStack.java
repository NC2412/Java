import java.util.*;

public class GenericStack<T> {

    /* YOUR CODE HERE
     * Just like in the ArrayList lab, copy your StringStack code, excluding the
     * main method, here.
     * Then, modify it so it's generic!
     */

	    /* You will need some data fields here - at the very least, some kind of
	     * String array.
	     */
		T[] m_sArray;
		int m_iSize;

	    /* Puts the stack into a valid state, ready for us to call methods on.
	     * The size parameter tell the... well, size of the stack.
	     */
	    @SuppressWarnings("unchecked")
		public GenericStack(int size) {
	    	m_sArray = (T[])(new Object[size]);
	    	m_iSize = 0;
	    }

	    /* If someone calls the constructor with no argument, they should get a
	     * stack with a default size of 10.
	     */
	    @SuppressWarnings("unchecked")
		public GenericStack() {
	        m_sArray = (T[])(new Object[10]);
	        m_iSize = 0;
	    }

	    /* Return true if the stack has no elements, and false otherwise.
	     */
	    public boolean empty() {
	        return m_iSize == 0 ? true : false;
	    }
	    
	    public int getSize() {
	    	return m_iSize;
	    }

	    /* Return the object at the top of the stack, WITHOUT removing it. 
	     * If there are no elements to peek, throw a NoSuchElementException.
	     */
	    public T peek() {

	    	if (m_iSize == 0)
	    		throw new NoSuchElementException();
	    	
	    	if (m_sArray[m_iSize - 1] == null) 
	    		throw new NoSuchElementException();
	    	else
	    		return m_sArray[m_iSize - 1];
	    }

	    /* Return the object at the top of the stack, AND ALSO remove it.
	     * If there are no elements to pop, throw a NoSuchElementException.
	     */
	    public T pop() {
	    	
	    	if (m_iSize == 0)
	    		throw new NoSuchElementException();
	    	
	        T retVal = m_sArray[m_iSize - 1];
	        m_sArray[m_iSize - 1] = null;
	        
	        m_iSize--;
	        return retVal;
	    }

	    /* Add a new object to the top of the stack. 
	     * If there is no room in the stack, throw a IllegalStateException.
	     */
	    public T push(T o) {
	        if (m_iSize == m_sArray.length)
	        	throw new IllegalStateException();
	        else {
	        	m_sArray[m_iSize] = o;
	        }
	        
	        m_iSize++;
	        return o;
	    }

	    /* Return the position of an object on the stack.  The position of an object
	     * is just its distance from the top of the stack. So, the topmost item is
	     * distance 0, the one below the topmost item is at distance 1, etc.
	     */
	    public int search(T o) {
	        
	    	for (int i = 0; i < m_iSize; i ++) {
	    		if (m_sArray[m_iSize - 1 - i].equals(o))
	    			return i;
	    	}
	    	
	    	return -1;
	    }

    public static void main(String[] args) {
        // If any of these lines cause a compilation error, your stack hasn't
        // been properly made generic.
        GenericStack<Integer> intStack = new GenericStack<>();
        GenericStack<String> stringStack = new GenericStack<>();
        GenericStack<ArrayList<String>> listStack = new GenericStack<>();
    }

}
