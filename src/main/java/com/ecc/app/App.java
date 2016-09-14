package com.ecc.app;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

class App{
    public static void main(String[] args)throws IOException{
        String filename;
        
        if(args.length < 1){
            System.out.println("Please specify a file. Run program as: java Program [filename/filepath]");
            System.exit(0);           
        }
        else if(args.length > 1){
            System.out.println("Multiple files detected.");
            System.exit(0);  
        }
        else if(!Files.exists(Paths.get(args[0]))){
            System.out.println("File not found.");
            System.exit(0);  
        }
        
        filename = args[0];
        TableGenerator tg = new TableGenerator(filename);
	    int choice = 3;

	    do{                
            switch(choice){
                case 1:
                    tg.searchTable();
                    break;
                case 2:
                    tg.editTable();
                    break;
                case 3:
                    break;
                case 4:
                    tg.initTable();
                    break;
                case 5:
                    tg.sortRow();
                    break;
                case 6:
                    tg.addNewRow();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            tg.saveTable();            
            choice = tg.printMenu();	
        }while(choice != 7);
    } 
}
