/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OrdenarPalabra;

import java.awt.Rectangle;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author jimer.sayago
 */
public class CargarImagenes {

    int [] posx;
    int [] posy;
    public static final int totalImages = 4;
    public ImageIcon[] imagen;
    public ImageIcon[] letras;
    
    private static CargarImagenes instance = null;
    
    public static final int letraU=0; 
    public static final int letraN=1;    
    public static final int letraE=2;
    public static final int letraT=3;
    public static final int botonArriba=0;
    public static final int botonAbajo=1;
    public static final int botonDerecha=2;
    public static final int botonIzquierda=3;
    
    private CargarImagenes(){
        posx = new int[totalImages];
        posy = new int[totalImages];
        for (int i = 0; i < totalImages; i++) {
             posx [i] = 0;
             posy [i] = 0;
        }

        String letra[] = new String[] {"letraU.jpg","letraN.jpg","letraE.jpg","letraT.jpg"};
        String image[] = new String[] {"botonArriba.jpg","botonAbajo.jpg","botonDerecha.jpg","botonIzquierda.jpg"};
        
        letras = new ImageIcon[totalImages];
        imagen = new ImageIcon[totalImages];
        
        
        for (int i = 0; i < totalImages; i++) {
            
            URL url = this.getClass().getResource("imagenes/"+image[i]);
            imagen[i] = new ImageIcon(url);
           
            URL url2 = this.getClass().getResource("imagenes/"+letra[i]);
            letras[i] = new ImageIcon(url2);
             
            
            
        }
    }

    public static CargarImagenes getInstance() {
        if (instance == null) 
            instance = new CargarImagenes();
        

        return instance;

    }

    public ImageIcon getImage(int imageId) {
        if (imageId < 0 || imageId >= totalImages) {
            return null;
        }

        return imagen[imageId];
    }

    public void setImage(int imageId) {
        imagen[imageId] = CargarImagenes.getInstance().getImage(imageId);
    }
    

    public int [] getPosx() {
        return posx;
    }

    public void setPosx(int [] posx) {
        this.posx = posx;
    }

    public int [] getPosy() {
        return posy;
    }

    public void setPosy(int [] posy) {
        this.posy = posy;
    }
    public ImageIcon[] getImagen() {
        return imagen;
    }

    public void setImagen(ImageIcon[] imagen) {
        this.imagen = imagen;
    }

    public void setBordes(int x, int y, int ancho, int alto){           
        for (int i = 0; i < totalImages; i++) {
            this.posx[i] = x;
            this.posy[i] = y;
            ancho = imagen[i].getIconWidth();
            alto = imagen[i].getIconHeight();
        }

    }

    public Rectangle getBordesFlecha() {
        for (int i = 0; i < totalImages; i++) {
            return new Rectangle(posx[i], posy[i], imagen[i].getIconWidth(), imagen[i].getIconHeight());  
        }
        return null;
        
    }

    public ImageIcon getImageLetras(int imageId) {
        if (imageId < 0 || imageId >= totalImages) {
            return null;
        }

        return letras[imageId];
    }

    public void setImageLetras(int imageId) {
        letras[imageId] = CargarImagenes.getInstance().getImage(imageId);
    }
    

    public int [] getPosxLetras() {
        return posx;
    }

    public void setPosxLetras(int [] posx) {
        this.posx = posx;
    }

    public int [] getPosyLetras() {
        return posy;
    }

    public void setPosyLetras(int [] posy) {
        this.posy = posy;
    }
    public ImageIcon[] getImagenLetras() {
        return letras;
    }

    public void setImagenLetras(ImageIcon[] letras) {
        this.letras = letras;
    }

    public void setBordesLetras(int x, int y, int ancho, int alto){           
        for (int i = 0; i < totalImages; i++) {
            this.posx[i] = x;
            this.posy[i] = y;
            ancho = letras[i].getIconWidth();
            alto = letras[i].getIconHeight();
        }

    }
    public Rectangle getBordesLetras() {
        for (int i = 0; i < totalImages; i++) {
            return new Rectangle(posx[i], posy[i], letras[i].getIconWidth(), letras[i].getIconHeight());  
        }
        return null;
        
    }       
}
