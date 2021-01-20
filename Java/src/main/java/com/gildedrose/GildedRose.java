package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    /**
     * Update the quality and the sellIn date of each item of each item
     */
    public void updateQuality() {
        for (Item item : items) {
            updateQuality(item);
            updateSellIn(item);
        }
    }

    /**
     * Update the quality of the given item.
     * @param item The item to update the quality of.
     */
    private void updateQuality(Item item) {
        if (item.name.equals(Product.AGED_BRIE.name)) {
            updateAgedBrieQuality(item);
        } else if (item.name.equals(Product.BACKSTAGE_PASS.name)) {
            updateBackstagePassQuality(item);
        } else if (item.name.equals(Product.SULFURAS.name)) {
            // sulfuras do not degrade in quality
        } else if (item.name.equals(Product.CONJURED.name)) {
            updateConjuredItemQuality(item);
        } else {
            updateNormalItemQuality(item);
        }
    }

    /**
     * Update the sellIn of the given item.
     * @param item The item to update the sellIn of.
     */
    private void updateSellIn(Item item) {
        if (!item.name.equals(Product.SULFURAS.name)) {
            item.sellIn--;
        }
    }

    /**
     * Update the quality of aged brie.
     * @param agedBrie Only pass aged brie as parameter!
     */
    private void updateAgedBrieQuality(Item agedBrie) {
        increaseQuality(agedBrie);

        if (willExpire(agedBrie)) {
            increaseQuality(agedBrie);
        }
    }

    /**
     * Update the quality of backstage pass.
     * @param backstagePass Only pass backstage pass as parameter!
     */
    private void updateBackstagePassQuality(Item backstagePass) {
        increaseQuality(backstagePass);

        if (backstagePass.sellIn < 11) {
            increaseQuality(backstagePass);
        }

        if (backstagePass.sellIn < 6) {
            increaseQuality(backstagePass);
        }

        if (willExpire(backstagePass)) {
            backstagePass.quality = 0;
        }
    }

    /**
     * Update the quality of conjured items.
     * @param conjuredItem Only pass conjured items as parameter!
     */
    private void updateConjuredItemQuality(Item conjuredItem) {
        decreaseQuality(conjuredItem);
        decreaseQuality(conjuredItem);

        if (willExpire(conjuredItem)) {
            decreaseQuality(conjuredItem);
            decreaseQuality(conjuredItem);
        }
    }

    /**
     * Update the quality of normal items.
     * @param normalItem Only pass normal items as parameter!
     */
    private void updateNormalItemQuality(Item normalItem) {
        decreaseQuality(normalItem);

        if (willExpire(normalItem)) {
            decreaseQuality(normalItem);
        }
    }

    /**
     * Mijn voorkeur zou hebben om deze methode op de item class zelf te maken.
     */
    private boolean willExpire(Item item) {
        return item.sellIn < 1;
    }

    /**
     * Mijn voorkeur zou hebben om deze methode op de item class zelf te maken.
     */
    private void increaseQuality(Item item) {
        item.quality = Math.min(item.quality+1, 50);
    }

    /**
     * Mijn voorkeur zou hebben om deze methode op de item class zelf te maken.
     */
    private void decreaseQuality(Item item) {
        item.quality = Math.max(item.quality-1, 0);
    }
}