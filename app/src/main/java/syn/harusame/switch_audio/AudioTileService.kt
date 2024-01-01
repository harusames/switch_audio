package syn.harusame.switch_audio

import android.media.AudioManager
import android.service.quicksettings.Tile
import android.service.quicksettings.TileService

class AudioTileService : TileService() {

    override fun onClick() {
        super.onClick()

        // Toggle audio between earpiece and speaker
        val audioManager = getSystemService(AudioManager::class.java)// Switch to speaker

        // Switch to earpiece
        MyAudioManager.setIsSpeakerOn(audioManager, !MyAudioManager.getIsSpeakerOn(audioManager))

        // Update the tile state
        updateTile()
    }

    override fun onStartListening() {
        super.onStartListening()

        // Initialize the tile
        updateTile()
    }

    private fun updateTile() {
        val tile = qsTile
        tile.state =
            if (MyAudioManager.getIsSpeakerOn(getSystemService(AudioManager::class.java))) Tile.STATE_ACTIVE else Tile.STATE_INACTIVE
        tile.updateTile()
    }

    override fun onTileRemoved() {
        super.onTileRemoved()
    }

    override fun onTileAdded() {
        super.onTileAdded()
        updateTile()
    }
}
