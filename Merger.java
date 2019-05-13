/**
  Represent a merge operation for sorted lists,
  as described in README.md
 */
import java.util.ArrayList;

public class Merger {

    ArrayList<String> usersData;

    /**
      Construct an instance from a list of data
      part of which is to be merged. See README
     */
    public Merger( ArrayList<String> list) {
        usersData = list;
    }


    /**
      Merge the sorted sub-lists.
     */
    public void merge(
      // indexes of sub-list boundaries; see README
        int start0  // index of first item in list0
      , int start1  // index of first item in list1
                    // = just past end of list0
      , int nItems  // number of items in the merged list
                    // = just past end of list1
      ) {
      ArrayList<String> sortedList = new ArrayList<String>();
      for (int i = 0; i < usersData.size(); i++)
        sortedList.add(usersData.get(i));
      
      int index1;
      int index2;
      int counter = start0;
      for( index1 = start0, index2 = start1; index1 < start1 && index2 < nItems; ){
        if(usersData.get( index1).compareTo( usersData.get( index2)) <= 0){
          sortedList.set( counter, usersData.get( index1));
          index1++;
          counter++;
        }
        else {
          sortedList.set( counter, usersData.get( index2));
          index2++;
          counter++;
        }
      }
        if(index1 == start1){
          for( int leftOverIndex = index2; leftOverIndex < nItems; leftOverIndex++){
            sortedList.set( counter, usersData.get( leftOverIndex));
            counter++;
          }
        }
        if(index2 == nItems){
          for( int leftOverIndex = index1; leftOverIndex < start1; leftOverIndex++){
            sortedList.set( counter, usersData.get( leftOverIndex));
            counter++;
          }
        }
        usersData = sortedList;
      }

    /**
      @return a string representation of the user's data
     */
    public String toString() {
        return "" + usersData; 
    }

    
    /** 
      @return the boolean value of the statement
         "the data in the range are in ascending order"
     */
    public boolean isSorted( int startAt, int endBefore) {
        for( int i = startAt
           ; i < endBefore -1 // stop early, because comparing to next
           ; i++
           )
            if( usersData.get(i).compareTo( usersData.get(i+1)) > 0) return false;
        return true;
    }
}