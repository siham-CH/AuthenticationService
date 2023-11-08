package or.topguns.AuthenticationService.AuthenticationService.User;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;

import java.util.Set;
import java.util.stream.Collectors;
import or.topguns.AuthenticationService.AuthenticationService.User.Permission;
import static or.topguns.AuthenticationService.AuthenticationService.User.Permission.*;


@RequiredArgsConstructor
public enum Role {
    USER(Collections.emptySet()),
    ADMIN(Set.of(
            ADMIN_READ,
            ADMIN_CREATE,
            ADMIN_UPDATE,
            ADMIN_DELETE,
            CLIENT_READ,
            CLIENT_CREATE,
            CLIENT_UPDATE,
            CLIENT_DELETE
    )),
    CLIENT(Set.of(
          CLIENT_READ,
          CLIENT_CREATE,
          CLIENT_UPDATE,
          CLIENT_DELETE
          ));
    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities(){
        var authorities=getPermissions()
                .stream()
                .map(permission ->new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("Role_"+ this.name()));
        return authorities;


    }
}
