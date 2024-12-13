package chapter10;

public class TestGraph {

	public static void main(String[] args) {
		String names = "ABCDEC";
		MyGraph g = new MyGraph(50);
		for(int i=0; i<names.length(); i++) {
			MyVertex v = new MyVertex(names.charAt(i));
			g.addVertex(v);
		}

		g.addEdge('A', 'B');
		g.addEdge('A', 'C');
		g.addEdge('B', 'D');
		g.addEdge('C', 'D');
		g.addEdge('C', 'E');
		g.addEdge('B', 'E');
		g.addEdge('D', 'E');

		g.display();
		System.out.println();
		for(int i=0; i<names.length(); i++) {
			System.out.println(g.getVertex(names.charAt(i)));
		}
		g.BFS('E');
		System.out.println();
		for(int i=0; i<names.length(); i++) {
			System.out.println(g.getVertex(names.charAt(i)));
		}
		System.out.println();
		g.DFS('E');
		System.out.println();
		for(int i=0; i<names.length(); i++) {
			System.out.println(g.getVertex(names.charAt(i)));
		}
		

	}

}