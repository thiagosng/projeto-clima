package caruaru.pe.clima.ui;


//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
//import android.R;

import androidx.appcompat.app.AppCompatActivity;

//import caruaru.pe.clima.R;

import caruaru.pe.clima.R;
import caruaru.pe.clima.transactions.GetClimaTransaction;
import caruaru.pe.clima.transactions.GetClimaView;
import caruaru.pe.clima.transactions.TransactionTask;
import caruaru.pe.clima.models.Clima;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity implements GetClimaView {

    TextView txtClima;
    EditText edtEndereco;
    Button btBuscar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.txtClima = findViewById(R.id.txtClima);
        this.edtEndereco = findViewById(R.id.edtEndereco);
        this.btBuscar = findViewById(R.id.btBuscar);

        this.btBuscar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                buscar(edtEndereco.getText().toString());
            }
        });
    }

    public void buscar(String endereco){
        new TransactionTask(this,
                new GetClimaTransaction(this,endereco),R.string.aguarde).execute(new Void[0]);
    }

    @Override
    public void setClima(Clima clima) {

        if(clima!=null) {
            this.txtClima.setText("Temperatura: " + clima.getTemperatura());
        }else{
            Toast.makeText(this,"Nenhum resultado encontrado", Toast.LENGTH_SHORT).show();
        }
    }

}
