import java.util.ArrayList;

/**
 * Table of all the TeacupSets
 */
public class DynamicTable {
    private TeacupSet[][] table;
    private int[] groupingValues;
    private int cupCount;
    private int maxAllowed;

    public DynamicTable(){
        this(24, 12, new int[]{0, 1, 3, 5, 9, 10, 15, 17, 18, 19, 22, 25, 27});
    }

    public DynamicTable(int count, int max, int[] values){
        table = new TeacupSet[count][max];
        groupingValues = values;
        cupCount = count;
        maxAllowed = max;
    }

    /**
     * Build table of each optimal TeacupSet
     */
    public void makeTable(){
        Divide d = new Divide();
        for(int i = 1; i <= maxAllowed; i++){
            for(int j = 1; j <= cupCount; j++){
                table[j - 1][i - 1] = getBestSet(new ArrayList<>(d.getCombos(j, i)));
            }
        }
    }

    /**
     * Print out the chosen TeacupSet
     * @param count x position of the set
     * @param max y position of the set
     */
    public void getSum(int count, int max){
        System.out.print(table[count - 1][max - 1]);
    }

    /**
     * Find best of all of the possible combinations of each x,y
     * @param combos possible combinations
     * @return best TeacupSet
     */
    private TeacupSet getBestSet(ArrayList<ArrayList<Integer>> combos){
        TeacupSet greatestSet = new TeacupSet(groupingValues);
        for(ArrayList<Integer> combo: combos){
            TeacupSet currentSet = new TeacupSet(groupingValues);
            for(Integer item: combo){
                currentSet.add(item);
            }
            greatestSet = max(greatestSet, currentSet);
        }
        return greatestSet;
    }

    /**
     * Get TeacupSet with the best value
     * @param set1 first
     * @param set2 second
     * @return greatest value TeacupSet
     */
    private TeacupSet max(TeacupSet set1, TeacupSet set2){
        if(set2.compareTo(set1)){
            return set2;
        } else{
            return set1;
        }
    }
}
