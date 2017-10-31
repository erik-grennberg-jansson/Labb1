
public class BinSearchIntSet implements IntSet{
    private int datArr[];
    
    public BinSearchIntSet(){
	    datArr = new int[0];
    }
    
    /*Method for adding a new element to the set. This is done by creating
     *a new primitive array which can hold one additional element and 
     *copying all the old elements from the last array and finally adding
     * the new element.
     */
    public void add(int element){
		//If the element is already in the set, do nothing.
		if(contains(element))
			return;
		
		
		int[] temp = new int[datArr.length+1];
			
		/*Iterate through the array backwards. Compare each element with
		 * the one that should be inserted. If the inserted element 
		 * is larger than the corresponding element in the old array, it
		 * should be inserted at that position.
		 */
		int index = datArr.length;
		while( (index > 0) && (element < datArr[index-1]) ){
			temp[index] = datArr[index-1];
			index = index - 1;
		}
		temp[index] = element;
			
		/*Fill the rest of the array with the elements from datArr.
		 */
		for(int i=0; i<index; i++){
			temp[i]=datArr[i];
		}
			
		datArr = temp;	
		return;	
	}
	
	public boolean contains(int element){
		if(binarySearch(element)>=0)
		    return true;
		else 
		    return false;
	}
	
	public void remove(int element){
	    int removeIndex = binarySearch(element);
	    if(removeIndex >=0){
			int temp[] = new int[datArr.length-1];
			for(int i=removeIndex; i<datArr.length-1; i++){
				temp[removeIndex]=datArr[removeIndex+1];	
			}
			for(int i=0; i<removeIndex; i++){
				temp[i] = datArr[i];
			}
			datArr = temp;
			return;
		} 
		return;
	}
	
	/*Method for conducting binarySearch
	 */ 
	public int binarySearch(int element){
	    int lowIndex = 0;
	    int maxIndex = datArr.length-1;
	    
	    while(lowIndex<=maxIndex){
		    int middleIndex = ((lowIndex+maxIndex)/2);
		    
		    if( datArr[middleIndex] < element)
		    {
				lowIndex = middleIndex + 1;
			} 
			else if( datArr[middleIndex] > element) 
			{
				maxIndex = middleIndex - 1;
			} 
			else 
			{
				return middleIndex;
			}	
		}
		return -1;	
	}
}
	
