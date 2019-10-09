package com.example.metropolismayor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.metropolismayor.mayorcore.CardCollection;
import com.example.metropolismayor.mayorcore.cards.Card;

import java.util.ArrayList;

public class CollectionAdapter extends RecyclerView.Adapter {
    CardCollection cards;
    Context context;

    public CollectionAdapter(Context context, CardCollection cards) {
        this.context = context;
        this.cards = cards;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayout, parent, false);
        CardViewHolder myViewHolder = new CardViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        CardViewHolder cardHolder = (CardViewHolder)holder;
        cardHolder.cardName.setText(cards.get(position).name);
        cardHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, cards.get(position).name, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        TextView cardName;

        public CardViewHolder(View cardView) {
            super(cardView);

            cardName = (TextView) itemView.findViewById(R.id.cardname);
        }
    }

}
