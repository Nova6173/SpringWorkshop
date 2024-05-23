package se.lexicon.util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ScannerInputService implements UserInputService {

    private Scanner scanner;

    @Autowired
    public ScannerInputService(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public int getInt() {
        while (!scanner.hasNextInt()){
            System.out.println("invalid input. Please enter an integer");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    @Override
    public String getString() {

        return scanner.nextLine();
    }


    @Override
    public String getString(String message) {

        System.out.println("message");
        return scanner.nextLine();
    }

    @Override
    public int getInt(String message) {

        System.out.println("message");
        return scanner.nextInt();
    }


}






