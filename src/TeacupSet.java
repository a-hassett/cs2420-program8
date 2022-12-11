import java.util.ArrayList;

/**
 * Holds all the data that we'll need for the TeacupSet
 */
public class TeacupSet {
    public ArrayList<Integer> groupings = new ArrayList<>();
    private int[] groupingValues;

    public TeacupSet(int[] values){
        groupingValues = values;
    }

    /**
     * Add a number to the set
     * @param newGroup
     */
    public void add(int newGroup){
        if(newGroup > 0 && newGroup <= 12){
            groupings.add(newGroup);
        }
    }

    /**
     * How many teacups
     * @return number of teacups
     */
    private int getCupCount(){
        int cupCount = 0;
        for(int groupSize: groupings){
            cupCount += groupSize;
        }
        return cupCount;
    }

    /**
     * Get values of all the items in the set
     * @return total value (will be optimal)
     */
    private int getSum(){
        int sum = 0;
        for(int groupSize: groupings){
            sum += groupingValues[groupSize];
        }
        return sum;
    }

    /**
     * Print all the data of the TeacupSet
     * @return string
     */
    public String toString(){
        StringBuilder data = new StringBuilder();
        data.append("Best Sum for (").append(getCupCount()).append(" teacup");
        if(getCupCount() != 1){
            data.append("s");
        }
        data.append("): $").append(getSum());
        for(int groupSize: groupings){
            data.append(" ").append(groupSize);
        }
        data.append("\n");
        return data.toString();
    }

    /**
     * Compare TeacupSets based on their total sum
     * @param otherSet second set to compare
     * @return whether self is larger than the other set
     */
    public boolean compareTo(TeacupSet otherSet){
        return getSum() > otherSet.getSum();
    }
}
