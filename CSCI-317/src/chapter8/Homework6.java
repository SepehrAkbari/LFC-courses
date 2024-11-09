package chapter8;

// MyLink Class from chapter5.MyLink (modified for HuffmanNode Type)
class MyLink {
    public HuffmanNode data;
    public MyLink next;

    public MyLink(HuffmanNode data) {
        this.data = data;
        this.next = null;
    }

    public void setData(HuffmanNode data) {
        this.data = data;
    }

    public HuffmanNode getData() {
        return data;
    }

    public void setNext(MyLink next) {
        this.next = next;
    }

    public MyLink getNext() {
        return next;
    }
}

// MyLinkedList Class from chapter5.MyLinkedList (modified for HuffmanNode Type)
class MyLinkedList {
    public MyLink head; 
    public int count;

    public MyLinkedList(HuffmanNode item) {
        head = new MyLink(item);
        count = 1;
    }

    public MyLinkedList() {
        head = null;
        count = 0;
    }

    public void insertHead(HuffmanNode item) {
        MyLink temp = new MyLink(item);
        temp.setNext(head);
        head = temp;
        count++;
    }

    public HuffmanNode removeHead() {
        if (head == null) {
            return null;
        } else {
            HuffmanNode temp = head.getData();
            head = head.getNext();
            count--;
            return temp;
        }
    }

    public int getCount() {
        return count;
    }

    public String toString() {
        String output = "";
        if (head != null) {
            MyLink current = head;
            while (current != null) {
                output += current.getData().getCharacter() + " ";
                current = current.getNext();
            }
        }
        return output;
    }
}

// Creating the node class from the MyBinaryTree class 
class HuffmanNode extends MyBinaryTree {
    char character;
    int frequency;

    public HuffmanNode(char character, int frequency) {
        super(frequency);
        this.character = character;
        this.frequency = frequency;
    }

    public char getCharacter() {
        return character;
    }

    // These are not needed for this assignment, but have to be included to avoid errors
    @Override
    public void insert(int key) {
        // Not needed
    }

    @Override
    public boolean remove(int key) {
        return false; // Not needed
    }

    @Override
    public boolean search(int key) {
        return false; // Not needed
    }
}

// Modifying the chapter5.HW3.MyPriorityQueue class to work with HuffmanNode
//// For some reason casting is not working, so I had to create a new class!
class MyPriorityQueue {
    private MyLinkedList list;

    public MyPriorityQueue() {
        list = new MyLinkedList();
    }

    public void insert(HuffmanNode item) {
        if (list.getCount() == 0) {
            list.insertHead(item);
        } else {
            MyLink current = list.head;
            MyLink prev = null;
            while (current != null && current.getData().frequency < item.frequency) {
                prev = current;
                current = current.getNext();
            }
            MyLink temp = new MyLink(item);
            if (prev == null) {
                list.insertHead(item);
            } else {
                prev.setNext(temp);
                temp.setNext(current);
                list.count++;
            }
        }
    }

    public HuffmanNode remove() {
        if (list.head != null) {
            return list.removeHead();
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return list.getCount() == 0;
    }
}

// Creating the Huffman tree
class HuffmanTree {
    private HuffmanNode root;
    private String[] huffmanCode; // Array to store the binary codes for each character

    // Constructor
    public HuffmanTree(char[] characters, int[] frequencies) {
        MyPriorityQueue priorityQueue = new MyPriorityQueue(); // Creating a new priority queue for Huffman nodes

        // Inserting each character and its frequency as a HuffmanNode into the priority queue
        for (int i = 0; i < characters.length; i++) {
            priorityQueue.insert(new HuffmanNode(characters[i], frequencies[i]));
        }

        // Building the tree by combining the nodes with the lowest frequencies until there is only one node left (the root)
        while (!priorityQueue.isEmpty()) {
            // Removing the node with the lowest frequency (left child)
            HuffmanNode left = priorityQueue.remove();
            
            // If the queue is empty after removing the left child, it means it was the root, so we'll set it as the root and break
            if (priorityQueue.isEmpty()) {
                root = left; 
                break;
            }

            // Now we remove the node with the second lowest frequency (right child)
            HuffmanNode right = priorityQueue.remove();

            // Creating a new internal node with frequency equal to the sum of the two children
            HuffmanNode newNode = new HuffmanNode('\0', left.frequency + right.frequency);
            newNode.setLeft(left);
            newNode.setRight(right);
            priorityQueue.insert(newNode); // Inserting the new node back into the queue
        }
        
        huffmanCode = new String[256]; // Initializing the HuffmanCode array for ASCII chars
        buildHuffmanCode(root, ""); // Building the Huffman codes starting from the root node
    }

    // Using a recursive method to traverse the tree and build the Huffman codes for each character
    public void buildHuffmanCode(HuffmanNode node, String code) {
        if (node != null) {
            // If the node is a leaf, store the code for that character 
            if (node.getCharacter() != '\0') {
                huffmanCode[node.getCharacter()] = code; // Set the character to its corresponding Huffman code
            }
            // For left child, we add "0" to the code
            buildHuffmanCode((HuffmanNode) node.getLeft(), code + "0");
            // For right child, we add "1" to the code
            buildHuffmanCode((HuffmanNode) node.getRight(), code + "1");
        }
    }

   // Method to encode (text to binary)
    public String encode(String text) {
        String encodedString = "";
        
        for (char c : text.toCharArray()) {
            encodedString += huffmanCode[c];
        }
        return encodedString;
    }

    // Method to decode (binary to string)
    public String decode(String encodedString) {
        String decodedString = "";
        HuffmanNode currentNode = root; // Starting the traversal from the root

        for (char bit : encodedString.toCharArray()) {
            // Moving to the left if the bit is '0', otherwise move to the right child
            currentNode = (bit == '0') ? (HuffmanNode) currentNode.getLeft() : (HuffmanNode) currentNode.getRight();
            // If a leaf node is reached, concatenate the character to the decoded string
            if (currentNode.getCharacter() != '\0') {
                decodedString += currentNode.getCharacter();
                currentNode = root; // Reseting to the root for the next character 
            }
        }
        return decodedString;
    }
}

// Main class
public class Homework6 {
    // testing
    public static void main(String[] args) {
        String message = "Lake Forest College";
        
        // I'll just use 256 to cover all ASCII characters
        char[] characters = new char[256];
        int[] frequencies = new int[256];

        // Populating the frequencies array
        for (char c : message.toCharArray()) {
            frequencies[c]++;
        }

        // Gather unique characters and their frequencies
        int uniqueCharCount = 0;
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] > 0) {
                characters[uniqueCharCount] = (char) i; 
                uniqueCharCount++; 
            }
        }

        HuffmanTree huffmanTree = new HuffmanTree(characters, frequencies);

        // ENCODING TEST
        String encodedMessage = huffmanTree.encode(message);
        System.out.println("Original Message: " + message);
        System.out.println("Encoded Message (Binary): " + encodedMessage);

        // DECODING TEST
        String decodedMessage = huffmanTree.decode(encodedMessage);
        System.out.println("Decoded Message: " + decodedMessage);
    }
}