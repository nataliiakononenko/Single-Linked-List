import java.util.*;

public class SimpleLinkedList
{
   public static void main(String[] args)
   {
		Node aNode = new Node(2, null);
		Node jNode = new Node(5, aNode);
		Node iNode = new Node(9527, jNode);
		Node gNode = new Node(6, iNode);
		Node fNode = new Node(5264, gNode);
		Node eNode = new Node(1, fNode);
		Node dNode = new Node(8, eNode);
		Node cNode = new Node(-55678, dNode);
		Node bNode = new Node(3, cNode);
		Node hNode = new Node(7, bNode);

        SingleLinkedList myList = new SingleLinkedList(hNode, 10);

		System.out.println("The initial list: ");
		myList.printList();

		System.out.println("\n");
		System.out.println("Menu: \n1 - delete the first element in the list");
		System.out.println("2 - delete the last element in the list");
		System.out.println("3 - delete the first element with a given value");
		System.out.println("4 - delete all elements with a given value");
		System.out.println("5 - add an element at the beginning of the list");
		System.out.println("6 - add an element at the end of the list");
		System.out.println("7 - add an element after a chosen element");
		System.out.println("8 - add an element before a chosen element");
		System.out.println("9 - print out the list's length");
		System.out.println("10 - check if element count is correct");
		System.out.println("11 - check how many times an element occurs in the list");
		System.out.println("12 - print out the whole list (5 elements pr. line) ");
		System.out.println("13 - delete the whole list and print out the number of deleted elements ");
		System.out.println("14 - find the biggest value in the list");
		System.out.println("15 - find the smallest value in the list");
		System.out.println("0 - exit. ");

   		Scanner input = new Scanner(System.in);
   		int choice = 0;

   		do
   		{
			try
			{
   				System.out.println("\nChoose an option: ");
				choice = input.nextInt();

				if (choice == 1)
				{
					myList.deleteFirst();
				}

				else if (choice == 2)
				{
					myList.deleteLast();
				}

				else if (choice == 3)
				{
					System.out.println("Enter the integer you want to delete from the list: ");
					int newElement = input.nextInt();

					myList.deleteFirstValue(newElement);
				}

				else if (choice == 4)
				{
					System.out.println("Enter the integer you want to delete from the list: ");
					int newElement = input.nextInt();

					myList.deleteValue(newElement);
				}

				else if(choice == 5)
				{
					System.out.println("Enter an integer you want to add at the beginning og the list: ");
					int newElement = input.nextInt();

					myList.addFirst(newElement);
				}

				else if(choice == 6)
				{
					System.out.println("Enter an integer you want to add at the end of the list: ");
					int newElement = input.nextInt();

					myList.addLast(newElement);
				}

				else if(choice == 7)
				{
					System.out.println("Enter an integer you want to add to the list: ");
					int newElement = input.nextInt();

					System.out.println("After which element do you want to place the integer? Enter it's value: ");
					int place = input.nextInt();

					myList.addAfter(newElement, place);
				}

				else if(choice == 8)
				{
					System.out.println("Enter an integer you want to add to the list: ");
					int newElement = input.nextInt();

					System.out.println("Before which element do you want to place the integer? Enter it's value: ");
					int place = input.nextInt();

					myList.addBefore(newElement, place);
				}

				else if(choice == 9)
				{
					System.out.println(myList.printOutListLength());
				}

				else if(choice == 10)
				{
					System.out.println("The element count is correct: " + myList.check());
				}

				else if(choice == 11)
				{
					System.out.println("Enter the value of the element you want to check: ");
					int newElement = input.nextInt();

					System.out.println("The element occurres in the list " + myList.checkOccurrences(newElement) + " times");
				}

				else if(choice == 12)
				{
					myList.printList();
				}

				else if(choice == 13)
				{
					System.out.println("The list is deleted and " + myList.deleteAll() + " elements have been removed.");
				}

				else if(choice == 14)
				{
					System.out.println("The biggest value in the list is: " + myList.max());
				}

				else if(choice == 15)
				{
					System.out.println("The smallest value in the list is: " + myList.min());
				}

				else if(choice == 0)
				{
					System.exit(1);
				}

				else
				{
				System.out.println("Error: invalid input!");
				}
			}

    		catch(InputMismatchException ex)
    		{
				System.out.println("Try again. (" +
				"Incorrect input: an integer is required)");
				input.nextLine();
			}

    	}while(choice != 0);
	}
}

class Node
{
	int value;
	Node next;

	Node (int value, Node next)
	{
		this.value = value;
		this.next = next;
	}
}

class SingleLinkedList
{
	Node head;
	int elementCount;

	SingleLinkedList (Node head, int elementCount)
	{
		this.head = head;
		this.elementCount = elementCount;
	}

	public void deleteFirst()
	{
		if (elementCount == 0)
		{
			this.head = null;
			this.elementCount = 0;
		}
		else
		{
			this.head = head.next;
			this.elementCount = --elementCount;
		}
	}

	public void deleteLast()
	{
		if (elementCount != 0)
		{
			Node cPtr = head;

			while (cPtr.next != null)
			{
				cPtr = cPtr.next;
			}

			cPtr.next = null;
			this.elementCount = --elementCount;
		}
	}

	public void deleteFirstValue(int x)
	{
		if (elementCount != 0)
		{
			Node cPtr = head;

			if(head.value == x)
			{
				deleteFirst();
			}
			else
			{
				while( cPtr.next != null)
				{
					if(cPtr.next.value == x)
					{
						cPtr.next = cPtr.next.next;
						this.elementCount = --elementCount;
					}
					else
					{
						cPtr = cPtr.next;
					}
				}
			}
		}
	}

	public void deleteValue(int x)
	{
		if (elementCount != 0)
		{
			for(int i=0; i<elementCount; i++)
			{
				Node cPtr = head;

				if(head.value == x)
				{
					deleteFirst();
				}
			    else
			    {
					while( cPtr.next != null)
					{
						if(cPtr.next.value == x)
						{
							cPtr.next = cPtr.next.next;
							this.elementCount = --elementCount;
						}
						else
						{
							cPtr = cPtr.next;
						}
					}
				}
			}
		}
	}

	public void addFirst(int x)
	{
		if(elementCount != 0)
		{
			this.head = new Node (x, head);
			this.elementCount = ++elementCount;
		}
		else
		{
			this.head = new Node (x, null);
			this.elementCount = 1;
		}
	}

	public void addLast(int x)
	{

		if (elementCount != 0)
		{
			Node cPtr = head;

			while (cPtr.next != null)
			{
				cPtr = cPtr.next;
			}

			cPtr.next = new Node (x, null);
			this.elementCount = ++elementCount;
		}
		else
		{
			this.head = new Node (x, null);
			this.elementCount = 1;
		}
	}

	public void addAfter(int x, int y)
	{
		if (elementCount != 0)
		{
			Node cPtr = head;
			Node a = null;

		    for(int i=0; i < elementCount; i++)
		    {
			    if(cPtr.value == y)
			    {
				    a = cPtr;
				    cPtr = cPtr.next;
			    }
			    else
			    {
				    cPtr = cPtr.next;
			    }
		    }

		    if (a != null)
		    {
				Node z = new Node(x, a.next);
				a.next = z;
				this.elementCount = ++elementCount;
			}
		}
	}

	public void addBefore(int x, int y)
	{
		if (elementCount !=0)
		{
			Node cPtr = head;
			Node a = null;
			Node b = head;

		    for(int i=0; i < elementCount; i++)
		    {
			    if(cPtr.value == y)
			    {
				    a = cPtr;
				    cPtr = cPtr.next;
			    }
			    else
			    {
				    cPtr = cPtr.next;
			    }
		    }

			if(a == head)
			{
				addFirst(x);
			}
			else if(a != null)
			{
				while(b.next != a)
				{
					b = b.next;
				}
				Node z = new Node(x, a);
				b.next = z;
				this.elementCount = ++elementCount;
			}
		}
	}

	public int printOutListLength()
	{
		return elementCount;
	}

	public boolean check()
	{
		if(elementCount > 0)
		{
		    Node cPtr = head;
		    int count = 1;

		    while(cPtr.next != null)
		    {
			    cPtr = cPtr.next;
			    count++;
		    }

	   	    if(count == elementCount)
		    {
			    return true;
		    }
		    else
		    {
			    return false;
		    }
	    }
	    else
	    {
			if(head == null)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}

	public int checkOccurrences(int x)
	{
		if(elementCount > 0)
		{
		Node cPtr = head;
		int count = 0;

		for(int i=0; i < elementCount; i++)
		{
			if(cPtr.value == x)
			{
				count++;
				cPtr = cPtr.next;
			}
			else
			{
				cPtr = cPtr.next;
			}
		}
		return count;
	    }
	    else
	    {
			return 0;
		}
	}

	public void printList()
	{
		if(elementCount != 0)
		{
			Node cPtr = head;
			for (int i=1; i<=elementCount; i++)
			{
				System.out.print(cPtr.value + " ");
				if (i % 5 == 0)
				{
					System.out.println("");
			    }
				cPtr = cPtr.next;
			}
		}
	}

	public String min()
	{
		if(elementCount != 0)
		{
			Node cPtr = head;
			int min = head.value;

			for (int i=1; i<elementCount; i++)
			{
				if(cPtr.value < min)
			    {
				    min = cPtr.value;
				    cPtr = cPtr.next;
			    }
			    else
			    {
				    cPtr = cPtr.next;
			    }
		    }
		    return String.format("%s%n", min);
		}
		else
		{
			return "None. The list is empty.";
		}
	}

	public String max()
	{
		if(elementCount != 0)
		{
			Node cPtr = head;
			int max = head.value;
			for (int i=1; i<elementCount; i++)
			{
				if(cPtr.value > max)
			    {
				    max = cPtr.value;
				    cPtr = cPtr.next;
			    }
			    else
			    {
				    cPtr = cPtr.next;
			    }
		    }
		    return String.format("%s%n", max);
		}
		else
		{
			return "None. The list is empty.";
		}
	}

	public int deleteAll()
	{
		int a = elementCount;
		if (elementCount != 0)
		{
			elementCount = 0;
			head = null;
	    }
	    return a;
	}
}