package com.example.a0725;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class Notification extends AppCompatActivity {
    private EditText mEditText;
    private static final String NOTIFICATION_CHANNEL_ID = "my_channel_id_01";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);
        mEditText = findViewById(R.id.editTextText);
        createNotificationChannel();
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID,
                    "My Notifications", NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription("Channel description");
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    public void sendNotification() {
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)  // Update this to your notification icon
                .setContentTitle("Egg Timer")
                .setContentText("계란 삶기가 완료되었습니다.")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        notificationBuilder.setContentIntent(pendingIntent);
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notificationBuilder.build());
    }

    public void startTimer(View v) {
        String s = mEditText.getText().toString();
        if (s.length() != 5 || s.charAt(2) != ':') {
            mEditText.setText("형식 오류");
            return;
        }
        int min;
        int sec;
        try {
            min = Integer.parseInt(s.substring(0, 2));
            sec = Integer.parseInt(s.substring(3, 5));
        } catch (NumberFormatException e) {
            mEditText.setText("형식 오류");
            return;
        }
        new CountDownTimer(min * 60 * 1000 + sec * 1000, 1000) {
            public void onTick(long millisUntilFinished) {
                mEditText.setText("" + (int) (millisUntilFinished / 1000) + "초");
            }

            public void onFinish() {
                mEditText.setText("계란 삶기가 완료되었습니다.");
                sendNotification();
            }
        }.start();
    }
}
