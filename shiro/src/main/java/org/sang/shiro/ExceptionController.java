package org.sang.shiro;

import com.alibaba.fastjson.JSON;
import net.sf.json.JSONObject;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(AuthorizationException.class)
    public void  error(HttpServletResponse res, AuthorizationException e) throws IOException {
        System.out.println("抛出UnauthorizedException权限异常");
        res.setHeader("Access-Control-Allow-Credentials", "true");
        res.setContentType("application/json; charset=utf-8");
        res.setStatus(HttpServletResponse.SC_OK);
        PrintWriter writer = res.getWriter();
        Map<String, Object> map= new HashMap<>();
        map.put("status", 3);
        map.put("msg", "权限不足");
        writer.write(JSON.toJSONString(map));
        writer.close();
    }
}
