package com.DNA.bean;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description 购物车对象
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/5/17 11:17
 */
public class Cart {
    //private Integer totalCount;
    //private BigDecimal totalPrice;
    //key = 商品编号，value = 商品信息
    private Map<Integer, CartItem> items = new LinkedHashMap<Integer, CartItem>();

    /**
    * @Description 添加商品项
    * @Return [cartItem]
    * @Author 脱氧核糖
    * @Date 2021/5/17 11:23
    */
    public void addItem(CartItem cartItem) {
        //查找购物车中是否有此商品
        CartItem item = items.get(cartItem.getId());
        if (item == null) {
            items.put(cartItem.getId(), cartItem);
        } else {
            //商品数+1，商品总金额*新商品数
            item.setCount(item.getCount() + 1);
            item.setTotalPrice(item.getTotalPrice().multiply(new BigDecimal(item.getCount())));
        }
    }

    /**
    * @Description 删除商品项
    * @Return [id]
    * @Author 脱氧核糖
    * @Date 2021/5/17 11:23
    */
    public void deleteItem(Integer id) {
        items.remove(id);
    }

    /**
    * @Description 清空购物车
    * @Return []
    * @Author 脱氧核糖
    * @Date 2021/5/17 11:23
    */
    public void clear() {
        items.clear();
    }

    /**
    * @Description 修改商品数量
    * @Return [id, count]
    * @Author 脱氧核糖
    * @Date 2021/5/17 11:24
    */
    public void updateCount(Integer id, Integer count) {
        //查找购物车中是否有此商品
        CartItem cartItem = items.get(id);
        if (cartItem != null) {
            cartItem.setCount(count);
            cartItem.setTotalPrice(cartItem.getTotalPrice().multiply(new BigDecimal(cartItem.getCount())));
        }
    }

    public Integer getTotalCount() {
        Integer totalCount = 0;
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
