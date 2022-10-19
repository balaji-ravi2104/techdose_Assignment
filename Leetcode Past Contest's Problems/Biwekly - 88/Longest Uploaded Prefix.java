class LUPrefix {
    
    TreeSet<Integer> tree = new TreeSet<>();
    int n;

    public LUPrefix(int n) {
        for (int i = 1; i <= n ; i++) {
            tree.add(i);
        }
        this.n = n;
    }

    public void upload(int video) {
        tree.remove(video);
    }

    public int longest() {
        return tree.isEmpty() ? n : tree.first() -1;
    }
}
/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */
