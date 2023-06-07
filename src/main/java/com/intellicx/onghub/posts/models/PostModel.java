package com.intellicx.onghub.posts.models;

import com.intellicx.onghub.ongs.models.ONGModel;
import com.intellicx.onghub.users.models.UserModel;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.sql.rowset.serial.SerialBlob;
import java.util.Date;
import java.util.UUID;

@Data
@Table(name = "tb_posts")
@Entity
public class PostModel {

    private static final UUID serialVersionUID = new UUID(1L, 1L);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserModel user;

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

    public void setPicture(SerialBlob serialBlob) {
        try {
            this.picture = serialBlob.getBytes(1, (int) serialBlob.length());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
