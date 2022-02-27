class LL{
    // data-member.
    Node head;
    private int size;
   
   // constrictor
    LL(){
        size=0;
    }

    public class Node{
        String data;
        Node next;


        Node(String data){
            this.data=data;
            this.next=null;
            size++;
        }
    }

    // add element at the front of linked list.

    public statoc addFirst(String data){
        Node newNode=new Node(data);
        newNode.next=head;
        head=newNode;
    }

    // add at the last of linked list.
    public static void addLast(String data){

        Node newNode=new node(data);

        if(head==null){
            head=newNode;
            return;
        }

        Node lastNode=head;

        while(lastNode.next!=null){
            lastNode=lastNode-next;
        }

        lastNode=newNode;
    }
}