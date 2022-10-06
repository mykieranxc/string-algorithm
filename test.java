import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountFruits {

    private static final String OUTPUT_OPTION_1 = "\tA: 2\n \t\tB: 1\n \t\tC: 3\n";

    private static final String OUTPUT_OPTION_2 = """
            \tA: 1
            \t\t1 Apple

            \t\tB: 2
            \t\t1 Banana\s
            \t\t1 Blueberry
            """;

    private static HashMap<String, Integer> getMemo() {

        return new HashMap<>();
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        final Map<String, Map<String, Integer>> alphabets = new HashMap<>();

        alphabets.put("A", getMemo());
        alphabets.put("B", getMemo());
        alphabets.put("C", getMemo());
        alphabets.put("D", getMemo());
        alphabets.put("E", getMemo());
        alphabets.put("F", getMemo());
        alphabets.put("G", getMemo());
        alphabets.put("H", getMemo());
        alphabets.put("I", getMemo());
        alphabets.put("J", getMemo());
        alphabets.put("K", getMemo());
        alphabets.put("L", getMemo());
        alphabets.put("M", getMemo());
        alphabets.put("N", getMemo());
        alphabets.put("O", getMemo());
        alphabets.put("P", getMemo());
        alphabets.put("Q", getMemo());
        alphabets.put("R", getMemo());
        alphabets.put("S", getMemo());
        alphabets.put("T", getMemo());
        alphabets.put("U", getMemo());
        alphabets.put("V", getMemo());
        alphabets.put("W", getMemo());
        alphabets.put("X", getMemo());
        alphabets.put("Y", getMemo());
        alphabets.put("Z", getMemo());

        String[] fruits = {"Strawberry", "Mango", "Cherry", "Lime", "Guava", "Papaya", "Nectarine",
                "Pineapple", "Lemon", "Plum", "Tangerine", "Fig", "Blueberry", "Grape", "Jackfruit",
                "Pomegranate", "Apple", "Pear", "Orange", "Watermelon", "Raspberry", "Banana"};

        System.out.printf("Please choose output format:%n 1 => %s%n 2 => %s%n", OUTPUT_OPTION_1, OUTPUT_OPTION_2);

        int flag = in.nextInt();

        for (String fruit : fruits) {
            String s = fruit.substring(0, 1);
            HashMap<String, Integer> l = (HashMap<String, Integer>) alphabets.get(s);

            if (l.containsKey(fruit)) {
                l.put(fruit, l.get(fruit) + 1);
            } else {
                l.put(fruit, 1);
            }

            alphabets.put(s, l);
        }

        alphabets.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(a -> {

                    if (flag == 2) {
                        System.out.printf("%s: %d%n", a.getKey(), a.getValue().size());

                        a.getValue()
                                .entrySet()
                                .stream()
                                .sorted(Map.Entry.comparingByKey())
                                .forEach(f -> System.out.printf("%d %s%n", f.getValue(), f.getKey()));
                    }

                    System.out.print("\n");
                });
    }
}