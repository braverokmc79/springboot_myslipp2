package net.slipp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

   @RequestMapping("/example-page")
    public String index() {
        return "Hello World With Spring Loaded!";
    }
}
