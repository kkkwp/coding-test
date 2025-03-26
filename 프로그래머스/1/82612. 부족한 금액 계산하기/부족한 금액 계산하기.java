class Solution {
    public long solution(int price, int money, int count) {
        long cost = 0;
        for (int i=1; i<=count; i++)
            cost += price*i;
        return cost-money>0 ? cost-money : 0;
    }
}