package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<String, Integer> votes = new LinkedHashMap<>();

        System.out.print("Type the file full path: ");//Files\\in.txt
        File path = new File(sc.next());
        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {

            String line = bf.readLine();
            while (line != null) {

                String[] split = line.split(",");
                if (votes.containsKey(split[0])) {
                    int totVotes = votes.get(split[0])+Integer.parseInt(split[1]);
                    votes.put(split[0], totVotes);
                } else {
                    votes.put(split[0], Integer.parseInt(split[1]));
                }

                line = bf.readLine();
            }

        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        for (String key : votes.keySet()) {
            System.out.println(key + ": " + votes.get(key));
        }

        sc.close();
    }
}
