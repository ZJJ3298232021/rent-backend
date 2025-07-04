package site.webzank.rent.common.result;

import lombok.Data;

import java.io.Serializable;

/**
 * 后端统一返回结果
 *
 * @param <T>
 * @author zank
 */
@Data
public class Result<T> implements Serializable {

    private Integer code;
    //编码：1成功，0和其它数字为失败
    private String message;
    //错误信息
    private T data;
    //数据

    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.code = 200;
        result.message = "success";
        return result;
    }

    public static <T> Result<T> success(T object) {
        Result<T> result = new Result<>();
        result.data = object;
        result.code = 200;
        result.message = "success";
        return result;
    }

    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<>();
        result.message = msg;
        result.code = 400;
        return result;
    }

}
