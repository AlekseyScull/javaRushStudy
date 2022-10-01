package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        hen.getCountOfEggsPerMonth();
    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = null;
            //напишите тут ваш код
            switch (country) {
                case Country.UKRAINE:
                    hen = new UkrainianHen();
                    break;
                case Country.RUSSIA:
                    hen = new RussianHen();
                    break;
                case Country.MOLDOVA:
                    hen = new MoldovanHen();
                    break;
                case Country.BELARUS:
                    hen = new BelarusianHen();
                    break;
            }
            return hen;
        }
    }

    static abstract class Hen {
        abstract int getCountOfEggsPerMonth();

        String getDescription() {
            return "Я - курица.";
        }
    }
}

class RussianHen extends Solution.Hen {

    @Override
    int getCountOfEggsPerMonth() {
        return 10;
    }

    @Override
    String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}

class UkrainianHen extends Solution.Hen {

    @Override
    int getCountOfEggsPerMonth() {
        return 11;
    }

    @Override
    String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }

}

class MoldovanHen extends Solution.Hen {

    @Override
    int getCountOfEggsPerMonth() {
        return 9;
    }

    @Override
    String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }

}

class BelarusianHen extends Solution.Hen {

    @Override
    int getCountOfEggsPerMonth() {
        return 8;
    }

    @Override
    String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }

}


