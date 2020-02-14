public class PQNode<P,T> {
	public T data;
   public P priority;
	public PQNode<P,T> next;

	public PQNode () {
		data = null;
      priority = null ;
		next = null;
	}

	public PQNode (P pr , T val) {
		data = val;
      priority = pr; 

		next = null;
	}
   
	}//end class
