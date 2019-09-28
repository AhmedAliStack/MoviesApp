package com.ahmedraafat.moviestask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.ahmedraafat.moviestask.adapter.MoviesAdapter;
import com.ahmedraafat.moviestask.model.CateModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView tvLang;
    private TextView tvFav;
    private RecyclerView rvMain;
    private MoviesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        tvLang = findViewById(R.id.tvLang);
        tvFav = findViewById(R.id.tvFav);
        rvMain = findViewById(R.id.rvMain);

        List<CateModel> models = new ArrayList<>();
        for (String title :
                getResources().getStringArray(R.array.cates)) {
            models.add(new CateModel(title));
        }
        adapter = new MoviesAdapter(this, models,item -> {

        });
        rvMain.setLayoutManager(new LinearLayoutManager(this));
        rvMain.setAdapter(adapter);
    }
}
