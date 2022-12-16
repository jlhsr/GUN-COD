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
public class ItemGunMk18 extends ItemGunBase {

    public ItemGunMk18() {
        super(getGunData(ItemGunMk18.class).getGunName());
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
        return 16;
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
        return 0.06f;
    }

    @Override
    public ItemMagBase getItemMagObject() {
        return new ItemMagMk18();
    }

    public static class ItemMagMk18 extends ItemMagBase {

        public ItemMagMk18() {
            super(getGunData(ItemGunMk18.class).getMagName());
            this.setCustomName(getGunData(ItemGunMk18.class).getMagName());
        }

        @Override
        public int getSkinId() {
            return 17;
        }

        @Override
        public float getDropItemScale() {
            return 0.05f;
        }
    }
}
