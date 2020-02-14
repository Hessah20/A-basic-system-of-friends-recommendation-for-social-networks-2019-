public class BSTMap<K extends Comparable<K>, T> implements Map<K, T> {
	public BSTNode<K, T> root; // Do not change this
   private int length;
   
   //*******Constractor*********
	public BSTMap() {
      length=0;
   	root=null;
	}
  //*******Constractor*********




   //*******Size()*********
   // Return the size of the map.
	public int size(){
   return length;
   }
   //*******Size()*********
   
   
   //*******full()*********
   // Return true if the map is full.
	public boolean full(){
   return false;}
   //*******full()*********

   
   
   
   //*******clear()*********
   // Remove all elements from the map.
	public void clear(){
   length = 0 ;
   root = null;}
   //*******clear()*********

   
   
  //*******update()*********

   private boolean exists (K k){
   if(length==0)
   return false;
   BSTNode<K,T> p = root, q= root;
				
				
		while(p != null) {
			q = p;
			if(k.compareTo(p.key)==0) {
				
				return true;
			}
			else if(k.compareTo(p.key)==-1 )
				p = p.left;
			else
				p = p.right;
		}
		
				return false;
   }
   
   
   private BSTNode<K, T> retNode (K k){
   
   BSTNode<K,T> p = root;
   BSTNode<K,T> q = root;
 		         	
				while(p != null) {

            q=p;
			if(k.compareTo(p.key)==0) {

				return q;
			}
			else if(k.compareTo(p.key)==-1)

				p = p.left;
			else
				p = p.right;
		}
		
				return q;}

   	// Update the data of the key k if it exists and return true. If k does not exist, the method returns false.
	public boolean update(K k, T e){
   if(size()==0)
   return false;
   if(!exists(k))
   return false;
   if(length==0||root==null)
   return false;

   BSTNode<K, T> up = retNode (k);
   up.data= e;
   return true;
   }
   //*******update()*********



	// Search for element with key k and returns a pair containing true and its data if it exists. If k does not exist, the method returns false and null.
	public Pair<Boolean, T> retrieve(K k){
   Pair<Boolean, T> P =new  Pair<Boolean, T> (false,null);
   if(size()==0)
   return P;
   if(!exists(k))
   return P;

   Pair<Boolean, T> P1 = new  Pair<Boolean, T> (true,  (retNode (k)).data);

   return P1;
   }



	// Insert a new element if does not exist and return true. If k already exists, return false.
	public boolean insert(K k, T e){
   if(full()){

   return false ;  }
   if(exists(k))
   return false;
   BSTNode<K, T> nbst = new BSTNode<K,T>(k,e);
   if(size()==0){
   
   root=nbst;
   length++;
   

   return true;}
   else {
if(length==0||root==null)
   return false;

      BSTNode<K, T> tmp = retNode (k);

   if(k.compareTo(tmp.key)==-1)
				 tmp.left=nbst;
			else
				tmp.right=nbst;
            length++;
   return true;
   
   }
   }



	// Remove the element with key k if it exists and return true. If the element does not exist return false.
	public boolean remove(K k){
   if(length==0||root==null)
   return false;

		Boolean removed = new Boolean(false);
		BSTNode<K,T> p;
      if(!exists (k))
      return false;
		p = remove_aux(k, root, removed);
		root = p;
      
    
      length--;
		return true;
	}   
    private BSTNode<K,T> remove_aux(K key, BSTNode<K,T> p, boolean  flag) {
		BSTNode<K,T> q, child = null;
		if(p == null)
			return null;
		if(key.compareTo(p.key)==-1)
			p.left = remove_aux(key, p.left, flag); //go left
		else if(key.compareTo(p.key)==1)
			p.right = remove_aux(key, p.right, flag); //go right
		else {
			flag= true;
			if (p.left != null && p.right != null){ //two children
				q = find_min(p.right);
				p.key = q.key;
				p.data = q.data;
				p.right = remove_aux(q.key, p.right, flag);
			}
         else {
				if (p.right == null) //one child
					child = p.left;
				else if (p.left == null) //one child
					child = p.right;
				return child;
			}
		}
		return p;
	}
  
   private BSTNode<K,T> find_min(BSTNode<K,T> p){
		if(p == null)
			return null;
		
		while(p.left != null){
			p = p.left;
		}
		
		return p;
	} 
	// Return the list of keys in increasing order.
private void preorder (BSTNode<K,T> node ,  List<K> L )
 
    { 
        if(node==null)
           return;  
        preorder(node.left,L); 
          L.insert(node.key); 

        preorder(node.right,L); 
    } 

	public List<K> getKeys(){
   List<K> L = new LinkedList<K>();
if(size()==0){

return L;}
       preorder(root,L);
         
   return L;}

}