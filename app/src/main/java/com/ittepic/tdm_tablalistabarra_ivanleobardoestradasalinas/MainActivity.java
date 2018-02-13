package com.ittepic.tdm_tablalistabarra_ivanleobardoestradasalinas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    SeekBar barra;
    ListView listv;
    TextView num;
    Button btn;
    int n,n1;
    String r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barra=findViewById(R.id.seekBar);
        listv=findViewById(R.id.listView);
        btn=findViewById(R.id.button);
        num=findViewById(R.id.textView);

        barra.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                num.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        final String[] lista = new String[]{"Tabla:"};
        final List<String> list = new ArrayList<String>(Arrays.asList(lista));
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        listv.setAdapter(arrayAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n=barra.getProgress();
                for (int i=1;i<=10;i++){
                    n1=n*i;
                    r=n+" X "+i+" = "+n1+"\n";
                    list.add(r);
                    arrayAdapter.notifyDataSetChanged();
                }
            }
        });
    }
}
