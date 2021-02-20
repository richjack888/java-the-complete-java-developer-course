import java.util.ArrayList;

class IntClass {
    private int myValue;

    public IntClass(int myValue) {
        this.myValue = myValue;
    }

    public int getMyValue() {
        return myValue;
    }

    public void setMyValue(int myValue) {
        this.myValue = myValue;
    }
}

public class AutoboxingAndUnboxing {
    public static void main(String[] args) {
        String[] strArr = new String[10];
        int[] intArray = new int[10];

        ArrayList<String> strArrayList = new ArrayList();
        strArrayList.add("Something");

        ArrayList<IntClass> intArrayList = new ArrayList();
        intArrayList.add(new IntClass(56));

        Integer intValue0 = new Integer(55);
        Integer intValue1 = 55;
        int intValue2 = 55;
        int intValue3 = intValue1.intValue();

        Integer intValue = new Integer(54);
        Double doubleValue1 = 12.12;
        Double doubleValue = new Double(12.12);

        ArrayList<Integer> intArrayLists = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            intArrayLists.add(Integer.valueOf(i));
        }

        for (int i = 0; i < 10; i++) {
//            System.out.println(i + " --> " + intArrayLists.get(i).intValue());
        }

        ArrayList<Double> myDoubleValues = new ArrayList<Double>();

        for (double dbl = 0.0; dbl <= 5.0; dbl += 0.5) {
            myDoubleValues.add(dbl);
        }

        for (int i = 0; i < myDoubleValues.size(); i++) {
            double value = myDoubleValues.get(i).doubleValue();
            System.out.println(i + " --> " + value);
        }
    }
}

