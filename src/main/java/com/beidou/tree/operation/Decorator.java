package com.beidou.tree.operation;

import com.beidou.tree.entity.User;
import lombok.AllArgsConstructor;

/**
 * @author Perkin
 * @version 1.0
 * @date 2020/7/8 0008 17:00
 */
@AllArgsConstructor
public abstract class Decorator implements MoneyOperation {

    private MoneyOperation moneyOperation;

    @Override
    public Integer operation(User user) {
        return moneyOperation.operation(user);
    }
}
