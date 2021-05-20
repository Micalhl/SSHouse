package me.mical.sshouse.config;

import me.mical.sshouse.SSHouse;
import org.serverct.parrot.parrotx.config.PConfig;
import org.serverct.parrot.parrotx.data.autoload.annotations.PAutoload;
import org.serverct.parrot.parrotx.data.autoload.annotations.PAutoloadGroup;

@PAutoloadGroup
@PAutoloadGroup(name = "Schematic")
@PAutoloadGroup(name = "Residence")
@PAutoloadGroup(name = "Vault")
public class SettingsConf extends PConfig {

    @PAutoload(group = "Schematic", value = "Path")
    private static String schematicPath;

    @PAutoload(group = "Schematic", value = "MiddleX")
    private static int middleX;

    @PAutoload(group = "Schematic", value = "MiddleY")
    private static int middleZ;

    @PAutoload(group = "Residence", value = "Radius")
    private static int residenceRadius;

    @PAutoload(group = "Vault", value = "Enable")
    private static boolean enableVault;

    @PAutoload(group = "Vault", value = "ServiceCharge")
    private static double serviceCharge;

    public SettingsConf() {
        super(SSHouse.getInstance(), "settings", "主配置文件");
    }

    public static String getSchematicPath() {
        return schematicPath;
    }

    public static int getMiddleX() {
        return middleX;
    }

    public static int getMiddleZ() {
        return middleZ;
    }

    public static int getResidenceRadius() {
        return residenceRadius;
    }

    public static boolean isEnableVault() {
        return enableVault;
    }

    public static double getServiceCharge() {
        return serviceCharge;
    }
}
