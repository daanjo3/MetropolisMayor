package com.example.metropolismayor;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.metropolismayor.mayorcore.CardCollection;
import com.example.metropolismayor.mayorcore.cards.CardFactory;

public class MainActivity extends AppCompatActivity {

    private CardCollection testCards = CardFactory.getNRandomCard(10);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView collectionView = (RecyclerView)findViewById(R.id.collectionView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 3);
        collectionView.setLayoutManager(gridLayoutManager);

        CollectionAdapter collectionAdapter = new CollectionAdapter(MainActivity.this, testCards);
        collectionView.setAdapter(collectionAdapter);
    }
}
