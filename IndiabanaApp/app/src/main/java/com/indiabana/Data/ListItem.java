package com.indiabana.Data;

import com.reim.android.filterrecyclerview.FilterableItem;

public class ListItem implements FilterableItem {

    private final String name;


    public ListItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListItem listItem = (ListItem) o;

        return name.equals(listItem.name);
    }
    @Override
    public int hashCode() {
        int result = name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ListItem{" +
                "name='" + name + '\'' +
                '}';
    }

}
