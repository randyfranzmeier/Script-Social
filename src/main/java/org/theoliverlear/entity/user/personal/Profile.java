package org.theoliverlear.entity.user.personal;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.theoliverlear.entity.user.User;

@Getter
@Setter
@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    private Long id;
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    User user;
    boolean isPublic;
    boolean displayProfileIntention;
    boolean displayEmploymentStatus;
    boolean displayInterests;
    public Profile() {
        this.isPublic = false;
        this.displayProfileIntention = false;
        this.displayEmploymentStatus = false;
        this.displayInterests = false;
        this.user = new User();
    }
    public Profile(User user) {
        this.isPublic = false;
        this.displayProfileIntention = false;
        this.displayEmploymentStatus = false;
        this.displayInterests = false;
        this.user = user;
    }
    public Profile(User user, boolean isPublic, boolean displayProfileIntention, boolean displayEmploymentStatus, boolean displayInterests) {
        this.isPublic = isPublic;
        this.displayProfileIntention = displayProfileIntention;
        this.displayEmploymentStatus = displayEmploymentStatus;
        this.displayInterests = displayInterests;
        this.user = user;
    }
}
