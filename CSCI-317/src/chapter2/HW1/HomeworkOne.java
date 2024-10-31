/*
 * My name is Sepehr, I'm a sophomore CS major, and potentially a Math & Data Science minor.
 * I'm taking this course of course as part of my requirements, but also as I think its perhaps the most important topic in my field, and will elevate me from a programmer to a computer scientist, who can understand, rather than just writing for functionality. So, I am very excited.
 * Reading (mostly humanities) and writing programs are about it, I also try to hangout with people and workout as much as life allows.
 * Python, Java, C, SQL, JS, HTML/CSS, R. I hate frontend, but have unfortunetly worked with it a lot. Favorite language is definetly C, I wish it was a bit easier to write it though. I've also worked with many different frameworks and libraries especially in Python.
 * I hope to have a good understanding of the material. I want to be able to analyze code in a higher level, and be thinking about efficiency while doing anything. I hope to move away from doing basic intereface projects, and move on to research and exploratory projects, with help of this course.
 */

package chapter2.HW1;

import java.util.function.*;

import chapter1.Array.MyArray;
import chapter2.OrderedArray.MyOrderedArray;


public class HomeworkOne {
    public static void timeComplexity(int size, Runnable function) {
        long startTimeMS = System.currentTimeMillis();
        long startTimeNS = System.nanoTime();

        function.run();

        long endTimeNS = System.nanoTime();
        long endTimeMS = System.currentTimeMillis();

        System.out.println("Time taken (" + size + "): " + (endTimeMS - startTimeMS) + "ms");
        System.out.println("Time taken (" + size + "): " + (endTimeNS - startTimeNS) + "ns");
        System.out.print("\n");
    }

    public static void conditionalTimeComplexity(int size, BooleanSupplier condition, Runnable function) {
        boolean n = false;
        while (!n) {
            if (condition.getAsBoolean()) {
                long startTimeMS = System.currentTimeMillis();
                long startTimeNS = System.nanoTime();
        
                function.run();  
                
                long endTimeNS = System.nanoTime();
                long endTimeMS = System.currentTimeMillis();
                
                System.out.println("Time taken (" + size + "): " + (endTimeMS - startTimeMS) + "ms");
                System.out.println("Time taken (" + size + "): " + (endTimeNS - startTimeNS) + "ns");
                System.out.print("\n");
                
                n = true;
            }
        }
    }
    
    public static void main(String[] args) {
        final int SIZE = 100;

        //// Problem 2 ////
        System.out.println("\n\n-- Unordered Array --\n\n");

        //// Problem 2.a ////

        MyArray arr1 = new MyArray(SIZE);
        MyArray arr2 = new MyArray(SIZE * 10);
        MyArray arr3 = new MyArray(SIZE * 100);

        //// Problem 2.b ////

        for (int i = 0; i < SIZE * 100; i++) {
            if (i < SIZE) {
                arr1.add((int) (Math.random() * SIZE));
            } else if (i < SIZE * 10) {
                arr2.add((int) (Math.random() * (SIZE * 10)));
            } else {
                arr3.add((int) (Math.random() * (SIZE * 100)));
            }
        }

        //// Problem 2.c ////

        System.out.println("Running time of remove(): \n");
        timeComplexity(SIZE, () -> arr1.remove());
        timeComplexity(SIZE * 10, () -> arr2.remove());
        timeComplexity(SIZE * 100, () -> arr3.remove());

        System.out.print("\n");

        //// Problem 2.d ////
        
        System.out.println("Running time of search(): \nSearching for a random number in the array\n");
        timeComplexity(SIZE, () -> arr1.search((int) (Math.random() * SIZE)));
        timeComplexity(SIZE * 10, () -> arr2.search((int) (Math.random() * (SIZE * 10))));
        timeComplexity(SIZE * 100, () -> arr3.search((int) (Math.random() * (SIZE * 100))));

        System.out.print("\n");

        System.out.println("Running time of search(): \nSearching for a non-existing number in the array\n");
        timeComplexity(SIZE, () -> arr1.search(SIZE));
        timeComplexity(SIZE * 10, () -> arr2.search(SIZE * 10));
        timeComplexity(SIZE * 100, () -> arr3.search(SIZE * 100));

        System.out.print("\n");

        //// Problem 2.e ////

        System.out.println("Running time of add(): \n");
        timeComplexity(SIZE, () -> arr1.add((int) (Math.random() * SIZE)));
        timeComplexity(SIZE * 10, () -> arr2.add((int) (Math.random() * (SIZE * 10))));
        timeComplexity(SIZE * 100, () -> arr3.add((int) (Math.random() * (SIZE * 100))));

        System.out.print("\n");

        //// Problem 3 ////
        System.out.println("\n\n-- Ordered Array --\n\n");

        //// Problem 3.a ////

        MyOrderedArray oArr1 = new MyOrderedArray(SIZE);
        MyOrderedArray oArr2 = new MyOrderedArray(SIZE * 10);
        MyOrderedArray oArr3 = new MyOrderedArray(SIZE * 100);

        //// Problem 3.b ////

        for (int j = 0; j < SIZE * 100; j++) {
            if (j < SIZE) {
                oArr1.add((int) (Math.random() * SIZE));
            } else if (j < SIZE * 10) {
                oArr2.add((int) (Math.random() * (SIZE * 10)));
            } else {
                oArr3.add((int) (Math.random() * (SIZE * 100)));
            }
        }

        //// Problem 3.c ////

        System.out.println("Running time of removeKey(): \n");
        conditionalTimeComplexity(SIZE, 
            () -> oArr1.removeKey((int) (Math.random() * SIZE)),  
            () -> oArr1.removeKey((int) (Math.random() * SIZE)) 
        );
        conditionalTimeComplexity(SIZE * 10, 
            () -> oArr2.removeKey((int) (Math.random() * SIZE * 10)),  
            () -> oArr2.removeKey((int) (Math.random() * (SIZE * 10)))
        );
        conditionalTimeComplexity(SIZE * 100, 
            () -> oArr3.removeKey((int) (Math.random() * SIZE * 100)),  
            () -> oArr3.removeKey((int) (Math.random() * (SIZE * 100)))
        );

        System.out.print("\n");

        //// Problem 3.d ////

        System.out.println("Running time of search(): \nSearching for a random number in the array\n");
        timeComplexity(SIZE, () -> oArr1.search((int) (Math.random() * SIZE)));
        timeComplexity(SIZE * 10, () -> oArr2.search((int) (Math.random() * (SIZE * 10))));
        timeComplexity(SIZE * 100, () -> oArr3.search((int) (Math.random() * (SIZE * 100))));

        System.out.print("\n");

        System.out.println("Running time of search(): \nSearching for a non-existing number in the array\n");
        timeComplexity(SIZE, () -> oArr1.search(SIZE));
        timeComplexity(SIZE * 10, () -> oArr2.search(SIZE * 10));
        timeComplexity(SIZE * 100, () -> oArr3.search(SIZE * 100));

        System.out.print("\n");

        //// Problem 3.e ////

        System.out.println("Running time of add(): \n");
        timeComplexity(SIZE, () -> oArr1.add((int) (Math.random() * SIZE)));
        timeComplexity(SIZE * 10, () -> oArr2.add((int) (Math.random() * (SIZE * 10))));
        timeComplexity(SIZE * 100, () -> oArr3.add((int) (Math.random() * (SIZE * 100))));
    }
}

/* OUTPUT (different every time):

-- Unordered Array --


Running time of remove(): 

Time taken (100): 0ms
Time taken (100): 3541ns

Time taken (1000): 0ms
Time taken (1000): 2541ns

Time taken (10000): 0ms
Time taken (10000): 2042ns


Running time of search(): 
Searching for a random number in the array

Time taken (100): 0ms
Time taken (100): 5041ns

Time taken (1000): 0ms
Time taken (1000): 3666ns

Time taken (10000): 0ms
Time taken (10000): 8083ns


Running time of search(): 
Searching for a non-existing number in the array

Time taken (100): 0ms
Time taken (100): 2917ns

Time taken (1000): 0ms
Time taken (1000): 14208ns

Time taken (10000): 0ms
Time taken (10000): 120292ns


Running time of add(): 

Time taken (100): 0ms
Time taken (100): 2875ns

Time taken (1000): 0ms
Time taken (1000): 1708ns

Time taken (10000): 0ms
Time taken (10000): 1708ns




-- Ordered Array --


Running time of removeKey(): 

Time taken (100): 0ms
Time taken (100): 1916ns

Time taken (1000): 0ms
Time taken (1000): 2584ns

Time taken (10000): 0ms
Time taken (10000): 122750ns


Running time of search(): 
Searching for a random number in the array

Time taken (100): 0ms
Time taken (100): 3166ns

Time taken (1000): 0ms
Time taken (1000): 2750ns

Time taken (10000): 0ms
Time taken (10000): 3333ns


Running time of search(): 
Searching for a non-existing number in the array

Time taken (100): 0ms
Time taken (100): 2375ns

Time taken (1000): 0ms
Time taken (1000): 2541ns

Time taken (10000): 0ms
Time taken (10000): 2584ns


Running time of add(): 

Time taken (100): 0ms
Time taken (100): 2333ns

Time taken (1000): 0ms
Time taken (1000): 2125ns

Time taken (10000): 0ms
Time taken (10000): 2958ns
*/