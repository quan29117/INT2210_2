package Vebo;

import java.util.*;

public class StartUp {
    public static class Company {
        Integer index;
        Integer profit;

        public Company(Integer index, Integer profit) {
            this.index = index;
            this.profit = profit;
        }
    }

    public static class CompanyComparator implements Comparator<Company> {
        @Override
        public int compare(Company o1, Company o2) {
            if (o1.profit.compareTo(o2.profit) != 0)
                return o1.profit.compareTo(o2.profit);
            else return o1.index.compareTo(o2.index);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int queries = sc.nextInt();

        Comparator comp = new CompanyComparator();
        long totalProfit = 0;

        PriorityQueue<Company> companies = new PriorityQueue<>(comp);
        SortedSet<Integer> indexArr = new TreeSet<>();

        for (int i = 1; i < queries; i++) {
            int k = sc.nextInt();
            switch (k) {
                case 1 -> {
                    int u = sc.nextInt();
                    totalProfit += u;
                    companies.add(new Company(i, u));
                    indexArr.add(i);
                }

                case 2 -> {
                    int v = sc.nextInt();
                    if (v == 0) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                    while (companies.size() >= v) {
                        Company tmp = companies.poll();
                        totalProfit -= tmp.profit;
                        indexArr.remove(tmp.index.intValue());
                    }
                }
            }
        }

        sc.nextInt();
        int v = sc.nextInt();
        if (companies.size() < v) {
            System.out.println(-1);
        } else {
            System.out.println(totalProfit);
            for (Integer ele : indexArr) {
                System.out.print(ele + " ");
            }
        }
    }
}
