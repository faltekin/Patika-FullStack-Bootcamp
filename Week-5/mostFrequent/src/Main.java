import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);
        System.out.println("Metin giriniz: ");
        String text = inp.nextLine();

        String[] str = text.split(" ");
        HashMap<String, Integer> freq = new HashMap<>();

        for (String st : str) {
            st = st.toLowerCase();
            if (freq.containsKey(st)) {
                int count = freq.get(st);
                freq.put(st, count + 1);
            } else {
                freq.put(st, 1);
            }
        }

        String mostFreq = "";
        int maxFreq = 0;

        for (String st : freq.keySet()) {
            if (freq.get(st) > maxFreq) {
                maxFreq = freq.get(st);
                mostFreq = st;
            }
        }

        System.out.println("En çok tekrar eden kelime: " + mostFreq);
        System.out.println("Bu kelime " + maxFreq + " kere tekrar edildi.");

    }
}