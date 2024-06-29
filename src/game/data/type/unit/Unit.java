package game.data.type.unit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import game.data.type.Copy;
import game.data.type.attr.Area;
import game.data.type.attr.Body;
import game.data.type.attr.Status;

public abstract class Unit implements Copy, Comparable<Unit>, Serializable {
    private static final long serialVersionUID = -168174367930446886L;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    protected boolean frozen;
    protected Body mainBody;
    protected Status hp;
    protected Status speed;
    protected int camp;
    protected boolean shouldDeleted;
    protected ArrayList<Unit> unitGenerated;

    public Unit() {
        super();
        this.frozen = false;
        this.mainBody = new Body();
        this.hp = new Status(1.0, 1.0, 0);
        this.speed = new Status(1.0, 1.0, 0);
        this.camp = 0;
        this.shouldDeleted = false;
        this.unitGenerated = new ArrayList<Unit>();
    }
    public Unit(boolean frozen, Body mainBody, Status hp, Status speed, int camp, ArrayList<Unit> unitGenerated) {
        super();
        this.frozen = frozen;
        this.mainBody = (Body)mainBody.getCopy();
        this.hp = (Status)hp.getCopy();
        this.speed = (Status)speed.getCopy();
        this.camp = camp;
        this.shouldDeleted = false;
        this.unitGenerated = unitGenerated;
        this.shouldDeleted = false;
    }

    public boolean isPlayer() {
        return false;
    }

    public boolean isFrozen() {
        return frozen;
    }
    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }
    public Body getMainBody() {
        return mainBody;
    }
    public void setMainBody(Body mainBody) {
        this.mainBody.setLocation(mainBody.getLocation());
        this.mainBody.setAngle(mainBody.getAngle());
        this.mainBody.setRadius(mainBody.getRadius());
        this.mainBody.setDepth(mainBody.getDepth());
    }
    public Status gethp() {
        return hp;
    }
    public void sethp(Status hp) {
        this.hp.setCurrent(hp.getCurrent());
        this.hp.setUpperbound(hp.getUpperbound());
        this.hp.setRecover(hp.getRecover());
    }
    public Status getSpeed() {
        return speed;
    }
    public void setSpeed(Status speed) {
        this.speed.setCurrent(speed.getCurrent());
        this.speed.setUpperbound(speed.getUpperbound());
        this.speed.setRecover(speed.getRecover());
    }
    public int getCamp() {
        return camp;
    }
    public void setCamp(int camp) {
        this.camp = camp;
    }
    public ArrayList<Unit> getUnitGenerated() {
        @SuppressWarnings("unchecked")
        ArrayList<Unit> ret = (ArrayList<Unit>)this.unitGenerated.clone();
        unitGenerated.clear();
        return ret;
    }
    public void setUnitGenerated(ArrayList<Unit> unitGenerated) {
        this.unitGenerated.clear();
        for(Unit it: unitGenerated) {
            this.unitGenerated.add(it);
        }
    }

    // Deteksi Tabrakan
    public abstract void initCollitionStatus();
    public abstract boolean canDetectCollision();
    public abstract void adjustSelf(Unit unit, HashMap<String, Unit> unitMap);
    public abstract boolean collisionDetected(Unit unit);
    public abstract void collisionHappened(Unit unit);
    public abstract boolean isTarget();
    public abstract boolean isBullet();

    public abstract void autoMove(double timePassed, Area border);
    public abstract void autoAct(double timePassed, boolean[] keyMap, HashMap<String, Unit> unitMap);

    // Status User
    public abstract void getDamage(double damage);
    public abstract void applyDamage();
    public abstract void checkSelf();
    public boolean shouldBeDeleted() {
        return this.shouldDeleted;
    }
    public void setDelete(boolean delete) {
        this.shouldDeleted = delete;
    }

    public abstract boolean canDisplay();
    public abstract String getDisplayName();
    public abstract double getDisplayPosX();
    public abstract double getDisplayPosY();
    public abstract int getDepth();

    @Override
    public abstract Object getCopy();

    @Override
    public int compareTo(Unit unit) {
        return this.mainBody.compareTo(unit.mainBody);
    }
}