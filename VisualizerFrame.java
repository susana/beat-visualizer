/*
 * FINAL PROJECT: Beat Visualizer
 * AUTHORS:       Susana C.Delgadillo, ****** ****
 * DATE:          5/5/2010
 *
 */

package beat_visualizer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class VisualizerFrame extends JFrame
{
    // Length of beat array
    private final static int LENGTH = 10;

    // Array to hold checkboxes
    static JCheckBox[] checkBoxArray = new JCheckBox[LENGTH];

    // mainPanel to hold all components
    private JPanel mainPanel;

    // displayPanel, where the beats will be shown
    protected static JPanel displayPanel;

    // beatListPanel to hold checkboxes and playButton
    private JPanel beatListPanel;

    // playButton when clicked, plays all selected beats
    private JButton playButton;

    //stopButton when clicked stops beat animations
    private JButton stopButton;


    public VisualizerFrame()
    {
        /* *************** MAIN PANEL *************** */
        // Create mainPanel to hold displayPanel and beatListPanel
         mainPanel = new JPanel(new BorderLayout());

        
        /* *************** DISPLAY PANEL *************** */
        // Create displayPanel to hold and display beat objects
        displayPanel = new JPanel(new BorderLayout());
        displayPanel.setLayout(new GridLayout(2,5));
        // Add already created beats to displayPanel
        for (int i = 0; i < LENGTH; i++)
        {
            displayPanel.add(Options.beatArray[i]);
        }
        // Add displayPanel to mainPanel
        mainPanel.add(displayPanel, BorderLayout.CENTER);


        /* *************** BEAT LIST PANEL *************** */
        // Create panel for checkboxes and play button
        beatListPanel = new JPanel(new BorderLayout());
        beatListPanel.setLayout(new GridLayout(13, 1));

        //Create checkBoxes, add to checkBoxArray and add to beatListPanel
        for (int i = 0; i < LENGTH; i++)
        {
            int num = i + 1;
            checkBoxArray[i] = new JCheckBox("Beat " + num);
            beatListPanel.add(checkBoxArray[i]);
        }

        // Register listeners for each checkbox which will indicated
        // whether beat is selected or not
        checkBoxArray[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Options.beatArray[0].setSelected(checkBoxArray[0].isSelected());
            }
        });

        checkBoxArray[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Options.beatArray[1].setSelected(checkBoxArray[1].isSelected());
            }
        });

        checkBoxArray[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Options.beatArray[2].setSelected(checkBoxArray[2].isSelected());
            }
        });

        checkBoxArray[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Options.beatArray[3].setSelected(checkBoxArray[3].isSelected());
            }
        });

        checkBoxArray[4].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Options.beatArray[4].setSelected(checkBoxArray[4].isSelected());
            }
        });

        checkBoxArray[5].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Options.beatArray[5].setSelected(checkBoxArray[5].isSelected());
            }
        });

        checkBoxArray[6].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Options.beatArray[6].setSelected(checkBoxArray[6].isSelected());
            }
        });

        checkBoxArray[7].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Options.beatArray[7].setSelected(checkBoxArray[7].isSelected());
            }
        });

        checkBoxArray[8].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Options.beatArray[8].setSelected(checkBoxArray[8].isSelected());
            }
        });

        checkBoxArray[9].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Options.beatArray[9].setSelected(checkBoxArray[9].isSelected());
            }
        });


        /* ****** PLAY BUTTON ****** */
        // Create play button and add to beatListPanel
        playButton = new JButton("Play selected beats");
        beatListPanel.add(playButton);

        // Register listener for play button: When button is clicked, the
        // displayPanel is cleared. Any beats that have been selected will
        // repopulate the displayPanel with their timers started. Beats
        // displayed will pulse/blink according to their frequencies.
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < LENGTH; i++)
                {
                    if (Options.beatArray[i].isSelected() == true)
                    {
                        Options.beatArray[i].setVisible(true);
                        Options.beatArray[i].timer.restart();
                    }
                    else
                    {
                        Options.beatArray[i].setVisible(false);
                    }
                    displayPanel.repaint();
                }
            }
        });

        /* ****** STOP BUTTON ****** */
        // Create stop button and add to beatListPanel
        stopButton = new JButton("Stop");
        beatListPanel.add(stopButton);

        // Register listener for stop button. Stops the timer on all the Beat
        // objects, makes all beats visible and repaints the displayPanel
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < LENGTH; i++)
                {
                    Options.beatArray[i].timer.stop();
                    Options.beatArray[i].setVisible(true);
                }
                displayPanel.repaint();
            }
        });

        // Add beatListPanel to mainPanel
        mainPanel.add(beatListPanel, BorderLayout.EAST);

        // Add mainPanel to frame
        add(mainPanel);
  }
}