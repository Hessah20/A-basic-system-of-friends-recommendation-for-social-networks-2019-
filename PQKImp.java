public class PQKImp<P extends Comparable<P>, T> implements PQK<P, T> {
private int size;
private PQNode<P,T> head;
private int maxsize;

	public PQKImp(int k) {
		head = null;
      maxsize = k;
		size = 0;

	}
   // Return the length of the queue
	public int length(){
   return size;
}

	// Enqueue a new element. The queue keeps the k elements with the highest priority. In case of a tie apply FIFO.
	public void enqueue(P pty, T e){
   PQNode<P,T> tmp = new PQNode<P,T>(pty,e);
		if((size == 0) || (pty.compareTo(head.priority) ==1)) {
			tmp.next = head;
			head = tmp;
		}
		else {
			PQNode<P,T> p = head;
			PQNode<P,T> q = null;
			while((p != null) && (pty.compareTo(p.priority)== 0||pty.compareTo(p.priority)== -1)) {
				q = p;
				p = p.next;
			}
			tmp.next = p;
			q.next = tmp;
		}
		size++;
      if(length() > maxsize)
      delete(maxsize);
      }
      
   
private void  delete(int k){
/*while(count<k){

q=p;
p=p.next;
count++;}
while (q!=null){
q=q.next;
}
q=p;*/
size =k;
}


  // Serve the element with the highest priority. In case of a tie apply FIFO.
	public Pair<P, T> serve(){
  
   PQNode<P,T> node = head;
		Pair<P,T> pqe=new Pair<P,T>(node.priority,node.data);
      head = head.next;
		size--;
		return pqe;

   }
}
