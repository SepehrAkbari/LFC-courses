package chapter7;

public class Homework5_Sepehr {
    // MyLink: written in class – chapter5.MyLink
    static class MyLink {
        private String data;
        private MyLink next;

        public MyLink(String data) {
            this.data = data;
            this.next = null;
        }

        public String getData() {
            return data;
        }

        public void setNext(MyLink next) {
            this.next = next;
        }

        public MyLink getNext() {
            return next;
        }
    }

    // MyLinkedQueue: written in class mainly, but modified to handle strings 
    static class MyLinkedQueue {
        private MyLink head;
        private int count;

        public MyLinkedQueue() {
            head = null;
            count = 0;
        }

        private void insertHead(String item) {
            MyLink temp = new MyLink(item);
            temp.setNext(head);
            head = temp;
            count++;
        }

        public void insert(String item) {
            if (head == null) {
                insertHead(item);
                return;
            }
            MyLink current = head;
            while (current.getNext() != null)
                current = current.getNext();

            MyLink temp = new MyLink(item);
            current.setNext(temp);
            count++;
        }

        public String remove() {
            if (head == null)
                return null;
            else {
                String temp = head.getData();
                head = head.getNext();
                count--;
                return temp;
            }
        }

        public int getCount() {
            return count;
        }

        @Override
        public String toString() {
            StringBuilder output = new StringBuilder();
            if (head != null) {
                MyLink current = head;
                while (current != null) {
                    output.append(current.getData()).append(" ");
                    current = current.getNext();
                }
            }
            return output.toString();
        }
    }

    // little modified radixSort() method which uses ASCII for fixed 3 characters
    public static void radixSort(String[] array) {
        int ASCII_OFFSET = 65; // im using ascii values to translate string to int
        int RADIX = 26;

        MyLinkedQueue[] buckets = new MyLinkedQueue[RADIX];

        for (int i = 0; i < RADIX; i++) {
            buckets[i] = new MyLinkedQueue();
        }

        for (int position = 2; position >= 0; position--) {
            for (String word : array) {
                int charIndex = word.charAt(position) - ASCII_OFFSET;
                buckets[charIndex].insert(word);
            }

            int index = 0;
            for (MyLinkedQueue bucket : buckets) {
                while (bucket.getCount() > 0) {
                    array[index++] = bucket.remove();
                }
            }

            System.out.print("After sorting by position " + (position + 1) + ": ");
            for (String word : array) {
                System.out.print(word + " ");
            }
            System.out.println();
        }
    }

    // main()
    public static void main(String[] args) {
        String[] words = {"COW", "DOG", "SEA", "RUG", "ROW", "MOB", "BOX", "TAB", "BAR", "EAR", "TAR", "DIG", "BIG", "TEA", "NOW", "FOX"};

        System.out.println("Original array:");
        for (String word : words) {
            System.out.print(word + " ");
        }
        System.out.println("\n");

        radixSort(words);

        System.out.println();

        System.out.println("Sorted array:");
        for (String word : words) {
            System.out.print(word + " ");
        }
        System.out.println();
    }
}