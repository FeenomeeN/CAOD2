public class List {
    private Node head = null;
    private Node last = null;

    void add(int key, String data) {
        if(head == null) {
            head = new Node(key, data);
            last = head;
        } else {
            Node temp = new Node(key, data);
            last.next = temp;
            temp.previous = last;
            last = temp;
        }
    }

    String show(int key) {
        Node current = head;
        do{
            if(current.key == key) {
                break;
            }
        }while((current = current.next) != null);
        if(current == last && current.key != key) {
            return "";
        }
        return current.data;
    }

    int delete(int key) {
        Node current = head;
        do{
            if(current.key == key) {
                break;
            }
        }while((current = current.next) != null);
        if(current == last && current.key != key) {
            return -1;
        } else {
            deleteNode(current);
        }
        return 0;
    }

    private void deleteNode(Node node) {
        if(node == last) {
            last = last.previous;
            last.next = null;
        } else if(node == head) {
            head = head.next;
            head.previous = null;
        } else {
            Node next = node.next;
            Node previous = node.previous;
            next.previous = previous;
            previous.next = next;
        }
    }

    public class Node {
        Node next;
        Node previous;
        String data;
        int key;

        Node(int key, String data) {
            this.data = data;
            this.key = key;
            next = null;
            previous = null;
        }
    }
}
