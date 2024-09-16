package br.com.gabsprojects.file_manager.data.model;

import br.com.gabsprojects.file_manager.data.type.FileOriginType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "file")
public class FileModel {

    @Id
    @Column(name = "uuid")
    private String uuid = UUID.randomUUID().toString();

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "origin_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private FileOriginType originType;

    @Column(name = "origin_uuid", nullable = false)
    private String originUuid;

    @Column(name = "file_path", nullable = false)
    private String filePath;

    @CreationTimestamp
    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Column(name = "active", nullable = false)
    private Boolean active = Boolean.TRUE;

    public FileModel(FileOriginType originType, String originUuid, MultipartFile file) {
        this.name = file.getOriginalFilename();

        var filenameParts = Objects.requireNonNull(file.getOriginalFilename()).split("[.]");
        var fileExtension = filenameParts[filenameParts.length - 1];
        this.filePath = originType.name() + "/" + this.uuid + "." + fileExtension;

        this.originType = originType;
        this.originUuid = originUuid;
    }
}
