package assignment02;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ButtonComponent extends JPanel
{
    JButton purpleButton = new JButton("     ");
    JButton redButton = new JButton("     ");
    JButton orangeButton = new JButton("     ");
    JButton greenButton = new JButton("     ");
    JButton yellowButton = new JButton("     ");
    JButton peachButton = new JButton("     ");
    JButton blueButton = new JButton("     ");
    JButton blackButton = new JButton("     ");
    
    PrintWriter outputFile;
 
    public ButtonComponent(PrintWriter outputFile)
    {
        this.outputFile = outputFile;
        setLayout(new GridLayout(3, 3, 4, 4));
        add(purpleButton);
        add(redButton);
        add(orangeButton);
        add(greenButton);
        add(yellowButton);
        add(peachButton);
        add(blackButton);
        add(blueButton);
        addColorAndListeners();
    }
 
    private void addColorAndListeners()
    {
        Edible fruit = new Plum();
        purpleButton.setBackground(fruit.getColor());
        purpleButton.addActionListener(new EdibleListener(fruit));
        fruit = new Strawberry();
        redButton.setBackground(fruit.getColor());
        redButton.addActionListener(new EdibleListener(fruit));
        fruit = new Orange();
        orangeButton.setBackground(fruit.getColor());
        orangeButton.addActionListener(new EdibleListener(fruit));
        fruit = new Grape();
        greenButton.setBackground(fruit.getColor());
        greenButton.addActionListener(new EdibleListener(fruit));
        fruit = new Banana();
        yellowButton.setBackground(fruit.getColor());
        yellowButton.addActionListener(new EdibleListener(fruit));
        fruit = new Peach();
        peachButton.setBackground(fruit.getColor());
        peachButton.addActionListener(new EdibleListener(fruit));
        fruit = new Blackberry();
        blackButton.setBackground(fruit.getColor());
        blackButton.addActionListener(new EdibleListener(fruit));
        fruit = new Blueberry();
        blueButton.setBackground(fruit.getColor());
        blueButton.addActionListener(new EdibleListener(fruit));
    }
    
    // Listener class
    private class EdibleListener 
    	implements ActionListener
    {
        Edible object;

        public EdibleListener(Edible object)
        {
            this.object = object;
        }

        @Override
        public void actionPerformed(ActionEvent arg0)
        {
            JOptionPane.showMessageDialog(ButtonComponent.this, 
                    object.getTaste(outputFile));
        } 
    }
}
