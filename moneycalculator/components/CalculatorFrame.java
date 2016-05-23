package moneycalculator.components;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import moneycalculator.control.Command;

public class CalculatorFrame extends JFrame {
    
    public CalculatorFrame(){
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("money calculator");        
        createLayout();        
    }
    
    public void addPanel(JPanel panel) {
        getContentPane().add(panel);
    }

    public void start(Command command) {
        createCalculateButton(command);
        setSize(400,500);
        setVisible(true);
    }

    private void createLayout() {
        Container container = getContentPane();
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
    }

    private void createCalculateButton(final Command command) {
        JButton button = new JButton("Calculate");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                command.execute();
            }
        });
        getContentPane().add(button);
    }

}

