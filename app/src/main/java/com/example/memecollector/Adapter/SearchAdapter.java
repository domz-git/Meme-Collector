package com.example.memecollector.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.memecollector.R;
import com.example.memecollector.model.Meme;

import java.util.List;

class SearchViewHolder extends RecyclerView.ViewHolder{
    public TextView title;
    public ImageView image;

    public SearchViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.list_item_text_view);
        image = itemView.findViewById(R.id.list_item_image_view);
    }
}

public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder> {

    private Context context;
    private List<Meme> memes;

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.meme_list_item, parent);
        return new SearchViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        holder.title.setText(memes.get(position).getTitle());
        holder.image.setImageBitmap(memes.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return memes.size();
    }
}
