package chapter5;

public class MyLinkedList {
    public MyLink head; 
    public int count;

    public MyLinkedList(int item) {
        head = new MyLink(item);
        count = 1;
    }

    public MyLinkedList() {
        head = null;
        count = 0;
    }

    public void insertHead(int item) {
        MyLink temp = new MyLink(item);
        temp.setNext(head);
        head = temp;
        count++;
    }

    public void insertTail(int item) {
        if (head == null) {
            insertHead(item);
        } else {
            MyLink current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            MyLink temp = new MyLink(item);
            current.setNext(temp);
            count++;
        }
    } 

    public boolean insertAtIndex(int item, int index) {
        if (index > count) {
            System.out.println("Index out of bounds");
            return false;
        }
        if (head == null || index == 0) {
            insertHead(item);
        } else {
            int currentNum = 0;
            MyLink current = head;
            while (currentNum < index - 1) {
                current = current.getNext();
                currentNum++;
            }
            MyLink temp = new MyLink(item);
            temp.setNext(head);
            head = temp;
        }   
        count++;
        return true;
    }

    public int removeTail() {
        if (head == null) {
            return Integer.MIN_VALUE;
        } else if (head.getNext() == null) {
            int temp = head.getData();
            head = null;
            count--;
            return temp;
        } else {
            MyLink current = head;
            while (current.getNext().getNext() != null) {
                current = current.getNext();
            }
            int temp = current.getNext().getData();
            current.setNext(null);
            count--;
            return temp;
        }
    }

    // remove head
    public int removeHead() {
        if (head == null) {
            return Integer.MIN_VALUE;
        } else {
            int temp = head.getData();
            head = head.getNext();
            count--;
            return temp;
        }
    }

    // remove at index
    public int removeAtIndex(int index) {
        if (index >= count || index < 0) {
            return Integer.MIN_VALUE;
        }
        if (head == null || index == 0) {
            return removeHead();
        } else {
            int currentNum = 0;
            MyLink current = head;
            while (currentNum < index - 1) {
                current = current.getNext();
                currentNum++;
            }
            int temp = current.getNext().getData();
            current.setNext(current.getNext().getNext());
            count--;
            return temp;
        }
    }

    public boolean search(int key) {
       if (count == 0) {
        return false;
       } else {
        MyLink current = head;
        while (current != null) {
            if (current.getData() == key) {
                return true;
            }
            current = current.getNext();
        }
        return false;
       }
    }

    public int searchIndex(int key) {
        if (count == 0) {
            return -1;
        } else {
            MyLink current = head;
            int count = 0;
            while (current != null) {
                if (current.getData() == key) {
                    return count;
                }
                current = current.getNext();
                count++;
            }
            return -1;
        }
    }

    public int getCount(){
        return count;
    }

    public String toString() {
        String output = "";
        if (head != null) {
            MyLink current = head;
            while (current != null) {
                output += current.getData() + " ";
                current = current.getNext();
            }
        }
        return output;
    }
}
