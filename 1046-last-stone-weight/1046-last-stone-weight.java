import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        // Create a max priority queue (max-heap)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        // Add all stone weights to the priority queue
        for (int ele : stones) { 
            pq.add(ele);
        }
        
        // Smash stones until 1 or 0 stones are left
        while (pq.size() > 1) {
            int max = pq.remove();
            int smax = pq.remove();
            
            int nstone = max - smax;
            
            if (nstone != 0) {
                pq.add(nstone);
            }
        }
        
        // Return the weight of the last remaining stone, or 0 if none left
        if (pq.size() == 0) {
            return 0;
        } else {
            return pq.peek(); // or pq.remove()
        }
    }
}