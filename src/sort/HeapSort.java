package sort;

import java.util.List;

public class HeapSort implements ListSorter<Vehicle> 
{
	List<Vehicle> list;
	int last;
	int left;
	int right;
	int largest;
	
	public void maxHeap(List<Vehicle> list, int i)
	{
		left = 2*i;
		right = 2*i + 1;
		if(left <= last && list.get(left).compareTo(list.get(i)) > 0)
			largest = left;
		else
			largest = i;
		
		if(right <= last && list.get(right).compareTo(list.get(largest)) > 0)
			largest = right;
		if(largest != i)
		{
			swap(i, largest);
			maxHeap(list, largest);
		}
	}
	
	public void buildHeap(List<Vehicle> list)
	{
		last = list.size() - 1;
		for(int i = last/2; i >= 0; i--)
		{
			maxHeap(list, i);
		}
	}
	
	public void swap(int i, int j)
	{
		Vehicle temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}
	
	public List<Vehicle> sort(List<Vehicle> list)
	{
		this.list = list;
		buildHeap(list);
		for(int i = last; i > 0; i--)
		{
			swap(0, i);
			last = last - 1;
			maxHeap(list, 0);
		}
		return list;
	}
}