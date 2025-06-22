package site.webzank.rent.handler;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import site.webzank.rent.common.result.Result;

/**
 * @author zank
 */
@RestControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class GlobalExceptionHandler {
    private final Gson gson = new Gson();

    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception e) {
        log.error("服务器发生异常：{}", e.getMessage());
        return gson.toJson(Result.error("服务器发生异常：" + e.getMessage()));
    }

}
