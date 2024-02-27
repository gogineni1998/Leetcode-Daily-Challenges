public class Main {
    public static void main(String[] args) {
        DisJointSet ds = new DisJointSet(8);
        ds.addEdge(1, 2);
        ds.addEdge(2, 3);
        ds.addEdge(4, 5);
        if(ds.getUltimateParent(1) == ds.getUltimateParent(5)) {
            System.out.println(1+" "+5+" belong to same tree");
        }
        else {
            System.out.println(1+" "+5+" dosen't belong to same tree");
        }
        ds.addEdge(6, 7);
        ds.addEdge(5, 6);
        ds.addEdge(3, 7);
        if(ds.getUltimateParent(1) == ds.getUltimateParent(5)) {
            System.out.println(1+" "+5+" belong to same tree");
        }
        else {
            System.out.println(1+" "+5+" dosen't belong to same tree");
        }
    }
}