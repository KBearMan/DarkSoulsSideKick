package zeik.darksoulsequipmentcalculator;

import android.net.LinkAddress;

/**
 * Created by Zeik on 1/13/2015.
 */
public class Armor {
    String Name;
    LinkAddress itemImage;
    enum ArmorType
    {
        Head,
        Chest,
        Arms,
        Legs
    }
    enum Set
    {
        Adventurers_Set,
        Antiquated_Set,
        Balder_Set,
        Big_Hats_Set,
        Brigand_Set,
        Black_Iron_Set,
        Black_Knight_Set,
        Black_Set,
        Black_Leather_Set,
        Black_Sorcerer_Set,
        Brass_Set,
        Catarina_Set,
        Chain_Set,
        Chesters_Set,
        Cleric_Set,
        Crimson_Set,
        Crystalline_Set,
        Dark_Set,
        Dingy_Set,
        Eastern_Set,
        Elite_Knight_Set,
        Giant_Set,
        GoldHemmed_Black_Set,
        Golem_Set,
        Guardian_Set,
        Hard_Leather_Set,
        Havels_Set,
        Hawkeye_Goughs_Set,
        Hollow_Soldier_Set,
        Hollow_Thiefs_Set,
        Hollow_Warrior_Set,
        Holy_Set,
        IronAndSun_Set,
        Knight_Set,
        Leather_Set,
        Lords_Blade_Ciarans_Set,
        Maiden_Set,
        Moonlight_Set,
        Ornsteins_Set,
        Painting_Guardian_Set,
        Paladin_Set,
        Set_of_Artorias,
        Set_of_Favor,
        Set_of_Thorns,
        Set_of_the_Channelers,
        Set_of_the_Great_Lord,
        Shadow_Set,
        Silver_Knight_Set,
        Smoughs_Set,
        Sorcerer_Set,
        Steel_Set,
        Stone_Set,
        Tattered_Cloth_Set,
        Wanderer_Set,
        Witch_Set,
        Xanthous_Set,
    }

    int PhysicalDefense[] = new int[6]; //Normal,Striking,Slashing,Thrusting
    int ElementalDefense[] = new int[3]; //Magic,Fire,Lightning
    int Requirements[] = new int[3]; //Bleed,Poison,Curse
    int Poise;
    int Durability;
    float Weight;
    int SoulValue;
    int PurchaseCost;
}
