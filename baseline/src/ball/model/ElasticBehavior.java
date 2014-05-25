package ball.model;

import ball.Ball;

public class ElasticBehavior implements BallBehavior {


    public static final int SPEED = 2;

    static final int GROW = 1;
    static final int SHRINK = -1;


    @Override
    public void update(BallImpl ball) {
        ball.elasticity = switchElasticityIfNecessary(ball);
        ball.radius = next(ball);
    }


    private int switchElasticityIfNecessary(BallImpl ball) {
        if (growingTooBig(ball) || shrinkingTooSmall(ball)) {
            return switchElasticity(ball);
        }

        return ball.elasticity;
    }

    private boolean shrinkingTooSmall(BallImpl ball) {
        return ball.radius <= 0 && shrinking(ball);
    }

    private boolean growingTooBig(BallImpl ball) {
        return ball.radius >= Ball.DEFAULT_RADIUS && growing(ball);
    }

    private int switchElasticity(BallImpl ball) {
        return growing(ball) ? SHRINK : GROW;
    }

    private int next(BallImpl ball) {
        return ball.radius + (SPEED * ball.elasticity);
    }

    private boolean shrinking(BallImpl ball) {
        return ball.elasticity == SHRINK;
    }

    private boolean growing(BallImpl ball) {
        return ball.elasticity == GROW;
    }
}
