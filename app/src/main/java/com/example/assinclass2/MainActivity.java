package com.example.assinclass2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText edttitle;
    private EditText edtname;
    private EditText edtpage;
    private Button btnsave;
    private Button btnsaveall;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    public String DATA ="DATA";
    List<Book> books= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupviews();
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tit=edttitle.getText().toString();
                String name=edtname.getText().toString();
                int page =Integer.parseInt(edtpage.getText().toString());
                books.add(new Book(tit,name,page));
                Toast.makeText(MainActivity.this, "Data save", Toast.LENGTH_SHORT).show();

            }
        });

        btnsaveall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prefs = PreferenceManager.getDefaultSharedPreferences(this);
                editor= prefs.edit();
                Gson gson =new Gson();
                String str =gson.toJson(books);
                editor.putString("DATA",str);
                editor.commit();
                Toast.makeText(MainActivity.this, "Data save on shared", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setupviews() {
        edtname =findViewById(R.id.edtname);
        edttitle =findViewById(R.id.edttitle);
        edtpage =findViewById(R.id.edtpage);
        btnsave=findViewById(R.id.btnsave);
        btnsaveall=findViewById(R.id.btnsaveall);
    }


}