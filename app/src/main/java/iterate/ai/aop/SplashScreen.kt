package iterate.ai.aop

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        var videoViewId: VideoView? = null
        videoViewId = findViewById(R.id.videoViewId)
        val path = "android.resource://" + packageName + "/" + R.raw.splash_screen_video
        val uri = Uri.parse(path)
        videoViewId!!.setVideoURI(uri)
        videoViewId!!.start()

        videoViewId!!.setOnCompletionListener {
            if (isFinishing) {
                true
            }
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }
}