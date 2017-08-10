package app.vini.com.meadota.Model;

import android.graphics.drawable.Drawable;

/**
 * Created by Vini on 01/07/2017.
 */

public class OpcaoButton {

    private int image;
    private int titulo;

    public OpcaoButton(int titulo, int image) {
        this.image = image;
        this.titulo = titulo;
    }

    public int getTitulo() {
        return titulo;
    }

    public void setTitulo(int titulo) {
        this.titulo = titulo;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
