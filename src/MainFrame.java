import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    private JMenuBar  jmb = new JMenuBar();
    private JMenu jme1 = new JMenu("File");
    private JMenu jme2 = new JMenu("竜神の剣を喰らえ");
    private JMenu jme3 = new JMenu(" I've got you in my sights.");
    private JMenuItem jmiFE = new JMenuItem("EXIT");
    private JMenuItem jmiFL = new JMenuItem("絕不會中獎的樂透");
    private JDesktopPane jdp = new JDesktopPane();
    private JInternalFrame jif = new JInternalFrame();
    private int screenW= Toolkit.getDefaultToolkit().getScreenSize().width;
    private int screenH= Toolkit.getDefaultToolkit().getScreenSize().height;
    private int frmW=500,frmH=600;
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
        jmb.add(jme1);
        jmb.add(jme2);
        jmb.add(jme3);
        jme1.add(jmiFE);
        jme1.add(jmiFL);

    }
}
