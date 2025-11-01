package Graphs.ConnectedComponents;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AccountsMerge {
   class DisJointSet {
        int parent[];
        int rank[];

        DisJointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int findUPar(int node) {
            if (node == parent[node]) {
                return node;
            }
            return parent[node] = findUPar(parent[node]);
        }

        public void unionByRank(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if (ulp_u == ulp_v)
                return;
            if (rank[ulp_u] < rank[ulp_v]) {
                parent[ulp_u] = ulp_v;
            } else if (rank[ulp_v] < rank[ulp_u]) {
                parent[ulp_v] = ulp_u;
            } else {
                parent[ulp_v] = ulp_u;
                rank[ulp_u]++;
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisJointSet ds = new DisJointSet(n);
        Map<String, Integer> emailToNode = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (!emailToNode.containsKey(email)) {
                    emailToNode.put(email, i);
                } else {
                    ds.unionByRank(i, emailToNode.get(email));
                }
            }
        }
        Map<Integer, Set<String>> mergedEmails = new HashMap<>();
        for (Map.Entry<String, Integer> entry : emailToNode.entrySet()) {
            String email = entry.getKey();
            int node = entry.getValue();
            int parentNode = ds.findUPar(node);
            mergedEmails.putIfAbsent(parentNode, new HashSet<>());
            mergedEmails.get(parentNode).add(email);
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, Set<String>> entry : mergedEmails.entrySet()) {
            int node = entry.getKey();
            Set<String> emailsSet = entry.getValue();
            List<String> emailsList = new ArrayList<>(emailsSet);
            emailsList.sort(String::compareTo);
            emailsList.add(0, accounts.get(node).get(0));
            result.add(emailsList);
        }
        return result;
    }
    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        accounts.add(Arrays.asList("Mary", "mary@mail.com"));

        System.out.println(new AccountsMerge().accountsMerge(accounts));
    }
}
