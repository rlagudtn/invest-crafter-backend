package soo.investcrafter.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soo.investcrafter.dto.CompanyDto;
import soo.investcrafter.dto.CompanyWithStatementsDto;
import soo.investcrafter.dto.JSendResponse;
import soo.investcrafter.dto.SearchCriteriaDto;
import soo.investcrafter.service.CompanyService;

import java.util.List;

@RestController
@RequestMapping(value = "/stocks")
@Slf4j
@RequiredArgsConstructor
public class CompanyApiController {
    private final CompanyService companyService;

    @GetMapping(value = "/overviews")
    public ResponseEntity readAllCompanyInfo() {
        try{
            List<CompanyDto> companies = companyService.getAllCompanies();
            return ResponseEntity.ok(JSendResponse.success(companies));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(JSendResponse.error(e.toString()));
        }
    }
    @GetMapping(value = "")
    public ResponseEntity readCompaniesWithIndicators(
            SearchCriteriaDto searchCriteria,
            @PageableDefault(size = 10,direction = Sort.Direction.DESC) Pageable pageable
            ) {
        try {
            log.info("searchCriteria >>> {}", searchCriteria.toString());

            Page<CompanyDto> companies = companyService.getCompanyWithLatestKeyIndicator(pageable,searchCriteria);
            // 데이터 로직 처리
            return ResponseEntity.ok(JSendResponse.success(companies));
        } catch (Exception e) {
            // 예외 처리 및 에러 응답 반환
            return ResponseEntity.badRequest().body(JSendResponse.error(e.toString()));

        }
    }

    @GetMapping(value = "",params = {"keyword"})
    public ResponseEntity searchCompaniesByKeyword(
            @RequestParam(value = "keyword") String keyword,
            @PageableDefault(size = 10, direction = Sort.Direction.ASC) Pageable pageable) {
        try {
            log.info("keyword >>> {},{}",keyword,pageable);
            Page<CompanyDto> searchedCompanies= companyService.searchCompaniesByKeyword(keyword, pageable);

            return ResponseEntity.ok(JSendResponse.success(searchedCompanies));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(JSendResponse.error(e.toString()));
        }

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity readCompanyById(@PathVariable(value = "id") Long id) {
        try{
            CompanyWithStatementsDto companyDto = companyService.getCompanyWithStatements(id);
            log.info("company with statements >>> {}",companyDto);
            return ResponseEntity.ok(JSendResponse.success(companyDto));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(JSendResponse.error(e.toString()));
        }
    }

    @PostMapping(value="/bookmarks/{id}")
    public ResponseEntity bookmarkCompany(@PathVariable Long id) {
        return null;
    }


}
