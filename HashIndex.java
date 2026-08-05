
import java.util.Scanner;

public class HashIndex {

    // Same logic as your Python function
    public static int hashIndex(int key, int tableSize) {
        return key % tableSize;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter key: ");
        int key = sc.nextInt();

        System.out.print("Enter table size: ");
        int tableSize = sc.nextInt();

        int index = hashIndex(key, tableSize);
        System.out.println("Hash Index = " + index);

        sc.close();
    }
}
