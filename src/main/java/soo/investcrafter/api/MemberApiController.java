package soo.investcrafter.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/members")
public class MemberApiController {

    @GetMapping(value = "/{id}")
    public ResponseEntity readMemberById(@PathVariable(value = "id") Long id) {

        return null;
    }

    @PutMapping(value = "{id}")
    public ResponseEntity updateMemberById() {
        return null;
    }
}
