package cn.cookiestudio.gun.guns.achieve;

import cn.cookiestudio.gun.guns.ItemGunBase;
import cn.cookiestudio.gun.guns.ItemMagBase;
import cn.nukkit.item.customitem.data.Offset;
import cn.nukkit.item.customitem.data.RenderOffsets;
import lombok.Getter;

@Getter
public class ItemGunM3 extends ItemGunBase {

    public ItemGunM3() {
        super(getGunData(ItemGunM3.class).getGunName());
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
        return 9;
    }

    @Override
    public Offset scaleOffset() {
        Offset offset = Offset.builder().scale(0,0,0).position(0,0,0).rotation(0,0,0);
        return offset;
    }

    @Override
    public float getDropItemScale() {
        return 0.1f;
    }

    @Override
    public ItemMagBase getItemMagObject() {
        return new ItemMagM3();
    }

    public static class ItemMagM3 extends ItemMagBase {

        public ItemMagM3() {
            super(getGunData(ItemGunM3.class).getMagName());
            this.setCustomName(getGunData(ItemGunM3.class).getMagName());
        }

        @Override
        public int getSkinId() {
            return 10;
        }

        @Override
        public float getDropItemScale() {
            return 0.1f;
        }

        @Override
        public int getMaxStackSize() {
            return 64;
        }
    }
}
