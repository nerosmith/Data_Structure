package com.nerosmith.java.Set_and_Map.LinkedListSet;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("C:/pride-and-prejudice.txt",words)){
                LinkedListSet<String> set = new LinkedListSet<>();
                for (String word : words)
                    set.add(word);
                System.out.println("Total different words: " + set.getSize());
            }
        System.out.println();

        System.out.println("A Tale of Two Cities");
        ArrayList<String> words2 = new ArrayList<>();
        if (FileOperation.readFile("C:/a-tale-of-two-cities.txt",words2)){
                LinkedListSet<String> set2 = new LinkedListSet<>();
                for (String word : words2)
                    set2.add(word);
                System.out.println("Total different words: " + set2.getSize());
            }
    }
}
