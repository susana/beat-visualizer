/*
 * FINAL PROJECT: Beat Visualizer
 * AUTHORS:       Susana C Delgadillo, ****** ****
 * DATE:          5/5/2010
 *
 */

package beat_visualizer;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Options extends JFrame
{
    // Array to hold 10 beats
    final static int LENGTH = 10;
    static Beat[] beatArray = new Beat[LENGTH];

    //  Static int to indicate what beat is currently being handled
    static int currentBeat;

    // mainPanel will hold all components described below
    private JPanel mainPanel;

    // Beat comboBox allows user to choose which premade beat they want to alter
    private JComboBox jcboChooseBeat;
    private String[] beatChoice = {"Beat 1", "Beat 2", "Beat 3", "Beat 4", 
    "Beat 5", "Beat 6", "Beat 7", "Beat 8", "Beat 9", "Beat 10"};
    
    // Shape comboBox holds 4 shape choices and records the shape according to
    // its corresponding index
    private JComboBox jcboChooseShape;
    private String[] shapeChoice = {"Pick a shape", "Line", "Rectangle",
        "Round-Rectangle", "Oval"};

    // Frequency comboBox shows 20 different frequencies
    private JComboBox jcboFrequency;
    private String[] pickFrequency = {"Frequency in seconds", ".1s", ".2s", 
        ".3s", ".4s", ".5s", ".6s", ".7s", ".8", ".9s", "1s", "2s", "3s", "4s",
        "5s", "6s", "7s", "8", "9s", "10s",};
    private int newTimerDelay;

    // Fill panel holds group of radio buttons that indicate fill or no fill
    private JPanel jpIsFilled;
    private ButtonGroup fillGroup;
    private JRadioButton jrbFill;
    private JRadioButton jrbNoFill;

    // beatSize panel with 2 textfields for height and width
    private JPanel jpSize;
    private JTextField jtfHeight;
    private JTextField jtfWidth;

    // nameBeat panel with textfield for beat name
    private JPanel jpBeatName;
    private JTextField jtfBeatName;

    public Options()
    {
        // Populate array with generic beats
        for (int i = 0; i < LENGTH; i++)
        {
        beatArray[i] = new Beat();
        }

        /* *************** MAIN PANEL *************** */
        // Create mainPanel that will hold all components
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setLayout(new GridLayout (8,1));


        /* *************** BEAT *************** */
        jcboChooseBeat = new JComboBox(beatChoice);
        jcboChooseBeat.setSelectedItem(1);
        jcboChooseBeat.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                currentBeat = jcboChooseBeat.getSelectedIndex();
            }
        });
        mainPanel.add(jcboChooseBeat);

        
        /* *************** SHAPE *************** */
        jcboChooseShape = new JComboBox(shapeChoice);
        jcboChooseShape.setSelectedItem("Pick a shape");
        jcboChooseShape.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                beatArray[currentBeat].setShape(jcboChooseShape.getSelectedIndex());
                VisualizerFrame.displayPanel.repaint();
            }
        });
        mainPanel.add(jcboChooseShape);
        

        /* *************** SIZE *************** */
        jpSize = new JPanel();
        jpSize.setLayout(new GridLayout(2,1));
        jpSize.add(new JLabel("Enter shape height: "));
        jtfHeight = new JTextField("100");
  jpSize.add(jtfHeight);

        jpSize.setLayout(new GridLayout(2,1));
  jpSize.add(new JLabel("Enter shape width: "));
        jtfWidth = new JTextField("100");
  jpSize.add(jtfWidth);

        jtfHeight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String h = (jtfHeight.getText());
                beatArray[currentBeat].setBeatHeight(Integer.parseInt(h));
                VisualizerFrame.displayPanel.repaint();
            }
        });
        jtfWidth.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String w = (jtfWidth.getText());
                beatArray[currentBeat].setBeatWidth(Integer.parseInt(w));
                VisualizerFrame.displayPanel.repaint();
            }
        });
        mainPanel.add(jpSize);


        /* *************** FILL *************** */
        jpIsFilled = new JPanel();
        jrbFill = new JRadioButton("Fill");
        jrbNoFill = new JRadioButton("No Fill");
        jpIsFilled.add(jrbFill);
        jpIsFilled.add(jrbNoFill);
        fillGroup = new ButtonGroup();
        fillGroup.add(jrbFill);
        fillGroup.add(jrbNoFill);

        jrbFill.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                beatArray[currentBeat].setFilled(true);
                VisualizerFrame.displayPanel.repaint();
            }
        });

        jrbNoFill.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                beatArray[currentBeat].setFilled(false);
                VisualizerFrame.displayPanel.repaint();
            }
        });
        mainPanel.add(jpIsFilled);


        /* *************** FREQUENCY *************** */
        jcboFrequency = new JComboBox(pickFrequency);
        jcboFrequency.addItemListener (new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                System.out.println(jcboFrequency.getSelectedIndex());
                beatArray[currentBeat].setFrequency(jcboFrequency.getSelectedIndex());
                newTimerDelay = beatArray[currentBeat].getFrequency();
                beatArray[currentBeat].timer.setDelay(newTimerDelay);
            }
        });
        mainPanel.add(jcboFrequency);


        /* *************** NAME *************** */
        jpBeatName = new JPanel();
        jpBeatName.setLayout(new GridLayout(2,1));
        jpBeatName.add(new JLabel("Name Your Beat"));
        jtfBeatName = new JTextField("Beat name");
        jpBeatName.add(jtfBeatName);
        jtfBeatName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                beatArray[currentBeat].setBeatName(jtfBeatName.getText());
                VisualizerFrame.checkBoxArray[currentBeat].setText(
                        jtfBeatName.getText());
            }
        });
        mainPanel.add(jpBeatName);

        // Add mainPanel to frame
        add(mainPanel);
    }

}

