/*
 * To change this license FBackground, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package style;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 *
 * @author Fikri-Falndi
 */
public class FExitBackground extends JPanel{
    
    Image bgimage = null;

    public FExitBackground() {
        MediaTracker mt = new MediaTracker(this);
        bgimage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("image/exitbackground.png"));
        mt.addImage(bgimage, 0);
        try {
            mt.waitForAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setOpaque(false);
        int imwidth = getWidth();
        int imheight = getHeight();
        
        g.drawImage(bgimage, 0, 0, imwidth, imheight, this);
    }
    
}
