package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {


    @GetMapping("hello-names")
    public String helloNames(Model model){
        String[] names = {"Mike", "Spring", "Blake", "Mary", "Chris"};
        model.addAttribute("names", names);
        return "hello-list";
    }

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("greeting", "Hello, Spring!");
        return "hello";
    }

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value="hello-spring")
    @ResponseBody
    public String helloWithQuery(@RequestParam String name, @RequestParam String lang){
        return switch (lang) {
            case "sp" -> "<h1>¡Hola, " + name + "!</h1>";
            case "fr" -> "<h1>Bonjour, " + name + "!</h1>";
            case "gr" -> "<h1>Hallo, " + name + "!</h1>";
            case "ch" -> "<h1>Ni hao, " + name + "!</h1>";
            default -> "<h1>Hello, " + name + "!</h1>";
        };
    }

    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPath(@PathVariable String name){ return "Hello, " + name + "!"; }

    @GetMapping("form")
    public String helloForm(){
        return "form";
    }

}
