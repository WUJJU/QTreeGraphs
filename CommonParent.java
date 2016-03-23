public class CommonParent{

    Tree deepT;
	public Tree find(Tree t1,Tree t2){
		if(t1.parent==null||t2.parent==null) throw new IllegalArgumentException("one is root");
		int d1=depth(t1);
		int d2=depth(t2);

		Tree higherT= d1>=d2?t2.parent:t1.parent;
	    deepT=d1>=d2?t1:t2;

		while(check(higherT)){
			higherT=higherT.parent;
		}
        
        return higherT;



	}
	public Boolean check(Tree tree){
         while(deepT!=null){
         	if(deepT==tree) return false;
         	deepT=deepT.parent;
         }
         return true;

	}
	public int depth(Tree tree){
		int d=0;
		while(tree!=null){
         tree=tree.parent;
         d++;
		}
		return d;

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
        CommonParent cp=new CommonParent();
        Tree commonp=cp.find(t4,t5);
        System.out.println(commonp.value);


	}
}