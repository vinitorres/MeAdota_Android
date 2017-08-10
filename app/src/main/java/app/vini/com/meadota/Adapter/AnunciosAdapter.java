package app.vini.com.meadota.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import app.vini.com.meadota.Model.Anuncio;
import app.vini.com.meadota.R;

/**
 * Created by Vini on 24/07/2017.
 */

public class AnunciosAdapter extends RecyclerView.Adapter<AnunciosAdapter.AnuncioViewHolder> {

    private List<Anuncio> listaAnuncios;

    public AnunciosAdapter(List<Anuncio> listaAnuncios) {
        this.listaAnuncios = listaAnuncios;
    }

    public AnuncioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_view_anuncio, parent, false);

        return new AnuncioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AnuncioViewHolder holder, final int position) {

        String imagemRef = listaAnuncios.get(position).listaImagensAnuncio.get(0);
//        Picasso.with(holder.itemView.getContext()).load(imagemRef).into(holder.imageView);

//        Glide.with(holder.imageView.getContext())
//                .load(imagemRef)
//                .crossFade()
//                .placeholder(R.drawable.ic_btn_dog)
//                .thumbnail(0.1f)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(holder.imageView);

        String titulo = listaAnuncios.get(position).titulo;
        String genero = listaAnuncios.get(position).genero;
        String descricao = listaAnuncios.get(position).descricao;
        String data = listaAnuncios.get(position).dataCriacao;

        holder.tvTituloAnuncio.setText(titulo);
        holder.tvGeneroAnuncio.setText(genero);
        holder.tvDataAnuncio.setText(data);
        holder.tvDescricaoAnuncio.setText(descricao);


    }

    @Override
    public int getItemCount() {
        return listaAnuncios.size();
    }


    public class AnuncioViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tvTituloAnuncio;
        TextView tvGeneroAnuncio;
        TextView tvDataAnuncio;
        TextView tvDescricaoAnuncio;

        public AnuncioViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.ivFotoAnuncio);
            tvTituloAnuncio = (TextView) itemView.findViewById(R.id.tvTituloAnuncio);
            tvGeneroAnuncio = (TextView) itemView.findViewById(R.id.tvGeneroAnuncio);
            tvDataAnuncio = (TextView) itemView.findViewById(R.id.tvDataAnuncio);
            tvDescricaoAnuncio = (TextView) itemView.findViewById(R.id.tvDescricaoAnuncio);

        }

    }

    public void update(List<Anuncio> listaAnuncios) {
        this.listaAnuncios = listaAnuncios;
        notifyDataSetChanged();
    }

}
