/** Linked List Lab
 * Made by Toby Patterson 5/31/2020
 * For CS165 at CSU
 */

public class MyLinkedList<E> implements MiniList<E>{
    /* Private member variables that you need to declare:
     ** The head pointer
     ** The tail pointer
     */
	private Node m_pHead;
	private Node m_pTail;
	private int m_iSize;

    public class Node {
        // declare member variables (data, prev and next)
    	E data;
    	Node pPrev;
    	Node pNext;

        // finish these constructors
        public Node(E data, Node pPrev, Node pNext) {
        	this.data = data;
        	this.pPrev = pPrev;
        	this.pNext = pNext;
        }
        public Node(E data) {
        	this.data = data;
        	this.pPrev = null;
        	this.pNext = null;
        } // HINT: use this() with next = prev = null
    }

    // Initialize the head and tail pointer
    public MyLinkedList() { 
    	m_pHead = null;
    	m_pTail = null;
    	m_iSize = 0;
    }

    @Override
    public boolean add(E item) {
    	Node newNode = new Node(item, m_pTail, null);
    	
    	if (null == m_pHead && null == m_pTail) {
    		m_pHead = newNode;
    	}
    	else {
    		m_pTail.pNext = newNode;
    	}
    	
    	m_pTail = newNode;
    	
    	m_iSize++;
    	return true;
    }

    @Override
    public void add(int index, E element) {
    	Node newNode = new Node(element);
    	Node pCur = m_pHead;
    	
    	// Out of bounds case
    	if (index < 0 || index > m_iSize)
    		return;
    	
    	// Head case
    	if (index == 0) {
    		newNode.pNext = m_pHead;
    		m_pHead.pPrev = newNode;
    		m_pHead = newNode;
    		
    		m_iSize++;
    		return;
    	}
    	
    	// Tail case
    	if (index == m_iSize) {
    		add(element);
    		return;
    	}
    	
    	for (int i = 0; i < index; i++) {
    		pCur = pCur.pNext;
    	}
    	
    	pCur.pPrev.pNext = newNode;
    	newNode.pPrev = pCur.pPrev;
    	newNode.pNext = pCur;
    	pCur.pPrev = newNode;
    	
    	
    	m_iSize++;
    	return;
    }

    @Override
    public E remove() {
    	Node pDelNode = m_pHead;
        m_pHead = m_pHead.pNext;
        pDelNode.pNext = null;
        
        m_iSize--;
        return pDelNode.data; 
    }

    @Override
    public E remove(int index) {
        Node pCur = m_pHead;
        
        // Out of bounds case
        if (index < 0 || index >= m_iSize) 
        	return null;
        
        // Head case
        if (index == 0) {
        	m_pHead = m_pHead.pNext;
        	pCur.pNext = null;
        	
        	m_iSize--;
        	return pCur.data;
        }
        
        for (int i = 0; i < index; i++) {
        	pCur = pCur.pNext;
        }

		if (pCur == m_pTail)
			m_pTail = m_pTail.pPrev;
		else
			pCur.pNext.pPrev = pCur.pPrev;
		
        pCur.pPrev.pNext = pCur.pNext;
        pCur.pPrev = null;
        pCur.pNext = null;
        
        m_iSize--;
        return pCur.data;
    }

    @Override
    public boolean remove(E item) {
    	Node pCur = m_pHead;
    	
    	// Head case
    	if (m_pHead.data.equals(item)) {
    		m_pHead = m_pHead.pNext;
    		pCur.pNext = null;
    		
    		m_iSize--;
    		return true;
    	}
        
    	while (null != pCur) {
        	if (pCur.data.equals(item)) {
        		if (pCur == m_pTail)
        			m_pTail = m_pTail.pPrev;
        		else 
        			pCur.pNext.pPrev = pCur.pPrev;
        		
        		pCur.pPrev.pNext = pCur.pNext;
        		pCur.pPrev = null;
        		pCur.pNext = null;
        		
        		m_iSize--;
        		return true;
        	}
        	
        	pCur = pCur.pNext;
        }
        
        return false;
    }

    @Override
    public void clear() {
    	m_pHead = null;
    	m_pTail = null;
    }

    @Override
    public boolean contains(E item) {
        for (Node pCur = m_pHead; null != pCur; pCur = pCur.pNext) {
        	if (pCur.data.equals(item)) {
        		return true;
        	}
        }
        
        return false;
    }

    @Override
    public E get(int index) {
        Node pCur = m_pHead;
        
        if (index < 0 || index >= m_iSize)
        	return null;
        
        for (int i = 0; i < index; i++) {
        	pCur = pCur.pNext;
        }
        
        return pCur.data;
    }

    @Override
    public int indexOf(E item) {
        Node pCur = m_pHead;
        int index = -1;
        
        for (int i = 0; i < m_iSize; i++) {
        	if (pCur.data.equals(item)) {
        		index = i;
        		break;
        	}
        	
        	pCur = pCur.pNext;
        }
        
        return index;
    }
    
    public E getHead() {
    	return m_pHead.data;
    }
    
    public E getTail() {
    	return m_pTail.data;
    }

    @Override
    public boolean isEmpty() {
        return (m_iSize == 0) ? true : false;
    }

    @Override
    public int size() {
        return m_iSize;
    }

    // Uncomment when ready to test
    @Override
    public String toString() {
        String ret = "";
        Node curr = m_pHead;
        while (curr != null) {
            ret += curr.data + " ";
            curr = curr.pNext;
        }
        return ret;
    }

}
