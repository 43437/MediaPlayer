package cn.maxkot.mediaplayer;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.Log;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class OpenglGraphicsDemoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_main);
        //Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());*/
        GLSurfaceView surfaceView = new GLSurfaceView(this);
        surfaceView.setRenderer(new NdkGlRender());
        setContentView(surfaceView);
    }
}


class NdkGlRender implements GLSurfaceView.Renderer {

    private static final String TAG = "NdkGlRender";

    native private void onNdkSurfaceCreated();
    native private void onNdkSurfaceChanged(int width, int height);
    native private void onNdkDrawFrame();

    // Used to load the 'OpengGraphicsDemo' library on application startup.
    static {
        System.loadLibrary("OpengGraphicsDemo");
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        Log.d(TAG, "onDrawFrame");
        onNdkDrawFrame();
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        Log.d(TAG, "onSurfaceCreated");
        onNdkSurfaceCreated();
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        Log.d(TAG, "onSurfaceChanged width height " + width + " " +height);
        onNdkSurfaceChanged(width, height);
    }
}
