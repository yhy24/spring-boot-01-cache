package com.yang.cache.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: yhy
 * @Date: 2019/5/15 11:12
 * @Version 1.0
 */
public class UserDO implements Serializable {
    private static final long serialVersionUID = 831181693822793770L;

    private List<Integer> lists;
    private String ids;

    public List<Integer> getLists() {
        return lists;
    }

    public void setLists(List<Integer> lists) {
        this.lists = lists;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "lists=" + lists +
                ", ids='" + ids + '\'' +
                '}';
    }
}
