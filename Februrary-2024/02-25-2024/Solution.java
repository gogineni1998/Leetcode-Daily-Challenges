import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private void getPrimes(int num, List<Integer> primes) {
        int[] primeHash = new int[num+1];
        for(int i=2;i<Math.sqrt(num);i++) {
            if(primeHash[i] == 0) {
                for(int j=i*i;j<=num;j=j+i) {
                    primeHash[j] = -1;
                }
            }
        }

        for(int i=2;i<primeHash.length;i++) {
            if(primeHash[i] == 0) {
                primes.add(i);
            }
        }
    }
    
    public boolean canTraverseAllPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> primes = new ArrayList<>();
        int max = 0;
        if(nums.length == 1) {
            return true;
        }
        for(int i=0;i<nums.length;i++) {
            max = Integer.max(max, nums[i]);
            if(nums[i] == 1) {
                return false;
            }
        }
        int x = (int)Math.ceil(Math.sqrt(max));
        getPrimes(x, primes);
        DisJointSet ds = new DisJointSet(max+1);
        for(int i=0;i<nums.length;i++) {
            int ind = 0;
            int n = nums[i];
            while(ind < primes.size() && n > 1) {
                if(n % primes.get(ind) == 0) {
                    if(map.containsKey(primes.get(ind)) && map.get(primes.get(ind)) != nums[i]) {
                        ds.addEdge(map.get(primes.get(ind)), nums[i]);
                    }
                    else if(!map.containsKey(primes.get(ind))) {
                        map.put(primes.get(ind), nums[i]);
                    }
                }
                while(n > 1 && n % primes.get(ind) == 0) {
                    n = n / primes.get(ind);
                }
                ind = ind + 1;
            }
            if(n > 1) {
                if(map.containsKey(n) && map.get(n) != nums[i]) {
                        ds.addEdge(map.get(n), nums[i]);
                    }
                    else if(!map.containsKey(n)) {
                        map.put(n, nums[i]);
                    }
            }
        }
        int a = ds.getUltimateParent(nums[0]);
        for(int i=1;i<nums.length;i++) {
            if(a != ds.getUltimateParent(nums[i])) {
                return false;
            }
        }
        
        return true;
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
    public int getUltimateParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = getUltimateParent(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
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