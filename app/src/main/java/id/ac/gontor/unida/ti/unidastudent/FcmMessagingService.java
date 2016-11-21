package id.ac.gontor.unida.ti.unidastudent;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by syakirarifu on 10/31/2016.
 */

public class FcmMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        String title    = remoteMessage.getNotification().getTitle();
        String message  = remoteMessage.getNotification().getBody();


        super.onMessageReceived(remoteMessage);
    }
}
