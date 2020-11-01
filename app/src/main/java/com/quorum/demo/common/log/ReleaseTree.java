package com.quorum.demo.common.log;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import timber.log.Timber;

public class ReleaseTree extends Timber.Tree
{

    @Override
    protected void log(final int priority, @Nullable final String tag, @NonNull final String message,
                       @Nullable final Throwable t) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            return;
        }

        // Log --> ERROR, WARN

        // log your crash to your favourite
        // Sending crash report to Firebase CrashAnalytics

        // FirebaseCrash.report(message);
        // FirebaseCrash.report(new Exception(message));
    }
}
