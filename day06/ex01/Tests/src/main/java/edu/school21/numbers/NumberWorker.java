package edu.school21.numbers;

public class NumberWorker {

    public boolean isPrime(int number) {
        if (number < 2) {
            throw new IllegalNumberException("Exception: number less than two");
        }
        else {
            int iterator;
            for (iterator = 2; iterator * iterator <= number; iterator++) {
                if (number % iterator == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public int digitsSum(int number) {
        int size = String.valueOf(number).length();
        int res = 0;

        for (; size != 0; size--) {
            res += number % 10;
            number /= 10;
        }
        return res;
    }

    class IllegalNumberException extends RuntimeException {
        public IllegalNumberException(String s) {
            super(s);
        }
    }
}


