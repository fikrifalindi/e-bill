/*
 * To change this license FBackground, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package style;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LinearGradientPaint;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author Fikri-Falndi
 */
public class FBackground extends JPanel{

    Image bgimage = null;

    public FBackground() {
        MediaTracker mt = new MediaTracker(this);
        bgimage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("image/background.png"));
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
