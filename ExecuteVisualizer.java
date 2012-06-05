/*
 * FINAL PROJECT: Beat Visualizer
 * AUTHORS:       Susana C Delgadillo, ****** ****
 * DATE:          5/5/2010
 *
 */

package beat_visualizer;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ExecuteVisualizer extends JFrame
{
    // Create ExecuteVisualizer frame components
    private JButton jbtStart = new JButton("Start!");
    private JLabel label = new JLabel("Welcome to Beat Visualizer.");
    String rules = "Welcome. "
            + "\nThe purpose of this program is to view 10 'beats,' all of "
            + "which you (the user), create. Please read the instructions before "
             +"clicking the 'Start!' button."
            + "\n\n\nInstructions:"
            + "\n\nAfter clicking 'Start!,' the Options, Color selection" +
            " and Beat visualizer windows will appear. " +
            "\n\n1. Using the first drop-down menu in the Options window, " +
            "select a beat." +
            "\n\n2. On the Options and Color selection windows, choose the desired" +
            " size, shape, color, fill, frequency and name for the beat " +
            " that is currently selected." +
            "\n*Do this for as many of the beats as you wish. You may " +
            " leave the properties of all the beats unchanged, if you wish." +
            "\n**The Beat visualizer window is resizable in order to accomodate" +
            " large shapes."
            + "\n\n3. When you're satisfied with your beats, go to the 'Beats " +
            "visualized' window." +
            "\n\n4. Select the beats that you want to view." +
            "\n\n5. Click on the 'Play selected beats' button. The selected beats" +
            " will play continuously until you hit stop. You can choose to view " +
            "a new set of beats simply by unchecking those you do not want to " +
            "see, checking those you do want to see and again clicking the " +
            " Play button." +
            "\nNOTE: You can change the properties of your beats at anytime," +
            "even when they're playing. The changes will be reflected" +
            "immediately.";
    private JTextArea jtaInstructions = new JTextArea(rules);

    // Create Options window
    private Options optionsFrame = new Options();

    // Create VisualizerFrame window
    private VisualizerFrame vFrame = new VisualizerFrame();

    // Create ColorChoose window
    private JFrame colorChooser = new JFrame("Color selection");
    
    public ExecuteVisualizer()
    {
        //Set textarea properties
        jtaInstructions.setWrapStyleWord(true);
        jtaInstructions.setLineWrap(true);
        jtaInstructions.setEditable(false);
        
        // Set ExecuteVisualizer frame layout and add components to the frame
        setLayout(new BorderLayout (5,10));
        add(jtaInstructions, BorderLayout.CENTER);
        add(jbtStart, BorderLayout.SOUTH);

        // Set Options frame attributes
        optionsFrame.setSize(250, 350);
        optionsFrame.setTitle("Options");
        optionsFrame.setResizable(false);
        optionsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set VisualizerFrame attributes
        vFrame.setSize(800,475);
        vFrame.setTitle("Beats visualized");
        vFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vFrame.setLocationRelativeTo(null);

        // Set colorChoose frame attributes
        colorChooser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ColorChooser newContentPane = new ColorChooser();
        newContentPane.setOpaque(true); //content panes must be opaque
        colorChooser.setContentPane(newContentPane);
        colorChooser.setResizable(false);


        // Add listener to button which will open Options, VisualizerFrame
        // and colorChoose frame, and close the current frame
        jbtStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                optionsFrame.setVisible(true);
                vFrame.setVisible(true);
                colorChooser.pack();
                colorChooser.setVisible(true);
                dispose();

            }
        });
    }

    public static void main(String[] args)
    {
        // Create new ExecuteVisualizer frame
        ExecuteVisualizer frame = new ExecuteVisualizer();

        // Set ExecuteVisualizer frame attributes and display
        frame.setSize(450, 550);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Beat Visualizer: Welcome");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }

}

