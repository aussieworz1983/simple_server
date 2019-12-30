import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {

public static void main(String[] args){
System.out.println("Initializing apllication");


Gui();


}
public static void Gui() {
JFrame frame = new JFrame();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JButton btn1 = new JButton("button 1");
JButton btn2 = new JButton("button 2");



//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//frame.setUndecorated(true);
frame.setLayout(new FlowLayout());
frame.setSize(320,240);
frame.setVisible(true);

//btn1.setPreferredSize(new Dimension(30,30));

frame.add(btn1);
frame.add(btn2);
btn1.addActionListener(new ActionListener() {
  @Override
  public void actionPerformed(ActionEvent e){
    
      Send("action=on");
    
  }
});

}
public static void Send(String params){
Server server = new Server();
try{
server.StartServer(params);

}catch(Exception e){
   System.out.println("error:"+e);
}
}
}
