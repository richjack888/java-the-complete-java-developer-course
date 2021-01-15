public class challenge_Paint_Job {

    public static void main(String[] args) {

        System.out.println(getBucketCount(-3.4, 2.1, 1.5, 2));
        System.out.println(getBucketCount(3.4, 2.1, 1.5, 2));
        System.out.println(getBucketCount(2.75, 3.25, 2.5, 1));

//        System.out.println(getBucketCount(-3.4, 2.1, 1.5));
//        System.out.println(getBucketCount(3.4, 2.1, 1.5));
//        System.out.println(getBucketCount(7.25, 4.3, 2.35));

//        System.out.println(getBucketCount(3.4, 1.5));
//        System.out.println(getBucketCount(6.26, 2.2));
//        System.out.println(getBucketCount(3.26, 0.75));
//        System.out.println(getBucketCount(2.25, 0.0));

    }

    public static int getBucketCount(double width, double height, double areaPerBuckets, int extraBuckets) {
        if ((width > 0) && (height > 0) && (areaPerBuckets > 0) && (extraBuckets >= 0)) {

            double num = getBucketCount(width, height, areaPerBuckets);
            return (int) (Math.ceil(num) - extraBuckets);

        }


        return -1;

    }

    public static int getBucketCount(double width, double height, double areaPerBuckets) {
        if ((width > 0) && (height > 0) && (areaPerBuckets > 0)) {
            double num = (width * height / areaPerBuckets);
            return (int) Math.ceil(num);
        }

        return -1;

    }

    public static int getBucketCount(double areaPerBuckets, double extraBuckets) {
        if ((areaPerBuckets > 0) && (extraBuckets > 0)) {

            double num = areaPerBuckets / extraBuckets;
            return (int) Math.ceil(num);

        }
        return -1;
    }
}
