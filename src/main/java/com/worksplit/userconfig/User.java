package com.worksplit.userconfig;

import com.worksplit.utils.EmailValidator;
import com.worksplit.utils.MobileNumberValidator;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User implements AppUserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(hidden = true)
    private Integer Id;

    public Integer getId() {
        return Id;
    }

    @Size(min = 4, max = 30)
    @NotNull
    private String username;

    @Size(min = 8 , max = 100)
    @NotNull
    private String password;

    @NotNull
    @NotEmpty
    private String name;
    @NotNull
   // @EmailValidator(message = "Provide a valid email address")
    private String email;

    @Column(name = "account_expired")
    private boolean accountNotExpired;

    @Column(name = "credentials_expired")
    private boolean credentialsNotExpired;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "account_locked")
    private  boolean accountNotLocked;

    @MobileNumberValidator(message = "Mobile number is not valid")
    private String  mob;

    private String device;

    @Column(name = "created_on")
    @CreationTimestamp
    @ApiModelProperty(hidden = true)
    private Timestamp createdOn;


    @ManyToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
            @JoinTable(name = "role_user" , joinColumns = {
                    @JoinColumn(name = "user_id" , referencedColumnName = "id")} , inverseJoinColumns = {
                    @JoinColumn(name = "role_id" , referencedColumnName = "id")
            })
    List<Role> roles;


    @Override
    @ApiModelProperty(hidden = true)
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
            role.getPermissions().forEach(permission -> {
                authorities.add(new SimpleGrantedAuthority(permission.getName()));
            });
        });
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !accountNotExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !accountNotLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !credentialsNotExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public List<Role> getRoles() {
        return roles;
    }

    @Override
    public String getMob() {
        return mob;
    }

    @Override
    public Timestamp getCreatedOn() {
        return createdOn;
    }

    @Override
    public String getDevice() {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
