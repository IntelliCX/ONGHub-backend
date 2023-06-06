package com.intellicx.onghub.contributors.models;

import com.intellicx.onghub.users.models.UserModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_contributors")
@PrimaryKeyJoinColumn(name = "user_id")
public class ContributorModel extends UserModel {
}
