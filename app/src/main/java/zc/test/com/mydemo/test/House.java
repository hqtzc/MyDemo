package zc.test.com.mydemo.test;

import androidx.annotation.NonNull;

import java.util.Observable;

public class House extends Observable {
    private float house_price;

    public House(float house_price) {
        this.house_price = house_price;
    }

    public void updatePrice(float house_price) {
        this.house_price = house_price;
        // 设置变化点
        setChanged();
        // 通知观察者
        notifyObservers(house_price);
    }

    @NonNull
    @Override
    public String toString() {
        return "当前房子价格：" + house_price;
    }

}
