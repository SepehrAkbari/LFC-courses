package chapter10;

import java.util.LinkedList;
import java.util.Stack;

public class MyGraph {
	private MyVertex[] vertices;
	private int[][] adj;
	private int vcount;
	
	public MyGraph(int max_size) {
		vcount = 0;
		vertices = new MyVertex[max_size];
		adj = new int[max_size][max_size];
	}
	
	public void reset() {
		for(int i=0; i<vcount; i++) {
			vertices[i].setColor("white");
			vertices[i].setDistance(Integer.MAX_VALUE);
			vertices[i].setTime1(0);
			vertices[i].setTime2(0);
		}
	}
	public int getVcount() {
		return vcount;
	}
	
	public void addVertex(MyVertex v) {
		if(getVertex(v.getName()) == null) {
			vertices[vcount++] = v;
			v.setIndex(vcount-1);
		}
		else
			System.out.println("Another vertex exists with the name "+v.getName());
		
	}
	
	public void addEdge(char v1, char v2) {
		int index1, index2;
		index1 = index2 = -1;
		int i = 0;
		while(i<vcount && (index1==-1 || index2==-1)) {
			if(vertices[i].getName()==v1)
				index1 = i;
			if(vertices[i].getName()==v2)
				index2 = i;
			i++;
		}
		if(index1>-1 && index2>-1) {
			adj[index1][index2] = 1;
			adj[index2][index1] = 1;
		}
		else
			System.out.println("Invalid vertices!");
	}
	
	public void DFS(char start) {
		reset();
		//first find the starting vertex
		MyVertex current = getVertex(start);
		int index = current.getIndex();
		
		Stack<MyVertex> s = new Stack<MyVertex>();
		int time = 0;

		current.setColor("gray");
		current.setDistance(0);
		current.setTime1(time++);
		s.push(current);
		System.out.print(current.getName()+" ");
		
		while (!s.empty()) {
			boolean pushed = false;
			for(int j=0; j<vcount; j++) {
				if(adj[index][j]==1 && vertices[j].getColor().equals("white")) {
					vertices[j].setColor("gray");
					vertices[j].setDistance(vertices[index].getDistance()+1);
					vertices[j].setTime1(time++);
					System.out.print(vertices[j].getName()+" ");
					s.push(vertices[j]);
					pushed = true;
					index = j;
					break;
				}
			}
			if(!pushed) {
				current = s.pop();
				current.setColor("black");
				current.setTime2(time++);
			}
			
		}
		System.out.println();
		
	}
	
	public void BFS(char start) {
		reset();
		//first find the starting vertex
		MyVertex current = getVertex(start);
		int index = current.getIndex();
		
		LinkedList<MyVertex> q = new LinkedList<MyVertex>();
		int time = 0;
		current.setDistance(0);
		current.setColor("gray");
		current.setTime1(time++);
		q.add(current);
		System.out.print(current.getName()+" ");

		while(!q.isEmpty()) {
			for(int j=0; j<vcount; j++) {
				if(adj[index][j]==1 && vertices[j].getColor().equals("white")) {
					vertices[j].setColor("gray");
					vertices[j].setDistance(current.getDistance()+1);
					vertices[j].setTime1(time++);
					System.out.print(vertices[j].getName()+" ");
					q.add(vertices[j]);
				}
			}
			current = q.remove();
			current.setColor("black");
			current.setTime2(time++);
			index = current.getIndex();
		}
	}
	
	public MyVertex getVertex(char name) {
		//first find the starting vertex
		int index;
		index = -1;
		int i = 0;
		while(i<vcount && index==-1 ) {
			if(vertices[i].getName()==name)
				index = i;
			i++;
		}
		if(index==-1) {
			System.out.println("Vertex "+name+" not in graph!");
			return null;
		}
		else
			return vertices[index];
	}
	
	public void display() {
		System.out.println("Graph has "+vcount+" vertices.");
		for(int i=0; i<vcount; i++) {
			System.out.print(vertices[i].getName()+" ");
		}
		System.out.println();
		//Now print edges
		for(int i=0; i<vcount; i++) {
			for(int j=i; j<vcount; j++) {
				if(adj[i][j]==1)
					System.out.println("There is an edge from "+vertices[i].getName()+
							" to " + vertices[j].getName());
			}
		}

	}

}