package com.leetcode.other;
/**
 * Created by guoyong1 on 2017/8/31.
 */

import org.junit.Test;

import java.util.Observable;
import java.util.Observer;

public class ObserverManager extends Observable{

    private int data = 0;
    public int getData(){
        return data;
    }

    public void setData(int i){
        if(this.data != i){ this.data = i;setChanged();}
        notifyObservers();
        //只有在setChange()被调用后，notifyObservers()才会去调用update()，否则什么都不干。  } }
    }

    class AObserver implements Observer{

        public AObserver(ObserverManager sm){
            super();
            sm.addObserver(this);
        }

        public void update(Observable o, Object arg) {
            System.out.println("AObserver receive:Data has changed to "+((ObserverManager) o).getData());
        }
    }

    class BObserver implements Observer{

        public BObserver(ObserverManager sm){
            super();
            sm.addObserver(this);
        }

        public void update(Observable o, Object arg) {
            System.out.println("AObserver receive:Data has changed to "+((ObserverManager) o).getData());
        }
    }


    @Test
    public void test() {
        // TODO Auto-generated method stub
        ObserverManager sm = new ObserverManager();
        AObserver a = new AObserver(sm);
        BObserver b = new BObserver(sm);
        sm.setData(5);
        sm.deleteObserver(a);
        //注销观察者，以后被观察者有数据变化就不再通知这个已注销的观察者
        sm.setData(10);
    }
}
