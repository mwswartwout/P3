
package p3;


public class Node 
{
    private int freq;
    private String word;
    private Node next;
    
    //Node constructor
    public Node()
    {
        freq = 1;
    }
    
    //Increases the frequency value of the node by 1
    public void increaseFrequency()
    {
        freq++;
    }
    
    //Returns the next node
    public Node getNext()
    {
        return next;
    }
    
    //Returns the word associated with the node
    public String getWord()
    {
        return word;
    }
    
    //Sets the value of the next node to the specified node
    public void setNext(Node node)
    {
        next = node;
    }
    
    //Sets the value of the node's word to the specified string
    public void setWord(String string)
    {
        word = string;
    }
    
    //Returns the frequency associated with the node
    public int getFreq()
    {
        return freq;
    }
    
    //Sets the frequency to the specified integer
    public void setFreq(int frequency)
    {
        freq = frequency;
    }
}
