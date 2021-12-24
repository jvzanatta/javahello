package com.javahello.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
@RedisHash("data")
public class Data {
    @Id
    private String id;
    private String value;
}
