import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    private JMenuBar  jmb = new JMenuBar();
    private JMenu jme1 = new JMenu("File");
    private JMenu jme2 = new JMenu("settings");
    private JMenu jme3 = new JMenu(" I've got you in my sights.");
    private JMenuItem jmiFE = new JMenuItem("EXIT");
    private JMenuItem jmiFL = new JMenuItem("絕不會中獎的樂透");
    private JMenuItem jtStyle = new JMenuItem("Font");
    private JDesktopPane jdp = new JDesktopPane();
    private JInternalFrame jif = new JInternalFrame();
    private JPanel pan1 = new JPanel(new GridLayout(2,3,5,5));
    private String[] Options = {"PLAIN","BOLD","ITALIC","BOLD+ITALIC"};
    private JComboBox jbstyle= new JComboBox(Options);
    private JLabel lab1 = new JLabel("字型");
    private JLabel lab2 = new JLabel("字體");
    private JLabel lab3 = new JLabel("大小");
    private JTextField jt1 = new JTextField("楷書");
    private JTextField jt2 = new JTextField("16");
    private int screenW= Toolkit.getDefaultToolkit().getScreenSize().width;
    private int screenH= Toolkit.getDefaultToolkit().getScreenSize().height;
    private int frmW=500,frmH=600;



    private JMenuBar jmb2 = new JMenuBar();
    private JMenu jdata = new JMenu("Data");
    private JMenuItem jmiLoad = new JMenuItem();
    private JMenuItem jmiNew = new JMenuItem();
    private JMenuItem jmiClose = new JMenuItem();
    private JFileChooser jfc = new JFileChooser();
    private JTextArea jta = new JTextArea();
    MainFrame(){
        initComp();
    }
    private void initComp(){
        this.setBounds(screenW/2-frmW/2,screenH/2-frmH/2,frmW,frmH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setJMenuBar(jmb);
        this.setContentPane(jdp);
        jmiFE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jmiFE.setAccelerator(KeyStroke.getKeyStroke('X',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        jmiFL.setAccelerator(KeyStroke.getKeyStroke('G',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        jif.setBounds(0,0,200,80);
        jmiFL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jdp.add(jif);
                jif.setVisible(true);
            }
        });
        jtStyle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(MainFrame.this,
                        pan1,"Font Setting",
                        JOptionPane.OK_CANCEL_OPTION);
                int FontStyle=0;
                switch(jbstyle.getSelectedIndex()){
                    case 0:
                        FontStyle=Font.PLAIN;
                    case 1:
                        FontStyle=Font.BOLD;
                    case 2:
                        FontStyle=Font.ITALIC;
                    case 3:
                        FontStyle=Font.BOLD+Font.ITALIC;

            }
             if (result==JOptionPane.OK_OPTION){
                    UIManager.put("Meun.font",new Font(jt1.getText(),FontStyle,Integer.parseInt(jt2.getText())));
             }
            }
        });

        jmb.add(jme1);
        jmb.add(jme2);
        jmb.add(jme3);
        jme1.add(jmiFE);
        jme1.add(jmiFL);
        jme2.add(jtStyle);

        pan1.add(lab1);
        pan1.add(lab2);
        pan1.add(lab3);
        pan1.add(jt1);
        pan1.add(jbstyle);
        pan1.add(jt2);


    }
}
