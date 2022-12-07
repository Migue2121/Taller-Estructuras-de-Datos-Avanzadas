class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
         ArrayList<Integer> g[] = new ArrayList[n];
        int degree[] = new int[n];
        
        for (int i=0; i<n; i++) {
            g[i] = new ArrayList<Integer>();
        }
        
        for (int i=0; i<edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            degree[from]++;
            degree[to]++;
            g[from].add(to);
            g[to].add(from);
        }
        
        int count = n;
        while (count>2) {
            ArrayList<Integer> toDeleteLeafs = getLeafs(degree);
            count-=toDeleteLeafs.size();
            deleteLeafsAndEdges(toDeleteLeafs, g, degree);
        }
        
        ArrayList<Integer> roots = new ArrayList<Integer>();
        for (int i=0; i<n; i++) {
            if (degree[i]>=0) roots.add(i);
        }
        return roots;
    }
    
    private ArrayList<Integer> getLeafs(int degree[]) {
        ArrayList<Integer> leafs = new ArrayList<Integer>();
        for (int i=0; i<degree.length; i++) {
            if (degree[i]==1) {
                leafs.add(i);
            }
        }
        return leafs;
    }
    
    private void deleteLeafsAndEdges(ArrayList<Integer> toDeleteLeafs, ArrayList<Integer> g[], int degree[]) {
        for (Integer v: toDeleteLeafs) {
            degree[v]=-1;
            for (Integer to: g[v]) {
                degree[to]--;
            }
        }
    }