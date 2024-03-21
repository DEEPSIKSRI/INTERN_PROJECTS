package com.jsp.Job.repository;

import com.jsp.Job.entity.AttachmentFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentFileRepository extends JpaRepository< AttachmentFile,Long > {
}