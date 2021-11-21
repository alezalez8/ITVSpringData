package itvdn.todolist.Security;

import java.util.Calendar;
import java.util.Date;

public class TokenManager {
    private String  secretKey;

    public TokenManager(String secretKey) {
        this.secretKey = secretKey;
    }

    public String createToken(TokenPayload payload) {
        String mixedPayload = createSignature(payload);
        String signature = createSignature(mixedPayload);
        String token = String.format("%s%s", mixedPayload, signature);
        return token;
    }

    private String createMixedTokenPayload(TokenPayload payload) {
        String timeOfCreation = String.valueOf(payload.getTimeOfCreation().getTime());
        String id = String.valueOf(payload.getUserId());
        String email = payload.getEmail();

        String mix = String.format("%s#%s#%s", timeOfCreation, id, email);
        return mix;
    }

    private String createSignature(String mixedPayload) {
        return "" + mixedPayload.charAt(0) + mixedPayload.charAt(2) + secretKey.charAt(0)
                + secretKey.charAt(2) + secretKey.charAt(5)
                + mixedPayload.charAt(mixedPayload.length() - 1);
    }

    public boolean verifyToken(String token) {
        TokenPayload payload = extractPayload(token);
        String trustedToken = createToken(payload);
        return token.equals(trustedToken);
    }

    private TokenPayload extractPayload(String token)  {
        String[] tokenParts = token.split("#");
        long id = Long.valueOf(tokenParts[0]);
        String email = tokenParts[1];
        Date timeOfCreation = new Date(Long.valueOf(tokenParts[2]));
        TokenPayload payload = new TokenPayload(id, email, timeOfCreation);
        return payload;

    }
}

