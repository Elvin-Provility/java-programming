package letcode;

public class TradeSum {
    public static void main(String[] args) {
        int shareValue[] = {5, 4, 2, 3, 1};
        int start = 1;
        int lowestValue = findTheLowestShare(shareValue, start);
        System.out.println(lowestValue);

    }

    private static int findTheLowestShare(int[] shareValue, int count) {
        int min = 0;
        int dublicateShareValue[] = new int[shareValue.length];
        for (int i = 0; i < shareValue.length; i++) {
            dublicateShareValue[i] = shareValue[i];
        }
        while (count > 0) {
            int index = 0;

            for (int i = 0; i < dublicateShareValue.length; i++) {
                if (min > dublicateShareValue[i]) {
                    min = dublicateShareValue[i];
                    index = i;
                }
            }
            if (count > 1) {
                dublicateShareValue[index] = -1;
            }
            count--;
        }
        return min;
    }
}
