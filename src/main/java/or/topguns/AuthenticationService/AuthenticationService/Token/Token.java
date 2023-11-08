package or.topguns.AuthenticationService.AuthenticationService.Token;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import or.topguns.AuthenticationService.AuthenticationService.User.User;
import org.springframework.data.annotation.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Token {
    @Id
    @GeneratedValue
    public Integer tokenId;
    @Column(unique = true)
    public String token;
    public boolean revoked;
    public boolean expired;
    @Enumerated(EnumType.STRING)
    public TokenType tokenType=TokenType.BEARER;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User user;





}
