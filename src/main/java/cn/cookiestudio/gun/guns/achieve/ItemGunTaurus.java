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
public class ItemGunTaurus extends ItemGunBase {

    public ItemGunTaurus() {
        super(getGunData(ItemGunTaurus.class).getGunName());
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
        return 1;
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
        return 0.2f;
    }

    @Override
    public ItemMagBase getItemMagObject() {
        return new ItemMagTaurus();
    }

    public static class ItemMagTaurus extends ItemMagBase {

        public ItemMagTaurus() {
            super(getGunData(ItemGunTaurus.class).getMagName());
            this.setCustomName(getGunData(ItemGunTaurus.class).getMagName());
        }

        @Override
        public int getSkinId() {
            return 2;
        }

        @Override
        public float getDropItemScale() {
            return 0.2f;
        }
    }
}
