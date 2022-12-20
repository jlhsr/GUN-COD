package cn.cookiestudio.gun.guns.achieve;

import cn.cookiestudio.gun.guns.ItemGunBase;
import cn.cookiestudio.gun.guns.ItemMagBase;
import cn.nukkit.item.customitem.data.Offset;
import lombok.Getter;

@Getter
public class ItemGunAk47 extends ItemGunBase {

    public ItemGunAk47() {
        super(getGunData(ItemGunAk47.class).getGunName());
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
        return 12;
    }

    @Override
    public float getDropItemScale() {
        return 0.00f;
    }







    @Override
    public Offset scaleOffset() {
        Offset offset = Offset.builder().scale(0,0,0).position(0,0,0).rotation(0,0,0);
        return offset;
    }

    @Override
    public ItemMagBase getItemMagObject() {
        return new ItemMagAk47();
    }

    public static class ItemMagAk47 extends ItemMagBase {

        public ItemMagAk47() {
            super(getGunData(ItemGunAk47.class).getMagName());
            this.setCustomName(getGunData(ItemGunAk47.class).getMagName());
        }

        @Override
        public int getSkinId() {
            return 13;
        }

        @Override
        public float getDropItemScale() {
            return 0.00f;
        }
    }
}
