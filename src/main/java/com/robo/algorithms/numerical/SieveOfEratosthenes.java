package com.robo.algorithms.numerical;

import java.util.List;
import java.util.ArrayList;

public class SieveOfEratosthenes {
    private void checkArguments(Long from, Long to) {
        if(from < 0 || to < 0) {
            throw new IllegalArgumentException(
                "from or to cannot be a negative number"
            );
        }

        if(to < from) {
            throw new IllegalArgumentException(
                "from cannot be larger than to"
            );
        }
    }
    public List<Integer> getPrimes(long from, long to) {
        checkArguments(from, to);
        boolean[] isComposite = new boolean[(int)to + 1]; 
        for(long i = 2; i <= to; i++) {
            if(!isComposite[(int)i]) {
                for(long j = i * i; j <= to; j += i) {
                    isComposite[(int)j] = true;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for(long i = from; i <= to; i++) {
            if(!isComposite[(int)i] && i > 1) {
                primes.add((int)i);
            }
        }
        
        return primes;
    }
}