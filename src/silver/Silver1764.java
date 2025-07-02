package silver;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Silver1764 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 듣도 못한 사람
        HashMap<String, Integer> notListening = new HashMap<>();
        for (int i = 0; i < N; i++) {
           notListening.put(br.readLine(), 1);
        }

        // Hash 듣도 못한 사람 중에 보도 못한 사람
        ArrayList<String> notSeeing = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if(notListening.containsKey(name)) {
                notSeeing.add(name);
            }
        }

        // 듣보잡의 수와 그 명단을 사전순으로 정렬한다.
        Collections.sort(notSeeing);

        // 정답을 출력한다.
        bw.write(notSeeing.size() + "\n");
        for (int i = 0; i < notSeeing.size(); i++) {
            bw.write(notSeeing.get(i));
            bw.write("\n");
        }

        bw.flush();

        bw.close();
        br.close();
    }
}
