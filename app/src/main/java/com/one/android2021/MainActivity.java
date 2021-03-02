package com.one.android2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.one.android2021.tools.ReflectionTool;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String CLASS_NAME_REFLECTION = "com.one.android2021.tools.ReflectionTool";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        triggerReflection();
    }

    Class<?> mReflectionTool;

    private void triggerReflection() {
        Log.d(TAG, "triggerReflection");
        try {
            mReflectionTool = Class.forName(CLASS_NAME_REFLECTION);
            String[] s = new String[]{"tom", "rose"};

            //调用静态方法
            Method staticMethod = mReflectionTool.getMethod("staticMethod", String[].class);
            staticMethod.invoke(null, (Object) s);

            //调用非静态方法
            Constructor<?> constructor = mReflectionTool.getConstructor();
            ReflectionTool reflectionTool = (ReflectionTool) constructor.newInstance();
            Method normalMethod = mReflectionTool.getMethod("normalMethod", String[].class);
            normalMethod.invoke(reflectionTool, (Object) s);

            //调用私有静态方法
            Method staticPrivateMethod = mReflectionTool.getDeclaredMethod("staticPrivateMethod", String[].class);
            staticPrivateMethod.setAccessible(true);
            staticPrivateMethod.invoke(reflectionTool, (Object) s);

            //调用私有非静态方法
            Method normalPrivateMethod = mReflectionTool.getDeclaredMethod("normalPrivateMethod", String[].class);
            normalPrivateMethod.setAccessible(true);
            normalPrivateMethod.invoke(reflectionTool, (Object) s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}