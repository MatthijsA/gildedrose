package com.gildedrose;

public enum Product {
    AGED_BRIE("Aged Brie"),
    BACKSTAGE_PASS("Backstage passes to a TAFKAL80ETC concert"),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    CONJURED("Conjured Mana Cake");

    public final String name;

    Product(String name) {
        this.name = name;
    }
}
