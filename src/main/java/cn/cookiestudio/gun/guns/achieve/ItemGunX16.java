package cn.cookiestudio.gun.guns.achieve;

import cn.cookiestudio.gun.guns.ItemGunBase;
import cn.cookiestudio.gun.guns.ItemMagBase;
import cn.nukkit.item.customitem.data.Offset;
import cn.nukkit.item.customitem.data.RenderOffsets;
import lombok.Getter;

@Getter
public class ItemGunX16 extends ItemGunBase {

    public ItemGunX16() {
        super(getGunData(ItemGunX16.class).getGunName());
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
    public Offset scaleOffset() {
        Offset offset = Offset.builder().scale(0,0,0).position(0,0,0).rotation(0,0,0);
        return offset;
    }

    @Override
    public float getDropItemScale() {
        return 0.2f;
    }

    @Override
    public ItemMagBase getItemMagObject() {
        return new ItemMagX16();
    }

    public static class ItemMagX16 extends ItemMagBase {

        public ItemMagX16() {
            super(getGunData(ItemGunX16.class).getMagName());
            this.setCustomName(getGunData(ItemGunX16.class).getMagName());
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
