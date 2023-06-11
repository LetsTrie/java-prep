import java.util.Scanner;

public class GCD {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);

		int a = scanner.nextInt();
		int b = scanner.nextInt();

		// Make sure that "b" is always greater!
		if(a > b) {
			int temp = a;
			a = b;
			b = temp;
		}

		System.out.println(findGCD(a, b));
	}

	private static int findGCD(int a, int b) {
		if(a == 0) return b;
		return findGCD(b % a, a);
	}
}
