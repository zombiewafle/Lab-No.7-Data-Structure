import Classes.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main{
    public static void main(String[] args){
        boolean go1 = false;
        boolean go2 = false;
        Scanner sc = new Scanner(System.in);
        BST bt = new BST();
        String[] divideWords;
        ArrayList<Association> translatedWords = new ArrayList<>();
        ArrayList<Association> dictionary= new ArrayList<>();
        boolean isInTheBinaryTree = false;
        //-----------------------------------------------
        //All the menu's of the program
        String fileMenu = ">> Menu: \n "+
                ">> Welcome, please enter a txt file: ";

        String menu = ">> Menu: \n"+
                "\n>> 1. Show all the content of the dictionary\n"+
                "\n>> 2. Translate the txt file\n"+
                "\n>> 3. Search for a word\n"+
                "\n>> 4. Exit";
        //-----------------------------------------------
        //Section of the program that reads the txt file that the user insert
        ArrayList<Association> dictionaryText = new ArrayList<>();
        BufferedReader input = null;
        boolean file = false;
        boolean file2 = false;
        System.out.println("Please insert the txt file that contains the words");
        String wordsPath = sc.nextLine();
        String nm;


        try{
            input = new BufferedReader(new FileReader(wordsPath ));
            while((nm = input.readLine())!= null){
                file2 = true;
                String[] split = wordsPath .split(",");
                String key = split[0];
                String value = split[1];
                dictionaryText.add(new Association(key.toLowerCase(), value.toLowerCase()));
            }
        }catch (Exception e){
            file2 = false;
            System.out.println("No file was found");
        }

        System.out.println("Please enter the path of the file that you what to translate");
        String dictionaryPath = sc.nextLine();
        try{
            input = new BufferedReader(new FileReader(dictionaryPath));

        }catch(Exception e){
            file = false;
            System.out.println("No file was found");
        }


        for(int i  = 0; i< dictionary.size(); i++){
            dictionary.add(dictionaryText.get(i));
        }

        //-----------------------------------------------
        //The menu will open only if the dictionary file was entered
        if(file == true && file2 == true){
            while(go2 == true) {
                System.out.println(">> Please enter a valid option\n");
                System.out.println(">> -----------------------------------------------");
                System.out.println(">> ");
                System.out.println(menu);
                System.out.println(">> ");
                System.out.println(">> -----------------------------------------------");
                String opMenu = ">> " + sc.nextLine();
                switch (Integer.parseInt(opMenu)) {
                    case 1:
                        System.out.println(">> Printing all the dictionary");
                        System.out.println(">> ...........................");
                        bt.inOrderTree(dictionary.get());
                        go2 = true;
                        break;

                    case 2:
                        System.out.println(">> Translating all the file");
                        System.out.println(">> ........................");
                        String translate = "";
                        isInTheBinaryTree = true;
                        break;

                    case 3:
                        System.out.println(">> Please enter a word\n");
                        String word = ">> " + sc.nextLine();
                        System.out.println(">> ...................");
                        bt.searchNode(word);
                        go2 = true;
                        break;
                    case 4:
                        System.out.println(">> .........");
                        System.out.println(">> Goodbye\n");
                        go2 = false;
                        break;
                    default:
                        System.out.println(">> Error, please enter a valid option\n");
                }
            }
        }
    }
}