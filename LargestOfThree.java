import java.awt.*; 
import java.awt.event.*; 
import java.applet.*; 

public class LargestOfThree extends Applet implements ActionListener
{
	Button b1,b2;
	TextField t1,t2,t3,t;
	String s1;
        Label l1,l2,l3,l;
	public void init() {
                b2=new Button("Replace");
		l1 = new Label("Number 1"); 
		add(l1); 
                t1=new TextField(10); 
                add(t1); 
                l2=new Label("Number 2"); 
                add(l2); 
                t2=new TextField(10); 
                add(t2); 
                l3=new Label("Number 3"); 
                add(l3); 
                t3=new TextField(10); 
                add(t3);
		l = new Label("To find Largest of three press this button");
                b2=new Button("Find"); 
		add(l);
                add(b2);
		t=new TextField(10); 
                add(t); 
                b2.addActionListener(this); 
  	}
 	public void actionPerformed(ActionEvent e) 
                   { 
                     int num1,num2,num3,num;
				num1=Integer.parseInt(t1.getText()); 
				num2=Integer.parseInt(t2.getText()); 
				num3=Integer.parseInt(t3.getText()); 
				num=-1;
                          if(e.getSource()==b2) 
                            { 
                                
				if(num1 >= num2 && num1 >= num3){
				num = num1;
				}
				else if(num2 >= num1 && num2 >= num3){
				num = num3;
				}
				else if(num3 >= num2 && num3 >= num1){
				num = num3;
				}
                            }
				t.setText(String.valueOf(num));
                    } 
}

/* <applet code=LargestOfThree width=400 height=400>
</applet>
*/