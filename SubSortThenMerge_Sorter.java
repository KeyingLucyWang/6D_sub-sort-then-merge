/**
  Implement an insertion sort, in the Sorters structure
 */
import java.util.ArrayList;

public class SubSortThenMerge_Sorter extends Sorter {


    /**
      Construct an instance to process the user's data
     */
    public SubSortThenMerge_Sorter(  ArrayList<String> usersData) {
        super( usersData);
    }
    

    /**
      sort the user's data, implementing insertion sort
     */
    public void mySort(){
      SubSortThenMerge( 0, elements.size() - 1, elements);
    }

    // public void mySort( int start, int end) {
    //     // your code here
    //     for( int indexToSort = start; indexToSort < end; indexToSort++){
    //     insert1( indexToSort);
    //     // System.out.println( "    dbg: "
    //     // + "after inserting element " + indexToSort
    //     // + " elements: " + elements
    //     // );
    //   }
    // }

  //   public void insert1( int alreadyInserted){
  //   String valueToInsert = elements.get(alreadyInserted);
  //   int dropIndex = alreadyInserted;
  //   // for debugging
  //   //System.out.println( valueToInsert);
  //   for( int indexToCompare = alreadyInserted - 1; indexToCompare >= 0 && valueToInsert.compareTo( elements.get( indexToCompare)) < 0; indexToCompare--){
  //     if ( valueToInsert.compareTo(elements.get( indexToCompare)) < 0){
  //       dropIndex = indexToCompare;
  //       if( indexToCompare == 0){
  //         elements.set(1, elements.get( 0));
  //         elements.set( 0, valueToInsert);
  //       }
  //       else
  //         elements.set( indexToCompare + 1, elements.get( indexToCompare));
  //     }
  //   }
  //   // for debugging
  //   //System.out.println( dropIndex);
  //   elements.set( dropIndex, valueToInsert);
  // } 

    public void SubSortThenMerge( int start0, int end, ArrayList<String> unsorted){
      Merger merger = new Merger( unsorted);
      if( end == start0)
        return;
      else {
        SubSortThenMerge( start0, (end + start0) / 2, merger.usersData);
        SubSortThenMerge( (end + start0) / 2, end, merger.usersData);
        merger.merge( start0, ( start0 + end) / 2, end - start0 + 1);
      }
      elements = merger.usersData;
  }
}
