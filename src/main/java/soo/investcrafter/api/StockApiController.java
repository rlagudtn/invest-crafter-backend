package soo.investcrafter.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
@Slf4j
@RequiredArgsConstructor
public class StockApiController {
    private final CompanyService companyService;

    @GetMapping(value = "")
    public ResponseEntity readAllStocks(@PageableDefault(size = 10,direction = Sort.Direction.DESC) Pageable pageable) {
        try {
            log.info("pageable>>> {}",pageable.toString());
            Page<CompanyDto> companies = companyService.getCompanyWithLatestKeyIndicator(pageable);
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
