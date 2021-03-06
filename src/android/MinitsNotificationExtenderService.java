package com.minits.push;

import com.onesignal.OSNotificationPayload;
import com.onesignal.NotificationExtenderService;
import com.onesignal.OSNotificationReceivedResult;

public class MinitsNotificationExtenderService extends NotificationExtenderService {
   @Override
   protected boolean onNotificationProcessing(OSNotificationReceivedResult receivedResult) {
      @Override
   protected boolean onNotificationProcessing(OSNotificationReceivedResult receivedResult) {
      OverrideSettings overrideSettings = new OverrideSettings();
      overrideSettings.extender = new NotificationCompat.Extender() {
         @Override
         public NotificationCompat.Builder extend(NotificationCompat.Builder builder) {
            //Force remove push from Notification Center after 30 seconds
            builder.setTimeoutAfter(30000);
            // Sets the icon accent color notification color to Green on Android 5.0+ devices.
            builder.setColor(new BigInteger("FF00FF00", 16).intValue());
            builder.setContentTitle("New Message");
            builder.setContentText("New Encrypted Message");
            return builder;
         }
      };

      OSNotificationDisplayedResult displayedResult = displayNotification(overrideSettings);
      Log.d("OneSignalExample", "Notification displayed with id: " + displayedResult.androidNotificationId);

      // Return true to stop the notification from displaying.
      return false;
   }
}