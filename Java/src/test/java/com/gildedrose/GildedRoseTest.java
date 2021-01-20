package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void testConjuredItems() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 5, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(48, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);

        app.updateQuality();
        assertEquals(46, app.items[0].quality);
        assertEquals(3, app.items[0].sellIn);

        app.updateQuality();
        app.updateQuality();
        assertEquals(42, app.items[0].quality);
        assertEquals(1, app.items[0].sellIn);

        app.updateQuality();
        assertEquals(40, app.items[0].quality);
        assertEquals(0, app.items[0].sellIn);

        app.updateQuality();
        assertEquals(36, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);

        updateQuality(2, app);
        assertEquals(28, app.items[0].quality);
        assertEquals(-3, app.items[0].sellIn);

        updateQuality(7, app);
        assertEquals(0, app.items[0].quality);
        assertEquals(-10, app.items[0].sellIn);

        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(-11, app.items[0].sellIn);
    }

    private void updateQuality(int numberOfTimes, GildedRose app) {
        for(int i = 0; i < numberOfTimes; i++) {
            app.updateQuality();
        }
    }

}
