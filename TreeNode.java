import java.util.Random;
import java.util.ArrayList;
public class TreeNode{
    private int data;
    private int size;
    public TreeNode left;
    public TreeNode right;

    public int size(TreeNode node){
        if(node==null) return 0;
    	else return node.size;
    }
    public int data(){
    	return data;
    }

    public TreeNode(int i){
    	data=i;
    	size=1;
    }
    public TreeNode randomN(){
    	Random r=new Random();
    	int random=r.nextInt(this.size);
    	int leftsize= left==null?0:left.size;
    	if(random<leftsize){
    	   return left.randomN();
    	}else if(random==leftsize){
    		return this;
    	}else{
            return right.randomN();
    	}

    }
    public void insert(int i){
    	if(i<data){
    		if(left==null) left=new TreeNode(i);
    		else left.insert(i);
    	}else{
    		if(right==null) right=new TreeNode(i);
    		else right.insert(i);
    	}
        size++;
    }
    public TreeNode find(int i){

        if(i==data) {return this;}
    	else if(i<data){
    		if(left==null) return null;
    		else return left.find(i);
    	}else{
    		if(right==null) return null;
    		else return right.find(i);
    	}
      
    }
    public TreeNode delete(int i,TreeNode node){
        if(node==null) return null;
       if(i<node.data) node.left=delete(i,node.left);
       else if(i>node.data) node.right=delete(i,node.right);
       else{
        if(node.right==null) {
         return node=node.left; 
        } 
        if(node.left==null) return node=node.right;

            TreeNode n1=node;
           node=min(n1.right);
            node.right=deleteMin(n1.right);
            node.left=n1.left;
       }
       node.size=size(node.left)+size(node.right)+1;
         return node;
       


    }
    public TreeNode min(TreeNode node){
        if(node==null) return null;
        while(node.left!=null){
            node=node.left;
        }
         return node;
    }
    public TreeNode deleteMin(TreeNode node){

        //if(node==null) return null;
        if(node.left==null) return node.right;
        node.left=deleteMin(node.left);
        size=node.left.size+node.right.size+1;
        return node;
    }
    public void inorder(TreeNode node,ArrayList<Integer> array){
        if(node==null) return;
        inorder(node.left,array);
        array.add(node.data);
        inorder(node.right,array);

    }
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(20);
        t1.insert(10);
        t1.insert(30);
        t1.insert(5);
        t1.insert(15);
        t1.insert(3);
        t1.insert(7);
        t1.insert(17);
        //t1.delete(17,t1);
        //t1.delete(10,t1);  
        TreeNode tttt=t1.randomN();
        System.out.println(tttt.data); 
        ArrayList<Integer> array=new ArrayList<Integer>();
        t1.inorder(t1,array);
        System.out.println(array.toString());
    }
}