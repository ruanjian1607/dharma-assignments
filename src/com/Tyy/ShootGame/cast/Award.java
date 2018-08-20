package com.Tyy.ShootGame.cast;
/*
需求：实现此接口的类给予奖励  -->奖励针对于击中蜜蜂的事件
      奖励分别为：0  -->双倍火力
                  1 -->增命
*/

public interface Award {
    int DOUBLE_FIRE = 0;
    int Life = 1;
    //获取奖励方式的方法
    int GetType();
}
