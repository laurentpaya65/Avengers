package org.epita.test1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicate {


    public List<String> removeDuplicate(List<String> liste) {

        return  new ArrayList<>(new HashSet<>(liste));
    }
}
