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
        var startTime = System.currentTimeMillis();
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

            if (checkArraySize(countNum))
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
                    if (checkArraySize(countNum))
                    {
                        break;
                    }

                    array[countNum++] = (int)keys[i];
                }
            }
        }

        var endTime = System.currentTimeMillis();

        var empericalTime = endTime - startTime;
        System.out.println("Emperical Time in miliseconds: " + empericalTime);

        return array;
    }

    public static boolean checkArraySize(int count)
    {
        return count == 3;
    }
}
