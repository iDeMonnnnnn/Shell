package demon.demo;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by DeMon on 2017/10/17.
 */

public class NetStateReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, Intent arg) {
        ConnectivityManager manager = (ConnectivityManager) context.
                getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager != null) {
            NetworkInfo gprs = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            NetworkInfo wifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            if (!gprs.isConnected() && !wifi.isConnected()) {
                AlertDialog.Builder ab = new AlertDialog.Builder(context);
                ab.setTitle("网络不可用");
                ab.setMessage("请检查网络状态！");
                ab.create().show();
            }
        }
    }
}