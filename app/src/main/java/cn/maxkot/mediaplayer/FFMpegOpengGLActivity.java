package cn.maxkot.mediaplayer;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class FFMpegOpengGLActivity extends Activity {

    private GLSurfaceView glSurfaceView;
    private FFMpegRender ffmpegRenderer;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ffmpeg_openg_gl);

        glSurfaceView = (GLSurfaceView) findViewById(R.id.video_surface);
        editText = (EditText) findViewById(R.id.fileUrl);
        ffmpegRenderer = new FFMpegRender();
        glSurfaceView.setRenderer(ffmpegRenderer);
    }

    public void onClicked(View view){

        String filePath= editText.getEditableText().toString();
        ffmpegRenderer.native_play(filePath);
    }

}

class FFMpegRender implements GLSurfaceView.Renderer {

    private native void surfaceChange(int width, int height);
    private native void createSurface();
    private native void drawFrame();
    public native void native_play(String file);

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("OpenGLDemo");
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
//        surfaceChange(width, height);
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        createSurface();
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        drawFrame();
    }
}

