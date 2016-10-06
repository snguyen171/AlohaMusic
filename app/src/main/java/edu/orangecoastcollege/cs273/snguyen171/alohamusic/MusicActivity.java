package edu.orangecoastcollege.cs273.snguyen171.alohamusic;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MusicActivity extends AppCompatActivity {

    private MediaPlayer ukuleleMP;
    private MediaPlayer ipuMP;
    private MediaPlayer hulaMP;

    private Button ukuleleButton;
    private Button ipuButton;
    private Button hulaButton;

    private VideoView hulaVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        ukuleleButton = (Button) findViewById(R.id.ukuleleButton);
        ipuButton = (Button) findViewById(R.id.ipuButton);
        hulaButton = (Button) findViewById(R.id.hulaButton);

        hulaVideoView = (VideoView) findViewById(R.id.hulaVideoView);
        // Important
        hulaVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.hula));
        hulaVideoView.setMediaController(new MediaController(this));

        // Associate the media player objects with the raw files
        ukuleleMP = MediaPlayer.create(this, R.raw.ukulele);
        ipuMP = MediaPlayer.create(this, R.raw.ipu);

        // Associate the media player object with the hula video

    }

    public void playMedia(View view)
    {
        // Determine which button is clicked:
        switch (view.getId())
        {
            case R.id.ukuleleButton:
                if (ukuleleMP.isPlaying())
                {
                    ukuleleMP.pause();
                    ukuleleButton.setText(R.string.ukulele_button_play_text);
                    // Show the other two buttons(ipu and hula)
                    ipuButton.setVisibility(View.VISIBLE);
                    hulaButton.setVisibility(View.VISIBLE);
                }
                else
                {
                    ukuleleMP.start();
                    ukuleleButton.setText(R.string.ukulele_button_pause_text);
                    // Hide the other two buttons(ipu and hula)
                    ipuButton.setVisibility(View.INVISIBLE);
                    hulaButton.setVisibility(View.INVISIBLE);
                }
                break;

            case R.id.ipuButton:
                if(ipuMP.isPlaying())
                {
                    ipuMP.pause();
                    ipuButton.setText(R.string.ipu_button_play_text);
                    // Show the other two buttons(ipu and hula)
                    ukuleleButton.setVisibility(View.VISIBLE);
                    hulaButton.setVisibility(View.VISIBLE);
                }
                else
                {
                    ipuMP.start();
                    ipuButton.setText(R.string.ipu_button_pause_text);
                    // Show the other two buttons(ipu and hula)
                    ukuleleButton.setVisibility(View.INVISIBLE);
                    hulaButton.setVisibility(View.INVISIBLE);
                }
                break;

            case R.id.hulaButton:
                if (hulaVideoView.isPlaying())
                {
                    hulaVideoView.pause();
                    hulaButton.setText(R.string.hula_button_watch_text);
                    // Hide the other two buttons(ipu and hula)
                    ukuleleButton.setVisibility(View.VISIBLE);
                    ipuButton.setVisibility(View.VISIBLE);
                }
                else
                {
                    hulaVideoView.start();
                    hulaButton.setText(R.string.hula_button_pause_text);
                    // Hide the other two buttons(ipu and hula)
                    ukuleleButton.setVisibility(View.INVISIBLE);
                    ipuButton.setVisibility(View.INVISIBLE);
                }
                break;

        }
    }
}
