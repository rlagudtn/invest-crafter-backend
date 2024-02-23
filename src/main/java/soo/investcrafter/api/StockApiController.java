package soo.investcrafter.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soo.investcrafter.dto.JSendResponse;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/stocks")
public class StockApiController {

    @GetMapping(value = "")
    public ResponseEntity readAllStocks() {
        try {
            // 데이터 로직 처리
            return ResponseEntity.ok(JSendResponse.success("hello"));
        } catch (Exception e) {
            // 예외 처리 및 에러 응답 반환
            return ResponseEntity.badRequest().body(JSendResponse.error("erorr"));

        }
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
