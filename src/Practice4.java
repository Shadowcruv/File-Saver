import java.io.*;
import java.util.*;
class Practice4 {
    private static enum Response {YES, NO}

    private FileManager fileManager;
    private SubClasse builder;
    private Scanner scanner;

    public Practice4(){
        scanner = new Scanner(System.in);
        fileManager = new FileManager();
        builder = new SubClasse();
    }

    public static void main(String[] args) {
        Practice4 nain = new Practice4();
        nain.start();
    }

    private String build(String document) {
        String concordance;
        concordance = builder.build(document);
        return concordance;
    }

    public String inputFile() {
        String doc = "";
        try {
            doc = fileManager.openFile();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Error in opening file: " + e.getMessage());
        }
        System.out.println("Input Document:\n" + doc); //TEMP
        return doc;
    }

    private void saveFile(String list) {
        try {
            fileManager.saveFile(list);
        } catch (IOException e) {
            System.out.println("Error in saving file: " + e.getMessage());
        }
    }

    private void start() {
        Response userReply;
        String document, wordList;
        while (true) {
            userReply = prompt("Run the program?");
            if (userReply == Response.NO) {
                break;
            }
            document = inputFile(); //open file
            System.out.println("testing.....");
            wordList = build(document); //build concordance
            saveFile(wordList);


        }

    }
    private Response prompt(String question) {
        String input;
        Response response = Response.NO;
        System.out.print(question + " (Yes - y; No - n): ");
        input = scanner.nextLine();
        if (input.equals("Y") || input.equals("y")) {
            response = Response.YES;
        }
        return response;
    }

}