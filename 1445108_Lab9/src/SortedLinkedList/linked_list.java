package SortedLinkedList;

public class linked_list {

	private String list_name;
	private node first, list;
	private int nodeCount = 0;
	
	public linked_list(String name)
	{
		setList_name(name);
	}
	
	/*public void add(int val)
	{
		if(list==null)
		{
			list = new node();
			list.value = val;
			list.next = null;
			setFirst(list);
		}
		else
		{
			node temp;
			//temp = list;
			temp = first;
			while(temp.next!=null && val<temp.value  )
			{
				temp=temp.next;	
			}
			
			list = new node();
			list.value = val;
			list.next = temp.next;
			temp.next = list;			
		}
		nodeCount++;
	}*/
	
	public void sortedAdd(int val)
	{
		//first is first node, list is last node...
		if(list==null)
		{
			list = new node();
			list.value = val;
			list.next = null;
			setFirst(list);			
		}
		else
		{
			if(val<first.value)
			{
				list = new node();
				list.value = val;
				list.next = first;
				setFirst(list);
				list = list.next;
				
			}
			else
			{
				node temp = first.next;
				while(temp!=list)
				{
					if(temp.value < val)
					{
						node newNode = new node();
						newNode.value =val;
						newNode.next = temp.next;
						temp.next = newNode;
					}
					temp = temp.next;
				}
				if(temp == list && temp.value < val)
				{
					//adding at the last position
					list = new node();
					list.next = null;
					list.value = val;
					temp.next = list;
				}
				
			}
						
		}
		nodeCount++;
	}
	
	public void printlist()
	{
		node temp = first;
		while(temp.next!=null)
		{
			System.out.println(temp.value);
			temp = temp.next;
		}
		System.out.println(temp.value);
	}
	
	public void delete()
	{
		
	}
	
	public int Count()
	{
		return nodeCount;
	}

	/*Getter and Setter*/
	public String getList_name() {
		return list_name;
	}

	public void setList_name(String list_name) {
		this.list_name = list_name;
	}

	public node getFirst() {
		return first;
	}

	public void setFirst(node first) {
		this.first = first;
	}
}
