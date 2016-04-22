package com.windog.activitytest.BroadcastReceiver;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.WindowManager;

import com.windog.activitytest.ui.ActivityCollector;
import com.windog.activitytest.ui.MainActivity;

/**
 * Created by windog on 2016/4/3.
 */
public class ForceOfflineReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, Intent intent) {
        AlertDialog.Builder dialogBuileder = new AlertDialog.Builder(context);
        dialogBuileder.setTitle("WARNING");
        dialogBuileder.setMessage("You Are Forced To Be Offline. Please Try To Login Again!!");
        dialogBuileder.setCancelable(false);
        dialogBuileder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ActivityCollector.finishAll();
                Intent intent = new Intent(context, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        AlertDialog alertDialog = dialogBuileder.create();
        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        alertDialog.show();

    }
}
