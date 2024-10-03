package Q3;

import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        var thirdMax = findThirdMax(new int[]{7, 20, 18, 4, 20, 19, 20, 3});
        for (int i = 0; i < thirdMax.length; i++) {
            System.out.println(thirdMax[i]);
        }
    }

    public static int[] findThirdMax(int[] a) {
        var startTime = System.nanoTime();

        var treeMap = new TreeMap<Integer, Integer>();

        for (int i = 0; i < a.length; i++)
        {
            treeMap.put(a[i], treeMap.getOrDefault(a[i], 0) + 1);
        }

        var keys = treeMap.keySet().toArray();
        var countNum = 0;
        var array = new int[3];

        for(int i = keys.length - 1; i >= 0; i--)
        {
            var count = treeMap.get(keys[i]);

            if (countNum==3)
            {
                break;
            }

            if (count == 1)
            {
                array[countNum++] = (int)keys[i];
            }
            else
            {
                for (int j = 0; j < count; j++)
                {
                    if (countNum==3)
                    {
                        break;
                    }

                    array[countNum++] = (int)keys[i];
                }
            }
        }

        var endTime = System.nanoTime();

        var empericalTime = endTime - startTime;
        System.out.println("Emperical Time in nano seconds: " + empericalTime);

        return array;
    }
}
