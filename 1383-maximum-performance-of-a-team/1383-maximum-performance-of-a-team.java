class Engineer{
    int speed;
    int efficiency;
    Engineer(int speed,int efficiency){
        this.speed=speed;
        this.efficiency=efficiency;
    }
}
class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        List<Engineer>  engineers = new ArrayList<>();
        for(int i=0;i<n;i++){
            engineers.add(new  Engineer(speed[i],efficiency[i]));
        }
        engineers.sort((a,b)->b.efficiency - a.efficiency);
        PriorityQueue<Engineer> currentTeam = new PriorityQueue<>((a,b)->a.speed-b.speed);
        long teamSpeed=0;
        long maxPerformance = 0;
        for(Engineer newHire:engineers){
            if(currentTeam.size()==k){
                Engineer slowGuy = currentTeam.poll();
                teamSpeed-=slowGuy.speed;
            }
            currentTeam.add(newHire);
            teamSpeed+=newHire.speed;
            long performaceWithNewGuy = teamSpeed * (long) newHire.efficiency;
            maxPerformance=Math.max(performaceWithNewGuy,maxPerformance);
        }
        return (int)(maxPerformance%1000000007);
    }
}