package com.blogspot.riteshcodejava.savethenote.ShowDataActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.blogspot.riteshcodejava.savethenote.MyDbHandler.DBHandler;
import com.blogspot.riteshcodejava.savethenote.R;
import com.blogspot.riteshcodejava.savethenote.databinding.ActivityShowDataBinding;

import java.util.ArrayList;

public class ShowDataActivity extends AppCompatActivity {

    ActivityShowDataBinding showDataBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showDataBinding = ActivityShowDataBinding.inflate(getLayoutInflater());
        setContentView(showDataBinding.getRoot());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        showDataBinding.showDataRecyclerView.setLayoutManager(linearLayoutManager);
        DBHandler handler = new DBHandler(this);

        ArrayList<DataModels> list = handler.getData();
        DataAdapters adapters = new DataAdapters(this,list);
        showDataBinding.showDataRecyclerView.setAdapter(adapters);

    }
}