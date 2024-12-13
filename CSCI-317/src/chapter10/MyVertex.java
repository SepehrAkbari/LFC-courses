package chapter10;

public class MyVertex {
	private long data;
	private char name;
	private String color;
	private int distance;
	private int time1, time2;
	private int index;//position in the array
	
	public MyVertex(char c) {
		data = 0;
		name = c;
		color = "white";
		distance = Integer.MAX_VALUE;
		time1 = 0;
		time2 = 0;	
		index = -1;
	}
	
	public void setData(long d) {
		data = d;
	}
	
	public long getData() {
		return data;
	}
	
	public char getName() {
		return name;
	}
	
	public void setColor(String c) {
		color = c;
	}
	public String getColor() {
		return color;
	}
	
	public void setDistance(int d) {
		distance = d;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public void setTime1(int t) {
		time1 = t;
	}
	
	public int getTime1() {
		return time1;
	}
	
	public void setTime2(int t) {
		time2 = t;
	}
	
	public int getTime2() {
		return time2;
	}
	
	public int getIndex() {
		return index;
	}
	
	public void setIndex(int i) {
		index = i;
	}
	
	public String toString() {
		String output = "[";
		output += (name + "|" + data + "|" + color + "|Dist:");
		if(distance==Integer.MAX_VALUE)
			output += "Inf";
		else
			output += distance;
		output += ("|Time1:"+time1+"|Time2:"+time2+"]");
		return output;
	}

}