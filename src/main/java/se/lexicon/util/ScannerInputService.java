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
    public String getString(String message) {
        return scanner.nextLine();
    }

    @Override
    public int getInt(String message) {
        return scanner.nextInt();
    }





}
