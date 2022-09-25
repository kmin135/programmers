package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineCharMap = new HashMap<>();

        for(Character ch : magazine.toCharArray()) {
            if(magazineCharMap.putIfAbsent(ch, 1) != null) {
                magazineCharMap.put(ch, magazineCharMap.get(ch)+1);
            }
        }

        for(Character ch : ransomNote.toCharArray()) {
            if(!magazineCharMap.containsKey(ch)) {
                return false;
            } else {
                int newValue = magazineCharMap.get(ch)-1;
                if(newValue == 0) {
                    magazineCharMap.remove(ch);
                } else {
                    magazineCharMap.put(ch, newValue);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        RansomNote sol = new RansomNote();
        System.out.println(sol.canConstruct("a", "b"));
        System.out.println(sol.canConstruct("aa", "ab"));
        System.out.println(sol.canConstruct("aa", "aab"));
    }
}
