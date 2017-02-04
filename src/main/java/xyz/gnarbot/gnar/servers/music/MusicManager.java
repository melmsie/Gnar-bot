package xyz.gnarbot.gnar.servers.music;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;

public class MusicManager {
    public final AudioPlayerManager playerManager;

    /**
     * Audio player for the guild.
     */
    public final AudioPlayer player;
    /**
     * Track scheduler for the player.
     */
    public final TrackScheduler scheduler;
    /**
     * Wrapper around AudioPlayer to use it as an AudioSendHandler.
     */
    public final AudioPlayerSendHandler sendHandler;

    /**
     * Creates a player and a track scheduler.
     *
     * @param playerManager Audio player playerManager to use for creating the player.
     */
    public MusicManager(AudioPlayerManager playerManager) {
        this.playerManager = playerManager;
        player = playerManager.createPlayer();
        scheduler = new TrackScheduler(player);
        sendHandler = new AudioPlayerSendHandler(player);
        player.addListener(scheduler);
    }
}