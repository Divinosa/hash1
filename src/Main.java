import java.util.HashMap;
import java.util.Map;

public class Main {

   static String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum";

    public static void main(String[] args) {
        Map<Character, Integer> map = initMap();
        System.out.println(maxMap(map));
        System.out.println(minMap(map));

    }

    public static Map<Character, Integer> initMap(){
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < text.length(); i++){
            if (Character.isLetter(text.charAt(i))) {
                if (map.containsKey(text.charAt(i))) {
                    int count = map.get(text.charAt(i)) + 1;
                    map.put(text.charAt(i), count);
                } else {
                    map.put(text.charAt(i), 1);
                }
            }
        }
        return map;
    }
    public static Map.Entry<Character, Integer> maxMap( Map<Character, Integer> map){
        Map.Entry<Character, Integer> maxEntry = null;
        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            if (maxEntry == null ||entry.getValue() > maxEntry.getValue()){
                maxEntry = entry;
            }
        }
        return maxEntry;
    }
    public static Map.Entry<Character, Integer> minMap(Map<Character, Integer> map){
        Map.Entry<Character, Integer> minEntry = maxMap(map);
        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            if (entry.getValue() < minEntry.getValue()){
                minEntry = entry;
            }
        }
        return minEntry;

    }
}