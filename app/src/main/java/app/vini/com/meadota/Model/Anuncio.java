package app.vini.com.meadota.Model;

import java.util.ArrayList;

/**
 * Created by Vini on 18/07/2017.
 */

public class Anuncio {

    public String userUID;
    public String titulo;
    public String genero;
    public String descricao;
    public String dataCriacao;
    //public String latitude;
    //public String longitude;
    public ArrayList<String> listaImagensAnuncio;

    public Anuncio() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Anuncio(String userUID, String titulo, String genero,String descricao,String dataCriacao, String latitude, String longitude, ArrayList<String> listaImagensAnuncio) {
        this.userUID = userUID;
        this.titulo = titulo;
        this.genero = genero;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
//        this.latitude = latitude;
//        this.longitude = longitude;
        this.listaImagensAnuncio = listaImagensAnuncio;
    }

}
