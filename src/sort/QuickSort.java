package sort;

import java.util.List;

public class QuickSort implements ListSorter<Vehicle> 
{
	public void swap(List<Vehicle> list, int left, int right)
	{
		if(left != right)
		{
			Vehicle temp = list.get(left);
			list.set(left, list.get(right));
			list.set(right, temp);
		}
	}
	
	public int partition(List<Vehicle> list, int left, int right)
	{
		Vehicle value = list.get(right);
		int i = left - 1;
		while(left <= right)
		{
			if(list.get(left).compareTo(value) <= 0)
				swap(list, ++i, left);
			++left;
		}
		return i < right ? i:i-1;
	}
	
	public void quicksort(List<Vehicle> list, int startIndex, int endIndex)
	{
		if(endIndex > startIndex)
		{
			int partition = partition(list, startIndex, endIndex);
			quicksort(list, startIndex, partition);
			quicksort(list, partition + 1, endIndex);
		}
	}
	
	public List<Vehicle> sort(List<Vehicle> list)
	{
		quicksort(list, 0, list.size() - 1);
		return list;
	}
}
