import java.io.*;

public class Silver4659 {
    private static final String vowels = "aeiou";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while (!(line = br.readLine()).equals("end")) {
            System.out.printf("<%s> is %sacceptable.\n", line, exception(line) ? "" : "not ");
        }
    }

    private static boolean exception(String n) {
        int vowelCount = 0, consonantCount = 0;
        boolean hasVowel = false;

        for (int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);

            // 모음(a,e,i,o,u) 하나를 반드시 포함해야한다.
            if (vowels.indexOf(c) >= 0) {
                hasVowel = true;
                vowelCount++;
                consonantCount = 0;
            } else {
                consonantCount++;
                vowelCount = 0;
            }

            // 모음이 3개 혹은 자음이 3개 연속으로 오면 안된다.
            if (vowelCount == 3 || consonantCount == 3) {
                return false;
            }

            // 같은 글자가 연속적으로 두번 오면 안되나, ee와 oo는 허용한다.
            if (i > 0 && c == n.charAt(i - 1) && !(c == 'e' || c == 'o')) {
                return false;
            }
        }
        return hasVowel;
    }
}
