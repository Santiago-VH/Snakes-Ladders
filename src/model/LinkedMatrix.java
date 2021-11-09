package model;

public class LinkedMatrix {
	private Node first;
	private int numRows;
	private int numCols;
	
	public LinkedMatrix(int n, int m) {
		numRows=n;
		numCols=m;
		createMatrix(n,m);
		fill();
	}
	
	public void createMatrix(int n, int m) {
		first=new Node(0,0);
		createRow(0,0,first);
	}
	
	private void createRow(int i, int j, Node currentFirstRow) {
		createCol(i,j+1,currentFirstRow,currentFirstRow.getUp());
		if(i+1<numRows) {
			Node downFirstRow = new Node(i+1,j);
			downFirstRow.setUp(currentFirstRow);
			currentFirstRow.setDown(downFirstRow);
			createRow(i+1,j,downFirstRow);
		}
	}
	
	private void createCol(int i, int j, Node prev, Node rowPrev) {
		if(j<numCols) {
			Node current = new Node(i,j);
			current.setPrev(prev);
			prev.setNext(current);
			
			if(rowPrev != null) {
				rowPrev=rowPrev.getNext();
				current.setUp(rowPrev);
				rowPrev.setDown(current);
			}
			createCol(i,j+1,current,rowPrev);
		}
	}
	
	public String toString() {
		String msg;
		msg=toStringRow(first);
		return msg;
	}
	
	public String toStringRow(Node firstRow) {
		String msg = "";
		if(firstRow!=null) {
			msg = toStringCol(firstRow)+" \n";
			msg += toStringRow(firstRow.getDown());
		}
		return msg;
	}
	
	private String toStringCol(Node current) {
		String msg = "";
		if(current!=null) {
			msg =current.toString();
			msg+=toStringCol(current.getNext());
		}
		return msg;
	}
	
	public void fill() {
		int RL = 1;
		Node current = first;
		int value = 1;
		int row=0;
		int col=0;
		while(current!=null) {
			if(RL==1) {
				
				current.setValue(value);
				value++;
				col++;
				
				if(col==numCols){
					RL=2;
					current = current.getDown();
					row++;
				}else {
					current = current.getNext();
				}
			}else if(RL==2){
				current.setValue(value);
				value++;
				col--;
				if(col==0) {
					RL=1;
					current = current.getDown();
					row++;
				}else {
					current = current.getPrev();
				}
			}else if(row==numRows && col==numCols){
				break;
			}
			
		}
	}

}

