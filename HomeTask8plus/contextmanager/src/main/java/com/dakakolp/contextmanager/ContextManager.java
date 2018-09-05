package com.dakakolp.contextmanager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class ContextManager {

    private Context context;

    public ContextManager(Context context) {
        this.context = context;
    }

    public void invokeActivity(Class<?> cls, Bundle bundleForActivity) {
        Intent intent = new Intent(context, cls);
        context.startActivity(intent, bundleForActivity);
    }

    public void invokeActivity(Class<?> cls) {
        Intent intent = new Intent(context, cls);
        context.startActivity(intent);
    }


    public void invokeActivities(Class<?> cls1, Class<?> cls2) {

            Intent intent1 = new Intent(context, cls1);
            context.startActivity(intent1);

            Intent intent2 = new Intent(context, cls2);
            context.startActivity(intent2);

    }

}
