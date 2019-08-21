package com.nerosmith.java.Trie.Using_HashMap_and_Array;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
            ArrayList<String>  words = new ArrayList<>();
            if (FileOperation.readFile("C:/pride-and-prejudice.txt",words) &&
                    FileOperation.readFile("C:/a-tale-of-two-cities.txt",words)){

                    long startTime = System.nanoTime();
                    BSTSet<String> set = new BSTSet<>();
                    for(String word: words)
                        set.add(word);

                    for(String word: words)
                        set.contains(word);

                    long endTime = System.nanoTime();

                    double time = (endTime - startTime) / 1000000000.0;

                    System.out.println("Total different words: " + set.getSize());
                    System.out.println("BSTSet: " + time + " s");

                    startTime = System.nanoTime();

                    Trie trie = new Trie();
                    for(String word: words)
                        trie.add(word);

                    for(String word: words)
                        trie.contains(word);

                    endTime = System.nanoTime();

                    time = (endTime - startTime) / 1000000000.0;

                    System.out.println("Total different words: " + trie.getSize());
                    System.out.println("TreeMap Trie: " + time + " s");


                    startTime = System.nanoTime();
                    Trie2 trie2 = new Trie2();
                    for (String word : words)
                        trie2.add(word);

                    for (String word : words)
                        trie2.contains(word);

                    endTime = System.nanoTime();
                    time = (endTime - startTime) / 1000000000.0;

                    System.out.println("Total different words: " + trie2.getSize());
                    System.out.println("HashMap Trie: " + time + " s");

                    startTime = System.nanoTime();
                    Trie3 trie3 = new Trie3();
                    for (String word : words)
                        trie3.add(word);

                    for(String word: words)
                        trie3.contains(word);

                    endTime = System.nanoTime();

                    time = (endTime - startTime) / 1000000000.0;

                    System.out.println("Total different words: " + trie3.getSize());
                    System.out.println("Array(Map) Trie: " + time + " s");
                }
        }
}
