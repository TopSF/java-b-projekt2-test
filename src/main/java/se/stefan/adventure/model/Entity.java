package se.stefan.adventure.model;

public abstract class Entity {

    private String role;
    private int health;
    private int damage;

    public Entity(String role, int health, int damage) {
        this.role = role;
        this.health = health;
        this.damage = damage;
    }

    public String getRole() {
        return role;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }


    public void setDamage(int damage) {
        this.damage = damage;
    }

    //Denna metod minskar Entity health attribut
    public void takeHit(int damage) {
        this.health -= damage;
    }

    //Denna metod attackerar en Entity
    public void punch(Entity target) {
        target.takeHit(this.damage);
    }

    //Kollar om Entitys health är över 0
    public boolean isConscious() {

        if (this.health > 0) {
            return true;
        } else {
            return false;
        }
    }


    private void executeAttack(Entity attacker, Entity defender) {
        System.out.println(attacker.getRole() + " attackerar " + defender.getRole());
        attacker.punch(defender);
        if (defender.isConscious()) {
            System.out.println(defender.getRole() + " är fortfarande medvetande " +
                    "och slår tillbaka");
            defender.punch(attacker);
        } else {
            System.out.println(defender.getRole() + " är medvetslös");
        }
    }

    public void fightOneRound(Entity attacker, Entity defender) {

        executeAttack(attacker, defender);

        if (defender.isConscious()) {
            executeAttack(attacker, defender);
        }
    }


}
