package no.INFO233.v18.oblig1.matsh;

import java.util.Arrays;


public class Main {

    private static long startTime;
    private static long endTime;

    public static void main(String[] args) {

        IDeque<String> myDeque = new ArrayDeque<String>();


        try {
            myDeque.addFirst("Mats");
            myDeque.addFirst("Per");

            System.out.println("Hva er størrelsen på arrayet? " + myDeque.size());


            System.out.println("Siste element er " + myDeque.peekLast());
            System.out.println("Første element er " + myDeque.peekFirst());


        } catch (DequeFullException e) {
            e.printStackTrace();
        }

        try {
            myDeque.pullFirst();

        } catch (DequeEmptyException e) {
            e.printStackTrace();
        }

        System.out.println(Arrays.deepToString(myDeque.toArray(new String[0])));

        boolean isPresent = (myDeque.contains("5") && myDeque.contains("4"));
        System.out.println("Element present?  " + isPresent);

        System.out.println("Bruker clear():");
        myDeque.clear();
        System.out.println(Arrays.deepToString(myDeque.toArray(new String[0])));


    }
}
