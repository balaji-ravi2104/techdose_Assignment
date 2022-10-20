import java.util.Scanner;
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data=data;
    }
}

public class Main
{
    static int getWinner(int m,int n)
    {
        Node head=new Node(1);
        Node temp=head,curr=head,prev=head;
        // both prev and curr should point to head initially
        for(int i=2;i<=m;i++)
        {
            temp.next=new Node(i);
            temp=temp.next;
        }
        temp.next=head;
        while(curr.next!=curr)//when a single node is there
        {
            for(int i=1;i<n;i++)
            {
                prev=curr;
                curr=curr.next;
            }
            prev.next=curr.next;
            curr=prev.next;
        }
        return curr.data;
    }
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int m=sc.nextInt(),n=sc.nextInt();
	    System.out.println(getWinner(m,n));
	}
}
