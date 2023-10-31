package SortingAlgorithm;

public class MergeSort {
    private static boolean less(Comparable a, Comparable b) {
        if (a.compareTo(b) < 0) {
            return true;
        }
        return false;
    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
//                a[k] = aux[j++];
                aux[k] = a[j++];
            else if (j > hi)
//                a[k] = aux[i++];
                aux[k] = a[i++];
            else if (less(aux[i], aux[j]))
//                a[k] = aux[j++];
                aux[k] = a[j++];
            else
//                a[k] = aux[i++];
                aux[k] = a[i++];
        }
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi < lo) return;
        int mid = lo + (hi - lo) / 2;
//        sort(a, aux, lo, mid);
//        sort(a, aux, mid + 1, hi);
        sort(aux, a, lo, mid);
        sort(aux, a, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }
}
