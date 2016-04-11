package sort;

import java.util.*;


public class HeapSort2 implements ListSorter<Vehicle>
{
	private HeapPriorityQueue createPriorityQueue(List<Vehicle> list)
	{
		HeapPriorityQueue queue = new HeapPriorityQueue();
		
		for(Vehicle v: list)
			queue.enqueue(v);
		return queue;
	}
	
	public List<Vehicle> sort(List<Vehicle> list)
	{
		HeapPriorityQueue queue = createPriorityQueue(list);
		List<Vehicle> result = new ArrayList<Vehicle>(list.size());
		while(!queue.isEmpty())
		{
			result.add(queue.dequeue());
		}
		return result;
	}
}
