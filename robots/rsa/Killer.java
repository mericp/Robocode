package rsa;

import robocode.HitByBulletEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

/**
 * Created by Meri on 08/06/2016
 */
public class Killer extends Robot{
    public Killer() {
    }

    public void run() {
        while(true) {
            this.seek();
        }
    }

    private void seek() {
        this.turnGunRight(60.0D);
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        this.turnRight(e.getBearing());
        this.ahead(100.0D);
        this.fireIfInRange(e.getDistance());
    }

    private void fireIfInRange(double distance) {
        if(distance < 100.0D) {
            this.fire(3.0D);
        } else {
            this.fire(1.0D);
        }

    }

    public void onHitByBullet(HitByBulletEvent e) {
        this.back(10.0D);
    }

    public void onHitWall(HitWallEvent e) {
        this.back(20.0D);
    }
}
