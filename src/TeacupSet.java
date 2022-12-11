import java.util.ArrayList;

public class TeacupSet {
    public ArrayList<Integer> groupings = new ArrayList<>();
    private int[] groupingValues;

    public TeacupSet(int[] values){
        groupingValues = values;
    }

    public TeacupSet(ArrayList<Integer> sequence, int[] values){
        groupings = new ArrayList<>(sequence);
        //groupings.addAll(sequence);
        groupingValues = values;
    }

//    public TeacupSet(int firstGroup){
//        if(firstGroup > 0 && firstGroup <= 12){
//            groupings.add(firstGroup);
//        }
//    }

//    public TeacupSet(ArrayList<Integer> list){
//        groupings.addAll(list);
//    }

    public void add(int newGroup){
        if(newGroup > 0 && newGroup <= 12){
            groupings.add(newGroup);
        }
    }

    private int getCupCount(){
        int cupCount = 0;
        for(int groupSize: groupings){
            cupCount += groupSize;
        }
        return cupCount;
    }

    private int getSum(){
        int sum = 0;
        for(int groupSize: groupings){
            sum += groupingValues[groupSize];
        }
        return sum;
    }

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

    public boolean compareTo(TeacupSet otherSet){
        return getSum() > otherSet.getSum();
    }
}
