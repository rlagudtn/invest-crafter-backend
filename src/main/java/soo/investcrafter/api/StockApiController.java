package soo.investcrafter.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soo.investcrafter.dto.CompanyDto;
import soo.investcrafter.dto.JSendResponse;
import soo.investcrafter.service.CompanyService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/stocks")
@RequiredArgsConstructor
public class StockApiController {
    private final CompanyService companyService;

    @GetMapping(value = "")
    public ResponseEntity readAllStocks() {
        try {
            List<CompanyDto> companies = companyService.getCompanyWithLatestKeyIndicator();

            // 데이터 로직 처리
            return ResponseEntity.ok(JSendResponse.success(companies));
        } catch (Exception e) {
            // 예외 처리 및 에러 응답 반환
            return ResponseEntity.badRequest().body(JSendResponse.error("error"));

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
