package com.xiao.domain;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "user_index")
public class User {
    private Integer id;

    @Field(type = FieldType.Text, analyzer = "ik_max_word") // 分词字段
    private String name;

    @Field(type = FieldType.Integer)
    private Integer age;

    @Field(type = FieldType.Keyword) // 不分词的精确匹配字段
    private String email;
}