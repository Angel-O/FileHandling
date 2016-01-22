package com.Angelo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.net.URL;
public class Main {

    public static void main(String[] args)  {

	    // get source domain name from keyboard

        Scanner inAddress = new Scanner(System.in);
        System.out.println("Type domain name: \n");


        // errors that might occur:
        // no name is inserted or url does not exist

        String webPrefix = "http://";  // url class requirement...
        String homeDir = "D:/";  // I will notify the user that the file has been created...

        boolean done = false;
        while (!done) {            // keep asking for input until everything is fine
            try
            {
                String domainName = inAddress.next();
                String webAddress = webPrefix + domainName;
                URL location = new URL(webAddress);
                String fileName = domainName + ".txt";

                //reading from web page
                Scanner inLocation = new Scanner(location.openStream());

                // writing to text (or html) file
                PrintWriter out = new PrintWriter(homeDir + fileName);
                while(inLocation.hasNextLine()) {

                    String line = inLocation.nextLine();
                    out.println(line);
                }

                // close Scanner and PrinterWriter

                inLocation.close();
                inAddress.close();
                out.close();

                // notify user
                System.out.println("File created in directory : " + homeDir);
                done = true;
            }
            catch (IOException exception)
            {
                System.out.println("Something went wrong (invalid domain).");
                System.out.println("Type a valid domain name: \n");
            }
        }


        // read and process web page to output

//        while(inLocation.hasNextLine()) {
//
//            String line = inLocation.nextLine();
//            System.out.println(line);
//        }

        //read and process web page to text file





    }
}
