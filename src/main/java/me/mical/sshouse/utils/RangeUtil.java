package me.mical.sshouse.utils;

import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class RangeUtil {

    /**
     * 计算两个 Location 的中心位置.
     * @param loc1 第一个位置
     * @param loc2 第二个位置
     * @param y 是否计算 Y 坐标
     * @return 中心坐标
     */
    public static Location getCenter(@NotNull Location loc1, @NotNull Location loc2, boolean y) {
        if (!Objects.equals(loc1.getWorld(), loc2.getWorld())) {
            return null;
        }
        final int x1 = loc1.getBlockX();
        final int z1 = loc1.getBlockZ();
        final int x2 = loc2.getBlockX();
        final int z2 = loc2.getBlockZ();
        if (y) {
            final int y1 = loc1.getBlockY();
            final int y2 = loc2.getBlockY();
            return new Location(loc1.getWorld(), (x1 + x2) / 2.0, (y1 + y2) / 2.0, (z1 + z2) / 2.0);
        }
        return new Location(loc1.getWorld(), (x1 + x2) / 2.0, loc1.getY(), (z1 + z2) / 2.0);
    }
}
