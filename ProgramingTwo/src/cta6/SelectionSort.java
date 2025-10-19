package cta6;
import java.util.*;

public class SelectionSort {
	
    public static void selectionSort(ArrayList<Student> list, Comparator<Student> comp) {
    	
        for (int i = 0; i < list.size() ; i++) {
        		//sets min to current index
            int min = i;
            //searches for smaller value in every value after the current index
            for (int j = i + 1; j < list.size(); j++) {
            		//goes trough all values after current index
                if ( comp.compare( list.get(j), list.get(min) ) < 0) {
                		//keeps track of smallest valued index found so far
                    min = j;
                }
            }
            //saps the smallest value to current index position
            if (i != min) {
            		Collections.swap(list, i, min);
            }
            
        }
    }

}
