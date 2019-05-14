package com.example.destroy.textualapp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by Destroy on 16-Jan-18.
 */

public class FirebaseMessageService extends com.google.firebase.messaging.FirebaseMessagingService {

    public void onMessageReceived(RemoteMessage remoteMessage){
        super.onMessageReceived(remoteMessage);


        String notification_title=remoteMessage.getNotification().getTitle();
        String notification_message=remoteMessage.getNotification().getBody();
        String action_click=remoteMessage.getNotification().getClickAction();
        String from_user_id=remoteMessage.getData().get("from_user_id");

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle(notification_title)
                        .setContentText(notification_message);

        Intent resultIntent = new Intent(action_click);
        resultIntent.putExtra("user_id",from_user_id);

        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        this,
                        0,
                        resultIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);


        int mNotificationId = (int)System.currentTimeMillis();
// Gets an instance of the NotificationManager service
        NotificationManager mNotifyMgr =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
// Builds the notification and issues it.
        mNotifyMgr.notify(mNotificationId, mBuilder.build());

    }
}
