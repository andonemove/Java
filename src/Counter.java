import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Counter {
    public static void main(String[] args) {
        System.out.println("Enter path to the file in format C://Users//Администратор");
        Scanner scanner = new Scanner(System.in);
        String pathname = scanner.nextLine();
        Validator valid = new Validator();
        if (valid.isValidated(pathname)) {
            Counter counter = new Counter();
            counter.countWords(pathname);
            valid.renameFile(pathname);
        }
        else {
            valid.createFile();
            valid.renameFile(pathname);
        }
    }



    public void countWords(String pathName) {
        int count = 0;
        File file = new File(pathName);
        if(file.length() == 0){
            System.out.println("File is empty, fill the file");
        }
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");

        }

        byte[] bytesArray = new byte[(int) file.length()];

        try {
            fis.read(bytesArray);
        } catch (IOException e) {
            System.out.println("Text can not be written");
        }

        String s = new String(bytesArray);

        String[] data = s.split("[-#$%^&!?,.0-9\\\\s]+");

        for (int i = 0; i < data.length; i++) {
            count++;
        }
        try {
            fis.close();
        } catch (IOException e) {
            System.out.println("File can not be closed");
            ;
        }

        System.out.println("Number of characters in the given file are " + count);
    }
}

