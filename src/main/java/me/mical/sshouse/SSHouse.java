package me.mical.sshouse;

import me.mical.sshouse.config.SettingsConf;
import org.jetbrains.annotations.NotNull;
import org.serverct.parrot.parrotx.PPlugin;
import org.serverct.parrot.parrotx.hooks.VaultUtil;

import java.io.File;

public final class SSHouse extends PPlugin {

    private static SSHouse instance;

    public static SSHouse getInstance() {
        return instance;
    }

    private VaultUtil vaultUtil;

    @Override
    public void onEnable() {
        instance = this;
        super.onEnable();
    }

    @Override
    protected void load() {
        vaultUtil = new VaultUtil(this, SettingsConf.isEnableVault());
    }

    @NotNull
    public File getSchematicFile() {
        final File file = getFile(SettingsConf.getSchematicPath());
        if (!file.exists()) {
            saveResource(SettingsConf.getSchematicPath(), false);
            lang.log.warn("未找到 &c{0}&f, 已自动生成.", SettingsConf.getSchematicPath());
            if (!file.exists()) {
                lang.log.warn("未找到内置家园模板文件: &c{0}&f.", SettingsConf.getSchematicPath());
            }
        }
        return file;
    }
}
