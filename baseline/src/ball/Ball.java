package ball;

import java.awt.*;

// DO NOT CHANGE
public interface Ball {
    int DEFAULT_RADIUS = 50;
    int DEFAULT_DIRECTION = 0;
    int SHRINK = -1;
    int GROW = 1;

    int radius();
    Point center();
    void update();
}
