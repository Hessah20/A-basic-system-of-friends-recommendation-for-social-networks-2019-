public class MGraph<K extends Comparable<K>> implements Graph<K> {
	public Map<K, List<K>> adj; // Do not change this
	public MGraph() {
   adj = new BSTMap<K, List<K>>();
    }
		
	
	// Add a node to the graph if it does not exist and return true. If the node already exists, return false.
	public boolean addNode(K i){
   try{
    List<K> L = new LinkedList<K>();
   return adj.insert(i,L);}catch(Exception e){return false;}

        }

	// Check if i is a node
	public boolean isNode(K i){
   try{
    if(adj.size()==0||adj==null)
   return false;

   return adj.retrieve(i).first;}catch(Exception e){return false;}

   }

	// Add an edge to the graph if it does not exist and return true. If i or j do not exist or the edge (i, j) already exists, return false.
	public boolean addEdge(K i, K j){
   try{
     if(adj.size()==0||adj==null)
   return false;

   if(!adj.retrieve(i).first && !adj.retrieve(j).first)
   return false;
   if(adj.retrieve(i).second.exists(j)&&adj.retrieve(j).second.exists(i) )
   return false;
    if(adj.retrieve(i).second==null||adj.retrieve(j).second==null )
   return false;

   if(!adj.retrieve(j).second.exists(i))
   adj.retrieve(j).second.insert(i);
   if(! adj.retrieve(i).second.exists(j))
   adj.retrieve(i).second.insert(j);

   return true;}catch(Exception e){return false;}

   
   }

	// Check if (i, j) is an edge.
	public boolean isEdge(K i, K j){
   try{
     if(adj.size()==0||adj==null)
   return false;

   if(!adj.retrieve(i).first && !adj.retrieve(j).first)
   return false;
   if(adj.retrieve(i).second.exists(j)&& adj.retrieve(j).second.exists(i))
   return true;
   return false;}catch(Exception e){return false;}
   }

	// Return the set of neighbors of node i. If i does not exist, the method returns null.
	public List<K> neighb(K i){
try{
     if(adj.size()==0||adj==null)
   return null;

   if(adj.retrieve(i).first){
   List<K>L = adj.retrieve(i).second;
   return L;}
   return null;}catch(Exception e){return null;}

    }

	// Return the degree (the number of neighbors) of node i. If i does not exist, the method returns -1.
	public int deg(K i){
   try{
     if(adj.size()==0||adj==null)
   return -1;

   if(adj.retrieve(i).first)
   return  adj.retrieve(i).second.size();
   return -1;}catch(Exception e){return -1;}

   }

	// Return a list containing the nodes in increasing order.
	public List<K> getNodes(){
    List<K> L = adj.getKeys();
    return L;
   }

}
