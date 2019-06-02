import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.BufferedReader;

public class FileDuplicator {
    public static void main(String[] args) {
        try {
            boolean create = true;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter Source File Name: ");
            String sourceFileName = reader.readLine();
            File sourceFile = new File(sourceFileName);
            if (!sourceFile.exists()) {
                System.out.println("File Not Found...");
            } else {
                FileInputStream input = new FileInputStream(sourceFileName);
                System.out.print("Enter Target File Name: ");
                String targetFileName = reader.readLine();
                File targetFile = new File(targetFileName);
                if (targetFile.exists()) {
                    System.out.print("File Already Exists. OverWrite it?...Yes/No: ");
                    String confirm = reader.readLine();
                    if (confirm.equalsIgnoreCase("yes")) {
                        create = true;
                    } else {
                        create = false;
                    }
                }
                if (create) {
                    FileOutputStream output = new FileOutputStream(targetFileName);
                    int b;
                    while ((b = input.read()) != -1) {
                        output.write(b);
                    }
                    System.out.println("\nFile Copied...");
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
