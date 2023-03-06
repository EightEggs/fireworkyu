package io.github.eighteggs.fireworkyu;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FireworkyuExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (sender instanceof Player player) {
            Location loc = player.getLocation();
            FireworkyuUtil.setFirework(loc);
            return true;
        }
        sender.sendMessage("only player can use");
        return false;
    }
}
