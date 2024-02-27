import java.util.ArrayList;
import java.util.List;

public class DisJointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();

    public DisJointSet(int n) {
        for(int i=0;i<n;i++) {
            parent.add(i);
            rank.add(0);
        }
    }
    public int getUltimateParent(int n) {
        if(n == parent.get(n)) {
            return n;
        }
        return getUltimateParent(parent.get(n));
    }
    public void addEdge(int a, int b) {
        int upa = getUltimateParent(a);
        int upb = getUltimateParent(b);
        int ra = rank.get(upa);
        int rb = rank.get(upb);
        if(upa == upb) {
            return;
        }

        if(ra > rb) {
            parent.set(upb,upa);
        }
        else if(ra < rb) {
            parent.set(upa,upb);
        }
        else {
            parent.set(upb,upa);
            int rankA = rank.get(upa) + 1;
            rank.set(upa, rankA + 1);
        }
    }
}
