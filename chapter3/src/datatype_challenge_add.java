public class datatype_challenge_add {

    public static void main(String[] args) {
        byte One_tenth_MaxByteValue = (Byte.MAX_VALUE / 10);
        short One_tenth_MaxShortValue = (Short.MAX_VALUE / 10);
        int One_tenth_MaxIntValue = (Integer.MAX_VALUE / 10);
        long SumValue = 50000 + 10L * (One_tenth_MaxByteValue + One_tenth_MaxIntValue + One_tenth_MaxShortValue);
        System.out.println("One_tenth_MaxByteValue:" + One_tenth_MaxByteValue);
        System.out.println("One_tenth_MaxShortValue:" + One_tenth_MaxShortValue);
        System.out.println("One_tenth_MaxIntValue:" + One_tenth_MaxIntValue);
        System.out.println("SumValue:" + SumValue);
    }

}
