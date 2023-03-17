/*
 * Class: CMSC204
 * Instructor: Professor Monshi
 * Description: (Give a brief description for each Class)
 * Due: 03/17/23
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __Kaan Sen________
*/
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> extends java.lang.Object implements java.lang.Iterable<T> {

	protected int size;
	protected Node<T> head;
	protected Node<T> tail;
	
	protected class Node<T>
	{
		 protected T data;
		 protected Node<T> next;
		 protected Node<T> previous;
		
		public Node(T dataNode)
		{
			this.data = dataNode;
			this.next = null;
			this.previous = null;
		}
	}
 
	public BasicDoubleLinkedList()
	{
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	/* Returns the number of nodes in the list 
	 * @return the size of the linked list
	 */
	public int getSize()
	{
		return size;
	}
	
	/* Adds an element to the end of the list and updates size of the list 
	 * @param data - the data to be added to the list
	 */
	public void addToEnd(T data)
	{
		Node<T> temp = new Node<T>(data);
		if(tail == null)
		{
			head = temp;
			tail = temp;
		}
		else
		{
			temp.previous = tail;
			temp.next = head;
			tail.next = temp;
			tail = temp;
			head.previous = tail;
		}
		size++;
	}
	
	/* Adds an element to the front of the list and updates size of the list 
	 * @param data - the data to be added to the list
	 */
	public void addToFront(T data)
	{
		Node<T> temp = new Node<T>(data);
		if(head == null)
		{
			head = temp;
			tail = temp;
		}
		else
		{
			temp.next = head;
			temp.previous = tail;
			head.previous = temp;
			head = temp;
			tail.next = head;
		}
		size++;
	}
	
	/* Returns but does not remove the first element from the list
	 * @return the data element or null
	 */
	public T getFirst()
	{
		if(size == 0)
		{
			return null;
		}
		return head.data;
	}
	
	/* Returns but does not remove the last element from the list 
	 * @return the data element or null
	 */
	public T getLast()
	{
		if(size == 0)
		{
			return null;
		}
		return tail.data;
	}
	
	/* Removes first instance of the targetData from the list. 
	 * @param targetData - the data element to be removed
	 * @param comparator - the comparator to determine equality of data element
	 * @return a node containing the targetData or null
	 */
	public Node<T> remove(T targetData, java.util.Comparator<T> comparator)
	{
		Node<T> previous = null;
		Node<T> current = head; 
		
		while(current != null && (comparator.compare(current.data, targetData) < 0))
		{
			current = current.next;
		}
			if(current != null)
			{
				if(current == head)
				{
						retrieveFirstElement();
				}
				else if(current == tail)
				{
						retrieveLastElement();
				}
				else 
				{
					current.previous.next = current.next;
					current.next.previous = current.previous;
					current.previous = null;
					current.next = null;
					size--;
				}
				current = null;
			}
			return head;
	 }

	/* Remove and return the first element from the list 
	 * If there are no elements the method returns null
	 * @return the data element or null
	 */
	public T retrieveFirstElement() throws NoSuchElementException
	{
		if(size == 0 || head == null)
		{
			throw new NoSuchElementException();
		}
		T data = head.data;
		head = head.next;
		head.previous = tail;
		tail.next = head;
		size--;
		return data;
	}
	
	/* Remove and return the last element from the list 
	 * If there are no elements the method returns null
	 * @return the data element or null
	 */
	public T retrieveLastElement()
	{
		if(tail == null)
		{
			throw new NoSuchElementException();
		}
		
		T data = tail.data;
		tail = tail.previous;
		tail.next = head;
		head.previous = tail;
		size--;
		return data;
	}
	
	/* Returns an arraylist of all the items in Double Linked list
	 * @return an arraylist of all items in the list
	 */
	public java.util.ArrayList<T> toArrayList()
	{
		ArrayList<T> list = new ArrayList<>();
		Node<T> current = head;
		do
		{
			if(size == 1)
			{
				list.add(head.data);
			}
			list.add(current.data);
			current = current.next;
		}
		while(current != head);
		return list;
	}
	
	/* Method returns an object of the DoubleLinkedListIterator
	 * @return a ListIterator object
	 */
	public class DoubleLinkedListIterator<T> implements ListIterator<T>
	{
		private Node<T> current;
		private int index;

		
		public DoubleLinkedListIterator(Node<T> head)
		{
			current = head;
		}
		
		public boolean hasNext()
		{
			return index < size;
		}
		
		public T next() throws java.util.NoSuchElementException
		{
			if(!hasNext())
			{
				throw new NoSuchElementException();
			}
				T data = current.data;
				current = current.next;
				index++;
				return data;
		}
		
		public boolean hasPrevious()
		{
			return index > 0;
		}
		
		public T previous()
		{
			if(!hasPrevious())
			{
				throw new NoSuchElementException();
			}
				current = current.previous;
				index--;
				return current.data;
		}
		
		@Override
		public void set(T arg0)
		{
			throw new UnsupportedOperationException();
		}
		
		@Override
		public int nextIndex() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}
		
		@Override
		public int previousIndex() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}
		
		@Override
		public void remove() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}
		
		@Override
		public void add(T arg0) throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}
	}
	
	@Override
	public java.util.ListIterator<T> iterator()  {
		return new DoubleLinkedListIterator<T>(head);
	}	
}
