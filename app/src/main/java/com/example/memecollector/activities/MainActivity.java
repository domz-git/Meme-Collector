package com.example.memecollector.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.memecollector.R;
import com.example.memecollector.db.MemeAdapter;
import com.example.memecollector.db.MemeDbHelper;

public class MainActivity extends AppCompatActivity {

    private MemeDbHelper dbHelper;
    private GridView gridView;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.gridView = findViewById(R.id.activity_main_grid_view);
        this.dbHelper = new MemeDbHelper(this);
        this.gridView.setAdapter(new MemeAdapter(this, this.dbHelper.readAllMemes(), false));
        this.gridView.setEmptyView(findViewById(R.id.activity_main_empty_view));




        }



    @Override
    protected void onResume() {
        super.onResume();

        ((CursorAdapter)gridView.getAdapter()).swapCursor(this.dbHelper.readAllMemes());
    }

    public void addNewMeme(View view) {
        Intent intent = new Intent(this, NewMemeActivity.class);
        startActivity(intent);
    }

}

