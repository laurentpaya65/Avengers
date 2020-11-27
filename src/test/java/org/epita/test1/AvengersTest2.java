package org.epita.test1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.epita.test1.Characters.*;

import static org.assertj.core.api.Assertions.*;

public class AvengersTest2 {

    @Test
//    @ValueSource(tables = {{"a","b","c"},{"a,"a"}})
    public void test_liste(List<String> maListe) {
        RemoveDuplicate maClasse = new RemoveDuplicate();
        List<String> maListe = new ArrayList<>(Arrays.asList("a","a",null,null));
        assertThat(maClasse.removeDuplicate(maListe)).doesNotHaveDuplicates();
//        assertThat(maListe).doesNotHaveDuplicates();

    }
    @Test
    public void spiderman_mineur() {
        assertThat(spiderman.getAge()).isLessThanOrEqualTo(15);
    }
    @Test
    public void black_widow() {
        assertThat(blackWidow).isIn(avengers);
    }
    @Test
    public void sh_doublon() {
        assertThat(avengers).doesNotHaveDuplicates();
    }
    @Test
    public void avengers_thanos() {
        assertThat(thanos).isNotIn(avengers);
    }
    @Test
    public void thor_thanos_nom() {
        assertThat(thanos).hasFieldOrPropertyWithValue("heroName",null);
    }
    @Test
    public void super_pouvoir() {
        assertThat(thanos.getPowers()).containsAll(hulk.getPowers());
    }
    @Test
    public void hawk_barton() {
        assertThat(hawkEye)
                .isInstanceOf(SuperHero.class)
                .isInstanceOf(Humanoid.class);
        assertThat(clintonBarton).isNotInstanceOfAny(SuperHero.class,String.class);
    }
    @Test
    public void age_tony_bruce() {
        assertThat(tonyStark).isEqualToComparingOnlyGivenFields(bruceBanner,"age");
    }


}
