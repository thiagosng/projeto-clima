package caruaru.pe.clima.tools;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
//import android.R;

import androidx.appcompat.app.AppCompatActivity;

import caruaru.pe.clima.R;

//import caruaru.pe.clima.R;
/**
 * Classe que tem métodos úteis
 * para a aplicação
 * @author albuquerque
 *
 */
public class AndroidUtils {

    protected static final String TAg="clima";

    public static boolean isNetworkAvailable(Context context){
        ConnectivityManager connectivity=(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivity == null){
            return false;
        }
        else{
            NetworkInfo[] info=connectivity.getAllNetworkInfo();
            if (info != null){
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void alertDialog(final Context context, final int mensagem){
        try{
            AlertDialog dialog= new AlertDialog.Builder(context)
                    .setTitle(R.string.title_label)
                    .setMessage(mensagem)
                    .create();

            dialog.setButton(context.getResources().getText(R.string.ok_button), new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    return;
                }

            });

            dialog.show();
        }catch(Exception e){
            Log.e(TAg, e.getMessage(), e);
        }
    }

    public static AlertDialog alertDialog(final Context context, final String mensagem){
        try{
            AlertDialog dialog= new AlertDialog.Builder(context)
                    .setTitle(R.string.title_label)
                    .setMessage(mensagem)
                    .create();

            dialog.setButton(context.getResources().getText(R.string.ok_button), new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    return;
                }

            });

            dialog.show();
            return dialog;
        }catch(Exception e){
            Log.e(TAg, e.getMessage(), e);
            return null;
        }
    }

    public static String getVersionName(Context c){
        PackageManager manager = c.getPackageManager();
        PackageInfo info = null;
        try {
            info = manager.getPackageInfo(
                    c.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return info.versionName;
    }

    public static void hideKeyboard(Activity activity, View view) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}
