package com.testPackage.java8;

/**
 * @Author handy
 * @Date 2021/7/22 下午2:18
 * @Version 1.0
 * 自定义一个流式操作的方式
 */
public class NutitionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int cabohdate;

    public NutitionFacts(Builde builde) {
        servingSize = builde.servingSize;
        servings = builde.servings;
        calories = builde.calories;
        fat = builde.fat;
        sodium = builde.sodium;
        cabohdate = builde.cabohdate;
    }


    public static class Builde {

        private final int servingSize;
        private final int servings;


        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int cabohdate = 0;

        public Builde(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builde calories(int calories) {
            this.calories = calories;
            return this;

        }

        public Builde cabohdate(int cabohdate) {
            this.cabohdate = cabohdate;
            return this;

        }

        public Builde fat(int fat, int sodium) {
            this.fat = fat;
            this.sodium = sodium;
            return this;
        }

        public NutitionFacts build() {
            return new NutitionFacts(this);
        }
    }

    public static void main(String[] args) {
        // 流式操作
//        JavaPromise aa = new JavaPromise.Builde(1,2).test(1,2);
        NutitionFacts cc = new NutitionFacts.Builde(1, 2).fat(1, 2).build();
    }
}
