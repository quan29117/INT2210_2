import HashTable.SeparateChaining;

public class Main {
    public static void main(String[] args) {
        SeparateChaining<Character, Integer> hash1 = new SeparateChaining<>(5);
        hash1.put('S', 0);
        hash1.put('E', 1);
        hash1.put('A', 2);
        hash1.put('X', 7);
        hash1.print();
        hash1.delete('X');
        hash1.print();
    }
}