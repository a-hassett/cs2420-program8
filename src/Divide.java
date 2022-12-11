import java.util.ArrayList;

/**
 * Recursively get all combination sums of a number
 */
public class Divide {
    private ArrayList<ArrayList<Integer>> combos = new ArrayList<>();

    public Divide(){}

    /**
     * Get array list of all combinations
     * @param cupCount sum
     * @param largestAllowed numbers in the combination cannot exceed
     * @return list of combinations (which are also lists)
     */
    public ArrayList<ArrayList<Integer>> getCombos(int cupCount, int largestAllowed){
        this.combos = new ArrayList<>();  // reset after every use
        getCombo(1, largestAllowed, cupCount, new ArrayList<>());
        return this.combos;
    }

    /**
     * Recurse through every possible combo
     * @param currOption integer you add to the combination
     * @param finalOption largest number you can use
     * @param goal final sum
     * @param path holds what numbers we've used so far in the combination
     */
    private void getCombo(int currOption, int finalOption, int goal, ArrayList<Integer> path){
        if(currOption > finalOption){
            if(goal == 0){
                this.combos.add(new ArrayList<>(path));
            }
            return;
        }
        if(currOption <= goal){
            // case where we use the current option
            path.add(currOption);
            getCombo(currOption, finalOption, goal - currOption, path);

            // case where we use the next option (continues outside if statement)
            path.remove(path.size() - 1);
        }
        getCombo(currOption + 1, finalOption, goal, path);
    }
}
