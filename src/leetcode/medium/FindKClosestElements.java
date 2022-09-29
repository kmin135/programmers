package leetcode.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/find-k-closest-elements/
 *
 * 정렬을 두번이나 하니 잘 풀려도 O(nlonN) 이라 봐야겠다.
 *
 * 모범답안은 two pointer를 이용해 O(n)으로 푼다.
 * https://leetcode.com/problems/find-k-closest-elements/discuss/202785/Very-simple-Java-O(n)-solution-using-two-pointers
 */
public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> results = new ArrayList<>(k);

        Dist[] distArr = new Dist[arr.length];
        for(int i=0;i<arr.length;i++) {
            distArr[i] = new Dist(i, arr[i], Math.abs(arr[i] - x));
        }

        Arrays.sort(distArr, (o1, o2) -> {
            if(o1.dist == o2.dist) {
                return o1.value - o2.value;
            }

            return o1.dist - o2.dist;
        });

        for(int i=0;i<k;i++) {
            results.add(distArr[i].value);
        }
        Collections.sort(results);
        return results;
    }

    private static class Dist {
        int index;
        int value;
        int dist;

        public Dist(int index, int value, int dist) {
            this.index = index;
            this.value = value;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        FindKClosestElements sol = new FindKClosestElements();
        sol.findClosestElements(new int[]{1,2,3,4,5}, 4, 3).forEach(System.out::println);   // [1,2,3,4]
        sol.findClosestElements(new int[]{1,2,3,4,5}, 4, -1).forEach(System.out::println);  // [1,2,3,4]
    }
}
