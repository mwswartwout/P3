package p3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class HashTable 
{
    static LinkedList[] hashTable;
    
    //HashTable constructor
    public HashTable()
    {
        hashTable = new LinkedList[2];
    }

    //Searches the table for a given word and either inserts it as a new word or increases the frequency by 1 if it already exists in the hash table
    public static void tableSearch(String word, int frequency)
    { 
        //Calculates the hash code of the word
        int hash = Math.abs(word.hashCode() % hashTable.length);
        
        //If the index in the hash table is null of the word does not exist in that index it inserts it as a new word
        if (hashTable[hash] == null || hashTable[hash].search(word) == null)
        {
            insert(word, frequency);
        }
        
        //If the word is already in the hash table it increases the frequency by 1
        else
        {
            hashTable[hash].search(word).increaseFrequency();
        }
    }
    
    //Rehashes the table
    public static void rehash()
    {   
        //Stores the old hash table
        LinkedList[] oldTable = hashTable;
        
        //Creates a new hash table double the length of the old one
        hashTable = new LinkedList[oldTable.length*2];
        
        //Initation loop runs through every index of the old hash table
        for (int i = 0; i < oldTable.length; i++)
        {
            if (oldTable[i] != null)
            {             
                //If the index of the old hash table contained a linked list the second loop iterates through each node of that list
                for (int a = 0; a < oldTable[i].size(); a++)
                {          
                    if (oldTable[i].lookup(a) != null)
                    {   
                        //Does a search of the new hash table for the word from the old hash table, inserts or iterates depending on results
                        tableSearch(oldTable[i].lookup(a).getWord(), oldTable[i].lookup(a).getFreq());
                    }
                }
            }
        }
    }
    
    //Inserts a new word into the hash table
    public static void insert(String word, int frequency)
    {   
        //Creates the new node with the proper word and frequency (if applicable)
        Node newNode = new Node();
        newNode.setWord(word);
        newNode.setFreq(frequency);
        
        //If the addition of the new node will require a rehash the rehash is done first, making sure the insert does not have to be done twice
        if ((calculateEntries() + 1)/hashTable.length > .8)
        {
            rehash();
        }
        
        //Calculates the hash code of the word
        int hash = Math.abs(word.hashCode() % hashTable.length);
        
        //If that index does not have a linked list the list is initialized
        if (hashTable[hash] == null)
        {
            hashTable[hash] = new LinkedList();
        }
        
        //Inserts the word and frequency into the linked list at that index
        hashTable[hash].insert(newNode); 
    }
    
    //Takes a text file and returns it as a string
    public static String readFileAsString(String fileName) throws FileNotFoundException, IOException
    {
        String book = "";
        char nextChar;
       
        //Creates a file reader to read the file
        FileReader scanner;
        scanner = new FileReader(fileName);
        
        //Reads each char of the file and adds it to the book string
        while(scanner.ready())
        {   
            nextChar = (char)scanner.read();
            book += nextChar;
        }
        
        scanner.close();
        
        return book;
    }
    
    //Splits a string up using regular expressions
    public static String[] splitString(String string)
    {
        //"[^0-9a-z]" will spllit the string anytime a character that is not a number or lowercase letter is encountered
        return string.split("[^0-9a-z]");
    }
    
    //Prints the hashtable to the console
    public void print()
    {
        //For-loop iterates through the hash table and prints the linked lists each index contains
        for (int i = 0; i < hashTable.length; i++)
        {
            if (hashTable[i] != null)
            {
                hashTable[i].print();
            }
        }
        
        System.out.println();
    }
    
    //Prints the hash table as a string
    public String printToString()
    {
        String complete = "";
        
        //For-loop iterates through the hash table and prints each linked list as a string
        for (int i = 0; i < hashTable.length; i++)
        {
            if (hashTable[i] != null)
            {
                complete += hashTable[i].printToString();
            }
        }
        
        return complete;
    }
    
    //Caculates how many words are stored within the hash table
    public static double calculateEntries()
    {
        double sum = 0;
        
        //For-loop iterates through the hash table and finds how many nodes are in each linked list
        for (int i = 0; i < hashTable.length; i++)
        {
            if (hashTable[i] != null)
            {
                sum += hashTable[i].size();
            }
        }
        
        return sum;
    }
    
    //Prints the average length of each collision list to the console
    public void averageCollision()
    {
        double entries = calculateEntries();
        
        System.out.println("The average length of the collision lists is " +entries/hashTable.length);
    }
}
