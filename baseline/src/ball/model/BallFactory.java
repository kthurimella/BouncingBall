package ball.model;

import ball.Ball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BallFactory {

    public static Ball[] all() {
        return new Ball[]{
                bouncingBall(75, 50, BouncingBehavior.DOWN),
                elasticBall(250, 100, Ball.DEFAULT_RADIUS, Ball.SHRINK),
                bouncingElasticBall(400, 100, 10, BouncingBehavior.DOWN, Ball.SHRINK)
        };
    }

    public static Ball bouncingBall(int centerX, int centerY, int direction) {
        List<BallBehavior> behaviors = new ArrayList<BallBehavior>();
        behaviors.add(new BouncingBehavior());
        return new BallImpl(centerX, centerY, Ball.DEFAULT_RADIUS, direction, 0, behaviors);
    }

    public static Ball elasticBall(int centerX, int centerY, int radius, int elasticity) {
        List<BallBehavior> behaviors = new ArrayList<BallBehavior>();
        behaviors.add(new ElasticBehavior());
        return new BallImpl(centerX, centerY, radius, Ball.DEFAULT_DIRECTION, elasticity, behaviors);
    }

    public static Ball bouncingElasticBall(int centerX, int centerY, int radius, int direction, int elasticity) {
        return new BallImpl(centerX, centerY, radius, direction, elasticity, Arrays.asList(new BouncingBehavior(), new ElasticBehavior()));
    }
}
