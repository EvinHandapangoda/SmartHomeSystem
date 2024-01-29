package db;

import model.timeblock.TimeBlock;

public class TimeBlockList{
	Node first;
	int nextIndex;
	
	TimeBlockList(){
		nextIndex = 0;
	}
	
	public void add(TimeBlock timeBlock){
		Node tempNode = new Node(timeBlock);
		if(isEmpty()){
			first = tempNode;
		}else{
			Node lastNode = first;
			while(lastNode.next != null){
				lastNode = lastNode.next;
			}
			 lastNode.next = tempNode;
		 }
		Node temp = first;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public void search(){
		
	}
	
	public boolean isEquals(TimeBlock checkBlock, int code){
		Node temp = first;
		while(temp != null){
			if(temp.timeBlock.getCode() == code){
				if(equals(temp.timeBlock, checkBlock)){
					return true;
				}
			}
			temp = temp.next;
		}
		return false;
	}
	
	public boolean equals(TimeBlock t1, TimeBlock t2){
		return t1.getStartHour() == t2.getStartHour() &&
				t1.getStartMinute() == t2.getStartMinute() &&
				t1.getEndHour() == t2.getEndHour() &&
				t1.getEndMinute() == t2.getEndMinute();
	}
	
	public int size(){
		int count = 0;
		Node temp = first;
		while(temp != null){
			count++;
			temp = temp.next;
		}
		return count;
	}
	
	
	/**public void add(TimeBlock[] tbArray, TimeBlock timeBlock){
		TimeBlock[] temp = new TimeBlock[tbArray.length+1];
		for (int i = 0; i < tbArray.length; i++){
			temp[i] = tbArray[i];
		}
		
		tbArray = temp;
		temp[tbArray.length -1] = timeBlock;
		
	}*/
		
		
	
	public TimeBlock[] toArray(int code){
		TimeBlock[] timeBlockArray = new TimeBlock[0];
		Node temp = first;
		while(temp != null){
			if(temp.timeBlock.getCode() == code){
				TimeBlock[] tempArray = new TimeBlock[timeBlockArray.length+1];
				for (int i = 0; i < timeBlockArray.length; i++){
					tempArray[i] = timeBlockArray[i];
				}
		
				timeBlockArray = tempArray;
				timeBlockArray[timeBlockArray.length -1] = temp.timeBlock;
			}
			temp = temp.next;
		}	
		return timeBlockArray;
	}
}	
	
class Node{
	TimeBlock timeBlock;
	Node next;
	
	Node(TimeBlock timeBlock){
		this.timeBlock = timeBlock;
	}
}
