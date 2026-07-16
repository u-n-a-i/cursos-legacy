package com.unai.reproductor

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer
    private var isPlaying = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializa MediaPlayer con un archivo de audio en res/raw/audio.mp3
        mediaPlayer = MediaPlayer.create(this, R.raw.audio)

        val btnPlay = findViewById<Button>(R.id.btnPlay)
        val btnPause = findViewById<Button>(R.id.btnPause)
        val btnStop = findViewById<Button>(R.id.btnStop)

        btnPlay.setOnClickListener {
            if (!isPlaying) {
                mediaPlayer.start()
                isPlaying = true
            }
        }

        btnPause.setOnClickListener {
            if (isPlaying && mediaPlayer.isPlaying) {
                mediaPlayer.pause()
                isPlaying = false
            }
        }

        btnStop.setOnClickListener {
            if (isPlaying || mediaPlayer.isPlaying) {
                mediaPlayer.stop()
                isPlaying = false
                // Para poder reproducir de nuevo después de stop(), hay que reiniciar
                mediaPlayer = MediaPlayer.create(this, R.raw.audio)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::mediaPlayer.isInitialized) {
            if (mediaPlayer.isPlaying) mediaPlayer.stop()
            mediaPlayer.release()
        }
    }
}