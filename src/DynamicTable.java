import java.util.ArrayList;

public class DynamicTable {
    private TeacupSet[][] table;
    private int[] groupingValues;
    private int cupCount;
    private int maxAllowed;
    final private int[] defaultValues = {0, 1, 3, 5, 9, 10, 15, 17, 18, 19, 22, 25, 27};

    public DynamicTable(int count, int max, int[] values){
        table = new TeacupSet[count][max];
        groupingValues = values;
        cupCount = count;
        maxAllowed = max;
    }

    public void makeTable(){
        Divide sums = new Divide();
        for(int i = 1; i <= maxAllowed; i++){
            for(int j = 1; j <= cupCount; j++){
                ArrayList<ArrayList<Integer>> combos = new ArrayList<>(sums.getCombos(j, i));
//                if(i == 1 && j == 1){
//                    System.out.println(combos);
//                    System.out.println("\n");
//                }

                table[j - 1][i - 1] = getBestSet(new ArrayList<>(combos));
            }
        }
    }

    public void getSum(int count, int max){
        System.out.print(table[count - 1][max - 1]);
    }

    private TeacupSet getBestSet(ArrayList<ArrayList<Integer>> combos){
        TeacupSet greatestSet = new TeacupSet(groupingValues);
        //ArrayList<Integer> greatest = new ArrayList<>();
        for(ArrayList<Integer> combo: combos){
            TeacupSet currentSet = new TeacupSet(groupingValues);
            for(Integer item: combo){
                currentSet.add(item);
            }
            greatestSet = max(greatestSet, currentSet);
        }
        System.out.println(greatestSet);
        return greatestSet;
    }

    private TeacupSet max(TeacupSet set1, TeacupSet set2){
        if(set2.compareTo(set1)){
            return set2;
        } else{
            return set1;
        }
    }
}
