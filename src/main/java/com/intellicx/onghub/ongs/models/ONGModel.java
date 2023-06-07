package com.intellicx.onghub.ongs.models;

import com.intellicx.onghub.contributors.models.ContributorModel;
import com.intellicx.onghub.users.models.UserModel;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Table(name = "tb_ongs")
@Entity
public class ONGModel extends UserModel {

    @ManyToMany(mappedBy = "ongs")
    private List<ContributorModel> contributors;

    @Column(name = "pix_key")
    private String pixKey;

    @Column(name = "website_url")
    private String websiteUrl;

    public ONGModel() {
        this.setRole("ONG");
    }

}
