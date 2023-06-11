import java.util.Arrays;

public class Permutation {

    public static void main(String[] args) {
        String str = "aabc";
        System.out.println("Given word: " + str);
        generatePermutations(str);
    }

    public static void generatePermutations(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars); // Sort the characters for easier tracking of visited characters
        boolean[] visited = new boolean[chars.length];
        char[] currentPermutation = new char[chars.length];
        permute(chars, visited, currentPermutation, 0);
    }

    private static void permute(char[] chars, boolean[] visited, char[] currentPermutation, int index) {
        if (index == chars.length) {
            System.out.println(new String(currentPermutation));
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) continue; // Skip visited characters
            if(i > 0 && chars[i] == chars[i - 1] && !visited[i - 1])  continue; // Avoid duplicates

            visited[i] = true;
            currentPermutation[index] = chars[i];
            permute(chars, visited, currentPermutation, index + 1);
            visited[i] = false;
        }
    }
}
