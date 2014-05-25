package ball.model;


import ball.ui.BallWorld;

public class BouncingBehavior implements BallBehavior {

    public static final int SPEED = 12;

    static final int DOWN = 1;
    static final int UP = -1;

    @Override
    public void update(BallImpl ball) {
        ball.direction = switchDirectionsIfNecessary(ball);
        ball.y = move(ball);
    }

    private int switchDirectionsIfNecessary(BallImpl ball) {
        if (movingTooHigh(ball) || movingTooLow(ball)) {
            return switchDirection(ball);
        }

        return ball.direction;
    }

    private boolean movingTooLow(BallImpl ball) {
        return ball.y + ball.radius >= BallWorld.BOX_HEIGHT && movingDown(ball);
    }

    private boolean movingTooHigh(BallImpl ball) {
        return ball.y - ball.radius <= 0 && movingUp(ball);
    }

    private int switchDirection(BallImpl ball) {
        return movingDown(ball) ? UP : DOWN;
    }

    private int move(BallImpl ball) {
        return ball.y + (SPEED * ball.direction);
    }

    private boolean movingDown(BallImpl ball) {
        return ball.direction == DOWN;
    }

    private boolean movingUp(BallImpl ball) {
        return ball.direction == UP;
    }
}
