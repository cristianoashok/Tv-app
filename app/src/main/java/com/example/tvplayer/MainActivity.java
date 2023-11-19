package com.example.tvplayer;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;

public class MainActivity extends AppCompatActivity {

    private PlayerView playerView;
    private SimpleExoPlayer player;
    private Button playButton;
    private Button pauseButton;
    private Button stopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerView = findViewById(R.id.player_view);
        playButton = findViewById(R.id.play_button);
        pauseButton = findViewById(R.id.pause_button);
        stopButton = findViewById(R.id.stop_button);

        // Use the updated constructor for SimpleExoPlayer.Builder
        player = new SimpleExoPlayer.Builder(this, new DefaultRenderersFactory(this)).build();
        playerView.setPlayer(player);

        Uri uri = Uri.parse("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4");

        // Use the updated constructor for MediaItem.Builder
        MediaItem mediaItem = new MediaItem.Builder().setUri(uri).build();
        player.setMediaItem(mediaItem);
        player.prepare();

        playButton.setOnClickListener(v -> player.setPlayWhenReady(true)); // Use lambda expression
        pauseButton.setOnClickListener(v -> player.setPlayWhenReady(false)); // Use lambda expression
        stopButton.setOnClickListener(v -> player.stop()); // Use lambda expression
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.release();
    }
}
