package pokemongame.pokemon;

import java.lang.Math;
import java.util.*;
import pokemongame.pokemove.*;
import pokemongame.typing.*;
import pokemongame.customcollections.*;

public abstract class Pokemon {

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // STATIC VARIABLES
    ////////////////////////////////////////////////////////////////////////////////////////////////////
   
    // Current highest dex number and level
    private static final int HIGHEST_DEX_NUMBER = 1008;
    private static final int MAX_LEVEL = 100;

    // All possible natures
    private static enum ALL_NATURES
        {Adamant,
        Bashful,
        Brave,
        Bold,
        Calm,
        Careful,
        Docile,
        Gentle,
        Hardy,
        Hasty,
        Impish,
        Jolly,
        Lax,
        Lonely,
        Mild,
        Modest,
        Naive,
        Naughty,
        Quiet,
        Quirky,
        Rash,
        Relaxed,
        Sassy,
        Serious,
        Timid};

    // static nature lookup table
    private static final Map<ALL_NATURES, double[]> NATURE_MAP = new EnumMap<ALL_NATURES, double[]>(ALL_NATURES.class);
    
    static {

        // Null Natures
        double[] nullType = {1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
        NATURE_MAP.put(ALL_NATURES.Bashful, nullType);
        NATURE_MAP.put(ALL_NATURES.Docile, nullType);
        NATURE_MAP.put(ALL_NATURES.Hardy, nullType);
        NATURE_MAP.put(ALL_NATURES.Quirky, nullType);
        NATURE_MAP.put(ALL_NATURES.Serious, nullType);

        // Atk Natures
        //                   hp   atk  def  spa  spd  speed
        double[] atkType1 = {1.0, 1.1, 1.0, 0.9, 1.0, 1.0};
        NATURE_MAP.put(ALL_NATURES.Adamant, atkType1);
        double[] atkType2 = {1.0, 1.1, 1.0, 1.0, 1.0, 0.9};
        NATURE_MAP.put(ALL_NATURES.Brave, atkType2);
        double[] atkType3 = {1.0, 1.1, 0.9, 1.0, 1.0, 1.0};
        NATURE_MAP.put(ALL_NATURES.Lonely, atkType3);
        double[] atkType4 = {1.0, 1.1, 1.0, 1.0, 0.9, 1.0};
        NATURE_MAP.put(ALL_NATURES.Naughty, atkType4);

        // Defense Natures
        //                   hp   atk  def  spa  spd  speed
        double[] defType1 = {1.0, 0.9, 1.1, 1.0, 1.0, 1.0};
        NATURE_MAP.put(ALL_NATURES.Bold, defType1);
        double[] defType2 = {1.0, 1.0, 1.1, 1.0, 1.0, 0.9};
        NATURE_MAP.put(ALL_NATURES.Relaxed, defType2);
        double[] defType3 = {1.0, 1.0, 1.1, 0.9, 1.0, 1.0};
        NATURE_MAP.put(ALL_NATURES.Impish, defType3);
        double[] defType4 = {1.0, 1.0, 1.1, 1.0, 0.9, 1.0};
        NATURE_MAP.put(ALL_NATURES.Lax, defType4);

        // Special Attack Natures
        //                     hp   atk  def  spa  spd  speed
        double[] spAtkType1 = {1.0, 0.9, 1.0, 1.1, 1.0, 1.0};
        NATURE_MAP.put(ALL_NATURES.Modest, spAtkType1);
        double[] spAtkType2 = {1.0, 1.0, 0.9, 1.1, 1.0, 1.0};
        NATURE_MAP.put(ALL_NATURES.Mild, spAtkType2);
        double[] spAtkType3 = {1.0, 1.0, 1.0, 1.1, 1.0, 0.9};
        NATURE_MAP.put(ALL_NATURES.Quiet, spAtkType3);
        double[] spAtkType4 = {1.0, 1.0, 1.0, 1.1, 0.9, 1.0};
        NATURE_MAP.put(ALL_NATURES.Rash, spAtkType4);

        // Special Defense Natures
        //                     hp   atk  def  spa  spd  speed
        double[] spDefType1 = {1.0, 0.9, 1.0, 1.0, 1.1, 1.0};
        NATURE_MAP.put(ALL_NATURES.Calm, spDefType1);
        double[] spDefType2 = {1.0, 1.0, 0.9, 1.0, 1.1, 1.0};
        NATURE_MAP.put(ALL_NATURES.Gentle, spDefType2);
        double[] spDefType3 = {1.0, 1.0, 1.0, 1.0, 1.1, 0.9};
        NATURE_MAP.put(ALL_NATURES.Sassy, spDefType3);
        double[] spDefType4 = {1.0, 1.0, 1.0, 0.9, 1.1, 1.0};
        NATURE_MAP.put(ALL_NATURES.Careful, spDefType4);

        // Speed Natures
        //                     hp   atk  def  spa  spd  speed
        double[] speedType1 = {1.0, 0.9, 1.0, 1.0, 1.0, 1.1};
        NATURE_MAP.put(ALL_NATURES.Timid, speedType1);
        double[] speedType2 = {1.0, 1.0, 0.9, 1.0, 1.0, 1.1};
        NATURE_MAP.put(ALL_NATURES.Hasty, speedType2);
        double[] speedType3 = {1.0, 1.0, 1.0, 0.9, 1.0, 1.1};
        NATURE_MAP.put(ALL_NATURES.Jolly, speedType3);
        double[] speedType4 = {1.0, 1.0, 1.0, 1.0, 0.9, 1.1};
        NATURE_MAP.put(ALL_NATURES.Naive, speedType4);
    }

    // IV and EV constants
    private final static int MAXIMUM_SINGLE_IV = 31;
    private final static int MAXIMUM_TOTAL_EVS = 510;
    private final static int MAXIMUM_SINGLE_EV = 255;

    // Stat constants
    private final static int MAX_HP = 9999;
    private final static int MAX_STAT = 999;
    private final static double MAX_PERCENT = 1.00;

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // INSTANCE VARIABLES
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    // non stat instance variables for pokemon
    private final String pokeName;
    private final int dexNumber;
    private final ALL_NATURES nature;
    private final PokeType.ALL_TYPES[] type;

    private String name;
    private int level;

    // IV vars
    private final int hpIV;
    private final int atkIV;
    private final int defIV;
    private final int spAtkIV;
    private final int spDefIV;
    private final int speedIV;

    // EV vars
    private int hpEV;
    private int atkEV;
    private int defEV;
    private int spAtkEV;
    private int spDefEV;
    private int speedEV;
    private int currentEVTotal;

    // base stats
    private final int baseHp;
    private final int baseAtk;
    private final int baseDef;
    private final int baseSpAtk;
    private final int baseSpDef;
    private final int baseSpeed;

    // actual stats
    private int maxHp;
    private int currHp;
    private int atk;
    private int def;
    private int spAtk;
    private int spDef;
    private int speed;
    private double acc;
    private double evasion;

    // movelist
    private List<PokeMove> moveList;

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public Pokemon(String pokeName, int dexNumber, ALL_NATURES nature, PokeType.ALL_TYPES[] type, int baseHp, int baseAtk, int baseDef, int baseSpAtk, int baseSpDef, int baseSpeed, PokeMove[] moveList) throws Exception {

        // validate the type, nature, move list length, type array length and dex number data (UNFINISHED ADD CHECK FOR TYPING)
        if (dexNumber < 1 || dexNumber > HIGHEST_DEX_NUMBER) {
            throw new Exception("Invalid dex number!");
        }
        if (!NATURE_MAP.containsKey(nature)) {
            throw new Exception("Invalid nature!");
        }
        if (moveList.length > 4) {
            throw new Exception("Too many moves!");
        }
        if (type.length > 2 || type.length < 1) {
            throw new Exception("Invalid type combination!");
        }

        // initializing the instance constants
        this.pokeName = pokeName;
        this.dexNumber = dexNumber;
        this.nature = nature;
        this.type = type;

        // intializing name and level
        name = pokeName;
        level = 1;

        // intiaizlize EV vars
        hpEV = 0;
        atkEV = 0;
        defEV = 0;
        spAtkEV = 0;
        spDefEV = 0;
        speedEV = 0;
        currentEVTotal = hpEV + atkEV + defEV + spAtkEV + spDefEV + speedEV;

        // initialize IV vars
        Random randomNum = new Random();
        hpIV = randomNum.nextInt(MAXIMUM_SINGLE_IV);
        atkIV = randomNum.nextInt(MAXIMUM_SINGLE_IV);
        defIV = randomNum.nextInt(MAXIMUM_SINGLE_IV);
        spAtkIV = randomNum.nextInt(MAXIMUM_SINGLE_IV);
        spDefIV = randomNum.nextInt(MAXIMUM_SINGLE_IV);
        speedIV = randomNum.nextInt(MAXIMUM_SINGLE_IV);

        // intializing base stats constants
        this.baseHp = baseHp;
        this.baseAtk = baseAtk;
        this.baseDef = baseDef;
        this.baseSpAtk = baseSpAtk;
        this.baseSpDef = baseSpDef;
        this.baseSpeed = baseSpeed;

        // initializing running stats
        maxHp = Math.min((int) (Math.floor(0.01*(2*baseHp + hpIV + Math.floor(0.25*hpEV))*level) + level + 10), MAX_HP);
        currHp = Math.min(maxHp, MAX_HP);
        atk = Math.min((int) ((Math.floor(0.01*(2*baseAtk + atkIV + Math.floor(0.25*atkEV))*level) + 5)*NATURE_MAP.get(nature)[1]), MAX_STAT);
        def = Math.min((int) ((Math.floor(0.01*(2*baseDef + defIV + Math.floor(0.25*defEV))*level) + 5)*NATURE_MAP.get(nature)[2]), MAX_STAT);
        spAtk = Math.min((int) ((Math.floor(0.01*(2*baseSpAtk + spAtkIV + Math.floor(0.25*spAtkEV))*level) + 5)*NATURE_MAP.get(nature)[3]), MAX_STAT);
        spDef = Math.min((int) ((Math.floor(0.01*(2*baseSpDef + spDefIV + Math.floor(0.25*spDefEV))*level) + 5)*NATURE_MAP.get(nature)[4]), MAX_STAT);
        speed = Math.min((int) ((Math.floor(0.01*(2*baseSpeed + speedIV + Math.floor(0.25*speedEV))*level) + 5)*NATURE_MAP.get(nature)[5]), MAX_STAT);
        acc = 1.00;
        evasion = 0;

        // initialize movelist
        this.moveList = new PokemonMoveList<PokeMove>(moveList);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // GETTERS
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    // non stat getters
    public String getPokeName() {
        return this.pokeName;
    }

    public String getName() {
        return this.name;
    }

    public int getLevel() {
        return this.level;
    }

    public int getDexNumber() {
        return this.dexNumber;
    }

    public ALL_NATURES getNature() {
        return this.nature;
    }

    public PokeType.ALL_TYPES[] getType() {
        return this.type;
    }

    // IV getters
    public int getHpIV() {
        return this.hpIV;
    }

    public int getAtkIV() {
        return this.atkIV;
    }

    public int getDefIV() {
        return this.defIV;
    }

    public int getSpAtkIV() {
        return this.spAtkIV;
    }

    public int getSpDefIV() {
        return this.spDefIV;
    }

    public int getSpeedIV() {
        return this.speedIV;
    }

    public int[] getAllIVs() {
        int[] allIVs = {getHpIV(), getAtkIV(), getDefIV(), getSpAtkIV(), getSpDefIV(), getSpeedIV()};
        return allIVs;
    }

    // EV getters
    public int getHpEV() {
        return this.hpEV;
    }

    public int getAtkEV() {
        return this.atkEV;
    }

    public int getDefEV() {
        return this.defEV;
    }

    public int getSpAtkEV() {
        return this.spAtkEV;
    }

    public int getSpDefEV() {
        return this.spDefEV;
    }

    public int getSpeedEV() {
        return this.speedEV;
    }
    
    public int getCurrentEVTotal() {
        return this.currentEVTotal;
    }

    public int[] getAllEVs() {
        int[] allEVs = {getHpEV(), getAtkEV(), getDefEV(), getSpAtkEV(), getSpDefEV(), getSpeedEV()};
        return allEVs; 
    }

    // base stat getters
    public int getBaseHp() {
        return this.baseHp;
    }

    public int getBaseAtk() {
        return this.baseAtk;
    }

    public int getBaseDef() {
        return this.baseDef;
    }

    public int getBaseSpAtk() {
        return this.baseSpAtk;
    }

    public int getBaseSpDef() {
        return this.baseSpDef;
    }

    public int getBaseSpeed() {
        return this.baseSpeed;
    }

    // actual stat getters
    public int getMaxHp() {
        return this.maxHp;
    }

    public int getCurrHp() {
        return this.currHp;
    }

    public int getAtk() {
        return this.atk;
    }

    public int getDef() {
        return this.def;
    }

    public int getSpAtk() {
        return this.spAtk;
    }

    public int getSpDef() {
        return this.spDef;
    }

    public int getSpeed() {
        return this.speed;
    }

    public double getAcc() {
        return this.acc;
    }

    public double getEvasion() {
        return this.evasion;
    }

    // move list getter
    public List<PokeMove> getMoveList() {
        return this.moveList;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // SETTERS
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    // non stat setters
    public void setName(String name) {
        if (name.length() <= 24) {
            this.name = name;
        }
    }

    public void setLevel(int level) {
        if (level <= MAX_LEVEL && level >= 1) {
            this.level = level;
        }
    }
    
    // EV setters
    public void setHpEV(int hpEV) {
        if (hpEV <= MAXIMUM_SINGLE_EV && ((currentEVTotal + hpEV) <= MAXIMUM_TOTAL_EVS)) {
            this.hpEV = hpEV;;
        }
    }

    public void setAtkEV(int atkEV) {
        if (atkEV <= MAXIMUM_SINGLE_EV && ((currentEVTotal + atkEV) <= MAXIMUM_TOTAL_EVS)) {
         this.atkEV = atkEV;
        }
    }

    public void setDefEV(int defEV) {
        if (defEV <= MAXIMUM_SINGLE_EV && ((currentEVTotal + defEV) <= MAXIMUM_TOTAL_EVS)) {
            this.defEV = defEV;
        }
    }

    public void setSpAtkEV(int spAtkEV) {
        if (spAtkEV <= MAXIMUM_SINGLE_EV && ((currentEVTotal +spAtkEV) <= MAXIMUM_TOTAL_EVS)) {
            this.spAtkEV = spAtkEV;
        }
    }

    public void setSpDefEV(int spDefEV) {
        if (spDefEV <= MAXIMUM_SINGLE_EV && ((currentEVTotal + spDefEV) <= MAXIMUM_TOTAL_EVS)) {
            this.spDefEV = spDefEV;
        }
    }

    public void setSpeedEV(int speedEV) {
        if (speedEV <= MAXIMUM_SINGLE_EV && ((currentEVTotal + speedEV) <= MAXIMUM_TOTAL_EVS)) {
            this.speedEV = speedEV;
        }
    }

    // stat setters for accuracy and evasion

    public void setAcc(double acc) {
        if (acc >= 0 && acc <= MAX_PERCENT) {
            this.acc = acc;
        }
    }

    public void setEvasion(double evasion) {
        if (evasion >= 0 && evasion <= MAX_PERCENT) {
            this.evasion = evasion;
        }
    }

    // move list setter
    public void setMoveList(PokeMove[] moveList) {
        this.moveList = new PokemonMoveList<PokeMove>(moveList);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // MOVE ADDERS
    ////////////////////////////////////////////////////////////////////////////////////////////////////
}
