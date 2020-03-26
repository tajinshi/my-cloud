package com.tjs.feign;

import com.tjs.bean.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "demo-provider")
public interface StudentFeign {
    @GetMapping("getStudentById")
    Student getStudentById(@RequestParam("id") Long id);
}
