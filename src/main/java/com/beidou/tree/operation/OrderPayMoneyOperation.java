package com.beidou.tree.operation;

import cn.hutool.core.util.ObjectUtil;
import com.beidou.tree.entity.User;
import com.beidou.tree.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Perkin
 * @version 1.0
 * @date 2020/7/8 0008 16:55
 */
@Component(value="orderPayMoneyOperation")
@AllArgsConstructor
public class OrderPayMoneyOperation implements  MoneyOperation{

    private UserMapper userMapper;

    public Integer operation(User user) {
        User users = userMapper.selectById(user.getId());
        int count = 0;
        if(ObjectUtil.isEmpty(users)){
            Integer num = user.getNum();
            String password = user.getPassword();
            int i = Integer.parseInt(password);
            count = num * i;
        }else {
            Integer num = users.getNum();
            String password = users.getPassword();
            int i = Integer.parseInt(password);
            count = num * i;
        }
        return count;
    }
}
