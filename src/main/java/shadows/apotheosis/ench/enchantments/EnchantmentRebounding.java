package shadows.apotheosis.ench.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.math.Vec3d;
import shadows.apotheosis.ApotheosisObjects;

public class EnchantmentRebounding extends Enchantment {

	public EnchantmentRebounding() {
		super(Rarity.RARE, EnchantmentType.ARMOR, new EquipmentSlotType[] { EquipmentSlotType.CHEST, EquipmentSlotType.LEGS });
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	public int getMinEnchantability(int level) {
		return 30 + 7 * level;
	}

	@Override
	public int getMaxEnchantability(int level) {
		return getMinEnchantability(level) + 30;
	}

	@Override
	public void onUserHurt(LivingEntity user, Entity attacker, int level) {
		if (attacker != null && user.getDistanceSq(attacker) <= 4D) {
			level = EnchantmentHelper.getMaxEnchantmentLevel(ApotheosisObjects.REBOUNDING, user);
			Vec3d vec = new Vec3d(attacker.func_226277_ct_() - user.func_226277_ct_(), attacker.func_226278_cu_() - user.func_226278_cu_(), attacker.func_226281_cx_() - user.func_226281_cx_());
			attacker.addVelocity(vec.x * 2 * level, vec.y * 3 * level, vec.z * 2 * level);
		}
	}

}
