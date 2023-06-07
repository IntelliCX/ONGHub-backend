package com.intellicx.onghub.contributors.models;

import com.intellicx.onghub.ongs.models.ONGModel;
import com.intellicx.onghub.users.models.UserModel;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "tb_contributors")
public class ContributorModel extends UserModel {
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tb_ongs_contributors", joinColumns = {
            @JoinColumn(name = "contributor_id", referencedColumnName = "id"),
    }, inverseJoinColumns = {
            @JoinColumn(name = "ong_id", referencedColumnName = "id")
    })
    private List<ONGModel> ongs;

    public ContributorModel() {
        this.setRole("CONTRIBUTOR");
    }
}
