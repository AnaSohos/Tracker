
package com.mycompany.trackerunittest;


import java.util.ArrayList;
import java.util.Objects;

public class Tracker {

    private final ArrayList<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < items.size(); index++) {
            Item item = items.get(index);
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public ArrayList <Item> returnItem(int id, Item itemD) {
        
     for (int index = 0; index < items.size(); index++) {
          Item item1 = items.get(index);
            if (item1.getId() == id) {
                items.set(index, itemD);
                break;

            }
 
        }
    
        return items;
    }

    public void deleteItem(int id) {
        Item rsl = null;
        for (Item it : items) {

            if (it.getId() == id) {
                items.remove(it);
                break;

            }

        }
    }

    public Item  findByName(String key) {
        Item item4 = null;
        for (int index = 0; index < items.size(); index++) {
            Item item2 = items.get(index);
            if (item2.getName().contains(key)) {
                item4 =  item2;
            break;}
       
    }
       return  item4;
    }

    public ArrayList<Item> findAll() {
        ArrayList<Item> allItem = new ArrayList();
        for (Item oo : items) {

            allItem.add(oo);
        }

        return allItem;

    }

  

    public void setIds(int ids) {
        this.ids = ids;
    }


    public Tracker() {
    }

    @Override
    public String toString() {
        return "Tracker{" + "items=" + items + ", ids=" + ids + '}';
    }

    

}


