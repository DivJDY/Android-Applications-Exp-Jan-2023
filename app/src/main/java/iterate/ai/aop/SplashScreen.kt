package iterate.ai.aop

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView

//import java.util.*
//import kotlin.concurrent.schedule


class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        var videoViewId: VideoView? = null

        videoViewId = findViewById(R.id.videoViewId)

        val path = "android.resource://" + packageName + "/" + R.raw.splash_screen_video
//        println("Splash path $path")
        val uri = Uri.parse(path)
        videoViewId!!.setVideoURI(uri)
        videoViewId!!.start()

//        Timer().schedule(3000){
//            //do something
//            videoViewId!!.setOnCompletionListener {
////                if (isFinishing) {
////                    true
////                }
////                startActivity(Intent(this, MainActivity::class.java))
//                startActivity(Intent(this@SplashScreen,MainActivity::class.java))
//
//                finish()
//            }
//
//        }


        videoViewId!!.setOnCompletionListener {
            if (isFinishing) {
                true
            }
            startActivity(Intent(this, MainActivity::class.java))

            finish()
        }

    }
}