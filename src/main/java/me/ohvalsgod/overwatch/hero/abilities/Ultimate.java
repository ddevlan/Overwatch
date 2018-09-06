package me.ohvalsgod.overwatch.hero.abilities;

public interface Ultimate extends Ability {

    /**
     * @return the ultimate ability's cost
     */
    int getCost();

    /**
     * @return the ultimate's current points
     */
    int getCurrentPoints();

    /**
     * @param i the amount of points that should be added
     */
    void addPoints(int i);

    /**
     * @param i the amount of points that should be set
     */
    void setCurrentPoints(int i);

}
