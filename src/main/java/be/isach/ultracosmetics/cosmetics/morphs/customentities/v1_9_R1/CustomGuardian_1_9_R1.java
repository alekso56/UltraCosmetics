package be.isach.ultracosmetics.cosmetics.morphs.customentities.v1_9_R1;

import be.isach.ultracosmetics.cosmetics.morphs.MorphType;
import net.minecraft.server.v1_9_R1.DataWatcherRegistry;
import net.minecraft.server.v1_9_R1.EntityGuardian;
import net.minecraft.server.v1_9_R1.SoundEffect;
import net.minecraft.server.v1_9_R1.World;
import org.bukkit.craftbukkit.v1_9_R1.entity.CraftArmorStand;
import org.bukkit.entity.ArmorStand;

/**
 * Created by Sacha on 19/12/15.
 */
public class CustomGuardian_1_9_R1 extends EntityGuardian {

    private boolean custom;

    public CustomGuardian_1_9_R1(World world) {
        super(world);
    }

    public void check() {
        custom = MorphType.customEntities.contains(this);
    }

    public void target(ArmorStand armorStand) {
        getDataWatcher().set(DataWatcherRegistry.c.a(17), (float) (armorStand == null ? 0 : ((CraftArmorStand) armorStand).getHandle().getId()));
//        getDataWatcher().set(armorStand == null ? 0 : ((CraftArmorStand) armorStand).getHandle().getId(), 17);
    }

    @Override
    protected SoundEffect G() {
        if (custom) return null;
        else return super.G();
    }

    @Override
    protected SoundEffect bR() {
        if (custom) return null;
        else return super.bR();
    }

    @Override
    protected SoundEffect bS() {
        if (custom) return null;
        else return super.bS();
    }

    @Override
    public void m() {
        if (!custom) super.m();
        else setHealth(getMaxHealth());
    }
}
