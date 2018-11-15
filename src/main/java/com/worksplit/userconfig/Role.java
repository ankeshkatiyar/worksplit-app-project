package com.worksplit.userconfig;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(hidden = true)
    private Integer Id;

    public Integer getId() {
        return Id;
    }

    String name ;

    @ManyToMany(fetch = FetchType.EAGER )
    @ApiModelProperty(hidden = true)
    @JoinTable(name = "permission_role" , joinColumns = {
            @JoinColumn(name = "role_id" , referencedColumnName = "id")} , inverseJoinColumns = {
            @JoinColumn(name = "permission_id" , referencedColumnName = "id")}
    )
    List<Permission> permissions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(name, role.name) &&
                Objects.equals(permissions, role.permissions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, permissions);
    }
}
