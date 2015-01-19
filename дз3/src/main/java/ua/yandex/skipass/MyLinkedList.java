package ua.yandex.skipass;

public class MyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    MyLinkedList() {
        head = new Node();
        tail = head;
        head.data = null;
    }

    static private class Node {

        private Node next;
        private Node last;
        private Object data;

        Node() {
            data = new Object();
        }
    }

    public int size() {
        return size;
    }

    public void add(int index, Object e) {
        checkBorderForAdd(index);
        if (index == 0) {
            this.addFirst(e);
            return;
        }
        if (size() == index) {
            this.addLast(e);
            return;
        }
        Node placeWhereAdd = head;
        for (int i = 1; i < index; i++) {
            placeWhereAdd = placeWhereAdd.next;
        }
        Node temp = new Node();
        temp.last = placeWhereAdd;
        temp.next = placeWhereAdd.next;
        temp.data = e;
        placeWhereAdd.next = temp;
        size++;
    }

    public void addFirst(Object e) {
        if (head.data == null) {
            head.data = new Object();
            head.data = e;
            size++;
            return;
        }
        Node temp = new Node();
        temp.last = null;
        temp.next = head;
        temp.data = e;
        head.last = temp;
        head = temp;
        size++;
    }

    public void addLast(Object e) {
        add(e);
    }

    public void add(Object e) {
        if (head.data == null) {
            head.data = e;
            size++;
            return;
        }
        Node temp = new Node();
        temp.next = null;
        temp.data = e;
        temp.last = tail;
        tail.next = temp;
        tail = temp;
        size++;
    }

    public Object getFirst() {
        checkBorderForAccess(0);
        return head.data;
    }

    public Object getLast() {
        checkBorderForAccess(0);
        return tail.data;
    }

    public Object get(int index) {
        checkBorderForAccess(index);
        if (index == 0) {
            return getFirst();
        }
        if (index == size() - 1) {
            return getLast();
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public void clear() {
        head.next = null;
        head.data = null;
        tail = head;
        size = 0;
    }

    public boolean isEmpty() {
        return head.data == null;
    }

    public Object[] toArray() {
        Object[] array = new Object[size()];
        Node temp = head;
        for (int i = 0; i < size(); i++) {
            array[i] = temp.data;
            temp = temp.next;
        }
        return array;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        Node temp = head;
        for (int i = 0; i < size(); i++) {
            buf.append(temp.data);
            if (i < size() - 1) {
                buf.append(',');
            }
            temp = temp.next;
        }
        return buf.toString();
    }

    public Object removeFirst() {
        checkBorderForAccess(0);
        Object temp = head.data;
        head = head.next;
        head.last = null;
        size--;
        return temp;

    }

    public Object removeLast() {
        checkBorderForAccess(0);
        Object temp = tail.data;
        tail = tail.last;
        tail.next = null;
        size--;
        return temp;
    }

    public Object remove(int index) {
        checkBorderForAccess(index);
        if (index == 0) {
            return removeFirst();
        }
        if (index == size() - 1) {
            return removeLast();
        }
        Node willDelete = head;
        for (int i = 0; i < index; i++) {
            willDelete = willDelete.next;
        }
        willDelete.next.last = willDelete.last;
        willDelete.last.next = willDelete.next;
        size--;
        return willDelete.data;
    }

    public void set(int index, Object e) {
        checkBorderForAccess(index);
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.data = e;
    }

    public int indexOf(Object o) {
        Node temp = head;
        for (int i = 0; i < size(); i++) {
            if (o == null) {
                if (temp.data == null) {
                    return i;
                }
            } else if (temp.data == o) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    public void addAll(Object[] c) {
        for (Object added : c) {
            this.add(added);
        }
    }

    public void addAll(int index, Object[] c) {
        checkBorderForAdd(index);
        if (index == size) {
            addAll(c);
            return;
        }
        if (index == 0) {
            Node oldHead = head;
            Node now = new Node();
            now.data = c[0];
            head = now;
            for (int i = 1; i < c.length; i++) {
                Node temp = new Node();
                temp.last = now;
                now.next = temp;
                temp.data = c[i];
                now = temp;
            }
            now.next = oldHead;
            oldHead.last = now;
            size += c.length;
            return;
        }
        Node placeWhereAdd = head;
        for (int i = 1; i < index; i++) {
            placeWhereAdd = placeWhereAdd.next;
        }
        Node twoPart = placeWhereAdd.next;
        for (Object addNow : c) {
            Node temp = new Node();
            temp.last = placeWhereAdd;
            placeWhereAdd.next = temp;
            temp.data = addNow;
            placeWhereAdd = temp;
        }
        size += c.length;
        placeWhereAdd.next = twoPart;
        twoPart.last = placeWhereAdd;
    }

    private void checkBorderForAdd(int index) {
        if (size() < index || index < 0) {
            throw new MyException("ReferenceToUncreatedElement");
        }
    }

    private void checkBorderForAccess(int index) {
        if (size() <= index || index < 0) {
            throw new MyException("ReferenceToUncreatedElement");
        }
    }
}
