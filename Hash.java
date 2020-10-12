import java.util.Scanner;

public class Hash {
    List[] arrayLists;


    Hash(int size) {
        arrayLists = new List[size % 100];
        for(int i = 0; i < arrayLists.length; i++) {
            arrayLists[i] = new List();
        }
    }

    int hashFunc(int key) {
        return key % arrayLists.length;
    }

    void push(int key, String data) {
        arrayLists[hashFunc(key)].add(key, data);
    }

    void delete(int key) {
        arrayLists[hashFunc(key)].delete(key);
    }

    String show(int key) {
        return arrayLists[hashFunc(key)].show(key);
    }
}
