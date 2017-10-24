import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame{
    private JLabel labID = new JLabel("ID:");
    private JLabel labPW = new JLabel("Password:");
    private JTextField texID = new JTextField();
    private JPasswordField texPW = new JPasswordField();
    private JButton butGO = new JButton("GO");
    private JButton butEXIT = new JButton("EXIT");
    private Container  cp;
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private int frmW=300,frmH=150, screenW = dim.width,screenH = dim.height;;
    LoginFrame(){
        initComp();
    }
    private void initComp(){
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setBounds(screenW/2-frmW/2,screenH/2-frmH/2,frmW,frmH);
        cp=this.getContentPane();
        cp.setLayout(new GridLayout(3,2,3,3));
        cp.add(labID);
        cp.add(texID);
        cp.add(labPW);
        cp.add(texPW);
        cp.add(butEXIT);
        cp.add(butGO);
        labID.setHorizontalAlignment(JLabel.CENTER);
        labPW.setHorizontalAlignment(JLabel.CENTER);
        butGO.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(texID.getText().equals("h304")&&new String((texPW.getPassword())).equals("852")){
                   MainFrame mainFrame = new MainFrame();
                   mainFrame.setVisible(true);
                    LoginFrame.this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Error");
                    System.out.println("NO"+texPW.getPassword()+"\tpw");
                }
            }
        });
        butEXIT.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
}