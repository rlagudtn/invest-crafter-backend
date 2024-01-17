package soo.investcrafter.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/home")
public class HomeApiController {

    @GetMapping(value = "")
    public ResponseEntity readKeyIndicators() {

        return null;
    }

}
