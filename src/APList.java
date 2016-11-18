
public class APList {
	private String[] list;
	private String longestString = "";
	private int longestStringIndex = 0;
	private int addIndexLength;
	private int nextFreeIndex = 0;

	public APList(int addIndexLength) {
		this.addIndexLength = addIndexLength;
		list = new String[addIndexLength];
	}

	public APList() {
		this.addIndexLength = 10;
		list = new String[addIndexLength];
	}

	public void addEnd(String input) {
		if(input.length() > longestString.length()){
			longestStringIndex = nextFreeIndex;
			longestString = input;
		}
		list[nextFreeIndex] = input;
		nextFreeIndex ++;
		
		if(nextFreeIndex >= list.length){
			String[] newList = new String[list.length + addIndexLength];
			for(int i = 0; i < list.length; i ++){
				newList[i] = list[i];
			}
			list = newList;
		}
		
	}
	
	public void removeEnd(){
		nextFreeIndex --;
		list[nextFreeIndex] = null;
		if(nextFreeIndex == longestStringIndex){
			String newLongestString = "";
			for(int i = 0; i< nextFreeIndex; i ++){
				if(list[i].length() > newLongestString.length()){
					longestStringIndex = i;
					newLongestString = list[i];
				}
			}
			longestString = newLongestString;
		}
	}
	
	public int indexOf(String input){
		for(int i = 0; i < nextFreeIndex; i ++){
			if(list[i].equals(input)){
				return i;
			}
		}
		return -1;
	}
	
	public String getLongest(){
		return longestString;
	}

}
