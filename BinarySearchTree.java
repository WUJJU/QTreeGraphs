import java.util.*;

public class BinarySearchTree{

	
   

   public Tree maketree(int []array){
        return maketree(array,0,array.length-1);
   }

  public Tree maketree(int []array,int start,int end){
     if(start>end) return null;
     int mid=(start+end)/2;
      
        Tree btree=new Tree(array[mid]); 
        btree.left= maketree(array,start,mid-1);
        btree.right= maketree(array,mid+1,end);

      return btree;
 
  }
  
   public static void main(String[] args) {
   	  BinarySearchTree b=new BinarySearchTree();
   	  int [] array={1,2,3,4,5,6,7,8,9};
   	  b.maketree(array);
  
   }

}