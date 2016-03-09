import java.util.*;

public class ListDepth{



    ArrayList<LinkedList<Tree>> q;
	public ArrayList<LinkedList<Tree>> deep(Tree t){


       q=new ArrayList<LinkedList<Tree>>();
      
       LinkedList <Tree> list=new LinkedList<Tree>();
        if(t!=null) list.add(t);
     while(list.size()!=0){
     	q.add(list);
        LinkedList<Tree> parents=list;
        list=new LinkedList<Tree>();

        for(Tree parent:parents){

           if(parent.right!=null) list.add(parent.right);
      
          if(parent.left!=null) list.add(parent.left);
        }

     
     }
         return q;
	}
	public static void main(String[] args) {
		     Tree t=new Tree(5);
    t.left=new Tree(3);
    t.right=new Tree(7);
    t.left.left=new Tree(2);
    t.left.right=new Tree(4);
   
    t.right.left=new Tree(6);
    t.right.right=new Tree(8);
  
     ListDepth ld=new ListDepth();
    ArrayList<LinkedList<Tree>> result= ld.deep(t);
    for(int i=0;i<result.size();i++){
    	System.out.println(i+" :");
    	 for( int j=0;j<result.get(i).size();j++){

    	 	System.out.println(result.get(i).get(j));
    	 }
    }

	}
}