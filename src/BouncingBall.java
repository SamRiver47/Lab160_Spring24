public class BouncingBall {
    public static void main(String[] args) {

        StdDraw.setCanvasSize(400,400);
        StdDraw.setXscale(-1.0,1.0);
        StdDraw.setYscale(-1.0,1.0);

        StdDraw.enableDoubleBuffering();

        int pauseDuration = 15;
        double position_x = 0.480 , position_y= 0.860;
        double velocity_x = 0.015, velocity_y= 0.017;
        double radius= 0.05;

        while(true){
            if (Math.abs(position_x + velocity_x)>1.0-radius){
                velocity_x = -velocity_x;
            }
            if (Math.abs(position_y+velocity_y)>1.0-radius){
                velocity_y = -velocity_y;
            }
            position_x = position_x + velocity_x;
            position_y = position_y + velocity_y;
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledCircle(position_x, position_y, radius);
            StdDraw.show();
            StdDraw.pause(pauseDuration);
        }
    }
}
