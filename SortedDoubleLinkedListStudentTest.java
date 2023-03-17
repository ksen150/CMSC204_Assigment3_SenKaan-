


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class SortedDoubleLinkedListStudentTest {
	SortedDoubleLinkedList<String> sortedLinkedString;
	SortedDoubleLinkedList<Double> sortedLinkedDouble;
	SortedDoubleLinkedList<Car> sortedLinkedCar;
	StringComparator comparator;
	DoubleComparator comparatorD;
	CarComparator comparatorCar;
	
	public Car a=new Car("BMW", "M4", 2018);
	public Car b=new Car("BMW", "M5", 2019);
	public Car c=new Car("Mercedes", "AMG", 2018);
	public Car d=new Car("Lamborghini", "Huracan", 2020);
	public Car e=new Car("Lamborghini", "Aventador", 2018);
	public Car f=new Car("Mercedes", "C63s", 2015);
	//alphabetic order: e f a c b d
	
	@Before
	public void setUp() throws Exception {
		comparator = new StringComparator();
		sortedLinkedString = new SortedDoubleLinkedList<String>(comparator);
		
		comparatorD = new DoubleComparator();
		sortedLinkedDouble = new SortedDoubleLinkedList<Double>(comparatorD);
		
		comparatorCar = new CarComparator();
		sortedLinkedCar = new SortedDoubleLinkedList<Car>(comparatorCar);
		
	}

	@After
	public void tearDown() throws Exception {
		comparator = null;
		comparatorD = null;
		comparatorCar = null;
		sortedLinkedString = null;
		sortedLinkedDouble = null;
		sortedLinkedCar = null;
	}

	@Test
	public void testAddToEnd() {
		try {
			sortedLinkedString.addToEnd("Hello");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testAddToFront() {
		try {
			sortedLinkedString.addToFront("Hello");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testIteratorSuccessfulNext() {
		sortedLinkedCar.add(a);
	}

	@Test
	public void testIteratorSuccessfulStringPrevious() {
		sortedLinkedString.add("Begin");
		sortedLinkedString.add("World");
		sortedLinkedString.add("Hello");
		sortedLinkedString.add("Zebra");
		ListIterator<String> iterator = sortedLinkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals("Zebra", iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("Zebra", iterator.previous());
		assertEquals("World", iterator.previous());
		assertEquals("Hello", iterator.previous());
	}
	@Test
	public void testIteratorSuccessfulCarPrevious() {
		sortedLinkedCar.add(e);
		sortedLinkedCar.add(c);
		sortedLinkedCar.add(b);
		sortedLinkedCar.add(d);
		//ArrayList<Car> carList = sortedLinkedCar.toArrayList();
		//alphabetic order: e f a c b d
		ListIterator<Car> iterator = sortedLinkedCar.iterator();
		assertEquals(true, iterator.hasNext());
	}
	@Test
	public void testIteratorSuccessfulDoubleNext() {
		sortedLinkedDouble.add((Double)8.0);
		sortedLinkedDouble.add((Double)6.0);
		sortedLinkedDouble.add((Double)1.0);
		sortedLinkedDouble.add((Double)2.0);
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals((Double)1.0, iterator.next());
		assertEquals((Double)2.0, iterator.next());
		assertEquals((Double)6.0, iterator.next());
		assertEquals(true, iterator.hasNext());	}
	
	@Test
	public void testIteratorSuccessfulDoublePrevious() {
		sortedLinkedDouble.add((Double)5.0);
		sortedLinkedDouble.add((Double)10.0);
		sortedLinkedDouble.add((Double)8.0);
		sortedLinkedDouble.add((Double)2.0);
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals((Double)2.0, iterator.next());
		assertEquals((Double)5.0, iterator.next());
		assertEquals((Double)8.0, iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals((Double)8.0, iterator.previous());
		assertEquals(true, iterator.hasPrevious());
	}
	
	@Test
	public void testIteratorNoSuchElementException() {
		sortedLinkedCar.add(e);
		sortedLinkedCar.add(c);
		sortedLinkedCar.add(b);
		sortedLinkedCar.add(d);
		//ArrayList<Car> carList = sortedLinkedCar.toArrayList();
		//alphabetic order: e f a c b d
		ListIterator<Car> iterator = sortedLinkedCar.iterator();
		
		assertEquals(true, iterator.hasNext());
	}
	
	@Test
	public void testIteratorUnsupportedOperationExceptionString() {
		sortedLinkedCar.add(e);
		sortedLinkedCar.add(c);
		sortedLinkedCar.add(b);
		sortedLinkedCar.add(d);
		//ArrayList<Car> carList = sortedLinkedCar.toArrayList();
		//alphabetic order: e f a c b d
		ListIterator<Car> iterator = sortedLinkedCar.iterator();
		
		try{
			//remove is not supported for the iterator
			iterator.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testAddCar() {
		//alphabetic order: e f a c b d
		sortedLinkedCar.add(a);
		assertEquals(a, sortedLinkedCar.getFirst());
	
	}

	@Test
	public void testRemoveFirstCar() {
		//alphabetic order: e f a c b d
		sortedLinkedCar.add(c);
		assertEquals(c, sortedLinkedCar.getFirst());

	}
	
	@Test
	public void testRemoveEndCar() {
		//alphabetic order: e f a c b d
		sortedLinkedCar.add(b);
		assertEquals(b, sortedLinkedCar.getLast());

	}

	@Test
	public void testRemoveMiddleCar() {
		//alphabetic order: e f a c b d
		sortedLinkedCar.add(a);
		assertEquals(a, sortedLinkedCar.getFirst());
	
	}

	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class CarComparator implements Comparator<Car>
	{

		@Override
		public int compare(Car arg0, Car arg1) {
			// Just put cars in alphabetic order by make
			return arg0.getMake().compareTo(arg1.getMake());
		}		
	}
	
	private class Car{
		String make;
		String model;
		int year;
		
		public Car(String make, String model, int year){
			this.make = make;
			this.model = model;
			this.year = year;
		}
		
		public String getMake(){
			return make;
		}
		public String getModel(){
			return model;
		}
		public int getYear(){
			return year;
		}
		
		public String toString() {
			return (getMake()+" "+getModel()+" "+getYear());
		}
	}
}
