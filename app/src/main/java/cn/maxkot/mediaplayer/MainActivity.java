package cn.maxkot.mediaplayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNativeWindow = (Button) findViewById(R.id.btn_native_window);
        btnNativeWindow.setOnClickListener(this);

        Button btnOpenglVideo = (Button) findViewById(R.id.btn_opengl_video);
        btnOpenglVideo.setOnClickListener(this);

        Button btnOpenglGraphics = (Button) findViewById(R.id.btn_opengl_graphics);
        btnOpenglGraphics.setOnClickListener(this);

        Button btnSDL = (Button) findViewById(R.id.btn_sdl);
        btnSDL.setOnClickListener(this);

        Button btnOpensl = (Button) findViewById(R.id.btn_opensl);
        btnOpensl.setOnClickListener(this);

        Button btnAudioTrack = (Button) findViewById(R.id.btn_audiotrack);
        btnAudioTrack.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        switch (v.getId()){
            case R.id.btn_native_window:
                Intent startNativeWindow = new Intent(this, cn.maxkot.mediaplayer.NativeWindowActivity.class);
                startActivity(startNativeWindow);
                break;
            case R.id.btn_opengl_video:
                Intent startOpenGL = new Intent(this, cn.maxkot.mediaplayer.FFMpegOpengGLActivity.class);
                startActivity(startOpenGL);
                break;
            case R.id.btn_opengl_graphics:
                Intent startOpenglGraphics = new Intent(this, cn.maxkot.mediaplayer.OpenglGraphicsDemoActivity.class);
                startActivity(startOpenglGraphics);
                break;
            case R.id.btn_sdl:
                Intent startSDL = new Intent(this, org.libsdl.app.SDLActivity.class);
                startActivity(startSDL);
                break;
            case R.id.btn_opensl:
                Intent startOpenSL = new Intent(this, cn.maxkot.mediaplayer.OpenSLDemoActivity.class);
                startActivity(startOpenSL);
                break;
            case R.id.btn_audiotrack:
                Intent startAudioTrack = new Intent(this, cn.maxkot.mediaplayer.AudioTrackDemoActivity.class);
                startActivity(startAudioTrack);
                break;
        }
    }
}
