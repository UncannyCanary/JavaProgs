package JavaProgs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class findPowerfulIntegers {
    public static void main(String[] args) {
        System.out.println(powerfulIntegers(60,56,175617));
    }
    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> result  = new HashSet<>();
        if (bound == 0 || bound == 1) {
            return new ArrayList<>(result);
        }
        int maxSecondPower = (y != 1) ? Math.round((int)(Math.log(bound - 1)/ Math.log(y))) : 1;
        int maxfirstPower = (x != 1) ? Math.round((int)(Math.log(bound - 1)/ Math.log(x))) : 1;
        for (int i = 0; i <= maxfirstPower; i++) {
            for (int j = 0; j <= maxSecondPower; j++) {
                int num = (int)Math.pow(x, i) + (int)Math.pow(y, j);
                if (num <= bound)
                    result.add(num);
            }
        }
        return new ArrayList<>(result);
    }
}