package com.tjs.feign;

import com.tjs.bean.Student;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "demo-provider",fallbackFactory = StudentFeignFallBack.class)
//@FeignClient(name = "demo-provider")
public interface StudentFeign {
    @GetMapping("getStudentById")
    Student getStudentById(@RequestParam("id") Long id);
}

@Component
class StudentFeignFallBack implements FallbackFactory<StudentFeign> {

    @Override
    public StudentFeign create(Throwable throwable) {
        return new StudentFeign() {
            @Override
            public Student getStudentById(Long id) {
                System.out.println("执行回归代码");
                return new Student();
            }
        };
    }
}