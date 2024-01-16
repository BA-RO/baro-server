package com.baro.template.presentation;

import com.baro.auth.domain.AuthMember;
import com.baro.template.application.TemplateService;
import com.baro.template.application.dto.FindTemplateQuery;
import com.baro.template.application.dto.FindTemplateResult;
import com.baro.template.domain.TemplateCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/templates")
@RestController
public class TemplateController {

    private final TemplateService templateService;

    @GetMapping("/{category}")
    ResponseEntity<Slice<FindTemplateResult>> findTemplates(
            AuthMember authMember,
            @PathVariable("category") String categoryName,
            @RequestParam("sort") String sortName
    ) {
        Sort sort = SortType.getSort(sortName);
        FindTemplateQuery query = new FindTemplateQuery(TemplateCategory.getCategory(categoryName), sort);
        Slice<FindTemplateResult> result = templateService.findTemplates(query);

        return ResponseEntity.ok().body(result);
    }
}
