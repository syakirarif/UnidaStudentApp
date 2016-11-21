package id.ac.gontor.unida.ti.unidastudent;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by syakirarifu on 10/29/2016.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Intent intent = new Intent(this,MenuUtama.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);

        //membuat notifikasi
        NotificationCompat.Builder notif = new NotificationCompat.Builder(this);
        notif.setContentTitle("FCM NOTIFICATION");
        notif.setContentText(remoteMessage.getNotification().getBody());
        notif.setAutoCancel(true);
        notif.setSmallIcon(R.drawable.ic_notifications_active_black_48px);
        notif.setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notif.build());
    }
}
