package games;

import java.awt.Container;
import java.awt.Event;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;


public class Snake extends JFrame {

    public Snake() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new Board());
        
        setResizable(false);
        pack();
        
        setTitle("El juego de serpiente");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();

         JMenuBar menuBar;
        
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(makeFileMenu());
       
    }
    
    private JMenu makeFileMenu()
    {
        JMenu menu;
        JMenuItem menuItem;        // set up the File menu
        menu = new JMenu("Archivo");
        menu.setMnemonic(KeyEvent.VK_F);
        // add New menu item
        menuItem = new JMenuItem("Juego nuevo");
        menuItem.setMnemonic(KeyEvent.VK_N);
        menuItem.addActionListener(new NewListener());
        menuItem.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_N,
                                       Event.CTRL_MASK));
        menu.add(menuItem);
        return menu;
    }
    private class NewListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        	EventQueue.invokeLater(() -> {
                JFrame ex = new Snake();
                ex.setVisible(true);
        	});
        }
    }
    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            JFrame ex = new Snake();
            ex.setVisible(true);
        });
    }
}