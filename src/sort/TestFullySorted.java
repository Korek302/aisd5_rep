package sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestFullySorted
{
	public static void main(String[] args)
	{
		List<Vehicle> l = new ArrayList<Vehicle>();
		Random generator = new Random();

		int lowerLimit = 0;
		int upperLimit = 100;
		int quantity = 10;
		
		upperLimit = upperLimit - lowerLimit + 1;
		
		for(int i = 0; i < quantity; i++)
		{
			l.add(new Vehicle(generator.nextInt(upperLimit)+lowerLimit, "Audi"));
		}
		
		//sorting
		ListSorter<Vehicle> ls = new QuickSort();
		l = ls.sort(l);
		System.out.println(l.toString());		
		
		//QuickSort
		List<Vehicle> l1 = new ArrayList<Vehicle>(l);
		ListSorter<Vehicle> quickSorted = new QuickSort();
		long startTime1 = System.nanoTime();
		l1 = quickSorted.sort(l1);
		long endTime1 = System.nanoTime();
		long totalTime1 = endTime1 - startTime1;
		System.out.println(l1.toString());
		System.out.println("QuickSort[ns]: "+totalTime1);		
		
		//MergeSort
		List<Vehicle> l2 = new ArrayList<Vehicle>(l);
		ListSorter<Vehicle> mergeSorted = new MergeSort();
		long startTime2 = System.nanoTime();
		l2 = mergeSorted.sort(l2);
		long endTime2 = System.nanoTime();
		long totalTime2 = endTime2 - startTime2;
		System.out.println(l2.toString());
		System.out.println("MergeSort[ns]: "+totalTime2);	
		
		//HeapSort
		List<Vehicle> l3 = new ArrayList<Vehicle>(l);
		ListSorter<Vehicle> heapSorted = new HeapSort();
		long startTime3 = System.nanoTime();
		l3 = heapSorted.sort(l3);
		long endTime3 = System.nanoTime();
		long totalTime3 = endTime3 - startTime3;
		System.out.println(l3.toString());
		System.out.println("HeapSort[ns]: "+totalTime3);	
	}
}
