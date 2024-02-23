import java.awt.*;
import java.util.Random;

public class BouncingBalls {
    public static void main(String[] args) {

        StdDraw.setCanvasSize(400,400);
        StdDraw.setXscale(-1.0,1.0);
        StdDraw.setYscale(-1.0,1.0);
        StdDraw.enableDoubleBuffering();
        int numBalls = 19;
        Random randNumber = new Random();
        int pauseDuration = 15;


        double[] positions_x = new double[numBalls];
        double[] positions_y = new double[numBalls];
        double[] velocities_x = new double[numBalls];
        double[] velocities_y = new double[numBalls];
        double[] radii = new double[numBalls];
        Color[] color = new Color[numBalls];


        for (int i=0; i<numBalls; i++){
            radii[i] = randNumber.nextDouble() * 0.05 + 0.05;;
            positions_x[i] = randNumber.nextDouble() * (1.0 - radii[i] * 2) + radii[i];
            positions_y[i] = randNumber.nextDouble() * (1.0 - radii[i] * 2) + radii[i];
            velocities_x[i] = randNumber.nextDouble() * 0.05 - 0.025;
            velocities_y[i] = randNumber.nextDouble() * 0.05 - 0.025;
            color[i] = new Color(randNumber.nextInt(256), randNumber.nextInt(256), randNumber.nextInt(256));
        }

        while (true){

            StdDraw.clear();
            for (int i=0; i<numBalls; i++){
                if(Math.abs(positions_x[i] + velocities_x[i]) > (1.0-radii[i]) ){
                    velocities_x[i] = -velocities_x[i];
                }
                if (Math.abs(positions_y[i] + velocities_y[i]) > (1.0-radii[i])){
                    velocities_y[i] = -velocities_y[i];
                }

                positions_x[i] = positions_x[i] + velocities_x[i];
                positions_y[i] = positions_y[i] + velocities_y[i];

                StdDraw.setPenColor(color[i]);
                StdDraw.filledCircle(positions_x[i], positions_y[i], radii[i]);

            }

            StdDraw.show();
            StdDraw.pause(pauseDuration);

        }

    }
}
