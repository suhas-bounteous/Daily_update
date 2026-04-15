class CloseTarget {
    public int closestTarget(String[] words, String target, int start) {
        int n = words.length;
        for (int i = 0; i <= n >> 1; i++)
            if (words[(start + i) % n].equals(target) |
                words[(start - i + n) % n].equals(target))
                return i;

        return -1;
    }
    public static void main(String[] args) {
        CloseTarget obj = new CloseTarget();
        System.out.println(obj.closestTarget(args[0], args[1], null, 0));
    }
}