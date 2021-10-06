/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trackerunittest;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Assert;
import static org.hamcrest.core.Is.is;

/**
 *
 * @author Admin
 */
public class TrackerTest {

    public TrackerTest() {
    }

    @Test
    public void whenAdd() {
        Item item = new Item("zayavka1");
        Tracker instance = new Tracker();
        Item result = instance.add(item);
        assertThat("zayavka1", is(result.getName()));

    }

    @Test
    public void whenFindById() {
        Item ferst = new Item("ferst");
        Item second = new Item("second");
        Tracker trac = new Tracker();
        trac.add(ferst);
        trac.add(second);
        Item idd = trac.findById(1);
        String sss = idd.getName();
        String prov = "ferst";
       assertThat(prov,is(sss));

    }

    @Test
    public void whenReturnItem() {
        Tracker instance1 = new Tracker();
        Item zayavka1 = new Item("zayavka1");
        Item zayavka2 = new Item("zayavka2");
        Item zayavkaNew = new Item(1, "zayavkanew");
        instance1.add(zayavka1);
        instance1.add(zayavka2);
        ArrayList<Item> idd = instance1.returnItem(1, zayavkaNew);
        String dd = new String();
        for (int index = 0; index < idd.size(); index++) {
            Item item1 = idd.get(index);
            if (item1.getId() == 1) {
                dd = item1.getName();
                break;
            }
        }

          assertThat("zayavkanew", is(dd));

    }

    @Test
    public void whenDeleteItem() {
        boolean bool = true;
        Tracker trac2 = new Tracker();
        Item zayavka1 = new Item(1, "zayavka1");
        Item zayavka2 = new Item(2, "zayavka2");
        Item zayavka3 = new Item(3, "zayavka3");
        trac2.add(zayavka1);
        trac2.add(zayavka2);
        trac2.add(zayavka3);
        trac2.deleteItem(2);
        ArrayList<Item> itemDelete = trac2.findAll();

        for (Item it : itemDelete) {

            if (it.getId() == 2) {
                bool = false;
                break;

            }

        }
        assertThat( true,is(bool));
        
    }

    @Test
    public void whenFindByName() {
        Tracker trac3 = new Tracker();
        Item zayavka1 = new Item(1, "zayavka1");
        Item zayavka2 = new Item(2, "zayavka2");
        Item zayavka3 = new Item(3, "zayavka3");
        trac3.add(zayavka1);
        trac3.add(zayavka2);
        trac3.add(zayavka3);
        String zayavkaProv = zayavka2.getName();
        String key = new String("zayavka2");
        Item result = trac3.findByName(key);
        String zayavkaVozvrat = result.getName();
        assertThat(zayavkaVozvrat, is(zayavkaProv));

    }

    @Test
    public void testFindAll() {
        Tracker trac4 = new Tracker();
        Item zayavka1 = new Item(1, "zayavka1");
        Item zayavka2 = new Item(2, "zayavka2");
        trac4.add(zayavka1);
        trac4.add(zayavka2);
        ArrayList<Item> expResult = new ArrayList<>();
        expResult.add(zayavka1);
        expResult.add(zayavka2);
        ArrayList<Item> result = trac4.findAll();
        assertThat(expResult, is(result));
        
    }

}
