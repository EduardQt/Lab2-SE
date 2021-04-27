package se.hkr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestATM {

    private MockAuthProvider authProvider;
    private MockBalanceProvider balanceProvider;

    @BeforeEach
    public void setUp() throws Exception {
        this.authProvider = new MockAuthProvider("spreed", "123");
        this.balanceProvider = new MockBalanceProvider(1);
    }

    @Test
    public void testAuth() {
        int id = this.authProvider.login("spreed", "123");

        assert id != -1;
    }

    @Test
    public void testBalance() {
        int balance = this.balanceProvider.provideBalance(1);

        assert balance != 0;
    }

}
