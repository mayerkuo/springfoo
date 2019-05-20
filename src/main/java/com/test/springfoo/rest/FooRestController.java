package com.test.springfoo.rest;

import com.github.javafaker.Faker;
import com.test.springfoo.data.DataIn;
import com.test.springfoo.data.TestBean;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class FooRestController {

    @RequestMapping(value = "api/foo", method = RequestMethod.POST)
    @ResponseBody
    public String hello() {
        return "hello world";
    }

    @RequestMapping(value = "api/foo1", method = RequestMethod.POST)
    @ResponseBody
    public TestBean hello2() {
        TestBean tb = new TestBean();
        tb.setDepartment("EAD");
        tb.setId(20);
        tb.setName("foo");
        return tb;
    }

    @RequestMapping(value = "api/foo2", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public TestBean hello3(@RequestBody DataIn di) {
        TestBean tb = new TestBean();
        tb.setDepartment("EAD");
        tb.setId(di.getId());
        tb.setName(di.getName());
        return tb;
    }

    @RequestMapping(value = "api/generate", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public TestBean generate() {
        TestBean tb = new TestBean();
        Random random = new Random();
        Integer id = random.nextInt(100);
        String name = UUID.randomUUID().toString();

        tb.setId(id);
        tb.setName(name);
        tb.setDepartment("EAD");

        return tb;
    }

    // POST
    // http://localhost:8080/api/init
    @RequestMapping(value = "api/init", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public List<TestBean> init() {
        Random random = new Random();
        Faker faker = new Faker();

        TestBean tb1 = new TestBean();
        tb1.setId(random.nextInt(100));
        tb1.setName(faker.name().firstName());
        tb1.setDepartment("IT");

        TestBean tb2 = new TestBean();
        tb2.setId(random.nextInt(100));
        tb2.setName(faker.name().firstName());
        tb2.setDepartment("IT");

        TestBean tb3 = new TestBean();
        tb3.setId(random.nextInt(100));
        tb3.setName(faker.name().firstName());
        tb3.setDepartment("IT");

        TestBean tb4 = new TestBean();
        tb4.setId(random.nextInt(100));
        tb4.setName(faker.name().firstName());
        tb4.setDepartment("IT");

        List<TestBean> r = new ArrayList<>();
        Collections.addAll(r, tb1, tb2, tb3, tb4);

        return r;
    }
}
