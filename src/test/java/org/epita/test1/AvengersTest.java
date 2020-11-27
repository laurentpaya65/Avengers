package org.epita.test1;


import org.junit.jupiter.api.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.epita.test1.Characters.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AvengersTest {

    Long diff;

    @BeforeEach
    public void beforeEach() {
        diff = System.currentTimeMillis();
//        System.out.println(System.currentTimeMillis() );
    }
    @AfterEach
    public void afterEach() {
        System.out.println( System.currentTimeMillis() - diff);
    }
    @Test
    public void modif_liste_superheros() {
        Throwable thrown = catchThrowable(() -> {hulk.getPowers().add("faible");});

        assertThat(thrown).isNotNull();
    }
    @Test
    public void test_8() {
        org.junit.jupiter.api.Assertions.assertAll(
                () -> assertThat(spiderman.heroNameOrHumanoidNameIfNull())
                .withFailMessage("spiderman ne contient pas d'espace")
                        .contains(" "),
                () -> assertThat(hulk.heroNameOrHumanoidNameIfNull()).contains(" "),
                () -> assertThat(ironman.heroNameOrHumanoidNameIfNull()).contains(" ")
        );
    }
    @Test
    @Order(2)
    public void Given_spiderman_When_mineur_Then_pasErreur() {
        assertThat(spiderman.getAge()).isLessThanOrEqualTo(15);
    }
    @Test
    @Order(1)
    public void Given_BlackWidow_When_faitpartie_Then_pasErreur() {
        assertThat(Characters.blackWidow).isIn(Characters.avengers);
    }
    @Test
    @Disabled("pas encore bon")
    @Order(3)
    public void Given_Avengers_When_pasdedoublons_Then_ok() {
        Set<SuperHero> setAvengers = new HashSet<org.epita.test1.SuperHero>(Characters.avengers);
        assertThat(Characters.avengers.size()).isEqualTo(setAvengers.size());

        assertThat(avengers).doesNotHaveDuplicates();
    }
    @Test
    public void Given_Avengers_When_pasThanos_Then_ok() {
        Set<SuperHero> setAvengers = new HashSet<org.epita.test1.SuperHero>(Characters.avengers);

        assertThat(thanos).isNotIn(Characters.avengers);

    }
    @Test
    public void Given_ThorThanos_When_pasNomSuperhero_Then_ok() {

        assertThat(Characters.thor).hasFieldOrPropertyWithValue("heroName",null);
        assertThat(Characters.thanos).hasFieldOrPropertyWithValue("heroName",null);
    }
    @Test
    public void Given_thanosSuperpouvoirs_When_hulkSuperpouvoirs_Then_ok() {

        assertThat(thanos.getPowers()).containsAll(hulk.getPowers());
    }
    @Test
    public void type_de_superhero() {

        assertThat(hawkEye)
                .isInstanceOf(SuperHero.class)
                .isInstanceOf(Humanoid.class);
        assertThat(clintonBarton).isNotInstanceOfAny(SuperHero.class,String.class);
    }
    @Test
    public void type_age() {

        assertThat(tonyStark.getAge()).isEqualTo(bruceBanner.getAge());
        assertThat(tonyStark).isEqualToComparingOnlyGivenFields(bruceBanner,"age");
          }
    @Test
    public void nom_heros() {

        assertThat(ironman.heroNameOrHumanoidNameIfNull()).contains(" ");
        assertThat(spiderman.heroNameOrHumanoidNameIfNull()).doesNotContainAnyWhitespaces();

    }
}
