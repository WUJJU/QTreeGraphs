import java.util.ArrayList;
public class Subtree{


	//pre-order
	//in-order can sort Binary Search Tree

	public Boolean match(String list, String  sublist){


		 if(list.indexOf(sublist)!=-1) return true;
		 else return false;
	}
   
    public ArrayList<Object> find(Tree t,ArrayList<Object> list){
     
    	sub(t,list);
    	return list;
    }

	public void sub(Tree t,ArrayList<Object> list){
     
       if(t==null) {
       	list.add("X");
       	return;
       }
       else    list.add(t.value);
 
		vist(t);
		sub(t.left,list);
		sub(t.right,list);


	}
	public void vist(Tree t){
		t.vist=true;
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
        Subtree st=new Subtree();
        ArrayList<Object> list=new ArrayList<Object>();
        ArrayList<Object> sublist=new ArrayList<Object>();

        st.find(t1,list);
        st.find(t2,sublist);

      	System.out.println(list.toString());


      	System.out.println(sublist.toString());
      	StringBuilder s1=new StringBuilder();
      	StringBuilder s2=new StringBuilder();
      	for(Object s:list){
            s1.append(s);
      	}
      	for(Object s:sublist){
      		s2.append(s);
      	}

      	Boolean flag=st.match(s1.toString(),s2.toString());
      	System.out.println(flag);
    
	}
}