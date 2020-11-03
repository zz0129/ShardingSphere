package com.ly.sharding.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
public class User {
    private Long user_id;
    private String username;
    private String ustatus;
}
