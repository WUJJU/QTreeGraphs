import java.util.*;

public class Tree{

	public Boolean vist;
    public Tree parent;
    public Tree [] parents;
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

	public void parent(Tree par, Tree child,String LorR){
         if(LorR=="l") {
         	par.left=child;
           child.parent=par;
         }
         if(LorR=="r") {

         	par.right=child;
         child.parent=par;
      }
	}
}