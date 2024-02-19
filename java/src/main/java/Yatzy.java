import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Yatzy {

    public static int chance(int... dice) {
        return Arrays.stream(dice).sum();

    }

    public static int yatzy(int... dice) {
        return Arrays.stream(dice)
            .boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .containsValue(5L) ? 50 : 0;
}

public static int ones(int... dice) {
    return (int) Arrays.stream(dice).filter(d -> d == 1).count();

}

    public static int twos(int... dice) {
        return Arrays.stream(dice)
            .filter(d -> d == 2)
            .sum();
    }

public static int threes(int ... dice) {
    return Arrays.stream(dice)
        .filter(d -> d == 3)
        .sum();
}

    protected int[] dice;
    public Yatzy(int d1, int d2, int d3, int d4, int _5)
    {
        dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = _5;
    }

public int fours() {
    return Arrays.stream(dice)
        .filter(d -> d == 4)
        .map(d -> 4)
        .sum();
}

public int fives() {
    return Arrays.stream(dice)
        .filter(d -> d == 5)
        .map(d -> 5)
        .sum();
}

public int sixes() {
    return Arrays.stream(dice)
        .filter(d -> d == 6)
        .map(d -> 6)
        .sum();
}

public static int score_pair(int ... dice) {
        int[] counts = new int[6];
        for (int die : dice) {
            counts[die - 1]++;
        }
        for (int i = counts.length - 1; i >= 0; i--) {
            if (counts[i] >= 2) {
                return (i + 1) * 2;
            }
        }
        return 0;

}

public static int two_pair(int ...dice) {
        int[] counts = new int[6];
        for (int die : dice) {
            counts[die - 1]++;
        }
        int pairsFound = 0;
        int score = 0;
        for (int i = counts.length - 1; i >= 0; i--) {
            if (counts[i] >= 2) {
                pairsFound++;
                score += (i + 1) << 1;
                if (pairsFound == 2) {
                    return score;
                }
            }
        }
        return 0;
}

public static int four_of_a_kind(int ...dice) {
        int[] tallies = new int[6];
        for (int die : dice) {
            tallies[die - 1]++;
        }
        for (int i = 0; i < tallies.length; i++) {
            if (tallies[i] >= 4) {
                return (i + 1) * 4;
            }
        }
        return 0;

}

public static int three_of_a_kind(int ... dice) {

    int[] tallies = new int[6];
    for (int die : dice) {
        tallies[die - 1]++;
    }
    for (int i = 0; i < tallies.length; i++) {
        if (tallies[i] >= 3) {
            return (i + 1) * 3;
        }
    }
    return 0;
}

public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {

    Set<Integer> dice = new HashSet<>(Arrays.asList(d1, d2, d3, d4, d5));
    boolean isSmallStraight =
        dice.containsAll(Arrays.asList(1, 2, 3, 4)) ||
            dice.containsAll(Arrays.asList(2, 3, 4, 5)) ||
            dice.containsAll(Arrays.asList(3, 4, 5, 6));

    return isSmallStraight ? 15 : 0;

}

public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
    Set<Integer> dice = new HashSet<>(Arrays.asList(d1, d2, d3, d4, d5));
    boolean isLargeStraight = dice.equals(Set.of(1, 2, 3, 4, 5)) || dice.equals(Set.of(2, 3, 4, 5, 6));
    return isLargeStraight ? 20 : 0;


}

public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
    int[] tallies;
    boolean _2 = false;
    int i;
    int _2_at = 0;
    boolean _3 = false;
    int _3_at = 0;




        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i+1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i+1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }
}



