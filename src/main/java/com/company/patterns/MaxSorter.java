package com.company.patterns;

import com.company.model.Pupil;
import com.company.model.Pupils;

import java.util.Comparator;

public class MaxSorter  implements  Strategy{
    @Override
    public Pupil[] sort(Pupil[] pupils) {
        return maxSort((a, b) -> a > b ? 1 : a == b ? 0 : -1, pupils);
    }

    private Pupil[] maxSort(Comparator<Double> comparator, Pupil[] pupils) {
        Pupil tmp;
        for (int i = 0; i < pupils.length - 1; i++) {
            for (int j = pupils.length - 2; j >= i; j--) {

                if (comparator.compare(Pupils.getAverage(pupils[j]), Pupils.getAverage(pupils[j + 1])) > 0) {
                    tmp = pupils[j + 1];
                    pupils[j + 1] = pupils[j];
                    pupils[j] = tmp;
                }
            }
        }

        return pupils;
    }




}
