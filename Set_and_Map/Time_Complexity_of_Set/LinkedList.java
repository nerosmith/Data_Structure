package com.nerosmith.java.Set_and_Map.Time_Complexity_of_Set;

public class LinkedList<E> {

    private class Node{
            public E e;
            public Node next;

            public Node(E e,Node next){
                    this.e = e;
                    this.next = next;
                }

            public Node(E e){
                    this(e,null);
                }

            public Node(){
                    this(null,null);
                }

            @Override
            public String toString() {
                return e.toString();
            }
    }

    private Node dummyHead;
    private int size;

    public LinkedList(){
            dummyHead = new Node();
            size = 0;
        }

    // 獲取鏈表中的元素個數
    public  int getSize(){
            return size;
        }

    // 返回鏈表是否為空
    public boolean isEmpty(){
        return size == 0;
    }

    // 在鏈表頭添加新的元素 e
    public void addFirst(E e){
         // Node node = new Node(e);
         // node.next = head;
         // head = node;
           add(0,e);
        }

    // 在鏈表尾添加新的元素e
    public void addLast(E e){
            add(size,e);
        }

    // 在鏈表任意位置添加新的元素e
    public void addAnywhere(int index,E e){
            add(index,e);
        }

    // 在鏈表的index(0-based)位置添加新的元素e
    private void add(int index ,E e){
            if (index < 0 || index > size)
                throw new IllegalArgumentException("Add failed. Illegal index.");

            Node prev = dummyHead;
            for (int i = 0; i < index; i++)
                prev = prev.next;

            prev.next = new Node(e,prev.next);
            size++;
        }

    // 獲得鏈表的第一個元素
    public E getFirst(){
            return get(0);
        }

    // 獲得鏈表的最後一個元素
    public E getLast(){
            return get(size-1);
        }

    // 獲得鏈表的任意元素
    public E getAnywhere(int index){
            return get(index);
        }

    // 獲得鏈表的第index(0-based)個位置的元素
    private E get(int index){
            if (index < 0 || index > size)
                throw new IllegalArgumentException("Get failed. Illegal index.");
            Node cur = dummyHead.next;
            for (int i = 0; i < index; i++)
                cur = cur.next;
            return cur.e;
        }

    // 修改鏈表的第index(0-based)個位置的元素為
    public void set(int index,E e){
            if (index < 0 || index > size)
                throw new IllegalArgumentException("Set failed. Illegal index.");

            Node cur = dummyHead.next;
            for (int i = 0; i < index; i++)
                cur = cur.next;
            cur.e = e;
        }

    // 查找鏈表中是否有元素e
    public boolean contains(E e){
            Node cur = dummyHead.next;
            while (cur != null){
                    if (cur.e.equals(e))
                        return true;
                    cur = cur.next;
                }
            return false;
        }

    // 從鏈表中刪除第一個元素, 返回刪除的元素
    public E removeFirst(){
            return remove(0);
        }

    // 從鏈表中刪除最後一個元素, 返回刪除的元素
    public E removeLast(){
            return remove(size-1);
        }

    // 刪除鏈表的任意位置元素
    public E removeAnywhere(int index){
            return remove(index);
        }

    // 從鏈表中刪除index(0-based)位置的元素, 返回刪除的元素
    private E remove(int index) {
            if(index < 0 || index >= size)
                throw new IllegalArgumentException("Remove failed. Index is illegal.");
            Node prev =  dummyHead;
            for (int i = 0; i < index; i++)
                prev = prev.next;

            Node retNode = prev.next;
            prev.next = retNode.next;
            retNode.next = null;
            size--;

            return retNode.e;
        }

    // 從鏈表中刪除元素e
    public void  removeElement(E e){
            Node prev = dummyHead;
            while (prev.next != null){
                    if (prev.next.e.equals(e))
                        break;
                    prev = prev.next;
                }

            if (prev.next != null){
                    Node delNode = prev.next;
                    prev.next = delNode.next;
                    delNode.next = null;
                    size--;
                }
        }

    @Override
    public String toString() {
            StringBuffer res = new StringBuffer();
            for (Node cur = dummyHead.next;cur != null ;cur = cur.next)
                res.append(cur + "->");
            res.append("NULL");
            return res.toString();
        }
}
