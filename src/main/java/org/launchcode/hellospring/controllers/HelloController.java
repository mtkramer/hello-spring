package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class HelloController {

    @GetMapping("hello-spring")
    public String hello(){
        return "Hello, Spring!";
    }

    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value="hello")
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
    public String helloWithPath(@PathVariable String name){return "Hello, " + name + "!";}

    @GetMapping("form")
    public String helloForm(){
        return
            "<html>" +
                "<body>" +
                    "<form action='hello' method='post'>" +
                        "<input type='text' name='name'>" +
                        "<select name='lang'>" +
                            "<option value='en'>--Please choose a language--</option>" +
                            "<option value='sp'>Spanish</option>\n" +
                            "<option value='fr'>French</option>\n" +
                            "<option value='gr'>German</option>\n" +
                            "<option value='ch'>Chinese</option>\n" +
                        "</select>" +
                        "<input type='submit' value='Greet Me'>" +
                    "</form>" +
                "</body>" +
            "</html>";
    }

}
