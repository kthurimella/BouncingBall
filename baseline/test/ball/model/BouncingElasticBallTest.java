package ball.model;

import ball.Ball;
import org.junit.Test;

import static ball.BallTestHarness.*;

public class BouncingElasticBallTest {

    @Test
    public void shouldGoDown() throws Exception {
        Ball bouncingBall = BallFactory.bouncingElasticBall(0, 100, 20, BouncingBehavior.DOWN, Ball.SHRINK);

        bouncingBall.update();

        assertCenterYCoordinateIs(oneStepDownFrom(100), bouncingBall);
    }

    @Test
    public void shouldIncreaseInSize() {
        Ball elasticBall = BallFactory.bouncingElasticBall(250, 100, 20, Ball.DEFAULT_DIRECTION, Ball.GROW);

        elasticBall.update();

        assertRadiusIs(oneStepOutwardsFrom(20), elasticBall);
    }

}