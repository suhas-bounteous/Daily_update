class MaxDistBwHouses {
    public int maxDistance(int[] colors) {
        int n=colors.length;
        int maxDist = 0;
        for(int i=0; i<colors.length; i++){
            if (colors[i] != colors[0]) {
                maxDist = Math.max(maxDist, i);
            }
            if (colors[i] != colors[n - 1]) {
                maxDist = Math.max(maxDist, (n - 1) - i);
            }
        }
        return maxDist;
    }
   
    public static void main(String[] args){
        MaxDistBwHouses obj = new MaxDistBwHouses();
        int[] colors1 = {1, 8, 3, 8, 1};
        System.out.println("Max distance for {1, 8, 3, 8, 1}: " + obj.maxDistance(colors1)); // Expected: 4
        int[] colors2 = {1, 1, 1, 6, 1, 1, 1};
        System.out.println("Max distance for {1, 1, 1, 6, 1, 1, 1}: " + obj.maxDistance(colors2)); // Expected: 3
    }
}