package p3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class wordCount
{
    public static void wordCount(String input_file) throws FileNotFoundException, IOException
    {
        //Initializes the hash table
        HashTable hashTable = new HashTable();
        
        //Reads the text file into a string, then splits the string into distinct words and stores those words in an array
        String book = HashTable.readFileAsString(input_file).toLowerCase();
        String[] temp = HashTable.splitString(book);
        
        //Takes each word from the String array and searches for it in the hash table
        for(int i = 0; i < temp.length; i++)
        {
            HashTable.tableSearch(temp[i], 1);
        }
        
        //Takes the complete hash table and writes it as a string of words and frequencies
        book = hashTable.printToString();
        
        //Writes the words and their frequencies to a text file
        try (PrintWriter out = new PrintWriter("pg20776Frequencies.txt")) 
        {
            out.println(book);
        }
        
        //Prints the hash table to the console
        hashTable.print();
        
        //Calcultes the average length of the collision lists and prints it to the console
        hashTable.averageCollision();
    }
}