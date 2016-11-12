package android.unitec.employeesmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etHoras;
    private TextView tvPago;
    private EditText etHn;
    private EditText etHe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etHoras= (EditText) findViewById(R.id.etHoras);
        tvPago= (TextView) findViewById(R.id.tvPago);
        etHn= (EditText) findViewById(R.id.etHn);
        etHe= (EditText) findViewById(R.id.etHe);

    }

    public void Calcular(View view) {
        //Sacar las horas trabajadas
        double horas= Double.parseDouble( etHoras.getText().toString());
        double pago=0;
        //Saquemos el pago
        //150 lps x cada hora normal. Hasta 40 son normales el resto extra se paga 300 lps.

        if (horas>40){
            pago= (150+40)+ (horas-40)* 300;
        }
        else{
            pago= horas*150;
        }
        tvPago.setText("L."+ pago);
        Toast.makeText(this, "Pago calculado", Toast.LENGTH_LONG).show();
    }

    public void Detalle(View view){
        double HN=40;
        double HE=0;
        double horas= Double.parseDouble(etHoras.getText().toString());
        if (horas>40){
            HE= horas-40;
        }
        else{
            HN= horas;
        }

        etHn.setText("Horas normales"+ HN);
        etHe.setText("Horas extras"+ HE);


    }
}
