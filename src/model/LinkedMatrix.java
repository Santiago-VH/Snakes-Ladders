package model;

public class LinkedMatrix {
	private Node first;
	private int numRows;
	private int numCols;
	
	public LinkedMatrix(int n, int m) {
		numRows=n;
		numCols=m;
		createMatrix(n,m);
		fill(n,m);
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
			current.setPrev(current);
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
	
	public void fill(int row, int col) {
		first.setValue(1);
		fillRow(first,1,row,col);
		
	}
	
	public void fillRow(Node currentRow,int value, int row, int col) {
		if(currentRow!=null) {
			if(row+1>numRows) {
				fillCol(currentRow.getDown(),value,row,col);
			}
			currentRow.setValue(value++);
			fillCol(currentRow.getNext(),value,row,col);
		}
	}
	
	public void fillCol(Node currentCol, int value, int row, int col) {
		if(col<numCols) {
			currentCol.setValue(value++);
			fillCol(currentCol.getPrev(),value,row,col);
		}
		if(currentCol!=null) {
			currentCol.setValue(value++);	
			fillCol(currentCol.getNext(),value,row,col);
		}
	}
}

