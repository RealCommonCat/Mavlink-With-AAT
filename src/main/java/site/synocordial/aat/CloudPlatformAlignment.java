package site.synocordial.aat;

import java.lang.Math;

public class CloudPlatformAlignment {

    // 将角度从度转换为弧度  
    private static double degreesToRadians(double degrees) {
        return degrees * Math.PI / 180.0;
    }

    // 将弧度从弧度转换为度  
    private static double radiansToDegrees(double radians) {
        return radians * 180.0 / Math.PI;
    }
    // 计算绕x轴旋转的旋转矩阵
    private static double[][] rotationMatrixX(double angle) {
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        return new double[][]{
                {1, 0, 0},
                {0, cos, -sin},
                {0, sin, cos}
        };
    }

    // 计算绕y轴旋转的旋转矩阵
    private static double[][] rotationMatrixY(double angle) {
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        return new double[][]{
                {cos, 0, sin},
                {0, 1, 0},
                {-sin, 0, cos}
        };
    }

    // 计算绕z轴旋转的旋转矩阵
    private static double[][] rotationMatrixZ(double angle) {
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        return new double[][]{
                {cos, -sin, 0},
                {sin, cos, 0},
                {0, 0, 1}
        };
    }

    // 矩阵乘法
    private static double[][] multiplyMatrices(double[][] a, double[][] b) {
        int rowsA = a.length;
        int colsA = a[0].length;
        int colsB = b[0].length;
        double[][] result = new double[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    // 应用旋转矩阵到点
    private static double[] applyRotation(double[][] rotationMatrix, double[] point) {
        double[] result = new double[3];
        for (int i = 0; i < 3; i++) {
            result[i] = rotationMatrix[i][0] * point[0] + rotationMatrix[i][1] * point[1] + rotationMatrix[i][2] * point[2];
        }
        return result;
    }
    public static final double EARTH_RADIUS = 6378137.0;
    public static double[] calculateAzimuthAltitude(double currentLat, double currentLon, double currentAlt,
                                                    double goalLat, double goalLon, double goalAlt,double roll,double pitch,double yaw) {
        double result[] = new double[2];
        double goalX = (EARTH_RADIUS + goalAlt) * Math.cos(degreesToRadians(goalLat)) * Math.cos(degreesToRadians(goalLon));
        double goalY = (EARTH_RADIUS + goalAlt) * Math.cos(degreesToRadians(goalLat)) * Math.sin(degreesToRadians(goalLon));
        double goalZ = (EARTH_RADIUS + goalAlt) * Math.sin(degreesToRadians(goalLat));
        // 计算旋转矩阵
        double[][] rx = rotationMatrixX(roll);
        double[][] ry = rotationMatrixY(pitch);
        double[][] rz = rotationMatrixZ(yaw);

        // 组合旋转矩阵
        double[][] rotationMatrix = multiplyMatrices(rz, multiplyMatrices(ry, rx));

        // 应用旋转矩阵到点
        double[] point = {goalX, goalY, goalZ};
        double[] transformedPoint = applyRotation(rotationMatrix, point);

        // 计算方位角和高度角
        double dx = transformedPoint[0];
        double dy = transformedPoint[1];
        double dz = transformedPoint[2];
        result[0] = Math.atan2(dy, dx);
        result[1] = Math.atan2(dz, Math.sqrt(dx * dx + dy * dy));
        return result;
    }
}