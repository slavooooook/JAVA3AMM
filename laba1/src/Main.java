

public class Main {
    static class Node {
        private Integer value_;
        private Node next_;

        int getValue() { return value_; }
        void setValue_(int value) { value_ = value; }
        Node getNext() { return next_; }
        void setNext_(Node next) { next_ = next; }

        Node() {
            value_ = null;
            next_ = null;
        }
        Node(int value) {
            value_ = value;
            next_ = null;
        }
        Node(int value, Node next) {
            value_ = value;
            next_ = next;
        }
    }
    static class List {
        private Node header, tail;
        List() {
            header = new Node();
        }

        void add(int value) {
            if (header.getNext() == null) {
                tail = new Node(value, null);
                header.setNext_(tail);
            }
            else {
                Node tmp = new Node(value);
                tail.setNext_(tmp);
                tail = tmp;
            }
        }

        void print() {
            Node tmp = header.getNext();
            while (tmp != null) {
                System.out.print(tmp.getValue() + " ");
                tmp = tmp.getNext();
            }
            System.out.println();
        }

        void printNode(int index) {
            if (index >= 0 ) {
                Node tmp = header.getNext();
                while (index > 1 && tmp != null) {
                    index--;
                    tmp = tmp.getNext();
                }
                if (tmp != null) {
                    System.out.println(tmp.getValue());
                } else {
                    System.out.println("Попытка вывести несуществующий элемент");
                }
            } else {
                System.out.println("Попытка вывести несуществующий элемент");
            }
        }

        void remove(int index) {
            if (index >= 0 ) {
                Node tmp = header;
                while (index > 1 && tmp != null) {
                    index--;
                    tmp = tmp.getNext();
                }
                if (tmp.getNext() != null) {
                    tmp.setNext_(tmp.getNext().getNext());
                } else {
                    System.out.println("Попытка удалить несуществующий элемент");
                }
            } else {
                System.out.println("Попытка удалить несуществующий элемент");
            }
        }
    }

    public static void main(String[] args) {
        List list = new List();
        for (int i = 0; i < 10; i++)
            list.add(i+1);
        list.remove(10);
        list.remove(1);
        list.remove(9);
        list.print();
        list.printNode(3);
    }
}
