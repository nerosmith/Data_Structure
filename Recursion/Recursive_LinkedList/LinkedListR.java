package com.nerosmith.java.Recursion.Recursive_LinkedList;

import javafx.util.Pair;

// 遞歸實現的LinkedList
public class LinkedListR<E> {
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

    private Node head;
    private int size;

    public LinkedListR(){
            head = null;
            size = 0;
        }

    public  int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addFirst(E e){
            add(0,e);
        }

    public void addLast(E e){
        add(size,e);
    }

    public void add(int index,E e){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");
        head = add(head,index,e);
        size++;
    }

    private Node add(Node node,int index ,E e){
            if (index == 0)
                return new Node(e,node);
            node.next = add(node.next,index-1,e);
            return node;
        }

    public E getFirst(){
        return get(head,0);
    }

    public E getLast(){
            return get(head,size-1);
        }

    public E get(int index){
            if(index < 0 || index >= size)
                throw new IllegalArgumentException("Get failed. Illegal index.");
            return get(head,index);
        }

    private E get(Node node,int index){
            if (index == 0)
                return node.e;
            return get(node.next,index-1);
        }

    public void set(int index,E e){
            if(index < 0 || index >= size)
                throw new IllegalArgumentException("Update failed. Illegal index.");
            set(head,index,e);
        }

    // 修改以node為頭節點的鏈表中，第index(0-based)個位置的元素為 e，遞歸算法
    private void set(Node node,int index,E e){
            if (index == 0){
                    node.e = e;
                    return;
                }
            set(node.next,index-1,e);
        }

    public boolean contains(E e){
            return contains(head,e);
        }

    // 在以node為頭節點的鏈表中，查找是否存在元素e，遞歸算法
    private boolean  contains(Node node,E e){
            if (node == null)
                return false;
            if (node.e.equals(e))
                return true;
            return contains(node.next,e);
        }

    public E removeFirst(){
            return remove(0);
        }

    public E removeLast(){
            return remove(size-1);
        }

    public E remove(int index){
            if(index < 0 || index >= size)
                throw new IllegalArgumentException("Remove failed. Index is illegal.");
            Pair<Node,E> res = remove(head,index);
            size--;
            head = res.getKey();
            return res.getValue();
        }

    // 從以node為頭節點的鏈表中，刪除第index位置的元素，遞歸算法
    // 返回值包含兩個元素，刪除後的鏈表頭結點和刪除的值
    private Pair<Node,E> remove(Node node,int index){
            if (index == 0)
                return new Pair<>(node.next,node.e);
            Pair<Node,E> res = remove(node.next,index-1);
            node.next = res.getKey();
            return new Pair<>(node,res.getValue());
        }

    public void removeElement(E e){
            head = removeElement(head,e);
        }

    // 從以node為頭節點的鍊錶中，刪除元素e，遞歸算法
    private Node removeElement(Node node,E e){
            if (node == null)
                return null;
            if (node.e.equals(e)){
                    size--;
                    return node.next;
                }
            node.next = removeElement(node.next,e);
            return node;

        }

    @Override
    public String toString() {
            StringBuilder res = new StringBuilder();

            Node cur = head;
            while(cur != null){
                res.append(cur + "->");
                cur = cur.next;
            }
            res.append("NULL");

            return res.toString();
        }

}
