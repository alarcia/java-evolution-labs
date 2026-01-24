package lab05_sequenced_collections.modern;

import java.util.*;

public class CollectionUnified {

    public static void main(String[] args) {
        // 1. Setup Data
        List<String> list = new ArrayList<>();
        list.add("Alpha");
        list.add("Bravo");
        list.add("Charlie");

        // LinkedHashSet remembers insertion order
        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.add("One");
        set.add("Two");
        set.add("Three");

        // 2. UNIFIED ACCESS (Java 21)
        // The API is now identical for both List and Set.

        System.out.println("--- FIRST Elements ---");
        System.out.println("List First: " + list.getFirst()); // Clean
        System.out.println("Set First:  " + set.getFirst());  // Clean!

        System.out.println("\n--- LAST Elements ---");
        System.out.println("List Last: " + list.getLast()); // No math required
        System.out.println("Set Last:  " + set.getLast());  // O(1) Access! No looping!

        // 3. BONUS: REVERSED VIEW
        // Creates a reversed view of the collection instantly.
        System.out.println("\n--- Reversed View ---");
        System.out.println(list.reversed());
        System.out.println(set.reversed());
    }
}