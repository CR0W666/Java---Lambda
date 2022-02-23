import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.DoubleFunction;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

public class Lambdas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> input = new ArrayList<>(Arrays.stream(sc.nextLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList()));

        while(true){

            String command = sc.nextLine();

            switch (command) {
                case "1":
                    System.out.println(filter(input, i -> i % 11 == 0));
                    break;
                case "2":
                    System.out.println(filter(input, i -> Integer.toString(i * i * i).endsWith("3")));
                    break;
                case "3":
                    System.out.println(apply(input, i -> i * 2));
                    break;
                case "4":
                    System.out.println(apply(input, i -> (double) (Math.round(i / 1000 * 80) * 10)));
                    break;
            }
        }



    }

    private static ArrayList<Integer> filter(ArrayList<Integer> input, IntPredicate by){
        ArrayList<Integer> output = new ArrayList<>();
        for(Integer i : input){
            if(by.test(i)) output.add(i);
        }
        return output;
    }

    private static ArrayList<Double> apply(ArrayList<Integer> input, DoubleFunction<Double> by){
        ArrayList<Double> output = new ArrayList<>();
        for(Integer i : input){
            output.add(by.apply(i));
        }
        return output;
    }
}