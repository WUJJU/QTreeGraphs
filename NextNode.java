import java.util.*;


public class NextNode{


   public Tree next(Tree tree){
   	if(tree.parent==null&&tree.right==null){

   		return null;
   	}else{
   		if(tree.right==null) {

            while(tree.parent.value>tree.parent.parent.value){

            	tree=tree.parent;
            	if(tree.parent.parent==null) return null;
            }


   			return tree.parent;

   		}
   		else return bst(tree.right);
   	}


   }

   public Tree bst(Tree tree){
   	 if(tree.left==null) return tree;
   	 else{
     bst(tree.left);
     tree.vist=true;
     bst(tree.right);
     

   	 }
     throw new IllegalArgumentException("unexpected error");

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
        t1.parent(t1,t3,"r");
        t1.parent(t2,t4,"l");
        t1.parent(t2,t5,"r");
        t1.parent(t3,t6,"r");
        NextNode nn=new NextNode();
        Tree t=nn.next(t6);
        System.out.println(t);
		//t1.left=t2;
		//t1.right=t3;
		//t2.left=t4;
		//t2.right=t5;
		//t3.right=t6;
	}
}