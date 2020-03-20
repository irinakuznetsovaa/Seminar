package Seminar1;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SerializeTest {
    List<Animals> listAnimals = Arrays.asList(
            new Animals(TypesAnimals.BIRD,"Kesha",2,Arrays.asList(new Food("cereals", (float) 123.51))),
            new Animals(TypesAnimals.FISH,"Dory",1,Arrays.asList(new Food("worms",(float)1.5))));

    @Test
    public void record()  {
        Serialize.record(listAnimals, "animalFile");
        assertEquals(listAnimals, Serialize.read("animalFile"));
    }
    @Test
    public void serializer()  {
        Serialize.serializer(listAnimals, "hardanimalFile");
        assertEquals(listAnimals, Serialize.deserializer("hardanimalFile"));
    }

}