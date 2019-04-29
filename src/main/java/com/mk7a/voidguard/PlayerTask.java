package com.mk7a.voidguard;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerTask extends BukkitRunnable {

    private final Player player;
    private Location lastLocation;

    protected PlayerTask(Player player) {
        this.player = player;
        lastLocation = player.getLocation();
    }

    @Override
    public void run() {

        Location currentLocation = player.getLocation();

        if (currentLocation.getY() <= -1D) {
            player.teleport(lastLocation);
            player.setFallDistance(0);

        } else {

            boolean onGround = false;
            for (int x=1; x <= 5; x++) {
                if (!currentLocation.getBlock().getRelative(0, -x, 0).getType().equals(Material.AIR)) {
                    onGround = true;
                    break;
                }
            }

            if (onGround) {
                this.lastLocation = currentLocation;
            }
        }
    }
}

