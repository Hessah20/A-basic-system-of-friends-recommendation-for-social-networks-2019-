import java.io.File;
import java.util.Scanner;

public class Recommender {

	// Return the top k recommended friends for user i using the popular nodes method. If i does not exist, return null. In case of a tie, users with the lowest id are selected.
	public static <K extends Comparable<K>> PQK<Double, K> recommendPop(Graph<K> g, K i, int k) {
      PQK<Double, K> P = new PQKImp <Double,K>(k);
try{
   if(g==null)
   return null;
  if(!g.isNode(i))
  return null;
  // PQK<Double, K> P = new PQKImp <Double,K>(k);
   List<K> L = g.getNodes();
   L.findFirst (); 
  for (int u = 0 ;u<L.size() ;u++){
  if(g.isEdge(i,L.retrieve ())||L.retrieve ()==i||g.neighb(i).exists(L.retrieve ())){
    L.findNext();

  continue; }
  P. enqueue((double)g.deg(L.retrieve ()),L.retrieve ());
  L.findNext();
  }
		return P;}catch(Exception e){return P;}

	}

	// Return the top k recommended friends for user i using common neighbors method. If i does not exist, return null. In case of a tie, users with the lowest id are selected.
	public static <K extends Comparable<K>> PQK<Double, K> recommendCN(Graph<K> g, K i, int k) {
   PQK<Double, K> P = new PQKImp <Double,K>(k);
try{
if (g==null)
return null;
   if(!g.isNode(i))
  return null;
  // PQK<Double, K> P = new PQKImp <Double,K>(k);
   List<K> L = g.getNodes();
   List<K> N = g.neighb(i);
   L.findFirst (); 
   for (int u = 0 ;u<L.size() ;u++){
     double c = 0;

   if(L.retrieve ()==i||g.neighb(i).exists(L.retrieve ())){
   if(L.last()){
   break;}
    L.findNext();

  continue; }
  List<K> N2 = g.neighb(L.retrieve ());
  if(N.size()==0)
  break;
  N.findFirst();
   if(N.size()==0)
  break;

  N2.findFirst();
    for(int n2=0 ; n2<N2.size();n2++){
  if(N.exists(N2.retrieve ())){
  c++;}
  if(N2.last())
  break;
  N2.findNext();
  }
     

  P. enqueue(c,L.retrieve ());
     L.findNext();
  }
		return P;

}catch(Exception e){return P;}

   	}

	// Read graph from file. The file is a text file where each line contains an edge. The end and start of the edge are separated by space(s) or tabs.
	public static Graph<Integer> read(String fileName) {

		try {
			Graph<Integer> g = new MGraph<Integer>();
			Scanner scanner = new Scanner(new File(fileName));
			while (scanner.hasNextInt()) {
				int i = scanner.nextInt();
				g.addNode(i);
				int j = scanner.nextInt();
				g.addNode(j);
				g.addEdge(i, j);
			}
			scanner.close();
			return g;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
