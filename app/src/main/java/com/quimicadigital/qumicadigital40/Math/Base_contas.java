package com.quimicadigital.qumicadigital40.Math;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.quimicadigital.qumicadigital40.Elementos.Elemento;
import com.quimicadigital.qumicadigital40.R;
import com.quimicadigital.qumicadigital40.ui.PesquisaPrincipal;
import com.quimicadigital.qumicadigital40.ui.logical_math;

public class Base_contas extends AppCompatActivity {

    private Button btn_calcular;
    private TextView title;
    private TextView title2;
    private TextView txt1;
    private TextView txt2;
    private TextView txt3;
    private TextView txt4;

    private EditText edt1;
    private EditText edt2;
    private EditText edt3;
    private EditText edt4;
    private TextView result;

    private View view_contas;

    private int number;
    private Contas contas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_contas);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(logical_math.title);

        edt1 = findViewById(R.id.edt_base);
        edt2 = findViewById(R.id.edt_expoente);
        edt3 = findViewById(R.id.edt_base2);
        edt4 = findViewById(R.id.edt_expoente2);

        String hexColor = String.format("#%06X", (0xFFFFFF & ((ColorDrawable) findViewById(R.id.view_contas).getBackground()).getColor()));
        view_contas = findViewById(R.id.view_edts);
        if(hexColor.equals("#B2D8EB")){
            view_contas.setBackgroundResource(R.drawable.forma_borda_elemento_light);
            edt1.setTextColor(Color.parseColor("#FFFFFF"));
            edt2.setTextColor(Color.parseColor("#FFFFFF"));
            edt3.setTextColor(Color.parseColor("#FFFFFF"));
            edt4.setTextColor(Color.parseColor("#FFFFFF"));
        }

        btn_calcular = findViewById(R.id.btn_calcular);
        title = findViewById(R.id.txt_title);
        title2 = findViewById(R.id.txt_explic);
        txt1 = findViewById(R.id.txt_Base);
        txt2 = findViewById(R.id.txt_Exponte);
        txt3 = findViewById(R.id.txt_Base2);
        txt4 = findViewById(R.id.txt_Exponte2);



        result = findViewById(R.id.txt_resultado);

        number = logical_math.selection;
        contas = new Contas(number,btn_calcular,title,title2,txt1,txt2,txt3,txt4,edt1,edt2,edt3,edt4,result);

        if(number == 1 || number == 2 || number == 6){
            edt1.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if (actionId == EditorInfo.IME_ACTION_DONE) {
                        View nextView = edt3;
                        nextView.requestFocus();
                        return true;
                    }
                    return false;
                }
            });

            edt3.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if (actionId == EditorInfo.IME_ACTION_DONE) {
                        View nextView = edt2;
                        nextView.requestFocus();
                        return true;
                    }
                    return false;
                }
            });

        }else if(number == 8){
            edt1.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if (actionId == EditorInfo.IME_ACTION_DONE) {
                        View nextView = edt2;
                        nextView.requestFocus();
                        return true;
                    }
                    return false;
                }
            });
        }

    }
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

}