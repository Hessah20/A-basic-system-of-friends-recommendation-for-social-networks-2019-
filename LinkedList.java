public  class LinkedList<T> implements List<T>{
	private Node<T> head;
	private Node<T> current;
private int size;
	public LinkedList () {
   size=0;
		head = current = null;
	}//END Constractor

	public boolean empty () {
		return head == null;
	}//END EMPTY

	public boolean last () {
		return current.next == null;
	}//END LAST
   
public boolean full () {
		return false;
	}//END FULL
   
	public void findFirst () {
		current = head;
	}//END findfirst
   
   public void findNext () {
		current = current.next;
	}//End FINDNEXT

	public T retrieve () {
		return current.data;
	}//END retrieve
   
	public void update (T val) {
		current.data = val;
	}//END update
   
   
public void insert(T val) {
     
      Node<T> tmp ;
		if(empty()) {
			current = head = new Node<T> (val);
         size++;
		}
		else {
			tmp = current.next;
			current.next = new Node<T> (val);
			current = current.next;
         current.next= tmp;
         size++;

		}
	}
   public void remove() {
		if(current == head) {
			head = head.next;
         size--;}
		else {
      Node<T> tmp = head;
      while(tmp.next!=current)
      tmp=tmp.next;
      tmp.next = current.next;
      size--;
					}

		if(current.next == null)
			current = head;
		else
			current = current.next;
	}

public int size(){
   return size;}

	// Searches for e in the list. Current must not change.
	public boolean exists(T e){
   if(size==0)
   return false;
   Node<T> N = new Node<T>();
   N =head;
   for(int i = 0 ; i<size();i++){
   if (N.data==e){
     return true;}
   N=N.next;}
   return false;
 
   }
   }
