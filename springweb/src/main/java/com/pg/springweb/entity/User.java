package com.pg.springweb.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NotEmpty(message = "名称不能为空")
    @Size(min=2 ,message = "名称至少2个字")
    private String name;
    private int age;
    private Sex sex;
    public enum Sex{
        MAN,WOMEN
    }
}
