import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
public class BuildOrder{

  

	
    public ArrayList<String> order(ArrayList<Graph> list){
    	ArrayList<String> output=new ArrayList<String>();
        Queue<Graph> queue=new LinkedList<Graph>();
    		for(int j=0;j<list.size();j++){
    		Graph g=list.get(j);
    			if(g.next.size()==0) {
    				g.vist=true;
    				g.added=true;
    				queue.add(g);
    				// if(g.pre.length!=0){
    				// 	//brith first search
    				// 	for(int i=0;i<g.pre.length;i++){
    				// 		queue.add(g.pre.get(i));
    				// 	}

    				// }
    			}


    		}
    	      while(queue.size()!=0){
                	Graph graph=queue.poll();
                	if(check(graph))    {
                		graph.vist=true;
                		output.add(graph.value);
                       }else{
                       	throw new IllegalArgumentException("error: can't build order");
                       }
                	if(graph.pre.size()!=0) {
                		for(int k=0;k<graph.pre.size();k++){
                            if(graph.pre.get(k).added==false){		
                            	queue.add(graph.pre.get(k));
								graph.pre.get(k).added=true;
                            }
                	

                		}
                	}
                     
                }

            return output;

    }
    public Boolean check(Graph graph){
          if(graph.next.size()==0) return true;
          for(int h=0;h<graph.next.size();h++){
          	     if(graph.next.get(h).vist==false) return false;
          }
      return true;

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
        a.nextG(d,b);
        a.nextG(a,f);
        a.nextG(c,d);
        BuildOrder bo=new BuildOrder();
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