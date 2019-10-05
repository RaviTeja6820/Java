import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javafx.scene.control.CheckBox;
public class Form extends Frame implements ActionListener{
    public TextField Response; 
    Form(){
        setSize(500,500);
        setLayout(new BorderLayout());
        Font font1 = new Font("Arial",Font.BOLD,30);
        Panel pform = new Panel();
        pform.setFont(font1);
        Label lform = new Label("Form",Label.CENTER);
        pform.add(lform);
        add(pform,BorderLayout.NORTH);
        Panel form = new Panel();
        font1 = font1.deriveFont(Font.PLAIN, 20);
        form.setFont(font1);
        Label name = new Label("Name :",Label.LEFT);
        TextField nameTA = new TextField(25);
        form.add(name);
        form.add(nameTA);
        name.setBounds(20, 30, 20, 20);
        Label Roll_No = new Label("Roll_No. :",Label.LEFT);
        TextField rollTF = new TextField(25);
        form.add(Roll_No);
        form.add(rollTF);
        Roll_No.setBounds(20, 30, 20, 20);
        Label Institute = new Label("Institute :",Label.LEFT);
        Choice IC = new Choice();
        IC.add("GIT");
        IC.add("GIS");
        IC.add("GIM");
        IC.setBounds(20, 30, 60 , 20);
        Label InstituteR = new Label("                                             ",Label.RIGHT);
        form.add(Institute);
        form.add(IC);
        form.add(InstituteR);
        Label Batch = new Label("Batch :",Label.LEFT);
        TextField BatchTF = new TextField(25);
        Batch.setBounds(20, 30, 20, 20);
        form.add(Batch);
        form.add(BatchTF);
        Button submit = new Button("Submit");
        submit.addActionListener(this);
        form.add(submit);
        Response = new TextField(25);
        form.add(Response);
        add(form);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
            if(ae.getActionCommand().equals("Submit")){
                Response.setText("true");
            }
    }
    public static void main(String args[]){
        new Form();
    }
}