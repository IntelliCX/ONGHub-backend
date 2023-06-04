package com.intellicx.onghub.posts.models;

import com.intellicx.onghub.ongs.models.ONGModel;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.UUID;

@Data
@Table(name = "tb_profiles")
@Entity
public class PostModel {

    private static final UUID serialVersionUID = new UUID(1L, 1L);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", referencedColumnName = "id", nullable = false)
    private ONGModel ong;

    @Column()
    private String caption;

    @Lob
    @Column()
    private byte[] picture;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updatedAt;

    @Column(name = "deleted_at")
    private Date deletedAt;
}
