package com.intellicx.onghub.ongs.models;

import com.intellicx.onghub.users.models.UserModel;
import lombok.Data;

import jakarta.persistence.*;

@Data
@Table(name = "tb_ongs")
@Entity
public class ONGModel extends UserModel {
    public ONGModel() {
        this.setRole("ONG");
    }

    @Column(name = "pix_key")
    private String pixKey;

    @Column(name = "website_url")
    private String websiteUrl;

}
