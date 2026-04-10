package com.example.launcher;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String targetPackage = "com.google.android.apps.photosgo"; // CHANGE THIS

        Intent intent = getPackageManager().getLaunchIntentForPackage(targetPackage);

        if (intent != null) {
            startActivity(intent);
        } else {
            // fallback: open Play Store
            Intent storeIntent = new Intent(Intent.ACTION_VIEW);
            storeIntent.setData(Uri.parse("market://details?id=" + targetPackage));
            startActivity(storeIntent);
        }

        finish(); // close launcher app
    }
}
