import java.util.Arrays;
import java.util.Scanner;

public class Silver1026 {
    public static void main(String[] args) {
        start();
    }

    // 50보다 작거나 같은 자연수여야한다.
    public static boolean count(int N) {
        return N >= 1 && N <= 50;
    }

    // A, B 배열 요소 값 유효성 검사 (0 , 100)
    public static boolean abBoolean(int[] A, int[] B) {
        for (int num : A) {
            if (num < 0 || num > 100) return false;
        }
        for (int num : B) {
            if (num < 0 || num > 100) return false;
        }
        return true;
    }

    public static void start() {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        if (!count(N)) {
            return;
        }

        int[] A = new int[N];
        Integer[] B = new Integer[N];

        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        for (int i = 0; i < N; i++) {
            B[i] = scanner.nextInt();
        }

        if (!abBoolean(A, Arrays.stream(B).mapToInt(Integer::intValue).toArray())) {
            return;
        }

        // A는 오름차순, B는 내림차순 정렬
        Arrays.sort(A);
        Arrays.sort(B,(x,y) -> y - x);

        int S = 0;
        for (int i = 0; i < N; i++) {
            S += A[i] * B[i];
        }

        System.out.println(S);
    }
}
