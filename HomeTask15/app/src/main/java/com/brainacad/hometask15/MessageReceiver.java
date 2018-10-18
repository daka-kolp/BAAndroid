package com.brainacad.hometask15;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

public class MessageReceiver extends BroadcastReceiver {

    private String message;

    public String getMessage() {
        return message;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();

        if (bundle != null) {

            final Object[] pdusObj = (Object[]) bundle.get("pdus");

            for (int i = 0; i < pdusObj.length; i++) {

                SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                //String phoneNumber = currentMessage.getDisplayOriginatingAddress();

                String senderNum = currentMessage.getOriginatingAddress();

                //String senderNum = phoneNumber;
                this.message = currentMessage.getDisplayMessageBody();

                Log.i("SmsReceiver", "senderNum: " + senderNum + "; message: " + message);

            }
        }
    }
}
