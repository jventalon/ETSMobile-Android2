package ca.etsmtl.applets.etsmobile.util;

import android.app.Application;
import android.util.Log;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class AnalyticsHelper {
    private static final String TAG = "GANALYTICS";

    private static Tracker tracker;
    private static Application application;

    public static void initialiserTracker(Application app, String propertyId) {
        GoogleAnalytics googleAnalytics = GoogleAnalytics.getInstance(app);
        application = app;

        googleAnalytics.setLocalDispatchPeriod(2);
        tracker = googleAnalytics.newTracker(propertyId);
        tracker.enableExceptionReporting(true);
        tracker.enableAdvertisingIdCollection(false);
    }

    public static void sendScreenView(String screenName) {
        Log.i(TAG, "Setting screen name: " + screenName);
        tracker.setScreenName(screenName);
        tracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    public static void sendEvent() {
        tracker.send(new HitBuilders.EventBuilder().setCategory("Action").setAction("Share").build());
        Log.i(TAG, "Sends events");
    }

}
