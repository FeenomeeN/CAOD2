import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Hash hashMap;


    public static void main(String[] args) throws IOException {
        mainInstructions();
        getData();
        workMethod();
    }

    static void mainInstructions() {
        System.out.println("Enter 1, if you want to add element.");
        System.out.println("Enter 2, if you want to delete element.");
        System.out.println("Enter 3, if you want to see data in the element.");
        System.out.println("Enter 0, if you want out.");
    }

    static void getData() throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("D:\\HashMap\\src\\data.txt"));
        hashMap = new Hash(checkLines(bf));
        bf.close();
        bf = new BufferedReader(new FileReader("D:\\HashMap\\src\\data.txt"));
        String str = "";
        String[] line;
        while((str = bf.readLine()) != null) {
            line = str.split("\\s+");
            hashMap.push(Integer.parseInt(line[0]), line[1]);
        }
        bf.close();
    }

    static void workMethod() {

        int command;
        while((command = inputCommand(userInput())) != 0) {
            switch (command) {
                case 1 :
                    System.out.println("Enter key and data: ");
                    int key = Integer.parseInt(userInput());
                    String data = userInput();
                    hashMap.push(key, data);
                    break;
                case 2 :
                    System.out.println("Enter key you want to delete: ");
                    hashMap.delete(Integer.parseInt(userInput()));
                    break;
                case 3 :
                    System.out.println("Enter key you want to see: ");
                    System.out.println(hashMap.show(Integer.parseInt(userInput())));
                    break;
            }
            mainInstructions();
        }
    }

    static int checkLines(BufferedReader bf) throws IOException {
        int count = 0;
        while(bf.readLine() != null) {
            count++;
        }
        return count;
    }

    static int inputCommand(String input) {
        int number = Integer.parseInt(input);
        if(number < 0 || number > 3) {
            System.out.println("Invalid command, try again.");
            return inputCommand(userInput());
        }
        return number;
    }

    static String userInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
