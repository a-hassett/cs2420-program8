public class Main {
    public static void main(String[] args){
        int[] values1 = {0, 1, 3, 5, 9, 10, 15, 17, 18, 19, 22, 25, 27};
        int[] values2 = {0, 2, 5, 8, 9, 10, 15, 19, 23, 24, 29, 30, 32};
        int cupCount = 24;
        int maxAllowed = 12;

        DynamicTable table = new DynamicTable(cupCount, maxAllowed, values1);
        table.makeTable();

        for(int i = 1; i <= cupCount; i++){
            table.getSum(i, maxAllowed);
        }
    }
}
