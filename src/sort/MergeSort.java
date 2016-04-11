package sort;

import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;

public class MergeSort implements ListSorter<Vehicle>
{
	
	public List<Vehicle> merge(List<Vehicle> first, List<Vehicle> second)
	{
		List<Vehicle> result = new ArrayList<Vehicle>();
		int iFirst = 0;
		int iSecond = 0;
		
		while(iFirst < first.size() && iSecond < second.size())
		{
			if(first.get(iFirst).compareTo(second.get(iSecond)) < 0)
			{
				result.add(first.get(iFirst));
				iFirst++;
			}
			else
			{
				result.add(second.get(iSecond));
				iSecond++;
			}
		}
		
		while(iFirst<first.size())
		{
			result.add(first.get(iFirst));
			iFirst++;
		}
		
		while(iSecond<second.size())
		{
			result.add(second.get(iSecond));
			iSecond++;
		}
		
		return result;
	}
	
	public List<Vehicle> mergeSort(List<Vehicle> list, int startIndex, int endIndex)
	{
		if(startIndex == endIndex)
		{
			List<Vehicle> out = new ArrayList<Vehicle>();
			out.add(list.get(startIndex));
			return out;
		}
		int splitIndex = startIndex + (endIndex - startIndex) / 2;
		return merge(mergeSort(list, startIndex, splitIndex),
				mergeSort(list, splitIndex + 1, endIndex));
	}
	
	public List<Vehicle> sort(List<Vehicle> list)
	{
		return mergeSort(list, 0, list.size() - 1);
	}
	
	
}