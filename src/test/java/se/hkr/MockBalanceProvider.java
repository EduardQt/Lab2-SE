package se.hkr;

public class MockBalanceProvider {

    private final int correctId;

    public MockBalanceProvider(int correctId) {
        this.correctId = correctId;
    }

    public int provideBalance(int userId) {
        if (userId == this.correctId) return 150;

        return 0;
    }

}
