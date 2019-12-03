package caruaru.pe.clima.transactions;

import android.util.Log;

import caruaru.pe.clima.models.Clima;
import caruaru.pe.clima.request.ClimaRequest;
import caruaru.pe.clima.request.RetrofitClient;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;


public class GetClimaTransaction implements Transaction {


    private String endereco;
    private ClimaRequest apiService;
    private GetClimaView view;
    private Clima clima;



    public GetClimaTransaction(GetClimaView view, String endereco){
        this.view = view;
        this.endereco = endereco;
        this.apiService =
                RetrofitClient.getClient().create(ClimaRequest.class);

    }


    public void execute(){
        Call<Clima> call = this.apiService.getClima(this.endereco,"metric");

        try {
            Response<Clima> response = call.execute();

            if (response.body() != null) {

                this.clima = response.body();
            }
        }catch (IOException ex){
            ex.printStackTrace();
            Log.d("Bug", ex.getMessage());
        }
    }


    public void updateView() {

        this.view.setClima(this.clima);


    }


}
