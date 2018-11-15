package OrdenarPalabra;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author jimer.sayago
 */
public class ventanaRegistro extends JFrame {

    JPanel panel;
    JLabel color;
    JButton reiniciar;
    JButton arriba, abajo, der, izq;
    JList ListaColores;
    JLabel[] palabra;
    JLabel[] flechas;
    Container container;
    Border border = BorderFactory.createLineBorder(Color.black, 1);
    String[] letras = {"U", "N", "E", "T"};
    int posx = 100, posy = 20;
    int ancho = 120, alto = 70;
    ImageIcon[] imagen;
    ImageIcon[] word;
    CargarImagenes cimg;

    public ventanaRegistro() {
        super.setTitle("Practica 1");
        //panel = new JPanel(new FlowLayout());

        //container = getContentPane();
        //container.setLayout(new FlowLayout());
        //name = new JLabel("" + nombre/*n.getNombre()*/);
        /*name.setBounds(130, 20, 200, 30);
        name.setFont(fuente);
        name.setForeground(Color.WHITE);
        super.add(name);*/
    }

    public void inicializar() {
        panel = new JPanel(new FlowLayout(2, 2, 2));
        //panel.setLayout(new);panel = new JPanel(new GridBagLayout());
        super.setContentPane(panel);
        super.getComponentZOrder(ListaColores);
        super.setSize(1000, 1000);
        color = new JLabel("Color");
        color.setBounds(0, 300, 100, 100);
        super.setBackground(Color.yellow);

        String colores[] = {"Blue", "Black", "Cyan",
            "Dark Gray", "Gray", "Green", "Light Gray", "Magenta",
            "Orange", "Pink", "Red", "White", "Yellow"};

        final Color colors[] = {Color.blue, Color.black,
            Color.cyan, Color.darkGray, Color.gray, Color.green,
            Color.lightGray, Color.magenta, Color.orange, Color.pink,
            Color.red, Color.white, Color.yellow};

        ListaColores = new JList(colores);
        ListaColores.setLayout(new FlowLayout());
        ListaColores.setVisibleRowCount(3);  //Tamaño de la lista. Items a visualizar       
        ListaColores.setBounds(200, 350, 100, 100);

        ListaColores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        ListaColores.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                for (int i = 0; i < letras.length; i++) {
                    palabra[i].setForeground(colors[ListaColores.getSelectedIndex()]);
                }

            }
        });

        cimg = CargarImagenes.getInstance();
        word = new ImageIcon[CargarImagenes.totalImages];
        imagen = new ImageIcon[CargarImagenes.totalImages];

        word[0] = cimg.getImageLetras(CargarImagenes.letraU);
        word[1] = cimg.getImageLetras(CargarImagenes.letraN);
        word[2] = cimg.getImageLetras(CargarImagenes.letraE);
        word[3] = cimg.getImageLetras(CargarImagenes.letraT);
        imagen[0] = cimg.getImage(CargarImagenes.botonArriba);
        imagen[1] = cimg.getImage(CargarImagenes.botonAbajo);
        imagen[2] = cimg.getImage(CargarImagenes.botonDerecha);
        imagen[3] = cimg.getImage(CargarImagenes.botonIzquierda);

        final Font fuente = new Font("Arial", Font.BOLD, 64);

        int aleatorio;
        int[] num = new int[letras.length];
        Random r = new Random();

        palabra = new JLabel[letras.length];
        for (int i = 0; i < letras.length; i++) {
            aleatorio = r.nextInt(letras.length);
            for (int j = 0; j < i; j++) {
                do {
                    if (aleatorio == num[j]) {
                        aleatorio = r.nextInt(letras.length);
                        j = 0;
                    }
                } while (aleatorio == num[j]);
            }

            System.out.println("num aleatorio: " + aleatorio);
            num[i] = aleatorio;

            palabra[i] = new JLabel(letras[num[i]]);
            palabra[i].setBounds(posx * (i + 1), posy, word[i].getIconWidth() * 2, word[i].getIconHeight());
            palabra[i].setFont(fuente);
            palabra[i].setForeground(colors[0]);
            //palabra[i].setHorizontalAlignment(SwingConstants.CENTER);
            //border.paintBorder(palabra[i],g, posx,posy,ancho,alto);

            super.add(palabra[i]);
            //super.add(flechas[i]);

        }

        arriba = new JButton(imagen[0]);
        arriba.setLayout(null);
        arriba.setBounds(400, 200 - imagen[1].getIconWidth(), imagen[0].getIconWidth() - 150, imagen[0].getIconHeight() + imagen[0].getIconHeight());

        abajo = new JButton(imagen[1]);
        abajo.setLayout(null);
        abajo.setBounds(400, 200 + imagen[1].getIconWidth(), imagen[1].getIconWidth() - 150, imagen[1].getIconHeight());

        der = new JButton(imagen[2]);
        der.setLayout(null);
        der.setBounds(200 + imagen[2].getIconWidth() + imagen[2].getIconWidth(), 400, imagen[2].getIconWidth() - 150, imagen[2].getIconHeight());

        izq = new JButton(imagen[3]);
        izq.setLayout(null);
        izq.setBounds(200, 0, imagen[3].getIconWidth() - 150, imagen[3].getIconHeight());

        reiniciar = new JButton("Reiniciar");
        reiniciar.setLayout(null);
        reiniciar.setBounds(200, 400, 150, 50);

        super.add(color);
        super.add(ListaColores);
        super.add(new JScrollPane(ListaColores));
        super.add(arriba);
        super.add(abajo);
        super.add(der);
        super.add(izq);
        super.add(reiniciar);
        reiniciar.addActionListener(reiniciarPrograma);
        super.addMouseListener(moverLetras);
        //super.getContentPane().add(ListaColores);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setResizable(false);
        super.setVisible(true);
        //ListaColores.setVisible(true);
    }

    ActionListener reiniciarPrograma = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            inicializar();
        }
    };

    MouseListener moverLetras = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            for (int i = 0; i < letras.length; i++) {
                if (arriba.getAction().isEnabled()) {
                    palabra[i].setFocusable(true);
                    palabra[i].setBounds(posx * (i + 1), posy-5, word[i].getIconWidth() * 2, word[i].getIconHeight());
                }
            }

        }

        @Override
        public void mousePressed(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };

    Graphics g = new Graphics() {
        @Override
        public Graphics create() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void translate(int x, int y) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Color getColor() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void setColor(Color c) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void setPaintMode() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void setXORMode(Color c1) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Font getFont() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void setFont(Font font) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public FontMetrics getFontMetrics(Font f) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Rectangle getClipBounds() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void clipRect(int x, int y, int width, int height) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void setClip(int x, int y, int width, int height) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Shape getClip() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void setClip(Shape clip) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void copyArea(int x, int y, int width, int height, int dx, int dy) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void drawLine(int x1, int y1, int x2, int y2) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void fillRect(int x, int y, int width, int height) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void clearRect(int x, int y, int width, int height) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void drawOval(int x, int y, int width, int height) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void fillOval(int x, int y, int width, int height) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void drawString(String str, int x, int y) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void drawString(AttributedCharacterIterator iterator, int x, int y) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, Color bgcolor, ImageObserver observer) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void dispose() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };
    /*public Rectangle getBordes() {
        
    
        return new Rectangle(posx, posy, ancho, alto);
    }*/

}
