package com.probal.restfulwebservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController()
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping(path = "/hello-world")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean/{name}")
    public HelloWorldModel sayHelloFromBean(@PathVariable String name) {
        return new HelloWorldModel(String.format("Hello %s", name));
    }

    /*@GetMapping(path = "/hello-world-internationalized")
    public String sayI18GoodMorning(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return messageSource.getMessage("good.morning.message", null, locale);
    }*/

    @GetMapping(path = "/hello-world-internationalized")
    public String sayI18GoodMorning() {
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }
}
