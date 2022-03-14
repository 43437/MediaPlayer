package cn.maxkot.mediaplayer;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NativeWindowActivity extends Activity implements SurfaceHolder.Callback, View.OnClickListener {

    private SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;
    private EditText editText;
    private Button btnClick;
    private boolean created = false;
    private static final String TAG = "maxD";

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("NativeWindow");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native_window);

        editText = findViewById(R.id.file_path);
        btnClick = findViewById(R.id.btn_play);
        btnClick.setOnClickListener(this);

        surfaceView = (SurfaceView) findViewById(R.id.videoSurface);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
    }

    @Override
    public void onClick(View v) {
        if (!created){
            Log.w(TAG, "surface not created, now return. ");
            return;
        }
        String path = editText.getText().toString();
        native_setFile(path);

        new Thread(new Runnable() {
            @Override
            public void run() {
                native_play(surfaceHolder.getSurface());
            }
        }).start();
    }

    private native int native_play(Surface surface);
    private native void native_setFile(String filepath);

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        created = true;
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
