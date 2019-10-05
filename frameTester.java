import java.io.*;
import java.awt.*;
public class frameTester{
    public static void main(String args[]){
        Frame f =  new Frame();
        Button b = new Button("this is button");
        b.setBounds(100,100,100,100);
        f.add(b);
        Button b2 = new Button("this is button");
        b2.setBounds(100,10,100,100);
        f.add(b2);
        f.setVisible(true);
    }
}