package Odev1_UE;

import com.sun.java.swing.plaf.windows.WindowsScrollBarUI;
import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import sun.font.TextLabel;

/**
 *
 * @author ALPARSLAN
 */
public class Odev1_Applet extends Applet implements ActionListener {

    Button btnEkle, btnCikar, btnGoster;
    Label lbSayi;
    TextField tfValue = new TextField();
    Odev_Stack y;
    int rectX, rectY;
    Graphics g2;

    @Override
    public void init() {
        createsButton();
        createLabelAndTextField();

    }

    public void createsButton() {
        btnEkle = new Button("EKLE");
        btnEkle.setBackground(Color.LIGHT_GRAY);
        add(btnEkle);
        btnEkle.addActionListener(this);

        btnCikar = new Button("CİKAR");
        btnCikar.setBackground(Color.LIGHT_GRAY);
        add(btnCikar);
        btnCikar.addActionListener(this);

        btnGoster = new Button("GOSTER");
        btnGoster.setBackground(Color.LIGHT_GRAY);
        add(btnGoster);
        btnGoster.addActionListener(this);
    }

    public void createLabelAndTextField() {
        lbSayi = new Label("Sayı :");
        add(lbSayi);
        tfValue = new TextField("Deger giriniz..");
        add(tfValue);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        rectX = 80;
        rectY = 140;
        //        (x,y,weight,height)
        g.drawRect(150, 130, rectX, rectY);
        g.setColor(Color.lightGray);
        g.fillRect(150, 130, rectX, rectY);

        //drawStackRect(g2, 5, 0);
        /*
        //stack yapısı
        g.drawRect(170, 250, 40, 20);
        g.setColor(Color.orange);
        g.fillRect(170, 250, 40, 20);

        g.setColor(Color.BLACK);
        g.drawString("5", 185, 265);

        g.setColor(Color.BLACK);
        g.drawString("0", 160, 265);
         */
        //bundan sonraki oluşacak rectangle'ın Y degeri 20 birim azalacak
    }

    public void drawStackRect(Graphics g2, int yeni_eleman, int sayac) {
        //stack yapısı
        try {
            int recttX = 170, recttY = 250;

            //g2.drawRect(recttX, recttY, 40, 20);
            g2.setColor(Color.orange);
            g2.fillRect(recttX, recttY, 40, 20);

            g2.setColor(Color.BLACK);
            g2.drawString(String.valueOf(yeni_eleman), 185, 265);

            g2.setColor(Color.BLACK);
            g2.drawString(String.valueOf(sayac), 160, 265);
            sayac++;
        } catch (NullPointerException ne) {
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int say = 0;
        if (e.getSource() == btnEkle) {
            //EKLE Butonu işlemleri
            int sayi = Integer.parseInt(tfValue.getText());
            //String sayi = tfValue.getText();
            //y.ekle(new dugum(sayi));
            System.out.println("Sayı :" + sayi);
            drawStackRect(g2, sayi, say);
            System.out.println("EKLE Butonu..");
        } else if (e.getSource() == btnCikar) {
            System.out.println("CİKAR Butonu..");
        } else if (e.getSource() == btnGoster) {
            System.out.println("GOSTER Butonu..");
        }
    }

}
