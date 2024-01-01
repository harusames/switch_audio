package syn.harusame.switch_audio;

import android.media.AudioManager;

public class MyAudioManager {

    public static void setIsSpeakerOn(AudioManager audioManager, boolean isSpeakerOn) {
        audioManager.setMode(isSpeakerOn ? AudioManager.MODE_NORMAL : AudioManager.MODE_IN_COMMUNICATION);
        audioManager.setSpeakerphoneOn(isSpeakerOn);
    }

    public static boolean getIsSpeakerOn(AudioManager audioManager) {
        return audioManager.isSpeakerphoneOn();
    }
}
