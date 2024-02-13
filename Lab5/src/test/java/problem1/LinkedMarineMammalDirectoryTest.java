package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedMarineMammalDirectoryTest {
    private LinkedMarineMammalDirectory linkedMarineMammalDirectory1;
    private MarineMammal marineMammal1, marineMammal2;

    @BeforeEach
    void setUp() {
        linkedMarineMammalDirectory1 = new LinkedMarineMammalDirectory();
        marineMammal1 = new MarineMammal("dolphin",null, null, null,null,null,null);
        marineMammal2 = new MarineMammal("seaLion",null, null, null,null,null,null);
    }

    @Test
    void add() {

    }

    @Test
    void isEmpty() {
    }

    @Test
    void containsMammal() {
        MarineMammalDirectory newDir1 = linkedMarineMammalDirectory1.add(marineMammal2);
        MarineMammalDirectory newDir2 = newDir1.add(marineMammal1);
        assertTrue(newDir2.containsMammal(marineMammal1));
    }

    @Test
    void remove() {
    }
}