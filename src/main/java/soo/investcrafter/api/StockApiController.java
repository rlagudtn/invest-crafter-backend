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
import soo.investcrafter.dto.SearchCriteriaDto;
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
    public ResponseEntity readCompaniesWithIndicators(
            @PageableDefault(size = 10,direction = Sort.Direction.DESC) Pageable pageable,
            SearchCriteriaDto searchCriteria
            ) {
        try {
            log.info("pageable>>> {}",pageable.toString());
            log.info("searchCriteria>>> {}", searchCriteria.toString());

            Page<CompanyDto> companies = companyService.getCompanyWithLatestKeyIndicator(pageable,searchCriteria);
            // 데이터 로직 처리
            return ResponseEntity.ok(JSendResponse.success(companies));
        } catch (Exception e) {
            // 예외 처리 및 에러 응답 반환
            return ResponseEntity.badRequest().body(JSendResponse.error("error"));

        }
    }

    @GetMapping
    public ResponseEntity searchCompaniesByKeyword(
            @RequestParam String keyword,
            @PageableDefault(size = 10, direction = Sort.Direction.ASC) Pageable pageable) {
        try {
            List<CompanyDto> searchedCompanies= companyService.searchCompaniesByKeyword(keyword, pageable);
            return ResponseEntity.ok(JSendResponse.success(searchedCompanies));
        } catch (Exception e) {
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
