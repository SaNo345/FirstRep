package Exe;

import javax.swing.*;
import java.io.IOException;

/**
 * Created by Sano on 21.06.2017.S
 */
public class ExelMain {
    public static void main(String[] args) throws IOException {


        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Display();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });



    

    	
    	

    }


}
