import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
public class BuildOrder2{

  

	
    public ArrayList<String> order(ArrayList<Graph> list){
    	ArrayList<String> output=new ArrayList<String>();
        //Queue<Graph> queue=new LinkedList<Graph>();
        while(output.size()!=list.size()){
            Boolean flag=false;
    		for(int j=0;j<list.size();j++){
    		    Graph g=list.get(j);
    			if(g.next.size()==0&&g.vist==false) {
                    flag=true;
    				g.vist=true;
    				//g.added=true;
                    output.add(g.value);
                    g.clear(g);
    				
    			}


    		}
            if(!flag) throw new IllegalArgumentException("cirle there!!!");
        }
    	      return output;

    }

	public static void main(String[] args) {
	    
	    ArrayList<Graph> list=new ArrayList<Graph>();
	    Graph a=new Graph("a");
        Graph b=new Graph("b");
        Graph c=new Graph("c");
        Graph d=new Graph("d");
        Graph e=new Graph("e");
        Graph f=new Graph("f");
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        list.add(f);

        a.nextG(d,a);
        a.nextG(b,f);
        a.nextG(a,b);
        a.nextG(b,a);
        a.nextG(d,b);
        a.nextG(a,f);
        a.nextG(c,d);
        BuildOrder2 bo=new BuildOrder2();
        ArrayList<String> st=bo.order(list);
        for(int i=0;i<st.size();i++){
        	System.out.println(st.get(i));
        }
	      


            // Scanner sc=new Scanner(System.in);
            // System.out.println("");
            // int i=0;
            // System.out.println("input 1 to add dependencies");
            // System.out.println("input 2 to build order");
            // System.out.println("input 3 to exit");
            // do{

            // 	i=sc.nextInt();
            // 	if(i==1){
            //    System.out.println("please input dependency");
            //    String d=sc.next();
            //    System.out.println("please input parent");
            //    String p=sc.next();
            //    Graph dg=new Graph(d);
            //    Graph pg=new Graph(p);
            //    dg.nextG(dg,pg);
          
            // 	}
            // 	else if(i==2){


            // 	}

            // }while(i==3)


	}
}