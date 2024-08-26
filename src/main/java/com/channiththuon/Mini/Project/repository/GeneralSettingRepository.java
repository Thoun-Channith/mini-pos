package com.channiththuon.Mini.Project.repository;

import com.channiththuon.Mini.Project.models.entity.GeneralSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface GeneralSettingRepository extends JpaRepository<GeneralSetting, Long> {
    Optional<GeneralSetting> findByIdAndIsDeletedFalse(Long id);
    List<GeneralSetting> findAllByIsDeletedFalse();
}
