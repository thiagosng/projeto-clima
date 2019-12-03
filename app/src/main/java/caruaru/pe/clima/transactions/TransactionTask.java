package caruaru.pe.clima.transactions;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import caruaru.pe.clima.DefaultApplication;
import caruaru.pe.clima.tools.AndroidUtils;


/**
 *
 * @author albuquerque
 *
 */
public class TransactionTask extends AsyncTask<Void, Void, Boolean> {

    private final Context context;
    private final Transaction transaction;
    private ProgressDialog progresso;
    private Throwable exceptionErro;
    private int aguardeMsg;

    AlertDialog dialog;


    public TransactionTask(Context context, Transaction transaction,
                           int aguardeMsg) {
        super();
        this.context = context;
        this.transaction = transaction;
        this.aguardeMsg = aguardeMsg;
    }

    @Override
    protected void onPreExecute() {
        // TODO Auto-generated method stub
        super.onPreExecute();
        this.openProgress();
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        // TODO Auto-generated method stub
        try{
            this.transaction.execute();
        }catch(Throwable e){
            Log.e(DefaultApplication.TAG, e.getMessage(), e);
            this.exceptionErro=e;
            return false;
        }finally{
            try{
                this.closeProgress();
            }catch(Exception e){
                Log.e(DefaultApplication.TAG, e.getMessage(), e);
            }
        }
        return true;
    }

    @Override
    protected void onPostExecute(Boolean result) {
        // TODO Auto-generated method stub
        if (result){
            transaction.updateView();
        }else{
            dialog = AndroidUtils.alertDialog(this.context, "Erro: "+this.exceptionErro.getMessage());
        }
    }

    private void openProgress(){
        try{
            this.progresso = ProgressDialog.show(this.context,"processando", this.context.getString(this.aguardeMsg));
        }catch(Throwable e){
            Log.e(DefaultApplication.TAG, e.getMessage(),e);
        }
    }

    private void closeProgress(){
        try{
            if (this.progresso != null){
                this.progresso.dismiss();
            }

        }catch(Throwable e){
            Log.e(DefaultApplication.TAG, e.getMessage(),e);
        }
    }

    public void closeDialog(){
        try{
            if (this.dialog != null){
                this.dialog.dismiss();
            }

        }catch(Throwable e){
            Log.e(DefaultApplication.TAG, e.getMessage(),e);
        }
    }

}
