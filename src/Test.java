import java.util.ArrayList;

public class Test {
    public static void main(String[] args){
        int[] nums = {0, 1, 3, 5, 9, 10, 15, 17, 18, 19, 22, 25, 27};
        TeacupSet set = new TeacupSet(nums);
        TeacupSet set1 = new TeacupSet(nums);
        System.out.println(set);
        set.add(3);
        set.add(7);
        System.out.println(set);
        System.out.println(set1.compareTo(set));

        Divide idk = new Divide();
        ArrayList<ArrayList<Integer>> combos = idk.getCombos(10, 10);

        for(ArrayList<Integer> combo: combos){
            for(Integer item: combo){
                System.out.print(item);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
