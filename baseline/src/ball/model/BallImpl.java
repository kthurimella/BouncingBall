package ball.model;

import ball.Ball;

import java.awt.*;
import java.util.List;


public class BallImpl implements Ball {
    protected int x;
    protected int y;
    protected int radius;
    protected int direction;
    protected int elasticity;
    private List<BallBehavior> behaviors;

    protected BallImpl(int x, int y, int radius, int direction, int elasticity, List<BallBehavior> behaviors) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.direction = direction;
        this.elasticity = elasticity;
        this.behaviors = behaviors;
    }

    // DO NOT CHANGE
    @Override
    public int radius() {
        return radius;
    }

    // DO NOT CHANGE
    @Override
    public Point center() {
        return new Point(x, y);
    }

    public void update() {
        for (BallBehavior behavior : behaviors) {
            behavior.update(this);
        }
    }
}
