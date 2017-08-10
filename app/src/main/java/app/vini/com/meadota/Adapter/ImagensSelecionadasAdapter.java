package app.vini.com.meadota.Adapter;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import app.vini.com.meadota.R;

/**
 * Created by Vini on 12/07/2017.
 */


public class ImagensSelecionadasAdapter extends RecyclerView.Adapter<ImagensSelecionadasAdapter.ImagemViewHolder> {

    private List<Bitmap> imagemList;

    public ImagensSelecionadasAdapter(List<Bitmap> imagensUri) {
        this.imagemList = imagensUri;
    }

    public ImagemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_view_gallery, parent, false);

        return new ImagemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImagemViewHolder holder, final int position) {

        Bitmap imagemRef = imagemList.get(position);

        holder.imageView.setImageBitmap(imagemList.get(position));
        
    }

    @Override
    public int getItemCount() {
        return imagemList.size();
    }


    public class ImagemViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public ImagemViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.ivFotoSelecionada);

        }

    }

    public void update(List<Bitmap> imagensUri) {
        this.imagemList = imagensUri;
        notifyDataSetChanged();
    }

}
