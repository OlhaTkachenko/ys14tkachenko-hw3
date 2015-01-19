package ua.yandex.skipass;

public class MyArrayList {

    private static final int DEFAULT_CAPACITY = 10;
    private static final int DEFAULT_INCREASE = 1;
    private Object[] arrayList;
    private int size;

    public MyArrayList() {
        arrayList = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public MyArrayList(int initialCapacity) {
        arrayList = new Object[initialCapacity];
        size = 0;
    }

    private int arrayListMaxSize() {
        return arrayList.length;
    }

    public void ensureCapacity(int newCapacity) {
        Object[] tempList = new Object[arrayList.length];
        System.arraycopy(arrayList, 0, tempList, 0, size);
        arrayList = new Object[newCapacity];
        System.arraycopy(tempList, 0, arrayList, 0, size);
    }

    public void add(Object e) {
        if (size == arrayList.length) {
            ensureCapacity(size + DEFAULT_INCREASE);
        }
        arrayList[size] = e;
        size++;
    }

    public void add(int index, Object e) {
        checkBorderForAdd(index);
        if (size == arrayList.length) {
            ensureCapacity(size + DEFAULT_INCREASE);
        }
        size++;
        for (int ind = size - 1; ind >= index; ind--) {
            arrayList[ind] = arrayList[ind - 1];
        }
        arrayList[index] = e;
    }

    public void addAll(Object[] c) {
        for (Object added : c) {
            this.add(added);
        }
    }

    public void addAll(int index, Object[] c) {
        checkBorderForAdd(index);
        if (size + c.length > arrayList.length) {
            ensureCapacity(size + c.length);
        }
        for (int ind = size - 1; ind >= index; ind--) {
            arrayList[ind + c.length] = arrayList[ind];
        }
        System.arraycopy(c, 0, arrayList, index, c.length);
        size += c.length;
    }

    public Object get(int index) {
        checkBorderForAccess(index);
        return arrayList[index];
    }

    public Object remove(int index) {
        checkBorderForAccess(index);
        Object result = get(index);
        for (int ind = index; ind < size; ind++) {
            arrayList[ind - 1] = arrayList[ind];
        }
        size--;
        ensureCapacity(size);
        return result;
    }

    public void set(int index, Object e) {
        checkBorderForAccess(index);
        arrayList[index] = e;

    }

    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
             if (o == null) {
                if (arrayList[i] == null) {
                    return i;
                }
            } else if (arrayList[i]== o) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public void clear() {
        arrayList = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object[] toArray() {
        Object[] result = new Object[size];
        System.arraycopy(arrayList, 0, result, 0, size);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < size; i++) {
            buf.append(arrayList[i]);
            if (i < size - 1) {
                buf.append(',');
            }
        }
        return buf.toString();
    }

    private void checkBorderForAdd(int index) {
        if (size < index || index < 0) {
            throw new MyException("ReferenceToUncreatedElement");
        }
    }

    private void checkBorderForAccess(int index) {
        if (size <= index || index < 0) {
            throw new MyException("ReferenceToUncreatedElement");
        }
    }
}
