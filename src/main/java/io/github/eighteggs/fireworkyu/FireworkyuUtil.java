package io.github.eighteggs.fireworkyu;

import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.Random;


public class FireworkyuUtil {
    private FireworkyuUtil() {
        throw new IllegalStateException("Utility class");
    }

    private static final Random r = new Random(114514);

    public static void buildFirework(FireworkEffect.Builder fb) {
        fb.withColor(
                Color.fromRGB(r.nextInt(156) + 100, r.nextInt(156) + 100, r.nextInt(156) + 100),
                Color.fromRGB(r.nextInt(136) + 120, r.nextInt(136) + 120, r.nextInt(136) + 120),
                Color.fromRGB(r.nextInt(116) + 140, r.nextInt(116) + 140, r.nextInt(116) + 140),
                Color.fromRGB(r.nextInt(96) + 160, r.nextInt(96) + 160, r.nextInt(96) + 160)
        );
        fb.withFade(
                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255)),
                Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255))
        );
        FireworkEffect.Type[] type = FireworkEffect.Type.values();
        fb.with(type[r.nextInt(type.length)]);
        int t = r.nextInt(64);
        if (t % 2 == 0) {
            fb.withFlicker();
        }
        if (t % 3 == 0 || t % 13 == 0) {
            fb.withTrail();
        }
    }

    public static void setFirework(Location loc) {
        if (Bukkit.getOnlinePlayers().isEmpty()||!loc.getChunk().isLoaded()) return;

        World world = Bukkit.getWorld("World");

        FireworkEffect.Builder fb = FireworkEffect.builder();
        buildFirework(fb);
        assert world != null;
        Firework fw = (Firework) world.spawnEntity(loc, EntityType.FIREWORK);
        FireworkMeta fwm = fw.getFireworkMeta();
        fwm.clearEffects();
        fwm.addEffect(fb.build());
        fwm.setPower(r.nextInt(3) + 1);
        fw.setPersistent(false);
        fw.setFireworkMeta(fwm);
    }

}