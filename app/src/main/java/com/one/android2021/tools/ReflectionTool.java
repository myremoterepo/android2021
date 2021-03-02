package com.one.android2021.tools;

import android.util.Log;

/**
 * Created by fanzengfu on 2021-03-02.
 */
public class ReflectionTool {
    private static final String TAG = "ReflectionTool";

    public static void staticMethod(String[] param) {
        Log.d(TAG, "staticMethod");
        // TODO: 2021/3/2  
    }
    
    public void normalMethod(String[] param) {
        Log.d(TAG, "normalMethod");
        // TODO: 2021/3/2  
    }
    
    private static void staticPrivateMethod(String[] param) {
        Log.d(TAG, "staticPrivateMethod");
        // TODO: 2021/3/2  
    }
    
    private void normalPrivateMethod(String[] parma) {
        Log.d(TAG, "normalPrivateMethod");
        // TODO: 2021/3/2  
    }

}
