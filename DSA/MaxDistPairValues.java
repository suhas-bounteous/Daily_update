class MacDistPairValues {
    public int maxDistance(int[] A, int[] B) {
        int i, j = 1;

        for (i = 0; i < A.length && j < B.length; j++)
            if (A[i] > B[j])
                i++;

        return j - i - 1;
    }
    public static void main(String[] args) {
        MacDistPairValues obj = new MacDistPairValues();
        int[] A = {1, 3,4};
        int[] B = {1, 2, 5};
        System.out.println(obj.maxDistance(A, B));
    }
}