package sort;
import java.util.*;

public class HeapPriorityQueue 
{
	private final List<Vehicle> list;
	
	public HeapPriorityQueue()
	{
		list = new ArrayList<Vehicle>();
	}
	
	private void swap(int index1, int index2)
	{
		Vehicle temp = list.get(index1);
		list.set(index1, list.get(index2));
		list.set(index2, temp);
	}
	
	private void swim(int index)
	{
		int parent;
		while(index != 0 && list.get(index).reverseCompareTo(list.get(parent = (index - 1) / 2)) > 0)
		{
			swap(index, parent);
			index = parent;
		}
	}
	
	private void sink(int index)
	{
		boolean isDone = false;
		int child;
		while(!isDone && (child = 2*index + 1) < list.size())
		{
			if(child < list.size() - 1 && list.get(child).reverseCompareTo(list.get(child + 1)) < 0)
				++child;
			if(list.get(index).reverseCompareTo(list.get(child)) < 0)
				swap(index, child);
			else
				isDone = true;
		}
	}
	
	public void enqueue(Vehicle value)
	{
		list.add(value);
		swim(list.size()-1);
	}
	
	public Vehicle dequeue() //throws EmptyQueueException
	{
		if(isEmpty())
			/*throw new EmptyQueueException()*/;
		Vehicle result = list.get(0);
		if(list.size() > 1)
		{
			list.set(0, list.get(list.size() - 1));
			sink(0);
		}
		list.remove(list.size() - 1);
		return result;
	}
	
	public void clear()
	{
		list.clear();
	}
	
	public int size()
	{
		return list.size();
	}
	
	public boolean isEmpty()
	{
		return list.isEmpty();
	}
}
