/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package style;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author Fikri-Falndi
 */
public class FButtonHome extends JButton {

    Color color1, color2;
    Image bgimage = null;
    
    public FButtonHome(Color color1, Color color2, int img, int size) {
        this.color1 = color1;
        this.color2 = color2;
        setBorderPainted(true);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(false);
        setForeground(Color.white);
        setFont(new Font("Humanst521 BT", Font.PLAIN, size));
        setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR));

    }

    @Override
    protected void paintComponent(Graphics g) {
        ButtonModel buttonModel = getModel();
        Graphics2D gd = (Graphics2D) g.create();
        gd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gd.setColor(color1);
        setBorder(new EmptyBorder(20, 20, 20, 20));
        if (buttonModel.isRollover()) {
            setBorder(new CompoundBorder(new LineBorder(color2, 5), new EmptyBorder(15, 15, 15, 15)));
            if (buttonModel.isPressed()) {
                setBorder(new CompoundBorder(new LineBorder(color2, 7), new EmptyBorder(13, 13, 13, 13)));
                gd.setColor(color1);
            }
        }
        gd.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
}
