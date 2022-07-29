package com.h5200002.berfin_meryem_tuzcu_final.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;


import androidx.annotation.NonNull;


import com.h5200002.berfin_meryem_tuzcu_final.R;

public class AlertUtil{
    private static AlertDialog.Builder builder;
    private static Resources resorces;

    public static void receiveNoInternet(Context context,Activity activity){

        resorces = context.getResources();
        builder = new AlertDialog.Builder(context);
        builder.setTitle(resorces.getString(R.string.alert_title));
        builder.setMessage(resorces.getString(R.string.alert_message));
        builder.setPositiveButton(resorces.getString(R.string.alert_positive_button), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                final Intent intent = new Intent(Intent.ACTION_MAIN, null);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                final ComponentName cn = new ComponentName("com.android.settings", "com.android.settings.wifi.WifiSettings");
                intent.setComponent(cn);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                activity.startActivity( intent);

            }
        });

        builder.setNegativeButton(resorces.getString(R.string.alert_negative_button), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                System.exit(0);
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    public static boolean onBackPressed(@NonNull Context context){
        resorces = context.getResources();
        builder = new AlertDialog.Builder(context);
        try{
            builder.setTitle(resorces.getString(R.string.listScreen_alert_exit_title));
            builder.setMessage(resorces.getString(R.string.listScreen_alert_exit_message));


            builder.setPositiveButton(resorces.getString(R.string.listScreen_alert_exit_yes),new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    System.exit(0);
                }
            });

            builder.setNegativeButton(resorces.getString(R.string.listScreen_alert_exit_no), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            builder.setCancelable(false);
            builder.show();
        }catch(Exception e){
          return  true;
        }
        return false;

    }

}
