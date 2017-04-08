import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FirstFailingVersionTest {

    @Test
    public void caseOne() {
        IsFailingVersion ibv = n -> n>=8;
        assertThat(FirstFailingVersion.firstBadVersion(10, ibv), is(8L));
    }

    @Test
    public void caseTwo() {
        IsFailingVersion ibv = n -> n>=14;
        assertThat(FirstFailingVersion.firstBadVersion(16, ibv), is(14L));
    }

    @Test
    public void caseThree() {
        IsFailingVersion ibv = n -> n>=7830201;
        assertThat(FirstFailingVersion.firstBadVersion(9000000, ibv), is(7830201L));
    }

    @Test
    public void caseFour() {
        IsFailingVersion ibv = n -> n>=8993820103L;
        assertThat(FirstFailingVersion.firstBadVersion(10099828403L, ibv), is(8993820103L));
    }

    @Test
    public void caseFive() {
        IsFailingVersion ibv = n -> n>=89938201403L;
        assertThat(FirstFailingVersion.firstBadVersion(100994828403L, ibv), is(89938201403L));
    }

    @Test
    public void caseSix() {
        IsFailingVersion ibv = n -> n>=932L;
        assertThat(FirstFailingVersion.firstBadVersion(100994828403L, ibv), is(932L));
    }
}
