/*
 * FINAL PROJECT: Beat Visualizer
 * AUTHORS:       Susana C Delgadillo, ****** ****
 * DATE:          5/5/2010
 *
 *
 * MODIFIED VERSION OF CODE PROVIDED FROM:
 *
 * INTRODUCTION TO PROGRAMMING: EIGTH EDITION
 * Y. DANIEL LIANG
 * FIGUREPANEL.JAVA
 * PAGES 503-505, LISTING 15.3
 * 
 */

package beat_visualizer;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Beat extends JPanel
{
    Timer timer;
    private int shape;
    private boolean filled;
    private int freq;
    private String name;
    private int beatHeight;
    private int beatWidth;
    private boolean selected;
    private Color beatColor;

    public static final int LINE            = 1;
    public static final int RECTANGLE       = 2;
    public static final int ROUND_RECTANGLE = 3;
    public static final int OVAL            = 4;

    // Timer listener for each beat's timer.
    // Causes the 'blinking/flashing' effect by hiding it if it's visible,
    // making it visible if it's hidden, and then repainting it.
    class TimerListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
            if(isVisible())
            {
                setVisible(false);
            }
            else
            {
                setVisible(true);
            }
            repaint();
        }
    }

    // Beat constructor, no parameters
    public Beat()
    {
        this.shape      = 2;
        this.freq       = 1000;
        this.beatColor  = Color.BLACK;
        this.filled     = true;
        this.name       = "Generic Beat";
        this.selected   = false;
        this.beatHeight = 100;
        this.beatWidth  = 100;
        this.timer      = new Timer(this.freq, new TimerListener());
        this.timer.setInitialDelay(100);

    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        // Get this beat's width and height and set the color
        int width = getBeatWidth();
        int height = getBeatHeight();
        g.setColor(beatColor);

        //Paint the beat according to its set properties
        switch (shape)
        {
          case LINE: // Display two cross lines
            g.drawLine(10, 10, width - 10, height - 10);
            g.drawLine(width - 10, 10, 10, height - 10);
            break;

          case RECTANGLE: // Display a rectangle
            if (filled)
              g.fillRect((int)(0.1 * width), (int)(0.1 * height),
                (int)(0.8 * width), (int)(0.8 * height));
            else
              g.drawRect((int)(0.1 * width), (int)(0.1 * height),
                (int)(0.8 * width), (int)(0.8 * height));
            break;

          case ROUND_RECTANGLE: // Display a round-cornered rectangle
            if (filled)
              g.fillRoundRect((int)(0.1 * width), (int)(0.1 * height),
                (int)(0.8 * width), (int)(0.8 * height), 20, 20);
            else
              g.drawRoundRect((int)(0.1 * width), (int)(0.1 * height),
                (int)(0.8 * width), (int)(0.8 * height), 20, 20);
            break;

          case OVAL: // Display an oval
            if (filled)
              g.fillOval((int)(0.1 * width), (int)(0.1 * height),
                (int)(0.8 * width), (int)(0.8 * height));
            else
              g.drawOval((int)(0.1 * width), (int)(0.1 * height),
                (int)(0.8 * width), (int)(0.8 * height));
        }

    }


    public int getBeatHeight()
    {
        return beatHeight;
    }

    public void setBeatHeight(int h)
    {
        this.beatHeight = h;
    }

    public int getBeatWidth()
    {
        return beatWidth;
    }

    public void setBeatWidth(int w)
    {
        this.beatWidth = w;
    }
    
    public Color getBeatColor()
    {
        return beatColor;
    }
    
    public void setBeatColor(Color color)
    {
        this.beatColor = color;
    }

    public int getShape()
    {
        return shape;
    }

    public void setShape(int shape)
    {
        this.shape = shape;
    }

    public boolean isFilled() 
    {
        return filled;
    }
    
    public void setFilled(boolean filled)
    {
        this.filled = filled;
    }

    
    public String getBeatName()
    {
        return name;
    }

    public void setBeatName(String name)
    {
        this.name = name;
    }

    public int getFrequency()
    {
        return freq;
    }

    public void setFrequency(int freq)
    {
        if (freq < 10)
        {
            this.freq = freq * 100;
        }
        else
        {
            this.freq = freq * 1000;
        }
    }

    public boolean isSelected()
    {
        return selected;
    }

    public void setSelected(boolean selected)
    {
        this.selected = selected;
    }

}

