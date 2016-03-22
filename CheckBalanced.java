import java.util.*;


public class CheckBalanced{


	public LinkedList<Integer> heights=new LinkedList<Integer>();
	
	int max=0;
	int min=0;

	

	public Boolean check(Tree tree){
		check(tree,0);
		return true;
	}

	public void check(Tree tree, int h){
	
		while(tree.hasChild()){
         h++;
         check(tree.nextChild(tree),h);
         

		}
		if(max!=min){	  if(max-min>1) throw new IllegalArgumentException("not balanced");	}
        if(min==0&&max==0){
        	min=h;
        }
       if(h>max) max=h; 
       else if(h<min) min=h;

      
	}

	public static void main(String[] args) {
		Tree t1=new Tree(1);
	    Tree t2=new Tree(1);
		Tree t3=new Tree(1);
		Tree t4=new Tree(1);
		Tree t5=new Tree(1);
		Tree t6=new Tree(1);
		Tree t7=new Tree(1);
		Tree t8=new Tree(1);
		Tree t9=new Tree(1);
		t1.left=t2;
		t1.right=t3;
		//t2.left=t4;
		//t3.left=t5;
		//t5.left=t6;
		CheckBalanced CB=new CheckBalanced();
        System.out.println(CB.check(t1));
			
	}


}