package remainder.com.remainder;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import remainder.com.remainder.database.ChildClass;

public class Notification extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {}
       /* int notificationId = intent.getIntExtra("notificationId",0);
        String message = intent.getStringExtra("todo");


        Intent mainIntent = new Intent(context, ChildClass.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context,0,mainIntent,0);

        NotificationManager myNotificationmanager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);


        //prepare notification
       android.app.Notification builder;
        builder = new NotificationCompat.Builder(context)
                .setContentTitle("vaccination")
                .setContentText("BCG")
                .setSmallIcon(R.drawable.ic_person).build();
                //.setWhen(System.currentTimeMillis())
                //.setContentIntent(contentIntent);

        myNotificationmanager.notify(notificationId,builder.build());
       /* NotificationHelper notificationHelper = new NotificationHelper(context);
        NotificationCompact.Builder nb = notificationHelper.getChannelNotification();
        notificationHelper.getManager().notify(1,nb.build());*/

    }



