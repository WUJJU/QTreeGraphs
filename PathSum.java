
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
public class PathSum{

    ArrayList<LinkedList<TreeNode>> list=new ArrayList<LinkedList<TreeNode>>();
    ArrayList<TreeNode> array=new ArrayList<TreeNode>();
    Queue<TreeNode> queue=new LinkedList<TreeNode>();

    public ArrayList<TreeNode> bfs(TreeNode node){
        queue.add(node);
        while(queue.size()!=0){
                TreeNode n=queue.poll();
                array.add(n);
                if(n.left!=null) queue.add(n.left);
                if(n.right!=null) queue.add(n.right);
        }
        return array;
    }
    public ArrayList<LinkedList<TreeNode>> dfs(TreeNode node,int sum){
       
        
        bfs(node);
        for(int i=0;i<array.size();i++){
            LinkedList<TreeNode> path=new LinkedList<TreeNode>();
            path.add(array.get(i));
            dfs(array.get(i),path,sum);
        }
       
     return list;

    }
    public void dfs(TreeNode node,LinkedList<TreeNode> path,int sum){

        if(check(path,sum)) {
           LinkedList<TreeNode> pp=replicate(path);
                list.add(pp);
               
          // path=new LinkedList<TreeNode>();

        }
         ArrayList<TreeNode> children=node.children();
         if(children==null){
             path.removeLast();
             return;
         }
        for(int i=0;i<children.size();i++)  {
      
                path.add(children.get(i));
                dfs(children.get(i),path,sum);

       }
        
        path.removeLast();
    }
    public LinkedList<TreeNode> replicate(LinkedList<TreeNode> path){
        LinkedList<TreeNode> p=new LinkedList<TreeNode>();
        for(int i=0;i<path.size();i++){
            p.add(path.get(i));
        }
        return p;
    }
    public Boolean check(LinkedList<TreeNode> path, int sum){
      int v=0;
     for(int i=0;i<path.size();i++){
        v+=path.get(i).data();

     }
     if(v==sum) return true;
     else return false;
    }





        public static void main(String[] args) {
            PathSum pathsum=new PathSum();
                  TreeNode t1=new TreeNode(20);
        t1.insert(10);
        t1.insert(30);
        t1.insert(5);
        t1.insert(15);
        t1.insert(3);
        t1.insert(7);
        t1.insert(17);
        ArrayList<LinkedList<TreeNode>> arraylist=pathsum.dfs(t1,42);
       for(int i=0;i<arraylist.size();i++){
           for(int j=0;j<arraylist.get(i).size();j++){
               System.out.println(arraylist.get(i).get(j).data());
               
           }
           System.out.println("----------");
       }
        }
}