package rsa;

import robocode.HitByBulletEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

public class Killer extends Robot
{
    public Killer()
    {
        setAllColors(Properties.COLOR);
    }

    public void run()
    {
        while(true)
        {
            seek();
        }
    }

    private void seek()
    {
        turnGunRight(Properties.SEEK_INTERVAL);
    }

    public void onScannedRobot(ScannedRobotEvent e)
    {
        turnRight(e.getBearing());
        ahead(Properties.AHEAD_INTERVAL_ON_SCAN);
        fireIfInRange(e.getDistance());
    }

    private void fireIfInRange(double distance)
    {
        if(distance < Properties.AHEAD_INTERVAL_ON_SCAN)
        {
            fire(Properties.HEAVY_POWER_ATTACK);
        }
        else
        {
            fire(Properties.REGULAR_POWER_ATTACK);
        }
    }

    public void onHitByBullet(HitByBulletEvent e)
    {
        back(Properties.PUSHBACK);
    }

    public void onHitWall(HitWallEvent e)
    {
        back(Properties.PUSHBACK);
    }
}