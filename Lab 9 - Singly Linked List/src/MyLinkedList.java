/** Linked List Lab
 * Made by Toby Patterson 5/29/2020
 * For CS165 at CSU
 */

public class MyLinkedList implements MiniList<Integer>{
    /* Private member variables that you need to declare:
     ** The head pointer
     ** The tail pointer
     */
	Node m_pHead;
	Node m_pTail;
	int  m_iSize;

    public class Node {
        // declare member variables (data and next)
    	int data;
    	Node pNext;

        // finish these constructors
        public Node(int data, Node pNext) {
        	this.data = data;
        	this.pNext = pNext;
        }
        public Node(int data) {
        	this.data = data;
        	this.pNext = null;
        } // HINT: use this() with next = null
    }

    // Initialize the linked list (set head and tail pointers)
    public MyLinkedList() {
    	m_pHead = null;
    	m_pTail = null;
    	m_iSize = 0;
    }

    @Override
    public boolean add(Integer item) {
    	Node newNode = new Node(item);
    	
    	if (null == m_pHead)
    		m_pHead = newNode;
    	else
    		m_pTail.pNext = newNode;
    		
        m_pTail = newNode;
        
        m_iSize++;
        return true;
    }

    @Override
    public void add(int index, Integer element) {
    	Node pCur = m_pHead;
    	Node newNode = new Node(element);
    	
    	if (index == 0) {
    		newNode.pNext = pCur.pNext;
    		pCur.pNext = null;
    		m_pHead = newNode;
    	}
    	
    	for (int i = 1; i < index; i++) {
    		pCur = pCur.pNext;
    	}
    	
    	newNode.pNext = pCur.pNext;
    	pCur.pNext = newNode;
    
    	m_iSize++;
    }

    @Override
    public Integer remove() {
        Node pCur = m_pHead;
        m_pHead = pCur.pNext;
        pCur.pNext = null;
        
        m_iSize--;
        return pCur.data;
    }

    @Override
    public Integer remove(int index) {
    	Node pPrev = m_pHead;
    	Node pCur = m_pHead.pNext;
        
    	if (null == m_pHead) 
    		return null;
    	// head case
    	else if (index == 0) {
        	m_pHead = m_pHead.pNext;
        	pPrev.pNext = null;
        	
        	m_iSize--;
        	return pCur.data;
        }
        
    	// inside case
        if (index > 0 && index < m_iSize - 1) {
        	for (int i = 1; i < index; i++) {
        		pPrev = pCur;
        		pCur = pCur.pNext;
        	}
        	
        	pPrev.pNext = pCur.pNext;
        	pCur.pNext = null;
        	
        	m_iSize--;
        	return pCur.data;
        }
        
        // tail case
        if (index == m_iSize - 1) {
        	pPrev.pNext = null;
        	
        	m_iSize--;
        	return pCur.data;
        }
        
        return null;
    }

    @Override
    public boolean remove(Integer item) {
    	Node pPrev = m_pHead;
        Node pCur = m_pHead.pNext;
        
        if (m_pHead.data == item) {
        	m_pHead = m_pHead.pNext;
        	pPrev.pNext = null;
        	m_iSize--;
        	return true;
        }
        
        while (null != pCur) {
        	if (pCur.data == item) {
        		pPrev.pNext = pCur.pNext;
        		pCur.pNext = null;
        		
                if (null == pPrev.pNext)
                	m_pTail = pPrev;

        		m_iSize--;
        		return true;
        	}

        	pPrev = pCur;
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
    public boolean contains(Integer item) {
        Node pCur = m_pHead;
        
        while (null != pCur) {
        	if (pCur.data == item) {
        		return true;
        	}
        	
        	pCur = pCur.pNext;
        }
        
        return false;
    }

    @Override
    public Integer get(int index) {
    	Node pCur = m_pHead;
    	
        if (index < 0 || index >= m_iSize) 
        	return null;
        
        for (int i = 0; i < index; i++)
        	pCur = pCur.pNext;
        
        return pCur.data;
    }

    @Override
    public int indexOf(Integer item) {
        Node pCur = m_pHead;
        int index = 0;
        
        while (null != pCur.pNext) {
        	if (pCur.data == item) {
        		return index;
        	}
        	
        	index++;
        	pCur = pCur.pNext;
        }
        
        return (pCur.data == item) ? index : -1;
    }

    @Override
    public boolean isEmpty() {
    	return (m_pHead == null) ? true : false;
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
