package cn.siwen.cloud.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //自动生成有参构造
@NoArgsConstructor  //自动生成无参构造
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T date;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
