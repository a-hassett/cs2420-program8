// Divide a certain number of teacups into all of its possible sets

import java.util.ArrayList;

public class Divide {
    //private ArrayList<ArrayList<Integer>>[][] allCombos;
    private ArrayList<ArrayList<Integer>> combos = new ArrayList<>();

    public Divide(){
    }

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

    public ArrayList<ArrayList<Integer>> getCombos(int cupCount, int largestAllowed){
        getCombo(1, largestAllowed, cupCount, new ArrayList<>());
        return this.combos;
    }


}
