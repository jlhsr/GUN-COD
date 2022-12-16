package cn.cookiestudio.gun.guns.achieve;

import cn.cookiestudio.gun.guns.ItemGunBase;
import cn.cookiestudio.gun.guns.ItemMagBase;
import cn.nukkit.block.customblock.CustomBlockDefinition;
import cn.nukkit.block.customblock.data.Materials;
import cn.nukkit.block.customblock.data.Permutation;
import cn.nukkit.block.customblock.data.Permutations;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.item.Item;
import cn.nukkit.item.customitem.CustomItemDefinition;
import cn.nukkit.item.customitem.data.ItemCreativeCategory;
import cn.nukkit.item.customitem.data.Offset;
import cn.nukkit.item.customitem.data.RenderOffsets;
import cn.nukkit.nbt.tag.CompoundTag;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public CustomItemDefinition getDefinition() {
        return CustomItemDefinition
                .bu

                .renderOffsets(new RenderOffsets(
                        Offset.builder()
                                .scale(0.0f, 0.0f, 0.0f),
                        Offset.builder()
                                .scale(0.0f, 0.0f, 0.0f)

                        )
                )
                .creativeGroup("itemGroup.name.sword")
                .allowOffHand(false)
                .handEquipped(true)
                ;
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
