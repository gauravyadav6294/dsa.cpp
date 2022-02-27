import java.util.*;

Class Implemantion{
    public static void main(String [] args){
        // how to declare a linkedlist.
        LinkedList<String> list=new LinkedList<String>();
        list.add("is");
        list.add("a");
        // add element in last of linkedlist.
        list.addLast("list");
        list.addFirst("this");
        list.add(3,"linked");
        System.out.println(list);

        System.out.println(list.get(0));
        System.out.println(list.size());
        list.remove(3);
        list.removeFirst();
        list.removeLast();

        System.out.println(list);
    }
}