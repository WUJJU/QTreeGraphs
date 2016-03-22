import java.util.*;

public class BST{

  //use in-order traversal

	public Integer v1=null;

	//public int v2;
    public void v(Tree tree){
    	validate(tree);
    	System.out.println("is BST!!");
    }
	public void validate(Tree tree){
     
     if(tree!=null){
        validate(tree.left);
        Boolean tof=vist(tree);
        if(tof==false) throw new IllegalArgumentException("not Binary Search Tree");
        validate(tree.right);
     }
        

	}
	public Boolean vist(Tree tree){

		tree.vist=true;
		if(v1==null) v1=tree.value;
		if(v1>tree.value)  return false;
		else return true;
	}
 public static void main(String[] args) {
 		Tree t1=new Tree(8);
	    Tree t2=new Tree(4);
		Tree t3=new Tree(10);
		Tree t4=new Tree(2);
		Tree t5=new Tree(6);
		Tree t6=new Tree(20);
		Tree t7=new Tree(7);
		Tree t8=new Tree(8);
		Tree t9=new Tree(1);
        t1.parent(t1,t2,"l");
		//t1.left=t2;
		t1.right=t3;
		t2.left=t4;
		t2.right=t5;
		t3.right=t6;
		//t3.right=t9;
		BST bst =new BST();

        bst.v(t1);
 }

}