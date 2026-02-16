class gas_Station{
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSurplus = 0; 
        int currentSurplus = 0; 
        int startStation = 0;
        
        for (int i = 0; i < gas.length; i++) {
            int d = gas[i] - cost[i];
            totalSurplus += d;
            currentSurplus += d;

            if (currentSurplus < 0) {
                startStation = i + 1;
                currentSurplus = 0;
            }
        }
        return (totalSurplus < 0) ? -1 : startStation;
    }
}