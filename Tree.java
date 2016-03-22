import java.util.*;

public class Tree{

	public Boolean vist;
  
    public int value;
    public Tree left;
    public Tree right;
	public Tree(int i){
     this.value=i;
     this.vist=false;

	}
	public Boolean hasChild(){
     if(left!=null||right!=null) return true;
     else return false;
	}
	public Tree nextChild(Tree tree){
		if(!tree.hasChild()) return null;
		if(tree.left!=null) return tree.left;
		else return tree.right;
	}
}