package lab05_sequenced_collections.legacy;

import java.util.*;

public class CollectionHell {

    public static void main(String[] args) {
        // A List (Ordered)
        List<String> list = new ArrayList<>();
        list.add("Alpha");
        list.add("Bravo");
        list.add("Charlie");

        // A LinkedHashSet (Ordered by insertion, but it's a Set)
        Set<String> set = new LinkedHashSet<>();
        set.add("One");
        set.add("Two");
        set.add("Three");

        // 1. Getting FIRST element
        String firstList = list.get(0); // List uses index
        String firstSet = set.iterator().next(); // Set needs Iterator

        // 2. Getting LAST element
        String lastList = list.get(list.size() - 1); // Manual

        // LinkedHashSet has NO direct way to get the last element in Java 8.
        // We have to iterate the whole set to find the end. O(N) performance...
        String lastSet = "";
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            lastSet = it.next();
        }

        System.out.println("Legacy First: " + firstList + ", " + firstSet);
        System.out.println("Legacy Last:  " + lastList + ", " + lastSet);
    }
}