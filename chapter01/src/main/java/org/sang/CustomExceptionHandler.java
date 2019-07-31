package org.sang;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    //这个是返回模板
    public ModelAndView uploadException(MaxUploadSizeExceededException e, HttpServletResponse resp) throws IOException {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","上传文件大小超出限制!");
        mv.setViewName("error");
        return mv;
    }

//    @ExceptionHandler(Exception.class)
//    public void myexce(Exception e) {
//        System.out.println("myexce>>>"+e.getMessage());
//    }
}
