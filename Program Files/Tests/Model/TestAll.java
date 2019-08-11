package Model;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BotPlayerTest.class,
        CardTest.class,
        DealerTest.class,
        DeckTest.class,
        HandTest.class,
        HandEvaluatorTest.class,
        PlayerTest.class,
        TableDataTest.class
})

public class TestAll {

}