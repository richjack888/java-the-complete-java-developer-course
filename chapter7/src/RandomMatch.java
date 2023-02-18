import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomMatch {
    public static void main(String[] args) {

        /*
       請從十二生肖中隨機挑一個生肖後，再從十二星座中隨機挑一個星座形成一對結果(生肖, 星座)，
       重複以上步驟1000次產生出1000對結果，計算出這1000對結果的重複次數，
       次數由高到低列出。例：(猴, 魔羯座): 98, (雞, 牡羊座): 77, (牛, 獅子座): 61……
       */
        String[] animals = {"鼠", "牛", "虎", "兔", "龍", "蛇", "馬", "羊", "猴", "雞", "狗", "豬"};
        String[] zodiacs = {"牡羊座", "金牛座", "雙子座", "巨蟹座", "獅子座", "處女座", "天秤座", "天蠍座", "射手座", "魔羯座", "水瓶座", "雙魚座"};

//        int[] counts = new int[animals.length * zodiacs.length];
//
//        for (int i = 0; i < 1000; i++) {
//            int animalIndex = (int) (Math.random() * animals.length);
//            int zodiacIndex = (int) (Math.random() * zodiacs.length);
//            counts[animalIndex * zodiacs.length + zodiacIndex]++;
//        }
//
//        for (int i = 0; i < animals.length; i++) {
//            for (int j = 0; j < zodiacs.length; j++) {
//                System.out.println("(" + animals[i] + ", " + zodiacs[j] + "): " + counts[i * zodiacs.length + j]);
//            }
//        }

        Map<String, Integer> result = new HashMap<>();

        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            int animalsIndex = random.nextInt(12);
            int zodiacIndex = random.nextInt(12);

            String key = animals[animalsIndex] + "，" + zodiacs[zodiacIndex];

            if (result.containsKey(key)) {
                result.put(key, result.get(key) + 1);
            } else {
                result.put(key, 1);
            }
        }

////         version-1
//        result.entrySet().stream()
//                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
//                .forEach(entry -> System.out.println("(" + entry.getKey() + ")：" + entry.getValue()));

        //  version-2
        result.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> System.out.println("(" + entry.getKey() + ")：" + entry.getValue()));


    }
}
