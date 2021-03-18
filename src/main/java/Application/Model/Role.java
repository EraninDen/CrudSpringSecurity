package Application.Model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roless")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role")
    private String role;

    @ManyToMany(mappedBy = "roleSet", fetch = FetchType.EAGER)
    Set<MyUser> myUserSet;

    public Long getId() {
        return id;
    }

    public Role() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<MyUser> getUserSet() {
        return myUserSet;
    }

    public void setUserSet(Set<MyUser> myUserSet) {
        this.myUserSet = myUserSet;
    }

    @Override
    public String getAuthority() {
        return role;
    }
}
