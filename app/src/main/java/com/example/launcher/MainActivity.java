package com.example.launcher;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String pkg = "com.google.android.apps.photosgo"; // CHANGE THIS

        // 1. Standard launcher (what you already do)
        Intent intent = getPackageManager().getLaunchIntentForPackage(pkg);

        if (intent == null) {

            // 2. Try ACTION_MAIN without CATEGORY_LAUNCHER
            intent = new Intent(Intent.ACTION_MAIN);
            intent.setPackage(pkg);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }

        try {
            startActivity(intent);
        } catch (Exception e) {

            // 3. Last fallback → Play Store
            Intent storeIntent = new Intent(Intent.ACTION_VIEW);
            storeIntent.setData(Uri.parse("market://details?id=" + pkg));
            startActivity(storeIntent);
        }

        finish(); // close launcher app
    }
}
