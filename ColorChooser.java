/*
 * FINAL PROJECT: Beat Visualizer
 * AUTHORS:       Susana C Delgadillo, ****** ****
 * DATE:          5/5/2010
 *
 *
 * ALTERED VERSION OF ColorChooserDemo.java:
 * http://java.sun.com/docs/books/tutorial/uiswing/examples/components/
 * ColorChooserDemoProject/src/components/ColorChooserDemo.java
 *
 *
 * 
 * Copyright (c) 1995 - 2008 Sun Microsystems, Inc.  All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Sun Microsystems nor the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package beat_visualizer;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class ColorChooser extends JPanel implements ChangeListener
{
    protected JColorChooser colorChoose;

    public ColorChooser()
    {
        super(new BorderLayout());
        colorChoose = new JColorChooser(Color.white);
        colorChoose.getSelectionModel().addChangeListener(this);
        colorChoose.setBorder(BorderFactory.createTitledBorder(
                                             "Choose Beat Color"));
        add(colorChoose, BorderLayout.PAGE_END);
    }

    public void stateChanged(ChangeEvent e)
    {
        Color newColor = colorChoose.getColor();
        Options.beatArray[Options.currentBeat].setBeatColor(newColor);
        VisualizerFrame.displayPanel.repaint();
    }
}

