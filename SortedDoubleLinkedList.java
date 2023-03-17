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
import java.util.Comparator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {

	Comparator<T> compare = null;
	
	/* Creates an empty list associated with specificed comparator  
	 * @param compareableObject - Comparator to compare data elements
	 */
	public SortedDoubleLinkedList(java.util.Comparator<T> compareableObject)
	{
		compare = compareableObject;
	}
	
	/* Inserts specified element at correct position in sorted list. 
	 * @param data - the data to be added to the list
	 */
	public void add(T data)
	{
		Node<T> temp = new Node<T>(data);
		if(head == null)
		{
			head = tail = temp;
		}
		else
		{
			Node<T> current = head;
			do
			{
				if(compare.compare(temp.data, current.data) == 0)
				{
					temp.next = current.next;
					current.next = temp;
					temp.previous = current;
					temp.next.previous = temp;
					break;
				}
				else if(compare.compare(temp.data, current.data) < 0)
				{
					if(current == head)
					{
						temp.next = current;
						current.previous = temp;
						temp.previous = tail;
						tail.next = temp;
						head = temp;
					}
					else 
					{
						temp.next = current;
						temp.previous = current.previous;
						current.previous = temp;
						temp.previous.next = temp;
					}
					break;
				}
				else if(compare.compare(temp.data, current.data) > 0)
				{
					if(current == tail)
					{
						tail.next = temp;
						temp.previous = tail;
						temp.next = head;
						head.previous = temp;
						tail = temp;
						break;
					}
					else 
					{
						current = current.next;
					}
				}
	
			} while(temp != head);
		}
		size++;
	}
	
	/* Invalid operation for sorted list. UnsupportedOperationException will be generated 
	 * with message "Invalid operation for sorted list" 
	 * @overrides addToEnd class BasicDoubleLinkedList<T>
	 * @param data - the data for the Node within the linked list
	 */
	@Override
	public void addToEnd(T data) throws java.lang.UnsupportedOperationException
	{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	/* Invalid operation for sorted list. UnsupportedOperationException will be generated 
	 * with message "Invalid operation for sorted list" 
	 * @overrides addToFront class BasicDoubleLinkedList<T>
	 * @param data - the data for the Node within the linked list
	 */
	@Override
	public void addToFront(T data) throws java.lang.UnsupportedOperationException
	{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	/* Implements the iterator by calling the super class iterator method
	 * @overrides iterator in class BasicDoubleLinkedList<T>
	 * @return an iterator positioned at the head of the list
	 */
	@Override
	public java.util.ListIterator<T> iterator()
	{
		return super.iterator();
	//	return new DoubleLinkedListIterator<T>(head);
	}
	
	/* Implements the remove operation by calling the super class remove method
	 * @overrides remove in class BasicDoubleLinkedList<T>
	 * @param data - the data to be removed
	 * @param comparator - the comparator to determine equality of data elements
	 * @return a node containing the data or null 
	 */
	@Override
	public BasicDoubleLinkedList.Node remove(T data, java.util.Comparator<T> comparator)
	{
		return super.remove(data, comparator);
	}	
}
