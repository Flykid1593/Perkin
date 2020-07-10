package com.beidou.tree.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Perkin
 * @version 1.0
 * @date 2020/7/10 0010 8:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentScore {
    private String stuName;
    private String subject;
    private int score;
}
