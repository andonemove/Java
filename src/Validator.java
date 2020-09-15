import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Validator {
    Scanner scanner= new Scanner(System.in);
    public boolean isValidated(String pathname) {
        boolean isValidate = false;
        File dir = new File(pathname);
        if (dir.isFile()) {
            System.out.println("This is a file,OK?");
            isValidate = true;
            return isValidate;
        } else if (dir.isDirectory()) {
            System.out.println("This is a directory,OK?");
            isValidate = true;
            return isValidate;
        }
        return isValidate;
    }

    public void createFile(){
        System.out.println("File that you chose is not found, do you want to create new file?");
        System.out.println("Write Yes/No");
        if(scanner.nextLine().equals("Yes")){
            System.out.println("Write the pathname to the directory to create file in it");
            String pathName=scanner.nextLine();
            if(isValidated(pathName)){
                File newFile = new File(pathName);
                boolean created = false;
                try {
                    created = newFile.createNewFile();
                } catch (IOException e) {
                    System.out.println("File can not be create");
                }
                if(created)
                    System.out.println("File has been created");
                System.out.println("Delete fail after counting? Write Yes/No");
                if (scanner.nextLine().equals("Yes")){
                    newFile.delete();
                }
                else {
                    System.out.println("File would be saved");
                }
            }

        }
       else if(scanner.nextLine().equals("No")){
            System.out.println("Good bay");
        }

    }

    public void renameFile(String pathname){
        File file;
        System.out.println("Do you want to rename file? Write Yes/No");
        if (scanner.nextLine().equals("Yes")){
            file=new File(pathname);
            System.out.println("Enter new file name");
            file.renameTo(new File((scanner.nextLine())));
        }
    }



}
