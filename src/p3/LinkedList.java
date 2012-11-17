package p3;

public class LinkedList
{
    private int size;
    private Node root;
    
    //NumLinkedList Constructor creates root node that will point to the first node with data
    public LinkedList()
    {
        root =  new Node();
        size = 0;
    }

    //Returns the size of the LinkedList
    public int size()
    {
        return size;
    }
    
    //Inserts a new node into the Linked List
    public void insert(Node node)
    {
        Node temp = root;
        
        //Cycles the values in the list until it has reached the spot where the new node is to be inserted
        for(int count = 0; count < size; count++)
        {
            temp = temp.getNext();
        }
        
        //Creates a new node, assigns the new node the specified value, 
        //sets the next values of the new node and the node before it so that the list is correctly linked
        Node newNode = node;
        //System.out.println(newNode.getWord() +" " +newNode.getFreq());
        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
        
        //Increases the size of the array
        size++;
    }
    
    //Finds a node at a specific index of a Linked List
    public Node lookup(int i)
    {   
        //Catches invalid indices
        if (i < 0 || i > size)
        {
            throw new IndexOutOfBoundsException("That index is invalid. Please pick an index within the size of the list");
        }
        
        Node temp = root.getNext();
        
        //Cycles through the nodes of the list until it has reached the desired node
        for (int count = 0; count <= i; count++)
        {
                temp = temp.getNext();
        }
        
        //Returns the desired node
        return temp;
    }

    //Searches the linked list for a node with the specified word as its value
    public Node search(String word)
    {   
        Node temp = root.getNext();
        
        for (int count = 0; count < size; count++)
        {
            if (temp.getWord().equals(word))
            {
                return temp;
            }
            
            temp = temp.getNext();
        }
        
        return null;
    }

    //Prints the word and frequency of each node to the console
    public void print()
    {
        Node temp = root.getNext();
        
        //Cycles through each node of the list and prints its value
        for(int i = 0; i < size; i++)
        {
            System.out.println("(" +temp.getWord() +" " +temp.getFreq() +")");
            temp = temp.getNext();
        }
    }
    
    //Prints the word and frequency of each node to a string
    public String printToString()
    {
        String complete = "";
        
        Node temp = root.getNext();
        
        for (int i = 0; i < size; i++)
        {
            complete += "(" +temp.getWord() +" " +temp.getFreq() +")" +"\r\n";
            temp = temp.getNext();
        }
        
        return complete;
    }
}
