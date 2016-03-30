import java.util.Random;

public class TreeNode{
    private int data;
    private int size;
    public TreeNode left;
    public TreeNode right;

    public int size(){
    	return size;
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
    	int random=r.nextInt(size);
    	int leftsize= left==null?0:left.size;
    	if(r<leftsize){
    	   return left.randomN();
    	}else if(r==leftsize){
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

        if(i==data) return this;
    	else if(i<data){
    		if(left==null) return null;
    		else left.find(i);
    	}else{
    		if(right==null) return null;
    		else right.find(i);
    	}
    }
    public void delete(int i){
        TreeNode node=find(i);
       if(node==null) return;
       if(node.right==null) {
        node=node.left;
        node.size--;
        return;
       }
       if(node.left==null) {
        node=node.right;
        node.size--;
        return;
    }
       TreeNode n1=node;
       node=min(n1.right);
       node.right=deleteMin(n1.right);
       node.left=n1.left;

       node.size--;

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
}