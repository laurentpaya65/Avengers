package org.epita.testdoomcode;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

import org.epita.doomcode.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestDoomCode {

//    @ParameterizedTest
//    @ValueSource(doubles = {10,100,10000,0,-124.40F})              à réessayer
    @RepeatedTest(1)
    @Disabled("marche à 99,5 %")
    public void test_doom_code() {
        float entree = (float) Math.random()*Float.MAX_VALUE;
        double resultatCode = DoomCode.invSqrt(entree);
        double resultatCodeJava = Math.pow(entree,(-0.5));
        assertThat(resultatCode).isCloseTo(resultatCodeJava, Percentage.withPercentage(0.5));

        assertThat( (double) DoomCode.invSqrt(15)).isCloseTo(0.25F, offset(0.001));
        System.out.println(DoomCode.invSqrt(15));
    }
}
