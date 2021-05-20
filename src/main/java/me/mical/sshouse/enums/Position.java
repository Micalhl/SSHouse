package me.mical.sshouse.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Position {
    NORTH, SOUTH, WEST, EAST;

    public static Position of(float loc) {
        final float yaw = getFloat(loc);
        if (yaw == 180f) return NORTH;
        if (yaw == 0f || yaw == 360f) return SOUTH;
        if (yaw == 90f) return WEST;
        if (yaw == 270f) return EAST;
        return null;
    }

    public static float getFloat(float target) {
        final List<Float> difference = new ArrayList<>();
        final List<Float> yaws = new ArrayList<>(Arrays.asList(0f, 90f, 180f, 270f, 360f));
        yaws.forEach(yaw -> difference.add(Math.abs(yaw - target)));
        int index = 0;
        float temp = difference.get(0);
        for (int i = 0; i < difference.size(); i++) {
            if (difference.get(i) < temp) {
                temp = difference.get(i);
                index = i;
            }
        }
        return yaws.get(index);
    }
}
