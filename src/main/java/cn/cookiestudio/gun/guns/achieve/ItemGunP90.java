package cn.cookiestudio.gun.guns.achieve;

import cn.cookiestudio.gun.guns.ItemGunBase;
import cn.cookiestudio.gun.guns.ItemMagBase;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.nbt.tag.FloatTag;
import cn.nukkit.nbt.tag.ListTag;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class ItemGunP90 extends ItemGunBase {

    public ItemGunP90() {
        super(getGunData(ItemGunP90.class).getGunName());
        gunData = getGunData(this.getClass());
        this.setCustomName(gunData.getGunName());
        if (!this.getNamedTag().contains("ammoCount")) {
            this.setAmmoCount(this.getGunData().getMagSize());
        } else {
            this.setAmmoCount(this.getAmmoCount());
        }
    }


    public void doInit() {
    }

    @Override
    public int getSkinId() {
        return 3;
    }

    @Override
    public Map<Double, Integer> scaleOffset() {
        Map<Double,Integer> map = new HashMap<>();
        map.put(0.1,1);
        map.put(0.1,2);

        return map;
    }

    @Override
    public float getDropItemScale() {
        return 0.1f;
    }

    @Override
    public ItemMagBase getItemMagObject() {
        return new ItemMagP90();
    }

    public static class ItemMagP90 extends ItemMagBase {

        public ItemMagP90() {
            super(getGunData(ItemGunP90.class).getMagName());
            this.setCustomName(getGunData(ItemGunP90.class).getMagName());
        }

        @Override
        public int getSkinId() {
            return 4;
        }

        @Override
        public float getDropItemScale() {
            return 0.1f;
        }
    }
}
