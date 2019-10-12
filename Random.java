package list;

/**
 * @ClassName Random
 * @Description 拷贝链表。
 * @Auther danni
 * @Date 2019/7/27 12:17]
 * @Version 1.0
 **/

public class Random {
    public Rnode addBack(Rnode head,int data){
        Rnode node=new Rnode(data);
        if(head==null){
            return node;
        }
        Rnode curr=new Rnode();
        curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=node;
        return head;
    }
    public void printRandom(Rnode head){
        if(head==null) {
            System.err.println("单链表为空");
            return ;
        }
        Rnode curr=new Rnode();
        curr=head;
        while(curr!=null){
            System.out.print(curr+"-> ");
            curr=curr.next;
        }
        System.out.println("null");
    }
    public void  randomList(Rnode n,Rnode m){
        n.random=m;
    }
    public Rnode copy(Rnode head){
        Rnode temp=head;
        while(temp!=null){
            Rnode m=new Rnode();
            m.data=temp.data;
            m.next=temp.next;
            temp.next=m;
            temp=m.next;
        }
        temp=head;
        while(temp!=null){
            Rnode p2=temp.next;
            if(temp.random!=null){
            p2.random=temp.random.next;
            }else{
                p2.random=null;
            }
            temp=p2.next;
        }
        temp=head;
        if(head==null){
            return null;
        }
        Rnode newhead=head.next;
        while(temp!=null){
            Rnode p2=temp.next;
            temp.next=p2.next;
            if(p2.next!=null){
                p2.next=p2.next.next;
            }
            temp=temp.next;
        }
        return newhead;
    }
    public static void main(String[] args) {
        Random r=new Random();
        Rnode n=new Rnode();
        n =null;
        n=r.addBack(n,1);
        n=r.addBack(n,2);
        n=r.addBack(n,3);
        n=r.addBack(n,4);
        n=r.addBack(n,5);
        n=r.addBack(n,4);
        r.randomList(n,n.next.next);
        r.randomList(n.next,n);
        r.randomList(n.next.next,n.next.next);
        r.randomList(n.next.next.next,null);
        n=r.copy(n);
        r.printRandom(n);
        r.printRandom(n.random);
        r.printRandom(n.next.random);

    }
}
class Rnode{
    int data;
    Rnode next=null;
    Rnode random=null;

    public Rnode() {
    }

    public Rnode(int data) {
        this.data = data;
    }

    public String toString(){
        return String.format("Node(%d)",data);
    }
}
