public class AllArrays{


	


     public ArrayList<LinkedList<Integer>> allSequences(Tree node){
     	ArrayList<LinkedList<Integer>> result=new ArrayList<LinkedList>>();
     	if(node==null){
     		result.add(new LinkedList<Integer>());
     		return result;
     	}

     	LinkedList<Integer>prefix=new LinkedList<Integer>();
     	prefix.add(node.data);

     	ArrayList<LinkedList<Integer>> leftSeq=allSequences(node.left);
     	ArrayList<LinkedList<Integer>> rightSeq=allSequences(node.right);

     	for(LinkedList<Integer> left: leftSeq){
     		for(LinkedList<Integer> right: rightSeq){
     			ArrayList<LinkedList<Integer>> weaved=
     			   new ArrayList<LinkedList<Integer>>();
     			   weaveLists(left,right,weaved,prefix);
     			   result.addAll(weaved);
     		}
     	}
     	return result;
     }


    public void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second, ArrayList<LinkedList<Integer>>results,
    	                LinkedList<Integer>prefix){
    	if(first.size()==0||second.size()==0){
    		LinkedList<Integer> result=(LinkedList<Integer>)prefix.clone();
    		result.addAll(first);
    		reuslt.addAll(second);
    		results.add(result);
    		return;
    	}
    	int headFirst=first.removeFirst();
    	prefix.addLast(headFirst);
    	weaveLists(first,second,results,prefix);
    	prefix.removeLast();
    	first.addFirst(headFirst);

    	int headSecond=second.removeFirst();
    	prefix.addLast(headSecond);
    	weaveLists(first,second,results,prefix);
    	prefix.removeLast;
    	second.addFirst(headSecond);
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

     AllArrays a=new AllArrays();
     ArrayList<ArrayList<Tree>> list=a.all(t1);

	}
}