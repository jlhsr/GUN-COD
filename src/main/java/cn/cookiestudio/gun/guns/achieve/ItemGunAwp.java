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
public class ItemGunAwp extends ItemGunBase {

    public ItemGunAwp() {
        super(getGunData(ItemGunAwp.class).getGunName());
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
        return 5;
    }

    @Override
    public Map<Double, Integer> scaleOffset() {
        Map<Double,Integer> map = new HashMap<>();
        map.put(0.1,1);  //”age“是key，类似于索引，1是索引对应的int值
        map.put(0.1,2);

        return map;
    }

    @Override
    public float getDropItemScale() {
        return 0.1f;
    }

    @Override
    public ItemMagBase getItemMagObject() {
        return new ItemMagAwp();
    }

    public static class ItemMagAwp extends ItemMagBase {

        public ItemMagAwp() {
            super(getGunData(ItemGunAwp.class).getMagName());
            this.setCustomName(getGunData(ItemGunAwp.class).getMagName());
        }

        @Override
        public int getSkinId() {
            return 6;
        }

        @Override
        public float getDropItemScale() {
            return 0.15f;
        }
    }
}
