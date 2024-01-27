package soo.investcrafter.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/stocks")
public class StockApiController {

    @GetMapping(value = "")
    public ResponseEntity readAllStocks() {

        return null;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity readStockById(@PathVariable Long id) {
        return null;
    }

    @PostMapping(value="/bookmarks/{id}")
    public ResponseEntity bookmarkCompany(@PathVariable Long id) {
        return null;
    }


}
