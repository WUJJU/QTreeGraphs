import java.util.*;

public class FindRoute{



	/**
   *  0:1
   *  1:2
   *  3:0
   *  4:2
 	**/
  ArrayList<Node> adjlist=new ArrayList<Node>();
  public FindRoute(){
  	  	Node n0=new Node(0);
   	n0.list.add(1);
   	Node n1=new Node(1);
   	n1.list.add(2);
   	Node n2=new Node(2);
   	Node n3=new Node(3);
   	n3.list.add(0);
   	Node n4=new Node(4);
   	n4.list.add(2);
   	   adjlist.add(n0);
   adjlist.add(n1);
   adjlist.add(n2);
   adjlist.add(n3);
   adjlist.add(n4);
  }
 
  public class Node{
  	 int value;
  	 Boolean vist;
  	 LinkedList<Integer> list=new LinkedList<Integer>();

  	 public Node(int v){
  	 	this.value=v;
  	 	vist=false;
  	 }

  }
  public void DFS(int s){
     Node n=adjlist.get(s);
     if (n.list.size()==0) return;
     for(int i=0;i<n.list.size();i++){
        
     	n.vist=true;

     	DFS(n.list.get(i));

     }
      
  }
  public Boolean check(int d){
  	 if(adjlist.get(d).vist==true){
    	return true;
    }else return false;
  }
  public Boolean BFS(int s,int d){
  	Node n=adjlist.get(s);
    Queue<Integer> queue=new LinkedList<Integer>();
    for(int i=0;i<n.list.size();i++){
    	queue.add(n.list.get(i));
    }

    while(queue.peek()!=null){
    	Node m=adjlist.get(queue.peek());
    	 for(int i=0;i<m.list.size();i++){
    	queue.add(m.list.get(i));
        }
        m.vist=true;

      queue.remove();
         if(adjlist.get(d).vist==true){
    	return true;
    }

    }
   return false;

  }


   public static void main(String[] args) {

   	   FindRoute f=new FindRoute();


   Boolean flag=f.BFS(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
 System.out.println(
 	"flag: "+flag);
   
   f.DFS(Integer.parseInt(args[0]));
   Boolean flag2=f.check(Integer.parseInt(args[1]));
    System.out.println(
 	"flag2: "+flag2);
 	}

}