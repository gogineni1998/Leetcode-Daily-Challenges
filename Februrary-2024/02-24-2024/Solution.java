import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a,b) -> a[2] - b[2]);

        TreeSet<Integer> result = new TreeSet<>();
        List<Integer> main_res = new ArrayList<>();
        DisJointSet ds = new DisJointSet(n);
        ds.addEdge(0, firstPerson);
        int ind = 0;
        result.add(0);
        result.add(firstPerson);
        while(ind < meetings.length) {
            int meeting_time = meetings[ind][2];
            Set<Integer> temp_res = new HashSet<>();
            while(ind < meetings.length && meeting_time == meetings[ind][2]) {
                ds.addEdge(meetings[ind][0], meetings[ind][1]);
                temp_res.add(meetings[ind][0]);
                temp_res.add(meetings[ind][1]);
                ind++;
            }
            Iterator<Integer> value =  temp_res.iterator();

            while(value.hasNext()) {
                int a = (int)value.next();
                if(ds.getUltimateParent(a) == ds.getUltimateParent(0)) {
                    result.add(a);
                }
                else {
                    ds.setBack(a);
                }
            }
            
        }
        for(Integer x : result) {
            main_res.add(x);
        }
        return main_res;
    }
}

class DisJointSet {
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
    public void setBack(int n) {
        parent.set(n, n);
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