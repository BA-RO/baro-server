package com.baro.template.domain;

import java.util.List;

public interface TemplateMemberRepository {

    boolean existsByMemberIdAndTemplateId(Long memberId, Long templateId);

    TemplateMember save(TemplateMember templateMember);

    List<TemplateMember> findAll();

    TemplateMember getByMemberIdAndTemplateId(Long memberId, Long templateId);

    void delete(TemplateMember templateMember);
}