import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String operation : operations) {
            String[] tmp = operation.split(" ");
            String op = tmp[0];
            int num = Integer.parseInt(tmp[1]);
            switch (op) {
                case "I":
                    minHeap.add(num);
                    maxHeap.add(num);
                    break;
                case "D":
                    if (minHeap.isEmpty()) continue;
                    if (num == 1)
                        minHeap.remove(maxHeap.poll());
                    else
                        maxHeap.remove(minHeap.poll());
                    break;
            }
        }
        
        if (minHeap.isEmpty())
            return new int[]{0, 0};
        return new int[]{maxHeap.peek(), minHeap.peek()};
    }
}