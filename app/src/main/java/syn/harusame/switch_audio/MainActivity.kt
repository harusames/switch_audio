package syn.harusame.switch_audio

import android.media.AudioManager
import android.os.Bundle
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // create an android kotlin app that switches between the phone and speaker audio and also adds a Quick Settings tile for it
    // MAYBE: and make sure the value in the app is updated if modified from quick settings and vice-versa (ex: using SharedPreferences)
    private lateinit var audioManager: AudioManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        audioManager = getSystemService(AudioManager::class.java)

        val speakerSwitch = findViewById<Switch>(R.id.speakerSwitch)
        speakerSwitch.isChecked = MyAudioManager.getIsSpeakerOn(audioManager)
        speakerSwitch.setOnCheckedChangeListener { _, isChecked ->
            MyAudioManager.setIsSpeakerOn(audioManager, isChecked)
        }
    }
}
