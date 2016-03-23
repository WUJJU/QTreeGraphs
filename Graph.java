import java.util.ArrayList;
public class Graph{



	
	public String value;
	public Boolean vist;
	public Boolean added;
	public ArrayList<Graph> pre=new ArrayList<Graph>();
	public ArrayList<Graph> next=new ArrayList<Graph>();

	public Graph(String v){
		added=false;
        vist=false;
		this.value=v;
	}
	public void nextG(Graph g1,Graph g2){

		g1.next.add(g2);
        g2.pre.add(g1);

	}
	public void clear(Graph g){
		if(g.pre.size()==0) return;
		for(int i=0;i<g.pre.size();i++){
		  g.pre.get(i).next.remove(g);
		}
	}
}